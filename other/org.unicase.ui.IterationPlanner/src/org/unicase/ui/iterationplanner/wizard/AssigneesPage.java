/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author Hodaie
 */
public class AssigneesPage extends WizardPage {

	private IterationPlannerManager iterationPlanner;
	private CheckboxTableViewer tableViewer;

	/**
	 * Constructor.
	 * 
	 * @param org.unicase.ui.iterationplanner.planner
	 *            iteration org.unicase.ui.iterationplanner.planner
	 */
	AssigneesPage(IterationPlannerManager planner) {
		super("assignees page");
		this.iterationPlanner = planner;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayout(new GridLayout(3, false));

		// labels
		Label lblAssignees = new Label(contents, SWT.NONE);
		lblAssignees.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false, 3, 1));
		lblAssignees
				.setText("Select assignees who participate in this sprint. You can also set the availability of an assignee:");

		Label label = new Label(contents, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false, 3, 1));

		// table viewer
		createTeableViewer(contents);

		// select all/none buttons
		Button btnSelectAll = new Button(contents, SWT.PUSH);
		btnSelectAll.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false));
		btnSelectAll.setText("Select all");
		btnSelectAll.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				List<User> selectedAssignees = new ArrayList<User>();
				for (Object obj : tableViewer.getCheckedElements()) {
					selectedAssignees.add((User) obj);
				}
				tableViewer.setAllChecked(true);
				List<User> allAssignees = new ArrayList<User>();
				for (Object obj : tableViewer.getCheckedElements()) {
					allAssignees.add((User) obj);
				}
				allAssignees.removeAll(selectedAssignees);
				for (User assignee : allAssignees) {
					iterationPlanner.getAssigneeProvider().addAssignee(assignee);
				}
				AssigneesPage.this.getWizard().getContainer().updateButtons();
			}
		});

		Button btnSelectNone = new Button(contents, SWT.PUSH);
		btnSelectNone.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false));
		btnSelectNone.setText("Select none");
		btnSelectNone.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				for (Object obj : tableViewer.getCheckedElements()) {
					iterationPlanner.getAssigneeProvider().removeAssignee((User) obj);
				}
				tableViewer.setAllChecked(false);
				AssigneesPage.this.getWizard().getContainer().updateButtons();

			}

		});

		Button btnReset = new Button(contents, SWT.PUSH);
		btnReset.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		btnReset.setText("Reset to initial assignees");
		btnReset.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				iterationPlanner.getAssigneeProvider().resetToInitialAssignees();
				AssigneesPage.this.getWizard().getContainer().updateButtons();
			}

		});

		setControl(contents);
	}

	/**
	 * @param contents
	 */
	private void createTeableViewer(Composite contents) {
		Table table = new Table(contents, SWT.CHECK | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		table.setHeaderVisible(true);

		TableColumn assigneeColumn = new TableColumn(table, SWT.NONE);
		assigneeColumn.setText("Assignee");
		assigneeColumn.setWidth(300);

		tableViewer = new CheckboxTableViewer(table);

		tableViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					iterationPlanner.getAssigneeProvider().addAssignee((User) event.getElement());
				} else {
					iterationPlanner.getAssigneeProvider().removeAssignee((User) event.getElement());

				}
				AssigneesPage.this.getWizard().getContainer().updateButtons();
			}
		});

		TableViewerColumn clmAssignee = new TableViewerColumn(tableViewer,
				assigneeColumn);
		clmAssignee.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof User) {
					return ((User) element).getName();
				}
				return super.getText(element);
			}

		});

		TableViewerColumn clmAvailability = new TableViewerColumn(tableViewer,
				SWT.NONE);
		clmAvailability.getColumn().setText("Availability");
		clmAvailability.getColumn().setWidth(100);
		ColumnLabelProvider availabilityLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof User) {
					return iterationPlanner.getAssigneeProvider().getAvailability((User) element)
							+ "";
				}
				return super.getText(element);
			}

		};
		clmAvailability.setLabelProvider(availabilityLabelProvider);
		clmAvailability.setEditingSupport(new AvailabilityEditingSupport(
				tableViewer, iterationPlanner));

		tableViewer.setContentProvider(new IStructuredContentProvider() {

			@SuppressWarnings("unchecked")
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List) {
					return ((List) inputElement).toArray();
				}
				return new Object[0];
			}

			public void dispose() {
			}

			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

		});
		tableViewer.setInput(WorkspaceManager.getInstance()
				.getCurrentWorkspace().getActiveProjectSpace().getProject()
				.getAllModelElementsbyClass(
						OrganizationPackage.eINSTANCE.getUser(),
						new BasicEList<User>()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		tableViewer.setCheckedElements(iterationPlanner.getAssigneeProvider().getAssignees()
				.toArray());
		tableViewer.refresh();
		return tableViewer.getCheckedElements().length > 0;
	}

}
