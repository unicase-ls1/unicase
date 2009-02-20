/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.ProjectSpace;

/**
 * A dashboard widget displaying an overview of all tasks.
 * 
 * @author Shterev
 */
public class DashboardTaskWidget extends AbstractDashboardWidget {

	private ProjectSpace ps;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 * @param ps the project space
	 */
	public DashboardTaskWidget(Composite parent, int style, ProjectSpace ps) {
		super(parent, style);
		this.ps = ps;
		setTitle("Tasks overview");
		createContent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContent() {
		Composite panel = getPanel();
		GridLayoutFactory.fillDefaults().applyTo(panel);
		List<WorkItem> allWI = ps.getProject().getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<WorkItem>());

		List<WorkItem> myWI = new ArrayList<WorkItem>();
		for (WorkItem wi : allWI) {
			if (wi.getAssignee() != null
				&& !wi.getAssignee().getName().equals(ps.getUsersession().getACUser().getName())) {
				myWI.add(wi);
			}
		}
		int ais = 2;
		int brs = 20;
		int is = 99;
		for (WorkItem wi : myWI) {
			if (TaskPackage.eINSTANCE.getCheckable().isInstance(wi) && ((Checkable) wi).isChecked()) {
				continue;
			}
			if (TaskPackage.eINSTANCE.getActionItem().isInstance(wi)) {
				ais++;
			} else if (RationalePackage.eINSTANCE.getIssue().isInstance(wi)) {
				is++;
			} else if (BugPackage.eINSTANCE.getBugReport().isInstance(wi)) {
				brs++;
			}
		}
		StyledText label = new StyledText(panel, SWT.WRAP | SWT.MULTI);
		StringBuilder string = new StringBuilder();
		String string1 = "You currently have:\n";
		string.append(string1);
		String string2 = "" + ais + "";
		string.append(string2);
		String string3 = " open ActionItems\n";
		string.append(string3);
		String string4 = "" + brs + "";
		string.append(string4);
		String string5 = " unresolved BugReports\n";
		string.append(string5);
		String string6 = "" + is + "";
		string.append(string6);
		String string7 = " open Issues";
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

	}
}
