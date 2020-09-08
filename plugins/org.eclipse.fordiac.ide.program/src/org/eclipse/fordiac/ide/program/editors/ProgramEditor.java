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
package org.eclipse.fordiac.ide.program.editors;

import javax.xml.stream.XMLStreamException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.fordiac.ide.application.editors.FBNetworkEditor;
import org.eclipse.fordiac.ide.application.editors.FBTypePaletteViewerProvider;
import org.eclipse.fordiac.ide.model.Palette.Palette;
import org.eclipse.fordiac.ide.model.dataexport.ProgramExporter;
import org.eclipse.fordiac.ide.model.dataimport.ProgramImporter;
import org.eclipse.fordiac.ide.model.iec61131.Program;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.typelibrary.TypeLibrary;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.FileEditorInput;

public class ProgramEditor extends FBNetworkEditor {

	private Program program;

	private IFile getProgramFile() {
		return ((FileEditorInput) getEditorInput()).getFile();
	}

	private static Program parseProgram(IFile programName) {

		ProgramImporter importer = new ProgramImporter(programName);
		importer.loadElement();
		return importer.getElement();
	}

	@Override
	protected IProject getProject() {
		return getProgramFile().getProject();
	}

	@Override
	protected EditPartFactory getEditPartFactory() {
		return new IEC61131EditPartFactory(this);
	}

	@Override
	protected Palette getPalette() {
		return TypeLibrary.getTypeLibrary(getProgramFile().getProject()).getBlockTypeLib();
	}

	@Override
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new FBTypePaletteViewerProvider(getProgramFile().getProject(), getEditDomain(), getPaletteNavigatorID());
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		getCommandStack().markSaveLocation();
		if (program.getInterfaceList() == null) {
			program.setInterfaceList(LibraryElementFactory.eINSTANCE.createInterfaceList());
		}
		ProgramExporter exporter = new ProgramExporter(program);
		try {
			exporter.saveProgram(getProgramFile());
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		firePropertyChange(IEditorPart.PROP_DIRTY);
	}

	@Override
	protected void setModel(final IEditorInput input) {

		/*
		 * Editor ist file editor input? Wenn ja, dann (siehe type editor init) file
		 * holen und parsen (eigener XML Parser extend FBTypeParser Adapter und CFB
		 * Parser) -> bekommst ein Model (Program Element) -> speichern in member
		 *
		 */

		if (input instanceof FileEditorInput) {
			IFile fbTypeFile = ((FileEditorInput) input).getFile();
			if (!fbTypeFile.exists()) {
				// throw new PartInitException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				// "File does not exist!"));
			}
			program = parseProgram(fbTypeFile);
			if (null != program) {
				setModel(program.getFbNetwork());
			}
		}

		setEditDomain(new DefaultEditDomain(this));
		getEditDomain().setDefaultTool(createDefaultTool());
		getEditDomain().setActiveTool(getEditDomain().getDefaultTool());
		getEditDomain().setCommandStack(new CommandStack());
	}
}
