/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.aiembodiesfr;

import org.eclipse.jface.wizard.IWizardPage;
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
public class AIEmbodiesFRPage5 extends AbstractRefactoringWizardPage {

	private Button button;

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage5(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
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
		// the body composite to place everything else on
		Composite body = createBodyComposite(parent);
		// create affected model element composite
		createModelElementInformationComposite(body);
		// create information text composite
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE5INFORMATION, "information.png");
		// create instruction text composite
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE5INSTRUCTION, "exclamation.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.TOP, new GridLayout(3, false),
			new GridData(SWT.FILL, SWT.TOP, true, true));
		// create arrow icon
		createIconLabel(composite, "arrow_divide.png");
		// create choose text
		createText(composite, "Please choose:");
		// create the composite to put the widgets on
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginLeft = 25;
		composite = createComposite(composite, SWT.TOP, gridLayout, new GridData(SWT.FILL, SWT.FILL, true, false));
		// create go on button
		button = new Button(composite, SWT.RADIO);
		button.setSelection(true);
		button.addSelectionListener(new ButtonSelectionListener());
		// create go on texts
		createText(composite, "Please continue with the creation process.");
		// create go on button
		button = new Button(composite, SWT.RADIO);
		button.addSelectionListener(new ButtonSelectionListener());
		// create go on text
		createText(composite, "Please let me go through the process one more time and review my choices.", true);
		// set body as control
		setControl(body);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		if (button.getSelection()) {
			return getRefactoringWizard().getPage("page2");
		} else {
			return super.getNextPage();
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class ButtonSelectionListener implements SelectionListener {
		public void widgetSelected(SelectionEvent e) {
			setPageComplete(true);
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}
	}
}
