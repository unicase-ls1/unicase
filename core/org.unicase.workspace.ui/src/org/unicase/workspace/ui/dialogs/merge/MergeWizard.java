/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge;

import org.eclipse.jface.wizard.Wizard;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

/**
 * .
 * 
 * @author wesendon
 */
public class MergeWizard extends Wizard {

	private DecisionManager decisionManager;

	public MergeWizard(DecisionManager decisionManager) {
		super();
		setWindowTitle("Merge Wizard");
		setDefaultPageImageDescriptor(DecisionUtil
				.getImageDescriptor("merge_wizard.gif"));

		this.decisionManager = decisionManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();
		addPage(new MergeWizardPage(decisionManager));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		if (decisionManager.isResolved()) {
			decisionManager.calcResult();
			return true;
		}
		return false;
	}
}
