/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.ui.strategies;

import org.unicase.ui.refactoring.strategies.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.ui.dialogs.impl.ActionItemNotInWorkPackageRefactoringDialog;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * The action item embodies functional requirement refactoring strategy.
 * 
 * @author pfeifferc
 */
public class ActionItemNotInWorkPackageRefactoringStrategy extends AbstractRefactoringStrategy {

	private ActionItemNotInWorkPackageRefactoringDialog abstractRefactoringDialog;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		abstractRefactoringDialog = new ActionItemNotInWorkPackageRefactoringDialog(getShell(), this);
		abstractRefactoringDialog.open();
		return abstractRefactoringDialog.getRefactoringResult();
	}
}