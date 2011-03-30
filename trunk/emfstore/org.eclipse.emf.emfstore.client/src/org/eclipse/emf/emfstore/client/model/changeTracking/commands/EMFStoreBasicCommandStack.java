/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.changeTracking.commands;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;

/**
 * Basic Command Stack for EMFStore. Allows tracking of command start and end.
 * 
 * @author koegel
 */
public class EMFStoreBasicCommandStack extends BasicCommandStack implements EMFStoreCommandStack {

	private EMFStoreCommandNotifier notifier;
	private Command currentCommand;

	/**
	 * Default constructor.
	 */
	public EMFStoreBasicCommandStack() {
		super();
		notifier = new EMFStoreCommandNotifier();
	}

	@Override
	protected void handleError(Exception exception) {
		notifier.notifiyListenersAboutCommandFailed(currentCommand, exception);
		currentCommand = null;
		super.handleError(exception);
	}

	@Override
	public void execute(Command command) {

		if (currentCommand == null) {
			currentCommand = command;
			notifier.notifiyListenersAboutStart(command);
		}
		super.execute(command);
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
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.EMFStoreCommandStack#addCommandStackObserver(org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver)
	 */
	public void addCommandStackObserver(CommandObserver observer) {
		notifier.addCommandStackObserver(observer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.changeTracking.commands.EMFStoreCommandStack#removeCommandStackObserver(org.eclipse.emf.emfstore.client.model.changeTracking.commands.CommandObserver)
	 */
	public void removeCommandStackObserver(CommandObserver observer) {
		notifier.removeCommandStackObserver(observer);
	}

}
