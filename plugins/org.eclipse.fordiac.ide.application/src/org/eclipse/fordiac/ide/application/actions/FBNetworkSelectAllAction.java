/*******************************************************************************
 * Copyright (c) 2012, 2013, 2017 TU Wien ACIN, fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl, Filip Andren
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.fordiac.ide.application.editparts.AbstractFBNElementEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SelectAllAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

public class FBNetworkSelectAllAction extends SelectAllAction {
	private IWorkbenchPart part;

	public FBNetworkSelectAllAction(IWorkbenchPart part) {
		super(part);
		this.part = part;
	}

	@Override
	public void run() {
		GraphicalViewer viewer = part.getAdapter(GraphicalViewer.class);
		if (null != viewer) {
			viewer.setSelection(new StructuredSelection(getSelectableEditParts(viewer)));
		}
	}

	private static List<EditPart> getSelectableEditParts(GraphicalViewer viewer) {
		List<EditPart> selectableChildren = new ArrayList<>();
		List<?> children = viewer.getContents().getChildren();

		for (Object child : children) {
			if (child instanceof AbstractFBNElementEditPart) {
				EditPart childPart = (EditPart) child;
				if (childPart.isSelectable()) {
					selectableChildren.add(childPart);
					addConnectionsTo(selectableChildren, childPart);
				}
			}
		}
		return Collections.unmodifiableList(selectableChildren);
	}

	private static void addConnectionsTo(List<EditPart> selectableChildren, EditPart child) {
		// the editparts are in charge of managing the connections if we take all source
		// connections
		// from one edit part we should get all connections in the end.

		List<?> elementChildren = child.getChildren();
		for (Object elementChild : elementChildren) {
			if (elementChild instanceof AbstractGraphicalEditPart) {
				@SuppressWarnings("unchecked") // GEF method returns child edit parts
				List<EditPart> connections = ((AbstractGraphicalEditPart) elementChild).getSourceConnections();
				connections.stream().filter(EditPart::isSelectable).forEach(selectableChildren::add);
			}
		}
	}

}
