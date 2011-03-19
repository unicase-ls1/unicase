/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.emfstore.client.exceptions.ChangeConflictException;
import org.eclipse.emf.emfstore.client.observers.ConflictResolver;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ui.dialogs.merge.DecisionManager;
import org.unicase.workspace.ui.dialogs.merge.MergeWizard;
import org.unicase.workspace.ui.dialogs.merge.util.CaseStudySwitch;

/**
 * This is an alternative merge handler, using the new merge wizard.
 * 
 * @author wesendon
 */
public class MergeProjectHandler implements ConflictResolver {

	private List<AbstractOperation> acceptedMine;
	private List<AbstractOperation> rejectedTheirs;

	/**
	 * Default constructor.
	 * 
	 * @param conflictException
	 *            the ChangeConflictException
	 */
	public MergeProjectHandler(ChangeConflictException conflictException) {
		acceptedMine = new ArrayList<AbstractOperation>();
		rejectedTheirs = new ArrayList<AbstractOperation>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.observers.ConflictResolver#getAcceptedMine()
	 */
	public List<AbstractOperation> getAcceptedMine() {
		return acceptedMine;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.observers.ConflictResolver#getAcceptedMine()
	 */
	public List<AbstractOperation> getRejectedTheirs() {
		return rejectedTheirs;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.client.observers.ConflictResolver#getAcceptedMine()
	 */
	public boolean resolveConflicts(Project project,
			List<ChangePackage> theirChangePackages,
			ChangePackage myChangePackage, PrimaryVersionSpec base,
			PrimaryVersionSpec target) {

		boolean caseStudy = false;

		if (caseStudy) {
			CaseStudySwitch studySwitch = new CaseStudySwitch();
			studySwitch.flattenChangePackages(myChangePackage,
					theirChangePackages);
		}

		DecisionManager decisionManager = new DecisionManager(project,
				myChangePackage, theirChangePackages, base, target);

		MergeWizard wizard = new MergeWizard(decisionManager);
		WizardDialog dialog = new WizardDialog(Display.getCurrent()
				.getActiveShell(), wizard);
		dialog.setPageSize(1000, 500);
		dialog.setBlockOnOpen(true);
		dialog.create();

		int open = dialog.open();
		acceptedMine = decisionManager.getAcceptedMine();
		rejectedTheirs = decisionManager.getRejectedTheirs();

		if (open != Window.OK) {
			decisionManager.getEventLogger().selectedCancel();
		}

		return (open == Window.OK);
	}
}
