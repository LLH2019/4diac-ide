/*******************************************************************************
 * Copyright (c) 2013, 2017 fortiss GmbH
 * 				 2019 Johannes Kepler University
 *               2021 Primetals Technologies Germany GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl, Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *   Alois Zoitl - Extracted this class from the FBInsertAction
 *   Bianca Wiesmayr - correctly calculate position for inserting
 *   Alois Zoitl - reworked action to always create a new creation command
 *   Bianca Wiesmayr - updated for breadcrumb editor
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.actions;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.fordiac.ide.application.editors.FBNetworkContextMenuProvider;
import org.eclipse.fordiac.ide.model.Palette.FBTypePaletteEntry;
import org.eclipse.fordiac.ide.model.Palette.PaletteEntry;
import org.eclipse.fordiac.ide.model.Palette.SubApplicationTypePaletteEntry;
import org.eclipse.fordiac.ide.model.commands.create.AbstractCreateFBNetworkElementCommand;
import org.eclipse.fordiac.ide.model.commands.create.CreateSubAppInstanceCommand;
import org.eclipse.fordiac.ide.model.commands.create.FBCreateCommand;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.WorkbenchPartAction;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;

public class FBNetworkElementInsertAction extends WorkbenchPartAction {

	private final PaletteEntry paletteEntry;
	private final FBNetwork fbNetwork;

	public FBNetworkElementInsertAction(IWorkbenchPart part, PaletteEntry paletteEntry, FBNetwork fbNetwork) {
		super(part);
		this.paletteEntry = paletteEntry;
		this.fbNetwork = fbNetwork;

		setId(paletteEntry.getFile().getFullPath().toString());
		setText(paletteEntry.getLabel());
	}

	@Override
	protected boolean calculateEnabled() {
		return (null != paletteEntry) && (null != fbNetwork);
	}

	@Override
	public void run() {
		execute(createFBNetworkElementCreateCommand());
	}

	private AbstractCreateFBNetworkElementCommand createFBNetworkElementCreateCommand() {
		final Point pt = getPositionInViewer((IEditorPart) getWorkbenchPart());
		if (paletteEntry instanceof FBTypePaletteEntry) {
			return new FBCreateCommand((FBTypePaletteEntry) paletteEntry, fbNetwork, pt.x, pt.y);
		} else if (paletteEntry instanceof SubApplicationTypePaletteEntry) {
			return new CreateSubAppInstanceCommand((SubApplicationTypePaletteEntry) paletteEntry, fbNetwork, pt.x,
					pt.y);
		}

		return null;
	}

	private static Point getPositionInViewer(IEditorPart editor) {
		final GraphicalViewer viewer = editor.getAdapter(GraphicalViewer.class);
		return ((FBNetworkContextMenuProvider) viewer.getContextMenu()).getTranslatedAndZoomedPoint();
	}
}
