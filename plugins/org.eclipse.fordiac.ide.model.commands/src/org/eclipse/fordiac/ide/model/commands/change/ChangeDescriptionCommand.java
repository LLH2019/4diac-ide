/*******************************************************************************
 * Copyright (c) 2012 fortiss GmbH
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
package org.eclipse.fordiac.ide.model.commands.change;

import org.eclipse.fordiac.ide.model.libraryElement.LibraryElement;

/**
 * The Class ChangeDescriptionCommand.
 */
public class ChangeDescriptionCommand extends ChangeIdentificationCommand {

	/** The new Description value. */
	private final String newDescription;

	/** The old Description value. */
	private String oldDescription;

	public ChangeDescriptionCommand(LibraryElement type, final String newDescription) {
		super(type);
		this.newDescription = (null == newDescription) ? "" : newDescription; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		oldDescription = getIdentification().getDescription();
		redo();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		getIdentification().setDescription(oldDescription);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		getIdentification().setDescription(newDescription);
	}

}
