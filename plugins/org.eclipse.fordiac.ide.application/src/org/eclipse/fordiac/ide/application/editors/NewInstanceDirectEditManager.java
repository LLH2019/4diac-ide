/*******************************************************************************
 * Copyright (c) 2019 Johannes Kepler University Linz
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
package org.eclipse.fordiac.ide.application.editors;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.fordiac.ide.gef.editparts.TextDirectEditManager;
import org.eclipse.fordiac.ide.model.Palette.Palette;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;

public class NewInstanceDirectEditManager extends TextDirectEditManager {

	private static final Insets BORDER_INSETS = new Insets(0, 0, 0, 0);
	private static final AbstractBorder BORDER = new AbstractBorder() {

		@Override
		public Insets getInsets(IFigure figure) {
			return BORDER_INSETS;
		}

		@Override
		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			// don't draw any border to make the direct editor smaller
		}
	};

	public static class NewInstanceCellEditorLocator implements CellEditorLocator {
		private Point refPoint = new Point(0, 0);

		@Override
		public void relocate(CellEditor celleditor) {
			if (null != celleditor) {
				final Control control = celleditor.getControl();
				final Point pref = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
				control.setBounds(refPoint.x - 1, refPoint.y - 1, pref.x + 1, pref.y + 1);
			}
		}

		public void setRefPoint(Point refPoint) {
			this.refPoint = refPoint;
		}

		public Point getRefPoint() {
			return refPoint;
		}
	}

	private final Palette palette;
	private final boolean useChangeFBType;
	private String initialValue;

	public NewInstanceDirectEditManager(GraphicalEditPart source, Palette palette, boolean useChangeFBType) {
		super(source, NewInstanceCellEditor.class, new NewInstanceCellEditorLocator());
		this.palette = palette;
		this.useChangeFBType = useChangeFBType;
	}

	@Override
	public void show() {
		initialValue = null;
		super.show();
	}

	public void show(String initialValue) {
		this.initialValue = initialValue;
		super.show();
		if (null != initialValue) {
			final Text text = getCellEditor().getText();
			text.selectAll();
			setDirty(true);
		}
	}

	@Override
	protected void initCellEditor() {
		getCellEditor().getMenuButton().addListener(SWT.Selection, event -> showFBInsertPopUpMenu());
		getCellEditor().setPalette(palette);
		super.initCellEditor();
		if (null != initialValue) {
			getCellEditor().setValue(initialValue);
		}
	}

	@Override
	public NewInstanceCellEditorLocator getLocator() {
		return (NewInstanceCellEditorLocator) super.getLocator();
	}

	@Override
	protected NewInstanceCellEditor getCellEditor() {
		return (NewInstanceCellEditor) super.getCellEditor();
	}

	public void updateRefPosition(Point refPoint) {
		getLocator().setRefPoint(refPoint);
	}

	@Override
	protected IFigure getCellEditorFrame() {
		final IFigure cellEditorFrame = super.getCellEditorFrame();
		cellEditorFrame.setBorder(BORDER);
		return cellEditorFrame;
	}

	private void showFBInsertPopUpMenu() {
		final EditPartViewer viewer = getEditPart().getViewer();
		final MenuManager mgr = new MenuManager();
		((FBNetworkContextMenuProvider) viewer.getContextMenu()).buildFBInsertMenu(mgr, getLocator().getRefPoint(),
				useChangeFBType);
		final Menu menu = mgr.createContextMenu(viewer.getControl());
		menu.setVisible(true);
		// put the menu on top of the editor
		menu.setLocation(viewer.getControl().toDisplay(getLocator().getRefPoint()));
		// get rid of the editor
		getCellEditor().fireCancelEditor();
	}
}
