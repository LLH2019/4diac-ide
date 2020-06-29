/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University, Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Daniel Lindhuber
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.fordiac.ide.elk.handlers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.fordiac.ide.application.editparts.SubAppInternalInterfaceEditPart;
import org.eclipse.fordiac.ide.application.editparts.UISubAppNetworkEditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class ResetInterfacesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		GraphicalViewer viewer = editor.getAdapter(GraphicalViewer.class);

		if (viewer != null) {
			Set<SubAppInternalInterfaceEditPart> interfaces = getEditParts(viewer);
			if (interfaces.isEmpty()) {
				return null;
			}
			UISubAppNetworkEditPart parent = getParent(interfaces.iterator().next());
			if (parent == null) {
				return null;
			}
			for (SubAppInternalInterfaceEditPart part : interfaces) {
				parent.removeChildVisualInterfaceElement(part);
				parent.addChildVisualInterfaceElement(part);
			}
		}

		return null;
	}

	private UISubAppNetworkEditPart getParent(SubAppInternalInterfaceEditPart part) {
		if (part.getParent() instanceof UISubAppNetworkEditPart) {
			return (UISubAppNetworkEditPart) part.getParent();
		}
		return null;
	}

	private Set<SubAppInternalInterfaceEditPart> getEditParts(GraphicalViewer viewer) {
		@SuppressWarnings("unchecked")
		Map<Object, Object> editPartSet = viewer.getEditPartRegistry();
		Set<SubAppInternalInterfaceEditPart> interfaces = new HashSet<>();
		for (Object part : editPartSet.values()) {
			if (part instanceof SubAppInternalInterfaceEditPart) {
				SubAppInternalInterfaceEditPart elem = (SubAppInternalInterfaceEditPart) part;
				if (!elem.getSourceConnections().isEmpty() || !elem.getTargetConnections().isEmpty()) {
					interfaces.add(elem);
				}
			}
		}
		return interfaces;
	}

}