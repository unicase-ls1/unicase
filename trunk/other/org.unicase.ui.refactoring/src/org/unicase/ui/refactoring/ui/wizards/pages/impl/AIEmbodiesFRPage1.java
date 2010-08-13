/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.ui.wizards.pages.impl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.unicase.ui.refactoring.ui.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.ui.wizards.AbstractRefactoringWizardPage;
import org.unicase.ui.validation.refactoring.RefactoringResult;

/**
 * @author pfeifferc
 */
public class AIEmbodiesFRPage1 extends AbstractRefactoringWizardPage {

	private static final String GUIDE = "The action item above might contain a functional requirement. " +
			"A functional requirement describes a certain function, the action item its implementation details. " +
			"In case you think the action item really is a functional requirement, the following pages will guide " +
			"you through a refactoring.";

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage1(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
		setPageComplete(true);
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
		// separator line
		createSeparator(body);
		// create information text composite
		createExplanatoryTextComposite(body, GUIDE, "validation.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.TOP, new GridLayout(3, false), new GridData(SWT.FILL, SWT.TOP, true,
			false));
		// create arrow icon
		createIconLabel(composite, "arrow_divide.png");
		// create choose text
		createText(composite, "Please choose:");
		// create the composite to put the widgets on
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginLeft = 25;
		composite = createComposite(composite, SWT.TOP, gridLayout, new GridData(SWT.FILL, SWT.FILL, true, true));
		// create go on button
		Button button = new Button(composite, SWT.RADIO);
		button.setSelection(true);
		button.addSelectionListener(new ContinueButtonSelectionListener());
		// create go on texts
		createText(composite, "The action item is a functional requirement");
		// create is not button
		new Button(composite, SWT.RADIO);
		// create is not text
		createText(composite, "The action item is not a functional requirement (remember this)");
		// set this as control for the page
		setControl(body);
	}

	/**
	 * @author pfeifferc
	 */
	private final class ContinueButtonSelectionListener implements SelectionListener {
		public void widgetSelected(SelectionEvent e) {
			boolean selection = ((Button) e.getSource()).getSelection();
			setPageComplete(selection);
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canFinish() {
		return !isPageComplete();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		getRefactoringWizard()	.setRefactoringResult(RefactoringResult.NO_VIOLATION);
		return super.performFinish();
	}
}