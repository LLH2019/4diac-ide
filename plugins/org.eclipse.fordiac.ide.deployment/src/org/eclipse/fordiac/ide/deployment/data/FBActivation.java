/*******************************************************************************
 * Copyright (c) 2020 TU Wien/ACIN
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Melik Merkumians - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.fordiac.ide.deployment.data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.FB;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;

class FBActivation {

	private FB functionBlock;
	private List<VarDeclaration> inputVars;

	public FBActivation(FB functionBlock) {
		this.functionBlock = functionBlock;
		inputVars = new ArrayList<>();
		inputVars.addAll(functionBlock.getInterface().getInputVars());

		inputVars.removeIf(element -> element.getInputConnections().isEmpty());

		for (VarDeclaration output : functionBlock.getInterface().getOutputVars()) {
			for (Connection outputConnection : output.getOutputConnections()) {
				if (inputVars.contains(outputConnection.getDestination())) {
					inputVars.remove(outputConnection.getDestination());
				}
			}
		}
	}

	public void checkForInput(FB functionBlock) {
		for (VarDeclaration output : functionBlock.getInterface().getOutputVars()) {
			for (Connection outputConn : output.getOutputConnections()) {
				inputVars.removeIf(element -> element.equals(outputConn.getDestination()));
			}
		}
	}

	public Boolean isFBReady() {
		return inputVars.isEmpty();
	}

	public FB getFunctionBlock() {
		return functionBlock;
	}

}
