package org.unicase.exportbb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
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
 * 
 * @author Carmen Carlan
 * 
 */
public class CreateBBCodeFormatString {

	static String string;
	static Set<ModelElement> setME;
	static Object[] childElementss;
	static Object[] childElements;
	Object aux;
	static Set<ModelElement> set;
	static Object[] o;
	UnicaseModelElement m;
	static CompositeMeetingSection cms;
	CompositeMeetingSection cms_aux;
	static WorkItemMeetingSection workItemSection;
	static Issue issue;
	static IssueMeetingSection ims;
	public static String error_message = "";
	public static Calendar cal = Calendar.getInstance();

	public static String createString(Meeting meeting) {
		string = "";
		try {
			error_message = "";

			writeHead(meeting);
			writeGeneralInfos(meeting);
			getModelElements(meeting);

			if (childElements[0] != null)
				writeInfosFromObjective(meeting);
			else
				error_message = "!Couldn't find objective!";

			if (childElements[1] != null) {
				writeInfosFromInfoSharing(meeting);
			} else
				error_message = "!Couldn't find Information Sharing!";

			if (childElements[3] != null) {
				writeInfosFromMisc(meeting);
			} else
				error_message = "!Couldn't find Misc!";

			if (childElements[4] != null) {
				writeInfosFromDisscusion(meeting);
			} else
				error_message = "!Couldn't find Discussion!";

			if (childElements[5] != null) {
				writeInfosFromWrapUp(meeting);
			} else
				error_message = "!Couldn't find Wrap up!";

		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			throw new RuntimeException("end time");
		}

		return string;
	}

	public static void writeHead(Meeting meeting) throws IOException {
		string = string
				+ ("[i][size=150]Chair for Applied Software Engineering [/size][/i]");
		string = string + "\n";
		string = string + "\n";
		string = string
				+ ("[color=#008000][size=150] Project Name: "
						+ getProjectName(meeting) + "[/size][/color]");
		string = string + "\n";
		string = string + "\n";
		
		//&& meeting.getEndtime()!=null
		if (meeting.getName()!=null  && cal.getTime().before(meeting.getEndtime()))
		string = string
				+ ("[size=150]Agenda: " + meeting.getName() + " [/size]");
		else
			string = string
			+ ("[size=150]Protocol: " + meeting.getName() + " [/size]");
		string = string + "\n";
		string = string + "\n";
	}

