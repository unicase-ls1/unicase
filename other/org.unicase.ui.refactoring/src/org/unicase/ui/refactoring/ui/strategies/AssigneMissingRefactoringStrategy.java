/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.ui.strategies;

import org.unicase.ui.refactoring.strategies.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.ui.dialogs.impl.AssigneeMissingRefactoringDialog;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * @author pfeifferc
 */
public class AssigneMissingRefactoringStrategy extends
		AbstractRefactoringStrategy {

	private AssigneeMissingRefactoringDialog abstractRefactoringDialog;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected RefactoringResult performRefactoring() {
		abstractRefactoringDialog = new AssigneeMissingRefactoringDialog(getShell(), this);
		abstractRefactoringDialog.open();
		return abstractRefactoringDialog.getRefactoringResult();
	}
}
