package org.unicase.iterationplanner.assigneerecommendation;

import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;

public class Assignee {

	private OrgUnit assignee;

	public Assignee(OrgUnit assignee) throws Exception {
		if (assignee instanceof User) {
			this.assignee = assignee;
		} else {
			throw new Exception("Assignee must be an instance of User class");
		}

	}

	public OrgUnit getAssignee() {
		return assignee;
	}

}
