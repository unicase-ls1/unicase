package org.unicase.ui.common.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

public abstract class ECPCommand extends ChangeCommand {

	private EObject eObject;

	/**
	 * Constructor.
	 * 
	 * @param eObject
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
		doRun();
	}

	/**
	 * The actual action that is being executed.
	 */
	protected abstract void doRun();

	/**
	 * Executes the command.
	 */
	public void run() {
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		domain.getCommandStack().execute(this);
	}

}
