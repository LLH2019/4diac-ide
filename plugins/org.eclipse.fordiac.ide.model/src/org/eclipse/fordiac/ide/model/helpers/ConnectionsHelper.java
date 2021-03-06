/*******************************************************************************
 * Copyright (c) 2017 fortiss GmbH
 * 				 2020 Primetals Technologies Germany GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 3
 *
 * Contributors:
 *   Alois Zoitl - initial implementation and/or documentation
 *   Alexander Lumplecker - extracted Code from OpenConnectionOppositeResource
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.helpers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.fordiac.ide.model.libraryElement.Connection;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;

public class ConnectionsHelper {

	public static EList<Connection> getConnections(IInterfaceElement oppositeIE) {
		IInterfaceElement fbOppostiteIE = oppositeIE.getFBNetworkElement().getOpposite()
				.getInterfaceElement(oppositeIE.getName());

		if (null != fbOppostiteIE) {
			final EList<Connection> connections = (fbOppostiteIE.isIsInput()) ? fbOppostiteIE.getInputConnections()
					: fbOppostiteIE.getOutputConnections();

			return connections;
		}
		return null;
	}

	public static IInterfaceElement getOppositeInterfaceElement(IInterfaceElement ie, Connection connection) {
		IInterfaceElement fbOppostiteIE = ie.getFBNetworkElement().getOpposite().getInterfaceElement(ie.getName());

		if (null != fbOppostiteIE) {
			IInterfaceElement connectionOpposite = (fbOppostiteIE.isIsInput()) ? connection.getSource()
					: connection.getDestination();

			if ((null != connectionOpposite) && connectionOpposite.getFBNetworkElement().isMapped()) {
				FBNetworkElement mappedOppositeElement = connectionOpposite.getFBNetworkElement().getOpposite();
				return mappedOppositeElement.getInterfaceElement(connectionOpposite.getName());
			}

		}
		return null;
	}
}
