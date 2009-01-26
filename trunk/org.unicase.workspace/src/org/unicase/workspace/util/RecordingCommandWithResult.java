/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * Recording command that can buffer a result for later retrieval.
 * 
 * @author koegel
 * @param <T>
 */
public abstract class RecordingCommandWithResult<T> extends RecordingCommand {

	private T result;

	/**
	 * Constructor.
	 * 
	 * @param domain the editing domain
	 */
	public RecordingCommandWithResult(TransactionalEditingDomain domain) {
		super(domain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected abstract void doExecute();

	/**
	 * Get the result with the correct type.
	 * 
	 * @return the result
	 */
	public T getTypedResult() {
		return result;
	}

	/**
	 * Set the result with the correct type.
	 * 
	 * @param result the result
	 */
	protected void setTypedResult(T result) {
		this.result = result;
	}

}
