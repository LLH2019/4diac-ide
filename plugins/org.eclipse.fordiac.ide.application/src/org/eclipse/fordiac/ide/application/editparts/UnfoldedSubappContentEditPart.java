/*******************************************************************************
 * Copyright (c) 2020 Primetals Technologies Germany GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Bianca Wiesmayr, Alois Zoitl
 *      - initial implementation and/or documentation
 *   Alexander Lumplecker, Bianca Wiesmayr, Alois Zoitl
 *   	- Bug: 568569
 *******************************************************************************/

package org.eclipse.fordiac.ide.application.editparts;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.fordiac.ide.application.policies.FBNetworkXYLayoutEditPolicy;
import org.eclipse.fordiac.ide.gef.editparts.ValueEditPart;
import org.eclipse.fordiac.ide.gef.policies.ModifiedNonResizeableEditPolicy;
import org.eclipse.fordiac.ide.model.commands.change.SetPositionCommand;
import org.eclipse.fordiac.ide.model.helpers.FBNetworkHelper;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementPackage;
import org.eclipse.fordiac.ide.model.libraryElement.PositionableElement;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.swt.graphics.Point;

public class UnfoldedSubappContentEditPart extends FBNetworkEditPart {
	private Point p;
	private Adapter adapter = new EContentAdapter() {
		@Override
		public void notifyChanged(final Notification notification) {
			
			Object feature = notification.getFeature();
			if (LibraryElementPackage.eINSTANCE.getPositionableElement_X().equals(feature) ||
					LibraryElementPackage.eINSTANCE.getPositionableElement_Y().equals(feature)) {
				p = FBNetworkHelper.getTopLeftCornerOfFBNetwork(getModel().getNetworkElements());
				getChildren().forEach(ep->((EditPart)ep).refresh());
			} else {
				super.notifyChanged(notification);
			}
		}
	};

	@Override
	public void setModel(Object model) {
		super.setModel(model);
		p = FBNetworkHelper.getTopLeftCornerOfFBNetwork(getModel().getNetworkElements());
	}
	
	@Override
	public void activate() {
		if (!isActive()) {
			super.activate();
			((Notifier) getModel()).eAdapters().add(adapter);
		}
	}
	
	@Override
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			((Notifier) getModel()).eAdapters().remove(adapter);

		}
	}
	
	@Override
	public void installEditPolicy(Object key, EditPolicy editPolicy) {
		if (!(editPolicy instanceof ModifiedNonResizeableEditPolicy)) {
			super.installEditPolicy(key, editPolicy);
		} else {
			// install an selection editpolicy which is forwarding selection requests to
			// parents
			super.installEditPolicy(key, new ModifiedNonResizeableEditPolicy() {

				@Override
				public EditPart getTargetEditPart(Request request) {
					return getParent().getTargetEditPart(request);
				}
			});
		}
	}

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
		// handles constraint changes of model elements and creation of new
		// model elements
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new FBNetworkXYLayoutEditPolicy() {
			@Override
			protected Command createChangeConstraintCommand(final ChangeBoundsRequest request, final EditPart child,
					final Object constraint) { // TODO constraint ist die neue Position, irgendwie Deltaposition
				// ausrechnen?
				// return a command that can move a "ViewEditPart"
				if ((child.getModel() instanceof PositionableElement) && (constraint instanceof Rectangle)) {
					Rectangle constraintRect = (Rectangle) constraint;
					constraintRect.x += p.x;
					constraintRect.y += p.y;

					return new SetPositionCommand((PositionableElement) child.getModel(), request,
							(Rectangle) constraint);
				}
				return null;
			}
		});
	}

	@Override
	protected IFigure createFigure() {
		final int BORDER_WIDTH = 10;
		final Insets BORDER_INSET = new Insets(BORDER_WIDTH);

		IFigure figure = new Figure() {
			@Override
			public Dimension getPreferredSize(int wHint, int hHint) {
				Dimension dim = super.getPreferredSize(wHint, hHint);
				return dim;
			}
		};

		figure.setOpaque(false);
		figure.setBorder(new MarginBorder(BORDER_INSET));

		figure.setLayoutManager(new XYLayout() {
			@Override
			public Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
				return super.calculatePreferredSize(container, wHint, hHint);
			}

		});
		return figure;
	}

	@Override
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		if (constraint instanceof Rectangle) {
			Rectangle rectConstraint = (Rectangle) constraint;
			if (child instanceof ValueEditPart) {
				rectConstraint.performTranslate(-getFigure().getBounds().x, -getFigure().getBounds().y);
			} else {
				rectConstraint.performTranslate(-p.x, -p.y);
			}
		}
		super.setLayoutConstraint(child, childFigure, constraint);

	}
}
