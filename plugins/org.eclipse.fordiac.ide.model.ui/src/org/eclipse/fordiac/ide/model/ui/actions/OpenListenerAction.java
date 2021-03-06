/*******************************************************************************
 * Copyright (c) 2008, 2011, 2017 Profactor GmbH, fortiss GmbH,
 * 				 2018 Johannes Kepler University
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
package org.eclipse.fordiac.ide.model.ui.actions;

import org.eclipse.jface.action.Action;

/**
 * A default implementation handling open action for IOpenListener implementers
 */
public class OpenListenerAction extends Action {
	private final IOpenListener openListener;

	public OpenListenerAction(final IOpenListener openListener) {
		this.openListener = openListener;
		setText(openListener.getActionText());
		setImageDescriptor(openListener.getImageDescriptor());
	}

	@Override
	public void run() {
		OpenListenerManager.setDefaultOpenListener(openListener.getHandledClass(), openListener.getOpenListenerID());
		openListener.run(null);
	}

}