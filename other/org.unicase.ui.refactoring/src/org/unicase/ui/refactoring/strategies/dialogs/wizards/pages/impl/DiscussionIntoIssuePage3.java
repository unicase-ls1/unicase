/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.util.controls.MERichTextControlWithoutToolbar;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.util.controls.MESingeLinkControlWithoutNewReferenceAction;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class DiscussionIntoIssuePage3 extends AbstractRefactoringWizardPage implements ModelElementChangeListener {

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
		issue.addModelElementChangeListener(this);
		addModelElementChangeListener(issue, this);
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
		// create separator
		createSeparator(body);
		// create instruction text composite
		createExplanatoryTextComposite(body, "Please specify the details needed for the new issue. In order to finish " +
				"the wizard, you need to set a parent element for the issue.", "exclamation.png");
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
		createMEControl(new MESingeLinkControlWithoutNewReferenceAction(), composite, issue, "containingWorkpackage");
		// create user icon
		createIconLabel(composite, "filtertouser.png");
		// create add assignee text
		createText(composite, "Assignee:");
		// create assignee link
		createMEControl(new MESingeLinkControlWithoutNewReferenceAction(), composite, issue, "assignee");
		// create user icon
		createIconLabel(composite, "filtertouser.png");
		// create reviewer text
		createText(composite, "Reviewer:");
		// create reviewer link
		createMEControl(new MESingeLinkControlWithoutNewReferenceAction(), composite, issue, "reviewer");
		// set body as control
		setControl(body);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onChange(Notification notification) {
		Issue issue = (Issue) notification.getNotifier();
		setPageComplete(issue.getLeafSection() != null || issue.getContainingWorkpackage() != null || issue.getProject() != null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onRuntimeExceptionInListener(RuntimeException exception) {
		// nothing to do here
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		getRefactoringWizard().setRefactoringResult(RefactoringResult.SUCCESS_CREATE);
		new UnicaseCommand() {
			
			@Override
			protected void doRun() {
				// add the chosen comments to be the parent comments of the new issue
				for(ModelElement modelElement: getRefactoringWizard().getChildModelElements()) {
					Comment comment = (Comment) modelElement;
					((UnicaseModelElement) getRefactoringWizard().getParentModelElements().get(0)).getComments().add(comment);
				}
				getRefactoringWizard().getInvalidModelElement().getAnnotations().add(issue);
			}
		}.run();
		ActionHelper.openModelElement(issue, "org.unicase.ui.refactoring");
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canFinish() {
		return isPageComplete();
	}
}
