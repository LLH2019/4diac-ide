/*******************************************************************************
 * Copyright (c) 2018 fortiss GmbH, Johannes Kepler University
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.deployment.util;

import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.Device;
import org.eclipse.fordiac.ide.model.libraryElement.Value;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.fordiac.ide.systemmanagement.SystemManager;

public interface DeploymentHelper {

	static String getVariableValue(VarDeclaration varDecl, AutomationSystem system) {
		Value value = varDecl.getValue();
		if (null != value && !value.getValue().isEmpty()) {
			String val = value.getValue();
			if (val.contains("%")) { //$NON-NLS-1$
				String replaced = SystemManager.INSTANCE.getReplacedString(system, val);
				if (replaced != null) {
					val = replaced;
				}
			}
			return val;
		}
		return null;
	}

	static String getMgrID(final Device dev) {
		for (VarDeclaration varDecl : dev.getVarDeclarations()) {
			if (varDecl.getName().equalsIgnoreCase("MGR_ID")) { //$NON-NLS-1$
				String val = DeploymentHelper.getVariableValue(varDecl, dev.getAutomationSystem());
				if (null != val) {
					return val;
				}
			}
		}
		return ""; //$NON-NLS-1$
	}

}
