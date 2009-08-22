/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hodaie
 */
public class AssigneeProvider {

	private Map<User, Integer> assigneeAvailabilities;
	private Map<User, Integer> initialAssigneeAvailabilities;
	private WorkPackage lastSprint;
	private IterationPlannerManager planningManager;
	private FindAssigneeStrategy findAssigneeStrategy;

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param lastSprint last sprint
	 */
	public AssigneeProvider(IterationPlannerManager iterationPlannerManager, FindAssigneeStrategy findAssigneeStrategy,
		WorkPackage lastSprint) {
		this.lastSprint = lastSprint;
		this.planningManager = iterationPlannerManager;
		this.findAssigneeStrategy = findAssigneeStrategy;
		initAssigneeAvailabilities();
	}

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param iterationPlannerManager
	 */
	public AssigneeProvider(IterationPlannerManager iterationPlannerManager, FindAssigneeStrategy findAssigneeStrategy) {
		this.planningManager = iterationPlannerManager;
		this.findAssigneeStrategy = findAssigneeStrategy;
	}

	/**
	 * @param assignee assignee
	 */
	public void addAssignee(User assignee) {
		if (assigneeAvailabilities == null) {
			assigneeAvailabilities = new HashMap<User, Integer>();
		}
		assigneeAvailabilities.put(assignee, 0);
	}

	/**
	 * @param asssignee assignee
	 */
	public void removeAssignee(User asssignee) {
		if (assigneeAvailabilities != null) {
			assigneeAvailabilities.remove(asssignee);

		}
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
	 * @param assignee assignee
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
	 * @param assignee assignee
	 * @param value value
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

	/**
	 * set the initial assignees.
	 * 
	 * @param assignees initial assignees
	 */
	public void setAssignees(List<User> assignees) {
		for (User assignee : assignees) {
			addAssignee(assignee);
		}
	}

	/**
	 * Finds expertise of a user regarding a task. Expertise is number of related tasks which have this user as
	 * assignee.
	 * 
	 * @param assignee assignee
	 * @param task task
	 * @return int
	 */
	public double getExpertise(WorkItem task, User assignee) {

		int expertise = 0;

		List<WorkItem> relatedWorkItems = planningManager.getTaskProvider().getRelatedTasks(task);

		// count number of related tasks assigned to this user
		for (WorkItem relatedWorkItem : relatedWorkItems) {
			if (relatedWorkItem.getAssignee() != null && relatedWorkItem.getAssignee().equals(assignee)) {
				expertise += 1;
			}
		}

		return expertise;
	}

	/**
	 * returns a expertise for each assignee relating this task.
	 * 
	 * @param task task
	 * @return a map of assignee to expertise relating this task
	 */
	public ExpertiseMap getExpertiseMap(WorkItem task) {
		ExpertiseMap result = new ExpertiseMap();
		for (User assignee : planningManager.getAssigneeProvider().getAssignees()) {
			result.getExpertiseMap().put(assignee, planningManager.getAssigneeProvider().getExpertise(task, assignee));
		}
		return result;
	}

	public User getAppropriateAssignee(WorkItem task) {
		return findAssigneeStrategy.suggestAssignee(task);
	}

}
