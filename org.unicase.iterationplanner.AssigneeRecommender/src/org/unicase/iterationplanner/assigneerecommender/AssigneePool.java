package org.unicase.iterationplanner.assigneerecommender;

import java.util.ArrayList;
import java.util.List;

import org.unicase.iterationplanner.assigneerecommendation.Assignee;
import org.unicase.iterationplanner.assigneerecommendation.AssigneePool;
import org.unicase.model.organization.User;

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
		if (assignees == null) {
			assignees = new ArrayList<Assignee>();
		}
		return assignees;
	}

	public void setAssignees(List<User> users) {
		assignees = new ArrayList<Assignee>();
		for (User user : users) {
			try {
				assignees.add(new Assignee(user));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
