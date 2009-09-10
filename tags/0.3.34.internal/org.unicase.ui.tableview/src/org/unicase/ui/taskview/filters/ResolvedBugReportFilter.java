/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.taskview.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

/**
 * This filter prevents showing of resolved bug reports in viewers.
 * 
 * @author Hodaie
 */
public class ResolvedBugReportFilter extends ViewerFilter {

	private User user;

	/**
	 * Constructor.
	 * 
	 * @param user the user, whose resolved work items must be filtered.
	 */
	public ResolvedBugReportFilter(User user) {
		this.user = user;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object,
	 *      java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		// false = don't show; true = show

		if (element instanceof WorkItem) {
			WorkItem workItem = (WorkItem) element;

			if (isCurrentUserAssigneeOrCreator(workItem)) {
				return !workItem.isResolved();
			}

		}

		return true;
	}

	/**
	 * @param workItem
	 * @return
	 */
	private boolean isCurrentUserAssigneeOrCreator(WorkItem workItem) {
		if (user == null) {
			return false;
		}
		OrgUnit assignee = workItem.getAssignee();
		String creator = workItem.getCreator();
		return user.equals(assignee) || (assignee == null && user.getName().equals(creator));
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

}
