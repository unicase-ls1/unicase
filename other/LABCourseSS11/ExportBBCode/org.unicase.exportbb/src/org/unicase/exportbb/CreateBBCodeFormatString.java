package org.unicase.exportbb;

import java.io.IOException;
import java.util.Calendar;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.unicase.exportbb.utils.BBCodeUtil;
import org.unicase.exportbb.utils.WriteInfosFromMeeting;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;

/**
 * Creates the BBCode format out of the infos from a Meeting and puts it into a
 * string.
 * 
 * @author Carmen Carlan
 * 
 */
public class CreateBBCodeFormatString {

	static String string;
	static Set<ModelElement> setME;
	static Object[] childElements1;
	static Object[] childElements;
	static Set<ModelElement> set;
	static Object[] object;
	static CompositeMeetingSection cms;
	CompositeMeetingSection cms_aux;
	static WorkItemMeetingSection workItemSection;
	static Issue issue;
	static IssueMeetingSection ims;
	public static String error_message = "";
	public static Calendar cal = Calendar.getInstance();
	static BBCodeUtil bbcodeUtil;
	
	public static String createString(Meeting meeting) {
		string = "";
		try {
			error_message = "";
			
			//initialize string
			bbcodeUtil = new BBCodeUtil("");
			
			writeHead(meeting);
			writeGeneralInfos(meeting);
			getModelElements(meeting);

			if (childElements[0] != null)
				writeInfosFromObjective(meeting);

			if (childElements[1] != null) {
				writeInfosFromInfoSharing(meeting);
			}

			if (childElements[3] != null) {
				writeInfosFromMisc(meeting);
			}

			if (childElements[4] != null) {
				writeInfosFromDisscusion(meeting);
			}

			if (childElements[5] != null) {
				writeInfosFromWrapUp(meeting);
			}
			string = BBCodeUtil.string;
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			throw new RuntimeException("end time");
		}

		return string;
	}

	public static void writeHead(Meeting meeting) throws IOException {

		BBCodeUtil.writeInString
				(BBCodeUtil.bold(BBCodeUtil.getProjectName(meeting)) + "  (chair for applied software engineering)");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();

		if (meeting.getName() != null
				&& cal.getTime().before(meeting.getEndtime()))
			BBCodeUtil.writeInString
					("[size=150]Agenda of the " + meeting.getName() + " [/size]");
		else
			BBCodeUtil.writeInString
					 ("[size=150]Protocol of the " + meeting.getName() + " [/size]");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
	}

	public static void writeGeneralInfos(Meeting meeting) throws IOException {
		BBCodeUtil.writeInString  ("[table1 border=1]");
		BBCodeUtil.newlineString ();
		createGeneralTableHead();

		if (meeting.getCreationDate() == null){
			if (error_message == "") {
				error_message = error_message + "creation date";
			} else {
				error_message = error_message + ", creation date";
			}
		}
		WriteInfosFromMeeting.getCreationDate(meeting, bbcodeUtil);
		
		if (meeting.getFacilitator() == null){
			if (error_message == "") {
				error_message = error_message + "facilitator";
			} else {
				error_message = error_message + ", facilitator";
			}
		}
		WriteInfosFromMeeting.getFacilitator(meeting,bbcodeUtil);
		BBCodeUtil.newlineString ();
		
		if (meeting.getStarttime() == null) {
			if (error_message == "") {
				error_message = error_message + "start time";
			} else {
				error_message = error_message + ", start time";
			}
		}
		WriteInfosFromMeeting.getStartTime(meeting,bbcodeUtil);
		
		if (meeting.getTimekeeper() == null){
			if (error_message == "") {
				error_message = error_message + "time keeper";
			} else {
				error_message = error_message + ", time keeper";
			}
		}
		WriteInfosFromMeeting.getTimeKeeper(meeting,bbcodeUtil);
		BBCodeUtil.newlineString ();
		
		if (meeting.getEndtime() == null) {
			if (error_message == "") {
				error_message = error_message + "end time";
			} else {
				error_message = error_message + ", end time";
			}
		}
		WriteInfosFromMeeting.getEndTime(meeting,bbcodeUtil);
		
		if (meeting.getMinutetaker() == null){
			if (error_message == "") {
				error_message = error_message + "minute taker";
			} else {
				error_message = error_message + ", minute taker";
			}
		}
		WriteInfosFromMeeting.getMinuteTaker(meeting,bbcodeUtil);
		BBCodeUtil.newlineString ();
		
		if (meeting.getLocation() == null  || meeting.getLocation() == ""){
			if (error_message == "") {
				error_message = error_message + "location";
			} else {
				error_message = error_message + ", location";
			}
		}
		WriteInfosFromMeeting.getLocation(meeting,bbcodeUtil);
		BBCodeUtil.newlineString ();
		
		EList<OrgUnit> participants_list = meeting.getParticipants();
		if (participants_list.size() <= 0) {
			if (error_message == "") {
				error_message = error_message + "participants";
			} else {
				error_message = error_message + ", participants";
			}
		} 
		WriteInfosFromMeeting.getParticipants(meeting,bbcodeUtil);
		BBCodeUtil.newlineString ();
		
		BBCodeUtil.writeInString ("[/table1]");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
	}

	

