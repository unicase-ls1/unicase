/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.specific.strategies.dialogs.wizards;

import org.unicase.ui.refactoring.specific.strategies.dialogs.wizards.pages.AIEmbodiesFRPage1;
import org.unicase.ui.refactoring.specific.strategies.dialogs.wizards.pages.AIEmbodiesFRPage2;
import org.unicase.ui.refactoring.templates.UnicaseRefactoringStrategy;
import org.unicase.ui.refactoring.templates.dialogs.wizards.AbstractRefactoringWizard;

/**
 * @author pfeifferc
 */
public class AIEmbodiesFrRefactoringWizard extends AbstractRefactoringWizard {

	/**
	 * @param unicaseRefactoringStrategy the
	 */
	public AIEmbodiesFrRefactoringWizard(UnicaseRefactoringStrategy unicaseRefactoringStrategy) {
		super(unicaseRefactoringStrategy);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		addPage(new AIEmbodiesFRPage1("page_1", this));
		addPage(new AIEmbodiesFRPage2("page_2", this));
	}
}