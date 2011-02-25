/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.discussionintoissue;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.controls.MERichTextControlWithoutToolbar;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.text.TextSnippets;

/**
 * @author pfeifferc
 */
public class DiscussionIntoIssuePage3 extends AbstractRefactoringWizardPage {

	private Issue issue;

	/**
	 * The default constructor.
	 * 
	 * @param pageName the
	 * @param wizard the
	 */
	public DiscussionIntoIssuePage3(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
		issue = RationaleFactory.eINSTANCE.createIssue();
		getRefactoringWizard().addModelElement(issue);
		getRefactoringWizard().getParentModelElements().add(issue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.refactoringstrategies.dialogs.wizards.pages.AbstractRefactoringWizardPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		// reusable variables
		Composite composite;
		// create body composite as base for the other composites
		Composite body = createBodyComposite(parent);
		// create affected model element composite
		createModelElementInformationComposite(body);
		// create information text composite
		createExplanatoryTextComposite(body, TextSnippets.DISCUSSIONINTOISSUE3INFORMATION, "information.png");
		// create instruction text composite
		createExplanatoryTextComposite(body, TextSnippets.DISCUSSIONINTOISSUE3INSTRUCTION, "exclamation.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.NONE, new GridLayout(3, false), new GridData(SWT.FILL, SWT.FILL, true,
			true));
		// create pencil icon
		createIconLabel(composite, "pencil.png");
		// create text for new issue name
		createText(composite, "New issue Name:");
		// create input field for new requirement name
		createMEControl(new METextControl(), composite, issue, "name");
		// create pencil icon
		createIconLabel(composite, "pencil.png");
		// create text for new requirement description
		createText(composite, "New issue Description:");
		// create input field for new requirement description
		createMEControl(new MERichTextControlWithoutToolbar(), composite, issue, "description");
		// create link icon
		createIconLabel(composite, "link.png");
		// create text for work package
		createText(composite, "Workpackage:");
		// create link for work package
		createMEControl(new MESingleLinkControl(), composite, issue, "containingWorkpackage");
		// create user icon
		createIconLabel(composite, "filtertouser.png");
		// create add assignee text
		createText(composite, "Assignee:");
		// create assignee link
		createMEControl(new MESingleLinkControl(), composite, issue, "assignee");
		// create user icon
		createIconLabel(composite, "filtertouser.png");
		// create reviewer text
		createText(composite, "Reviewer:");
		// create reviewer link
		createMEControl(new MESingleLinkControl(), composite, issue, "reviewer");
		// set body as control
		setControl(body);
	}
}
