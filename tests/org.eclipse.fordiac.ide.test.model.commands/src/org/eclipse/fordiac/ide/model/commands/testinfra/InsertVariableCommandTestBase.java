/*******************************************************************************
 * Copyright (c) 2020 Johannes Kepler University
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Daniel Lindhuber
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/
package org.eclipse.fordiac.ide.model.commands.testinfra;

import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.fordiac.ide.model.data.DataFactory;
import org.eclipse.fordiac.ide.model.data.StructuredType;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.gef.commands.Command;

public abstract class InsertVariableCommandTestBase extends CommandTestBase<InsertVariableCommandTestBase.State> {

	private static StructuredType struct = DataFactory.eINSTANCE.createStructuredType();

	public static class State implements CommandTestBase.StateBase {
		private final EList<VarDeclaration> list;
		private VarDeclaration varDec;

		private Command cmd;

		public State() {
			list = struct.getMemberVariables();
			list.clear();
		}

		private State(State s) {
			list = s.list;
			varDec = s.varDec;
		}

		@Override
		public Object getClone() {
			return new State(this);
		}

		public VarDeclaration getVarDec() {
			return varDec;
		}

		public void setVarDec(VarDeclaration varDec) {
			this.varDec = varDec;
		}

		public EList<VarDeclaration> getList() {
			return list;
		}

		public Command getCommand() {
			return cmd;
		}

		public void setCommand(Command cmd) {
			this.cmd = cmd;
		}
	}

	protected static State undoCommand(Object stateObj) {
		final State state = (State) stateObj;
		assumeTrue(state.getCommand().canUndo());
		state.getCommand().undo();
		return (state);
	}

	protected static State redoCommand(Object stateObj) {
		final State state = (State) stateObj;
		assumeTrue(state.getCommand().canRedo());
		state.getCommand().redo();
		return (state);
	}

	protected static List<Object[]> createCommands(List<Object> executionDescriptions) {
		final List<Object[]> commands = new ArrayList<>();

		commands.addAll(describeCommand("Start from default values", //
				State::new, //
				(State state, State oldState, TestFunction t) -> verifyDefaultInitialValues(state, oldState, t), //
				executionDescriptions //
		));

		return commands;
	}

	protected static Collection<Object[]> describeCommand(String description, StateInitializer<?> initializer,
			StateVerifier<?> initialVerifier, List<Object> commands) {
		return describeCommand(description, initializer, initialVerifier, commands,
				InsertVariableCommandTestBase::undoCommand, InsertVariableCommandTestBase::redoCommand);
	}

	protected static void verifyDefaultInitialValues(State state, State oldState, TestFunction t) {
		t.test(state.getList().isEmpty());
	}

	protected static boolean validateVarDeclaration(VarDeclaration newVar, VarDeclaration oldVar) {
		/*
		 * can not check the name because if it is already taken a unique one will be
		 * generated
		 */
		if (newVar.getType() != oldVar.getType()) {
			return false;
		}
		if (!newVar.getComment().equals(oldVar.getComment())) {
			return false;
		}
		if (newVar.getArraySize() != oldVar.getArraySize()) {
			return false;
		}
		return true;
	}

}