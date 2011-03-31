/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.util;

/**
 * Command that can buffer a result for later retrieval.
 * 
 * @author koegel
 * @param <T> result type
 * @param <U> parameter type
 */
public abstract class UnicaseCommandWithParameterAndResult<T, U> extends AbstractUnicaseCommand {

	private T result;
	private U parameter;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.util.AbstractUnicaseCommand#commandBody()
	 */
	@Override
	protected void commandBody() {
		result = doRun(parameter);
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

		super.aRun(ignoreExceptions);

		return this.result;
	}

}
