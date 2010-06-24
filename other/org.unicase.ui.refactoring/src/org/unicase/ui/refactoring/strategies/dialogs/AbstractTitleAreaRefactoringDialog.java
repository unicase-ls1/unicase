/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Shell;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.refactoring.strategies.dialogs.util.RefactoringDialogHelper;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * @author pfeifferc
 */
public class AbstractTitleAreaRefactoringDialog extends TitleAreaDialog implements AbstractRefactoringDialog {

	private RefactoringResult refactoringResult;
	
	private RefactoringDialogHelper refactoringDialogHelper;
	
	/**
	 * The model element the refactoring is about.
	 */
	private UnicaseModelElement unicaseModelElement;
	
	/**
	 * The constructor.
	 * 
	 * @param parentShell the
	 * @param abstractRefactoringStrategy the
	 */
	public AbstractTitleAreaRefactoringDialog(Shell parentShell, AbstractRefactoringStrategy abstractRefactoringStrategy) {
		super(parentShell);
		this.refactoringDialogHelper = new RefactoringDialogHelper();
		this.refactoringResult = RefactoringResult.ABORT;
		this.unicaseModelElement = (UnicaseModelElement) abstractRefactoringStrategy.getInvalidModelElement();
	}

	/**
	 * {@inheritDoc}
	 */
	public UnicaseModelElement getInvalidModelElement() {
		return unicaseModelElement;
	}

	/**
	 * {@inheritDoc}
	 */
	public RefactoringResult getRefactoringResult() {
		return refactoringResult;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRefactoringResult(RefactoringResult refactoringResult) {
		this.refactoringResult = refactoringResult;
	}
}
