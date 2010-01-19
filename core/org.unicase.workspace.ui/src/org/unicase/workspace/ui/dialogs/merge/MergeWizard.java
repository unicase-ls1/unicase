/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge;

import org.eclipse.jface.dialogs.MessageDialog;
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
		setDefaultPageImageDescriptor(DecisionUtil.getImageDescriptor("merge_wizard2.gif"));

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
			decisionManager.getEventLogger().selectedOK();
			return true;
		}
		decisionManager.getEventLogger().selectedOKButNotFinished();
		MessageDialog.openInformation(getShell(), "Resolve all conflicts first",
			"You have to resolve all conflicts in order to finish."
				+ "\nTherefore choose an option for every conflict.");
		return false;
	}
}
