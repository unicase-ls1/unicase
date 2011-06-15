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
import org.unicase.model.meeting.MeetingSection;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.meeditor.MEEditorInput;

/**
 * 
 * @author Carmen Carlan
 * 
 */
public class CreateBBCodeFormat {

	static File file;
	static FileWriter fstream;
	static BufferedWriter out;
	static Set<ModelElement> eee;
	static Object[] childElementss;
	static Object[] childElements;
	Object aux;
	static Set<ModelElement> set;
	static Object[] o;
	UnicaseModelElement m;
	static CompositeMeetingSection cms;
	CompositeMeetingSection cms_aux;
	static WorkItemMeetingSection w;
	ActionItem ai;
	static Issue is;
	static IssueMeetingSection ims;
	public static String error_message = "";
	public static Calendar cal = Calendar.getInstance();

	

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
		}
	}

	public static void writeHead(BufferedWriter out, Meeting meeting)
			throws IOException {
		out.write("[i][size=150]Chair for Applied Software Engineering [/size][/i]");
		out.newLine();
		out.newLine();
		out.write("[color=#008000][size=150] Project Name: "
				+ getProjectName(meeting) + "[/size][/color]");
		out.newLine();
		out.newLine();
		if (cal.getTime().before(meeting.getEndtime()))
		out.write("[size=150]Agenda: " + meeting.getName() + " [/size]");
		else
			out.write("[size=150]Protocol: " + meeting.getName() + " [/size]");
		out.newLine();
		out.newLine();
	}

	public static void writeGeneralInfos(BufferedWriter out, Meeting meeting)
			throws IOException {
		out.write("[code]");
		out.newLine();
		out.write("Time and Location       Roles");
		out.newLine();
		if (meeting.getCreationDate() != null)
			out.write("Date: " + meeting.getCreationDate().getDay() + "-"
					+ meeting.getCreationDate().getMonth() + "-"
					+ (meeting.getCreationDate().getYear() + 1900));
		else
			out.write("Date: " + "<not defined>");
		if (meeting.getFacilitator() != null)
			out.write("          Moderator: "
					+ meeting.getFacilitator().getName());
		else
			out.write("          Moderator: " + "<not defined>");
		out.newLine();
		if (meeting.getStarttime() != null) {
			if (meeting.getStarttime().getHours() > 10
					&& meeting.getStarttime().getMinutes() > 10)
				out.write("Start: " + meeting.getStarttime().getHours() + ":"
						+ meeting.getStarttime().getMinutes());
			else if (meeting.getStarttime().getHours() > 10
					&& meeting.getStarttime().getMinutes() < 10)
				out.write("Start: " + meeting.getStarttime().getHours() + ":0"
						+ meeting.getStarttime().getMinutes());
			else if (meeting.getStarttime().getHours() < 10
					&& meeting.getStarttime().getMinutes() < 10)
				out.write("Start: 0" + meeting.getStarttime().getHours() + ":0"
						+ meeting.getStarttime().getMinutes());
			else if (meeting.getStarttime().getHours() < 10
					&& meeting.getStarttime().getMinutes() > 10)
				out.write("Start: 0" + meeting.getStarttime().getHours() + ":"
						+ meeting.getStarttime().getMinutes());
		} else
			out.write("Start: " + "<not defined>");
		if (meeting.getTimekeeper() != null)
			out.write("            Time Keeper: "
					+ meeting.getTimekeeper().getName());
		else
			out.write("            Time Keeper: " + "<not defined>");
		out.newLine();
		if (meeting.getTimekeeper() != null) {
			if (meeting.getEndtime().getHours() > 10
					&& meeting.getEndtime().getMinutes() > 10)
				out.write("End: " + meeting.getEndtime().getHours() + ":"
						+ meeting.getEndtime().getMinutes()
						+ "              Minute Taker: "
						+ meeting.getMinutetaker().getName());
			else if (meeting.getEndtime().getHours() > 10
					&& meeting.getEndtime().getMinutes() < 10)
				out.write("End: " + meeting.getEndtime().getHours() + ":0"
						+ meeting.getEndtime().getMinutes());
			else if (meeting.getEndtime().getHours() < 10
					&& meeting.getEndtime().getMinutes() < 10)
				out.write("End: 0" + meeting.getEndtime().getHours() + ":0"
						+ meeting.getEndtime().getMinutes());
			else if (meeting.getEndtime().getHours() < 10
					&& meeting.getEndtime().getMinutes() > 10)
				out.write("End: 0" + meeting.getEndtime().getHours() + ":"
						+ meeting.getEndtime().getMinutes());
		} else
			out.write("End: " + "<not defined>");
		if (meeting.getMinutetaker() != null)
			out.write("              Minute Taker: "
					+ meeting.getMinutetaker().getName());
		else
			out.write("              Minute Taker: " + "<not defined>");
		out.newLine();
		if (meeting.getLocation() != "")
			out.write("Location: " + meeting.getLocation());
		else
			out.write("Location: " + "<not defined>");
		out.newLine();
		EList<OrgUnit> participants_list = meeting.getParticipants();
		String s = "";
		if (participants_list.size() <= 0)
			out.write("Participants: " + "<not defined>");
		else {
			for (int i = 0; i < participants_list.size(); i++)
				s = s + participants_list.get(i).getName() + ", ";
			out.write("Participants: " + s);
		}
		out.newLine();
		out.write("[/code]");
		out.newLine();
		out.newLine();
		out.newLine();
	}

	public static void getModelElements(BufferedWriter out, Meeting meeting) {
		eee = meeting.getAllContainedModelElements();
		childElementss = eee.toArray();
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
				w = (WorkItemMeetingSection) childElementss[i];
				if (w.getName().equals("Action Items")) {
					childElements[2] = w;
				} else {
					childElements[6] = w;
				}
			}
	}

	public static void writeInfosFromObjective(BufferedWriter out,
			Meeting meeting) throws IOException {
		cms = (CompositeMeetingSection) childElements[0];
		out.write("[list=1]");
		out.newLine();
		out.write("  [*] [b]Objective[/b] [");
		out.write(cms.getAllocatedTime() + " Minutes]");
		out.newLine();
		out.newLine();
		if (cms.getDescription() != null) {
			out.write("       [i]" + cms.getDescription() + "[/i]");
			out.newLine();
			out.newLine();
		}
	}

	public static void writeInfosFromInfoSharing(BufferedWriter out,
			Meeting meeting) throws IOException {
		EList<WorkItem> work_items;
		cms = (CompositeMeetingSection) childElements[1];
		out.write("  [*] [b]Information Sharing[/b] [" + cms.getAllocatedTime()
				+ " Minutes]");
		out.newLine();
		out.newLine();
		out.write("  [list=1]");
		out.newLine();
		out.write("    [*] Action Items");
		out.newLine();
		out.write("    [list]");
		out.newLine();
		w = (WorkItemMeetingSection) childElements[2];
		work_items = w.getIncludedWorkItems();
		writeInfosFromActionItems(out, meeting, work_items);
		out.write("    [/list]");
		out.newLine();
		out.newLine();
	}

	public static void writeInfosFromActionItems(BufferedWriter out,
			Meeting meeting, EList<WorkItem> work_items ) throws IOException {

		for (int l = 0; l < work_items.size(); l++) {
			if (work_items.get(l) instanceof ActionItem){
			out.newLine();
			out.write("      [*] [b]Name[/b]: " + work_items.get(l).getName());
			out.newLine();
			if (work_items.get(l).getAssignee() != null)
				out.write("[b]Asignee[/b]: "
						+ work_items.get(l).getAssignee().getName());
			else
				out.write("[b]Asignee[/b]: " + "<not defined>");
			out.newLine();
			if (work_items.get(l).getDueDate() != null)
				out.write("[b]Deadline[/b]: "
						+ work_items.get(l).getDueDate().getDay() + "."
						+ work_items.get(l).getDueDate().getMonth());
			else
				out.write("[b]Deadline[/b]: " + "<not defined>");
			out.newLine();

			if (work_items.get(l).getState() != null)
				out.write("[b]Status[/b]: " + work_items.get(l).getState());
			else
				out.write("[b]Status[/b]: " + "<not defined>" + ", ");
			out.newLine();
			out.write("         [i]" + work_items.get(l).getDescription()
					+ "[/i]");
			out.newLine();
			}
		}
	}

	public static void writeInfosFromMisc(BufferedWriter out, Meeting meeting)
			throws IOException {
		cms = (CompositeMeetingSection) childElements[3];
		out.write("    [*] Misc");
		out.newLine();
		out.newLine();
		if (cms.getDescription() != "") {
			out.write("         [i]" + cms.getDescription() + "[/i]");
			out.newLine();
		}
		out.write("  [/list]");
		out.newLine();
		out.newLine();
	}

	public static void writeInfosFromDisscusion(BufferedWriter out,
			Meeting meeting) throws IOException {
		boolean written = false;
		int nr = 0;
		ims = (IssueMeetingSection) childElements[4];
		out.write("  [*] [b]Discussion[/b] [" + ims.getAllocatedTime()
				+ " Minutes]");
		out.newLine();
		out.newLine();
		set = ims.getLinkedModelElements();
		o = set.toArray();
		if (o.length != 0) {

			for (int j = 0; j < o.length; j++)
				if (o[j] instanceof Issue) {
					nr++;
					if (!written) {
						out.write("  [list]");
						out.newLine();
						written = true;
					}
					out.newLine();
					is = (Issue) o[j];
					writeInfosFromIssues(out, meeting, is, nr);
					if (j == o.length && written) {
						out.write("  [/list]");
						out.newLine();
						out.newLine();
					}
				}

		}
	}

	public static void writeInfosFromIssues(BufferedWriter out,
			Meeting meeting, Issue is, int j) throws IOException {

		out.write("    [*] #issue [" + (j + 1) + ", ");
		if (is.getAssignee() != null)
			out.write(is.getAssignee().getName() + "]: ");
		else
			out.write("<not defined>" + "]: ");
		out.write(is.getName() + " (" + is.getState() + ")");
		out.newLine();
		if (is.getDescription() != "") {
			out.write("        [i]" + is.getDescription() + "[/i]");
			out.newLine();
		}
		EList<Proposal> proposals = is.getProposals();
		if (proposals.size() > 0) {
			out.write("    [list=1]");
			out.newLine();
			for (int k = 0; k < proposals.size(); k++) {
				out.write("      [*] #alt" + (k + 1) + " [" + (j + 1) + "]: "
						+ proposals.get(k).getCreator() + ": "
						+ proposals.get(k).getName());
				out.newLine();
				out.write("         [i]" + proposals.get(k).getDescription()
						+ "[/i]");
				out.newLine();
			}
			out.write("    [/list]");
			out.newLine();
		}
		out.write("        Resolution [" + is.getSolution().getCreator()
				+ "]: [i]" + is.getSolution().getDescription() + "[/i]");
		out.newLine();
		out.newLine();
		
	}

	public static void writeInfosFromWrapUp(BufferedWriter out, Meeting meeting)
			throws IOException {
		out.newLine();
		cms = (CompositeMeetingSection) childElements[5];
		out.write("  [*] [b]Wrap-up[/b] [" + cms.getAllocatedTime()
				+ " Minutes]");
		out.newLine();
		out.newLine();
		if (childElements[6] != null || childElements[7] != null && cal.getTime().after(meeting.getEndtime())) {
			out.write("  [list=1]");
			out.newLine();
		}
		if (childElements[6] != null && cal.getTime().after(meeting.getEndtime())) {
			out.write("    [*]New Action Items");
			out.newLine();
			w = (WorkItemMeetingSection) childElements[6];
			EList<WorkItem> work_items = w.getIncludedWorkItems();
			if (work_items.size() > 0) {
				out.write("    [list]");
				out.newLine();
			writeInfosFromNewActionItems(out, meeting, work_items);
			out.write("    [/list]");
			out.newLine();
			}
		}
		if (childElements[7] != null && cal.getTime().after(meeting.getEndtime())) {

			writeInfosFromMeetingCritique(out, meeting);

		} else
			error_message = "!Couldn't find Meeting Critique!";
		if (childElements[6] != null || childElements[7] != null) {
			out.write("  [/list]");
			out.newLine();
		}
		out.write("[/list]");
		out.newLine();
	}

	public static void writeInfosFromNewActionItems(BufferedWriter out,
			Meeting meeting, EList<WorkItem> work_items) throws IOException {
		

			for (int l = 0; l < work_items.size(); l++) {
				if (work_items.get(l) instanceof ActionItem){
				out.newLine();
				out.write("      [*] [b]Name[/b]: "
						+ work_items.get(l).getName());
				out.newLine();
				if (work_items.get(l).getAssignee() != null)
					out.write("[b]Asignee[/b]: "
							+ work_items.get(l).getAssignee().getName());
				else
					out.write("[b]Asignee[/b]: " + "<not defined>");
				out.newLine();
				if (work_items.get(l).getDueDate() != null)
					out.write("[b]Deadline[/b]: "
							+ work_items.get(l).getDueDate().getDay() + "."
							+ work_items.get(l).getDueDate().getMonth());
				else
					out.write("[b]Deadline[/b]: " + "<not defined>");
				out.newLine();

				if (work_items.get(l).getState() != null)
					out.write("[b]Status[/b]: " + work_items.get(l).getState());
				else
					out.write("[b]Status[/b]: " + "<not defined>");
				out.newLine();
				out.write("         [i]" + work_items.get(l).getDescription()
						+ "[/i]");
				out.newLine();
			}
			
			if (work_items.get(l).getSuccessors()!=null)
				writeInfosFromNewActionItems(out, meeting, work_items.get(l).getSuccessors());
			}
		}

	
	
	public static void writeInfosFromMeetingCritique(BufferedWriter out,
			Meeting meeting) throws IOException {
		out.newLine();
		cms = (CompositeMeetingSection) childElements[7];
		out.write("    [*]Meeting-Critique");
		out.newLine();
		out.newLine();
		if (cms.getDescription() != "") {
			out.write("         [i]" + cms.getDescription() + "[/i]");
			out.newLine();
		}
	}

	public static String getErrorMessage() {
		return error_message;
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

}
