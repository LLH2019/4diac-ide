/*******************************************************************************
 * Copyright (c) 2009, 2011, 2012, 2016, 2017 Profactor GmbH, TU Wien ACIN, fortiss GmbH
 * 				 2018 Johanes Kepler University
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
 *   Alois Zoitl - fixed connection adjusting when zoomed
 *******************************************************************************/
package org.eclipse.fordiac.ide.gef.commands;

import java.text.MessageFormat;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.fordiac.ide.gef.Activator;
import org.eclipse.fordiac.ide.gef.Messages;
import org.eclipse.fordiac.ide.gef.router.MoveableRouter;
import org.eclipse.fordiac.ide.model.libraryElement.ConnectionRoutingData;
import org.eclipse.gef.commands.Command;

public class AdjustConnectionCommand extends Command {

	private final Connection connection;
	private final Point point;
	private final int index;
	private final org.eclipse.fordiac.ide.model.libraryElement.Connection modelConnection;
	private final double zoom;

	public AdjustConnectionCommand(final Connection connection, final Point p, final int index,
			final org.eclipse.fordiac.ide.model.libraryElement.Connection modelConnection, final double zoom) {
		super();
		this.connection = connection;
		this.point = p;
		this.index = index;
		this.modelConnection = modelConnection;
		this.zoom = zoom;
	}

	@Override
	public void execute() {
		final Point sourceP = getSourcePoint();
		final Point destP = getDestinationPoint();
		final int scaledMinDistance = (int) Math.floor(MoveableRouter.MIN_CONNECTION_FB_DISTANCE * zoom);
		final ConnectionRoutingData routingData = modelConnection.getRoutingData();

		switch (index) {
		case 1:
			int newDx1 = Math.max(point.x - sourceP.x, scaledMinDistance);
			if (0 == routingData.getDx2()) {
				// we have three segment connection check that we are not beyond the input
				newDx1 = Math.min(newDx1, destP.x - sourceP.x - scaledMinDistance);
			}
			routingData.setDx1((int) Math.floor(newDx1 / zoom));
			break;
		case 2:
			routingData.setDy((int) Math.floor((point.y - sourceP.y) / zoom));
			break;
		case 3:
			final int newDx2 = Math.max(destP.x - point.x, scaledMinDistance);
			routingData.setDx2((int) Math.floor(newDx2 / zoom));
			break;
		default:
			Activator.getDefault().logError(
					MessageFormat.format(Messages.AdjustConnectionCommand_WrongConnectionSegmentIndex, index));
			break;
		}
		connection.revalidate();
	}

	private Point getDestinationPoint() {
		final Point destP = connection.getTargetAnchor().getLocation(connection.getTargetAnchor().getReferencePoint())
				.getCopy();
		return destP;
	}

	private Point getSourcePoint() {
		final Point sourceP = connection.getSourceAnchor().getLocation(connection.getSourceAnchor().getReferencePoint())
				.getCopy();
		return sourceP;
	}

	@Override
	public void undo() {
	}

	@Override
	public void redo() {
	}
}
