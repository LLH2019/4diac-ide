/*******************************************************************************
 * Copyright (c) 2019 - 2020 Johannes Kepler University Linz
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Alois Zoitl - initial API and implementation and/or initial documentation
 *   Bianca Wiesmayr - added positioning calculations
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.helpers;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterConnection;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.AdapterFB;
import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.DataConnection;
import org.eclipse.fordiac.ide.model.libraryElement.EventConnection;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetwork;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.fordiac.ide.model.libraryElement.InterfaceList;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.Position;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.graphics.Point;

public final class FBNetworkHelper {

	/**
	 * Take the src FBNetwork and copy it into a new network.
	 *
	 * @param srcNetwork    the FBNetwork to copy
	 * @param destInterface if not null the interface of the component the new
	 *                      FBNetwork should be contained in
	 * @return the copied FBNetwork
	 */
	public static FBNetwork copyFBNetWork(final FBNetwork srcNetwork, final InterfaceList destInterface) {
		final FBNetwork dstNetwork = LibraryElementFactory.eINSTANCE.createFBNetwork();
		dstNetwork.getNetworkElements().addAll(EcoreUtil.copyAll(srcNetwork.getNetworkElements()));
		checkForAdapterFBs(dstNetwork, destInterface);
		createConnections(srcNetwork, dstNetwork, destInterface);
		return dstNetwork;
	}

	private static void checkForAdapterFBs(final FBNetwork dstNetwork, final InterfaceList destInterface) {
		for (final FBNetworkElement elem : dstNetwork.getNetworkElements()) {
			if (elem instanceof AdapterFB) {
				final AdapterDeclaration adapter = destInterface.getAdapter(elem.getName());
				if (null != adapter) {
					((AdapterFB) elem).setAdapterDecl(adapter);
				}
			}
		}
	}

	private static void createConnections(final FBNetwork srcNetwork, final FBNetwork dstNetwork, final InterfaceList destInterface) {
		for (final Connection connection : srcNetwork.getEventConnections()) {
			dstNetwork.getEventConnections()
			.add((EventConnection) createConnection(srcNetwork, destInterface, dstNetwork, connection));
		}

		for (final Connection connection : srcNetwork.getDataConnections()) {
			dstNetwork.getDataConnections()
			.add((DataConnection) createConnection(srcNetwork, destInterface, dstNetwork, connection));
		}

		for (final Connection connection : srcNetwork.getAdapterConnections()) {
			dstNetwork.getAdapterConnections()
			.add((AdapterConnection) createConnection(srcNetwork, destInterface, dstNetwork, connection));
		}
	}

	private static Connection createConnection(final FBNetwork srcNetwork, final InterfaceList destInterface, final FBNetwork dstNetwork,
			final Connection connection) {
		final Connection newConn = EcoreUtil.copy(connection);
		newConn.setSource(getInterfaceElement(connection.getSource(), destInterface, dstNetwork, srcNetwork));
		newConn.setDestination(getInterfaceElement(connection.getDestination(), destInterface, dstNetwork, srcNetwork));
		return newConn;
	}

	private static IInterfaceElement getInterfaceElement(final IInterfaceElement ie, final InterfaceList typeInterface,
			final FBNetwork dstNetwork, final FBNetwork srcNetwork) {
		if (null == ie.getFBNetworkElement()) {
			return typeInterface.getInterfaceElement(ie.getName());
		}

		if (!srcNetwork.equals(ie.getFBNetworkElement().getFbNetwork())) {
			return typeInterface.getInterfaceElement(ie.getName());
		}
		final FBNetworkElement element = dstNetwork.getElementNamed(ie.getFBNetworkElement().getName());
		if (null == element) {
			return null;
		}
		return element.getInterfaceElement(ie.getName());
	}

	/**
	 * methods for updating position of FBNetwork after creating/flattening
	 * subapp/...
	 */

	public static Point getTopLeftCornerOfFBNetwork(final List<?> selection) {
		Assert.isNotNull(selection);
		final Point pt = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Object fb = null;
		for (final Object sel : selection) {
			fb = (sel instanceof EditPart) ? ((EditPart) sel).getModel() : sel;
			if (fb instanceof FBNetworkElement) {
				final Position pos = ((FBNetworkElement) fb).getPosition();
				pt.x = Math.min(pt.x, pos.getX());
				pt.y = Math.min(pt.y, pos.getY());
			}
		}
		return pt;
	}

	public static final int Y_OFFSET_FROM_TOP_LEFT_CORNER = 80; // from top-left corner of container
	public static final int X_OFFSET_FROM_TOP_LEFT_CORNER = 150;

	public static void moveFBNetworkByOffset(final Iterable<FBNetworkElement> fbNetwork, final int xOffset, final int yOffset) {
		for (final FBNetworkElement el : fbNetwork) {
			final Position pos = LibraryElementFactory.eINSTANCE.createPosition();
			pos.setX(el.getPosition().getX() - xOffset);
			pos.setY(el.getPosition().getY() - xOffset);
			el.setPosition(pos);
		}
	}

	public static Point removeXYOffsetForFBNetwork(final List<FBNetworkElement> fbNetwork) {
		final Point offset = getTopLeftCornerOfFBNetwork(fbNetwork);
		moveFBNetworkByOffset(fbNetwork, offset.x - X_OFFSET_FROM_TOP_LEFT_CORNER,
				offset.y - Y_OFFSET_FROM_TOP_LEFT_CORNER);
		return offset;
	}

	public static void moveFBNetworkByOffset(final List<FBNetworkElement> fbNetwork, final Point offset) {
		moveFBNetworkByOffset(fbNetwork, offset.x, offset.y);
	}

	private FBNetworkHelper() {
		throw new IllegalStateException("FBNetworkHelper is a utility class that can not be instantiated"); //$NON-NLS-1$
	}
}