	public static void writeGeneralInfos(Meeting meeting) throws IOException {
		string = string + ("[code]");
		string = string + "\n";
		string = string + ("Time and Location       Roles");
		string = string + "\n";
		if (meeting.getCreationDate() != null)
			string = string
					+ ("Date: " + meeting.getCreationDate().getDay() + "-"
							+ meeting.getCreationDate().getMonth() + "-" + (meeting
							.getCreationDate().getYear() + 1900));
		else
			string = string + ("Date: " + "<not defined>");
		if (meeting.getFacilitator() != null)
			string = string
					+ ("          Moderator: " + meeting.getFacilitator()
							.getName());
		else
			string = string + ("          Moderator: " + "<not defined>");
		string = string + "\n";
		if (meeting.getStarttime() != null) {
			if (meeting.getStarttime().getHours() > 10
					&& meeting.getStarttime().getMinutes() > 10)
				string = string
						+ ("Start: " + meeting.getStarttime().getHours() + ":" + meeting
								.getStarttime().getMinutes());
			else if (meeting.getStarttime().getHours() > 10
					&& meeting.getStarttime().getMinutes() < 10)
				string = string
						+ ("Start: " + meeting.getStarttime().getHours() + ":0" + meeting
								.getStarttime().getMinutes());
			else if (meeting.getStarttime().getHours() < 10
					&& meeting.getStarttime().getMinutes() < 10)
				string = string
						+ ("Start: 0" + meeting.getStarttime().getHours()
								+ ":0" + meeting.getStarttime().getMinutes());
			else if (meeting.getStarttime().getHours() < 10
					&& meeting.getStarttime().getMinutes() > 10)
				string = string
						+ ("Start: 0" + meeting.getStarttime().getHours() + ":" + meeting
								.getStarttime().getMinutes());
		} else
			string = string + ("Start: " + "<not defined>");
		if (meeting.getTimekeeper() != null)
			string = string
					+ ("            Time Keeper: " + meeting.getTimekeeper()
							.getName());
		else
			string = string + ("            Time Keeper: " + "<not defined>");
		string = string + "\n";
		if (meeting.getEndtime() != null) {
			if (meeting.getEndtime().getHours() > 10
					&& meeting.getEndtime().getMinutes() > 10)
				string = string
						+ ("End: " + meeting.getEndtime().getHours() + ":"
								+ meeting.getEndtime().getMinutes()
								);
			else if (meeting.getEndtime().getHours() > 10
					&& meeting.getEndtime().getMinutes() < 10)
				string = string
						+ ("End: " + meeting.getEndtime().getHours() + ":0" + meeting
								.getEndtime().getMinutes());
			else if (meeting.getEndtime().getHours() < 10
					&& meeting.getEndtime().getMinutes() < 10)
				string = string
						+ ("End: 0" + meeting.getEndtime().getHours() + ":0" + meeting
								.getEndtime().getMinutes());
			else if (meeting.getEndtime().getHours() < 10
					&& meeting.getEndtime().getMinutes() > 10)
				string = string
						+ ("End: 0" + meeting.getEndtime().getHours() + ":" + meeting
								.getEndtime().getMinutes());
		} else
			string = string + ("End: " + "<not defined>");
		if (meeting.getMinutetaker() != null)
			string = string
					+ ("              Minute Taker: " + meeting
							.getMinutetaker().getName());
		else
			string = string
					+ ("              Minute Taker: " + "<not defined>");
		string = string + "\n";
		if (meeting.getLocation() != "")
			string = string + ("Location: " + meeting.getLocation());
		else
			string = string + ("Location: " + "<not defined>");
		string = string + "\n";
		EList<OrgUnit> participants_list = meeting.getParticipants();
		String s = "";
		if (participants_list.size() <= 0)
			string = string + ("Participants: " + "<not defined>");
		else {
			for (int i = 0; i < participants_list.size(); i++)
				s = s + participants_list.get(i).getName() + ", ";
			string = string + ("Participants: " + s);
		}
		string = string + "\n";
		string = string + ("[/code]");
		string = string + "\n";
		string = string + "\n";
		string = string + "\n";
	}

	public static void getModelElements(Meeting meeting) {
		setME = meeting.getAllContainedModelElements();
		
		childElementss = setME.toArray();
		childElements = new Object[100];

		for (int i = 0; i < childElementss.length; i++)
			if (childElementss[i] instanceof CompositeMeetingSection) {
				cms = (CompositeMeetingSection) childElementss[i];
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
			} else if (childElementss[i] instanceof IssueMeetingSection) {
				ims = (IssueMeetingSection) childElementss[i];
				childElements[4] = ims;
			} else if (childElementss[i] instanceof WorkItemMeetingSection) {
				workItemSection = (WorkItemMeetingSection) childElementss[i];
				if (workItemSection.getName().equals("Action Items")) {
					childElements[2] = workItemSection;
				} else {
					childElements[6] = workItemSection;
				}
			}
	}

	public static void writeInfosFromObjective(Meeting meeting)
			throws IOException {
		cms = (CompositeMeetingSection) childElements[0];
		string = string + ("[list=1]");
		string = string + "\n";
		string = string + ("  [*] [b]Objective[/b] [");
		string = string + (cms.getAllocatedTime() + " Minutes]");
		string = string + "\n";
		string = string + "\n";
		if (cms.getDescription() != null) {
			string = string + ("       [i]" + cms.getDescription() + "[/i]");
			string = string + "\n";
			string = string + "\n";
		}
	}

	public static void writeInfosFromInfoSharing(
			Meeting meeting) throws IOException {
		EList<WorkItem> work_items;
		cms = (CompositeMeetingSection) childElements[1];
		string = string + ("  [*] [b]Information Sharing[/b] [" + cms.getAllocatedTime()
				+ " Minutes]");
		string = string + "\n";
		string = string + "\n";
		string = string + ("  [list=1]");
		string = string + "\n";
		string = string + ("    [*] Action Items");
		string = string + "\n";
		string = string + ("    [list]");
		string = string + "\n";
		if (childElements[2] != null) {
			workItemSection = (WorkItemMeetingSection) childElements[2];
		work_items = workItemSection.getIncludedWorkItems();
		if (work_items.size() > 0)
			writeInfosFromActionItems(meeting, work_items);
		}
		string = string + ("    [/list]");
		string = string + "\n";
		string = string + "\n";
	}

