/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.sprintstatus;

import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;

/**
 * Filter the work items to a specific user.
 * 
 * @author Shterev
 */
public class SprintUserFilter implements SprintFilter {

	private OrgUnit user;

	/**
	 * Default constructor.
	 */
	public SprintUserFilter() {
	}

	/**
	 * Constructor with a user.
	 * 
	 * @param user the user.
	 */
	public SprintUserFilter(OrgUnit user) {
		this.user = user;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean accept(WorkItem workItem) {
		if (user == null) {
			return true;
		}
		OrgUnit assignee = workItem.getAssignee();
		User reviewer = workItem.getReviewer();
		boolean ret = false;
		if (assignee != null) {
			if (OrganizationPackage.eINSTANCE.getGroup().isInstance(assignee)) {
				ret = ret || ((Group) assignee).getOrgUnits().contains(user);
			}
			ret = ret || assignee.equals(user);
		}
		if (reviewer != null) {
			ret = ret || reviewer.equals(user);
		}
		ret = ret || workItem.getParticipants().contains(user);
		return ret;
	}

	/**
	 * Sets a new user for this filter.
	 * 
	 * @param user the new user.
	 */
	public void setUser(OrgUnit user) {
		this.user = user;
	}
}
