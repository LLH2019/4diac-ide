/*******************************************************************************
 * Copyright (c) 2020 TU Wien
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Martin Melik Merkumians
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.program.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.fordiac.ide.application.editparts.AbstractFBNElementEditPart;
import org.eclipse.fordiac.ide.application.editparts.FBEditPart;
import org.eclipse.fordiac.ide.application.editparts.InstanceName;
import org.eclipse.fordiac.ide.application.figures.FBNetworkElementFigure;
import org.eclipse.fordiac.ide.gef.draw2d.AdvancedRoundedRectangle;
import org.eclipse.fordiac.ide.model.libraryElement.FBNetworkElement;
import org.eclipse.fordiac.ide.model.libraryElement.FBType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

public class IEC61131FBEditPart extends FBEditPart {

	@Override
	protected List<Object> getModelChildren() {
		// In iec 61131 FB Networks we only want to see data in and outputs
		ArrayList<Object> elements = new ArrayList<>();
		elements.add(new InstanceName(getModel()));
		elements.addAll(getModel().getInterface().getInputVars());
		elements.addAll(getModel().getInterface().getOutputVars());
		return elements;
	}

	@Override
	protected IFigure createFigureForModel() {
		// extend this if FunctionBlock gets extended!
		return new IEC61131FBFigure(getModel(), this);
	}

	private class IEC61131FBFigure extends FBNetworkElementFigure {

		public IEC61131FBFigure(FBNetworkElement model, AbstractFBNElementEditPart editPart) {
			super(model, editPart);
		}

		@Override
		protected void createFBTop(Figure fbFigureContainer, int cornerDim, Color borderColor) {
			setTop(new AdvancedRoundedRectangle(
					PositionConstants.NORTH | PositionConstants.EAST | PositionConstants.WEST,
					AdvancedRoundedRectangle.TOP_LEFT | AdvancedRoundedRectangle.TOP_RIGHT, borderColor));
			getTop().setCornerDimensions(new Dimension(cornerDim, cornerDim));

			GridLayout topLayout = new GridLayout(2, false);
			topLayout.marginHeight = 4;
			topLayout.marginWidth = 0;
			topLayout.horizontalSpacing = 0;
			topLayout.verticalSpacing = 0;
			getTop().setLayoutManager(topLayout);

			fbFigureContainer.add(getTop());
			GridData topLayoutData = new GridData(
					GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL);
			fbFigureContainer.setConstraint(getTop(), topLayoutData);
		}

		@Override
		protected void configureFBMiddle(FBType fbType, Figure fbFigureContainer, Color borderColor) {
			AdvancedRoundedRectangle middleContainer = new AdvancedRoundedRectangle(
					PositionConstants.NORTH | PositionConstants.EAST | PositionConstants.WEST,
					AdvancedRoundedRectangle.TOP_LEFT | AdvancedRoundedRectangle.TOP_RIGHT, borderColor);
			middleContainer.setCornerDimensions(new Dimension(7, 7));
			BorderLayout borderLayout = new BorderLayout();
			middleContainer.setLayoutManager(borderLayout);
			borderLayout.setHorizontalSpacing(0);

			fbFigureContainer.add(middleContainer);
			GridData middleLayouData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
			fbFigureContainer.setConstraint(middleContainer, middleLayouData);

			setupTypeNameAndVersion(fbType, middleContainer, borderColor);
		}

		@Override
		protected void createFBBottom(Figure fbFigureContainer, int cornerDim, Color borderColor) {
			AdvancedRoundedRectangle bottom = new AdvancedRoundedRectangle(
					PositionConstants.SOUTH | PositionConstants.EAST | PositionConstants.WEST,
					AdvancedRoundedRectangle.BOTTOM_LEFT | AdvancedRoundedRectangle.BOTTOM_RIGHT, borderColor);

			setBottom(bottom);

			bottom.setCornerDimensions(new Dimension(cornerDim, cornerDim));
			GridLayout bottomLayout = new GridLayout(2, false);
			bottomLayout.marginHeight = 4;
			bottomLayout.marginWidth = 0;
			bottomLayout.horizontalSpacing = 0;
			bottomLayout.verticalSpacing = 0;
			bottom.setLayoutManager(bottomLayout);

			GridData bottomLayoutData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL
					| GridData.VERTICAL_ALIGN_FILL | GridData.GRAB_VERTICAL);
			bottomLayoutData.verticalAlignment = SWT.TOP;

			fbFigureContainer.add(bottom);
			fbFigureContainer.setConstraint(bottom, bottomLayoutData);

			setBottomIOs(bottom);
		}
	}
}
