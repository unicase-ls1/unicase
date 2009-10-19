/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest.merge;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.Project;

/**
 * .
 * 
 * @author wesendon
 */
public class MergeWizardPage extends WizardPage {

	private final Project project;
	private final List<ChangePackage> theirChangePackages;
	private final ChangePackage myChangePackage;

	/**
	 * Default constructor.
	 * 
	 * @param pageName
	 *            page name
	 * @param myChangePackage
	 * @param theirChangePackages
	 * @param project
	 */
	protected MergeWizardPage(String pageName, Project project,
			List<ChangePackage> theirChangePackages,
			ChangePackage myChangePackage) {
		super(pageName);
		this.project = project;
		this.theirChangePackages = theirChangePackages;
		this.myChangePackage = myChangePackage;

		setTitle("First Merge Page");
		setDescription("This wizard will lead you through the process of merging.");
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		parent.setLayout(new GridLayout());
		GridLayout gridLayout = new GridLayout();
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		DecisionManager decisionManager = new DecisionManager(project, myChangePackage, theirChangePackages);
		for(Conflict conflict : decisionManager.getConflicts()) {
			new DecisionBox(composite, conflict);
		}

		setControl(parent);
	}
}
