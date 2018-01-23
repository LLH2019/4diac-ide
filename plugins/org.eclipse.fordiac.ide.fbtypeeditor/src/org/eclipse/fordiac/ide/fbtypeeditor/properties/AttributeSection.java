/*******************************************************************************
 * Copyright (c) 2017 fortiss GmbH
 * 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 3
 *******************************************************************************/
package org.eclipse.fordiac.ide.fbtypeeditor.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.fbtypeeditor.editors.FBTypeEditor;
import org.eclipse.fordiac.ide.fbtypeeditor.editparts.InterfaceEditPart;
import org.eclipse.fordiac.ide.gef.properties.AbstractAttributeSection;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class AttributeSection extends AbstractAttributeSection {
	
	public void createControls(final Composite parent, final TabbedPropertySheetPage tabbedPropertySheetPage) {
		isInheritable = true;
		super.createControls(parent, tabbedPropertySheetPage);	
	}
	
	protected IInterfaceElement getInputType(Object input) {
		if(input instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) input).getCastedModel();
		}
		return null;
	}

	@Override
	protected EObject getType() {
		if(type instanceof IInterfaceElement){
			return (IInterfaceElement) type;
		}
		return null;
	}
	
	@Override
	protected CommandStack getCommandStack(IWorkbenchPart part, Object input) {
		if(part instanceof FBTypeEditor){
			return ((FBTypeEditor)part).getCommandStack();
		}
		return null;
	}
}