	public static void createGeneralTableHead() {
		BBCodeUtil.writeInString  ("[tr][th]Time and Location[/th][th]Roles[/th][/tr]");
		BBCodeUtil.newlineString ();
	}

	/**
	 * Gets the children of a Meeting and sorts them in a certain order.
	 * @param meeting
	 */
	public static void getModelElements(Meeting meeting) {
		setME = meeting.getAllContainedModelElements();

		childElements1 = setME.toArray();
		childElements = new Object[100];

		for (int i = 0; i < childElements1.length; i++)
			if (childElements1[i] instanceof CompositeMeetingSection) {
				cms = (CompositeMeetingSection) childElements1[i];
				if (cms.getName().equals("Objective")) {
					childElements[0] = cms;
				} else if (cms.getName().equals("Information sharing")) {
					childElements[1] = cms;
				} else if (cms.getName().equals("Misc")) {
					childElements[3] = cms;
				} else if (cms.getName().equals("Wrap up")) {
					childElements[5] = cms;
				} else if (cms.getName().equals("Meeting critique")) {
					childElements[7] = cms;
				}
			} else if (childElements1[i] instanceof IssueMeetingSection) {
				ims = (IssueMeetingSection) childElements1[i];
				childElements[4] = ims;
			} else if (childElements1[i] instanceof WorkItemMeetingSection) {
				workItemSection = (WorkItemMeetingSection) childElements1[i];
				if (workItemSection.getName().equals("Action items")) {
					childElements[2] = workItemSection;
				} else {
					childElements[6] = workItemSection;
				}
			}
	}

	public static void writeInfosFromObjective(Meeting meeting)
			throws IOException {
		cms = (CompositeMeetingSection) childElements[0];
		BBCodeUtil.writeInString  ("[list=1]");
		BBCodeUtil.newlineString ();
		BBCodeUtil.writeInString  ("  [*]"+ BBCodeUtil.bold("Objective")+ "  [");
		BBCodeUtil.writeInString  (cms.getAllocatedTime() + " Minutes]");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
		if (cms.getDescription() != null) {
			BBCodeUtil.writeInString  ("       [i]" + cms.getDescription() + "[/i]");
			BBCodeUtil.newlineString ();
			BBCodeUtil.newlineString ();
		}
	}

