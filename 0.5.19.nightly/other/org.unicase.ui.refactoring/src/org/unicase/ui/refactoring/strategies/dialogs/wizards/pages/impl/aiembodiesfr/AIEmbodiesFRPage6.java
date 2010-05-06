/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.impl.aiembodiesfr;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.ActionItem;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.AbstractRefactoringWizardPage;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.pages.controls.RefactoringProgressMonitorPart;
import org.unicase.ui.refactoring.strategies.dialogs.wizards.text.TextSnippets;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author pfeifferc
 */
public class AIEmbodiesFRPage6 extends AbstractRefactoringWizardPage {

	private RefactoringProgressMonitorPart progressMonitorPart;

	/**
	 * The default constructor.
	 * 
	 * @param wizard the
	 * @param pageName the
	 */
	public AIEmbodiesFRPage6(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName, wizard);
		setPageComplete(false);
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
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE6INFORMATION, "information.png");
		// create instruction text composite
		createExplanatoryTextComposite(body, TextSnippets.AIEMBODIESFRPAGE6INSTRUCTION, "exclamation.png");
		// create the composite to put the widgets on
		composite = createComposite(body, SWT.TOP, new GridLayout(2, false), new GridData(SWT.FILL, SWT.FILL, true,
			true));
		// create rotate icon
		createIconLabel(composite, "rotate.png");
		// create progress monitor
		progressMonitorPart = new RefactoringProgressMonitorPart(composite, null); // new GridLayout());
		progressMonitorPart.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
		// set body as control
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
			FunctionalRequirement functionalRequirement = null;
			for (ModelElement modelElement : getRefactoringWizard().getParentModelElements()) {
				functionalRequirement = (FunctionalRequirement) modelElement;
				progressMonitorPart.subTask("Creating " + functionalRequirement.getName());
				progressMonitorPart.worked(1);
			}
			for (ModelElement modelElement : getRefactoringWizard().getChildModelElements()) {
				ActionItem actionItem = (ActionItem) modelElement;
				progressMonitorPart.subTask("Referencing " + functionalRequirement.getName());
				actionItem.getAnnotatedModelElements().add(functionalRequirement);
				progressMonitorPart.worked(1);
			}
			progressMonitorPart.subTask("Done!");
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