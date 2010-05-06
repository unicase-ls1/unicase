/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest;

import java.util.List;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.MergeWizard;
import org.unicase.metamodel.Project;
import org.unicase.workspace.observers.ConflictResolver;

/**
 * This is a ConflictResolver that shows a MergeDialog when triggered.
 * 
 * @author Shterev
 */
public class MergeProjectHandler implements ConflictResolver {

	private MergeDialog mergeDialog;

	private WizardDialog dialog;

	/**
	 * Default constructor.
	 */
	public MergeProjectHandler() {
		this.mergeDialog = new MergeDialog(Display.getCurrent()
				.getActiveShell());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.ConflictResolver#getAcceptedMine()
	 */
	public List<AbstractOperation> getAcceptedMine() {
		return mergeDialog.getAcceptedMine();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.ConflictResolver#getAcceptedMine()
	 */
	public List<AbstractOperation> getRejectedTheirs() {
		return mergeDialog.getRejectedTheirs();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.observers.ConflictResolver#getAcceptedMine()
	 */
	public boolean resolveConflicts(Project project,
			List<ChangePackage> theirChangePackages,
			ChangePackage myChangePackage) {
		DecisionManager decisionManager = new DecisionManager(project,
				myChangePackage, theirChangePackages);
		MergeWizard wizard = new MergeWizard(decisionManager);
		dialog = new WizardDialog(Display.getCurrent().getActiveShell(), wizard);
		dialog.setPageSize(800, 500);
		dialog.setBlockOnOpen(true);
		dialog.create();
		int open = dialog.open();
		return true;
	}

}
