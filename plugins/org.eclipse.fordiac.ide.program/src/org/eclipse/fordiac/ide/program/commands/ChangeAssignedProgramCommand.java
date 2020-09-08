/*******************************************************************************
 * Copyright (c) 2020 TU Wien
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Melik Merkumians
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.program.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.fordiac.ide.model.iec61131.ProgramInstance;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.gef.commands.Command;

public class ChangeAssignedProgramCommand extends Command {

	private ProgramInstance oldProgram;
	private ProgramInstance newProgram;
	private FBNetwork network;

	public ChangeAssignedProgramCommand(final FBNetwork network, ProgramInstance newProgram) {
		super();
		this.newProgram = newProgram;
		this.network = network;
	}

	@Override
	public void execute() {
		EList<FBNetworkElement> elements = network.getNetworkElements();
		FBNetworkElement networkElement = elements.isEmpty() ? null : elements.get(0);
		if (networkElement instanceof ProgramInstance) {
			oldProgram = (ProgramInstance) networkElement;
		} else {
			oldProgram = null;
		}
		setProgram(newProgram);
	}

	private void setProgram(ProgramInstance program) {
		network.getNetworkElements().clear();
		if (null != program) {
			network.getNetworkElements().add(program);
		}
	}

	@Override
	public boolean canExecute() {
		return null != newProgram;
	}

	@Override
	public void undo() {
		setProgram(oldProgram);
	}

	@Override
	public void redo() {
		setProgram(newProgram);
	}

}
