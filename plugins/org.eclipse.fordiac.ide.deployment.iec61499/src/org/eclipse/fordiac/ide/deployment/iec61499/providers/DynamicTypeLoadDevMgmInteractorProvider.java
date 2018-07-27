/*******************************************************************************
 * Copyright (c) 2018 Johannes Kepler University
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alois Zoitl - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.deployment.iec61499.providers;

import org.eclipse.fordiac.ide.deployment.AbstractDeviceManagementCommunicationHandler;
import org.eclipse.fordiac.ide.deployment.iec61499.DynamicTypeLoadDeploymentExecutor;
import org.eclipse.fordiac.ide.deployment.interactors.IDeviceManagementInteractor;
import org.eclipse.fordiac.ide.deployment.interactors.IDeviceManagementInteractorProvider;
import org.eclipse.fordiac.ide.model.libraryElement.Device;

public class DynamicTypeLoadDevMgmInteractorProvider implements IDeviceManagementInteractorProvider {
	private static final String PROFILE_NAME = "DynamicTypeLoad"; //$NON-NLS-1$

	@Override
	public boolean supports(final String profile) {
		return getProfileName().equals(profile);
	}

	@Override
	public String getProfileName() {
		return PROFILE_NAME;
	}

	@Override
	public IDeviceManagementInteractor createInteractor(Device dev, AbstractDeviceManagementCommunicationHandler overrideHandler) {
		return new DynamicTypeLoadDeploymentExecutor(dev, overrideHandler);
	}

}