/*******************************************************************************
 * Copyright (c) 2015 - 2017 fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl, Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.systemmanagement.ui.commands;

import org.eclipse.fordiac.ide.application.editors.FBNetworkEditor;
import org.eclipse.fordiac.ide.model.commands.change.UnmapCommand;
import org.eclipse.fordiac.ide.model.libraryElement.Application;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.Mapping;
import org.eclipse.fordiac.ide.systemmanagement.SystemManager;
import org.eclipse.fordiac.ide.ui.editors.EditorUtils;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;

/**
 * The Class NewAppCommand.
 */
public class DeleteApplicationCommand extends Command {

	private Application application;
	private AutomationSystem system;

	// compound command to store all unmapp commands for FBNetwork elements to be
	// unmapped
	private CompoundCommand unmappApplicationElements = new CompoundCommand();

	public DeleteApplicationCommand(Application application) {
		super("Delete Application");
		this.application = application;
		if (null != application) {
			this.system = application.getAutomationSystem();
		}
	}

	@Override
	public boolean canExecute() {
		return ((null != application) && (null != system));
	}

	@Override
	public void execute() {
		getUnmappCommands();
		unmappApplicationElements.execute();
		closeApplicationEditor();
		system.getApplication().remove(application);
		SystemManager.saveSystem(system);
	}

	@Override
	public void redo() {
		unmappApplicationElements.redo();
		system.getApplication().remove(application);
		SystemManager.saveSystem(system);
	}

	@Override
	public void undo() {
		system.getApplication().add(application);
		unmappApplicationElements.undo();
		SystemManager.saveSystem(system);
	}

	private void getUnmappCommands() {
		application.getFBNetwork().getNetworkElements().stream().forEach(element -> {
			Mapping mapping = element.getMapping();
			if (null != mapping) {
				unmappApplicationElements.add(new UnmapCommand(element));
			}
			// TODO model refactoring -if not mapped and subapp check if the internals are
			// mapped and perform this recursivle on the elements
		});
	}

	private void closeApplicationEditor() {
		EditorUtils.closeEditorsFiltered(editor -> ((editor instanceof FBNetworkEditor)
				&& (application.getFBNetwork().equals(((FBNetworkEditor) editor).getModel()))));
	}
}
