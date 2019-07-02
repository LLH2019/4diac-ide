/*******************************************************************************
 * Copyright (c) 2008, 2014 Profactor GmbH, fortiss GmbH
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Gerhard Ebenhofer, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.ui;

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
		plugin = this;
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
		plugin = null;
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