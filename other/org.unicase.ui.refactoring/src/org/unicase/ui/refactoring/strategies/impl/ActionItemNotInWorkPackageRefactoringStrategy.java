/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.impl;

import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.impl.ActionItemNotInWorkPackageRefactoringDialog;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * The action item embodies functional requirement refactoring strategy.
 * 
 * @author pfeifferc
 */
public class ActionItemNotInWorkPackageRefactoringStrategy extends AbstractRefactoringStrategy {

	private static final String ID = "org.unicase.ui.refactoring.ActionItemNotInWorkPackageRefactoringStrategy";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		AbstractRefactoringDialog abstractRefactoringDialog = new ActionItemNotInWorkPackageRefactoringDialog(getShell(), this);
		abstractRefactoringDialog.open();
		return abstractRefactoringDialog.getRefactoringResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "Set a work package for the action item";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return ID;
	}
}