/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.testspec.ui.test.commands;


/**
 * Recording command that can buffer a result for later retrieval.
 * 
 * @author koegel
 */
public abstract class StubUnicaseCommand {

	/**
	 * Constructor. The editing domain needs to be initialized by the workspace manager before using this constructor.
	 */
	public StubUnicaseCommand() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	protected final void doExecute() {
		doRun();
	}

	/**
	 * The actual action that is being executed.
	 */
	protected abstract void doRun();

	/**
	 * Executes the command on the workspaces editing domain.
	 */
	public void run() {
		this.doExecute();
	}

}
