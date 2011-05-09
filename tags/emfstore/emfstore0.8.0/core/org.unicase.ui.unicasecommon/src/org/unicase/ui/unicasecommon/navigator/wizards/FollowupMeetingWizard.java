/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.wizards;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.document.LeafSection;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author naughton Wizard for creating a follow-up meeting.
 */
public class FollowupMeetingWizard extends Wizard implements IWorkbenchWizard {

	private Meeting selectedMeeting;
	private Meeting followupMeeting;
	private boolean canFinish;
	private MeetingNameDescriptionPage namePage;
	private MeetingWorkItemCarryPage itemCarryPage;

	/**
	 * Sets if the wizard can be finished.
	 * 
	 * @param canFinish Can the wizard finish?
	 */
	public void setCanFinish(boolean canFinish) {
		this.canFinish = canFinish;
	}

	/**
	 * Accesses the meeting the followup meeting is based on.
	 * 
	 * @return Base meeting.
	 */
	public Meeting getSelectedMeeting() {
		return selectedMeeting;
	}

	/**
	 * Accesses the meeting being generated.
	 * 
	 * @return Followup meeting.
	 */
	public Meeting getFollowupMeeting() {
		return followupMeeting;
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void addPages() {
		namePage = new MeetingNameDescriptionPage("NamePage");
		addPage(namePage);
		itemCarryPage = new MeetingWorkItemCarryPage("ItemCarryPage");
		addPage(itemCarryPage);
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
		followupMeeting = MeetingFactory.eINSTANCE.createMeeting();
		canFinish = false;
		// get the meeting selected in the navigator
		Object firstElement;
		if (!selection.isEmpty()) {
			firstElement = selection.getFirstElement();
			if (firstElement instanceof Meeting) {
				selectedMeeting = (Meeting) firstElement;
			} else {
				throw new IllegalArgumentException("No Meeting selected!");
			}
		} else {
			throw new IllegalArgumentException("Nothing selected!");
		}
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public boolean performFinish() {
		if (!(selectedMeeting.eContainer() instanceof LeafSection)) {
			return false;
		} else {
			createFollowupMeeting();
			return true;
		}
	}

	private void createFollowupMeeting() {
		final LeafSection leafSection = (LeafSection) selectedMeeting.eContainer();
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(ModelUtil.getProject(leafSection));

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();
				followupMeeting.setName(namePage.getMeetingName());
				followupMeeting.setDescription(namePage.getMeetingDescription());
				leafSection.getModelElements().add(followupMeeting);
				followupMeeting.setFacilitator(getSelectedMeeting().getFacilitator());
				followupMeeting.setLocation(getSelectedMeeting().getLocation());
				followupMeeting.getParticipants().addAll(getSelectedMeeting().getParticipants());
				addMeetingSections(followupMeeting);
				addMeetingSubSections(followupMeeting);

				final List<WorkItem> statusItems = itemCarryPage.getStatusWorkItems();
				addMeetingStatusItems(followupMeeting, statusItems);
				try {
					operationHandle.end("Create follow-up meeting", "Created follow-up meeting "
						+ followupMeeting.getName() + " from " + selectedMeeting.getName() + ".", ModelUtil.getProject(
						followupMeeting).getModelElementId(followupMeeting));
				} catch (InvalidHandleException e) {
					WorkspaceUtil.logException("Composite Operation failed!", e);
				}
			}
		}.run();

		UnicaseActionHelper.openModelElement(followupMeeting, this.getClass().getName());
	}

	private void addMeetingStatusItems(Meeting meeting, List<WorkItem> statusItems) {
		CompositeMeetingSection informationExchangeSection = (CompositeMeetingSection) meeting.getSections().get(1);
		WorkItemMeetingSection workItemMeetingSection = (WorkItemMeetingSection) informationExchangeSection
			.getSubsections().get(0);
		for (WorkItem workItem : statusItems) {
			workItemMeetingSection.getIncludedWorkItems().add(workItem);
		}
	}

	private void addMeetingSections(Meeting meeting) {
		CompositeMeetingSection objectiveSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		CompositeMeetingSection informationExchangeSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		CompositeMeetingSection wrapUpSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		IssueMeetingSection discussionSection = MeetingFactory.eINSTANCE.createIssueMeetingSection();

		// set attributes
		objectiveSection.setName("Objective");
		informationExchangeSection.setName("Information sharing");
		wrapUpSection.setName("Wrap up");
		discussionSection.setName("Discussion");

		informationExchangeSection.setAllocatedTime(30);
		discussionSection.setAllocatedTime(50);
		wrapUpSection.setAllocatedTime(10);

		// set links
		meeting.getSections().add(objectiveSection);
		meeting.getSections().add(informationExchangeSection);
		meeting.getSections().add(discussionSection);
		meeting.getSections().add(wrapUpSection);

		meeting.setIdentifiedIssuesSection(discussionSection);
	}

	private void addMeetingSubSections(Meeting meeting) {
		CompositeMeetingSection miscSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		CompositeMeetingSection meetingCritiqueSection = MeetingFactory.eINSTANCE.createCompositeMeetingSection();
		WorkItemMeetingSection workItemsSection = MeetingFactory.eINSTANCE.createWorkItemMeetingSection();
		WorkItemMeetingSection newWorkItemsSection = MeetingFactory.eINSTANCE.createWorkItemMeetingSection();

		workItemsSection.setName("Action items");
		newWorkItemsSection.setName("New action items");
		miscSection.setName("Misc");
		meetingCritiqueSection.setName("Meeting critique");

		CompositeMeetingSection informationExchangeSection = (CompositeMeetingSection) meeting.getSections().get(1);
		CompositeMeetingSection wrapUpSection = (CompositeMeetingSection) meeting.getSections().get(3);

		// set links
		informationExchangeSection.getSubsections().add(workItemsSection);
		informationExchangeSection.getSubsections().add(miscSection);
		wrapUpSection.getSubsections().add(newWorkItemsSection);
		wrapUpSection.getSubsections().add(meetingCritiqueSection);

		meeting.setIdentifiedWorkItemsSection(newWorkItemsSection);
	}
}
