/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl;

import java.util.List;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.rationale.Comment;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.unicasecommon.common.widgets.MECommentWidget;
import org.unicase.ui.validation.refactoring.strategy.RefactoringResult;

/**
 * @author pfeifferc
 */
public class DiscussionIntoIssuePage1 extends AbstractRefactoringWizardPage {

	private static final String GUIDE = "The model element present above has a greater amount of comments. It might therefore " +
	"actually be an issue, in which case the comments should be contained in a new issue. As a first step, " +
	"please review the discussion thread.";

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public DiscussionIntoIssuePage1(String pageName, AbstractRefactoringWizard wizard) {
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
		// create separator
		createSeparator(body);
		// create instruction text composite
		createExplanatoryTextComposite(body, GUIDE, "validation.png");
		// create scrolled composite to put the widgets on
		ScrolledComposite scrolledComposite = new ScrolledComposite(body, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setLayout(new GridLayout(1, true));
		scrolledComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		// create the composite to put the widgets on
		composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, true));
		// add comments
		List<Comment> comments = ((UnicaseModelElement) getRefactoringWizard().getInvalidModelElement()).getComments();
		for (Comment comment : comments) {
			MECommentWidget widget = new MECommentWidget(comment, composite);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(widget);
		}
		// set scrolled composite properties
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setAlwaysShowScrollBars(true);
		// set scrolled composite content
		scrolledComposite.setContent(composite);
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
		createText(composite, "The comment thread is an issue");
		// create is not button
		new Button(composite, SWT.RADIO);
		// create is not text
		createText(composite, "The comment thread is not an issue (remember this)");
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
			if(!selection) {
				getRefactoringWizard().setRefactoringResult(RefactoringResult.NO_VIOLATION);
			}
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
		getRefactoringWizard().setRefactoringResult(RefactoringResult.NO_VIOLATION);
		return super.performFinish();
	}
}