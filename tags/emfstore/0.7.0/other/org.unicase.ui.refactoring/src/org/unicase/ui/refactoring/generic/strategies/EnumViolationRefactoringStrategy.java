/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.generic.strategies;

import org.unicase.ui.refactoring.generic.strategies.dialogs.EnumViolationRefactoringDialog;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * An {@link UnicaseRefactoringStrategy} for enum features.
 * 
 * @author pfeifferc
 */
public class EnumViolationRefactoringStrategy extends UnicaseRefactoringStrategy {

	private EnumViolationRefactoringDialog abstractRefactoringDialog;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		abstractRefactoringDialog = new EnumViolationRefactoringDialog(getShell(), this);
		abstractRefactoringDialog.create();
		abstractRefactoringDialog.setTitle(getName());
		abstractRefactoringDialog.setMessage(getDescription());
		abstractRefactoringDialog.open();
		return abstractRefactoringDialog.getRefactoringResult();
	}
}