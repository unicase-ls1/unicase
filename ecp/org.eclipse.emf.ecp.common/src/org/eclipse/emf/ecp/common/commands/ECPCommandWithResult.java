/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Command capable of recording changes on a model element.
 * @param <T> the type of the return value
 * 
 * @author koegel
 */
public abstract class ECPCommandWithResult<T> extends ChangeCommand {

	private EObject eObject;
	private RuntimeException runtimeException;
	private T result;

	/**
	 * Constructor.
	 * 
	 * @param eObject the model element whose changes one is interested in
	 */
	public ECPCommandWithResult(EObject eObject) {
		super(eObject);
		this.eObject = eObject;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ChangeCommand#doExecute()
	 */
	@Override
	protected final void doExecute() {
		try {
			result = doRun();
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
	 * @return the result of type T
	 */
	protected abstract T doRun();

	/**
	 * Executes the command.
	 * 
	 * @param ignoreExceptions true if any thrown exception in the execution of the command should be ignored.
	 * @return the result of type T
	 */
	public T run(boolean ignoreExceptions) {
		runtimeException = null;

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		domain.getCommandStack().execute(this);

		if (!ignoreExceptions && runtimeException != null) {
			throw runtimeException;
		}
		return result;
	}

	/**
	 * Executes the command.
	 * 
	 * @deprecated use run(boolean) instead.
	 * @return the result of type T
	 */
	@Deprecated
	public T run() {
		return run(true);
	}

}