	public static void writeInfosFromActionItems(
			Meeting meeting, EList<WorkItem> work_items ) throws IOException {

		for (int l = 0; l < work_items.size(); l++) {
			if (work_items.get(l) instanceof ActionItem){
			string = string + "\n";
			string = string + ("      [*] [b]Name[/b]: " + work_items.get(l).getName());
			string = string + "\n";
			if (work_items.get(l).getAssignee() != null)
				string = string + ("[b]Asignee[/b]: "
						+ work_items.get(l).getAssignee().getName());
			else
				string = string + ("[b]Asignee[/b]: " + "<not defined>");
			string = string + "\n";
			if (work_items.get(l).getDueDate() != null)
				string = string + ("[b]Deadline[/b]: "
						+ work_items.get(l).getDueDate().getDay() + "."
						+ work_items.get(l).getDueDate().getMonth());
			else
				string = string + ("[b]Deadline[/b]: " + "<not defined>");
			string = string + "\n";

			if (work_items.get(l).getState() != null)
				string = string + ("[b]Status[/b]: " + work_items.get(l).getState());
			else
				string = string + ("[b]Status[/b]: " + "<not defined>" + ", ");
			string = string + "\n";
			if (work_items.get(l).getDescription() != null && work_items.get(l).getDescription()!= ""){
			string = string + ("         [i]" + work_items.get(l).getDescription()
					+ "[/i]");
			string = string + "\n";}
			}
		}
	}


	public static void writeInfosFromMisc(Meeting meeting) throws IOException {
		cms = (CompositeMeetingSection) childElements[3];
		string = string + ("    [*] Misc");
		string = string + "\n";
		string = string + "\n";
		if (cms.getDescription() != null && cms.getDescription() != "") {
			string = string + ("         [i]" + cms.getDescription() + "[/i]");
			string = string + "\n";
		}
		string = string + ("  [/list]");
		string = string + "\n";
		string = string + "\n";
	}

	public static void writeInfosFromDisscusion(
			Meeting meeting) throws IOException {
		boolean written = false;
		int nr = 0;
		ims = (IssueMeetingSection) childElements[4];
		string = string + ("  [*] [b]Discussion[/b] [" + ims.getAllocatedTime()
				+ " Minutes]");
		string = string + "\n";
		string = string + "\n";
		set = ims.getLinkedModelElements();
		o = set.toArray();
		if (o.length != 0) {

			for (int j = 0; j < o.length; j++)
				if (o[j] instanceof Issue) {
					nr++;
					if (!written) {
						string = string + ("  [list]");
						string = string + "\n";
						written = true;
					}
					string = string + "\n";
					issue = (Issue) o[j];
					writeInfosFromIssues(meeting, issue, nr);
					if (j == o.length && written) {
						string = string + ("  [/list]");
						string = string + "\n";
						string = string + "\n";
					}
				}

		}
	}

	public static void writeInfosFromIssues(Meeting meeting, Issue is, int j)
			throws IOException {

		string = string + ("    [*] #issue [" + (j + 1) + ", ");
		if (is.getAssignee() != null)
			string = string + (is.getAssignee().getName() + "]: ");
		else
			string = string + ("<no assignee defined>" + "]: ");
		string = string + (is.getName() + " (" + is.getState() + ")");
		string = string + "\n";
		if (is.getDescription() != "" && is.getDescription() != null) {
			string = string + ("        [i]" + is.getDescription() + "[/i]");
			string = string + "\n";
		}
		EList<Proposal> proposals = is.getProposals();
		if (proposals.size() > 0) {
			string = string + ("    [list=1]");
			string = string + "\n";
			for (int k = 0; k < proposals.size(); k++) {
				string = string
						+ ("      [*] #alt" + (k + 1) + " [" + (j + 1) + "]: "
								+ proposals.get(k).getCreator() + ": " + proposals
								.get(k).getName());
				string = string + "\n";
				if (proposals.get(k).getDescription() != null && proposals.get(k).getDescription() != ""){
				string = string
						+ ("         [i]" + proposals.get(k).getDescription() + "[/i]");
				string = string + "\n";}
			}
			string = string + ("    [/list]");
			string = string + "\n";
		}
		if (is.getSolution()!=null){
			if (is.getSolution().getDescription() !=null && is.getSolution().getDescription() != ""){
				string = string +("        Resolution [" + is.getSolution().getCreator()
				+ "]: [i]" + is.getSolution().getDescription() + "[/i]");
			}
			else {
				string = string +("        Resolution [" + is.getSolution().getCreator()
						+ "]: <no description defined>");
			}
		}
		string = string + "\n";
		string = string + "\n";
	}

