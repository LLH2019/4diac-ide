/*******************************************************************************
 * Copyright (c) 2008, 2009, 2016, 2017 Profactor GmbH, fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.actions;

import java.util.Iterator;

import org.eclipse.fordiac.ide.application.editparts.AbstractFBNElementEditPart;
import org.eclipse.fordiac.ide.model.commands.change.MapToCommand;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

/**
 * The Class MapAction. Creates a compound command that contains several
 * "MapCommands".
 */
public class MapAction extends SelectionAction {

	/** The resource. */
	private final Resource resource;

	/** The map command. */
	private final CompoundCommand mapCommand = new CompoundCommand();

	/**
	 * The Constructor.
	 *
	 * @param part     the part
	 * @param resource the resource
	 */
	public MapAction(final IWorkbenchPart part, final Resource resource) {
		super(part);
		this.resource = resource;
		setText(resource.getName());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		update();
		for (Iterator<?> iterator = getSelectedObjects().iterator(); iterator.hasNext();) {
			EditPart ep = (EditPart) iterator.next();
			if (ep instanceof AbstractFBNElementEditPart) {
				MapToCommand cmd = new MapToCommand((FBNetworkElement) ep.getModel(), resource);
				if (cmd.canExecute()) {
					mapCommand.add(cmd);
				}
			}
		}
		executeMapToCmds();
	}

	/**
	 * Executes the mapCommand
	 */
	private void executeMapToCmds() {
		if (getCommandStack() != null) {
			getCommandStack().execute(mapCommand);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		return true;
	}

}
