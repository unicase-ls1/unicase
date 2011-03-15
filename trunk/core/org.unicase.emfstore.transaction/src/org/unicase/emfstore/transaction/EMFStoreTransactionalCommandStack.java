/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.transaction;


import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.changeTracking.commands.CommandObserver;
import org.unicase.workspace.changeTracking.commands.EMFStoreCommandNotifier;
import org.unicase.workspace.changeTracking.commands.EMFStoreCommandStack;
import org.unicase.workspace.util.AbstractUnicaseCommand;

/**
 * Command Stack with additional support for command listing.
 * 
 * @author koegel
 */
public class EMFStoreTransactionalCommandStack extends TransactionalCommandStackImpl implements EMFStoreCommandStack {

	private Command currentCommand;
	private EMFStoreCommandNotifier notifier;

	/**
	 * Dafault Constructor.
	 */
	public EMFStoreTransactionalCommandStack() {
		notifier = new EMFStoreCommandNotifier();
	}

	@Override
	public void execute(final Command command) {
		//handle Unicase commands
		if (command instanceof AbstractUnicaseCommand) {
			runUnicaseCommand((AbstractUnicaseCommand) command);
			return;
		}
		super.execute(command);
	}

	private void runUnicaseCommand(final AbstractUnicaseCommand unicaseCommand) {
		//wrap UNICASECommands in RecordingCommands
		RecordingCommand recordingCommand = new RecordingCommand((TransactionalEditingDomain) Configuration.getEditingDomain()) {
			@Override
			protected void doExecute() {
				unicaseCommand.execute();
			}
		};
		super.execute(recordingCommand);
		
		//rethrow runtime exceptions if neccessary
		if (!unicaseCommand.shouldIgnoreExceptions() && unicaseCommand.getRuntimeException()!=null) {
			throw unicaseCommand.getRuntimeException();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.impl.AbstractTransactionalCommandStack#basicExecute(org.eclipse.emf.common.command.Command)
	 */
	@Override
	protected void basicExecute(Command command) {
		// Notify about the command started!
		// check if we are already inside of a command, if not then notify.
		if (currentCommand == null) {
			currentCommand = command;
			notifier.notifiyListenersAboutStart(command);
		}

		try {
			super.basicExecute(command);
		} catch (OperationCanceledException e) {
			notifier.notifiyListenersAboutCommandFailed(command, e);
			this.currentCommand = null;
			throw e;
		}

		// Notify someone that the command is done.
		// Check if we are really at the end of the most outer command.
		if (currentCommand == command) {
			// check again if command was really completed.
			if (mostRecentCommand == command) {
				notifier.notifiyListenersAboutCommandCompleted(command);
			}
			currentCommand = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl#handleRollback(org.eclipse.emf.common.command.Command,
	 *      org.eclipse.emf.transaction.RollbackException)
	 */
	@Override
	protected void handleRollback(Command command, RollbackException rbe) {
		super.handleRollback(command, rbe);
		notifier.notifiyListenersAboutCommandFailed(command, (rbe.getCause() != null) ? (Exception) rbe.getCause()
			: rbe);

		if (currentCommand == command) {
			currentCommand = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.changeTracking.commands.EMFStoreCommandStack#addCommandStackObserver(org.unicase.workspace.changeTracking.commands.CommandObserver)
	 */
	public void addCommandStackObserver(CommandObserver observer) {
		notifier.addCommandStackObserver(observer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.changeTracking.commands.EMFStoreCommandStack#removeCommandStackObserver(org.unicase.workspace.changeTracking.commands.CommandObserver)
	 */
	public void removeCommandStackObserver(CommandObserver observer) {
		notifier.removeCommandStackObserver(observer);
	}
}