	public static void writeInfosFromWrapUp(Meeting meeting)
	throws IOException {
		string = string + "\n";
cms = (CompositeMeetingSection) childElements[5];
string = string + ("  [*] [b]Wrap-up[/b] [" + cms.getAllocatedTime()
		+ " Minutes]");
string = string + "\n";
string = string + "\n";
if ((childElements[6] != null || childElements[7] != null) && cal.getTime().after(meeting.getEndtime())) {
	
	string = string + ("  [list=1]");
	string = string + "\n";
}
if (childElements[6] != null && cal.getTime().after(meeting.getEndtime())) {
	string = string + ("    [*]New Action Items");
	string = string + "\n";
	workItemSection = (WorkItemMeetingSection) childElements[6];
	EList<WorkItem> work_items = workItemSection.getIncludedWorkItems();
	if (work_items.size() > 0) {
		string = string + ("    [list]");
		string = string + "\n";
	writeInfosFromNewActionItems(meeting, work_items);
	string = string + ("    [/list]");
	string = string + "\n";
	}
}
if (childElements[7] != null && cal.getTime().after(meeting.getEndtime())) {

	writeInfosFromMeetingCritique(meeting);

} else
	error_message = "!Couldn't find Meeting Critique!";
if (childElements[6] != null || childElements[7] != null) {
	string = string + ("  [/list]");
	string = string + "\n";
}
string = string + ("[/list]");
string = string + "\n";
}

	public static void writeInfosFromNewActionItems(
			Meeting meeting, EList<WorkItem> work_items) throws IOException {
		

			for (int l = 0; l < work_items.size(); l++) {
				if (work_items.get(l) instanceof ActionItem){
				string = string + "\n";
				string = string + ("      [*] [b]Name[/b]: "
						+ work_items.get(l).getName());
				string = string + "\n";
				if (work_items.get(l).getAssignee() != null)
					string = string + ("[b]Asignee[/b]: "
							+ work_items.get(l).getAssignee().getName());
				else
					string = string + ("[b]Asignee[/b]: " + "<not defined>");
				string = string + "\n";
				if (work_items.get(l).getDueDate() != null)
					string = string + ("[b]Deadline[/b]: "
							+ work_items.get(l).getDueDate().getDay() + "."
							+ work_items.get(l).getDueDate().getMonth());
				else
					string = string + ("[b]Deadline[/b]: " + "<not defined>");
				string = string + "\n";

				if (work_items.get(l).getState() != null)
					string = string + ("[b]Status[/b]: " + work_items.get(l).getState());
				else
					string = string + ("[b]Status[/b]: " + "<not defined>");
				string = string + "\n";
				if (work_items.get(l).getDescription() != null && work_items.get(l).getDescription() != ""){
				string = string + ("         [i]" + work_items.get(l).getDescription()
						+ "[/i]");
				string = string + "\n";}
			}
			
			if (work_items.get(l).getSuccessors()!=null)
				writeInfosFromNewActionItems(meeting, work_items.get(l).getSuccessors());
			}
		}


	public static void writeInfosFromMeetingCritique(Meeting meeting)
			throws IOException {
		string = string + "\n";
		cms = (CompositeMeetingSection) childElements[7];
		string = string + ("    [*]Meeting-Critique");
		string = string + "\n";
		string = string + "\n";
		if (cms.getDescription() != "" && cms.getDescription() != null) {
			string = string + ("         [i]" + cms.getDescription() + "[/i]");
			string = string + "\n";
		}
	}

	private static String getProjectName(UnicaseModelElement ume) {

		// get eobject of project and convert it to string
		String project = ume.getProject().eContainer().toString();

		// defining pattern
		Pattern pattern = Pattern
				.compile("(\\bprojectName\\b)(.*?)(\\bprojectDescription\\b)");
		Matcher match = pattern.matcher(project);
		List<String> matches = new ArrayList<String>();
		match.find();
		matches.add(match.group(2));

		// get first match which is only match in our case
		String projectName = matches.get(0);

		projectName = projectName.replace(':', ' ');
		projectName = projectName.replace(',', ' ');
		projectName = projectName.trim();

		return projectName;
	}

	public static String getErrorMessage() {
		return error_message;
	}

}
