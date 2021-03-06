/*******************************************************************************
 * Copyright (c) 2008, 2009, 2014, 2016, 2017 Profactor GmbH, fortiss GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl, Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.application;

import org.eclipse.fordiac.ide.ui.Abstract4DIACUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * This class is the main class for the org.eclipse.fordiac.ide.application
 * plugin. It coordinates changes in data in different views. (e.g. changes in
 * Workspace)
 *
 */
public class ApplicationPlugin extends Abstract4DIACUIPlugin {
	public static final String PLUGIN_ID = "org.eclipse.fordiac.ide.application"; //$NON-NLS-1$
	// The shared instance.
	private static Abstract4DIACUIPlugin plugin;

	public static Abstract4DIACUIPlugin getDefault() {
		return plugin;
	}

	/**
	 * This method is called upon plug-in activation.
	 *
	 * @param context the context
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		setPlugin(this);
	}

	/**
	 * This method is called when the plug-in is stopped.
	 *
	 * @param context the context
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		super.stop(context);
		setPlugin(null);
	}

	private static synchronized void setPlugin(ApplicationPlugin newPlugin) {
		plugin = newPlugin;
	}

}
