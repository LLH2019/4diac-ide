/*******************************************************************************
 * Copyright (c) 2020 TU Wien
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Melik Merkumians
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.program.editors;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.fordiac.ide.model.Palette.FBTypePaletteEntry;
import org.eclipse.fordiac.ide.model.Palette.PaletteFactory;
import org.eclipse.fordiac.ide.model.dataimport.ProgramImporter;
import org.eclipse.fordiac.ide.model.iec61131.Program;
import org.eclipse.fordiac.ide.model.iec61131.ProgramInstance;
import org.eclipse.fordiac.ide.model.iec61131.iec61131Factory;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibraryTags;
import org.eclipse.fordiac.ide.program.commands.ChangeAssignedProgramCommand;
import org.eclipse.fordiac.ide.resourceediting.editors.ResourceEditorInput;
import org.eclipse.fordiac.ide.systemmanagement.SystemManager;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

public class PLCRessourceEditor extends EditorPart
		implements CommandStackEventListener, ITabbedPropertySheetPageContributor {

	private List<IFile> availableProgramFiles;

	@Override
	public String getContributorId() {
		return "org.eclipse.fordiac.ide.program.editors.PLCRessourceEditor"; //$NON-NLS-1$
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		SystemManager.saveSystem(getSystem());
		getCommandStack().ifPresent(stack -> stack.markSaveLocation());
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	private Resource getResource() {
		if (getEditorInput() instanceof ResourceEditorInput) {
			ResourceEditorInput resInput = (ResourceEditorInput) getEditorInput();
			return resInput.getContent();
		}
		return null;
	}

	private AutomationSystem getSystem() {
		Resource resource = getResource();
		return (null != resource) ? resource.getAutomationSystem() : null;
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		getCommandStack().ifPresent(stack -> stack.addCommandStackEventListener(this));
		if (input instanceof ResourceEditorInput) {
			ResourceEditorInput editorInput = (ResourceEditorInput) input;
			IProject project = editorInput.getContent().getAutomationSystem().getSystemFile().getProject();
			availableProgramFiles = collectProjectIFiles(project);
			setInput(input);
			setSite(site);
		}
	}

	private static List<IFile> collectProjectIFiles(IProject project) {
		List<IFile> files = new ArrayList<>();
		Deque<IResource> candidates = new ArrayDeque<>();

		try {
			candidates.addAll(Arrays.asList(project.members()));
			while (!candidates.isEmpty()) {
				IResource candidate = candidates.pop();
				if ((candidate instanceof IFile) && (TypeLibraryTags.PROGRAM_TYPE_FILE_ENDING
						.equalsIgnoreCase(((IFile) candidate).getFileExtension()))) {
					files.add((IFile) candidate);
				}
				if (candidate instanceof IFolder) {
					candidates.addAll(Arrays.asList(((IFolder) candidate).members()));
				}
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}

		return files;
	}

	@Override
	public boolean isDirty() {
		Optional<CommandStack> stack = getCommandStack();
		return stack.isPresent() && stack.get().isDirty();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		GridLayout layout = new GridLayout(1, false);
		parent.setLayout(layout);
		Label lblSelectProgram = new Label(parent, SWT.NONE);
		lblSelectProgram.setText("Please select a PROGRAM to execute on PLC resource:");

		ListViewer viewer = new ListViewer(parent);
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof IFile) {
					return ((IFile) element).getName().substring(0, ((IFile) element).getName().length() - 4);
				}
				return super.getText(element);
			}
		});

		viewer.setInput(availableProgramFiles);

		Resource resource = getResource();
		FBNetwork network = resource != null ? resource.getFBNetwork() : null;
		EList<FBNetworkElement> elements = network != null ? network.getNetworkElements() : null;
		FBNetworkElement element = (elements == null || elements.isEmpty() ? null : elements.get(0));

		String programTypeName = (element != null ? element.getName() : ""); // Workaround for missing palette entry

		List<IFile> selectedProgram = availableProgramFiles.stream().filter(
				file -> file.getName().substring(0, file.getName().length() - 4).compareTo(programTypeName) == 0)
				.collect(Collectors.toList());

		if (!selectedProgram.isEmpty()) {
			ISelection fileSelection = new StructuredSelection(selectedProgram.get(0));
			viewer.setSelection(fileSelection);
		}

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (!selection.isEmpty()) {
					IFile programFile = (IFile) selection.getFirstElement();

					ProgramInstance instance = iec61131Factory.eINSTANCE.createProgramInstance();
					ProgramImporter importer = new ProgramImporter(programFile);
					importer.loadElement();
					Program program = importer.getElement();

					FBTypePaletteEntry entry = PaletteFactory.eINSTANCE.createFBTypePaletteEntry();
					entry.setType(program);
					entry.setFile(programFile);
					entry.setLastModificationTimestamp(programFile.getModificationStamp());
					entry.setLabel(program.getName());

					instance.setPaletteEntry(entry);
					instance.setInterface(LibraryElementFactory.eINSTANCE.createInterfaceList());
					instance.setName(instance.getTypeName());

					Resource resource = getResource();
					if (null != resource) {
						ChangeAssignedProgramCommand cmd = new ChangeAssignedProgramCommand(resource.getFBNetwork(),
								instance);
						getCommandStack().ifPresent(stack -> stack.execute(cmd));
						firePropertyChange(IEditorPart.PROP_DIRTY);
					}

				}
			}
		});
	}

	private Optional<CommandStack> getCommandStack() {
		AutomationSystem system = getSystem();
		CommandStack stack = (system != null) ? system.getCommandStack() : null;
		return Optional.ofNullable(stack);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stackChanged(CommandStackEvent event) {
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	public void dispose() {
		getCommandStack().ifPresent(stack -> stack.removeCommandStackEventListener(this));
		super.dispose();
	}
}
