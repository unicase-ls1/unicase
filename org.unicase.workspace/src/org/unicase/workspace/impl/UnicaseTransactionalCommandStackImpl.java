package org.unicase.workspace.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.eclipse.emf.transaction.util.ConditionalRedoCommand;

public class UnicaseTransactionalCommandStackImpl extends TransactionalCommandStackImpl implements
	CommandStackChangedListener {

	private Command commandCache;

	@Override
	public void commandEnded(Command command) {
		if (!(listeners == null)) {
			for (CommandObserver commandObservers : listeners) {
				commandObservers.commandEnded(command);
			}
		}
	}

	@Override
	public void commandStarted(Command command) {
		if (!(listeners == null)) {
			for (CommandObserver commandObservers : listeners) {
				commandObservers.commandStarted(command);
			}
		}
	}

	@Override
	protected void basicExecute(Command command) {
		boolean completed = false;
		// Notify about the command started!
		if (command instanceof AbstractCommand) {
			if (commandCache == null) {
				commandCache = command;
				this.commandStarted(command);

			}
		}

		try {
			super.basicExecute(command);
		} catch (OperationCanceledException e) {
			this.commandFailed(command);
			this.commandCache = null;
			throw e;
		}
		// Notify someone that the command is done.
		if (command instanceof AbstractCommand) {
			if (commandCache == command) {
				if ((completed = mostRecentCommand == command)) {
					commandCache = null;
					this.commandEnded(command);
				} else {
					commandCache = null;
				}
			}
		}
	}

	private void commandFailed(Command command) {
		if (!(listeners == null)) {
			for (CommandObserver commandObservers : listeners) {
				commandObservers.commandFailed(command);
			}
		}

	}

	/**
	 * Initializes me.
	 */
	public UnicaseTransactionalCommandStackImpl() {

		super();
		listeners = new ArrayList<CommandObserver>();
	}

	/**
	 * The {@link CommandStackListener}s.
	 */
	protected Collection<CommandObserver> listeners;

	/**
	 * {@inheritDoc}
	 * 
	 * @since 1.1
	 */
	@Override
	protected void doExecute(Command command, Map<?, ?> options) throws InterruptedException, RollbackException {
		InternalTransaction tx = createTransaction(command, options);
		boolean completed = false;

		try {

			basicExecute(command);

			// new in EMF 2.4: AbortExecutionException can cause the
			// command not to be added to the undo stack
			completed = mostRecentCommand == command;

			// commit the transaction now
			tx.commit();

		} catch (OperationCanceledException e) {
			// snuff the exception, because this is expected (user asked to
			// cancel the model change). We will rollback, below
		} finally {
			if ((tx != null) && (tx.isActive())) {
				// roll back (some exception, possibly being thrown now or
				// an operation cancel, has occurred)
				rollback(tx);
				handleRollback(command, null);
			} else {
				// the transaction has already incorporated the triggers
				// into its change description, so the recording command
				// doesn't need them again
				if (!(command instanceof RecordingCommand) && completed) {
					Command triggerCommand = tx.getTriggers();

					if (triggerCommand != null) {
						// replace the executed command by a compound of the
						// original and the trigger commands
						CompoundCommand compound = new ConditionalRedoCommand.Compound();
						compound.append(mostRecentCommand);
						compound.append(triggerCommand);
						mostRecentCommand = compound;
						commandList.set(top, mostRecentCommand);
					}
				}
			}
		}
	}

	/*
	 * Javadoc adds the listener
	 */
	public void addCommandStackListener(CommandObserver observer) {
		listeners.add(observer);
	}

	/*
	 * Javadoc remove the listener
	 */
	public void removeCommandStackListener(CommandObserver observer) {
		listeners.remove(observer);
	}

}
