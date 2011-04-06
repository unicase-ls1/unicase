/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.changeTracking.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;

/**
 * Notifier for Commands. Notifies Observers about command start, completion and failure.
 * 
 * @author koegel
 */
public class EMFStoreCommandNotifier {

	private List<CommandObserver> commandObservers;

	/**
	 * Default constructor.
	 */
	public EMFStoreCommandNotifier() {
		super();
		commandObservers = new ArrayList<CommandObserver>();
	}

	/**
	 * Notify all registered listeners about command start.
	 * 
	 * @param command the command
	 */
	public void notifiyListenersAboutStart(Command command) {
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
	 * Notify all registered listeners about command failure.
	 * 
	 * @param command the command
	 * @param exception the exception that triggered the failure
	 */
	public void notifiyListenersAboutCommandFailed(Command command, Exception exception) {
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

	/**
	 * Notify all registered listeners about command completion.
	 * 
	 * @param command the command
	 */
	public void notifiyListenersAboutCommandCompleted(Command command) {
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
