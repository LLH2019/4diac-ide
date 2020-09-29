/*******************************************************************************
 * Copyright (c) 2008 - 2018 Profactor GmbH, fortiss GmbH,
 * 							 Johannes Kepler University
 *               2020 TU Wien/ACIN
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
 *   Alois Zoitl - reworked deployment to detect if monitoring was enabled
 *   Martin Melik Merkumians - added deployment for PLC resource
 *******************************************************************************/
package org.eclipse.fordiac.ide.deployment;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.fordiac.ide.deployment.data.DeviceDeploymentData;
import org.eclipse.fordiac.ide.deployment.data.PLCResourceDeploymentData;
import org.eclipse.fordiac.ide.deployment.data.ResourceDeploymentData;
import org.eclipse.fordiac.ide.deployment.interactors.IDeviceManagementInteractor;
import org.eclipse.fordiac.ide.deployment.util.IDeploymentListener;
import org.eclipse.fordiac.ide.model.libraryElement.Device;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

public enum DeploymentCoordinator {
	INSTANCE;

	private static final String OUTPUT_VIEW_ID = "org.eclipse.fordiac.ide.deployment.ui.views.Output"; //$NON-NLS-1$

	private final Map<Device, List<VarDeclaration>> deployedDeviceProperties = new HashMap<>();

	public void addDeviceProperty(Device dev, VarDeclaration property) {
		if (deployedDeviceProperties.containsKey(dev)) {
			List<VarDeclaration> temp = deployedDeviceProperties.get(dev);
			if (!temp.contains(property)) {
				temp.add(property);
			}
		} else {
			ArrayList<VarDeclaration> temp = new ArrayList<>();
			temp.add(property);
			deployedDeviceProperties.put(dev, temp);
		}
	}

	public void setDeviceProperties(Device dev, List<VarDeclaration> properties) {
		deployedDeviceProperties.put(dev, properties);
	}

	public void removeDeviceProperty(Device dev, VarDeclaration property) {
		if (deployedDeviceProperties.containsKey(dev)) {
			List<VarDeclaration> temp = deployedDeviceProperties.get(dev);
			if (temp.contains(property)) {
				temp.remove(property);
			}
		}
	}

	public List<VarDeclaration> getSelectedDeviceProperties(Device dev) {
		List<VarDeclaration> retVal = deployedDeviceProperties.get(dev);
		if (null == retVal) {
			retVal = Collections.emptyList();
		}
		return retVal;
	}

	public static void printUnsupportedDeviceProfileMessageBox(final Device device, final Resource res) {
		Display.getDefault().asyncExec(() -> {
			MessageBox messageBox = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					SWT.ICON_ERROR | SWT.OK);
			String resName = (null != res) ? res.getName() : ""; //$NON-NLS-1$

			if (null != device.getProfile() && !device.getProfile().equals("")) { //$NON-NLS-1$
				messageBox.setMessage(
						MessageFormat.format(Messages.DeploymentCoordinator_MESSAGE_DefinedProfileNotSupported,
								device.getProfile(), device.getName(), resName));
			} else {
				messageBox.setMessage(MessageFormat.format(Messages.DeploymentCoordinator_MESSAGE_ProfileNotSet,
						device.getName(), resName));
			}
			messageBox.open();
		});
	}

	/**
	 * Perform deployment.
	 *
	 * @param selection                 the selection
	 * @param overrideDevMgmCommHandler if not null this device management
	 *                                  communication should be used instead the one
	 *                                  derived from the device profile.
	 */
	public void performDeployment(final Object[] selection,
			IDeviceManagementCommunicationHandler overrideDevMgmCommHandler, String profile) {
		IDeploymentListener outputView = (IDeploymentListener) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().findView(OUTPUT_VIEW_ID);
		DownloadRunnable download = new DownloadRunnable(createDeploymentdata(selection), overrideDevMgmCommHandler,
				outputView, profile);
		Shell shell = Display.getDefault().getActiveShell();
		try {
			new ProgressMonitorDialog(shell).run(true, true, download);
		} catch (InvocationTargetException ex) {
			MessageDialog.openError(shell, Messages.DeploymentCoordinator_DepoymentError, ex.getMessage());
		} catch (InterruptedException ex) {
			MessageDialog.openInformation(shell, Messages.DeploymentCoordinator_LABEL_DownloadAborted, ex.getMessage());
		}
	}

	public void performDeployment(final Object[] selection) {
		performDeployment(selection, null, null);
	}

	/**
	 * Enable output.
	 *
	 * @param executor the executor
	 */
	public void enableOutput(IDeviceManagementInteractor interactor) {
		IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(OUTPUT_VIEW_ID);
		if (null != view) {
			interactor.addDeploymentListener((IDeploymentListener) view);
		}
	}

	/**
	 * Disable output.
	 *
	 * @param executor the executor
	 */
	public void disableOutput(IDeviceManagementInteractor interactor) {
		IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(OUTPUT_VIEW_ID);
		if (null != view) {
			interactor.removeDeploymentListener((IDeploymentListener) view);
		}
	}

	private List<DeviceDeploymentData> createDeploymentdata(Object[] selection) {
		List<DeviceDeploymentData> data = new ArrayList<>();
		for (Object object : selection) {
			if (object instanceof Resource) {
				Resource res = (Resource) object;
				DeviceDeploymentData devData = getDevData(data, res.getDevice());
				if ("EMB_PLC_RES".equalsIgnoreCase(res.getType().getName())) {
					devData.addResourceData(new PLCResourceDeploymentData(res));
				} else {
					devData.addResourceData(new ResourceDeploymentData(res));
				}
			} else if (object instanceof Device) {
				Device dev = (Device) object;
				DeviceDeploymentData devData = getDevData(data, dev);
				devData.setSeltectedDevParams(getSelectedDeviceProperties((Device) object));
			}
		}
		return data;
	}

	private static DeviceDeploymentData getDevData(List<DeviceDeploymentData> data, final Device device) {
		DeviceDeploymentData retVal = null;
		for (DeviceDeploymentData devData : data) {
			if (device == devData.getDevice()) {
				retVal = devData;
				break;
			}
		}
		if (null == retVal) {
			retVal = new DeviceDeploymentData(device);
			data.add(retVal);
		}
		return retVal;
	}

}
