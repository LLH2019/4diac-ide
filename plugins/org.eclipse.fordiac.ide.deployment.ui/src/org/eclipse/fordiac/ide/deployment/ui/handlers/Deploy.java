/*******************************************************************************
 * Copyright (c) 2018 Johannes Kepler University
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.deployment.ui.handlers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.deployment.DeploymentCoordinator;
import org.eclipse.fordiac.ide.model.libraryElement.AutomationSystem;
import org.eclipse.fordiac.ide.model.libraryElement.Device;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.libraryElement.SystemConfiguration;
import org.eclipse.fordiac.ide.systemmanagement.SystemManager;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.ISources;
import org.eclipse.ui.handlers.HandlerUtil;

public class Deploy extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final Collection<EObject> selected = getDeployableObjects(HandlerUtil.getCurrentSelection(event));
		if (!selected.isEmpty()) {
			DeploymentCoordinator.INSTANCE.performDeployment(selected.toArray(new EObject[selected.size()]));
		}
		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean needToAdd = false;
		final Object selection = HandlerUtil.getVariable(evaluationContext, ISources.ACTIVE_CURRENT_SELECTION_NAME);
		if (selection instanceof ISelection) {
			needToAdd = !getDeployableObjects((ISelection) selection).isEmpty();
		}
		setBaseEnabled(needToAdd);
	}

	private static Collection<EObject> getDeployableObjects(final ISelection selection) {
		final Set<EObject> retVal = new HashSet<>();
		if (selection instanceof StructuredSelection) {
			for (final Object selectedObject : ((StructuredSelection) selection).toArray()) {
				if (selectedObject instanceof EObject) {
					addEObject((EObject) selectedObject, retVal);
				} else if (selectedObject instanceof EditPart
						&& ((EditPart) selectedObject).getModel() instanceof EObject) {
					addEObject((EObject) ((EditPart) selectedObject).getModel(), retVal);
				} else if (SystemManager.isSystemFile(selectedObject)) {
					addEObject(SystemManager.INSTANCE.getSystem((IFile) selectedObject), retVal);
				}
			}
		}
		return retVal;
	}

	private static void addEObject(final EObject object, final Set<EObject> retVal) {
		if (object instanceof AutomationSystem) {
			for (final Device dev : ((AutomationSystem) object).getSystemConfiguration().getDevices()) {
				addDeviceContent(dev, retVal);
			}
		} else if (object instanceof SystemConfiguration) {
			for (final Device dev : ((SystemConfiguration) object).getDevices()) {
				addDeviceContent(dev, retVal);
			}
		} else if (object instanceof Device) {
			addDeviceContent((Device) object, retVal);
		} else if (object instanceof Resource) {
			retVal.add(object);
		}
	}

	private static void addDeviceContent(final Device dev, final Set<EObject> retVal) {
		retVal.add(dev);
		for (final Resource res : dev.getResource()) {
			retVal.add(res);
		}
	}

}
