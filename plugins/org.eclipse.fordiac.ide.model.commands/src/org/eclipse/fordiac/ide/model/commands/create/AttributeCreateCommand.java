/*******************************************************************************
 * Copyright (c) 2017 fortiss GmbH
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Monika Wenger
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.commands.create;

import org.eclipse.fordiac.ide.model.libraryElement.Attribute;
import org.eclipse.fordiac.ide.model.libraryElement.AttributeDeclaration;
import org.eclipse.fordiac.ide.model.libraryElement.ConfigurableObject;
import org.eclipse.fordiac.ide.model.libraryElement.InheritableAttribute;
import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.gef.commands.Command;

public class AttributeCreateCommand extends Command {
	private Object configurableObject;
	private Attribute attribute;
	private AttributeDeclaration attributeDeclaration;
	private boolean isInheritable;

	public AttributeCreateCommand(Object configurableObject, boolean isInheritable) {
		this.configurableObject = configurableObject;
		this.isInheritable = isInheritable;
	}
	
	@Override
	public boolean canExecute() {
		return null != configurableObject;
	}

	@Override
	public void execute() {
		if(isInheritable) {			
			attributeDeclaration = LibraryElementFactory.eINSTANCE.createAttributeDeclaration();
			attributeDeclaration.setName("name");
			attributeDeclaration.setComment("comment");
			attributeDeclaration.setInitialValue("value");
		}else {
			attribute = LibraryElementFactory.eINSTANCE.createAttribute();
			attribute.setName("name");
			attribute.setComment("comment");
			attribute.setValue("value");
		}
		redo();
	}

	@Override
	public void undo() {
		if(isInheritable) {					
			((InheritableAttribute)configurableObject).getAttributeDeclarations().remove(attributeDeclaration);
		}else {
			((ConfigurableObject)configurableObject).getAttributes().remove(attribute);
		}
	}

	@Override
	public void redo() {
		if(isInheritable) {					
			((InheritableAttribute)configurableObject).getAttributeDeclarations().add(attributeDeclaration);	
		}else {
			((ConfigurableObject)configurableObject).getAttributes().add(attribute);
		}
	}

}
