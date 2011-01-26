/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.changeTracking.commands;

import org.eclipse.emf.common.command.Command;

/**
 * Listener for a {@link EMFStoreTransactionalCommandStack}.
 * 
 * @author koegel
 */
public interface CommandObserver {

	/**
	 * Called to notify listener about the start of the given command.
	 * 
	 * @param command the command
	 */
	void commandStarted(Command command);

	/**
	 * Called to notify listener about the successful completion of the given command.
	 * 
	 * @param command the command
	 */
	void commandCompleted(Command command);

	/**
	 * Called to notify listener about the failure of the given command.
	 * 
	 * @param command the command
	 * @param exception the exception that occured
	 */
	void commandFailed(Command command, Exception exception);

}
