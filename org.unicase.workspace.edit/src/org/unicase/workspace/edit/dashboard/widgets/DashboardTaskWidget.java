/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
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
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.URLHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.edit.dashboard.DashboardPage;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * A dashboard widget displaying an overview of all tasks.
 * 
 * @author Shterev
 */
public class DashboardTaskWidget extends AbstractDashboardWidget {

	private static final String WIDGET_ID = "DashboardTaskWidget";

	private ProjectSpace ps;
	private User user;

	/**
	 * Default constructor.
	 * 
	 * @param dashboard the dashboard
	 */
	public DashboardTaskWidget(DashboardPage dashboard) {
		super(dashboard);
		this.ps = dashboard.getProjectSpace();
		setTitle("Tasks overview");
		try {
			user = OrgUnitHelper.getUser(ps);
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
		DashboardWidgetAction taskView = new DashboardWidgetAction(toolbar, "table.png", 150);
		taskView.setToolTipText("Open the Task View");
		taskView.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent event) {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				String viewId = "org.unicase.ui.taskview";
				try {
					page.showView(viewId);
				} catch (PartInitException e) {
					DialogHandler.showExceptionDialog(e);
				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContentPanel() {
		super.createContentPanel();
		Composite panel = getContentPanel();

		GridLayoutFactory.fillDefaults().applyTo(panel);
		List<WorkItem> allWI = ps.getProject().getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<WorkItem>());

		ArrayList<ActionItem> ais = new ArrayList<ActionItem>();
		ArrayList<BugReport> brs = new ArrayList<BugReport>();
		ArrayList<Issue> is = new ArrayList<Issue>();
		HashSet<WorkPackage> sprints = new HashSet<WorkPackage>();

		Date now = new Date();

		for (WorkItem wi : allWI) {
			if (applies(wi)) {
				if (TaskPackage.eINSTANCE.getActionItem().isInstance(wi)) {
					ais.add((ActionItem) wi);
				} else if (RationalePackage.eINSTANCE.getIssue().isInstance(wi)) {
					is.add((Issue) wi);
				} else if (BugPackage.eINSTANCE.getBugReport().isInstance(wi)) {
					brs.add((BugReport) wi);
				}

				WorkPackage containingWorkpackage = wi.getContainingWorkpackage();
				if (containingWorkpackage != null
					&& (containingWorkpackage.getStartDate() == null || containingWorkpackage.getStartDate()
						.before(now))
					&& (containingWorkpackage.getDueDate() != null && containingWorkpackage.getDueDate().after(now))) {
					sprints.add(containingWorkpackage);
				}
			}
		}
		sprints.remove(null);

		StyledText label = new StyledText(panel, SWT.WRAP | SWT.MULTI);
		StringBuilder string = new StringBuilder();
		String string1 = "You currently have:\n";
		string.append(string1);
		final int aiSize = ais.size();
		String string2 = "" + aiSize + "";
		string.append(string2);
		String string3 = " open ActionItem" + (aiSize == 1 ? "" : "s") + "\n";
		string.append(string3);
		final int brSize = brs.size();
		String string4 = "" + brSize + "";
		string.append(string4);
		String string5 = " unresolved BugReport" + (brSize == 1 ? "" : "s") + "\n";
		string.append(string5);
		final int isSize = is.size();
		String string6 = "" + isSize + "";
		string.append(string6);
		String string7 = " open Issue" + (isSize == 1 ? "" : "s") + "";
		string.append(string7);
		label.setText(string.toString());

		StyleRange style = new StyleRange();
		style.start = string1.length();
		style.length = string2.length();
		style.fontStyle = SWT.BOLD;
		label.setStyleRange(style);

		style = new StyleRange();
		style.start = string1.length() + string2.length() + string3.length();
		style.length = string4.length();
		style.fontStyle = SWT.BOLD;
		label.setStyleRange(style);

		style = new StyleRange();
		style.start = string1.length() + string2.length() + string3.length() + string4.length() + string5.length();
		style.length = string6.length();
		style.fontStyle = SWT.BOLD;
		label.setStyleRange(style);

		label.setEnabled(false);

		if (sprints.size() > 0) {
			Label currentSprint = new Label(panel, SWT.WRAP);
			currentSprint.setText("You are participating in:");
			for (WorkPackage sprint : sprints) {
				URLHelper.getModelElementLink(panel, sprint, getDashboard().getProjectSpace(), 15);
			}
		}
	}

	private boolean applies(WorkItem wi) {
		return (isAssignee(wi) || isGroupAssignee(wi)) && !(isChecked(wi) || isResolved(wi));
	}

	private boolean isGroupAssignee(WorkItem wi) {
		return wi.getAssignee() != null
			&& (OrganizationPackage.eINSTANCE.getGroup().isInstance(wi.getAssignee()) && ((Group) wi.getAssignee())
				.getOrgUnits().contains(user));
	}

	private boolean isAssignee(WorkItem wi) {
		return wi.getAssignee() != null && wi.getAssignee().equals(user);
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
