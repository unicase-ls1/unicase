/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import java.util.Comparator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.stem.Activator;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.util.EventUtil;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * A view that displays the status of a given sprint (work package). It is mainly used to plan the sprint and
 * (re-)assign the work items.
 * 
 * @author Shterev
 */
public class SprintStatusView extends ViewPart {

	/**
	 * Compares two work items acc. to the name of their user.
	 * 
	 * @author Shterev
	 */
	private class UserComparator implements Comparator<WorkItem> {

		public int compare(WorkItem o1, WorkItem o2) {
			OrgUnit user1 = o1.getAssignee();
			OrgUnit user2 = o2.getAssignee();
			if (user1 == null && user2 == null) {
				return 0;
			} else if (user1 == null) {
				return -1;
			} else if (user2 == null) {
				return 1;
			}
			return user1.getName().compareTo(user2.getName());

		}
	}

	/**
	 * Compares two work items acc. to their priority.
	 * 
	 * @author Shterev
	 */
	private class PriorityComparator implements Comparator<WorkItem> {

		public int compare(WorkItem o1, WorkItem o2) {
			int prio1 = o1.getPriority();
			int prio2 = o2.getPriority();
			if (prio1 == prio2) {
				return 0;
			} else if (prio1 > prio2) {
				return -1;
			}
			return 1;
		}
	}

	/**
	 * Compares two work items acc. to their names.
	 * 
	 * @author Shterev
	 */
	private class NameComparator implements Comparator<WorkItem> {

		public int compare(WorkItem o1, WorkItem o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

	/**
	 * ID for this view.
	 */
	public static final String ID = "org.unicase.ui.stem.views.sprintstatus.SprintStatusView";

	private ModelElement input;

	private SprintStatusComposite statusComposite;

	/**
	 * Constructor.
	 */
	public SprintStatusView() {
		this.input = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {

		statusComposite = new SprintStatusComposite(parent, SWT.NONE);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(statusComposite);

		statusComposite.addComparator(0, new NameComparator());
		statusComposite.addComparator(0, new PriorityComparator());

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		Action refresh = new Action() {
			@Override
			public void run() {
				setInput(input);
			}
		};
		refresh.setImageDescriptor(Activator.getImageDescriptor("/icons/refresh.png"));
		refresh.setToolTipText("Refresh");
		menuManager.add(refresh);

		try {
			final SprintUserFilter userFilter = new SprintUserFilter(OrgUnitHelper.getCurrentUser(WorkspaceManager
				.getInstance().getCurrentWorkspace()));
			Action filterByUser = new Action("", SWT.TOGGLE) {

				@Override
				public void run() {
					if (isChecked()) {
						statusComposite.addFilter(userFilter);
					} else {
						statusComposite.removeFilter(userFilter);
					}
					setInput(input);
				}
			};
			filterByUser.setChecked(false);

			filterByUser.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertouser.png"));
			filterByUser.setToolTipText("Show only my items");
			menuManager.add(filterByUser);
		} catch (NoCurrentUserException e) {
		} catch (CannotMatchUserInProjectException e) {
		}

		final UserComparator userComparator = new UserComparator();
		Action groupByUser = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				if (isChecked()) {
					statusComposite.addComparator(0, userComparator);
				} else {
					statusComposite.removeComparator(userComparator);
				}
				setInput(input);
			}
		};
		groupByUser.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertomyteam.png"));
		groupByUser.setToolTipText("Group by user");
		groupByUser.setChecked(false);
		menuManager.add(groupByUser);

	}

	/**
	 * Refresh top composite and tabs based on input.
	 */
	public void refreshView() {
		if (input == null) {
			return;
		}

		if (TaskPackage.eINSTANCE.getWorkPackage().isInstance(input) && statusComposite != null) {
			statusComposite.setInput(input);
		}
	}

	/**
	 * Set input to the view. currently input is set using drag and drop on top composite. Later we implement a context
	 * menu command for it too.
	 * 
	 * @param me input model element
	 */
	public void setInput(ModelElement me) {
		ModelElement newInput = me;
		if (newInput == null) {
			newInput = ActionHelper.getSelectedModelElement();
		}
		if (input == null || newInput != null) {
			input = newInput;
		}
		statusComposite.setFocus();
		refreshView();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		EventUtil.logFocusEvent(ID);
		// getViewSite().getPart().setFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		statusComposite.dispose();
		super.dispose();
	}
}
