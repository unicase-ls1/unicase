package org.unicase.exportbb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
 * Writes the information from the meeting in BBCode format into a file.
 * @author Carmen Carlan
 * 
 */
public class CreateBBCodeFormat {

	static File file;
	static FileWriter fstream;
	static BufferedWriter out;
	static Set<ModelElement> modelElementSet;
	static Object[] children;
	
	static Object[] objects;
	static WorkItemMeetingSection wims;
	ActionItem actionItem;
	
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
	

	/**
	 * Creates the file and writes everything in it.
	 * @param meeting
	 * @param fileUrl
	 */
	public static void createFile(Meeting meeting, String fileUrl) { 
		try {
			error_message = "";
			// Create file
			file = new File(fileUrl);
			fstream = new FileWriter(file);
			out = new BufferedWriter(fstream);
			writeHead(out, meeting);
			writeGeneralInfos(out, meeting);
			getModelElements(out, meeting);

			if (childElements[0] != null)
				writeInfosFromObjective(out, meeting);
			else
				error_message = "!Couldn't find objective!";

			if (childElements[1] != null) {
				writeInfosFromInfoSharing(out, meeting);
			} else
				error_message = "!Couldn't find Information Sharing!";

			if (childElements[3] != null) {
				writeInfosFromMisc(out, meeting);
			} else
				error_message = "!Couldn't find Misc!";

			if (childElements[4] != null) {
				writeInfosFromDisscusion(out, meeting);
			} else
				error_message = "!Couldn't find Discussion!";

			if (childElements[5] != null) {
				writeInfosFromWrapUp(out, meeting);
			} else
				error_message = "!Couldn't find Wrap up!";
			// Close the output stream
			out.close();

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			//throw new RuntimeException(e);
			throw new RuntimeException("end time");
		}
	}

	public static void writeHead(BufferedWriter out2, Meeting meeting) throws IOException {

		BBCodeUtil.writeInBuffer
				(out, BBCodeUtil.bold(BBCodeUtil.getProjectName(meeting)) + "  (chair for applied software engineering)");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);

