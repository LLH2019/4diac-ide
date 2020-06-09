package org.eclipse.fordiac.ide.model.commands.change;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

//see org.eclipse.fordiac.ide.util.ColorHelperTest.java for information on implementing tests

/**
 * Base class for testing commands. Sets up a undo/redo structure and a state
 * description
 *
 * @param <T> type of the state description, has to be derived from
 *            CommandTestBase.StateBase
 */
@RunWith(Parameterized.class)
public abstract class CommandTestBase<T extends CommandTestBase.StateBase> {

	/**
	 * Base type for state descriptions, used to structure class hierarchy
	 *
	 */
	protected interface StateBase {
	}

	/**
	 * functional interface for setting the initial state
	 *
	 */
	protected interface StateInitializer<T> {
		T initializeState();
	}

	/**
	 * functional interface for preparing infrastructure for commands
	 *
	 */
	protected interface CommandCreator<T> {
		void createCommand(T state);
	}

	/**
	 * functional interface for executing a state transition
	 *
	 */
	protected interface CommandExecutor<T> {
		T executeCommand(T state);
	}

	/**
	 * functional interface for verifying a state based on changes against the state
	 * before that step (oldState)
	 *
	 */
	protected interface StateVerifier<T> {
		boolean verifyState(T state, T oldState);
	}

	enum ExecutionType {
		COMMAND, UNDO, REDO
	}

	/**
	 * combination of functional interfaces for a state transition and verification
	 * of that transition
	 *
	 * @param <U> type of state description derived form StateBase
	 */
	protected static class ExecutionDescription<U extends StateBase> {
		final ExecutionType type;
		final CommandExecutor<U> executor;
		final StateVerifier<U> verifier;
		final String description;

		/**
		 * Constructor for creating a execution description with selectable Execution
		 * type, only used internally
		 *
		 * @param description textual description of the state transition
		 * @param type        COMMAND/UNDO/REDO as given by the enum
		 * @param executor    lambda/method reference to state transition method
		 * @param verifier    lambda/method reference to state verification method
		 */
		private ExecutionDescription(String description, ExecutionType type, CommandExecutor<U> executor,
				StateVerifier<U> verifier) {
			this.type = type;
			this.executor = executor;
			this.verifier = verifier;
			this.description = description;
		}

		/**
		 * Constructor for creating a execution description of type COMMAND
		 *
		 * @param description textual description of the state transition
		 * @param executor    lambda/method reference to state transition method
		 * @param verifier    lambda/method reference to state verification method
		 */
		public ExecutionDescription(String description, CommandExecutor<U> executor, StateVerifier<U> verifier) {
			this(description, ExecutionType.COMMAND, executor, verifier);
		}

		/**
		 * factory method to create a redo transition
		 *
		 * @return execution description that redoes a transition
		 */
		public static ExecutionDescription<? extends StateBase> redo() {
			return new ExecutionDescription<>("redo", ExecutionType.REDO, null, null);
		}

		/**
		 * factory method to create a undo transition
		 *
		 * @return execution description that undoes a transition
		 */
		public static ExecutionDescription<? extends StateBase> undo() {
			return new ExecutionDescription<>("undo", ExecutionType.UNDO, null, null);
		}

		/**
		 * Helper function to pack Objects into a Object[]
		 *
		 * @param vararg Objects
		 * @return Object[] with all Objects from varargs
		 */
		public static List<Object> commandList(Object... a) {
			return Arrays.asList(a);
		}
	}

	/**
	 * node for storing undo/redo information in a linked list
	 *
	 * @param <U> type of state description derived form StateBase
	 */
	protected class StateNode<U extends StateBase> {
		private final U state;
		private final StateVerifier<U> verifier;
		private StateNode<U> before;
		private StateNode<U> after = null;

		/**
		 * @return current state description
		 */
		public U getState() {
			return state;
		}

		/**
		 * @return current state verifier
		 */
		public StateVerifier<U> getVerifier() {
			return verifier;
		}

		/**
		 * @return get state before last state transition
		 */
		public StateNode<U> getBefore() {
			return null != before ? before : this;
		}

