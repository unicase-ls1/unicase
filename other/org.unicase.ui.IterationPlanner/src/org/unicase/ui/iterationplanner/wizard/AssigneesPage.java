/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.wizard;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.ui.iterationplanner.core.IterationPlanner;
import org.unicase.workspace.WorkspaceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hodaie
 */
public class AssigneesPage extends WizardPage {

	private IterationPlanner iterationPlanner;
	private CheckboxTableViewer tableViewer;

	/**
	 * Constructor.
	 * 
	 * @param planner iteration planner
	 */
	AssigneesPage(IterationPlanner planner) {
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
		contents.setLayout(new GridLayout());

		Label lblAssignees = new Label(contents, SWT.NONE);
		lblAssignees.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblAssignees
			.setText("Select assignees who participate in this sprint. You can also set the availability of an assignee:");

		Label label = new Label(contents, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));

		Table table = new Table(contents, SWT.CHECK | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setHeaderVisible(true);

		TableColumn assigneeColumn = new TableColumn(table, SWT.NONE);
		assigneeColumn.setText("Assignee");
		assigneeColumn.setWidth(300);

		tableViewer = new CheckboxTableViewer(table);

		tableViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getChecked()) {
					// add assignee
				} else {
					// remove assignee

				}
				AssigneesPage.this.getWizard().getContainer().updateButtons();
			}
		});

		TableViewerColumn clmAssignee = new TableViewerColumn(tableViewer, assigneeColumn);
		clmAssignee.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof User) {
					return ((User) element).getName();
				}
				return super.getText(element);
			}

		});

		TableViewerColumn clmAvailability = new TableViewerColumn(tableViewer, SWT.NONE);
		clmAvailability.getColumn().setText("Availability");
		clmAvailability.getColumn().setWidth(100);
		ColumnLabelProvider availabilityLabelProvider = new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (element instanceof User) {
					return iterationPlanner.getAvailability((User) element) + "";
				}
				return super.getText(element);
			}

		};
		clmAvailability.setLabelProvider(availabilityLabelProvider);
		clmAvailability.setEditingSupport(null);

		tableViewer.setContentProvider(new IStructuredContentProvider() {

			@SuppressWarnings("unchecked")
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof List) {
					return ((List) inputElement).toArray();
				}
				return new Object[0];
			}

			public void dispose() {}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		});
		tableViewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject()
			.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(), new BasicEList<User>()));

		tableViewer.setCheckedElements(iterationPlanner.getInitialAssignees().toArray());

		setControl(contents);
		setPageComplete(true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		List<User> assignees = new ArrayList<User>();
		for (Object obj : tableViewer.getCheckedElements()) {
			assignees.add((User) obj);
		}
		iterationPlanner.setAssignees(assignees);
		return super.getNextPage();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		return tableViewer.getCheckedElements().length > 0;
	}

}
