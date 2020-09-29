/*******************************************************************************
 * Copyright (c) 2008 - 2016 Profactor GmbH, fortiss GmbH
 *               2020 TU Wien/ACIN
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
 *   Martin Melik Merkumians - added case for PLC resource editor
 *******************************************************************************/
package org.eclipse.fordiac.ide.resourceediting.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.resourceediting.Messages;
import org.eclipse.fordiac.ide.resourceediting.editors.ResourceDiagramEditor;
import org.eclipse.fordiac.ide.resourceediting.editors.ResourceEditorInput;
import org.eclipse.fordiac.ide.ui.imageprovider.FordiacImage;
import org.eclipse.fordiac.ide.util.OpenListener;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * The Class OpenResourceEditorAction.
 */
public class OpenResourceEditorAction extends OpenListener {

	private static final String OPEN_RES_EDITOR_LISTENER_ID = "org.eclipse.fordiac.ide.resourceediting.actions.OpenResourceEditorAction"; //$NON-NLS-1$

	/** The res. */
	private Resource res;

	@Override
	public void run(final IAction action) {
		if (null != res) {
			ResourceEditorInput input = new ResourceEditorInput(res);
			if ("EMB_PLC_RES".equalsIgnoreCase(res.getType().getName())) {
				openEditor(input, "org.eclipse.fordiac.ide.program.editors.PLCRessourceEditor");
			} else {
				openEditor(input, ResourceDiagramEditor.class.getName());
			}
		}
	}

	@Override
	public void selectionChanged(final IAction action, final ISelection selection) {
		res = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSel = (IStructuredSelection) selection;
			if (structuredSel.getFirstElement() instanceof Resource) {
				res = (Resource) structuredSel.getFirstElement();
			}
		}
	}

	@Override
	public String getActionText() {
		return Messages.OpenResourceEditorAction_Name;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return FordiacImage.ICON_RESOURCE.getImageDescriptor();
	}

	@Override
	public Class<? extends EObject> getHandledClass() {
		return Resource.class;
	}

	@Override
	public String getOpenListenerID() {
		return OPEN_RES_EDITOR_LISTENER_ID;
	}

}
