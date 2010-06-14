/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies;

import org.unicase.ui.refactoring.Activator;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.impl.AIEmbodiesFRDialog;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.impl.AIEmbodiesFrWizard;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;

/**
 * The circular dependency refactoring strategy.
 * 
 * @author pfeifferc
 */
public class AIEmbodiesFRRefactoringStrategy extends AbstractRefactoringStrategy {

	private static final String DESCRIPTION = "org.unicase.validation";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performRefactoring() {
		AbstractRefactoringDialog refactoringDialog = new AIEmbodiesFRDialog(getShell(), new AIEmbodiesFrWizard(this));
		refactoringDialog.setTitleImage(Activator.getImageDescriptor("icons/validation.png").createImage());
		refactoringDialog.open();
		return refactoringDialog.getResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}