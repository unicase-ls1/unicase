/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.impl;

import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringWizardDialog;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;

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
		// TODO Auto-generated constructor stub
	}

}
