package org.unicase.documentexport.renderers.modelElement;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.unicase.documentexport.documentTemplate.DocumentTemplate;
import org.unicase.documentexport.renderers.ModelElementRenderer;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.documentexport.renderers.elements.UEntry;
import org.unicase.documentexport.renderers.elements.UParagraph;
import org.unicase.documentexport.renderers.elements.USection;
import org.unicase.documentexport.renderers.elements.UTable;
import org.unicase.documentexport.renderers.options.LayoutOptions;
import org.unicase.documentexport.renderers.options.TextOption;
import org.unicase.model.ModelElement;
import org.unicase.model.bug.BugReport;
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
import org.unicase.model.task.WorkPackage;

public class MeetingRenderer extends ModelElementRenderer {

	public static final String header = "Lehrstuhl f�r Angewandte Softwaretechnik \n DOLLI-Projekt";
	public static final String topicAgenda = "Agenda: ";
	public static final String topicProtokoll = "Protokoll: ";
	
	private transient Meeting meeting;
	private transient UCompositeSection parent;
	private TextOption workItemTextOption;
	
	
	public MeetingRenderer(DocumentTemplate template) {
		super(template);
		
		workItemTextOption = new TextOption();
		workItemTextOption.setName("workItem");
		this.rendererOptions.add(workItemTextOption);
	}

	
	@Override
	public void render(
			ModelElement modelElement, 
			UCompositeSection section,
			LayoutOptions layoutOptions) {
		this.meeting = (Meeting) modelElement;
		this.parent = section;
		this.layoutOptions = layoutOptions;
		
		String topic;
		if (meeting.getStarttime() == null) {
			topic = topicAgenda;
		} else if (meeting.getStarttime().compareTo(Calendar.getInstance().getTime()) > 0)
			topic = topicProtokoll;
		else {
			topic = topicAgenda;
		}
		UParagraph topic2 = new UParagraph(topic + meeting.getName());
		TextOption topicOption = new TextOption();
		topicOption.size = 20;
		topic2.option = topicOption;
		section.add(topic2);
		
		createMeetingTable();
		
		renderParticipants();
		
		renderMeetingSections();
		
	}


	private void createMeetingTable() {
		UTable table = new UTable(2);
		UEntry wannUndWo = new UEntry("Wann und Wo");
		UEntry rollen = new UEntry("Rollen");
		Color background = new Color(210, 210, 210);
		wannUndWo.backgroundColor = rollen.backgroundColor = background;
		table.addEntry(wannUndWo);
		table.addEntry(rollen);

		
		
		String text;
		if (meeting.getStarttime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(meeting.getStarttime());
			text = cal.get(Calendar.DAY_OF_MONTH) + 
			"-" + 
			(cal.get(Calendar.MONTH) + 1 ) + 
			"-" +
			cal.get(Calendar.YEAR);
		}
		else
			text = "";
		table.addEntry("Datum: " + text);
		
		
		if (meeting.getFacilitator() != null)
			text = meeting.getFacilitator().getName();
		else
			text = "";
		table.addEntry("Moderator: " + text);
		
		
		if (meeting.getStarttime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(meeting.getStarttime());
			text = getTimeString(cal);
		} else {
			text = "";
		}
		table.addEntry("Start: " + text);
		
		
		if (meeting.getTimekeeper() != null) {
			text = meeting.getTimekeeper().getName();
		} else {
			text = "";
		}
		table.addEntry("Zeitnehmer: " + text);
		
		
		if (meeting.getEndtime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(meeting.getEndtime());
			text = getTimeString(cal);
		} else {
			text = "";
		}
		table.addEntry("Ende: " + text);
		
		
		if (meeting.getMinutetaker() != null) {
			text = meeting.getMinutetaker().getName();
		} else {
			text = "";
		}
		table.addEntry("Protokollant: " + text);
		
		
		if (meeting.getLocation() != null) {
			text = meeting.getLocation();
		} else {
			text = "";
		}
		UEntry ort = new UEntry("Ort: " + text);
		ort.colspan = 2;
		table.addEntry(ort);
		
		String text2 = "Teilnehmer: ";
		for (OrgUnit orgUnit : meeting.getParticipants()) {
			text2 += orgUnit.getName() + ", ";
		}
		text2 = text2.substring(0, text2.length() - 2);
		
		UEntry teilnehmer = new UEntry(text2);
		teilnehmer.colspan = 2;
		table.addEntry(teilnehmer);
		
		
		
		parent.add(table);
		

	}
	
	private String getTimeString (Calendar cal) {
		String text = "";
		if (cal.get(Calendar.HOUR_OF_DAY) < 10)
			text += 0;
		text += cal.get(Calendar.HOUR_OF_DAY);
		text += ":";
		if (cal.get(Calendar.MINUTE) < 10)
			text += 0;
		text += cal.get(Calendar.MINUTE);
		
		return text;
	}

	
	private void renderParticipants() {
		
//		UTable table2 = new UTable(1);
//		String text2 = "Teilnehmer: ";
//		for (OrgUnit orgUnit : meeting.getParticipants()) {
//			text2 += orgUnit.getName() + ", ";
//		}
//		text2 = text2.substring(0, text2.length() - 2);
//		table2.addEntry(text2);
//		table2.addEntry(text2);
//		parent.add(table2);
	}
	
