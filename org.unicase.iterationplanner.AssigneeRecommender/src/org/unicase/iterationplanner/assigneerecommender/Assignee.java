package org.unicase.iterationplanner.assigneerecommender;

import org.unicase.iterationplanner.assigneerecommendation.Assignee;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;

public class Assignee {

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

//	public OrgUnit getOrgUnit() {
//		return orgUnit;
//	}

	@Override
	public String toString() {
		return orgUnit.getName();
	}

}
