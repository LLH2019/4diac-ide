/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University, Linz
 *               2021 Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Daniel Lindhuber, Bianca Wiesmayr
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.fordiac.ide.datatypeeditor.editors;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.fordiac.ide.datatypeeditor.Activator;
import org.eclipse.fordiac.ide.datatypeeditor.DataTypeListener;
import org.eclipse.fordiac.ide.datatypeeditor.Messages;
import org.eclipse.fordiac.ide.datatypeeditor.widgets.StructViewingComposite;
import org.eclipse.fordiac.ide.model.data.AnyDerivedType;
import org.eclipse.fordiac.ide.model.data.DataType;
import org.eclipse.fordiac.ide.model.data.StructuredType;
import org.eclipse.fordiac.ide.model.dataexport.DataTypeExporter;
import org.eclipse.fordiac.ide.model.dataimport.DataTypeImporter;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibrary;
import org.eclipse.fordiac.ide.ui.widget.TableWidgetFactory;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackEvent;
import org.eclipse.gef.commands.CommandStackEventListener;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.RedoAction;
import org.eclipse.gef.ui.actions.UndoAction;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.FileStoreEditorInput;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class DataTypeEditor extends EditorPart
implements CommandStackEventListener, ITabbedPropertySheetPageContributor, ISelectionListener {

	private DataType dataType;
	private IFile file;
	private final CommandStack commandStack = new CommandStack();
	private StructViewingComposite editComposite;
	private Composite errorComposite;
	private boolean importFailed;
	private boolean outsideWorkspace;
	private DataTypeListener listener;

	private ActionRegistry actionRegistry;
	private final List<String> selectionActions = new ArrayList<>();
	private final List<String> stackActions = new ArrayList<>();
	private final List<String> propertyActions = new ArrayList<>();

	@Override
	public void stackChanged(final CommandStackEvent event) {
		updateActions(stackActions);
		firePropertyChange(IEditorPart.PROP_DIRTY);
		editComposite.getViewer().refresh();
	}

	@Override
	public String getContributorId() {
		return "org.eclipse.fordiac.ide.datatypeeditor.editors.DataTypeEditor"; //$NON-NLS-1$
	}

	@Override
	public void dispose() {
		getCommandStack().removeCommandStackEventListener(this);
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(this);
		getActionRegistry().dispose();
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(listener);
		super.dispose();
	}

	@Override
	protected void firePropertyChange(final int property) {
		super.firePropertyChange(property);
		updateActions(propertyActions);
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		final DataTypeExporter exporter = new DataTypeExporter((AnyDerivedType) dataType);
		try {
			exporter.saveType(file);
			commandStack.markSaveLocation();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		} catch (final XMLStreamException e) {
			Activator.getDefault().logError(e.getMessage(), e);
			MessageDialog.openError(getSite().getShell().getShell(), Messages.MessageDialogTitle_SaveError,
					Messages.MessageDialogContent_SaveError);
		}
	}

	@Override
	public void doSaveAs() {
		// TODO implement save as new data type method, update isSaveAsAllowed()
		// accordingly
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		importType(input);
		setInput(input);
		setSite(site);
		site.getWorkbenchWindow().getSelectionService().addSelectionListener(this);
		getCommandStack().addCommandStackEventListener(this);
		initializeActionRegistry();
		setActionHandlers(site);
	}

	private void importType(final IEditorInput input) throws PartInitException {

		if (input instanceof FileEditorInput) {
			file = ((FileEditorInput) input).getFile();
		} else if (input instanceof FileStoreEditorInput) {
			// is called when files are opened via File -> Open File
			importFailed = true;
			outsideWorkspace = true;
		}

		try {
			if (null != file) {
				setPartName(getDatatypeNameFromFile(file));
				final DataTypeImporter importer = new DataTypeImporter(file);
				importer.loadElement();
				dataType = importer.getElement();
				listener = new DataTypeListener(file, this);
				final IWorkspace workspace = ResourcesPlugin.getWorkspace();
				workspace.addResourceChangeListener(listener);
			}
		} catch (final Exception e) {
			throw new PartInitException(e.getMessage(), e);
		}
	}

	private static String getDatatypeNameFromFile(IFile file) {
		return file.getName().substring(0, file.getName().lastIndexOf('.'));
	}

	private void setActionHandlers(final IEditorSite site) {
		final ActionRegistry registry = getActionRegistry();
		final IActionBars bars = site.getActionBars();
		String id = ActionFactory.UNDO.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.REDO.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.DELETE.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		bars.updateActionBars();
	}

	@Override
	public boolean isDirty() {
		return getCommandStack().isDirty();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(final Composite parent) {
		if ((dataType instanceof StructuredType) && (!importFailed)) {
			editComposite = new StructViewingComposite(parent, 1, commandStack, (StructuredType) dataType,
					TypeLibrary.getTypeLibrary(file.getProject()).getDataTypeLibrary(), this);
			editComposite.createPartControl(parent);
			TableWidgetFactory.enableCopyPasteCut(this);
		} else if (importFailed) {
			createErrorComposite(parent, Messages.ErrorCompositeMessage);
			if (outsideWorkspace) {
				MessageDialog.openError(getSite().getShell().getShell(),
						Messages.MessageDialogTitle_OutsideWorkspaceError,
						Messages.MessageDialogContent_OutsideWorkspaceError);
			}
		}
	}

	private void createErrorComposite(final Composite parent, final String errorText) {
		errorComposite = new Composite(parent, SWT.NONE);
		errorComposite.setLayout(new GridLayout(1, false));
		final Label label = new Label(errorComposite, SWT.CENTER);
		label.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.HEADER_FONT));
		label.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
		label.setText(errorText);
	}

	@Override
	public void setFocus() {
		if (null == editComposite) {
			errorComposite.setFocus();
		} else {
			editComposite.setFocus();
		}
	}

	public CommandStack getCommandStack() {
		return commandStack;
	}

	@Override
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		if (this.equals(getSite().getPage().getActiveEditor())) {
			updateActions(selectionActions);
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
	}

	private void createActions() {
		final ActionRegistry registry = getActionRegistry();
		IAction action;

		action = new UndoAction(this);
		registry.registerAction(action);
		getStackActions().add(action.getId());

		action = new RedoAction(this);
		registry.registerAction(action);
		getStackActions().add(action.getId());
	}

	@Override
	public <T> T getAdapter(final Class<T> key) {
		if (key == org.eclipse.ui.views.properties.IPropertySheetPage.class) {
			return key.cast(new TabbedPropertySheetPage(this));
		}
		if (key == CommandStack.class) {
			return key.cast(getCommandStack());
		}
		if (key == ActionRegistry.class) {
			return key.cast(getActionRegistry());
		}

		return super.getAdapter(key);
	}

	private List<String> getStackActions() {
		return stackActions;
	}

	private void initializeActionRegistry() {
		createActions();
		updateActions(propertyActions);
		updateActions(stackActions);
	}

	private void updateActions(final List<String> actionIds) {
		final ActionRegistry registry = getActionRegistry();
		actionIds.forEach(id -> {
			final IAction action = registry.getAction(id);
			if (action instanceof UpdateAction) {
				((UpdateAction) action).update();
			}
		});
	}

	private ActionRegistry getActionRegistry() {
		if (null == actionRegistry) {
			actionRegistry = new ActionRegistry();
		}
		return actionRegistry;
	}

	public void updateDataType(IPath path) {
		this.file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		final String name = getDatatypeNameFromFile(file);
		dataType.setName(name);
		setPartName(name);
		setTitle(name);
		setInput(new FileEditorInput(file));
	}

}
