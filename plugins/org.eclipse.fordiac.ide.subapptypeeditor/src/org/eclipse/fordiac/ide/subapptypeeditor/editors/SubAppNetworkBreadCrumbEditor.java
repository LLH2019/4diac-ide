/*******************************************************************************
 * Copyright (c) 2020 Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial implementation and/or documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.subapptypeeditor.editors;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.fordiac.ide.application.editors.SubApplicationEditorInput;
import org.eclipse.fordiac.ide.fbtypeeditor.editors.IFBTEditorPart;
import org.eclipse.fordiac.ide.fbtypeeditor.network.viewer.CompositeAndSubAppInstanceViewerInput;
import org.eclipse.fordiac.ide.fbtypeeditor.network.viewer.CompositeInstanceViewer;
import org.eclipse.fordiac.ide.model.helpers.FordiacMarkerHelper;
import org.eclipse.fordiac.ide.model.libraryElement.CompositeFBType;
import org.eclipse.fordiac.ide.model.libraryElement.FB;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.fordiac.ide.model.libraryElement.SubAppType;
import org.eclipse.fordiac.ide.model.ui.editors.AbstractBreadCrumbEditor;
import org.eclipse.fordiac.ide.model.ui.editors.BreadcrumbUtil;
import org.eclipse.fordiac.ide.subapptypeeditor.Activator;
import org.eclipse.fordiac.ide.subapptypeeditor.providers.TypedSubappProviderAdapterFactory;
import org.eclipse.fordiac.ide.subapptypeeditor.viewer.SubappInstanceViewer;
import org.eclipse.fordiac.ide.typemanagement.FBTypeEditorInput;
import org.eclipse.fordiac.ide.typemanagement.navigator.FBTypeLabelProvider;
import org.eclipse.fordiac.ide.ui.imageprovider.FordiacImage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.MultiPageEditorSite;

public class SubAppNetworkBreadCrumbEditor extends AbstractBreadCrumbEditor implements IFBTEditorPart {

	private CommandStack commandStack;

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		if (!(input instanceof FBTypeEditorInput)) {
			throw new IllegalArgumentException("SubAppNetworkBreadCrumbEditor is only suitable for FBTypeEditorInputs");
		}

		IEditorSite siteToUse = site;
		if (siteToUse instanceof MultiPageEditorSite) {
			siteToUse = (IEditorSite) ((MultiPageEditorSite) siteToUse).getMultiPageEditor().getSite();
		}

		super.init(siteToUse, input);

		setTitleImage(FordiacImage.ICON_FB_NETWORK.getImage());
		setPartName("FB Network");
	}

	@Override
	public FBTypeEditorInput getEditorInput() {
		return (FBTypeEditorInput)super.getEditorInput();
	}

	private SubAppType getSubAppType (){
		return (SubAppType) getEditorInput().getContent();
	}

	@Override
	protected Composite createPageContainer(final Composite parent) {
		final Composite pageContainer = new Composite(parent, SWT.NONE);
		pageContainer.setLayoutData(new GridData(GridData.FILL_BOTH));
		return pageContainer;
	}

	@Override
	protected void createPages() {
		try {
			final TypedSubAppNetworkEditor initialEditor = new TypedSubAppNetworkEditor();
			initialEditor.setCommonCommandStack(getCommandStack());
			final int pagenum = addPage(initialEditor, getEditorInput());
			getModelToEditorNumMapping().put(getSubAppType(), pagenum); // need to use the file as reference as
			// this is
			// provided by the content providers
		} catch (final PartInitException e) {
			Activator.getDefault().logError(e.getMessage(), e);
		}
	}

	@Override
	protected EditorPart createEditorPart(final Object model) {
		if (model instanceof SubApp) {
			if (((SubApp) model).getType() != null) {
				return new SubappInstanceViewer();
			}
			final UnTypedSubAppNetworkEditor editor = new UnTypedSubAppNetworkEditor();
			editor.setCommonCommandStack(getCommandStack());
			editor.setTypeLib(getEditorInput().getPaletteEntry().getTypeLibrary());
			return editor;
		}

		if (model instanceof FB && ((FB) model).getType() instanceof CompositeFBType) {
			return new CompositeInstanceViewer();
		}

		return null;
	}

	@Override
	protected IEditorInput createEditorInput(final Object model) {
		if (model instanceof SubApp) {
			if (((SubApp) model).getType() != null) {
				return createSubappInstanceViewerInput(model);
			}
			return new SubApplicationEditorInput((SubApp) model);
		}

		if (model instanceof FB && ((FB) model).getType() instanceof CompositeFBType) {
			return createCompositeInstanceViewerInput(model);
		}
		return null;
	}

	private static IEditorInput createSubappInstanceViewerInput(final Object model) {
		final EditPart createEditPart = new SubappInstanceViewer().getEditPartFactory().createEditPart(null, model);
		return new CompositeAndSubAppInstanceViewerInput(createEditPart, model,
				((FBNetworkElement) model).getType().getName());

	}

	private static IEditorInput createCompositeInstanceViewerInput(final Object model) {
		final EditPart createEditPart = new CompositeInstanceViewer().getEditPartFactory().createEditPart(null, model);
		return new CompositeAndSubAppInstanceViewerInput(createEditPart, model,
				((FBNetworkElement) model).getType().getName());
	}

	@Override
	protected AdapterFactoryContentProvider createBreadcrumbContentProvider() {
		return new AdapterFactoryContentProvider(new TypedSubappProviderAdapterFactory());
	}

	@Override
	protected AdapterFactoryLabelProvider createBreadcrumbLabelProvider() {
		return new FBTypeLabelProvider();
	}

	@Override
	protected Object getInitialModel(final String itemPath) {
		// FIXME implement path analysis for typed subapps
		return getSubAppType();
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		// currently nothing needs to be done here
	}


	@Override
	public void doSaveAs() {
		// currently not allowed
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}


	@Override
	public CommandStack getCommandStack() {
		return commandStack;
	}

	@Override
	public String getContributorId() {
		return "property.contributor.fb"; //$NON-NLS-1$
	}

	@Override
	protected void gotoFBNetworkElement(final Object object) {
		// TODO implement fb search and select
	}


	@Override
	public void selectionChanged(final IWorkbenchPart part, final ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean outlineSelectionChanged(Object selectedElement) {
		if ((selectedElement instanceof EObject)
				&& (EcoreUtil.isAncestor(getSubAppType().getFBNetwork(), (EObject) selectedElement))) {
			// an selected element is only valid if it is a child of the FBNetwork of the subapp or the fbnetwork
			if (selectedElement instanceof FBNetwork) {
				selectedElement = ((FBNetwork) selectedElement).eContainer();
			}
			if ((selectedElement instanceof FBNetworkElement) || (selectedElement instanceof SubAppType)) {
				EObject refElement = null;
				if (selectedElement instanceof FB) {
					refElement = (FB) selectedElement;
					selectedElement = refElement.eContainer().eContainer();
				}
				getBreadcrumb().setInput(selectedElement);
				if (null != refElement) {
					BreadcrumbUtil.selectElement(refElement, getActiveEditor());
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public void setCommonCommandStack(final CommandStack commandStack) {
		this.commandStack = commandStack;
	}

	@Override
	public boolean isMarkerTarget(final IMarker marker) {
		try {
			return FordiacMarkerHelper.markerTargetsFBNetworkElement(marker.getAttributes());
		} catch (final CoreException e) {
			Activator.getDefault().logError("Could not get marker attributes", e); //$NON-NLS-1$
		}
		return false;
	}

}
