/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.aiembodiesfr.old;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
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
public class AIEmbodiesFRPage4 extends AbstractRefactoringWizardPage {

	private ActionItem currentActionItem;

	private Composite body;

	private Composite composite;

	private Combo combo;

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage4(String pageName, AbstractRefactoringWizard wizard) {
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
		// create body composite
		body = createBodyComposite(parent);
		// create affected model element composite
		createModelElementInformationComposite(body);
		// create information text composite
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE4INFORMATION, "information.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.NONE, new GridLayout(3, false), new GridData(SWT.FILL, SWT.NONE, true,
			false));
		// create exclamation icon
		createIconLabel(composite, "exclamation.png");
		// create new action item name text
		createText(composite, "Choose action item to edit:");
		// create the combo to choose between action items
		combo = new Combo(composite, SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		combo.addSelectionListener(new ComboSelectionListener());
		// set body as control
		setControl(body);
	}

	private void updateInputWidgets() {
		// dispose composite
		if (composite != null) {
			super.disposeMEControls();
			composite.dispose();
		}
		composite = createComposite(body, SWT.NONE, new GridLayout(3, false), new GridData(SWT.FILL, SWT.FILL, true,
			true));
		// create pencil icon
		createIconLabel(composite, "pencil.png");
		// create new action item name text
		createText(composite, "Name:");
		// create new action item name input field
		createMEControl(new METextControl(), composite, currentActionItem, "name");
		// create pencil icon
		createIconLabel(composite, "pencil.png");
		// create new action item description text
		createText(composite, "Description:");
		// create new action item description input field
		createMEControl(new MERichTextControlWithoutToolbar(), composite, currentActionItem, "description");
		// create link icon
		createIconLabel(composite, "link.png");
		// create parent text
		createText(composite, "Workpackage:");
		// create containing work package link
		createMEControl(new MESingleLinkControl(), composite, currentActionItem, "containingWorkpackage");
		// create user icon
		createIconLabel(composite, "filtertouser.png");
		// create add assignee text
		createText(composite, "Assignee:");
		// create assignee link
		createMEControl(new MESingleLinkControl(), composite, currentActionItem, "assignee");
		// create user icon
		createIconLabel(composite, "filtertouser.png");
		// create reviewer text
		createText(composite, "Reviewer:");
		// create reviewer link
		createMEControl(new MESingleLinkControl(), composite, currentActionItem, "reviewer");
		// update layout
		composite.layout(true);
		composite.getParent().layout(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.refactoringstrategies.dialogs.wizards.pages.AbstractRefactoringWizardPage#pageSelected()
	 */
	@Override
	public void pageSelected() {
		currentActionItem = (ActionItem) getRefactoringWizard().getChildModelElements().get(0);
		if (composite == null) {
			updateInputWidgets();
		}
		updateCombo();
	}

	/**
	 * @author pfeifferc
	 */
	private final class ComboSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {
			int index = combo.getSelectionIndex();
			if (index >= 0 && index < getRefactoringWizard().getChildModelElements().size()) {
				currentActionItem = (ActionItem) getRefactoringWizard().getChildModelElements().get(index);
			}
			 updateInputWidgets();
			 updateCombo();
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}
	}

	private void updateCombo() {
		String[] strings = new String[getRefactoringWizard().getChildModelElements().size()];
		int i = 0;
		for (ModelElement modelElement : getRefactoringWizard().getChildModelElements()) {
			strings[i++] = ((ActionItem) modelElement).getName();
		}
		combo.setItems(strings);
	}
}