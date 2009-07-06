/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.impl.ModelElementRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.exportModel.renderers.options.SectionNumberingStyle;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.model.ModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingSection;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Meeting Renderer</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class MeetingRendererImpl extends ModelElementRendererImpl implements MeetingRenderer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected MeetingRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.MEETING_RENDERER;
	}

	// begin custom code

	/**
	 * agenda text.
	 */
	public static final String TOPIC_AGENDA = "Agenda: ";

	/**
	 * protokoll text.
	 */
	public static final String TOPIC_PROTOKOLL = "Protokoll: ";

	private transient Meeting meeting;
	private TextOption workItemTextOption;

	/**
	 * @param modelElement the ModelElement which shall be rendered
	 * @param section the section where the content of the ModelElement will be added
	 */
	@Override
	public void doRender(ModelElement modelElement, UCompositeSection section) {

		for (RendererOption option : getRendererOptions()) {
			if (option.getName().equals("workItem")) {
				workItemTextOption = (TextOption) option;
			}
		}

		this.meeting = (Meeting) modelElement;

		String topic = "";
		if (meeting.getStarttime() == null) {
			topic += TOPIC_AGENDA;
		} else if (meeting.getStarttime().compareTo(Calendar.getInstance().getTime()) > 0) {
			topic += TOPIC_PROTOKOLL;
		} else {
			topic += TOPIC_AGENDA;
		}

		UParagraph topic2 = new UParagraph(topic + meeting.getName(), (TextOption) EcoreUtil.copy(getTemplate()
			.getLayoutOptions().getSectionTextOption()));

		USection title = new USection(topic2);
		section.add(title);
		// todo this break is also done, if there are no following elements after the Meeting
		// so there is an empty page at the end if you export a single meeting
		// if you export multiple meetings, there should be page breaks between the meetings..
		// looks nicer!
		// title.getBoxModel().setBreakAfter(true);
		title.getSectionOption().setLeaveOutPreviousSectionNumbering(true);
		title.getSectionOption().setSectionNumberingStyle(SectionNumberingStyle.NONE);
		title.getBoxModel().setMarginTop(20);

		if (title.getDepth() > 1 && title.getDepth() < 4) {
			title.getTitlParagraph().getOption().setFontSize(
				getTemplate().getLayoutOptions().getSectionTextOption().getFontSize()
					- getTemplate().getLayoutOptions().getSectionFontSizeDecreaseStep() * title.getDepth());
		}

		createMeetingTable(title);
		renderMeetingSections(title);

	}

	/**
	 * creates the meeting table of this meeting containing the most important information.
	 */
	private void createMeetingTable(USection parent) {
		UTable table = new UTable(2);
		table.getBoxModel().setMarginTop(5);
		table.getDefaultCellBoxModel().setBorder(0.8);
		table.getDefaultCellBoxModel().setBorderStyle(UBorderStyle.SOLID);

		table.getBoxModel().setMarginBottom(5);
		table.getBoxModel().setKeepTogether(true);
		table.getBoxModel().setKeepWithPrevious(true);

		UTableCell wannUndWo = new UTableCell("Wann und Wo");
		UTableCell rollen = new UTableCell("Rollen");
		Color background = new Color(210, 210, 210);
		wannUndWo.getBoxModel().setBackgroundColor(background);
		wannUndWo.getBoxModel().setBorder(0.8);
		wannUndWo.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		rollen.getBoxModel().setBorder(0.8);
		rollen.getBoxModel().setBackgroundColor(background);
		rollen.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		table.addCell(wannUndWo);
		table.addCell(rollen);

		String text;
		if (meeting.getStarttime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(meeting.getStarttime());
			text = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
		} else {
			text = "";
		}
		table.addCell("Datum: " + text);

		if (meeting.getFacilitator() != null) {
			text = getOrgUnitName(meeting.getFacilitator());
		} else {
			text = "";
		}
		table.addCell("Moderator: " + text);

		if (meeting.getStarttime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(meeting.getStarttime());
			text = getTimeString(cal);
		} else {
			text = "";
		}
		table.addCell("Start: " + text);

		if (meeting.getTimekeeper() != null) {
			text = getOrgUnitName(meeting.getTimekeeper());
		} else {
			text = "";
		}
		table.addCell("Zeitnehmer: " + text);

		if (meeting.getEndtime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(meeting.getEndtime());
			text = getTimeString(cal);
		} else {
			text = "";
		}
		table.addCell("Ende: " + text);

		if (meeting.getMinutetaker() != null) {
			text = getOrgUnitName(meeting.getMinutetaker());
		} else {
			text = "";
		}
		table.addCell("Protokollant: " + text);

		if (meeting.getLocation() != null) {
			text = meeting.getLocation();
		} else {
			text = "";
		}
		UTableCell ort = new UTableCell("Ort: " + text);
		ort.setColspan(2);
		ort.setBoxModel(table.getDefaultCellBoxModel());
		table.addCell(ort);

		String text2 = "Teilnehmer: ";
		for (OrgUnit orgUnit : meeting.getParticipants()) {
			text2 += getOrgUnitName(orgUnit) + ", ";
		}
		text2 = text2.substring(0, text2.length() - 2);

		UTableCell teilnehmer = new UTableCell(text2);
		teilnehmer.setColspan(2);
		teilnehmer.setBoxModel(table.getDefaultCellBoxModel());
		table.addCell(teilnehmer);

		parent.add(table);
	}

	private String getTimeString(Calendar cal) {
		String text = "";
		if (cal.get(Calendar.HOUR_OF_DAY) < 10) {
			text += 0;
		}
		text += cal.get(Calendar.HOUR_OF_DAY);
		text += ":";
		if (cal.get(Calendar.MINUTE) < 10) {
			text += 0;
		}
		text += cal.get(Calendar.MINUTE);

		return text;
	}

	private void renderMeetingSections(USection title) {

		EList<MeetingSection> sections = meeting.getSections();
		for (MeetingSection meetingSection : sections) {
			renderMeetingSection(title, meetingSection);
		}
	}

	private void renderMeetingSection(UCompositeSection parent, MeetingSection meetingSection) {

		if (meetingSection instanceof CompositeMeetingSection) {
			renderCompositeMeetingSection(parent, (CompositeMeetingSection) meetingSection);
		} else if (meetingSection instanceof WorkItemMeetingSection) {
			renderWorkItemMeetingSection(parent, (WorkItemMeetingSection) meetingSection);
		} else if (meetingSection instanceof IssueMeetingSection) {
			renderIssueMeetingSection(parent, (IssueMeetingSection) meetingSection);
		}
	}

	private void renderCompositeMeetingSection(UCompositeSection parent, CompositeMeetingSection meetingSection) {

		parent.add(new UParagraph(" "));

		USection uSection = new USection(getMeetingSectionTitle(meetingSection), getTemplate().getLayoutOptions()
			.getModelElementTextOption());
		parent.add(uSection);
		// uSection.getSectionOption().setLeaveOutPreviousSectionNumbering(true);
		uSection.getBoxModel().setMarginTop(12);

		renderDescription(uSection, meetingSection);

		EList<MeetingSection> sections = meetingSection.getSubsections();
		for (MeetingSection subSection : sections) {
			renderMeetingSection(uSection, subSection);
		}
	}

	private void renderIssueMeetingSection(UCompositeSection parent, IssueMeetingSection meetingSection) {

		parent.add(new UParagraph(" "));

		USection issueSection = new USection(getMeetingSectionTitle(meetingSection), getTemplate().getLayoutOptions()
			.getModelElementTextOption());
		parent.add(issueSection);
		issueSection.getBoxModel().setMarginTop(10);

		renderDescription(issueSection, meetingSection);

		int i = 1;
		EList<Issue> issues = meetingSection.getIncludedIssues();
		for (Issue issue : issues) {

			renderWorkItem(issueSection, issue, i);
			i++;
			// ModelElementRendererMappings mappings = template.modelElementRendererMappings;
			// ModelElementRenderer renderer = mappings.get(Issue.class);
			// renderer.render(issue, issueSection, layoutOptions);

			// UParagraph par = new UParagraph("- " + issue.getName(), layoutOptions.defaultTextOption);
			// par.setIndentionLeft(1);
			// issueSection.add(par);
		}
	}

	private void renderWorkItemMeetingSection(UCompositeSection parent, WorkItemMeetingSection meetingSection) {
		USection workItemSection = new USection(getMeetingSectionTitle(meetingSection), getTemplate()
			.getLayoutOptions().getModelElementTextOption());
		parent.add(new UParagraph(" "));
		workItemSection.getBoxModel().setMarginTop(10);

		parent.add(workItemSection);

		renderDescription(workItemSection, meetingSection);

		int i = 1;
		EList<WorkItem> workItems = meetingSection.getIncludedWorkItems();
		for (WorkItem workItem : workItems) {

			renderWorkItem(workItemSection, workItem, i);
			i++;

			// UParagraph par = new UParagraph("- " + workItem.getName(), layoutOptions.defaultTextOption);
			// par.setIndentionLeft(1);
			// workItemSection.add(par);
		}
	}

	private void renderWorkItem(USection workItemSection, WorkItem workItem, int number) {
		// ModelElementRendererMappings mappings = template.modelElementRendererMappings;
		// ModelElementRenderer renderer = mappings.get(workItem.eClass().getInstanceClass());
		// renderer.render(workItem, workItemSection, layoutOptions);

		String text = "";
		String workItemText = "[" + number + ", " + getOrgUnitName(workItem.getAssignee()) + "]: " + workItem.getName();
		if (workItem instanceof Issue) {
			text += "I";
		} else if (workItem instanceof BugReport) {
			text += "BR";
		} else if (workItem instanceof WorkPackage) {
			text += "WP";
		} else if (workItem instanceof ActionItem) {
			text += "AI";
			workItemText = "[" + number + ", " + getOrgUnitName(((ActionItem) workItem).getAssignee()) + ", ";

			if (((ActionItem) workItem).getDueDate() == null) {
				workItemText += "ASAP";
			} else {
				Date dueDate = ((ActionItem) workItem).getDueDate();
				Calendar cal = new GregorianCalendar();
				cal.setTime(dueDate);
				workItemText += cal.get(Calendar.DAY_OF_MONTH) + "." + cal.get(Calendar.MONTH);
			}
			workItemText += "]: " + workItem.getName();
			// text += " (" + workItem.getState() + ")";
		} else {
			text += "WI";
		}
		workItemText += " (" + workItem.getState() + ")";

		UParagraph par = new UParagraph(text + workItemText, workItemTextOption);
		par.setIndentionLeft(1);
		workItemSection.add(par);

		if (workItem instanceof Issue) {
			Issue issue = (Issue) workItem;
			int i = 1;
			for (Proposal proposal : issue.getProposals()) {
				String text2 = "P[" + number + "." + i + "]: " + proposal.getName();
				UParagraph par2 = new UParagraph(text2, workItemTextOption);
				par2.setIndentionLeft(2);
				workItemSection.add(par2);
			}

			if (issue.getSolution() != null) {
				UParagraph solution = new UParagraph("Solution: " + issue.getSolution().getName(), workItemTextOption);
				solution.setIndentionLeft(2);
				workItemSection.add(solution);
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
		UParagraph descr = new UParagraph(WorkspaceUtil.cleanFormatedText(me.getDescription()) + "\n", getTemplate()
			.getLayoutOptions().getDefaultTextOption());
		descr.setIndentionLeft(1);
		parent.add(descr);
		descr.getBoxModel().setKeepWithPrevious(true);
	}

	private String getOrgUnitName(OrgUnit orgUnit) {

		if (orgUnit == null) {
			return "<not assigned>";
		}

		String ret;
		if (orgUnit instanceof User) {
			if (((User) orgUnit).getLastName() != null) {
				ret = ((User) orgUnit).getLastName();
			} else {
				ret = orgUnit.getName();
			}

		} else {
			ret = orgUnit.getName();
		}

		return ret;
	}
	// end custom code

} // MeetingRendererImpl
