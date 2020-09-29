/*******************************************************************************
 * Copyright (c) 2008 - 2017 Profactor GmbH, fortiss GmbH
 * 				 2019 Johannes Kepler University Linz
 *               2008 - 2017, 2020 TU Wien/ACIN
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
 *   Alois Zoitl - moved openEditor helper function to EditorUtils
 *               - added diagram font preference
 *   			 - separated FBNetworkElement from instance name for better
 *                 direct editing of instance names
 *               - extracted common FB shape for interface and fbn editors
 *   Martin Melik Merkumians - added setModel method
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.figures;

import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.fordiac.ide.application.editparts.AbstractFBNElementEditPart;
import org.eclipse.fordiac.ide.gef.draw2d.ITransparencyFigure;
import org.eclipse.fordiac.ide.gef.figures.FBShape;
import org.eclipse.fordiac.ide.model.Palette.PaletteEntry;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.ui.editors.EditorUtils;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * The visualization of an FB. It Provides several containers for its interface.
 *
 */
public class FBNetworkElementFigure extends FBShape implements ITransparencyFigure {

	private static final class OpenTypeListener implements MouseListener {
		private final AbstractFBNElementEditPart editPart;

		public OpenTypeListener(AbstractFBNElementEditPart editPart) {
			this.editPart = editPart;
		}

		@Override
		public void mousePressed(MouseEvent me) {
			if ((0 != (me.getState() & SWT.CONTROL)) && editPart.isOnlyThisOrNothingSelected()) {
				openTypeInEditor(editPart.getModel());
			}
		}

		@Override
		public void mouseReleased(MouseEvent me) {
			// nothing to be done here
		}

		@Override
		public void mouseDoubleClicked(MouseEvent me) {
			// nothing to be done here
		}

	}

	// TODO model refactoring - look for a better place for this function
	public static void openTypeInEditor(FBNetworkElement element) {
		// open the default editor for the adapter file
		PaletteEntry entry = element.getPaletteEntry();
		if (null != entry) {
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry()
					.getDefaultEditor(entry.getFile().getName());
			EditorUtils.openEditor(new FileEditorInput(entry.getFile()), desc.getId());
		}
	}

	/** The model. */
	private FBNetworkElement model = null;

	protected FBNetworkElement getModel() {
		return model;
	}

	protected void setModel(FBNetworkElement model) {
		this.model = model;
	}

	/**
	 * Instantiates a new fB figure.
	 *
	 * @param model the model
	 */
	public FBNetworkElementFigure(final FBNetworkElement model, final AbstractFBNElementEditPart editPart) {
		super(model.getType());
		this.model = model;
		refreshToolTips();
		if (null != editPart) {
			setupMouseListener(editPart);
		}
	}

	private void setupMouseListener(final AbstractFBNElementEditPart editPart) {

		getMiddle().addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent me) {
				// nothing to bo done here
			}

			@Override
			public void mouseEntered(MouseEvent me) {
				if ((0 != (me.getState() & SWT.CONTROL)) && editPart.isOnlyThisOrNothingSelected()) {
					getTypeLabel().setDrawUnderline(true);
				}
			}

			@Override
			public void mouseExited(MouseEvent me) {
				getTypeLabel().setDrawUnderline(false);
			}

			@Override
			public void mouseHover(MouseEvent me) {
				// currently mouseHover should be the same as mouse moved
				mouseMoved(me);
			}

			@Override
			public void mouseMoved(MouseEvent me) {
				if ((0 != (me.getState() & SWT.CONTROL)) && editPart.isOnlyThisOrNothingSelected()) {
					if (!getTypeLabel().isDrawUnderline()) {
						getTypeLabel().setDrawUnderline(true);
					}
				} else {
					if (getTypeLabel().isDrawUnderline()) {
						getTypeLabel().setDrawUnderline(false);
					}
				}
			}

		});

		getMiddle().addMouseListener(createOpenTypeMouseListener(editPart));

	}

	private static OpenTypeListener createOpenTypeMouseListener(final AbstractFBNElementEditPart editPart) {
		return new OpenTypeListener(editPart);
	}

	/**
	 * Refresh tool tips.
	 */
	public final void refreshToolTips() {
		setToolTip(new FBNetworkElementTooltipFigure(model));
	}

	@Override
	public void setTransparency(int value) {
		setAlpha(value);
	}

	@Override
	public int getTransparency() {
		return getAlpha();
	}

	@Override
	public Rectangle getBounds() {
		return super.getBounds();
	}

	public Rectangle getFBBounds() {
		int x = getTop().getBounds().x();
		int y = getLabelBounds().y();
		int width = getTop().getBounds().width;
		int height = getTop().getBounds().height() + getMiddle().getBounds().height() + getBottom().getBounds().height()
				+ getLabelBounds().height();
		return new Rectangle(x, y, width, height);
	}

	public Rectangle getLabelBounds() {
		for (Object figure : getChildren()) {
			if (figure instanceof InstanceNameFigure) {
				return ((InstanceNameFigure) figure).getBounds();
			}
		}
		return new Rectangle();
	}

}
