/*******************************************************************************
 * Copyright (c) 2011 - 2016 Profactor GmbH, fortiss GmbH
 *               2020 Johannes Kepler University Linz
 *               2020 TU Wien/ACIN
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Gerhard Ebenhofer, Monika Wenger, Alois Zoitl
 *     - initial API and implementation and/or initial documentation
 *  Bianca Wiesmayr
 *     - make border color editable
 *  Martin Melik Merkumians - added options which corners should be rounded
 *******************************************************************************/
package org.eclipse.fordiac.ide.gef.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class AdvancedRoundedRectangle extends RoundedRectangle {

	public final static int NO_ROUNDED_CORNERS = 0;
	public final static int TOP_LEFT = 1;
	public final static int TOP_RIGHT = 2;
	public final static int BOTTOM_LEFT = 4;
	public final static int BOTTOM_RIGHT = 8;
	public final static int ALL_CORNERS_ROUNDED = TOP_LEFT | TOP_RIGHT | BOTTOM_LEFT | BOTTOM_RIGHT;

	private int side = PositionConstants.NONE;
	private int corners = PositionConstants.NONE;
	private Color borderColor;

	public AdvancedRoundedRectangle(int side) {
		super();
		this.side = side;
	}

	public AdvancedRoundedRectangle(int side, Color borderColor) {
		super();
		this.side = side;
		this.corners = ALL_CORNERS_ROUNDED;
		this.borderColor = borderColor;
	}

	public AdvancedRoundedRectangle(int side, int corners, Color borderColor) {
		super();
		this.side = side;
		this.corners = corners;
		this.borderColor = borderColor;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public void setBorderColor(Color color) {
		this.borderColor = color;
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		if (null != borderColor) {
			graphics.setForegroundColor(borderColor);
		}
		float lineInset = Math.max(1.0F, getLineWidthFloat()) / 2.0F;
		int inset1 = (int) Math.floor(lineInset);
		int inset2 = (int) Math.ceil(lineInset);

		Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
		r.x += inset1;
		r.y += inset1;
		r.width -= inset1 + inset2;
		r.height -= inset1 + inset2;

		int x = r.x;
		int y = r.y;

		int width = r.width;
		int height = r.height;
		int arcWidth = Math.max(0, getCornerDimensions().width - (int) lineInset);
		int arcHeight = Math.max(0, getCornerDimensions().height - (int) lineInset);

		if ((width == 0) || (height == 0)) {
			return;
		}
		if ((arcWidth == 0) || (arcHeight == 0)) {
			if ((side & PositionConstants.NORTH) != 0) {
				graphics.drawLine(r.x, r.y, r.x + r.width, r.y);
			}
			if ((side & PositionConstants.EAST) != 0) {
				graphics.drawLine(r.x + r.width, r.y, r.x + r.width, r.y + r.height);
			}
			if ((side & PositionConstants.SOUTH) != 0) {
				graphics.drawLine(r.x, r.y + r.height, r.x + r.width, r.y + r.height);
			}
			if ((side & PositionConstants.WEST) != 0) {
				graphics.drawLine(r.x, r.y, r.x, r.y + r.height);
			}
			if ((side & PositionConstants.NONE) != 0) {
				// nothing to do!
			}

			return;
		}
		if (width < 0) {
			x += width;
			width = -width;
		}
		if (height < 0) {
			y += height;
			height = -height;
		}
		if (arcWidth < 0) {
			arcWidth = -arcWidth;
		}
		if (arcHeight < 0) {
			arcHeight = -arcHeight;
		}
		if (arcWidth > width) {
			arcWidth = width;
		}
		if (arcHeight > height) {
			arcHeight = height;
		}

		if (arcWidth < width) {
			if ((side & PositionConstants.NORTH) != 0) {
				graphics.drawLine(x + (arcWidth / 2), y, (x + width) - (arcWidth / 2), y);
			}
			if ((side & PositionConstants.SOUTH) != 0) {
				graphics.drawLine(x + (arcWidth / 2), y + height, (x + width) - (arcWidth / 2), y + height);
			}
		}
		if (arcHeight < height) {
			if ((side & PositionConstants.WEST) != 0) {
				graphics.drawLine(x, y + (arcHeight / 2), x, (y + height) - (arcHeight / 2));
			}
			if ((side & PositionConstants.EAST) != 0) {
				graphics.drawLine(x + width, y + (arcHeight / 2), x + width, (y + height) - (arcHeight / 2));
			}
		}
		if ((arcWidth != 0) && (arcHeight != 0) && (side != PositionConstants.NONE)) {

			if (0 != (TOP_LEFT & corners)) {
				graphics.drawArc(x, y, arcWidth, arcHeight, 90, 90);
			} else {
				graphics.drawLine(r.x, r.y, r.x, r.y + arcHeight);
			}
			if (0 != (TOP_RIGHT & corners)) {
				graphics.drawArc((x + width) - arcWidth, y, arcWidth, arcHeight, 0, 90);
			} else {
				graphics.drawLine(r.x + width, r.y, r.x + width, r.y + arcHeight);
			}
			if (0 != (BOTTOM_RIGHT & corners)) {
				graphics.drawArc((x + width) - arcWidth, (y + height) - arcHeight, arcWidth, arcHeight, 0, -90);
			} else {
				graphics.drawLine(r.x + width, r.y + height, r.x + width, r.y + height - (arcHeight + 1) / 2);
			}
			if (0 != (BOTTOM_LEFT & corners)) {
				graphics.drawArc(x, (y + height) - arcHeight, arcWidth, arcHeight, 180, 90);
			} else {
				graphics.drawLine(r.x, r.y + height, r.x, r.y + height - (arcHeight + 1) / 2);
			}
		}

	}

}
