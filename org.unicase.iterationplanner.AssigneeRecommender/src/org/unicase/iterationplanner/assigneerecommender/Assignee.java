package org.unicase.iterationplanner.assigneerecommender;

import org.unicase.iterationplanner.assigneeRecommender.IAssignee;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;

public class Assignee implements IAssignee {

	private OrgUnit orgUnit;

	public Assignee(OrgUnit orgUnit) throws Exception {
		if (orgUnit instanceof User) {
			this.orgUnit = orgUnit;
		} else {
			throw new Exception("Assignee must be an instance of User class");
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Assignee)) {
			return false;
		}

		return ((Assignee) obj).getOrgUnit().equals(this.orgUnit);
	}

	public OrgUnit getOrgUnit() {
		return orgUnit;
	}

	@Override
	public String toString() {
		return orgUnit.getName();
	}

	public String getName() {
		return orgUnit.getName();
	}

}
