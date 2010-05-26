/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.filter;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.common.util.OrgUnitHelper;

/**
 * This filter filters to the elements of a users team.
 * 
 * @author helming
 */
public class TeamFilter extends ViewerFilter {

	private User user;
	private Set<OrgUnit> team;

	/**
	 * default constructor.
	 * 
	 * @param user The user to whose team it should be filtered.
	 */
	public TeamFilter(User user) {
		team = OrgUnitHelper.getTeam(user);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
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

			// TODO: getCreator method
			// if (workItem.getAssignee() == null) {
			// for (OrgUnit orgUnit : team) {
			// if (orgUnit.getName().equals(workItem.getCreator())) {
			// return true;
			// }
			// }
			// }

		}

		/*
		 * else if (element instanceof EObject) { String creator = ((EObject) element).getCreator(); for (OrgUnit
		 * orgUnit : team) { if (orgUnit.getName().equals(creator)) { return true; } } }
		 */

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

}
