/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.filter;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * This filter filters to the elements of a users team.
 * 
 * @author helming
 * 
 */
public class TeamFilter extends ViewerFilter {

	private Set<OrgUnit> team;

	/**
	 * default constructor.
	 * 
	 * @param user
	 *            The user to whos team it should be filtered.
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
			EList<OrgUnit> participants = ((WorkItem) element)
					.getParticipants();
			for (OrgUnit orgUnit : participants) {
				if (team.contains(orgUnit)) {
					return true;
				}
			}

			OrgUnit assignee = ((WorkItem) element).getAssignee();
			if (assignee != null) {
				return (team.contains(assignee));
			}

			return false;
		}
		if (element instanceof ModelElement) {
			String creator = ((ModelElement) element).getCreator();
			for (OrgUnit orgUnit : team) {
				if (orgUnit.getName().equals(creator)) {
					return true;
				}
			}
		}
		return false;
	}

}
