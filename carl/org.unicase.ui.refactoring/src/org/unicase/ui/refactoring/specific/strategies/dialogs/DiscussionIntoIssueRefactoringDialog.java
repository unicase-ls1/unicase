/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */


package org.unicase.ui.refactoring.specific.strategies.dialogs;

import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.refactoring.templates.AbstractRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.templates.dialogs.AbstractRefactoringWizardDialog;
import org.unicase.ui.refactoring.templates.dialogs.wizards.AbstractRefactoringWizard;

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