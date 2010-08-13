/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.ui.strategies;

import org.unicase.ui.refactoring.strategies.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.ui.dialogs.impl.ModelElementNewNameRefactoringDialog;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * The model element new name refactoring strategy.
 * 
 * @author pfeifferc
 */
public class MENewNameRefactoringStrategy extends AbstractRefactoringStrategy {

	private ModelElementNewNameRefactoringDialog abstractRefactoringDialog;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		abstractRefactoringDialog = new ModelElementNewNameRefactoringDialog(getShell(), this, "Set a name", null, null, null);
		abstractRefactoringDialog.open();
		return abstractRefactoringDialog.getRefactoringResult();
	}
}