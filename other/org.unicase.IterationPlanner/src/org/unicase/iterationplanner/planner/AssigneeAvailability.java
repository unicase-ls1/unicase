package org.unicase.iterationplanner.planner;

import org.unicase.iterationplanner.assigneerecommendation.Assignee;

/**
 * Before planner algorithm can begin, it needs to know how long every developer (assignee) will be available during
 * each iteration. The sets these values before the planning starts.
 * 
 * @author zardosht
 */
public class AssigneeAvailability {

	private final Assignee assignee;
	private int availability;

	public AssigneeAvailability(Assignee assignee, int availability) {
		this.assignee = assignee;
		this.availability = availability;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public Assignee getAssignee() {
		return assignee;
	}

}
