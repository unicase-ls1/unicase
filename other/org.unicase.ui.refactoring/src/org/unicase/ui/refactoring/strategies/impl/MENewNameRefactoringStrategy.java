/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.impl;

import org.unicase.ui.refactoring.strategies.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.impl.ModelElementNewNameRefactoringDialog;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * The model element new name refactoring strategy.
 * 
 * @author pfeifferc
 */
public class MENewNameRefactoringStrategy extends AbstractRefactoringStrategy {

	private static final String ID = "org.unicase.ui.refactoring.MENewNameRefactoringStrategy";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		AbstractRefactoringDialog refactoringDialog = new ModelElementNewNameRefactoringDialog(getShell(), this, "Please choose a name", null, null, null);
		refactoringDialog.open();
		return refactoringDialog.getRefactoringResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "Rename the model element";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return ID;
	}
}