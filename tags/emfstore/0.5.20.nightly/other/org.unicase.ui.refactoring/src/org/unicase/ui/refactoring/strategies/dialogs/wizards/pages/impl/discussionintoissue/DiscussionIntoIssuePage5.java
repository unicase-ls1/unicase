/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.discussionintoissue;

import org.eclipse.jface.dialogs.ProgressIndicator;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.Issue;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.text.TextSnippets;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class DiscussionIntoIssuePage5 extends AbstractRefactoringWizardPage {

	private RefactoringProgressMonitorPart progressMonitorPart;

	/**
	 * The default constructor.
	 * 
	 * @param pageName the
	 * @param wizard the
	 */
	public DiscussionIntoIssuePage5(String pageName, AbstractRefactoringWizard wizard) {
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
		createExplanatoryTextComposite(body, TextSnippets.DISCUSSIONINTOISSUE5INFORMATION, "information.png");
		// create instruction text composite
		createExplanatoryTextComposite(body, TextSnippets.DISCUSSIONINTOISSUE5INSTRUCTION, "exclamation.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.TOP, new GridLayout(2, false), new GridData(SWT.FILL, SWT.FILL, true,
			true));
		// create rotate icon
		createIconLabel(composite, "rotate.png");
		// create progress monitor
		progressMonitorPart = new RefactoringProgressMonitorPart(composite, null); // new GridLayout());
		progressMonitorPart.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
		// set the control
		setControl(body);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.refactoringstrategies.dialogs.wizards.pages.AbstractRefactoringWizardPage#pageSelected()
	 */
	@Override
	public void pageSelected() {
		int totalWork = getRefactoringWizard().getTotalNumberOfElements();
		progressMonitorPart.beginTask("Progress of the refactoring process", totalWork);
		new UnicaseCommandExtension().run();
		progressMonitorPart.subTask("Done!");
	}

	/**
	 * @author pfeifferc
	 */
	private final class UnicaseCommandExtension extends UnicaseCommand {
		@Override
		protected void doRun() {
			Issue issue = null;
			for (ModelElement item : getRefactoringWizard().getParentModelElements()) {
				issue = (Issue) item;
				progressMonitorPart.subTask("Referencing " + issue.getName());
				progressMonitorPart.worked(1);
			}
			for (ModelElement item : getRefactoringWizard().getChildModelElements()) {
				Comment comment = (Comment) item;
				progressMonitorPart.subTask("Referencing " + comment.getName());
				comment.setCommentedElement(issue);
				progressMonitorPart.worked(1);
			}
		}
	}

	/**
	 * @author pfeifferc
	 */
	private final class RefactoringProgressMonitorPart extends ProgressMonitorPart {

		public RefactoringProgressMonitorPart(Composite parent, Layout layout) {
			super(parent, layout);
		}

		@Override
		protected void initialize(Layout layout, int progressIndicatorHeight) {
			if (layout == null) {
				GridLayout l = new GridLayout();
				l.marginWidth = 0;
				l.marginHeight = 0;
				l.numColumns = 1;
				layout = l;
			}
			setLayout(layout);

			fLabel = new Label(this, SWT.WRAP);
			GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
			gridData.heightHint = 30;
			fLabel.setLayoutData(gridData);
			if (progressIndicatorHeight == SWT.DEFAULT) {
				GC gc = new GC(fLabel);
				FontMetrics fm = gc.getFontMetrics();
				gc.dispose();
				progressIndicatorHeight = fm.getHeight();
			}

			fProgressIndicator = new ProgressIndicator(this);
			GridData gd = new GridData();
			gd.horizontalAlignment = GridData.FILL;
			gd.grabExcessHorizontalSpace = true;
			gd.verticalAlignment = GridData.CENTER;
			gd.heightHint = progressIndicatorHeight;
			fProgressIndicator.setLayoutData(gd);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		return this;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getPreviousPage()
	 */
	@Override
	public IWizardPage getPreviousPage() {
		return this;
	}
}