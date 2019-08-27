/*******************************************************************************
 * Copyright (c) 2008, 2014 Profactor GmbH, fortiss GmbH
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
package org.eclipse.fordiac.ide.ui;

import org.eclipse.fordiac.ide.ui.preferences.PreferenceConstants;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class UIPlugin extends Abstract4DIACUIPlugin {

	// The shared instance.
	private static UIPlugin plugin;

	/**
	 * The constructor.
	 */
	public UIPlugin() {
		//empty constructor
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
		getPreferenceStore().setValue(PreferenceConstants.P_HIDE_EVENT_CON, false);
		getPreferenceStore().setValue(PreferenceConstants.P_HIDE_DATA_CON, false);
	}

	private static synchronized void setPlugin(UIPlugin uiPlugin) {
		plugin = uiPlugin;
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

	/**
	 * Returns the shared instance.
	 * 
	 * @return the default
	 */
	public static UIPlugin getDefault() {
		return plugin;
	}

}