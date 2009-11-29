/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.multiaction.navigator.wizards;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.multiaction.MultiActionGenerator;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * @author naughton Wizard for creating a follow-up meeting.
 */
public class MultiactionWizard extends Wizard implements IWorkbenchWizard {

	private ActionItem selectedActionItem;
	private EList<OrgUnit> assignees;
	private boolean canFinish;
	private ChooseAsigneePage assigneePage;

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
		assigneePage = new ChooseAsigneePage("chooseAssignees");
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
		assignees = new BasicEList<OrgUnit>();
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean performFinish() {
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				WorkPackage wp = MultiActionGenerator.getInstance().generateMultiAction(selectedActionItem, assignees);
				UnicaseActionHelper.openModelElement(wp, this.getClass().getName());

			}
		}.run();		
		
		return true;
	}

	
}
