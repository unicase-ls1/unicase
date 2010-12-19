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
 * @param <U> parameter type
 */
public abstract class UnicaseCommandWithParameterAndResult<T, U> extends RecordingCommand {

	private T result;
	private U parameter;
	private RuntimeException runtimeException;

	/**
	 * Constructor. The editing domain needs to be initialized by the workspace manager before using this constructor.
	 */
	public UnicaseCommandWithParameterAndResult() {
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
			this.result = doRun(parameter);
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
	 * @param parameter the parameter
	 * @return the result
	 */
	protected abstract T doRun(U parameter);

	/**
	 * Executes the command on the workspaces editing domain.
	 * 
	 * @param parameter the parameter
	 * @return the result
	 * @deprecated Use run(boolean) instead
	 */
	@Deprecated
	public T run(U parameter) {
		return run(parameter, true);
	}

	/**
	 * Executes the command on the workspaces editing domain.
	 * 
	 * @param parameter the parameter
	 * @param ignoreExceptions true if any thrown exception in the execution of the command should be ignored.
	 * @return the result
	 */
	public T run(U parameter, boolean ignoreExceptions) {
		this.parameter = parameter;
		runtimeException = null;

		Configuration.getEditingDomain().getCommandStack().execute(this);

		if (!ignoreExceptions && runtimeException != null) {
			throw runtimeException;
		}

		return this.result;
	}

}
