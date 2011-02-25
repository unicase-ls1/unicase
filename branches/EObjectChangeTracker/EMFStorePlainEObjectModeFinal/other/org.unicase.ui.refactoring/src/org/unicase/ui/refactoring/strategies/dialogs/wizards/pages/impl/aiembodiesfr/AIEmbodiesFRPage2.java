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
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.controls.MERichTextControlWithoutToolbar;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.text.TextSnippets;

/**
 * @author pfeifferc
 */
public class AIEmbodiesFRPage2 extends AbstractRefactoringWizardPage {

	private FunctionalRequirement functionalRequirement;

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage2(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
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
		composite = createComposite(body, SWT.NONE, new GridLayout(3, false), new GridData(SWT.FILL, SWT.FILL, true,
			true));
		// create pencil icon
		createIconLabel(composite, "pencil.png");
		// create text for new requirement name
		createText(composite, "Name:");
		// create input field for new requirement name
		createMEControl(new METextControl(), composite, functionalRequirement, "name");
		// create pencil icon
		createIconLabel(composite, "pencil.png");
		// create text for new requirement description
		createText(composite, "Description:");
		// create input field for new requirement description
		createMEControl(new MERichTextControlWithoutToolbar(), composite, functionalRequirement, "description");
		// create link icon
		createIconLabel(composite, "link.png");
		// create text for refined requirement
		createText(composite, "Refined Requirement:");
		// create link for refined requirement
		createMEControl(new MESingleLinkControl(), composite, functionalRequirement, "refinedRequirement");
		// create user icon
		createIconLabel(composite, "filtertouser.png");
		// create text for add stakeholder
		createText(composite, "Stakeholder:");
		// create link for stakeholder
		createMEControl(new MESingleLinkControl(), composite, functionalRequirement, "stakeholder");
		// set body as control
		setControl(body);
	}
}