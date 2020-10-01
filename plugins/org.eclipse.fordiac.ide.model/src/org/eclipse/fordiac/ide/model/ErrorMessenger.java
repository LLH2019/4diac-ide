/*******************************************************************************
 * Copyright (c) 2020 Primetals Technologies Germany GmbH
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Ernst Blecha - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;

public class ErrorMessenger {

	/**
	 * This method sends an error message to be displayed This can be done from any
	 * plugin, as long as the message gets put on the message bus it will be shown
	 *
	 * @param the actual error message
	 *
	 */
	public static void popUpErrorMessage(final String errorMsg) {
		popUpErrorMessage(errorMsg, "Operation not possible", 1500);
	}

	public static void popUpErrorMessage(final String errorMsg, final String title, final int timeout) {
		Dictionary<String, Object> d = new Hashtable<>();
		d.put("message", errorMsg); //$NON-NLS-1$
		d.put("title", title); //$NON-NLS-1$
		d.put("timeout", timeout); //$NON-NLS-1$
		eventBroker.post(TOPIC_ERRORMESSAGES, d);
	}

	private static final String TOPIC_ERRORMESSAGES = "ORG/ECLIPSE/FORDIAC/IDE/ERRORMESSAGES"; //$NON-NLS-1$

	private static IEventBroker initEventBroker() {
		IEclipseContext eclipseCtx = EclipseContextFactory.getServiceContext(Activator.getContext());
		return (IEventBroker) eclipseCtx.get(IEventBroker.class.getName());
	}

	private static final IEventBroker eventBroker = initEventBroker();

	private ErrorMessenger() {
		throw new UnsupportedOperationException();
	}
}