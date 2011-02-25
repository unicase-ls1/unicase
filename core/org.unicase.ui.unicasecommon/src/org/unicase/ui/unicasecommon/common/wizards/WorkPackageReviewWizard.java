/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.wizards;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.wizards.wizardpages.WorkItemSectionSelectionPage;
import org.unicase.ui.unicasecommon.common.wizards.wizardpages.WorkItemSelectionPage;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author naughton Wizard for creating a follow-up meeting.
 */
public class WorkPackageReviewWizard extends Wizard implements IWorkbenchWizard {
	private WorkItemSelectionPage workItemSelectionPage;
	private WorkItemSectionSelectionPage workItemSectionSelectionPage;
	private Meeting meeting;
	private EList<WorkItem> workItems;

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {
		workItemSelectionPage = new WorkItemSelectionPage("WorkItemSelectionPage");
		addPage(workItemSelectionPage);
		workItemSectionSelectionPage = new WorkItemSectionSelectionPage("WorkItemSectionSelectionPage");
		addPage(workItemSectionSelectionPage);
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

	/**
	 * Initialize the wizard.
	 * 
	 * @param meeting the meeting
	 * @param workItems the workItems
	 */
	public void init(Meeting meeting, EList<WorkItem> workItems) {
		this.meeting = meeting;
		this.workItems = workItems;
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean performFinish() {
		TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();

		final WorkItemMeetingSection selectedSection = workItemSectionSelectionPage.getSelectedSection();
		final EList<WorkItem> selectedWorkItems = workItemSelectionPage.getSelectedWorkItems();

		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				// HN: Notification.ADD_MANY does not work yet - when it works replace?
				// selectedSection.getIncludedWorkItems().addAll(selectedWorkItems);
				for (WorkItem item : selectedWorkItems) {
					selectedSection.getIncludedWorkItems().add(item);
				}
			}
		});

		return true;
	}

	/**
	 * @return the meeting
	 */
	public Meeting getMeeting() {
		return meeting;
	}

	/**
	 * @return the workItems
	 */
	public EList<WorkItem> getWorkItems() {
		return workItems;
	}
}
