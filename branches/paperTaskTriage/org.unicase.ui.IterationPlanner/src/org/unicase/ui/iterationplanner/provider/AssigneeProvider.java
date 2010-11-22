/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author hodaie
 */
public class AssigneeProvider {

	private Map<OrgUnit, Integer> assigneeAvailabilities;
	private Map<OrgUnit, Integer> initialAssigneeAvailabilities;
	private WorkPackage lastSprint;
	private IterationPlannerManager planningManager;
	private AssigneePredictionStrategy assigneePredictionStrategy;

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param lastSprint last sprint
	 */
	public AssigneeProvider(IterationPlannerManager iterationPlannerManager,
		AssigneePredictionStrategy findAssigneeStrategy, WorkPackage lastSprint) {
		this.lastSprint = lastSprint;
		this.planningManager = iterationPlannerManager;
		this.assigneePredictionStrategy = findAssigneeStrategy;
		initAssigneeAvailabilities();
	}

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param findAssigneeStrategy findAssigneeStrategy (imperative or machine learning)
	 */
	public AssigneeProvider(IterationPlannerManager iterationPlannerManager,
		AssigneePredictionStrategy findAssigneeStrategy) {
		this.planningManager = iterationPlannerManager;
		this.assigneePredictionStrategy = findAssigneeStrategy;
	}

	/**
	 * @param assignee assignee
	 */
	public void addAssignee(OrgUnit assignee) {
		if (assigneeAvailabilities == null) {
			assigneeAvailabilities = new HashMap<OrgUnit, Integer>();
		}
		assigneeAvailabilities.put(assignee, 0);
	}

	/**
	 * @param asssignee assignee
	 */
	public void removeAssignee(OrgUnit asssignee) {
		if (assigneeAvailabilities != null) {
			assigneeAvailabilities.remove(asssignee);

		}
	}

	/**
	 * @return assignees
	 */
	public Set<OrgUnit> getAssignees() {
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
	public int getAvailability(OrgUnit assignee) {
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
	public void setAvailability(OrgUnit assignee, int value) {
		if (assigneeAvailabilities != null) {
			assigneeAvailabilities.put(assignee, new Integer(value));
		}

	}

	/**
	 * 
	 */
	public void initAssigneeAvailabilities() {
		assigneeAvailabilities = new HashMap<OrgUnit, Integer>();
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

		initialAssigneeAvailabilities = new HashMap<OrgUnit, Integer>();
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
	 * @param list initial assignees
	 */
	public void setAssignees(List<OrgUnit> list) {
		for (OrgUnit assignee : list) {
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
	public double getExpertise(WorkItem task, OrgUnit assignee) {

		int expertise = 0;

		List<WorkItem> relatedWorkItems = planningManager.getTaskProvider().getRelatedWorkItems(task);

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
		for (OrgUnit assignee : getAssignees()) {
			result.put(assignee, getExpertise(task, assignee));
		}
		return result;
	}

	public OrgUnit getAppropriateAssignee(WorkItem task) {
		// return assigneePredictionStrategy.predictAssignee(task);
		ExpertiseMap expertiseMap = getExpertiseMap(task);
		List<Entry<OrgUnit, Double>> sortedExpertiseMap = expertiseMap.sortByExpertise();

		return sortedExpertiseMap.get(0).getKey();

	}

	/**
	 * @param fr
	 * @return
	 */
	public ExpertiseMap getExpertiseMap(FunctionalRequirement fr) {
		ExpertiseMap result = new ExpertiseMap();
		for (OrgUnit assignee : getAssignees()) {
			result.put(assignee, getExpertise(fr, assignee));
		}
		return result;
	}

	/**
	 * @param fr
	 * @param assignee
	 * @return
	 */
	private double getExpertise(FunctionalRequirement fr, OrgUnit assignee) {
		int expertise = 0;
		List<WorkItem> relatedWorkItems = planningManager.getTaskProvider().getRelatedWorkItems(fr);
		// count number of related tasks assigned to this user
		for (WorkItem relatedWorkItem : relatedWorkItems) {
			if (relatedWorkItem.getAssignee() != null && relatedWorkItem.getAssignee().equals(assignee)) {
				expertise += 1;
			}
		}

		return expertise;
	}
}
