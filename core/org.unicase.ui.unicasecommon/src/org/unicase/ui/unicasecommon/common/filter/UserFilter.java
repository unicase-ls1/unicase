/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.filter;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * A filter to filter workitems lists to a certain user.
 * 
 * @author helming
 */
public class UserFilter extends ViewerFilter {

	private User user;
	private Set<OrgUnit> team;
	private boolean showTeam;

	/**
	 * default constructor.
	 * 
	 * @param user The user on which workitems should be filtered
	 */
	public UserFilter(User user) {
		setUser(user);
	}

	/**
	 * {@inheritDoc} The filter should only show the following: - Tasks the user created which are *not* assigned yet -
	 * Tasks the user is Assignee - Tasks the user is Reviewer and status "resolved" - Tasks the user is Participant.
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// false = don't show, true = show
		if (isShowTeam()) {
			return filterTeam(element);
		} else {
			return filterUser(element);
		}
	}

	private boolean filterUser(Object element) {
		if (user == null) {
			return true;
		}
		if (element instanceof WorkItem) {
			// if user participates in this work item
			WorkItem workItem = (WorkItem) element;
			if (workItem.getParticipants().contains(user)) {
				return true;
			}

			// or if user is assignee of this work item
			OrgUnit assignee = workItem.getAssignee();
			if (assignee != null && assignee.equals(user)) {
				return true;
			}

			// or if this work item is resolved, and user is its reviewer
			if (workItem.isResolved() && workItem.getReviewer() != null && workItem.getReviewer().equals(user)) {
				return true;
			}

			if (user.getName().equals(workItem.getCreator()) && workItem.getAssignee() == null) {
				return true;
			}

		} else if (element instanceof UnicaseModelElement) {
			String creator = ((UnicaseModelElement) element).getCreator();
			if (user.getName().equals(creator)) {
				return true;
			}
		}

		return false;
	}

	private boolean filterTeam(Object element) {
		if (element instanceof WorkItem) {
			// if team contains any participants of this work item, then show the work item
			WorkItem workItem = (WorkItem) element;
			EList<OrgUnit> participants = workItem.getParticipants();
			for (OrgUnit orgUnit : participants) {
				if (team.contains(orgUnit)) {
					return true;
				}
			}

			// if team contains assignee of this work item then show the work item
			OrgUnit assignee = workItem.getAssignee();
			if (assignee != null) {
				return (team.contains(assignee));
			}

			// if work item is resolved and its reviewer is member of this team then show it
			if (workItem.isResolved() && team.contains(workItem.getReviewer())) {
				return true;
			}

			if (workItem.getAssignee() == null) {
				for (OrgUnit orgUnit : team) {
					if (orgUnit.getName().equals(workItem.getCreator())) {
						return true;
					}
				}
			}

		} else if (element instanceof UnicaseModelElement) {
			String creator = ((UnicaseModelElement) element).getCreator();
			for (OrgUnit orgUnit : team) {
				if (orgUnit.getName().equals(creator)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
		team = OrgUnitHelper.getTeam(user);
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param showTeam whether to show teams artifacts
	 */
	public void setShowTeam(boolean showTeam) {
		this.showTeam = showTeam;
	}

	/**
	 * @return true if teams artifacts are shown
	 */
	public boolean isShowTeam() {
		return showTeam;
	}

}
