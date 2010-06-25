/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.aiembodiesfr;

import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementFactory;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.task.ActionItem;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.util.controls.MERichTextControlWithoutToolbar;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.util.controls.MESingeLinkControlWithoutNewReferenceAction;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class AIEmbodiesFRPage2 extends AbstractRefactoringWizardPage implements ModelElementChangeListener {

	private static final String GUIDE = "The action item contains information that should be contained in a " +
	"functional requirement. Therefore, you can now choose an existing, one that is already annotating " +
	"the action item or create a new functional " +
	"requirement to store this information in. You will then be able to edit both the action item and " +
	"the functional requirement at the same time.";

	private FunctionalRequirement functionalRequirement;

	private ActionItem actionItem;

	private Composite body;

	private Composite composite;

	private Button newButton;

	private Button existingButton;

	private Button annotatedButton;

	private Text advisoryText;

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage2(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
		actionItem = (ActionItem) wizard.getInvalidModelElement();
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
		body = createBodyComposite(parent);
		// create affected model element composite
		createModelElementInformationComposite(body);
		// create separator
		createSeparator(body);
		// create information text composite
		createExplanatoryTextComposite(body, GUIDE, "information.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.NONE, new GridLayout(2, false), new GridData(SWT.BEGINNING, SWT.TOP, true,
				false));
		// create information text composite
		createIconLabel(composite, "exclamation.png");
		// create text for new requirement description
		advisoryText = createText(composite, "Please choose one of the options:", true);
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.NONE, new GridLayout(2, false), new GridData(SWT.BEGINNING, SWT.TOP, true,
				false));
		// create icon label
		Label label = createIconLabel(composite, "arrow_divide.png");
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		// create the composite to put the widgets on
		composite = createComposite(composite, SWT.NONE, new GridLayout(3, true), new GridData(SWT.BEGINNING, SWT.TOP, true,
				false));
		// button layout data
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		// create button create new
		newButton = new Button(composite, SWT.PUSH);
		newButton.setLayoutData(gridData);
		newButton.setText("Create new");
		newButton.addSelectionListener(new NewSelectionListener());
		// create button choose existing
		existingButton = new Button(composite, SWT.PUSH);
		existingButton.setLayoutData(gridData);
		existingButton.setText("Choose existing");
		existingButton.addSelectionListener(new ChooseSelectionListener());
		// create button choose among annotated
		annotatedButton = new Button(composite, SWT.PUSH);
		annotatedButton.setLayoutData(gridData);
		annotatedButton.setText("Choose already annotated");
		annotatedButton.addSelectionListener(new AnnotatedSelectionListener());
		// set body as control
		setControl(body);
	}

	private void updateInputWidgets() {
		// dispose composite
		if (composite != null) {
			super.disposeMEControls();
			composite.dispose();
		}
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.NONE, new GridLayout(2, true), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		Composite compositeLeft = createComposite(composite, SWT.NONE, new GridLayout(2, false), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		Composite compositeRight = createComposite(composite, SWT.NONE, new GridLayout(2, false), new GridData(SWT.FILL, SWT.FILL, true,
				true));
		// == LEFT composite ==
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
		createMEControl(new MESingeLinkControlWithoutNewReferenceAction(), compositeLeft, functionalRequirement, "refinedRequirement");
		// // create link icon
		// createIconLabel(compositeLeft, "link.png");
		// // create text for refined requirement
		// createText(compositeLeft, "Leaf section:");
		// // create link for refined requirement
		// createIconLabel(compositeLeft);
		// createMEControl(new MESingeLinkControlWithoutNewReferenceAction(), compositeLeft, functionalRequirement, "leafSection");
		// == RIGHT composite ==
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
		createMEControl(new MESingeLinkControlWithoutNewReferenceAction(), compositeRight, actionItem, "assignee");
		// update layout
		composite.layout(true);
		composite.getParent().layout(true);
	}

	/**
	 * @author pfeifferc
	 */
	private class NewSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do here
		}

		public void widgetSelected(SelectionEvent e) {
			// Create a new functional requirement, add it to the project and disable all buttons (no backward)
			functionalRequirement = RequirementFactory.eINSTANCE.createFunctionalRequirement();
			getRefactoringWizard().addModelElement(functionalRequirement);
			newButton.setEnabled(false);
			existingButton.setEnabled(false);
			annotatedButton.setEnabled(false);
			functionalRequirement.addModelElementChangeListener(AIEmbodiesFRPage2.this);
			addModelElementChangeListener(functionalRequirement, AIEmbodiesFRPage2.this);
			// only advance when parent model element is set
			setPageComplete(false);
			advisoryText.setText("Please set a parent element for the new functional requirement. " +
					"Otherwise you will not be able to finish the dialog.");
			updateInputWidgets();
		}
	}

	/**
	 * @author pfeifferc
	 */
	private class ChooseSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do here
		}

		public void widgetSelected(SelectionEvent e) {
			// Choose a functional requirement among the existing ones
			FunctionalRequirementSelectionDialog functionalRequirementSelectionDialog = new FunctionalRequirementSelectionDialog(UnicaseActionHelper.getContext(actionItem), RequirementPackage.eINSTANCE.getFunctionalRequirement(), false);
			functionalRequirementSelectionDialog.open();
			functionalRequirement = (FunctionalRequirement) functionalRequirementSelectionDialog.getFirstResult();
			// if chosen, update controls and wizard may advance
			if(functionalRequirement != null) {
				setPageComplete(true);
				updateInputWidgets();
			}
		}
	}

	/**
	 * @author pfeifferc
	 */
	private class AnnotatedSelectionListener implements SelectionListener {

		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do here
		}

		public void widgetSelected(SelectionEvent e) {
			// Choose among the already annotated, if there are any
			FunctionalRequirementSelectionDialog functionalRequirementSelectionDialog = new FunctionalRequirementSelectionDialog(UnicaseActionHelper.getContext(actionItem), RequirementPackage.eINSTANCE.getFunctionalRequirement(), false);
			EList<UnicaseModelElement> unicaseModelElements = actionItem.getAnnotatedModelElements();
			Vector<EObject> functionalRequirements = new Vector<EObject>();
			for(UnicaseModelElement unicaseModelElement : unicaseModelElements) {
				if(unicaseModelElement instanceof FunctionalRequirement) {
					functionalRequirements.add(unicaseModelElement);
				}
			}
			functionalRequirementSelectionDialog.setModelElements(functionalRequirements);
			functionalRequirementSelectionDialog.open();
			// if chosen, update controls and wizard may advance
			functionalRequirement = (FunctionalRequirement) functionalRequirementSelectionDialog.getFirstResult();
			if(functionalRequirement != null) {
				setPageComplete(true);
				updateInputWidgets();
			}
		}
	}

	/**
	 * @author pfeifferc
	 */
	private class FunctionalRequirementSelectionDialog extends ModelElementSelectionDialog {

		FunctionalRequirementSelectionDialog(ModelElementContext modelElementContext, EClass eClass, boolean multiSelection) {
			super(modelElementContext, eClass, multiSelection);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				// add the functional requirement to the annotated model elements
				actionItem.getAnnotatedModelElements().add(functionalRequirement);
			}
		}.run();
		getRefactoringWizard().setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
		ActionHelper.openModelElement(functionalRequirement, "org.unicase.ui.refactoring");
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canFinish() {
		return isPageComplete();
	}

	/**
	 * {@inheritDoc}
	 */
	public void onChange(Notification notification) {
		// check if functional requirement has a parent model element, if true allow wizard to go on
		if(((EObject) notification.getNotifier()).eContainer() != null) {
			advisoryText.setText("You may finish the dialog when you are done with the editing.");
			setPageComplete(true);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void onRuntimeExceptionInListener(RuntimeException exception) {
		// nothing to do here
	}
	
}