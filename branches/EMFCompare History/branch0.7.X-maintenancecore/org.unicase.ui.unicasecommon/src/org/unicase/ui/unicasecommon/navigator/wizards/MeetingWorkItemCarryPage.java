/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.navigator.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.unicase.model.meeting.CompositeMeetingSection;
import org.unicase.model.meeting.IssueMeetingSection;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingSection;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.WorkItem;

/**
 * @author naughton Wizard page containing all items from last meeting to be selected for inclusion in the information
 *         exchange of this meeting.
 */
public class MeetingWorkItemCarryPage extends WizardPage {

	private static final String PAGE_TITLE = "Items from last meeting";
	private static final String PAGE_DESCRIPTION = "Select items to be carried over into the information sharing section of the next meeting.";
	private List<WorkItem> statusWorkItems;

	/**
	 * . Constructor
	 * 
	 * @param pageName page name
	 */
	protected MeetingWorkItemCarryPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		statusWorkItems = new ArrayList<WorkItem>();
	}

	/**
	 * . ({@inheritDoc})
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);
		Table checkTable = new Table(composite, SWT.CHECK | SWT.BORDER);
		checkTable.setLayoutData(new GridData(GridData.FILL_BOTH));
		populateTable(checkTable);

		checkTable.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					if (((TableItem) event.item).getChecked()) {
						statusWorkItems.add((WorkItem) event.item.getData());
					} else {
						WorkItem workItem = (WorkItem) event.item.getData();
						if (statusWorkItems.contains(workItem)) {
							statusWorkItems.remove(workItem);
						}
					}
				}
			}
		});

		setControl(composite);
	}

	/**
	 * Returns the work items collected for the status of the next meeting.
	 * 
	 * @return The work items for the status of the next meeting.
	 */
	public List<WorkItem> getStatusWorkItems() {
		return statusWorkItems;
	}

	// collect all workitems and issues and fill the table
	private void populateTable(Table table) {
		// Turn off drawing to avoid flicker
		table.setRedraw(false);

		Meeting selectedMeeting = ((FollowupMeetingWizard) getWizard()).getSelectedMeeting();

		List<WorkItem> identifiedWorkItems = new ArrayList<WorkItem>();
		if (selectedMeeting.getIdentifiedWorkItemsSection() != null) {
			identifiedWorkItems.addAll(selectedMeeting.getIdentifiedWorkItemsSection().getIncludedWorkItems());
		}

		List<WorkItem> otherWorkItems = new ArrayList<WorkItem>();
		for (WorkItemMeetingSection workItemMeetingSection : findOtherWorkItemMeetingSections(selectedMeeting
			.getSections(), selectedMeeting)) {
			List<WorkItem> includedWorkItems = workItemMeetingSection.getIncludedWorkItems();
			for (WorkItem workItem : includedWorkItems) {
				if (!identifiedWorkItems.contains(workItem)) {
					otherWorkItems.add(workItem);
				}
			}
		}

		List<Issue> identifiedIssues = new ArrayList<Issue>();
		if (selectedMeeting.getIdentifiedIssuesSection() != null) {
			identifiedIssues.addAll(selectedMeeting.getIdentifiedIssuesSection().getIncludedIssues());
		}

		List<Issue> otherIssues = new ArrayList<Issue>();
		for (IssueMeetingSection issueMeetingSection : findOtherIssueMeetingSections(selectedMeeting.getSections(),
			selectedMeeting)) {
			List<Issue> includedIssues = issueMeetingSection.getIncludedIssues();
			for (Issue issue : includedIssues) {
				if (!identifiedIssues.contains(issue)) {
					otherIssues.add(issue);
				}
			}
		}

		createTableItems(table, identifiedWorkItems, otherWorkItems, identifiedIssues, otherIssues);

		// Turn drawing back on!
		table.setRedraw(true);
	}

	// create and precheck table items
	private void createTableItems(Table table, List<WorkItem> identifiedWorkItems, List<WorkItem> otherWorkItems,
		List<Issue> identifiedIssues, List<Issue> otherIssues) {
		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		// first add all work items identified in the last meeting and check
		// them per default
		for (WorkItem workItem : identifiedWorkItems) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(workItem);
			item.setImage(labelProvider.getImage(workItem));
			item.setText(workItem.getName());
			item.setChecked(true);
			statusWorkItems.add(workItem);
		}
		// secondly add all issues identified in the last meeting and check
		// them if the have not been solved yet
		for (Issue issue : identifiedIssues) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(issue);
			item.setImage(labelProvider.getImage(issue));
			item.setText(issue.getName());
			item.setChecked(!issue.isChecked());
			if (!issue.isChecked()) {
				statusWorkItems.add(issue);
			}
		}
		// thirdly add all other work items from the last meeting (last meeting
		// status etc.) unchecked
		for (WorkItem workItem : otherWorkItems) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(workItem);
			item.setImage(labelProvider.getImage(workItem));
			item.setText(workItem.getName());
			item.setChecked(false);
		}
		// finally add all other issues from the last meeting unchecked as well
		for (Issue issue : otherIssues) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(issue);
			item.setImage(labelProvider.getImage(issue));
			item.setText(issue.getName());
			item.setChecked(false);
		}
	}

	// find IssueMeetingSections other than the one linked as
	// identifiedIssuesMeetingSection
	private List<IssueMeetingSection> findOtherIssueMeetingSections(List<MeetingSection> sections, Meeting meeting) {
		List<IssueMeetingSection> res = new ArrayList<IssueMeetingSection>();
		for (MeetingSection meetingSection : sections) {
			if (meetingSection instanceof IssueMeetingSection
				&& (!meetingSection.equals(meeting.getIdentifiedIssuesSection()))) {
				res.add((IssueMeetingSection) meetingSection);
			}
			if (meetingSection instanceof CompositeMeetingSection
				&& ((CompositeMeetingSection) meetingSection).getSubsections() != null) {
				CompositeMeetingSection compositeSection = (CompositeMeetingSection) meetingSection;
				res.addAll(findOtherIssueMeetingSections(compositeSection.getSubsections(), meeting));
			}
		}
		return res;
	}

	// find WorkItemMeetingSections other than the one linked as
	// identifiedWorkItemsMeetingSection
	private List<WorkItemMeetingSection> findOtherWorkItemMeetingSections(List<MeetingSection> sections, Meeting meeting) {
		List<WorkItemMeetingSection> res = new ArrayList<WorkItemMeetingSection>();
		for (MeetingSection meetingSection : sections) {
			if (meetingSection instanceof WorkItemMeetingSection
				&& (!meetingSection.equals(meeting.getIdentifiedWorkItemsSection()))) {
				res.add((WorkItemMeetingSection) meetingSection);
			}
			if (meetingSection instanceof CompositeMeetingSection
				&& ((CompositeMeetingSection) meetingSection).getSubsections() != null) {
				CompositeMeetingSection compositeSection = (CompositeMeetingSection) meetingSection;
				res.addAll(findOtherWorkItemMeetingSections(compositeSection.getSubsections(), meeting));
			}
		}
		return res;
	}
}