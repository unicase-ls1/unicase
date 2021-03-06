/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * A command that is used in the XMIECPWorkspace
 * and which is similar to the UnicaseCommand.
 * @author kraftm, maierma
 *
 */
public abstract class XmiCommand extends RecordingCommand {

	/**
	 * Store exception to use it in multiple methods.
	 */
	private RuntimeException runtimeException;
	private final TransactionalEditingDomain editingDomain;
	
	/**
	 * Creates a command to be used within the XMIWorkspace. 
	 * @param domain Transactional editing domain from the workspace.
	 */
	public XmiCommand(TransactionalEditingDomain domain) {
		super(domain);
		editingDomain = domain;
	}

	@Override
	protected void doExecute() {
		try {
			doRun();
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			runtimeException = e;
			throw e;
		}
	}
	
	/**
	 * The actual action that is being executed.
	 */
	protected abstract void doRun();
	
	/**
	 * Executes the command on the workspaces editing domain.
	 * @param ignoreExceptions true if any thrown exception in the execution of the command should be ignored.
	 */
	public void run(boolean ignoreExceptions) {
		runtimeException = null;

		editingDomain.getCommandStack().execute(this);

		if (!ignoreExceptions && runtimeException != null) {
			throw runtimeException;
		}
	}

}
