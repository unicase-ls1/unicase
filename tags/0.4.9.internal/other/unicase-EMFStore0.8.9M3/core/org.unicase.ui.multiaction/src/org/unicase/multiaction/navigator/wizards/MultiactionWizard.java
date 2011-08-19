/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.multiaction.navigator.wizards;

import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.multiaction.MultiActionGenerator;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * @author jfinis Wizard for assigning an action item to a group of users.
 */
public class MultiactionWizard extends Wizard implements IWorkbenchWizard {

	private ActionItem selectedActionItem;
	private boolean canFinish;
	private ChooseAssigneePage assigneePage;

	/**
	 * Returns the action item that was selected to be assigned to a group.
	 * 
	 * @return the action item to be assigned to a group
	 */
	public ActionItem getSelectedActionItem() {
		return selectedActionItem;
	}

	/**
	 * Sets if the wizard can be finished.
	 * 
	 * @param canFinish Can the wizard finish?
	 */
	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {
		assigneePage = new ChooseAssigneePage("chooseAssignees", this);
		addPage(assigneePage);
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
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		canFinish = false;
		// get the meeting selected in the navigator
		Object firstElement;
		if (!selection.isEmpty()) {
			firstElement = selection.getFirstElement();
			if (firstElement instanceof ActionItem) {
				selectedActionItem = (ActionItem) firstElement;
			} else {
				throw new IllegalArgumentException("No ActionItem selected!");
			}
		} else {
			throw new IllegalArgumentException("Nothing selected!");
		}
	}

	/**
	 * Upon finishing, the old action item is split into many action items and a containing work package and the work
	 * package is opened in the MEEditor. ({@inheritDoc})
	 */
	@Override
	public boolean performFinish() {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				WorkPackage wp = MultiActionGenerator.generateMultiAction(selectedActionItem,
					assigneePage.getSelected());
				UnicaseActionHelper.openModelElement(wp, this.getClass().getName());

			}
		}.run();

		return true;
	}

}
