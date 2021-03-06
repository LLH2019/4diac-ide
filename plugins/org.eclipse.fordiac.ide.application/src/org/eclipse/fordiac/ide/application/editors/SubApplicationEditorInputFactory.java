/*******************************************************************************
 * Copyright (c) 2013, 2016, 2017 fortiss GmbH
 * 				 2018, 2020 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *               - reworked sub app name storage to contain the full hierarchical
 *   			   name
 *   			 - New Project Explorer layout
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.editors;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.model.libraryElement.Application;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.fordiac.ide.util.AbstractUntypedEditorInputFactory;
import org.eclipse.ui.IMemento;

public class SubApplicationEditorInputFactory extends AbstractUntypedEditorInputFactory {

	/**
	 * Factory id. The workbench plug-in registers a factory by this name with the
	 * "org.eclipse.ui.elementFactories" extension point.
	 */
	private static final String ID_FACTORY = "org.eclipse.fordiac.ide.application.SubApplicationEditorInputFactory"; //$NON-NLS-1$

	/**
	 * Tag for the application name.
	 */
	private static final String TAG_APPLICATION = "APPLICATION"; //$NON-NLS-1$

	/**
	 * Tag for the subapplication name.
	 */
	private static final String TAG_SUB_APPLICATION = "SUB_APPLICATION"; //$NON-NLS-1$

	@Override
	public IAdaptable createElement(IMemento memento) {
		String applicationName = memento.getString(TAG_APPLICATION);
		String subApplicationName = memento.getString(TAG_SUB_APPLICATION);
		if (null != applicationName) {
			AutomationSystem system = loadAutomationSystemName(memento);
			if (null != system) {
				Application application = system.getApplicationNamed(applicationName);
				SubApp subApp = findSubApp(application, subApplicationName);
				if (null != subApp) {
					return new SubApplicationEditorInput(subApp);
				}
			}
		}
		return null;
	}

	/**
	 * Returns the element factory id for this class.
	 *
	 * @return the element factory id
	 */
	public static String getFactoryId() {
		return ID_FACTORY;
	}

	/**
	 * Saves the state of the given file editor input into the given memento.
	 *
	 * @param memento the storage area for element state
	 * @param input   the application editor input
	 */
	public static void saveState(IMemento memento, SubApplicationEditorInput input) {
		Application app = input.getApplication();
		if (null != app) {
			saveAutomationSystem(memento, app.getAutomationSystem());
			memento.putString(TAG_APPLICATION, app.getName());
			memento.putString(TAG_SUB_APPLICATION, createHierarchicalSubAppName(input.getSubApp()));
		}
	}

	private static String createHierarchicalSubAppName(final SubApp subApp) {
		StringBuilder builder = new StringBuilder(subApp.getName());

		EObject runner = subApp.getFbNetwork().eContainer();
		while (runner instanceof SubApp) {
			SubApp parent = (SubApp) runner;
			builder.insert(0, '.');
			builder.insert(0, parent.getName());
			runner = parent.getFbNetwork().eContainer();
		}
		return builder.toString();
	}

	private static SubApp findSubApp(Application application, String subApplicationName) {
		String[] nameList = subApplicationName.split("\\."); //$NON-NLS-1$
		FBNetwork network = application.getFBNetwork();
		SubApp retVal = null;

		for (String name : nameList) {
			retVal = network.getSubAppNamed(name);
			if (null == retVal) {
				break;
			}
			network = retVal.getSubAppNetwork();
		}

		return retVal;
	}

}
