/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.workspace.Configuration;

/**
 * Super class for all commands.
 * 
 * @author wesendon
 */
public abstract class AbstractUnicaseCommand {

	private RuntimeException runtimeException;

	/**
	 * Create a command to run the command body.
	 * 
	 * @return the command
	 */
	protected Command createCommand() {
		if (Configuration.getEditingDomain() instanceof TransactionalEditingDomain) {
			return new RecordingCommand((TransactionalEditingDomain) Configuration.getEditingDomain()) {
				@Override
				protected void doExecute() {
					runCommandBody();
				}
			};
		} else {
			// TODO DOD - think of using Changecommand mit Changerecorder
			return new AbstractCommand() {
				public void redo() {
					throw new UnsupportedOperationException();
				}

				public void execute() {
					runCommandBody();
				}

				@Override
				protected boolean prepare() {
					return true;
				}
			};
		}
	}

	private void runCommandBody() {
		try {
			commandBody();
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			runtimeException = e;
			throw e;
		}
	}

	/**
	 * Content of the actual command.
	 */
	protected abstract void commandBody();

	/**
	 * Executes the command on the workspaces editing domain.
	 * 
	 * @param ignoreExceptions true if any thrown exception in the execution of the command should be ignored.
	 */
	protected void aRun(boolean ignoreExceptions) {
		runtimeException = null;

		Configuration.getEditingDomain().getCommandStack().execute(createCommand());

		if (!ignoreExceptions && runtimeException != null) {
			throw runtimeException;
		}
	}
}
