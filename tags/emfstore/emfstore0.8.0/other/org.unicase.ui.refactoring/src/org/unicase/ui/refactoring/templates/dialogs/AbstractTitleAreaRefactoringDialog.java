/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.templates.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.refactoring.templates.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * @author pfeifferc
 */
public abstract class AbstractTitleAreaRefactoringDialog extends TitleAreaDialog implements AbstractRefactoringDialog {

	private RefactoringResult refactoringResult;
	
	private RefactoringDialogHelper refactoringDialogHelper;
	
	/**
	 * The model element the refactoring is about.
	 */
	private UnicaseModelElement invalidEObject;

	/**
	 * The abstract refactoring strategy.
	 */
	private UnicaseRefactoringStrategy unicaseRefactoringStrategy;

	/**
	 * The constructor.
	 * 
	 * @param parentShell the
	 * @param unicaseRefactoringStrategy the
	 */
	public AbstractTitleAreaRefactoringDialog(Shell parentShell, UnicaseRefactoringStrategy unicaseRefactoringStrategy) {
		super(parentShell);
		this.refactoringDialogHelper = new RefactoringDialogHelper();
		this.unicaseRefactoringStrategy = unicaseRefactoringStrategy;
		this.refactoringResult = RefactoringResult.ABORT;
		this.invalidEObject = (UnicaseModelElement) unicaseRefactoringStrategy.getInvalidEObject();
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

	/**
	 * {@inheritDoc}
	 */
	public EObject getInvalidEObject() {
		return invalidEObject;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		performFinish();
		super.okPressed();
	}
}
