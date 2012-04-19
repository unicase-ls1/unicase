/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.view.widgets;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecp.common.util.DialogHandler;
import org.eclipse.emf.ecp.common.utilities.CannotMatchUserInProjectException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.exceptions.NoCurrentUserException;
import org.eclipse.emf.emfstore.client.ui.util.URLHelper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.dashboard.view.DashboardPage;
import org.unicase.ui.dashboard.view.DashboardToolbarAction;
import org.unicase.ui.unicasecommon.common.filter.UserFilter;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * A dashboard widget displaying an overview of all tasks.
 * 
 * @author Shterev
 */
public class DashboardTaskWidget extends AbstractDashboardWidget {

	private static final String WIDGET_ID = "DashboardTaskWidget";

	private ProjectSpace ps;
	private User user;

	private ArrayList<ActionItem> actionItems;

	private ArrayList<BugReport> bugReports;

	private ArrayList<Issue> issues;

	private HashSet<WorkPackage> sprints;

	private Date now;

	/**
	 * Default constructor.
	 */
	public DashboardTaskWidget() {
		super();
		setTitle("Tasks overview");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDashboard(DashboardPage dashboard) {
		super.setDashboard(dashboard);
		this.ps = dashboard.getProjectSpace();
		try {
			user = OrgUnitHelper.getUser(ps);

			actionItems = new ArrayList<ActionItem>();
			bugReports = new ArrayList<BugReport>();
			issues = new ArrayList<Issue>();
			sprints = new HashSet<WorkPackage>();

			now = new Date();

			List<WorkItem> allWI = ps.getProject().getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
				new BasicEList<WorkItem>());

			for (WorkItem wi : allWI) {
				if (applies(wi)) {
					addWorkItem(wi);
					WorkPackage containingWorkpackage = wi.getContainingWorkpackage();
					addWorkPackage(containingWorkpackage);
				}
			}
		} catch (NoCurrentUserException e) {
			return;
		} catch (CannotMatchUserInProjectException e) {
			return;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createToolbar() {
		super.createToolbar();
		Composite toolbar = getToolbar();
		DashboardToolbarAction taskView = new DashboardToolbarAction(toolbar, "table.png", 150);
		taskView.setToolTipText("Open the Task View");
		taskView.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent event) {
				openTaskView();
			}
		});
	}

	private void openTaskView() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		String viewId = "org.unicase.ui.taskview";
		try {
			IViewPart showView = page.showView(viewId);
			Object filterAdapter = showView.getAdapter(UserFilter.class);
			if (filterAdapter != null) {
				Action filterAction = (Action) filterAdapter;
				filterAction.setChecked(true);
				filterAction.run();
			}
		} catch (PartInitException e) {
			DialogHandler.showExceptionDialog(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContentPanel() {
		super.createContentPanel();

		if (user == null) {
			return;
		}

		Composite panel = getContentPanel();

		GridLayoutFactory.fillDefaults().applyTo(panel);

		Link label = new Link(panel, SWT.WRAP);

		StringBuilder string = new StringBuilder();
		string.append("You currently have:\n");
		string.append(getCountLink(actionItems.size(), " open ActionItem"));
		string.append(getCountLink(bugReports.size(), " unresolved BugReport"));
		string.append(getCountLink(issues.size(), " open Issue"));
		label.setText(string.toString());

		label.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openTaskView();
			}
		});

		if (sprints.size() > 0) {
			Label currentSprint = new Label(panel, SWT.WRAP);
			currentSprint.setText("You are participating in:");

			for (WorkPackage sprint : sprints) {
				URLHelper.getModelElementLink(panel, sprint, getDashboard().getProjectSpace(), 15);
			}
		}
	}

	private String getCountLink(int count, String label) {
		StringBuilder string = new StringBuilder();
		string.append(count > 0 ? "<a>" : "");
		string.append(count);
		string.append(count > 0 ? "</a>" : "");
		string.append(label);
		string.append(count == 1 ? "" : "s");
		string.append("\n");
		return string.toString();
	}

	private void addWorkPackage(WorkPackage containingWorkpackage) {
		if (containingWorkpackage != null
			&& (containingWorkpackage.getStartDate() == null || containingWorkpackage.getStartDate().before(now))
			&& (containingWorkpackage.getDueDate() != null && containingWorkpackage.getDueDate().after(now))) {
			sprints.add(containingWorkpackage);
		}
	}

	private void addWorkItem(WorkItem wi) {
		if (TaskPackage.eINSTANCE.getActionItem().isInstance(wi)) {
			actionItems.add((ActionItem) wi);
		} else if (RationalePackage.eINSTANCE.getIssue().isInstance(wi)) {
			issues.add((Issue) wi);
		} else if (BugPackage.eINSTANCE.getBugReport().isInstance(wi)) {
			bugReports.add((BugReport) wi);
		}
	}

	private boolean applies(WorkItem wi) {
		return (((isAssignee(wi) || isGroupAssignee(wi)) && !(isChecked(wi) || isResolved(wi))) || (isReviewer(wi)));
		// TODO AS: Add "to be reviewed" only if checked
	}

	private boolean isGroupAssignee(WorkItem wi) {
		if (wi.getAssignee() != null && OrganizationPackage.eINSTANCE.getGroup().isInstance(wi.getAssignee())) {
			Set<Group> groups = OrgUnitHelper.getAllGroupsOfOrgUnit(user);
			return groups.contains(wi.getAssignee());
		}
		return false;
	}

	private boolean isAssignee(WorkItem wi) {
		return wi.getAssignee() != null && wi.getAssignee().equals(user);
	}

	private boolean isReviewer(WorkItem wi) {
		return wi.getReviewer() != null && wi.getReviewer().equals(user);
	}

	private boolean isResolved(WorkItem wi) {
		return wi.isResolved();
	}

	private boolean isChecked(WorkItem wi) {
		return TaskPackage.eINSTANCE.getCheckable().isInstance(wi) && ((Checkable) wi).isChecked();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getId() {
		return WIDGET_ID;
	}
}
