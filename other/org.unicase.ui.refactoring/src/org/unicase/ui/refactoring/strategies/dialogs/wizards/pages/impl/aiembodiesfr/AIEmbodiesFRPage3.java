/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.aiembodiesfr;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.task.ActionItem;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.controls.MERichTextControlWithoutToolbar;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.text.TextSnippets;

/**
 * @author pfeifferc
 */
public class AIEmbodiesFRPage3 extends AbstractRefactoringWizardPage {

	private FunctionalRequirement functionalRequirement;
	
	private ActionItem actionItem;

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage3(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
		actionItem = (ActionItem) wizard.getInvalidModelElement();
		functionalRequirement = RequirementFactory.eINSTANCE.createFunctionalRequirement();
		getRefactoringWizard().addModelElement(functionalRequirement);
		getRefactoringWizard().getParentModelElements().add(functionalRequirement);
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
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE2INFORMATION, "information.png");
		// create instruction text composite
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE2INSTRUCTION, "exclamation.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.NONE, new GridLayout(2, true), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		Composite compositeLeft = createComposite(composite, SWT.NONE, new GridLayout(2, false), new GridData(SWT.FILL, SWT.FILL, true,
			true));
		Composite compositeRight = createComposite(composite, SWT.NONE, new GridLayout(2, false), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		// == left composite ==
		// create pencil icon
		createIconLabel(compositeLeft, "pencil.png");
		// create text for new requirement name
		createText(compositeLeft, "Name:");
		// create input field for new requirement name
		createIconLabel(compositeLeft);
		createMEControl(new METextControl(), compositeLeft, functionalRequirement, "name");
		// create pencil icon
		createIconLabel(compositeLeft, "pencil.png");
		// create text for new requirement description
		createText(compositeLeft, "Description:");
		// create input field for new requirement description
		createIconLabel(compositeLeft);
		createMEControl(new MERichTextControlWithoutToolbar(), compositeLeft, functionalRequirement, "description");
		// create link icon
		createIconLabel(compositeLeft, "link.png");
		// create text for refined requirement
		createText(compositeLeft, "Refined Requirement:");
		// create link for refined requirement
		createIconLabel(compositeLeft);
		createMEControl(new MESingleLinkControl(), compositeLeft, functionalRequirement, "refinedRequirement");
		// create link for leaf section
		createIconLabel(compositeLeft);
		createMEControl(new MESingleLinkControl(), compositeLeft, functionalRequirement, "leafSection");
		// == right composite ==
		// create pencil icon
		createIconLabel(compositeRight, "pencil.png");
		// create text for new requirement name
		createText(compositeRight, "Name:");
		// create input field for new requirement name
		createIconLabel(compositeRight);
		createMEControl(new METextControl(), compositeRight, actionItem, "name");
		// create pencil icon
		createIconLabel(compositeRight, "pencil.png");
		// create text for new requirement description
		createText(compositeRight, "Description:");
		// create input field for new requirement description
		createIconLabel(compositeRight);
		createMEControl(new MERichTextControlWithoutToolbar(), compositeRight, actionItem, "description");
		// create user icon
		createIconLabel(compositeRight, "filtertouser.png");
		// create text for add stakeholder
		createText(compositeRight, "Assignee:");
		// create link for stakeholder
		createIconLabel(compositeRight);
		createMEControl(new MESingleLinkControl(), compositeRight, actionItem, "assignee");
		// set body as control
		setControl(body);
	}
}