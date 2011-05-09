/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.wizards.wizardpages;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IDisposable;
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
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.wizards.WorkPackageReviewWizard;

/**
 * Wizardpage for selecting WorkItems.
 * 
 * @author naughton
 */
public class WorkItemSelectionPage extends WizardPage {
	private static final String PAGE_TITLE = "Items to be reviewed";
	private static final String PAGE_DESCRIPTION = "Select items to be reviewed in this meeting.";
	private EList<WorkItem> selectedWorkItems;

	/**
	 * Constructor.
	 * 
	 * @param pageName the page name
	 */
	public WorkItemSelectionPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		selectedWorkItems = new BasicEList<WorkItem>();
	}

	/**
	 * @return the selectedWorkItems
	 */
	public EList<WorkItem> getSelectedWorkItems() {
		return selectedWorkItems;
	}

	/**
	 * @param parent the parent.
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
						selectedWorkItems.add((WorkItem) event.item.getData());
					} else {
						WorkItem workItem = (WorkItem) event.item.getData();
						if (selectedWorkItems.contains(workItem)) {
							selectedWorkItems.remove(workItem);
						}
					}
				}
			}
		});

		setControl(composite);
	}

	private void populateTable(Table table) {
		// Turn off drawing to avoid flicker
		table.setRedraw(false);

		WorkPackageReviewWizard wizard = (WorkPackageReviewWizard) getWizard();
		EList<WorkItem> workItems = wizard.getWorkItems();

		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		for (WorkItem workItem : workItems) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setData(workItem);
			item.setImage(labelProvider.getImage(workItem));
			item.setText(workItem.getName());
			item.setChecked(!getStatus(workItem));
			selectedWorkItems.add(workItem);
		}

		// Turn drawing back on!
		table.setRedraw(true);

		labelProvider.dispose();
		if (labelProvider.getAdapterFactory() instanceof IDisposable) {
			((IDisposable) labelProvider.getAdapterFactory()).dispose();

		}

	}

	private boolean getStatus(WorkItem workItem) {
		if (workItem instanceof Checkable) {
			return ((Checkable) workItem).isChecked();
		}
		return true;
	}
}
