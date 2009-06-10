/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.core;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.TaskFactory;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Iteration planner.
 * 
 * @author hodaie
 */
public class IterationPlanner {

	// input
	private List<WorkPackage> workPackages;
	private List<FunctionalRequirement> requirements;
	private List<User> assignees;
	private Map<User, Integer> assigneeAvailabilities;

	private WorkPackage lastSprint;

	// sprint attributes
	private WorkPackage sprint;

	/**
	 * @param requirements the requirements to set
	 */
	public void setRequirements(List<FunctionalRequirement> requirements) {
		this.requirements = requirements;
	}

	/**
	 * @return set of functional requirements to be implemented in sprints.
	 */
	public List<FunctionalRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new ArrayList<FunctionalRequirement>();
		}
		return requirements;
	}

	/**
	 * @param workPackages the workPackages to set
	 */
	public void setWorkPackages(List<WorkPackage> workPackages) {
		this.workPackages = workPackages;
	}

	/**
	 * @return the workPackages
	 */
	public List<WorkPackage> getWorkPackages() {
		if (workPackages == null) {
			workPackages = new ArrayList<WorkPackage>();
		}
		return workPackages;
	}

	/**
	 * Sets the last sprint.
	 * 
	 * @param wp last sprint
	 */
	public void setLastSprint(WorkPackage wp) {
		if (lastSprint != null) {
			workPackages.remove(lastSprint);
		}
		workPackages.add(wp);
		lastSprint = wp;

	}

	/**
	 * @return last sprint
	 */
	public WorkPackage getLastSprint() {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {

				if (lastSprint.getEndDate() == null) {
					// now
					lastSprint.setEndDate(Calendar.getInstance().getTime());

				}
				if (lastSprint.getStartDate() == null) {
					// minus 14 days (two weeks)
					lastSprint
						.setStartDate(new Date(lastSprint.getEndDate().getTime() - 14L * 24L * 60L * 60L * 1000L));
				}
			}

		});

		return lastSprint;
	}

	/**
	 * @return the sprint
	 */
	public WorkPackage getSprint() {
		if (sprint == null) {
			sprint = TaskFactory.eINSTANCE.createWorkPackage();
		}
		return sprint;
	}

	/**
	 * @param assignees the assignees to set
	 */
	public void setAssignees(List<User> assignees) {
		this.assignees = assignees;
	}

	/**
	 * @return the assignees
	 */
	public List<User> getAssignees() {
		return assignees;
	}

	/**
	 * returns availability of this assignee.
	 * 
	 * @param assignee assignee
	 * @return availability
	 */
	public int getAvailability(User assignee) {
		if (assigneeAvailabilities == null) {
			initAssigneeAvailabilities();
		}

		if (assigneeAvailabilities.containsKey(assignee)) {
			return assigneeAvailabilities.get(assignee).intValue();
		} else {
			return 0;
		}
	}

	/**
	 * @return initial assignees
	 */
	public Set<User> getInitialAssignees() {
		if (assigneeAvailabilities == null) {
			initAssigneeAvailabilities();
		}
		return assigneeAvailabilities.keySet();
	}

	/**
	 * 
	 */
	private void initAssigneeAvailabilities() {
		assigneeAvailabilities = new HashMap<User, Integer>();
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
