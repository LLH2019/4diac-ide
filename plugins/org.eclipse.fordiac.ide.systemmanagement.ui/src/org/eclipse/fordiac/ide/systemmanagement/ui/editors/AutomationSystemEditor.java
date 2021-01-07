/*******************************************************************************
 * Copyright (c) 2020 Primetals Technologies Germany GmbH, Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial implementation and/or documentation
 *               - implemented first version of gotoMarker for FB markers
 *               - extracted breadcrumb based editor to model.ui
 *******************************************************************************/
package org.eclipse.fordiac.ide.systemmanagement.ui.editors;

import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.application.editors.ApplicationEditor;
import org.eclipse.fordiac.ide.application.editors.ApplicationEditorInput;
import org.eclipse.fordiac.ide.application.editors.FBNetworkEditor;
import org.eclipse.fordiac.ide.application.editors.SubAppNetworkEditor;
import org.eclipse.fordiac.ide.application.editors.SubApplicationEditorInput;
import org.eclipse.fordiac.ide.gef.DiagramEditorWithFlyoutPalette;
import org.eclipse.fordiac.ide.gef.DiagramOutlinePage;
import org.eclipse.fordiac.ide.model.libraryElement.Application;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.Device;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.fordiac.ide.model.libraryElement.SystemConfiguration;
import org.eclipse.fordiac.ide.model.ui.editors.AbstractBreadCrumbEditor;
import org.eclipse.fordiac.ide.resourceediting.editors.ResourceDiagramEditor;
import org.eclipse.fordiac.ide.resourceediting.editors.ResourceEditorInput;
import org.eclipse.fordiac.ide.systemconfiguration.editor.SystemConfigurationEditor;
import org.eclipse.fordiac.ide.systemconfiguration.editor.SystemConfigurationEditorInput;
import org.eclipse.fordiac.ide.systemmanagement.SystemManager;
import org.eclipse.fordiac.ide.systemmanagement.ui.Activator;
import org.eclipse.fordiac.ide.systemmanagement.ui.systemexplorer.SystemContentProvider;
import org.eclipse.fordiac.ide.systemmanagement.ui.systemexplorer.SystemLabelProvider;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class AutomationSystemEditor extends AbstractBreadCrumbEditor {

	private AutomationSystem system;

	private DiagramOutlinePage outlinePage;

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		super.init(site, input);
		loadSystem();
	}

	@Override
	public void createPartControl(final Composite parent) {
		super.createPartControl(parent);
		getBreadcrumb().setContentProvider(new SystemContentProvider());
		getBreadcrumb().setLabelProvider(new SystemLabelProvider());
		getBreadcrumb().setInput(system.getSystemFile());
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
			final int pagenum = addPage(new SystemEditor(), getEditorInput());
			getModelToEditorNumMapping().put(system.getSystemFile(), pagenum); // need to use the file as reference as
			// this is
			// provided by the content providers
		} catch (final PartInitException e) {
			Activator.getDefault().logError(e.getMessage(), e);
		}
	}

	private void loadSystem() {
		if (getEditorInput() instanceof FileEditorInput) {
			system = SystemManager.INSTANCE.getSystem(((FileEditorInput) getEditorInput()).getFile());
			if (null != system) {
				getCommandStack().addCommandStackEventListener(this);
				setPartName(system.getName());
			}
		}
	}

	@Override
	protected void pageChange(final int newPageIndex) {
		super.pageChange(newPageIndex);
		if ((-1 != newPageIndex) && (null != outlinePage)) {
			final GraphicalViewer viewer = getActiveEditor().getAdapter(GraphicalViewer.class);
			outlinePage.viewerChanged(viewer);
		}
	}


	@Override
	protected EditorPart createEditorPart(final Object model) {
		if (model instanceof IFile) {
			return new SystemEditor();
		}
		if (model instanceof SubApp) {
			return new SubAppNetworkEditor();
		}
		if (model instanceof Application) {
			return new ApplicationEditor();
		}
		if (model instanceof SystemConfiguration) {
			return new SystemConfigurationEditor();
		}
		if (model instanceof Device) {
			return new SystemConfigurationEditor();
		}
		if (model instanceof Resource) {
			return new ResourceDiagramEditor();
		}

		return null;
	}

	@Override
	protected IEditorInput createEditorInput(final Object model) {
		if (model instanceof IFile) {
			return getEditorInput();
		}
		if (model instanceof SubApp) {
			return new SubApplicationEditorInput((SubApp) model);
		}
		if (model instanceof Application) {
			return new ApplicationEditorInput((Application) model);
		}
		if (model instanceof SystemConfiguration) {
			return new SystemConfigurationEditorInput((SystemConfiguration) model);
		}
		if (model instanceof Device) {
			return new SystemConfigurationEditorInput(((Device) model).getSystemConfiguration());
		}
		if (model instanceof Resource) {
			return new ResourceEditorInput((Resource) model);
		}
		return null;
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		if (null != system) {
			SystemManager.saveSystem(system);
			getCommandStack().markSaveLocation();
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}

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
	public <T> T getAdapter(final Class<T> adapter) {
		if (adapter == IPropertySheetPage.class) {
			return adapter.cast(new TabbedPropertySheetPage(this));
		}
		if (adapter == IContentOutlinePage.class) {
			if (null == outlinePage) {
				outlinePage = new DiagramOutlinePage(getActiveEditor().getAdapter(GraphicalViewer.class));
			}
			return adapter.cast(outlinePage);
		}
		return super.getAdapter(adapter);
	}

	@Override
	public CommandStack getCommandStack() {
		return (null != system) ? system.getCommandStack() : null;
	}
	
	@Override
	public String getContributorId() {
		return DiagramEditorWithFlyoutPalette.PROPERTY_CONTRIBUTOR_ID;
	}

	@Override
	protected void gotoFBNetworkElement(final Object object) {
		final String[] split = ((String) object).split("\\."); //$NON-NLS-1$
		if (split.length >= 2) {
			final EObject targetmodel = getTargetModel(Arrays.copyOf(split, split.length - 1));
			if (null != targetmodel) {
				getBreadcrumb().setInput(targetmodel);
				final FBNetworkEditor fbEditor = getAdapter(FBNetworkEditor.class);
				if (null != fbEditor) {
					final FBNetworkElement elementToSelect = fbEditor.getModel()
							.getElementNamed(split[split.length - 1]);
					fbEditor.selectElement(elementToSelect);
				}
			}
		}
	}

	private EObject getTargetModel(final String[] path) {
		EObject retVal = system.getApplicationNamed(path[0]);
		if (null != retVal) {
			if(path.length > 1) {
				// we are within a subapplication in the application
				retVal = parseSubappPath(((Application) retVal).getFBNetwork(),
						Arrays.copyOfRange(path, 1, path.length));
			}
		} else if (path.length > 2) {
			// we need to have at least a device and a resource in the path
			retVal = system.getDeviceNamed(path[0]);
			if (null != retVal) {
				retVal = ((Device) retVal).getResourceNamed(path[1]);
				if ((null != retVal) && (path.length > 2)) {
					// we are within a subapplication in the resource
					retVal = parseSubappPath(((Resource) retVal).getFBNetwork(),
							Arrays.copyOfRange(path, 2, path.length));
				}
			}
		}
		return retVal;
	}

	private static EObject parseSubappPath(FBNetwork network, final String[] path) {
		EObject retVal = null;
		for (final String element : path) {
			retVal = network.getElementNamed(element);
			if (retVal instanceof SubApp) {
				network = ((SubApp) retVal).getSubAppNetwork();
			} else {
				return null;
			}
		}
		return retVal;
	}

}