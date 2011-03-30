/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.util;

/**
 * Recording command that can buffer a result for later retrieval.
 * 
 * @author koegel
 */
public abstract class UnicaseCommand extends AbstractUnicaseCommand {

	/**
	 * The actual action that is being executed.
	 */
	protected abstract void doRun();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.model.util.AbstractUnicaseCommand#commandBody()
	 */
	@Override
	protected void commandBody() {
		doRun();
	}

	/**
	 * Executes the command on the workspaces editing domain.
	 * 
	 * @param ignoreExceptions true if any thrown exception in the execution of the command should be ignored.
	 */
	public void run(boolean ignoreExceptions) {
		super.aRun(ignoreExceptions);
	}

	/**
	 * Executes the command on the workspaces editing domain with ignoring runtime exceptions.
	 */
	public void run() {
		run(true);
	}
}