	public static void writeInfosFromInfoSharing(Meeting meeting)
			throws IOException {
		EList<WorkItem> work_items;
		cms = (CompositeMeetingSection) childElements[1];
		BBCodeUtil.writeInString
				 ("  [*]"+ BBCodeUtil.bold("Information Sharing")  +"["
						+ cms.getAllocatedTime() + " Minutes]");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
		BBCodeUtil.writeInString  ("  [list=1]");
		BBCodeUtil.newlineString ();
		BBCodeUtil.writeInString  ("    [*] Action Items");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();

		if (childElements[2] != null) {
			workItemSection = (WorkItemMeetingSection) childElements[2];
			work_items = workItemSection.getIncludedWorkItems();
			if (work_items.size() > 0)
				writeInfosFromActionItems(meeting, work_items);
		}
		BBCodeUtil.newlineString ();
	}

	public static void writeInfosFromActionItems(Meeting meeting,
			EList<WorkItem> work_items) throws IOException {

		int nr = 1;

		BBCodeUtil.writeInString  ("[table1 border=1]");
		BBCodeUtil.writeInString
				("[tr][th]#[/th][th]Name[/th][th]Asignee[/th][th]Deadline[/th][th]Status[/th][th]Description[/th][/tr]");

		for (int l = 0; l < work_items.size(); l++) {
			if (work_items.get(l) instanceof ActionItem) {
				BBCodeUtil.writeInString  ("[tr]"+BBCodeUtil.createCellInTable( nr +""));
				nr++;
				BBCodeUtil.writeInString
						 (BBCodeUtil.createCellInTable(work_items.get(l).getName()));
				if (work_items.get(l).getAssignee() != null)
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(
									 work_items.get(l).getAssignee().getName()));
				else
					BBCodeUtil.writeInString
							 (BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
				if (work_items.get(l).getDueDate() != null)
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(
									BBCodeUtil.dateFormat(work_items.get(l)
											.getDueDate())));
				else {

					BBCodeUtil.writeInString
							 (BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
				}
				if (work_items.get(l).getState() != null) {
					if (work_items.get(l).getState() == "Closed") {
						BBCodeUtil.writeInString
								(BBCodeUtil.createColoredCellInTable(work_items.get(l).getState(), "80FF40"));
					} else if (work_items.get(l).getState() == "Open"
							&& work_items.get(l).getDueDate() != null
							&& work_items.get(l).getDueDate().before(cal.getTime())) {
						BBCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable("Delayed", "FF8080"));
					} else if (work_items.get(l).getState() == "Blocked") {
						BBCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable("Blocked", "FFBF00"));
					} else if (work_items.get(l).getState() == "Open") {
						BBCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable(work_items.get(l).getState(), "FFFF80"));
					}
				} else
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));

				if (work_items.get(l).getDescription() != null
						&& work_items.get(l).getDescription() != "") {

					BBCodeUtil.writeInString
							 (BBCodeUtil.createCellInTable("[i]" + work_items.get(l).getDescription() + "[/i]")+"[/tr]");
				} else {

					BBCodeUtil.writeInString
							 (BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()) + "[/tr]");
				}
			}
		}
		BBCodeUtil.writeInString ( "[/table1]");
		BBCodeUtil.newlineString ();
	}

	public static void writeInfosFromMisc(Meeting meeting) throws IOException {
		cms = (CompositeMeetingSection) childElements[3];
		BBCodeUtil.writeInString  ("    [*] Misc");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
		if (cms.getDescription() != null && cms.getDescription() != "") {
			BBCodeUtil.writeInString  ("         [i]" + cms.getDescription() + "[/i]");
			BBCodeUtil.newlineString ();
		}
		BBCodeUtil.writeInString  ("  [/list]");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
	}

	public static void writeInfosFromDisscusion(Meeting meeting)
			throws IOException {
		boolean written = false;
		int nr = 0;
		ims = (IssueMeetingSection) childElements[4];
		BBCodeUtil.writeInString
				("  [*]"+ BBCodeUtil.bold("Discussion")+"  [" + ims.getAllocatedTime() + " Minutes]");
		BBCodeUtil.newlineString ();
		set = ims.getLinkedModelElements();
		object = set.toArray();
		if (object.length != 0) {

			for (int j = 0; j < object.length; j++)
				if (object[j] instanceof Issue) {
					nr++;
					if (!written) {
						BBCodeUtil.writeInString  ("  [list]");
						BBCodeUtil.newlineString ();
						written = true;
					}
					BBCodeUtil.newlineString ();
					issue = (Issue) object[j];
					writeInfosFromIssues(meeting, issue, nr);
					if (j == (object.length - 1) && written) {
						BBCodeUtil.writeInString  ("  [/list]");
						BBCodeUtil.newlineString ();
					}
				}

		}
	}

	public static void writeInfosFromIssues(Meeting meeting, Issue is, int j)
			throws IOException {

		BBCodeUtil.writeInString  ("    [*]" + BBCodeUtil.bold("#issue")+"  [" + (j + 1) + ", ");
		if (is.getAssignee() != null)
			BBCodeUtil.writeInString  (is.getAssignee().getName() + "]: ");
		else
			BBCodeUtil.writeInString
					 (BBCodeUtil.bold(BBCodeUtil.fontColor("<no assignee defined>", "red"))
							+ "]: ");
		BBCodeUtil.writeInString  (is.getName() + " (" + is.getState() + ")");
		BBCodeUtil.newlineString ();
		if (is.getDescription() != "" && is.getDescription() != null) {
			BBCodeUtil.writeInString  ("        [i]" + is.getDescription() + "[/i]");
			BBCodeUtil.newlineString ();
		}
		EList<Proposal> proposals = is.getProposals();
		if (proposals.size() > 0) {
			BBCodeUtil.writeInString  ("    [list=1]");
			BBCodeUtil.newlineString ();
			for (int k = 0; k < proposals.size(); k++) {
				BBCodeUtil.writeInString
						 ("      [*] #alt" + (k + 1) + " [" + (j + 1) + "]: "
								+ proposals.get(k).getCreator() + ": " + proposals
								.get(k).getName());
				BBCodeUtil.newlineString ();
				if (proposals.get(k).getDescription() != null
						&& proposals.get(k).getDescription() != "") {
					BBCodeUtil.writeInString
							("         [i]"
									+ proposals.get(k).getDescription() + "[/i]");
					BBCodeUtil.newlineString ();
				}
			}
			BBCodeUtil.writeInString ("    [/list]");
			BBCodeUtil.newlineString ();
		}
		if (is.getSolution() != null) {
			if (is.getSolution().getDescription() != null
					&& is.getSolution().getDescription() != "") {
				BBCodeUtil.writeInString
						("        "+BBCodeUtil.bold("Resolution ")+" ["
								+ is.getSolution().getCreator() + "]: [i]"
								+ is.getSolution().getDescription() + "[/i]");
			} else {
				BBCodeUtil.writeInString
						("        "+BBCodeUtil.bold("Resolution ")+" ["
								+ is.getSolution().getCreator() + "]: "+BBCodeUtil.bold("[color=red]<no description defined>[/color]"));
			}
		}
		BBCodeUtil.newlineString ();
	}

	public static void writeInfosFromWrapUp(Meeting meeting) throws IOException {
		BBCodeUtil.newlineString ();
		cms = (CompositeMeetingSection) childElements[5];
		BBCodeUtil.writeInString
				("  [*]"+ BBCodeUtil.bold("Wrap-up")+"  [" + cms.getAllocatedTime() + " Minutes]");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
		if ((childElements[6] != null || childElements[7] != null)
				&& cal.getTime().after(meeting.getEndtime())) {

			BBCodeUtil.writeInString ("  [list=1]");
			BBCodeUtil.newlineString ();
		}
		if (childElements[6] != null
				&& cal.getTime().after(meeting.getEndtime())) {
			BBCodeUtil.writeInString ("    [*]New Action Items");
			BBCodeUtil.newlineString ();
			BBCodeUtil.newlineString ();
			workItemSection = (WorkItemMeetingSection) childElements[6];
			EList<WorkItem> work_items = workItemSection.getIncludedWorkItems();
			if (work_items.size() > 0) {
				BBCodeUtil.writeInString ( "[table1 border=1]");
				BBCodeUtil.writeInString
						( "[tr][th]#[/th][th]Name[/th][th]Asignee[/th][th]Deadline[/th][th]Status[/th][th]Description[/th][/tr]");
				writeInfosFromNewActionItems(meeting, work_items);
				BBCodeUtil.writeInString ( "[/table1]");
				BBCodeUtil.newlineString ();
				BBCodeUtil.newlineString ();
			}
		}
		if (childElements[7] != null
				&& cal.getTime().after(meeting.getEndtime())) {

			writeInfosFromMeetingCritique(meeting);

		} else if ((childElements[6] != null || childElements[7] != null)
				&& cal.getTime().after(meeting.getEndtime())) {
			BBCodeUtil.writeInString ("  [/list]");
			BBCodeUtil.newlineString ();
		}
		BBCodeUtil.writeInString ("[/list]");
		BBCodeUtil.newlineString ();
	}

	static int nrAI = 1;

	public static void writeInfosFromNewActionItems(Meeting meeting,
			EList<WorkItem> work_items) throws IOException {

		for (int l = 0; l < work_items.size(); l++) {
			if (work_items.get(l) instanceof ActionItem) {
				BBCodeUtil.writeInString ("[tr]"+BBCodeUtil.createCellInTable(nrAI+""));
				nrAI++;
				BBCodeUtil.writeInString
						(BBCodeUtil.createCellInTable(work_items.get(l).getName()));
				if (work_items.get(l).getAssignee() != null)
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(
									 work_items.get(l).getAssignee().getName()));
				else
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
				if (work_items.get(l).getDueDate() != null)
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(
									BBCodeUtil.dateFormat(work_items.get(l)
											.getDueDate())));
				else {
					
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
				}
				if (work_items.get(l).getState() != null
						&& work_items.get(l).getState() != "") {
					if (work_items.get(l).getState() == "Closed") {
						BBCodeUtil.writeInString
								(BBCodeUtil.createColoredCellInTable(work_items.get(l).getState(), "80FF40"));
					} else if (work_items.get(l).getState() == "Open"
							&& work_items.get(l).getDueDate() != null
							&& work_items.get(l).getDueDate().before(cal.getTime())) {
						BBCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable("Delayed", "FF8080"));
					} else if (work_items.get(l).getState() == "Blocked") {
						BBCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable("Blocked", "FFBF00"));
					} else if (work_items.get(l).getState() == "Open") {
						BBCodeUtil.writeInString(BBCodeUtil.createColoredCellInTable(work_items.get(l).getState(), "FFFF80"));
					}
				} else {
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
				}
				if (work_items.get(l).getDescription() != null
						&& work_items.get(l).getDescription() != "") {

					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable("[i]" + work_items.get(l).getDescription() + "[/i]") + " [/tr]");
				} else {
					BBCodeUtil.writeInString
							(BBCodeUtil.createCellInTable(BBCodeUtil.notDefined())+"[/tr]");
				}
			}

			if (work_items.get(l).getSuccessors() != null)
				writeInfosFromNewActionItems(meeting, work_items.get(l)
						.getSuccessors());
		}
	}

	public static void writeInfosFromMeetingCritique(Meeting meeting)
			throws IOException {
		BBCodeUtil.newlineString ();
		cms = (CompositeMeetingSection) childElements[7];
		BBCodeUtil.writeInString ("    [*]Meeting-Critique");
		BBCodeUtil.newlineString ();
		BBCodeUtil.newlineString ();
		if (cms.getDescription() != "" && cms.getDescription() != null) {
			BBCodeUtil.writeInString ("         [i]" + cms.getDescription() + "[/i]");
			BBCodeUtil.newlineString ();
		}

	}

	public static String getErrorMessage() {
		return error_message;
	}

}
