/*******************************************************************************
 * Copyright (c) 2012 - 2018 Profactor GmbH, AIT, fortiss GmbH
 * 							 Johannes Kepler University
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Filip Andren, Alois Zoitl, Gerd Kainz
 *     - initial API and implementation and/or initial documentation
 *   Alois Zoitl - Harmonized deployment and monitoring
 *******************************************************************************/
package org.eclipse.fordiac.ide.monitoring;

import java.util.ArrayList;

import org.eclipse.fordiac.ide.application.editparts.FBEditPart;
import org.eclipse.fordiac.ide.deployment.monitoringbase.MonitoringBaseFactory;
import org.eclipse.fordiac.ide.deployment.monitoringbase.PortElement;
import org.eclipse.fordiac.ide.fbtypeeditor.network.viewer.CompositeNetworkViewerEditPart;
import org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.FB;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.Resource;
import org.eclipse.fordiac.ide.model.libraryElement.SubApp;
import org.eclipse.fordiac.ide.model.monitoring.MonitoringFactory;

public final class MonitoringManagerUtils {

	private MonitoringManagerUtils() {
		throw new AssertionError(); // class should not be instantiated
	}

	public static boolean canBeMonitored(final org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart editPart) {
		final PortElement port = MonitoringManagerUtils.createPortElement(editPart); // FIXME think how we can get away
		// without creating a port element
		return ((port != null) && (port.getPortString() != null));
	}

	public static boolean canBeMonitored(final FBEditPart obj) {
		// As a first solution try to find the first interface editpart and see if we
		// can monitoring
		for (final Object child : obj.getChildren()) {
			if (child instanceof InterfaceEditPart) {
				return canBeMonitored((InterfaceEditPart) child);
			}
		}
		return false;
	}

	public static PortElement createPortElement(
			final org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart editPart) {
		if (editPart.getParent() instanceof FBEditPart
				&& editPart.getParent().getParent() instanceof CompositeNetworkViewerEditPart) {
			return createCompositeInternalPortString(editPart);
		}

		final FBNetworkElement obj = editPart.getModel().getFBNetworkElement();
		if (obj instanceof FB) {
			final FB fb = (FB) obj;
			return createPortElement(fb, editPart);
		}

		return null;

	}

	private static PortElement createPortElement(final FBNetworkElement fb,
			final org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart ep) {
		PortElement p;
		if (ep.getModel() instanceof AdapterDeclaration) {
			p = MonitoringFactory.eINSTANCE.createAdapterPortElement();
		} else {
			p = MonitoringBaseFactory.eINSTANCE.createPortElement();
		}

		final Resource res = fb.getResource();
		if (res == null) {
			return null;
		}

		p.setResource(res);
		// TODO adapt or remove this
		if (fb instanceof FB) {
			p.setFb((FB) fb);
		}
		setupFBHierarchy(fb, p);
		p.setInterfaceElement(ep.getModel());
		return p;
	}

	private static PortElement createCompositeInternalPortString(
			final org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart editPart) {

		final FBEditPart fbep = (FBEditPart) editPart.getParent();
		final CompositeNetworkViewerEditPart cnep = (CompositeNetworkViewerEditPart) editPart.getParent().getParent();

		final ArrayList<CompositeNetworkViewerEditPart> parents = new ArrayList<>();

		CompositeNetworkViewerEditPart root = cnep;
		parents.add(0, root);
		while (root.getparentInstanceViewerEditPart() != null) {
			parents.add(0, root.getparentInstanceViewerEditPart());
			root = root.getparentInstanceViewerEditPart();
		}

		final FBNetworkElement fb = root.getFbInstance();
		final PortElement pe = createPortElement(fb, editPart);
		if (pe != null) {
			pe.setFb(fbep.getModel());

			for (final CompositeNetworkViewerEditPart compositeNetworkEditPart : parents) {
				pe.getHierarchy().add(compositeNetworkEditPart.getFbInstance().getName());
			}
			return pe;
		}
		return null;
	}

	private static void setupFBHierarchy(final FBNetworkElement element, final PortElement p) {
		if (!element.isMapped() && element.getFbNetwork().eContainer() instanceof SubApp) {
			final SubApp subApp = (SubApp) element.getFbNetwork().eContainer();
			setupFBHierarchy(subApp, p);
			p.getHierarchy().add(subApp.getName());
		}
	}

}