		if (meeting.getName() != null
				&& cal.getTime().before(meeting.getEndtime()))
			BBCodeUtil.writeInBuffer
					(out, "[size=150]Agenda of the " + meeting.getName() + " [/size]");
		else
			BBCodeUtil.writeInBuffer
					 (out, "[size=150]Protocol of the " + meeting.getName() + " [/size]");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
	}

	public static void writeGeneralInfos(BufferedWriter out2, Meeting meeting) throws IOException {
		BBCodeUtil.writeInBuffer  (out, "[table1 border=1]");
		BBCodeUtil.newlineBuffer (out);
		createGeneralTableHead();

		if (meeting.getCreationDate() == null){
			if (error_message == "") {
				error_message = error_message + "creation date";
			} else {
				error_message = error_message + ", creation date";
			}
		}
		WriteInfosFromMeeting.getCreationDateBuffer(meeting, out);
		
		if (meeting.getFacilitator() == null){
			if (error_message == "") {
				error_message = error_message + "facilitator";
			} else {
				error_message = error_message + ", facilitator";
			}
		}
		WriteInfosFromMeeting.getFacilitatorBuffer(meeting,out);
		BBCodeUtil.newlineBuffer (out);
		
		if (meeting.getStarttime() == null) {
			if (error_message == "") {
				error_message = error_message + "start time";
			} else {
				error_message = error_message + ", start time";
			}
		}
		WriteInfosFromMeeting.getStartTimeBuffer(meeting,out);
		
		if (meeting.getTimekeeper() == null){
			if (error_message == "") {
				error_message = error_message + "time keeper";
			} else {
				error_message = error_message + ", time keeper";
			}
		}
		WriteInfosFromMeeting.getTimeKeeperBuffer(meeting,out);
		BBCodeUtil.newlineBuffer (out);
		
		if (meeting.getEndtime() == null) {
			if (error_message == "") {
				error_message = error_message + "end time";
			} else {
				error_message = error_message + ", end time";
			}
		}
		WriteInfosFromMeeting.getEndTimeBuffer(meeting,out);
		
		if (meeting.getMinutetaker() == null){
			if (error_message == "") {
				error_message = error_message + "minute taker";
			} else {
				error_message = error_message + ", minute taker";
			}
		}
		WriteInfosFromMeeting.getMinuteTakerBuffer(meeting,out);
		BBCodeUtil.newlineBuffer (out);
		
		if (meeting.getLocation() == null  || meeting.getLocation() == ""){
			if (error_message == "") {
				error_message = error_message + "location";
			} else {
				error_message = error_message + ", location";
			}
		}
		WriteInfosFromMeeting.getLocationBuffer(meeting,out);
		BBCodeUtil.newlineBuffer (out);
		
		EList<OrgUnit> participants_list = meeting.getParticipants();
		if (participants_list.size() <= 0) {
			if (error_message == "") {
				error_message = error_message + "participants";
			} else {
				error_message = error_message + ", participants";
			}
		} 
		WriteInfosFromMeeting.getParticipantsBuffer(meeting,out);
		BBCodeUtil.newlineBuffer (out);
		
		BBCodeUtil.writeInBuffer(out, "[/table1]");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
	}

	

	public static void createGeneralTableHead() throws IOException {
		BBCodeUtil.writeInBuffer  (out, "[tr][th]Time and Location[/th][th]Roles[/th][/tr]");
		BBCodeUtil.newlineBuffer (out);
	}

	/**
	 * Gets the children of a Meeting and sorts them in a certain order.
	 * @param out2 
	 * @param meeting
	 */
	public static void getModelElements(BufferedWriter out2, Meeting meeting) {
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

	public static void writeInfosFromObjective(BufferedWriter out2, Meeting meeting)
			throws IOException {
		cms = (CompositeMeetingSection) childElements[0];
		BBCodeUtil.writeInBuffer  (out, "[list=1]");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.writeInBuffer  (out, "  [*]"+ BBCodeUtil.bold("Objective")+ "  [");
		BBCodeUtil.writeInBuffer  (out, cms.getAllocatedTime() + " Minutes]");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
		if (cms.getDescription() != null) {
			BBCodeUtil.writeInBuffer  (out, "       [i]" + cms.getDescription() + "[/i]");
			BBCodeUtil.newlineBuffer (out);
			BBCodeUtil.newlineBuffer (out);
		}
	}

	public static void writeInfosFromInfoSharing(BufferedWriter out2, Meeting meeting)
			throws IOException {
		EList<WorkItem> work_items;
		cms = (CompositeMeetingSection) childElements[1];
		BBCodeUtil.writeInBuffer
				 (out, "  [*]"+ BBCodeUtil.bold("Information Sharing")  +"["
						+ cms.getAllocatedTime() + " Minutes]");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.writeInBuffer  (out, "  [list=1]");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.writeInBuffer  (out, "    [*] Action Items");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);

		if (childElements[2] != null) {
			workItemSection = (WorkItemMeetingSection) childElements[2];
			work_items = workItemSection.getIncludedWorkItems();
			if (work_items.size() > 0)
				writeInfosFromActionItems(meeting, work_items);
		}
		BBCodeUtil.newlineBuffer (out);
	}

	public static void writeInfosFromActionItems(Meeting meeting,
			EList<WorkItem> work_items) throws IOException {

		int nr = 1;

		BBCodeUtil.writeInBuffer  (out, "[table1 border=1]");
		BBCodeUtil.writeInBuffer
				(out, "[tr][th]#[/th][th]Name[/th][th]Asignee[/th][th]Deadline[/th][th]Status[/th][th]Description[/th][/tr]");

		for (int l = 0; l < work_items.size(); l++) {
			if (work_items.get(l) instanceof ActionItem) {
				BBCodeUtil.writeInBuffer  (out, "[tr]"+BBCodeUtil.createCellInTable( nr +""));
				nr++;
				BBCodeUtil.writeInBuffer
						 (out, BBCodeUtil.createCellInTable(work_items.get(l).getName()));
				if (work_items.get(l).getAssignee() != null)
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(
									 work_items.get(l).getAssignee().getName()));
				else
					BBCodeUtil.writeInBuffer
							 (out, BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
				if (work_items.get(l).getDueDate() != null)
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(
									BBCodeUtil.dateFormat(work_items.get(l)
											.getDueDate())));
				else {

					BBCodeUtil.writeInBuffer
							 (out, BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
				}
				if (work_items.get(l).getState() != null) {
					if (work_items.get(l).getState() == "Closed") {
						BBCodeUtil.writeInBuffer
								(out, BBCodeUtil.createColoredCellInTable(work_items.get(l).getState(), "80FF40"));
					} else if (work_items.get(l).getState() == "Open"
							&& work_items.get(l).getDueDate() != null
							&& work_items.get(l).getDueDate().before(cal.getTime())) {
						BBCodeUtil.writeInBuffer(out, BBCodeUtil.createColoredCellInTable("Delayed", "FF8080"));
					} else if (work_items.get(l).getState() == "Blocked") {
						BBCodeUtil.writeInBuffer(out, BBCodeUtil.createColoredCellInTable("Blocked", "FFBF00"));
					} else if (work_items.get(l).getState() == "Open") {
						BBCodeUtil.writeInBuffer(out, BBCodeUtil.createColoredCellInTable(work_items.get(l).getState(), "FFFF80"));
					}
				} else
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));

				if (work_items.get(l).getDescription() != null
						&& work_items.get(l).getDescription() != "") {

					BBCodeUtil.writeInBuffer
							 (out, BBCodeUtil.createCellInTable("[i]" + work_items.get(l).getDescription() + "[/i]")+"[/tr]");
				} else {

					BBCodeUtil.writeInBuffer
							 (out, BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()) + "[/tr]");
				}
			}
		}
		BBCodeUtil.writeInBuffer(out,  "[/table1]");
		BBCodeUtil.newlineBuffer (out);
	}

	public static void writeInfosFromMisc(BufferedWriter out2, Meeting meeting) throws IOException {
		cms = (CompositeMeetingSection) childElements[3];
		BBCodeUtil.writeInBuffer  (out, "    [*] Misc");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
		if (cms.getDescription() != null && cms.getDescription() != "") {
			BBCodeUtil.writeInBuffer  (out, "         [i]" + cms.getDescription() + "[/i]");
			BBCodeUtil.newlineBuffer (out);
		}
		BBCodeUtil.writeInBuffer  (out, "  [/list]");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
	}

	public static void writeInfosFromDisscusion(BufferedWriter out2, Meeting meeting)
			throws IOException {
		boolean written = false;
		int nr = 0;
		ims = (IssueMeetingSection) childElements[4];
		BBCodeUtil.writeInBuffer
				(out, "  [*]"+ BBCodeUtil.bold("Discussion")+"  [" + ims.getAllocatedTime() + " Minutes]");
		BBCodeUtil.newlineBuffer (out);
		set = ims.getLinkedModelElements();
		object = set.toArray();
		if (object.length != 0) {

			for (int j = 0; j < object.length; j++)
				if (object[j] instanceof Issue) {
					nr++;
					if (!written) {
						BBCodeUtil.writeInBuffer  (out, "  [list]");
						BBCodeUtil.newlineBuffer (out);
						written = true;
					}
					BBCodeUtil.newlineBuffer (out);
					issue = (Issue) object[j];
					writeInfosFromIssues(meeting, issue, nr);
					if (j == (object.length - 1) && written) {
						BBCodeUtil.writeInBuffer  (out, "  [/list]");
						BBCodeUtil.newlineBuffer (out);
					}
				}

		}
	}

	public static void writeInfosFromIssues(Meeting meeting, Issue is, int j)
			throws IOException {

		BBCodeUtil.writeInBuffer  (out, "    [*]" + BBCodeUtil.bold("#issue")+"  [" + (j + 1) + ", ");
		if (is.getAssignee() != null)
			BBCodeUtil.writeInBuffer  (out, is.getAssignee().getName() + "]: ");
		else
			BBCodeUtil.writeInBuffer
					 (out, BBCodeUtil.bold(BBCodeUtil.fontColor("<no assignee defined>", "red"))
							+ "]: ");
		BBCodeUtil.writeInBuffer  (out, is.getName() + " (" + is.getState() + ")");
		BBCodeUtil.newlineBuffer (out);
		if (is.getDescription() != "" && is.getDescription() != null) {
			BBCodeUtil.writeInBuffer  (out, "        [i]" + is.getDescription() + "[/i]");
			BBCodeUtil.newlineBuffer (out);
		}
		EList<Proposal> proposals = is.getProposals();
		if (proposals.size() > 0) {
			BBCodeUtil.writeInBuffer  (out, "    [list=1]");
			BBCodeUtil.newlineBuffer (out);
			for (int k = 0; k < proposals.size(); k++) {
				BBCodeUtil.writeInBuffer
						 (out, "      [*] #alt" + (k + 1) + " [" + (j + 1) + "]: "
								+ proposals.get(k).getCreator() + ": " + proposals
								.get(k).getName());
				BBCodeUtil.newlineBuffer (out);
				if (proposals.get(k).getDescription() != null
						&& proposals.get(k).getDescription() != "") {
					BBCodeUtil.writeInBuffer
							(out, "         [i]"
									+ proposals.get(k).getDescription() + "[/i]");
					BBCodeUtil.newlineBuffer (out);
				}
			}
			BBCodeUtil.writeInBuffer(out, "    [/list]");
			BBCodeUtil.newlineBuffer (out);
		}
		if (is.getSolution() != null) {
			if (is.getSolution().getDescription() != null
					&& is.getSolution().getDescription() != "") {
				BBCodeUtil.writeInBuffer
						(out, "        "+BBCodeUtil.bold("Resolution ")+" ["
								+ is.getSolution().getCreator() + "]: [i]"
								+ is.getSolution().getDescription() + "[/i]");
			} else {
				BBCodeUtil.writeInBuffer
						(out, "        "+BBCodeUtil.bold("Resolution ")+" ["
								+ is.getSolution().getCreator() + "]: "+BBCodeUtil.bold("[color=red]<no description defined>[/color]"));
			}
		}
		BBCodeUtil.newlineBuffer (out);
	}

	public static void writeInfosFromWrapUp(BufferedWriter out2, Meeting meeting) throws IOException {
		BBCodeUtil.newlineBuffer (out);
		cms = (CompositeMeetingSection) childElements[5];
		BBCodeUtil.writeInBuffer
				(out, "  [*]"+ BBCodeUtil.bold("Wrap-up")+"  [" + cms.getAllocatedTime() + " Minutes]");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
		if ((childElements[6] != null || childElements[7] != null)
				&& cal.getTime().after(meeting.getEndtime())) {

			BBCodeUtil.writeInBuffer(out, "  [list=1]");
			BBCodeUtil.newlineBuffer (out);
		}
		if (childElements[6] != null
				&& cal.getTime().after(meeting.getEndtime())) {
			BBCodeUtil.writeInBuffer(out, "    [*]New Action Items");
			BBCodeUtil.newlineBuffer (out);
			BBCodeUtil.newlineBuffer (out);
			workItemSection = (WorkItemMeetingSection) childElements[6];
			EList<WorkItem> work_items = workItemSection.getIncludedWorkItems();
			if (work_items.size() > 0) {
				BBCodeUtil.writeInBuffer(out,  "[table1 border=1]");
				BBCodeUtil.writeInBuffer
						(out,  "[tr][th]#[/th][th]Name[/th][th]Asignee[/th][th]Deadline[/th][th]Status[/th][th]Description[/th][/tr]");
				writeInfosFromNewActionItems(meeting, work_items);
				BBCodeUtil.writeInBuffer(out,  "[/table1]");
				BBCodeUtil.newlineBuffer (out);
				BBCodeUtil.newlineBuffer (out);
			}
		}
		if (childElements[7] != null
				&& cal.getTime().after(meeting.getEndtime())) {

			writeInfosFromMeetingCritique(meeting);

		} else if ((childElements[6] != null || childElements[7] != null)
				&& cal.getTime().after(meeting.getEndtime())) {
			BBCodeUtil.writeInBuffer(out, "  [/list]");
			BBCodeUtil.newlineBuffer (out);
		}
		BBCodeUtil.writeInBuffer(out, "[/list]");
		BBCodeUtil.newlineBuffer (out);
	}

	static int nrAI = 1;

	public static void writeInfosFromNewActionItems(Meeting meeting,
			EList<WorkItem> work_items) throws IOException {

		for (int l = 0; l < work_items.size(); l++) {
			if (work_items.get(l) instanceof ActionItem) {
				BBCodeUtil.writeInBuffer(out, "[tr]"+BBCodeUtil.createCellInTable(nrAI+""));
				nrAI++;
				BBCodeUtil.writeInBuffer
						(out, BBCodeUtil.createCellInTable(work_items.get(l).getName()));
				if (work_items.get(l).getAssignee() != null)
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(
									 work_items.get(l).getAssignee().getName()));
				else
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
				if (work_items.get(l).getDueDate() != null)
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(
									BBCodeUtil.dateFormat(work_items.get(l)
											.getDueDate())));
				else {
					
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(BBCodeUtil.notDefined() ));
				}
				if (work_items.get(l).getState() != null
						&& work_items.get(l).getState() != "") {
					if (work_items.get(l).getState() == "Closed") {
						BBCodeUtil.writeInBuffer
								(out, BBCodeUtil.createColoredCellInTable(work_items.get(l).getState(), "80FF40"));
					} else if (work_items.get(l).getState() == "Open"
							&& work_items.get(l).getDueDate() != null
							&& work_items.get(l).getDueDate().before(cal.getTime())) {
						BBCodeUtil.writeInBuffer(out, BBCodeUtil.createColoredCellInTable("Delayed", "FF8080"));
					} else if (work_items.get(l).getState() == "Blocked") {
						BBCodeUtil.writeInBuffer(out, BBCodeUtil.createColoredCellInTable("Blocked", "FFBF00"));
					} else if (work_items.get(l).getState() == "Open") {
						BBCodeUtil.writeInBuffer(out, BBCodeUtil.createColoredCellInTable(work_items.get(l).getState(), "FFFF80"));
					}
				} else {
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(BBCodeUtil.notDefined()));
				}
				if (work_items.get(l).getDescription() != null
						&& work_items.get(l).getDescription() != "") {

					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable("[i]" + work_items.get(l).getDescription() + "[/i]") + " [/tr]");
				} else {
					BBCodeUtil.writeInBuffer
							(out, BBCodeUtil.createCellInTable(BBCodeUtil.notDefined())+"[/tr]");
				}
			}

			if (work_items.get(l).getSuccessors() != null)
				writeInfosFromNewActionItems(meeting, work_items.get(l)
						.getSuccessors());
		}
	}

	public static void writeInfosFromMeetingCritique(Meeting meeting)
			throws IOException {
		BBCodeUtil.newlineBuffer (out);
		cms = (CompositeMeetingSection) childElements[7];
		BBCodeUtil.writeInBuffer(out, "    [*]Meeting-Critique");
		BBCodeUtil.newlineBuffer (out);
		BBCodeUtil.newlineBuffer (out);
		if (cms.getDescription() != "" && cms.getDescription() != null) {
			BBCodeUtil.writeInBuffer(out, "         [i]" + cms.getDescription() + "[/i]");
			BBCodeUtil.newlineBuffer (out);
		}

	}

	public static String getErrorMessage() {
		return error_message;
	}

}
