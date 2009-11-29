package org.unicase.ui.multiaction;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.document.LeafSection;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingFactory;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.CompositeOperationHandle;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.InvalidHandleException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * 
 * @author jfinis
 * This class generates a multi action workpackage
 *
 */
public class MultiActionGenerator {
	
	private static MultiActionGenerator theInstance;
	private MultiActionGenerator(){}
	
	/**
	 * Gets the singleton instance.
	 * @return the singleton.
	 */
	public static MultiActionGenerator getInstance(){
		if (theInstance == null){
			theInstance = new MultiActionGenerator();
		}
		return theInstance;
	}
	
	private void copyValues(ActionItem from, WorkItem to){
		if(to instanceof ActionItem){
			ActionItem toA = (ActionItem)to;
			toA.setActivity(from.getActivity());
			toA.setChecked(from.isChecked());
			toA.setDone(from.isDone());
		}
		to.setCreationDate(from.getCreationDate());
		to.setCreator(from.getCreator());
		to.setDescription(from.getDescription());
		to.setDueDate(from.getDueDate());
		to.setEffort(from.getEffort());
		to.setEstimate(from.getEstimate());
		to.setIdentifier(from.getIdentifier());
		to.setLeafSection(from.getLeafSection());
		to.setName(from.getName());
		to.setPriority(from.getPriority());
		to.setResolved(from.isResolved());
		to.setReviewer(from.getReviewer());
		to.getSuccessors().addAll(from.getSuccessors());
		to.getAnnotatedModelElements().addAll(from.getAnnotatedModelElements());
		to.getAnnotations().addAll(from.getAnnotations());
		to.getAppliedStereotypeInstances().addAll(from.getAppliedStereotypeInstances());
		to.getAttachments().addAll(from.getAttachments());
		to.getComments().addAll(from.getComments());
		to.getIncomingDocumentReferences().addAll(from.getIncomingDocumentReferences());
		to.getPredecessors().addAll(from.getPredecessors());
		to.getParticipants().addAll(from.getParticipants());
		
	}
	
	public WorkPackage generateMultiAction(ActionItem baseAction,EList<OrgUnit> assignees){
		final WorkPackage result = TaskFactory.eINSTANCE.createWorkPackage();
		final WorkPackage parentPackage = (WorkPackage) baseAction.eContainer();
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(parentPackage.getProject());

		//Begin composite operation
		CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();
		
		for(OrgUnit curAssignee: assignees){
			//Create copied action item
			ActionItem curAI = TaskFactory.eINSTANCE.createActionItem();
			curAI.setAssignee(curAssignee);
			
			//Copy values (not good if ActionItem gets new attributes, a .clone method would be better...)
			copyValues(baseAction,curAI);
			
			//Add to resulting section
			result.getContainedWorkItems().add(curAI);
			
		}
		
		//Set values for the resulting work package to those of the old Work Item
		copyValues(baseAction,result);
		
		//Add resulting work package into parent
		parentPackage.getContainedWorkItems().add(result);
		
		//Delete old action item
		baseAction.delete();
		
		try {
			operationHandle.end("Assign action item to group", "Assigned action item "
				+ baseAction.getName() + " to multiple assignees.", result
				.getModelElementId());
		} catch (InvalidHandleException e) {
			WorkspaceUtil.logException("Composite Operation failed!", e);
		}
		
		return result;
	}
	

	private void createFollowupMeeting() {
		final LeafSection leafSection = (LeafSection) selectedMeeting.eContainer();
		final ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(leafSection.getProject());

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				CompositeOperationHandle operationHandle = projectSpace.beginCompositeOperation();
				followupMeeting.setName(namePage.getMeetingName());
				followupMeeting.setDescription(namePage.getMeetingDescription());
				leafSection.getModelElements().add(followupMeeting);
				addMeetingSections(followupMeeting);
				addMeetingSubSections(followupMeeting);
				final List<WorkItem> statusItems = itemCarryPage.getStatusWorkItems();
				addMeetingStatusItems(followupMeeting, statusItems);
				try {
					operationHandle.end("Create follow-up meeting", "Created follow-up meeting "
						+ followupMeeting.getName() + " from " + selectedMeeting.getName() + ".", followupMeeting
						.getModelElementId());
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