		/**
		 * @return get state from before the last undo operation
		 */
		public StateNode<U> getAfter() {
			return null != after ? after : this;
		}

		/**
		 * @param after set state from before the last undo operation
		 */
		public void setAfter(StateNode<U> after) {
			this.after = after;
		}

		/**
		 * @param state
		 * @param verifier
		 * @param before
		 */
		public StateNode(U state, StateVerifier<U> verifier, StateNode<U> before) {
			this.state = state;
			this.verifier = verifier;
			this.before = before;
		}

	}

	/**
	 * list of parameters for JUnit test case
	 */
	@Parameter(0)
	public String description;
	@Parameter(1)
	public StateInitializer<T> initializer;
	@Parameter(2)
	public StateVerifier<T> initialVerifier;
	@Parameter(3)
	public CommandCreator<T> creator;
	@Parameter(4)
	public Iterable<ExecutionDescription<T>> commands;
	@Parameter(5)
	public CommandExecutor<T> undo;
	@Parameter(6)
	public CommandExecutor<T> redo;

	/**
	 * Helper function to pack Objects into a Object[]
	 *
	 * @param vararg Objects
	 * @return Object[] with all Objects from varargs
	 */
	private static Object[] convert(Object... a) {
		return a;
	}

	/**
	 * method to describe a command to the class
	 *
	 * @param description     textual description of the command
	 * @param initializer     method to set initial state
	 * @param initialVerifier method to verify the initial state
	 * @param creator         method to prepare command infrastructure
	 * @param commands        list of commands and verifiers to be executed (use
	 *                        helper method commandList for creation)
	 * @param undo            state transition that undoes a command
	 * @param redo            state transition that redoes a command
	 * @return
	 */
	protected static Collection<Object[]> describeCommand(String description, StateInitializer<?> initializer,
			StateVerifier<?> initialVerifier, CommandCreator<?> creator, List<Object> commands, CommandExecutor<?> undo,
			CommandExecutor<?> redo) {
		List<Object[]> descriptions = new ArrayList<>();

		final String MESSAGE_MASTER = "{0} : {1}";
		final String MESSAGE_NO_MASTER = "{1}";

		final String MESSAGE_VERIFY_INITIAL_STATE = "Verify initial State";
		final String MESSAGE_EXECUTE_ALL_COMMANDS = "Execute all Commands";
		final String MESSAGE_EXECUTE_UNTIL_COMMAND_I = "Execute until Command {0}: {1}";
		final String MESSAGE_EXECUTE_UNTIL_COMMAND_I_UNDO = "Execute until Command {0}: {1}, run Undo";
		final String MESSAGE_EXECUTE_UNTIL_COMMAND_I_UNDO_REDO = "Execute until Command {0}: {1}, run Undo, run Redo";
		final String MESSAGE_EXECUTE_UNTIL_COMMAND_I_UNDO_REDO_ALL = "Execute all Commands interspersed with Undo and Redo";

		descriptions.add(convert(
				MessageFormat.format(null != description ? MESSAGE_MASTER : MESSAGE_NO_MASTER, description,
						MESSAGE_VERIFY_INITIAL_STATE),
				initializer, initialVerifier, creator, Collections.emptyList(), undo, redo));

		descriptions
				.add(convert(
						MessageFormat.format(null != description ? MESSAGE_MASTER : MESSAGE_NO_MASTER, description,
								MESSAGE_EXECUTE_ALL_COMMANDS),
						initializer, initialVerifier, creator, commands, undo, redo));

		int index = 0;
		ArrayList<Object> commandsUntil = new ArrayList<>();
		ArrayList<Object> commandsWithUndoRedo;
		ArrayList<Object> commandsWithUndoRedoAll = new ArrayList<>();
		for (Object commandObject : commands) {
			ExecutionDescription<?> command = (ExecutionDescription<?>) commandObject;
			index++;
			commandsUntil.add(command);
			commandsWithUndoRedoAll.add(command);
			commandsWithUndoRedo = new ArrayList<>();
			commandsWithUndoRedo.addAll(commandsUntil);
			descriptions.add(convert(
					MessageFormat.format(null != description ? MESSAGE_MASTER : MESSAGE_NO_MASTER, description,
							MessageFormat.format(MESSAGE_EXECUTE_UNTIL_COMMAND_I, index, command.description)),
					initializer, initialVerifier, creator, commandsWithUndoRedo.clone(), undo, redo));
			commandsWithUndoRedo.add(ExecutionDescription.undo());
			commandsWithUndoRedoAll.add(ExecutionDescription.undo());
			descriptions
					.add(convert(
							MessageFormat.format(null != description ? MESSAGE_MASTER : MESSAGE_NO_MASTER, description,
									MessageFormat.format(MESSAGE_EXECUTE_UNTIL_COMMAND_I_UNDO, index,
											command.description)),
							initializer, initialVerifier, creator, commandsWithUndoRedo.clone(), undo, redo));
			commandsWithUndoRedo.add(ExecutionDescription.redo());
			commandsWithUndoRedoAll.add(ExecutionDescription.redo());
			descriptions.add(convert(
					MessageFormat.format(null != description ? MESSAGE_MASTER : MESSAGE_NO_MASTER, description,
							MessageFormat.format(MESSAGE_EXECUTE_UNTIL_COMMAND_I_UNDO_REDO, index,
									command.description)),
					initializer, initialVerifier, creator, commandsWithUndoRedo.clone(), undo, redo));
		}
		descriptions.add(convert(
				MessageFormat.format(null != description ? MESSAGE_MASTER : MESSAGE_NO_MASTER, description,
						MESSAGE_EXECUTE_UNTIL_COMMAND_I_UNDO_REDO_ALL),
				initializer, initialVerifier, creator, commandsWithUndoRedoAll, undo, redo));
		return descriptions;

	}

