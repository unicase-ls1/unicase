/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.group.strategies;

import org.unicase.ui.refactoring.group.strategies.dialogs.ReviewWorkItemByUserRefactoringDialog;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * The action item embodies functional requirement refactoring strategy.
 * 
 * @author pfeifferc
 */
public class ReviewWorkItemByUserRefactoringStrategy extends UnicaseRefactoringStrategy {

	private ReviewWorkItemByUserRefactoringDialog abstractRefactoringDialog;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		abstractRefactoringDialog = new ReviewWorkItemByUserRefactoringDialog(getShell(), this);
		abstractRefactoringDialog.create();
		abstractRefactoringDialog.setTitle(getName());
		abstractRefactoringDialog.setMessage(getDescription());
		abstractRefactoringDialog.open();
		return abstractRefactoringDialog.getRefactoringResult();
	}
}