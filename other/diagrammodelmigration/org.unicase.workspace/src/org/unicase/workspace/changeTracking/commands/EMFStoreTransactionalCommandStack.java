/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.impl.TransactionalCommandStackImpl;
import org.unicase.metamodel.util.ModelUtil;

/**
 * Command Stack with additional support for command listing.
 * 
 * @author koegel
 */
public class EMFStoreTransactionalCommandStack extends TransactionalCommandStackImpl {

	private Command currentCommand;

	private List<CommandObserver> commandObservers;

	/**
	 * Dafault Constructor.
	 */
	public EMFStoreTransactionalCommandStack() {
		commandObservers = new ArrayList<CommandObserver>();
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
			notifiyListenersAboutStart(command);
		}

		try {
			super.basicExecute(command);
		} catch (OperationCanceledException e) {
			this.notifiyListenersAboutCommandFailed(command, e);
			this.currentCommand = null;
			throw e;
		}
		// Notify someone that the command is done.
		// Check if we are really at the end of the most outer command.
		if (currentCommand == command) {
			// check again if command was really completed.
			if (mostRecentCommand == command) {
				this.notifiyListenersAboutCommandCompleted(command);
			}
			currentCommand = null;
		}
	}

	private void notifiyListenersAboutStart(Command command) {
		for (CommandObserver commandObservers : this.commandObservers) {
			try {
				commandObservers.commandStarted(command);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				ModelUtil.logWarning("Command Observer threw exception", e);
			}
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
		notifiyListenersAboutCommandFailed(command, (rbe.getCause() instanceof Exception) ? (Exception) rbe.getCause()
			: rbe);
		if (currentCommand == command) {
			currentCommand = null;
		}
	}

	private void notifiyListenersAboutCommandFailed(Command command, Exception exception) {
		for (CommandObserver commandObservers : this.commandObservers) {
			try {
				commandObservers.commandFailed(command, exception);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				ModelUtil.logWarning("Command Observer threw exception", e);
			}
		}
	}

	private void notifiyListenersAboutCommandCompleted(Command command) {
		for (CommandObserver commandObservers : this.commandObservers) {
			try {
				commandObservers.commandCompleted(command);
				// BEGIN SUPRESS CATCH EXCEPTION
			} catch (RuntimeException e) {
				// END SUPRESS CATCH EXCEPTION
				ModelUtil.logWarning("Command Observer threw exception", e);
			}
		}
	}

	/**
	 * Add a command stack observer.
	 * 
	 * @param observer the observer
	 */
	public void addCommandStackObserver(CommandObserver observer) {
		commandObservers.add(observer);
	}

	/**
	 * Remove COmmand stack observer.
	 * 
	 * @param observer the observer
	 */
	public void removeCommandStackObserver(CommandObserver observer) {
		commandObservers.remove(observer);
	}
}
