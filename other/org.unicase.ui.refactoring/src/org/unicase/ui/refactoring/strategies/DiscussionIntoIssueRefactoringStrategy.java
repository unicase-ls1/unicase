/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies;

import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.refactoring.Activator;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.impl.DiscussionIntoIssueDialog;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.impl.DiscussionIntoIssueWizard;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;

/**
 * The circular dependency refactoring strategy.
 * 
 * @author pfeifferc
 */
public class DiscussionIntoIssueRefactoringStrategy extends AbstractRefactoringStrategy {

	private static final String DESCRIPTION = "org.unicase.validation";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performRefactoring(Shell parentShell) {
		AbstractRefactoringDialog refactoringDialog = new DiscussionIntoIssueDialog(parentShell,
			new DiscussionIntoIssueWizard(getConstraintStatus()));
		refactoringDialog.setTitleImage(Activator.getImageDescriptor("icons/validation.png").createImage());
		refactoringDialog.open();
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}