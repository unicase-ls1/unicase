package org.unicase.ui.iterationplanner.assigneerecommendation;

import java.util.List;

public class AssigneePool {

	private static AssigneePool instance;
	private List<Assignee> assignees;

	public static AssigneePool getInstance() {
		if (instance == null) {
			instance = new AssigneePool();
		}
		return instance;
	}

	private AssigneePool() {
		initAssigneePool();
	}

	private void initAssigneePool() {

	}

	public List<Assignee> getAssignees() {
		return assignees;
	}

}
