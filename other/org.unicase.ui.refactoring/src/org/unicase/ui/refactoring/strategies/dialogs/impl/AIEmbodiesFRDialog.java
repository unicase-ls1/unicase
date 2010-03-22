/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.impl;

import org.eclipse.swt.widgets.Shell;
import org.unicase.ui.refactoring.strategies.dialogs.AbstractRefactoringDialog;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;

/**
	 */
public class AIEmbodiesFRDialog extends AbstractRefactoringDialog {

	/**
	 * @param parentShell the
	 * @param wizard the
	 */
	public AIEmbodiesFRDialog(Shell parentShell, AbstractRefactoringWizard wizard) {
		super(parentShell, wizard);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void finishPressed() {
		super.finishPressed();
		close();
	}
}