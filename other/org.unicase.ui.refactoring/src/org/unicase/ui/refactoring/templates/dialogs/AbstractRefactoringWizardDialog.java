/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.templates.dialogs;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * @author pfeifferc
 */
public abstract class AbstractRefactoringWizardDialog extends WizardDialog implements AbstractRefactoringDialog {

	/**
	 * The result of the refactoring process.
	 */
	private RefactoringResult refactoringResult;

	/**
	 * The refactoring wizard.
	 */
	private AbstractRefactoringWizard wizard;

	/**
	 * The abstract refactoring strategy.
	 */
	private final UnicaseRefactoringStrategy unicaseRefactoringStrategy;

	/**
	 * The model element the refactoring is about.
	 */
	private UnicaseModelElement unicaseModelElement;

	/**
	 * @param parentShell the
	 * @param unicaseRefactoringStrategy the
	 * @param newWizard the
	 */
	public AbstractRefactoringWizardDialog(Shell parentShell, UnicaseRefactoringStrategy unicaseRefactoringStrategy, AbstractRefactoringWizard newWizard) {
		super(parentShell, newWizard);
		this.unicaseRefactoringStrategy = unicaseRefactoringStrategy;
		addPageChangedListener(newWizard);
		this.wizard = newWizard;
		this.unicaseModelElement = (UnicaseModelElement) unicaseRefactoringStrategy.getInvalidEObject();
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
		setRefactoringResult(wizard.getRefactoringResult());
		close();
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
	public UnicaseModelElement getInvalidModelElement() {
		return unicaseModelElement;
	}
}
