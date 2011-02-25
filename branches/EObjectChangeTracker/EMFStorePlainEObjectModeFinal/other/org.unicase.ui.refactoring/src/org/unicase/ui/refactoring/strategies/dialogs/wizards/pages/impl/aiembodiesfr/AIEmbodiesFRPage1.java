/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.aiembodiesfr;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.text.TextSnippets;

/**
 * @author pfeifferc
 */
public class AIEmbodiesFRPage1 extends AbstractRefactoringWizardPage {

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage1(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
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
		createModelElementInformationComposite(body);
		// create information text composite
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE1INFORMATION, "information.png");
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
		createText(composite, "The action item is in fact a functional requirement");
		// create go on button
		new Button(composite, SWT.RADIO);
		// create go on text
		createText(composite, "The action item is fine as is, please let me add a functional requirement");
		// set this as control for the page
		setControl(body);
	}

	/**
	 * @author pfeifferc
	 */
	private final class ContinueButtonSelectionListener implements SelectionListener {
		public void widgetSelected(SelectionEvent e) {
			setPageComplete(((Button) e.getSource()).getSelection());
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}
	}

}