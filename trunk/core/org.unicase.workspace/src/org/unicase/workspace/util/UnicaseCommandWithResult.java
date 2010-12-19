/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.eclipse.emf.transaction.RecordingCommand;
import org.unicase.workspace.Configuration;

/**
 * Recording command that can buffer a result for later retrieval.
 * 
 * @author koegel
 * @param <T> result type
 */
public abstract class UnicaseCommandWithResult<T> extends RecordingCommand {

	private T result;
	private RuntimeException runtimeException;

	/**
	 * Constructor. The editing domain needs to be initialized by the workspace manager before using this constructor.
	 */
	public UnicaseCommandWithResult() {
		super(Configuration.getEditingDomain());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected final void doExecute() {
		try {
			this.result = doRun();
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			runtimeException = e;
			throw e;
		}
	}

	/**
	 * The actual action that is being executed.
	 * 
	 * @return the result
	 */
	protected abstract T doRun();

	/**
	 * Executes the command on the workspaces editing domain.
	 * 
	 * @return the result
	 * @deprecated Use run(boolean) instead
	 */
	@Deprecated
	public T run() {
		return run(true);
	}

	/**
	 * Executes the command on the workspaces editing domain.
	 * 
	 * @param ignoreExceptions true if any thrown exception in the execution of the command should be ignored.
	 * @return the result
	 */
	public T run(boolean ignoreExceptions) {
		runtimeException = null;

		Configuration.getEditingDomain().getCommandStack().execute(this);

		if (!ignoreExceptions && runtimeException != null) {
			throw runtimeException;
		}

		return this.result;
	}

}
