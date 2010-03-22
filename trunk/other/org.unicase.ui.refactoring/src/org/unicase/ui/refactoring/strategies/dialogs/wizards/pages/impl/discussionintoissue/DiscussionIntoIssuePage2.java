/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.discussionintoissue;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.rationale.Comment;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.text.TextSnippets;

/**
 * @author pfeifferc
 */
public class DiscussionIntoIssuePage2 extends AbstractRefactoringWizardPage {

	private Tree tree;

	/**
	 * The default constructor.
	 * 
	 * @param pageName the
	 * @param wizard the
	 */
	public DiscussionIntoIssuePage2(String pageName, AbstractRefactoringWizard wizard) {
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
		createExplanatoryTextComposite(body, TextSnippets.DISCUSSIONINTOISSUE2INFORMATION, "information.png");
		// create instruction text composite
		createExplanatoryTextComposite(body, TextSnippets.DISCUSSIONINTOISSUE2INSTRUCTION, "exclamation.png");
		// create scrolled composite to put the widgets on
		ScrolledComposite scrolledComposite = new ScrolledComposite(body, SWT.BORDER | SWT.V_SCROLL);
		scrolledComposite.setLayout(new GridLayout(1, true));
		scrolledComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(1, true));
		tree = new Tree(composite, SWT.MULTI | SWT.BORDER);
		tree.setLayoutData(new GridData(GridData.FILL_BOTH));
		// populate the tree
		populateTree(tree, getRefactoringWizard().getInvalidModelElement());
		// set scrolled composite properties
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		scrolledComposite.setContent(composite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setAlwaysShowScrollBars(true);
		// set the control
		setControl(body);
	}

	private void populateTree(Object tree, UnicaseModelElement parent) {
		for (Comment comment : parent.getComments()) {
			TreeItem treeItem = null;
			if (tree instanceof Tree) {
				treeItem = new TreeItem((Tree) tree, SWT.NONE);
			} else {
				treeItem = new TreeItem((TreeItem) tree, SWT.NONE);
			}
			treeItem.setText("" + comment.getDescription());
			treeItem.setImage(getRefactoringWizard().getLabelProvider().getImage(comment));
			treeItem.setData(comment);
			populateTree(treeItem, comment);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		getRefactoringWizard().getChildModelElements().clear();
		for (TreeItem treeItem : tree.getSelection()) {
			getRefactoringWizard().getChildModelElements().add((Comment) treeItem.getData());
		}
		return super.getNextPage();
	}
}