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
package org.eclipse.fordiac.ide.model.commands.change;

import org.eclipse.fordiac.ide.model.data.BaseType1;
import org.eclipse.fordiac.ide.model.libraryElement.Attribute;
import org.eclipse.fordiac.ide.model.libraryElement.AttributeDeclaration;
import org.eclipse.gef.commands.Command;

public class AttributeChangeCommand extends Command {
	private Attribute attribute;
	private AttributeDeclaration attributeDeclaration;
	private String name;
	private String nameOld;
	private String value;
	private String valueOld;
	private String comment;
	private String commentOld;
	private BaseType1 type;
	private BaseType1 typeOld;
	
	public AttributeChangeCommand(Object attribute, String name, String value, BaseType1 type, String comment) {
		if(attribute instanceof Attribute) {			
			this.attribute = (Attribute) attribute;
		}
		if(attribute instanceof AttributeDeclaration) {			
			this.attributeDeclaration = (AttributeDeclaration) attribute;
		}
		this.comment = comment;
		this.value = value;
		this.name = name;
		this.type = type;
	}
	
	@Override
	public boolean canExecute() {
		return (null != attribute || null != attributeDeclaration)
				&& (null != name || null != value || null != comment || (null == attribute.getAttributeDeclaration() && null != type));
	}

	@Override
	public void execute() {
		if(null != attribute) {			
			nameOld = attribute.getName();
			valueOld = attribute.getValue();
			commentOld = attribute.getComment();
			typeOld = attribute.getType();
		}
		if(null != attributeDeclaration) {			
			nameOld = attributeDeclaration.getName();
			valueOld = attributeDeclaration.getInitialValue();
			commentOld = attributeDeclaration.getComment();
			typeOld = attributeDeclaration.getType();
		}
		redo();
	}

	@Override
	public void undo() {
		if(null != attribute) {					
			if(null != name) {			
				attribute.setName(nameOld);
			}
			if(null != comment) {			
				attribute.setComment(commentOld);
			}
			if(null != value) {			
				attribute.setValue(valueOld);
			}
			if(null != type) {			
				attribute.setType(typeOld);
			}
			return;
		}
		if(null != attributeDeclaration) {					
			if(null != name) {			
				attributeDeclaration.setName(nameOld);
			}
			if(null != comment) {			
				attributeDeclaration.setComment(commentOld);
			}
			if(null != value) {			
				attributeDeclaration.setInitialValue(valueOld);
			}
			if(null != type) {			
				attributeDeclaration.setType(typeOld);
			}
		}
	}

	@Override
	public void redo() {
		if(null != attribute) {					
			if(null != name) {			
				attribute.setName(name);
			}
			if(null != comment) {			
				attribute.setComment(comment);
			}
			if(null != value) {			
				attribute.setValue(value);
			}
			if(null != type) {			
				attribute.setType(type);
			}
			return;
		}
		if(null != attributeDeclaration) {					
			if(null != name) {			
				attributeDeclaration.setName(name);
			}
			if(null != comment) {			
				attributeDeclaration.setComment(comment);
			}
			if(null != value) {			
				attributeDeclaration.setInitialValue(value);
			}
			if(null != type) {			
				attributeDeclaration.setType(type);
			}
		}
	}

}
