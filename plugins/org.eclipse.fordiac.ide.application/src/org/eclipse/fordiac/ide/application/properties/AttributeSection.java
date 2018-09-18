/*******************************************************************************
 * Copyright (c) 2017 fortiss GmbH
 * 
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 3
 *******************************************************************************/
package org.eclipse.fordiac.ide.application.properties;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.fordiac.ide.application.editparts.FBNetworkEditPart;
import org.eclipse.fordiac.ide.gef.editparts.InterfaceEditPart;
import org.eclipse.fordiac.ide.gef.properties.AbstractAttributeSection;
import org.eclipse.fordiac.ide.model.libraryElement.Application;
import org.eclipse.fordiac.ide.model.libraryElement.ConfigurableObject;
import org.eclipse.fordiac.ide.model.libraryElement.IInterfaceElement;

public class AttributeSection extends AbstractAttributeSection {

	@Override
	protected ConfigurableObject getInputType(Object input) {
		if(input instanceof FBNetworkEditPart){
			return ((FBNetworkEditPart) input).getModel().getApplication();
		}
		if(input instanceof InterfaceEditPart) {
			return ((InterfaceEditPart) input).getModel();
		}
		return null;
	}

	@Override
	protected EObject getType() {
		if(type instanceof Application){
			return (Application) type;
		}
		if(type instanceof IInterfaceElement){
			return (IInterfaceElement) type;
		}
		return null;
	}
}
