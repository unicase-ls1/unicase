/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.mergetest.merge.util.DecisionUtil;
import org.unicase.metamodel.Project;
import org.unicase.workspace.observers.ConflictResolver;

/**
 * .
 * 
 * @author wesendon
 */
public class MergeWizard extends Wizard implements ConflictResolver {

	private DecisionManager decisionManager;

	/**
	 * Default constructor.
	 * 
	 * @param myChangePackage
	 * @param theirChangePackages
	 * @param project
	 */
	public MergeWizard(Project project,
			List<ChangePackage> theirChangePackages,
			ChangePackage myChangePackage) {
		super();
		setWindowTitle("Merge Wizard");
		setDefaultPageImageDescriptor(DecisionUtil
				.getImageDescriptor("merge_wizard.gif"));

		decisionManager = new DecisionManager(project, myChangePackage,
				theirChangePackages);

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
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<AbstractOperation> getAcceptedMine() {
		return new ArrayList<AbstractOperation>();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<AbstractOperation> getRejectedTheirs() {
		return new ArrayList<AbstractOperation>();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean resolveConflicts(Project project,
			List<ChangePackage> theirChangePackages,
			ChangePackage myChangePackage) {

		System.out.println(theirChangePackages);
		System.out.println(myChangePackage);

		return false;
	}

}
