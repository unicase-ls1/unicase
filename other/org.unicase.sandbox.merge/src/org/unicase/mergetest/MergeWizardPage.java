/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.mergetest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.conflictDetection.ConflictDetector;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
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
		Text text = new Text(composite, SWT.NONE);
		text.setText("Here could be your Operation.");

		ConflictDetector conflictDetector = new ConflictDetector();
		Set<AbstractOperation> conflicting = conflictDetector.getConflicting(
				myChangePackage.getOperations(), theirChangePackages.get(0)
						.getOperations());

		HashMap<AbstractOperation, Set<AbstractOperation>> hashMap = new HashMap<AbstractOperation, Set<AbstractOperation>>();
		for (AbstractOperation ao : conflicting) {
			Set<AbstractOperation> set = conflictDetector.getConflicting(theirChangePackages.get(0).getOperations(),Arrays
					.asList(ao));
			hashMap.put(ao, set);
		}

		for (AbstractOperation ao : hashMap.keySet()) {
			if (ao instanceof AttributeOperation) {
				// ao.get
				Iterator<AbstractOperation> iterator = hashMap.get(ao).iterator();
				
				if(!iterator.hasNext())
					continue;
				
				AbstractOperation opposite = iterator.next();

				createMergeDecision(composite, project.getModelElement(
						ao.getModelElementId()).getName(),
						((AttributeOperation) ao).getFeatureName(),
						(String) ((AttributeOperation) ao).getNewValue(),
						(String) ((AttributeOperation) opposite).getNewValue());
			}
		}

		createMergeDecision(composite, "Implement time machine", "assign to",
				"shterevg", "hodaie");
		createMergeDecision(composite, "Document time machine", "review",
				"wesendon", "hodaie");
		setControl(parent);
	}

	private void createMergeDecision(Composite composite,
			String modelElementName, String attributeName, String myName,
			String theirName) {
		Composite mergeDecision = new Composite(composite, SWT.BORDER);
		GridLayout gridLayout2 = new GridLayout(4, false);
		mergeDecision.setLayout(gridLayout2);
		mergeDecision
				.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// mergeDecision.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_GRAY));
		Link link = new Link(mergeDecision, SWT.LEFT);
		link.setText(modelElementName);
		link.setEnabled(true);
		Text attribute = new Text(mergeDecision, SWT.NONE);
		attribute.setText(attributeName + ":");
		attribute
				.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true));
		Button my = new Button(mergeDecision, SWT.NONE);
		my.setText(myName);
		Button their = new Button(mergeDecision, SWT.NONE);
		their.setText(theirName);
	}

}
