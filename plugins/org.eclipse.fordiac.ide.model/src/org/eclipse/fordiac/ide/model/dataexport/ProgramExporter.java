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
package org.eclipse.fordiac.ide.model.dataexport;

import javax.xml.stream.XMLStreamException;

import org.eclipse.core.resources.IFile;
import org.eclipse.fordiac.ide.model.LibraryElementTags;
import org.eclipse.fordiac.ide.model.iec61131.Program;

public class ProgramExporter extends AbstractBlockTypeExporter {

	public ProgramExporter(Program type) {
		super(type);
	}

	public void saveProgram(IFile iFile) throws XMLStreamException {
		String programName = iFile.getName().substring(0, iFile.getName().length() - 4);
		getType().setName(programName);
		createXMLEntries();
		writeToFile(iFile);
	}

	@Override
	protected void createBlockTypeSpecificXMLEntries() throws XMLStreamException {
		new FBNetworkExporter(this).createFBNetworkElement(((Program) getType()).getFbNetwork());
	}

	@Override
	protected String getRootTag() {
		return LibraryElementTags.PROGRAM_TYPE;
	}

}
