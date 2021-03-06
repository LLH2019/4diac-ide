/*******************************************************************************
 * Copyright (c) 2010, 2012, 2013, 2016, 2017 Profactor GbmH, fortiss GmbH
 *               2018 TU Vienna/ACIN
 *               2020 Johannes Kepler University Linz
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
 *   Martin Melik Merkumians
 *     - makes ctor private and class final
 *   Bianca Wiesmayr
 *     - define a first color for devices
 *******************************************************************************/
package org.eclipse.fordiac.ide.util;

import java.security.SecureRandom;
import java.util.Random;

import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public final class ColorHelper {

	private static final double MAX_RGB_VALUE = 255.D;

	private ColorHelper() {

	}

	private static final float VALUE_MULTIPLIER = 0.6F;

	public static Color lighter(final Color original) {
		return transformColorLightness(original, 1.0 / VALUE_MULTIPLIER);
	}

	public static Color transformColorLightness(final Color original, final double scale) {
		if (null == original) {
			return null;
		}
		final double[] hsl = rgbToHSL(original.getRGB());
		hsl[2] = Math.min(1.0, hsl[2] * scale);
		return ColorManager.getColor(hslToRGB(hsl));
	}

	public static Color darker(final Color original) {
		return transformColorLightness(original, VALUE_MULTIPLIER);
	}

	/**
	 * Transforms the RGB color into the according HSL color space. Algorithm based
	 * on the Book: Computer Graphics: Principles and Practice in C (2nd Edition)
	 * (Systems Programming Series) (Hardcover) by James D. Foley (Author), Andries
	 * van Dam (Author), Steven K. Feiner (Author), John F. Hughes (Author)
	 *
	 * @param rgb the rgb values of the color to convert
	 * @return the color in hsl space h: 0..360, s: 0..1, l: 0..1
	 */
	public static double[] rgbToHSL(final RGB rgb) {

		final double r = rgb.red / MAX_RGB_VALUE;
		final double g = rgb.green / MAX_RGB_VALUE;
		final double b = rgb.blue / MAX_RGB_VALUE;
		final double max = Math.max(Math.max(r, g), b);
		final double min = Math.min(Math.min(r, g), b);

		final double[] hsl = new double[] { 0, 0, (max + min) / 2 };

		if (max != min) {
			// we are not just grey
			final double delta = max - min;

			if (hsl[2] <= 0.5) {
				hsl[1] = (delta / (max + min));
			} else {
				hsl[1] = (delta / (2.0 - (max + min)));
			}

			if (Math.abs(max - r) <= Double.MIN_VALUE) { // how to check equality for doubles
				hsl[0] = (g - b) / delta;
			} else if (Math.abs(max - g) <= Double.MIN_VALUE) {
				hsl[0] = 2.0 + ((b - r) / delta);
			} else if (Math.abs(max - b) <= Double.MIN_VALUE) {
				hsl[0] = 4.0 + ((r - g) / delta);
			}
			hsl[0] *= 60.0;

			if (hsl[0] < 0.0) {
				hsl[0] += 360.0;
			}
		}
		return hsl;
	}

	/**
	 * Transforms the HSL color into the according RGB color space. Algorithm based
	 * on the Book: Computer Graphics: Principles and Practice in C (2nd Edition)
	 * (Systems Programming Series) (Hardcover) by James D. Foley (Author), Andries
	 * van Dam (Author), Steven K. Feiner (Author), John F. Hughes (Author)
	 *
	 * @param hsl the color in hsl space h: 0..360, s: 0..1, l: 0..1
	 * @return the color in rgb space
	 */
	public static RGB hslToRGB(final double[] hsl) {
		final RGB retVal = new RGB(0, 0, 0);

		if (hsl[1] == 0.0) {
			if (hsl[0] == 0.0) {
				retVal.red = retVal.green = retVal.blue = (int) (hsl[2] * MAX_RGB_VALUE);
			} else {
				// in the achromatic (grey) case h must not have a value
				SWT.error(SWT.ERROR_INVALID_ARGUMENT);
			}
		} else {
			final double m2 = ((hsl[2] <= 0.5) ? (hsl[2] * (1.0 + hsl[1])) : ((hsl[2] + hsl[1]) - (hsl[2] * hsl[1])));
			final double m1 = (2.0 * hsl[2]) - m2;

			retVal.red = hslValue(m1, m2, hsl[0] + 120.0);
			retVal.green = hslValue(m1, m2, hsl[0]);
			retVal.blue = hslValue(m1, m2, hsl[0] - 120.0);
		}
		return retVal;
	}

	private static int hslValue(final double m1, final double m2, double hue) {
		double retVal = m1;

		if (hue > 360.0) {
			hue -= 360.0;
		} else if (hue < 0.0) {
			hue += 360.0;
		}

		if (hue < 60.0) {
			retVal = m1 + (((m2 - m1) * hue) / 60.0);
		} else if (hue < 180.0) {
			retVal = m2;
		} else if (hue < 240.0) {
			retVal = m1 + (((m2 - m1) * (240.0 - hue)) / 60.0);
		}

		return (int) (MAX_RGB_VALUE * retVal);
	}

	private static final double GOLDEN_RATIO_CONJUGATE = 0.618033988749895;
	private static Random rand = new SecureRandom();
	private static double h = rand.nextDouble(); // static to get different colors

	public static org.eclipse.fordiac.ide.model.libraryElement.Color createRandomColor() {
		final RGB rgbColor = createRandomColor(0.6f, 0.85f);

		final org.eclipse.fordiac.ide.model.libraryElement.Color color = LibraryElementFactory.eINSTANCE.createColor();
		color.setRed(rgbColor.red);
		color.setGreen(rgbColor.green);
		color.setBlue(rgbColor.blue);
		return color;
	}

	public static RGB createRandomColor(float s, float v) {
		h += GOLDEN_RATIO_CONJUGATE;
		h %= 1;

		s += ((rand.nextDouble() * 0.5) - 0.25);
		v += ((rand.nextDouble() * 0.2) - 0.1);

		return new RGB((float) (h * 360.0), s, v);
	}

	public static org.eclipse.fordiac.ide.model.libraryElement.Color getStartingColor() {
		final org.eclipse.fordiac.ide.model.libraryElement.Color color = LibraryElementFactory.eINSTANCE.createColor();
		color.setRed(255);
		color.setGreen(190);
		color.setBlue(111);
		return color;
	}
}
