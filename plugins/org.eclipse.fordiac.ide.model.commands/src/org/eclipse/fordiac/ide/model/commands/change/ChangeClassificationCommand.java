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
 * The Class ChangeCommentCommand.
 */
public class ChangeClassificationCommand extends ChangeIdentificationCommand {

	/** The new classification value. */
	private final String newClassification;

	/** The old classification value. */
	private String oldClassification;

	public ChangeClassificationCommand(LibraryElement type, final String newClassification) {
		super(type);
		this.newClassification = (null == newClassification) ? "" : newClassification; //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		oldClassification = getIdentification().getClassification();
		redo();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		getIdentification().setClassification(oldClassification);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		getIdentification().setClassification(newClassification);
	}

}
