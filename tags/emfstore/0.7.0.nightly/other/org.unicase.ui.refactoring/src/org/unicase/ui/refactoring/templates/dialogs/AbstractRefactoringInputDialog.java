/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.templates.dialogs;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.refactoring.templates.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * Refactoring input dialog.
 * 
 * @author pfeifferc
 */
public abstract class AbstractRefactoringInputDialog extends InputDialog implements
		AbstractRefactoringDialog {

	private RefactoringResult refactoringResult;
	
	private RefactoringDialogHelper refactoringDialogHelper;
	
	private UnicaseRefactoringStrategy unicaseRefactoringStrategy;

	/**
	 * Constructor.
	 * 
	 * @param parentShell the
	 * @param unicaseRefactoringStrategy the
	 * @param dialogTitle the
	 * @param dialogMessage the
	 * @param initialValue the
	 * @param validator the
	 */
	public AbstractRefactoringInputDialog(Shell parentShell, UnicaseRefactoringStrategy unicaseRefactoringStrategy, String dialogTitle,
			String dialogMessage, String initialValue, IInputValidator validator) {
		super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
		this.refactoringDialogHelper = new RefactoringDialogHelper();
		this.unicaseRefactoringStrategy = unicaseRefactoringStrategy;
		this.refactoringResult = RefactoringResult.ABORT;
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
	 * 
	 * @see org.eclipse.jface.wizard.WizardDialog#cancelPressed()
	 */
	@Override
	protected void cancelPressed() {
		setRefactoringResult(RefactoringResult.ABORT);
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
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		performFinish();
		super.okPressed();
	}
	
	/**
	 * Perform the finish.
	 */
	public abstract void performFinish();

	/**
	 * To be called when disposed.
	 */
	public void dispose() {
		refactoringDialogHelper.dispose();
	}
	
	/**
	 * @return true if not canceled or closed, false otherwise
	 */
	public RefactoringResult getRefactoringResult() {
		return refactoringResult;
	}

	/**
	 * Set the refactoring result.
	 * 
	 * @param refactoringResult the
	 */
	public void setRefactoringResult(RefactoringResult refactoringResult) {
		this.refactoringResult = refactoringResult;
	}

	/**
	 * {@inheritDoc}
	 */
	public RefactoringDialogHelper getRefactoringDialogHelper() {
		return refactoringDialogHelper;
	}

	/**
	 * {@inheritDoc}
	 */
	public UnicaseRefactoringStrategy getAbstractRefactoringStrategy() {
		return unicaseRefactoringStrategy;
	}
}
