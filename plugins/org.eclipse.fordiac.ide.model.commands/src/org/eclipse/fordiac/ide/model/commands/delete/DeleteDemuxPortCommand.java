/*******************************************************************************
 * Copyright (c) 2020 Primetals Technologies Germany GmbH
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: Bianca Wiesmayr - initial implementation and documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.commands.delete;

import static org.eclipse.fordiac.ide.model.LibraryElementTags.DEMUX_VISIBLE_CHILDREN;
import static org.eclipse.fordiac.ide.model.LibraryElementTags.VARIABLE_SEPARATOR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.fordiac.ide.model.FordiacKeywords;
import org.eclipse.fordiac.ide.model.LibraryElementTags;
import org.eclipse.fordiac.ide.model.StructManipulation;
import org.eclipse.fordiac.ide.model.commands.change.ChangeStructCommand;
import org.eclipse.fordiac.ide.model.data.DataFactory;
import org.eclipse.fordiac.ide.model.data.StructuredType;
import org.eclipse.fordiac.ide.model.libraryElement.Demultiplexer;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.gef.commands.Command;

public class DeleteDemuxPortCommand extends Command {

	private Demultiplexer type;
	private final VarDeclaration var;
	private final String name;
	private String oldVisibleChildren;
	private String newVisibleChildren;
	private StructuredType configuredStruct; // contains the required ports
	private ChangeStructCommand cmd;
	private Demultiplexer oldMux;

	public DeleteDemuxPortCommand(Demultiplexer type, String name) {
		this.type = type;
		this.name = name;
		this.var = (VarDeclaration) type.getInterfaceElement(name);
		this.oldVisibleChildren = type.getAttributeValue(DEMUX_VISIBLE_CHILDREN);
	}

	private String getNewAttributeValue() {
		if (null == oldVisibleChildren) {
			final StringBuilder sb = new StringBuilder();
			type.getStructType().getMemberVariables().forEach(var -> sb.append(var.getName() + VARIABLE_SEPARATOR));
			if (!type.getStructType().getMemberVariables().isEmpty()) {
				sb.deleteCharAt(sb.length() - 1);
			}
			oldVisibleChildren = sb.toString();
		}
		return cutVarFromAttribute();
	}

	private String cutVarFromAttribute() {
		final int startIndex = oldVisibleChildren.indexOf(name);
		if ((startIndex == -1) || (oldVisibleChildren.length() == name.length())) {
			return ""; //$NON-NLS-1$
		}
		final int endIndex = startIndex + name.length();
		final StringBuilder sb = new StringBuilder(oldVisibleChildren);
		sb.delete(startIndex, endIndex);
		if (sb.charAt(sb.length() - 1) == ',') {
			return sb.substring(0, sb.length() - 1);
		}
		if (sb.charAt(0) == ',') {
			return sb.substring(1);
		}
		return sb.toString();
	}

	@Override
	public void execute() {
		newVisibleChildren = getNewAttributeValue();
		createChangeStructCommand();
		cmd.execute();
		oldMux = type;
		type = (Demultiplexer) cmd.getNewMux();
		setVisibleChildrenAttribute(newVisibleChildren);
	}

	private void createChangeStructCommand() {
		configuredStruct = DataFactory.eINSTANCE.createStructuredType();
		configuredStruct.setName(type.getStructType().getName());
		final List<String> visibleChildrenNames = Arrays
				.asList(newVisibleChildren.trim().split(LibraryElementTags.VARIABLE_SEPARATOR));
		configuredStruct.getMemberVariables().addAll(EcoreUtil.copyAll(getVarDeclarations(visibleChildrenNames)));
		cmd = new ChangeStructCommand(type, configuredStruct);
	}

	@Override
	public boolean canExecute() {
		return var != null;
	}

	@Override
	public void redo() {
		cmd.redo();
		type = (Demultiplexer) cmd.getNewMux();
		setVisibleChildrenAttribute(newVisibleChildren);
	}

	@Override
	public void undo() {
		type = oldMux;
		cmd.undo();
		setVisibleChildrenAttribute(oldVisibleChildren);
	}

	private void setVisibleChildrenAttribute(String value) {
		type.setAttribute(DEMUX_VISIBLE_CHILDREN, FordiacKeywords.STRING, value, ""); //$NON-NLS-1$
	}

	private Collection<VarDeclaration> getVarDeclarations(List<String> varDeclNames) {
		final List<VarDeclaration> vars = new ArrayList<>();
		varDeclNames.forEach(name -> {
			final VarDeclaration varDecl = EcoreUtil
					.copy(StructManipulation.findVarDeclarationInStruct(type.getStructType(), name));
			if (null != varDecl) {
				varDecl.setName(name);
				vars.add(varDecl);
			}
		});
		return vars;
	}

	public Demultiplexer getType() {
		return type;
	}

}
