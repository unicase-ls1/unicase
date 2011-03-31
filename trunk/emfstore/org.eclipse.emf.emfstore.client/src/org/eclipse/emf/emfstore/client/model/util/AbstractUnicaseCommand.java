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

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.emfstore.client.model.Configuration;

/**
 * Super class for all commands.
 * 
 * @author wesendon
 */
public abstract class AbstractUnicaseCommand extends AbstractCommand {

	private RuntimeException runtimeException;

	/**
	 * Get the runtime exception that occurred during command execution. Returns null if there was no exception
	 * 
	 * @return the exception or null
	 */
	public RuntimeException getRuntimeException() {
		return runtimeException;
	}

	private boolean ignoreExceptions;

	/**
	 * Return whether the command should ignore exceptions during command execution.
	 * 
	 * @return true, if exceptions should be ignored.
	 */
	public boolean shouldIgnoreExceptions() {
		return ignoreExceptions;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#canUndo()
	 */
	@Override
	public boolean canUndo() {
		// return false as default, override method to implement undo.
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
		try {
			commandBody();
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			// END SUPRESS CATCH EXCEPTION
			// record exception
			runtimeException = e;
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
	 */
	@Override
	protected boolean prepare() {
		// return true as default, override method to implement preparation.
		return true;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		throw new UnsupportedOperationException("Redo is not implemented in this command!");
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
		this.ignoreExceptions = ignoreExceptions;
		Configuration.getEditingDomain().getCommandStack().execute(this);

	}
}
