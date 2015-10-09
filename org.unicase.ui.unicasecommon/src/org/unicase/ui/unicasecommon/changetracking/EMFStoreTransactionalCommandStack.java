/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.changetracking;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.emfstore.client.changetracking.ESCommandObserver;
import org.eclipse.emf.emfstore.client.changetracking.ESCommandStack;
import org.eclipse.emf.emfstore.internal.client.model.ESWorkspaceProviderImpl;
import org.eclipse.emf.emfstore.internal.client.model.changeTracking.commands.EMFStoreCommandNotifier;
import org.eclipse.emf.emfstore.internal.client.model.util.AbstractEMFStoreCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;

public class EMFStoreTransactionalCommandStack extends
		TransactionalCommandStackImpl implements ESCommandStack {

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
		// handle EMFStore commands
		if (command instanceof AbstractEMFStoreCommand) {
			runEMFStoreCommand((AbstractEMFStoreCommand) command);
			return;
		}
		super.execute(command);
	}

	private void runEMFStoreCommand(final AbstractEMFStoreCommand cmd) {
		// wrap EMFStoreCommands in RecordingCommands
		RecordingCommand recordingCommand = new RecordingCommand(
				(TransactionalEditingDomain) ESWorkspaceProviderImpl
						.getInstance().getEditingDomain()) {
			@Override
			protected void doExecute() {
				cmd.execute();
			}
		};
		super.execute(recordingCommand);

		// rethrow runtime exceptions if neccessary
		if (!cmd.shouldIgnoreExceptions() && cmd.getRuntimeException() != null) {
			throw cmd.getRuntimeException();
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
		notifier.notifiyListenersAboutCommandFailed(command,
				(rbe.getCause() != null) ? (Exception) rbe.getCause() : rbe);

		if (currentCommand == command) {
			currentCommand = null;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.EMFStoreCommandStack#addCommandStackObserver(org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver)
	 */
	public void addCommandStackObserver(ESCommandObserver observer) {
		notifier.addCommandStackObserver(observer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.EMFStoreCommandStack#removeCommandStackObserver(org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver)
	 */
	public void removeCommandStackObserver(ESCommandObserver observer) {
		notifier.removeCommandStackObserver(observer);
	}
}
