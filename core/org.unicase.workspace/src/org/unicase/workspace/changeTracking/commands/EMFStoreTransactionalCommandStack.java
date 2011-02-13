/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking.commands;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;

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

	@Override
	public void addCommandStackObserver(CommandObserver observer) {
		notifier.addCommandStackObserver(observer);
	}

	@Override
	public void removeCommandStackObserver(CommandObserver observer) {
		notifier.removeCommandStackObserver(observer);
	}
}
