/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.templates.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.refactoring.templates.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * Refactoring input dialog.
 * 
 * @author pfeifferc
 */
public abstract class AbstractElementListSelectionRefactoringDialog extends ElementListSelectionDialog implements
		AbstractRefactoringDialog {

	private RefactoringResult refactoringResult;
	
	private RefactoringDialogHelper refactoringDialogHelper;
	
	private UnicaseRefactoringStrategy unicaseRefactoringStrategy;
	
	/**
	 * @param parent the
	 * @param unicaseRefactoringStrategy the
	 * @param renderer the
	 */
	public AbstractElementListSelectionRefactoringDialog(Shell parent, UnicaseRefactoringStrategy unicaseRefactoringStrategy,
			ILabelProvider renderer) {
		super(parent, renderer);
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
	 * @return the abstract refactoring strategy
	 */
	public UnicaseRefactoringStrategy getAbstractRefactoringStrategy() {
		return unicaseRefactoringStrategy;
	}

	/**
	 * {@inheritDoc}
	 */
	public RefactoringDialogHelper getRefactoringDialogHelper() {
		return refactoringDialogHelper;
	}
}
