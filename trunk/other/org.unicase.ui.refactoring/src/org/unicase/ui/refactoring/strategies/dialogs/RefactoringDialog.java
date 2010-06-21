/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * @author pfeifferc
 */
public class RefactoringDialog extends WizardDialog {

	/**
	 * The result of the refactoring process.
	 */
	private RefactoringResult refactoringResult;

	/**
	 * The refactoring wizard.
	 */
	private AbstractRefactoringWizard wizard;

	/**
	 * @param parentShell the
	 * @param newWizard the
	 */
	public RefactoringDialog(Shell parentShell, AbstractRefactoringWizard newWizard) {
		super(parentShell, newWizard);
		addPageChangedListener(newWizard);
		this.wizard = newWizard;
		setTitle("");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleShellCloseEvent() {
		cancelPressed();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void finishPressed() {
		getWizard().performFinish();
		refactoringResult = wizard.getRefactoringResult();
		close();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardDialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		refactoringResult = RefactoringResult.ABORT;
		super.cancelPressed();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardDialog#close()
	 */
	@Override
	public boolean close() {
		dispose();
		return super.close();
	}

	/**
	 * To be called when disposed.
	 */
	public void dispose() {
		wizard.dispose();
	}
	
	/**
	 * @return true if not canceled or closed, false otherwise
	 */
	public RefactoringResult getRefactoringResult() {
		return refactoringResult;
	}
}
