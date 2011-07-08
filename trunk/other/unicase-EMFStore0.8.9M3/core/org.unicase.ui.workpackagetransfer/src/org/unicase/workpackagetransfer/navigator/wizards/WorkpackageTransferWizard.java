/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workpackagetransfer.navigator.wizards;

import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.workpackagetransfer.WorkItemTransferOperator;

/**
 * @author mkagel Wizard for moving model elements from the selected WorkPackage to a other.
 */
public class WorkpackageTransferWizard extends Wizard implements IWorkbenchWizard {

	private WorkPackage selectedWorkpackage;
	private ChooseWorkItemPage chooseWorkItemPage;

	private boolean canFinish;

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean performFinish() {

		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				WorkItemTransferOperator.moveWorkItems(chooseWorkItemPage.getSelectedWorkItems(),
					chooseWorkItemPage.getTargetWorkPackage(), selectedWorkpackage);
			}
		}.run();

		return true;
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean canFinish() {
		return canFinish;
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {
		chooseWorkItemPage = new ChooseWorkItemPage("Choose WorkItem", this);
		addPage(chooseWorkItemPage);
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {

		canFinish = false;

		Object firstElement;
		if (!selection.isEmpty()) {

			firstElement = selection.getFirstElement();

			if (firstElement instanceof WorkPackage) {
				selectedWorkpackage = (WorkPackage) firstElement;
			} else {
				throw new IllegalArgumentException("No WorkPackage selected");
			}
		} else {
			throw new IllegalArgumentException("Nothing selected");
		}

	}

	/**
	 * Returns the WorkPackage that was selected to choose the WorkItems from.
	 * 
	 * @return the selected WorkPackage which contains the WorkItems to move
	 */
	public WorkPackage getSelectedWorkPackage() {
		return selectedWorkpackage;
	}

}
