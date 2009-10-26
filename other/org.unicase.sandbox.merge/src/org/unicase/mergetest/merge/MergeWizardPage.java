/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.Project;

/**
 * .
 * 
 * @author wesendon
 */
public class MergeWizardPage extends WizardPage {

	private ArrayList<DecisionBox> decisionBoxes;
	private DecisionManager decisionManager;

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
		decisionManager = new DecisionManager(project, myChangePackage, theirChangePackages);
		setTitle("First Merge Page");
		setDescription("This wizard will lead you through the process of merging.");
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		parent.setLayout(new GridLayout());
//		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.V_SCROLL);
//		GridDataFactory.fillDefaults().grab(true,true).applyTo(scrolledComposite);
//		scrolledComposite.setExpandHorizontal(false);
//		scrolledComposite.setExpandVertical(true);
//		scrolledComposite.setLayout(new GridLayout(1,false));
		
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));
		composite.setLayout(new GridLayout(1,false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

//		scrolledComposite.setContent(composite);
//		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		decisionBoxes = new ArrayList<DecisionBox>();
		for(Conflict conflict : decisionManager.getConflicts()) {
			decisionBoxes.add(new DecisionBox(composite, conflict));
		}

		setControl(parent);
	}
}
