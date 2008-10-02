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

public class TeamFilter extends ViewerFilter {

	private final User user;
	Set<OrgUnit> team;

	public TeamFilter(User user) {
		this.user = user;

		team = OrgUnitHelper.getTeam(user);

	}

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
