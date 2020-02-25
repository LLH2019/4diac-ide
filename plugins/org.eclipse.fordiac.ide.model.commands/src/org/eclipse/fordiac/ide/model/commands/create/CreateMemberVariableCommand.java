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
 *   Bianca Wiesmayr
 *      - initial implementation and documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.commands.create;

import org.eclipse.emf.common.util.EList;
import org.eclipse.fordiac.ide.model.commands.internal.CreateVariableCommand;
import org.eclipse.fordiac.ide.model.data.DataType;
import org.eclipse.fordiac.ide.model.data.StructuredType;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;

/**
 * Creates a new member variable for a Structured Type
 */
public class CreateMemberVariableCommand extends CreateVariableCommand {

	/**
	 * Instantiates command that creates a new member variable of a StructuredType
	 *
	 * @param dataType the data type
	 * @param struct   the structured type
	 */
	public CreateMemberVariableCommand(final StructuredType struct) {
		super(struct, struct.getMemberVariables().size() - 1, null, null);
	}

	public CreateMemberVariableCommand(final StructuredType struct, int index, String name, DataType dataType) {
		super(struct, index, name, dataType);
	}

	@Override
	protected EList<VarDeclaration> getVariableList() {
		return ((StructuredType) getType()).getMemberVariables();
	}

	@Override
	public String getDefaultVarName() {
		return "MEMBERVAR1"; //$NON-NLS-1$
	}

}