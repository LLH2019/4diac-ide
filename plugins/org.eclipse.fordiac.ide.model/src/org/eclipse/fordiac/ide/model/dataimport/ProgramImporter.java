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
package org.eclipse.fordiac.ide.model.dataimport;

import javax.xml.stream.XMLStreamException;

import org.eclipse.core.resources.IFile;
import org.eclipse.fordiac.ide.model.LibraryElementTags;
import org.eclipse.fordiac.ide.model.dataimport.exceptions.TypeImportException;
import org.eclipse.fordiac.ide.model.iec61131.Program;
import org.eclipse.fordiac.ide.model.iec61131.iec61131Factory;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElement;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;

public class ProgramImporter extends FBTImporter {

	public ProgramImporter(IFile typeFile) {
		super(typeFile);
	}

	@Override
	public LibraryElement createRootModelElement() {
		Program newProgram = iec61131Factory.eINSTANCE.createProgram();
		newProgram.setFbNetwork(LibraryElementFactory.eINSTANCE.createFBNetwork());
		newProgram.setInterfaceList(LibraryElementFactory.eINSTANCE.createInterfaceList());
		return newProgram;
	}

	@Override
	protected String getStartElementName() {
		return LibraryElementTags.PROGRAM_TYPE;
	}

	@Override
	public Program getElement() {
		return (Program) super.getElement();
	}

	@Override
	protected IChildHandler getBaseChildrenHandler() {
		return name -> {
			switch (name) {
			case LibraryElementTags.IDENTIFICATION_ELEMENT:
				parseIdentification(getElement());
				break;
			case LibraryElementTags.VERSION_INFO_ELEMENT:
				parseVersionInfo(getElement());
				break;
			case LibraryElementTags.COMPILER_INFO_ELEMENT:
				parseCompilerInfo(getElement());
				break;
			case LibraryElementTags.INTERFACE_LIST_ELEMENT:
				getElement().setInterfaceList(parseInterfaceList(LibraryElementTags.INTERFACE_LIST_ELEMENT));
				break;
			case LibraryElementTags.FBNETWORK_ELEMENT:
				parseFBNetwork(getElement());
				break;
			case LibraryElementTags.PROGRAM_TYPE:
				parseFBNetwork(getElement());
				break;
			default:
				return false;
			}
			return true;
		};
	}

	private void parseFBNetwork(final Program type) throws TypeImportException, XMLStreamException {
		FBNetwork fbNetwork = LibraryElementFactory.eINSTANCE.createFBNetwork();
		FBNetworkImporter fbnInmporter = new FBNetworkImporter(this, fbNetwork, type.getInterfaceList());
		type.setFbNetwork(fbnInmporter.parseFBNetwork(LibraryElementTags.FBNETWORK_ELEMENT));
	}

}
