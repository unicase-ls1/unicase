/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.ui.strategies;

import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.refactoring.strategies.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.ui.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.ui.dialogs.AbstractRefactoringWizardDialog;
import org.unicase.ui.refactoring.ui.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.ui.wizards.impl.DiscussionIntoIssueRefactoringWizard;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * The discussion into issue refactoring strategy.
 * 
 * @author pfeifferc
 */
public class DiscussionIntoIssueRefactoringStrategy extends AbstractRefactoringStrategy {

	private DiscussionIntoIssueRefactoringDialog abstractRefactoringDialog;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RefactoringResult performRefactoring() {
		abstractRefactoringDialog = new DiscussionIntoIssueRefactoringDialog(getShell(), this, 
			new DiscussionIntoIssueRefactoringWizard(this));
		setTitleAndMessage();
		abstractRefactoringDialog.open();
		return abstractRefactoringDialog.getRefactoringResult();
	}
	
	/**
	 * Sets the dialog title and message.
	 */
	protected void setTitleAndMessage() {
		abstractRefactoringDialog.setTitle(getName());
		abstractRefactoringDialog.setMessage(getDescription());
	}
	
	/**
	 * @author pfeifferc
	 */
	public class DiscussionIntoIssueRefactoringDialog extends
			AbstractRefactoringWizardDialog implements AbstractRefactoringDialog {

		/**
		 * @param parentShell the
		 * @param abstractRefactoringStrategy the
		 * @param newWizard the
		 */
		public DiscussionIntoIssueRefactoringDialog(Shell parentShell,
				AbstractRefactoringStrategy abstractRefactoringStrategy,
				AbstractRefactoringWizard newWizard) {
			super(parentShell, abstractRefactoringStrategy, newWizard);
		}

	}

}