/*******************************************************************************
 * Copyright (c) 2013 - 2017 Profactor GmbH, fortiss GmbH
 * 				 2019 Johannes Kepler University
 * 				 2021 Primetals Technologies Austria GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *   Alois Zoitl - copying the FB type to fix issues in monitoring
 *   Michael Oberlehner - extracted from CompositeInstanceViewer
 *******************************************************************************/

package org.eclipse.fordiac.ide.fbtypeeditor.network.viewer;

import java.util.EventObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.application.editparts.FBNetworkRootEditPart;
import org.eclipse.fordiac.ide.gef.DiagramEditor;
import org.eclipse.fordiac.ide.gef.FordiacContextMenuProvider;
import org.eclipse.fordiac.ide.gef.tools.AdvancedPanningSelectionTool;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.CompositeFBType;
import org.eclipse.fordiac.ide.model.libraryElement.FB;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.INamedElement;
import org.eclipse.fordiac.ide.model.libraryElement.InterfaceList;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.fordiac.ide.model.libraryElement.SubAppType;
import org.eclipse.fordiac.ide.util.ColorHelper;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.IEditorInput;

public abstract class AbstractFbNetworkInstanceViewer extends DiagramEditor {
	protected FBNetworkElement fbNetworkElement;
	protected CompositeFBType fbType;
	protected EditPart fbEditPart;

	protected abstract CompositeFBType createFbType(final CompositeFBType type, final InterfaceList interfaceList);


	@Override
	public abstract EditPartFactory getEditPartFactory();

	@Override
	protected void initializeGraphicalViewer() {
		final GraphicalViewer viewer = getGraphicalViewer();
		if (fbType.getFBNetwork() != null) {
			viewer.setContents(getModel());
		}
	}

	@Override
	protected void setModel(final IEditorInput input) {
		setEditDomain(new DefaultEditDomain(this));
		getEditDomain().setDefaultTool(new AdvancedPanningSelectionTool());
		getEditDomain().setActiveTool(getEditDomain().getDefaultTool());

		if (input instanceof CompositeAndSubAppInstanceViewerInput) {
			final CompositeAndSubAppInstanceViewerInput untypedInput = (CompositeAndSubAppInstanceViewerInput) input;
			final Object content = untypedInput.getContent();
			if ((content instanceof SubApp && ((SubApp) content).getType() instanceof SubAppType)
					|| (content instanceof FB) && (((FB) content).getType() instanceof CompositeFBType)) {
				fbNetworkElement = (FBNetworkElement) content;
				final String name = getNameHierarchy();
				setPartName(name);
				// we need to copy the type so that we have an instance specific network
				fbType = createFbType((CompositeFBType) fbNetworkElement.getType(), fbNetworkElement.getInterface());
				fbType.setName(name); // we set the name of the type so internal function blocks can generate their
				// hierarchy name from it
				fbEditPart = untypedInput.getFbEditPart();
				((CompositeAndSubAppInstanceViewerInput) input).setName(name); // the tooltip will show the whole name when
				// hovering
			}
		}
	}

	@Override
	protected ContextMenuProvider getContextMenuProvider(final ScrollingGraphicalViewer viewer,
			final ZoomManager zoomManager) {
		return new FordiacContextMenuProvider(getGraphicalViewer(), zoomManager, getActionRegistry());
	}

	@Override
	protected TransferDropTargetListener createTransferDropTargetListener() {
		//
		return null;
	}

	@Override
	public AutomationSystem getSystem() {
		return null;
	}

	@Override
	public String getFileName() {
		return null;
	}



	@Override
	public FBNetwork getModel() {
		return fbType.getFBNetwork();
	}

	@Override
	public void commandStackChanged(final EventObject event) {
		// nothing to do as its a viewer!
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		// nothing to do as its a viewer!
	}

	protected String getNameHierarchy() {
		// TODO mabye a nice helper function to be put into the fb model
		final StringBuilder retVal = new StringBuilder(fbNetworkElement.getName());
		final EObject cont = fbNetworkElement.eContainer().eContainer();
		if (cont instanceof INamedElement) {
			retVal.insert(0, ((INamedElement) cont).getName() + "."); //$NON-NLS-1$
		}
		return retVal.toString();
	}

	public EditPart getEditPart() {
		return fbEditPart;
	}

	@Override

	protected ScalableFreeformRootEditPart createRootEditPart() {
		return new FBNetworkRootEditPart(getModel(), fbNetworkElement.getPaletteEntry().getPalette(), getSite(),
				getActionRegistry()) {
			@Override
			protected IFigure createFigure() {
				final IFigure viewPort = super.createFigure();
				final IFigure backGround = (IFigure) viewPort.getChildren().get(0);
				final IFigure drawingAreaContainer = (IFigure) backGround.getChildren().get(0);
				final Color backGroundColor = backGround.getBackgroundColor();
				backGround.setBackgroundColor(ColorHelper.lighter(backGroundColor));
				drawingAreaContainer.setBackgroundColor(backGroundColor);
				return viewPort;
			}
		};
	}

}