	/**
	 * actual JUnit test case
	 *
	 * executes commands and adds redo/undo steps and adds a meaningful description
	 */
	@Test
	public void testCommand() {
		// prepare initial state and verify
		StateNode<T> current = new StateNode<>(initializer.initializeState(), initialVerifier, null);
		boolean isInitialStateVerified = initialVerifier.verifyState(current.getState(),
				current.getBefore().getState());

		// if there are more steps to be executed the initial verification is not
		// asserted but only assumed
		// execution of the test will therefore not fail on those commands due to
		// initial assumptions being wrong
		Iterator<ExecutionDescription<T>> iterator = commands.iterator();
		if (iterator.hasNext()) {
			assumeTrue(isInitialStateVerified);
		} else {
			assertTrue(isInitialStateVerified);
		}

		// prepare command infrastructure
		creator.createCommand(current.getState());

		// step through all the commands/undo/redo
		while (iterator.hasNext()) {
			ExecutionDescription<T> command = iterator.next();
			StateNode<T> state = null;
			boolean isVerified = false;
			switch (command.type) {
			case COMMAND:
				// execute command if available and verify
				if (null != command.executor) {
					state = new StateNode<>(command.executor.executeCommand(current.getState()), command.verifier,
							current);
					current.setAfter(state);
					current = state;
				}
				isVerified = command.verifier.verifyState(current.getState(), current.getBefore().getState());
				break;
			case UNDO:
				// execute undo and fix undo list
				state = new StateNode<>(undo.executeCommand(current.getState()), current.getBefore().getVerifier(),
						current.getBefore());
				state.setAfter(current);
				current = state;
				isVerified = current.getVerifier().verifyState(current.getState(), current.getBefore().getState());
				break;
			case REDO:
				// execute redo and fix undo list
				state = new StateNode<>(redo.executeCommand(current.getState()), current.getAfter().getVerifier(),
						current);
				current.setAfter(state);
				current = state;
				isVerified = current.getVerifier().verifyState(current.getState(), current.getBefore().getState());
				break;
			}
			// if there are more commands to be executed use assume instead of assert
			// same reason as for initial state verifier
			if (iterator.hasNext()) {
				assumeTrue(isVerified);
			} else {
				assertTrue(isVerified);
			}
		}
	}

}