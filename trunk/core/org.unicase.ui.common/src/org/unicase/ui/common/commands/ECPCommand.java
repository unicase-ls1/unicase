/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Command capable of recording changes on a model element.
 * 
 * @author emueller
 */
public abstract class ECPCommand extends ChangeCommand {

	private EObject eObject;
	private RuntimeException runtimeException;

	/**
	 * Constructor.
	 * 
	 * @param eObject the model element whose changes one is interested in
	 */
	public ECPCommand(EObject eObject) {
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
	 * Executes the command.
	 * 
	 * @param ignoreExceptions true if any thrown exception in the execution of the command should be ignored.
	 */
	public void run(boolean ignoreExceptions) {
		runtimeException = null;

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		domain.getCommandStack().execute(this);

		if (!ignoreExceptions && runtimeException != null) {
			throw runtimeException;
		}
	}

	/**
	 * Executes the command.
	 */
	public void run() {
		run(true);
	}

}
