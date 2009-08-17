/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;

/**
 * 
 * @author hodaie
 *
 */
public class AssigneeProvider {

	private Map<User, Integer> assigneeAvailabilities;
	private Map<User, Integer> initialAssigneeAvailabilities;
	private WorkPackage lastSprint;
	private IterationPlannerManager planningManager;
	
	
	/**
	 * Constructor.
	 * @param iterationPlannerManager iteration planning manager
	 * @param lastSprint last sprint
	 */
	public AssigneeProvider(IterationPlannerManager iterationPlannerManager, WorkPackage lastSprint){
		this.lastSprint = lastSprint;
		this.planningManager = iterationPlannerManager;
		initAssigneeAvailabilities();
	}

	/**
	 * Constructor.
	 *  @param iterationPlannerManager iteration planning manager
	 * @param iterationPlannerManager 
	 */
	public AssigneeProvider(IterationPlannerManager iterationPlannerManager) {
		this.planningManager = iterationPlannerManager;
	}

	/**
	 * @param assignee
	 *            assignee
	 */
	public void addAssignee(User assignee) {
		assigneeAvailabilities.put(assignee, 0);
	}

	/**
	 * @param asssignee
	 *            assignee
	 */
	public void removeAssignee(User asssignee) {
		assigneeAvailabilities.remove(asssignee);
	}

	/**
	 * @return assignees
	 */
	public Set<User> getAssignees() {
		if (assigneeAvailabilities != null) {
			return assigneeAvailabilities.keySet();
		}

		return Collections.emptySet();

	}

	/**
	 * reset to initial assignee availabilities.
	 */
	public void resetToInitialAssignees() {
		assigneeAvailabilities.clear();
		assigneeAvailabilities.putAll(initialAssigneeAvailabilities);
	}

	/**
	 * returns availability of this assignee.
	 * 
	 * @param assignee
	 *            assignee
	 * @return availability
	 */
	public int getAvailability(User assignee) {
		if (assigneeAvailabilities == null) {
			return 0;
		}

		if (assigneeAvailabilities.containsKey(assignee)) {
			return assigneeAvailabilities.get(assignee).intValue();
		} else {
			return 0;
		}
	}

	/**
	 * @param assignee
	 *            assignee
	 * @param value
	 *            value
	 */
	public void setAvailability(User assignee, int value) {
		if (assigneeAvailabilities != null) {
			assigneeAvailabilities.put(assignee, new Integer(value));
		}

	}

	/**
	 * 
	 */
	public void initAssigneeAvailabilities() {
		assigneeAvailabilities = new HashMap<User, Integer>();
		if (lastSprint == null) {
			return;
		}
		for (WorkItem wi : lastSprint.getAllContainedWorkItems()) {
			if (wi.getAssignee() instanceof Group) {
				Group group = (Group) wi.getAssignee();
				List<User> assigness = getAllUsers(group);
				int averageAvailability = wi.getEstimate() / assigness.size();
				for (User assignee : assigness) {
					updateAvailability(assignee, averageAvailability);
				}
			} else {
				User assignee = (User) wi.getAssignee();
				updateAvailability(assignee, wi.getEstimate());
			}

		}

		initialAssigneeAvailabilities = new HashMap<User, Integer>();
		initialAssigneeAvailabilities.putAll(assigneeAvailabilities);
	}

	
	private void updateAvailability(User assignee, int value) {
		int currentAvailability = 0;
		if (assigneeAvailabilities.get(assignee) != null) {
			currentAvailability = assigneeAvailabilities.get(assignee);
		}
		assigneeAvailabilities.put(assignee, currentAvailability + value);
	}

	/**
	 * @param group
	 * @return
	 */
	private List<User> getAllUsers(Group group) {
		List<User> result = new ArrayList<User>();
		for (OrgUnit ou : group.getOrgUnits()) {
			if (ou instanceof User) {
				result.add((User) ou);
			} else {
				result.addAll(getAllUsers((Group) ou));
			}
		}

		return result;
	}
	

}
