/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Ernst Blecha, Bianca Wiesmayr
 *      - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Status;
import org.eclipse.fordiac.ide.model.commands.change.ChangeStructCommand;
import org.eclipse.fordiac.ide.model.commands.change.UpdateFBTypeCommand;
import org.eclipse.fordiac.ide.model.data.StructuredType;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.StructManipulator;
import org.eclipse.fordiac.ide.model.typelibrary.DataTypeLibrary;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

public class UpdateFBTypeHandler extends AbstractHandler {

	private final List<FBNetworkElement> selectedNetworkElements = new ArrayList<>();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CompoundCommand cmd = new CompoundCommand();
		CommandStack stack = HandlerUtil.getActiveEditor(event).getAdapter(CommandStack.class);

		for (FBNetworkElement element : selectedNetworkElements) {
			Command updateFBTypeCmd = getUpdateCommand(element);
			if (updateFBTypeCmd.canExecute()) {
				cmd.add(updateFBTypeCmd);
			}
		}
		if (null != stack) {
			stack.execute(cmd);
		}
		return Status.OK_STATUS;
	}

	public static Command getUpdateCommand(FBNetworkElement element) {
		if (element instanceof StructManipulator) {
			StructManipulator mux = (StructManipulator) element;
			DataTypeLibrary lib = mux.getType().getTypeLibrary().getDataTypeLibrary();
			StructuredType updated = (StructuredType) lib.getType(mux.getStructType().getName());
			return new ChangeStructCommand(mux, updated);
		} else {
			return new UpdateFBTypeCommand(element, null);
		}
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		updateSelection(evaluationContext);
		setBaseEnabled(!selectedNetworkElements.isEmpty());
	}

	protected void updateSelection(Object evaluationContext) {
		selectedNetworkElements.clear();
		ISelection selection = (ISelection) HandlerUtil.getVariable(evaluationContext,
				ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (selection instanceof StructuredSelection) {
			for (Object element : ((StructuredSelection) selection).toList()) {
				if (element instanceof EditPart) {
					element = ((EditPart) element).getModel();
				}
				if ((element instanceof FBNetworkElement) && (null != ((FBNetworkElement) element).getType())) {
					selectedNetworkElements.add((FBNetworkElement) element);
				}
			}
		}
	}

}
