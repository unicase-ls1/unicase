/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;

/**
 * @author pfeifferc
 */
public abstract class AbstractRefactoringDialog extends WizardDialog {

	/**
	 * Has the cancel button been pressed.
	 */
	private boolean cancelPressed;

	/**
	 * The refactoring wizard.
	 */
	private AbstractRefactoringWizard wizard;

	/**
	 * @param parentShell the
	 * @param newWizard the
	 */
	public AbstractRefactoringDialog(Shell parentShell, AbstractRefactoringWizard newWizard) {
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
		cancelPressed = true;
		super.handleShellCloseEvent();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardDialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		cancelPressed = true;
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
	 * @return true if not canceled or closed, false otherwise
	 */
	public boolean getResult() {
		return !cancelPressed;
	}

	/**
	 * To be called when disposed.
	 */
	public void dispose() {
		wizard.dispose();
	}
}
