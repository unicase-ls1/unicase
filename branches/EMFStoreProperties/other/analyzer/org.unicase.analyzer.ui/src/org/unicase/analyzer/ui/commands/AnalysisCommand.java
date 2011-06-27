/**
 * 
 */
package org.unicase.analyzer.ui.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author liya
 */
public abstract class AnalysisCommand extends RecordingCommand {

	private final TransactionalEditingDomain domain;

	/**
	 * Constructor. The editing domain needs to be initialized by the workspace manager before using this constructor.
	 * 
	 * @param domain editing domain
	 */
	public AnalysisCommand(TransactionalEditingDomain domain) {
		super(domain);
		this.domain = domain;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		try {
			doRun();
			// BEGIN SUPRESS CATCH EXCEPTION
		} catch (RuntimeException e) {
			throw e;
		}

	}

	/**
	 * The actual action that is being executed.
	 */
	protected abstract void doRun();

	/**
	 * Executes the command.
	 */
	public void run() {
		domain.getCommandStack().execute(this);
	}

}
