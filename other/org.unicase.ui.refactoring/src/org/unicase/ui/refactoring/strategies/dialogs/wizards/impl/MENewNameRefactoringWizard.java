/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.impl;

import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.menewname.MENewNamePage1;
import org.unicase.ui.validation.refactoring.strategy.AbstractRefactoringStrategy;

/**
 * @author pfeifferc
 */
public class MENewNameRefactoringWizard extends AbstractRefactoringWizard {

	/**
	 * Default constructor.
	 * 
	 * @param abstractRefactoringStrategy the
	 */
	public MENewNameRefactoringWizard(
			AbstractRefactoringStrategy abstractRefactoringStrategy) {
		super(abstractRefactoringStrategy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(new MENewNamePage1("page_1", this));
	}
}
