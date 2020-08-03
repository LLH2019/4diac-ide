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
 *   Lisa Sonnleithner
 *     - initial API and implementation and/or initial documentation
 *******************************************************************************/

package org.eclipse.fordiac.ide.model.commands.testinfra;

import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.fordiac.ide.model.libraryElement.LibraryElementFactory;
import org.eclipse.fordiac.ide.model.libraryElement.VarDeclaration;
import org.eclipse.gef.commands.Command;

public abstract class ValueCommandTestBase extends CommandTestBase<ValueCommandTestBase.State> {

	private static final String SET_VALUE = "default";

	// create a state description that fits our purpose
	public static class State implements CommandTestBase.StateBase {
		private VarDeclaration var = LibraryElementFactory.eINSTANCE.createVarDeclaration();

		State() {
			super();
			var.setValue(LibraryElementFactory.eINSTANCE.createValue());
		}

		// private String value = "";
		private Command cmd;

		public VarDeclaration getVar() {
			return var;
		}

		public Command getCommand() {
			return cmd;
		}

		public void setCommand(Command cmd) {
			this.cmd = cmd;
		}

		@Override
		public Object getClone() {
			return new State();
		}
	}

	protected static State undoCommand(Object stateObj) {
		State state = (State) stateObj;
		assumeTrue(state.getCommand().canUndo());
		state.getCommand().undo();
		return (state);
	}

	protected static State redoCommand(Object stateObj) {
		State state = (State) stateObj;
		assumeTrue(state.getCommand().canRedo());
		state.getCommand().redo();
		return (state);
	}

	protected static Collection<Object[]> describeCommand(String description, StateInitializer<?> initializer,
			StateVerifier<?> initialVerifier, List<Object> commands) {
		return describeCommand(description, initializer, initialVerifier, commands, ValueCommandTestBase::undoCommand,
				ValueCommandTestBase::redoCommand);
	}

	protected static List<Object[]> createCommands(List<Object> executionDescriptions) {
		List<Object[]> commands = new ArrayList<>();

		commands.addAll(describeCommand("Start from default values", //
				State::new, //
				(State state, State oldState, TestFunction t) -> verifyDefaultInitialValues(state, oldState, t), //
				executionDescriptions //
		));

		commands.addAll(describeCommand("Start from set values", //
				() -> setInitialValues(), //
				(State state, State oldState, TestFunction t) -> verifySetInitialValues(state, oldState, t), //
				executionDescriptions //
		));
		return commands;
	}

	protected static void verifyDefaultInitialValues(State state, State oldState, TestFunction t) {
		final VarDeclaration varDec = LibraryElementFactory.eINSTANCE.createVarDeclaration();
		varDec.setValue(LibraryElementFactory.eINSTANCE.createValue());

		final String DEFAULT_VALUE = varDec.getValue().getValue();

		t.test(state.getVar().getValue().getValue().equals(DEFAULT_VALUE));
	}

	protected static State setInitialValues() {
		State state = new State();
		state.getVar().getValue().setValue(SET_VALUE);
		return state;
	}

	protected static void verifySetInitialValues(State state, State oldState, TestFunction t) {
		t.test(state.getVar().getValue().getValue().equals(SET_VALUE));

	}

}