	private void renderMeetingSections() {
		EList<MeetingSection> sections = meeting.getSections();
		for (MeetingSection meetingSection : sections) {
			renderMeetingSection(parent, meetingSection);
		}
	}	
	
	
	private void renderMeetingSection (
			UCompositeSection parent, 
			MeetingSection meetingSection) {
		
		if (meetingSection instanceof CompositeMeetingSection) {
			renderCompositeMeetingSection(parent, (CompositeMeetingSection) meetingSection);
		} else if (meetingSection instanceof WorkItemMeetingSection) {
			renderWorkItemMeetingSection(parent, (WorkItemMeetingSection) meetingSection);
		} else if (meetingSection instanceof IssueMeetingSection) {
			renderIssueMeetingSection(parent, (IssueMeetingSection) meetingSection);
		}
	}
	
	
	private void renderCompositeMeetingSection(
			UCompositeSection parent,
			CompositeMeetingSection meetingSection) {
		
		USection uSection = new USection(
				getMeetingSectionTitle(meetingSection), 
				layoutOptions.sectionTextOption
			);
		parent.add(uSection);
		
		renderDescription(uSection, meetingSection);

		
		EList<MeetingSection> sections = meetingSection.getSubsections();
		for (MeetingSection subSection : sections) {
			renderMeetingSection(uSection, subSection);
		}
	}	
	
	
	private void renderIssueMeetingSection(
			UCompositeSection parent,
			IssueMeetingSection meetingSection) {
		
		USection issueSection = new USection(
				getMeetingSectionTitle(meetingSection), 
				layoutOptions.sectionTextOption
			);
		parent.add(issueSection);

		renderDescription(issueSection, meetingSection);
		
		int i = 1;
		EList<Issue> issues = meetingSection.getIncludedIssues();
		for (Issue issue : issues) {
			
			renderWorkItem(issueSection, issue, i);
			i++;
//			ModelElementRendererMappings mappings = template.modelElementRendererMappings;
//			ModelElementRenderer renderer = mappings.get(Issue.class);
//			renderer.render(issue, issueSection, layoutOptions);
			
//			UParagraph par = new UParagraph("- " + issue.getName(), layoutOptions.defaultTextOption);
//			par.setIndentionLeft(1);
//			issueSection.add(par);
		}
	}

	private void renderWorkItemMeetingSection(
			UCompositeSection parent,
			WorkItemMeetingSection meetingSection) {
		USection workItemSection = new USection(
				getMeetingSectionTitle(meetingSection), 
				layoutOptions.sectionTextOption
			);
		parent.add(workItemSection);	
		
		renderDescription(workItemSection, meetingSection);
		
		int i= 1;
		EList<WorkItem> workItems = meetingSection.getIncludedWorkItems();
		for (WorkItem workItem : workItems) {

			renderWorkItem(workItemSection, workItem, i);
			i++;
			
//			UParagraph par = new UParagraph("- " + workItem.getName(), layoutOptions.defaultTextOption);
//			par.setIndentionLeft(1);
//			workItemSection.add(par);
		}
	}


	private void renderWorkItem(USection workItemSection, WorkItem workItem, int number) {
//		ModelElementRendererMappings mappings = template.modelElementRendererMappings;
//		ModelElementRenderer renderer = mappings.get(workItem.eClass().getInstanceClass());
//		renderer.render(workItem, workItemSection, layoutOptions);
		String text = "";
		if (workItem instanceof Issue) {
			text += "I[" + number + "]: " + workItem.getName();
		} else if (workItem instanceof BugReport) {
			text += "BR[" + number + "]: " + workItem.getName();
		} else if (workItem instanceof WorkPackage) {
			text += "WP[" + number + "]: " + workItem.getName();
		} else if (workItem instanceof ActionItem) {
			text += "AI[" + number + ", ";
			for (OrgUnit orgUnit : ((ActionItem)workItem).getParticipants()) {
				text += orgUnit.getName() + ", ";
			}
			if (((ActionItem) workItem).getDueDate() != null) {
				text += "ASAP";
			} else {
				Date dueDate = ((ActionItem) workItem).getDueDate();
				Calendar cal = new GregorianCalendar();
				cal.setTime(dueDate);
				text += cal.get(Calendar.DAY_OF_MONTH) + "." + cal.get(Calendar.MONTH);
			}
			text += "]: " + workItem.getName();
			text += " (" + workItem.getState() + ")";
		} else {
			text += "WI[" + number + "]: " + workItem.getName();
		}
		
		UParagraph par = new UParagraph(text, workItemTextOption);
		par.setIndentionLeft(1);
		parent.add(par);
		
		if (workItem instanceof Issue) {
			Issue issue = (Issue)workItem;
			int i = 1;
			for (Proposal proposal : issue.getProposals()) {
				String text2 = "P[" + number + "." + i + "]" + proposal.getName();
				UParagraph par2 = new UParagraph(text2, workItemTextOption);
				par2.setIndentionLeft(2);
				parent.add(par2);
			}
		}
	}
	
	private String getMeetingSectionTitle(MeetingSection meetingSection) {
		String title = meetingSection.getName();
		if (meetingSection.getAllocatedTime() > 0) {
			title += " [" + meetingSection.getAllocatedTime() + " Minuten]";
		}
		return title;
	}
	
	private void renderDescription(UCompositeSection parent, ModelElement me) {
		String description = "";
		if (me.getDescription() != null)
			description += me.getDescription();

		
		if (description.indexOf("%BEGINNTEXT%") > 0 && description.length() > 0)
			description = description.substring(description.indexOf("%BEGINNTEXT%") + 12, description.length() - 1);
			
		UParagraph descr = new UParagraph(description + "\n", layoutOptions.defaultTextOption);
		descr.setIndentionLeft(0);
		parent.add(descr);	
	}
}
