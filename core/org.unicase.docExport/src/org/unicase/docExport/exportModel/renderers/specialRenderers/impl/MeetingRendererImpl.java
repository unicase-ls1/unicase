/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
import org.unicase.model.UnicaseModelElement;
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
	 * 
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
	public static final String TOPIC_PROTOKOLL = "Minutes: ";

	private transient Meeting meeting;
	private TextOption workItemTextOption;

	/**
	 * @param modelElement the ModelElement which shall be rendered
	 * @param section the section where the content of the ModelElement will be added
	 */
	@Override
	public void doRender(UnicaseModelElement modelElement, UCompositeSection section) {

		for (RendererOption option : getRendererOptions()) {
			if (option.getName().equals("workItem")) {
				setWorkItemTextOption((TextOption) option);
			}
		}

		this.setMeeting((Meeting) modelElement);

		String topic = "";
		if (getMeeting().getStarttime() == null) {
			topic += TOPIC_AGENDA;
		} else if (getMeeting().getStarttime().compareTo(Calendar.getInstance().getTime()) < 0) {
			topic += TOPIC_PROTOKOLL;
		} else {
			topic += TOPIC_AGENDA;
		}

		UParagraph topic2 = new UParagraph(topic + getMeeting().getName(), (TextOption) EcoreUtil.copy(getTemplate()
			.getLayoutOptions().getSectionTextOption()));

		USection title = new USection(topic2);
		section.add(title);
		title.getSectionOption().setLeaveOutPreviousSectionNumbering(true);
		title.getSectionOption().setSectionNumberingStyle(SectionNumberingStyle.NONE);
		title.getBoxModel().setMarginTop(20);

		if (title.getDepth() > 1 && title.getDepth() < 4) {
			title.getTitlParagraph().getOption().setFontSize(
				getTemplate().getLayoutOptions().getSectionTextOption().getFontSize()
					- getTemplate().getLayoutOptions().getSectionFontSizeDecreaseStep() * title.getDepth());
		}

		createMeetingTable(title);
		createMeetingDescription(title);
		renderMeetingSections(title);

	}

	/**
	 * Renders the meeting description.
	 * 
	 * @param parent
	 */
	private void createMeetingDescription(USection parent) {
		renderDescription(parent, getMeeting());
	}

	/**
	 * creates the meeting table of this meeting containing the most important information.
	 */
	protected void createMeetingTable(USection parent) {
		UTable table = new UTable(2);
		table.getBoxModel().setMarginTop(5);
		table.getDefaultCellBoxModel().setBorder(0.8);
		table.getDefaultCellBoxModel().setBorderStyle(UBorderStyle.SOLID);

		table.getBoxModel().setMarginBottom(5);
		table.getBoxModel().setKeepTogether(true);
		table.getBoxModel().setKeepWithPrevious(true);

		UTableCell wannUndWo = new UTableCell("Time and Location");
		UTableCell rollen = new UTableCell("Roles");
		Color background = new Color(210, 210, 210);
		wannUndWo.getBoxModel().setBackgroundColor(background);
		wannUndWo.getBoxModel().setBorder(0.8);
		wannUndWo.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		rollen.getBoxModel().setBorder(0.8);
		rollen.getBoxModel().setBackgroundColor(background);
		rollen.getBoxModel().setBorderStyle(UBorderStyle.SOLID);
		table.add(wannUndWo);
		table.add(rollen);

		String text;
		if (getMeeting().getStarttime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(getMeeting().getStarttime());
			text = cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
		} else {
			text = "";
		}
		table.add("Date: " + text);

		if (getMeeting().getFacilitator() != null) {
			text = getOrgUnitName(getMeeting().getFacilitator());
		} else {
			text = "";
		}
		table.add("Moderator: " + text);

		if (getMeeting().getStarttime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(getMeeting().getStarttime());
			text = getTimeString(cal);
		} else {
			text = "";
		}
		table.add("Start: " + text);

		if (getMeeting().getTimekeeper() != null) {
			text = getOrgUnitName(getMeeting().getTimekeeper());
		} else {
			text = "";
		}
		table.add("Time Keeper: " + text);

		if (getMeeting().getEndtime() != null) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(getMeeting().getEndtime());
			text = getTimeString(cal);
		} else {
			text = "";
		}
		table.add("End: " + text);

		if (getMeeting().getMinutetaker() != null) {
			text = getOrgUnitName(getMeeting().getMinutetaker());
		} else {
			text = "";
		}
		table.add("Minute Taker: " + text);

		if (getMeeting().getLocation() != null) {
			text = getMeeting().getLocation();
		} else {
			text = "";
		}
		UTableCell ort = new UTableCell("Location: " + text);
		ort.setColspan(2);
		ort.setBoxModel(table.getDefaultCellBoxModel());
		table.add(ort);

		String text2 = "Participants: ";
		for (OrgUnit orgUnit : getMeeting().getParticipants()) {
			text2 += getOrgUnitName(orgUnit) + ", ";
		}
		text2 = text2.substring(0, text2.length() - 2);

		UTableCell teilnehmer = new UTableCell(text2);
		teilnehmer.setColspan(2);
		teilnehmer.setBoxModel(table.getDefaultCellBoxModel());
		table.add(teilnehmer);

		parent.add(table);
	}

	protected String getTimeString(Calendar cal) {
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

	protected void renderMeetingSections(USection title) {

		EList<MeetingSection> sections = getMeeting().getSections();
		for (MeetingSection meetingSection : sections) {
			renderMeetingSection(title, meetingSection);
		}
	}

	protected void renderMeetingSection(UCompositeSection parent, MeetingSection meetingSection) {

		if (meetingSection instanceof CompositeMeetingSection) {
			renderCompositeMeetingSection(parent, (CompositeMeetingSection) meetingSection);
		} else if (meetingSection instanceof WorkItemMeetingSection) {
			renderWorkItemMeetingSection(parent, (WorkItemMeetingSection) meetingSection);
		} else if (meetingSection instanceof IssueMeetingSection) {
			renderIssueMeetingSection(parent, (IssueMeetingSection) meetingSection);
		}
	}

	protected void renderCompositeMeetingSection(UCompositeSection parent, CompositeMeetingSection meetingSection) {

		parent.add(new UParagraph(" "));

		USection uSection = new USection(getMeetingSectionTitle(meetingSection), getTemplate().getLayoutOptions()
			.getModelElementTextOption());
		parent.add(uSection);
		uSection.getBoxModel().setMarginTop(12);

		renderDescription(uSection, meetingSection);

		EList<MeetingSection> sections = meetingSection.getSubsections();
		for (MeetingSection subSection : sections) {
			renderMeetingSection(uSection, subSection);
		}
	}

	protected void renderIssueMeetingSection(UCompositeSection parent, IssueMeetingSection meetingSection) {

		parent.add(new UParagraph(" "));

		USection issueSection = new USection(getMeetingSectionTitle(meetingSection), getTemplate().getLayoutOptions()
			.getModelElementTextOption());
		parent.add(issueSection);
		issueSection.getBoxModel().setMarginTop(10);

		renderDescription(issueSection, meetingSection);

		int i = 1;
		EList<Issue> issues = meetingSection.getIncludedIssues();
		for (Issue issue : issues) {
			renderWorkItem(issueSection, issue, i++);
		}
	}

	protected void renderWorkItemMeetingSection(UCompositeSection parent, WorkItemMeetingSection meetingSection) {
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
		}
	}

	protected void renderWorkItem(USection workItemSection, WorkItem workItem, int number) {

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
				workItemText += cal.get(Calendar.DAY_OF_MONTH) + "." + (cal.get(Calendar.MONTH) + 1) + ".";
			}
			workItemText += "]: " + workItem.getName();
		} else {
			text += "WI";
		}
		workItemText += " (" + workItem.getState() + ")";

		UParagraph par = new UParagraph(text + workItemText, getWorkItemTextOption());
		par.setIndentionLeft(1);
		workItemSection.add(par);

		if (workItem instanceof Issue) {
			Issue issue = (Issue) workItem;
			UParagraph issueDescriptionPar = new UParagraph(WorkspaceUtil.cleanFormatedText(issue.getDescription()),
				getWorkItemTextOption());
			issueDescriptionPar.setIndentionLeft(2);
			workItemSection.add(issueDescriptionPar);
			int i = 1;
			for (Proposal proposal : issue.getProposals()) {
				String text2 = "P[" + number + "." + i++ + "]: " + proposal.getName();
				UParagraph par2 = new UParagraph(text2, getWorkItemTextOption());
				String text3 = WorkspaceUtil.cleanFormatedText(proposal.getDescription());
				UParagraph par3 = new UParagraph(text3, getWorkItemTextOption());
				par2.setIndentionLeft(3);
				par3.setIndentionLeft(4);
				workItemSection.add(par2);
				workItemSection.add(par3);
			}

			if (issue.getSolution() != null) {
				UParagraph solution = new UParagraph("Solution: " + issue.getSolution().getName(),
					getWorkItemTextOption());
				String solutionDescription = WorkspaceUtil.cleanFormatedText(issue.getSolution().getDescription());
				UParagraph solutionPar = new UParagraph(solutionDescription, getWorkItemTextOption());
				solution.setIndentionLeft(3);
				workItemSection.add(solution);
				solutionPar.setIndentionLeft(4);
				workItemSection.add(solutionPar);
			}
		}
	}

	protected String getMeetingSectionTitle(MeetingSection meetingSection) {
		String title = meetingSection.getName();
		if (meetingSection.getAllocatedTime() > 0) {
			title += " [" + meetingSection.getAllocatedTime() + " Minutes]";
		}
		return title;
	}

	protected void renderDescription(UCompositeSection parent, UnicaseModelElement me) {
		UParagraph descr = new UParagraph(WorkspaceUtil.cleanFormatedText(me.getDescription()) + "\n", getTemplate()
			.getLayoutOptions().getDefaultTextOption());
		descr.setIndentionLeft(1);
		parent.add(descr);
		descr.getBoxModel().setKeepWithPrevious(true);
	}

	protected String getOrgUnitName(OrgUnit orgUnit) {

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

	/**
	 * @param meeting the meeting to set
	 */
	protected void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}

	/**
	 * @return the meeting
	 */
	protected Meeting getMeeting() {
		return meeting;
	}

	/**
	 * @param workItemTextOption the workItemTextOption to set
	 */
	protected void setWorkItemTextOption(TextOption workItemTextOption) {
		this.workItemTextOption = workItemTextOption;
	}

	/**
	 * @return the workItemTextOption
	 */
	protected TextOption getWorkItemTextOption() {
		return workItemTextOption;
	}

} // MeetingRendererImpl
