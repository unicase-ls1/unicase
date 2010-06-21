/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.menewname;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * @author pfeifferc
 */
public class MENewNamePage1 extends AbstractRefactoringWizardPage {

	private static final String GUIDE = "Please choose a new name for the model element.";
	
	private UnicaseModelElement unicaseModelElement;

	/**
	 * Constructor. 
	 * 
	 * @param pageName the
	 * @param wizard the
	 */
	public MENewNamePage1(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
		unicaseModelElement = (UnicaseModelElement) getRefactoringWizard().getInvalidModelElement();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		// reusable variables
		Composite composite;
		// create body composite as base for the other composites
		Composite body = createBodyComposite(parent);
		// create affected model element composite
		createModelElementInformationCompositeWithDescription(body);
		// create separator
		createSeparator(body);
		// create instruction text composite
		createExplanatoryTextComposite(body, GUIDE, "validation.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.TOP, new GridLayout(3, false), new GridData(SWT.FILL, SWT.TOP, true,
				false));
		// create arrow icon
		createIconLabel(composite, "pencil.png");
		// create new name text
		createText(composite, "New name:");
		// create input field for new requirement name
		createMEControl(new METextControl(), composite, unicaseModelElement, "name");
		// set this as control for the page
		setControl(body);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canFinish() {
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		getRefactoringWizard().setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
		return true;
	}
}
