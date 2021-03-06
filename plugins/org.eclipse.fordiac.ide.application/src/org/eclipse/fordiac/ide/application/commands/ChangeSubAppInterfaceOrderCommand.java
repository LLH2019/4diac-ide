/*******************************************************************************
 * Copyright (c) 2018 Johannes Kepler University
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.commands;

import org.eclipse.fordiac.ide.model.commands.change.ChangeInterfaceOrderCommand;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;

public class ChangeSubAppInterfaceOrderCommand extends ChangeInterfaceOrderCommand {

	private ChangeInterfaceOrderCommand mirroredElement = null;

	public ChangeSubAppInterfaceOrderCommand(IInterfaceElement selection, boolean moveUp) {
		super(selection, moveUp);

		if (selection.getFBNetworkElement().isMapped()) {
			mirroredElement = new ChangeInterfaceOrderCommand(
					selection.getFBNetworkElement().getOpposite().getInterfaceElement(selection.getName()), moveUp);
		}
	}

	@Override
	public void execute() {
		super.execute();
		if (null != mirroredElement) {
			mirroredElement.execute();
		}
	}

	@Override
	public void redo() {
		super.redo();
		if (null != mirroredElement) {
			mirroredElement.redo();
		}
	}

	@Override
	public void undo() {
		super.undo();
		if (null != mirroredElement) {
			mirroredElement.undo();
		}
	}

}
