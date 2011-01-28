/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.wizards.wizardpages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
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
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingSection;
import org.unicase.model.meeting.WorkItemMeetingSection;
import org.unicase.ui.unicasecommon.common.wizards.WorkPackageReviewWizard;

/**
 * Wizardpage for selecting the WorkItemSection.
 * 
 * @author naughton
 */
public class WorkItemSectionSelectionPage extends WizardPage {
	private static final String PAGE_TITLE = "Section selection";
	private static final String PAGE_DESCRIPTION = "Select the section the items get put into.";
	private WorkItemMeetingSection selectedSection;

	/**
	 * Constructor.
	 * 
	 * @param pageName the page name
	 */
	public WorkItemSectionSelectionPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
	}

	/**
	 * @return the selectedSection
	 */
	public WorkItemMeetingSection getSelectedSection() {
		return selectedSection;
	}

	/**
	 * @param parent the parent.
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);

		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);
		Table checkTable = new Table(composite, SWT.SINGLE | SWT.BORDER);
		checkTable.setLayoutData(new GridData(GridData.FILL_BOTH));

		populateTable(checkTable);

		checkTable.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				selectedSection = (WorkItemMeetingSection) event.item.getData();
			}
		});

		setControl(composite);
	}

	private void populateTable(Table table) {
		// Turn off drawing to avoid flicker
		table.setRedraw(false);

		WorkPackageReviewWizard wizard = (WorkPackageReviewWizard) getWizard();
		Meeting meeting = wizard.getMeeting();

		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		// jc: open
		List<WorkItemMeetingSection> workItemMeetingSections = getAllWorkItemMeetingSections(meeting);

		for (WorkItemMeetingSection workItemMeetingSection : workItemMeetingSections) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(workItemMeetingSection);
			item.setImage(labelProvider.getImage(workItemMeetingSection));
			item.setText(workItemMeetingSection.getName());
		}
		if (!workItemMeetingSections.isEmpty()) {
			table.select(0);
			selectedSection = (WorkItemMeetingSection) table.getSelection()[0].getData();
		}

		// Turn drawing back on!
		table.setRedraw(true);
	}

	private List<WorkItemMeetingSection> getAllWorkItemMeetingSections(Meeting meeting) {
		EList<MeetingSection> sections = meeting.getSections();
		return getAllWorkItemMeetingSections(sections);
	}

	private List<WorkItemMeetingSection> getAllWorkItemMeetingSections(EList<MeetingSection> sections) {
		List<WorkItemMeetingSection> list = new ArrayList<WorkItemMeetingSection>();
		for (MeetingSection section : sections) {
			if (section instanceof WorkItemMeetingSection) {
				list.add((WorkItemMeetingSection) section);
			} else if (section instanceof CompositeMeetingSection) {
				list.addAll(getAllWorkItemMeetingSections(((CompositeMeetingSection) section).getSubsections()));
			}
		}
		return list;
	}
}
