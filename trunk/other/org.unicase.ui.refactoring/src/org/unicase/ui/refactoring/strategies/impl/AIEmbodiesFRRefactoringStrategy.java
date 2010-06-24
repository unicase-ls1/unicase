/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.impl;

import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringWizardDialog;
import org.unicase.ui.refactoring.strategies.dialogs.impl.AIEmbodiesFrRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.impl.AIEmbodiesFrRefactoringWizard;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * The action item embodies functional requirement refactoring strategy.
 * 
 * @author pfeifferc
 */
public class AIEmbodiesFRRefactoringStrategy extends AbstractRefactoringStrategy {

	private static final String ID = "org.unicase.validation.AIEmbodiesFRRefactoringStrategy";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		AbstractRefactoringWizardDialog refactoringDialog = new AIEmbodiesFrRefactoringDialog(getShell(), this, new AIEmbodiesFrRefactoringWizard(this));
		refactoringDialog.open();
		return refactoringDialog.getRefactoringResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "Extract functional requirement information into action item";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return ID;
	}
}