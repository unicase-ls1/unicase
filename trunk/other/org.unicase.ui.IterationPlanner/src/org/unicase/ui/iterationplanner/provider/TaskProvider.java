/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;

/**
 * This class is responsible for holding tasks to be planned, computing tasks
 * related to a task (using RelatedTasksStrategy), creating a list of assignee
 * expertise regarding a task.
 * 
 * @author Hodaie
 */
public class TaskProvider {

	private List<WorkPackage> workpackages;
	private WorkPackage lastSprint;
	private RelatedTasksSterategy relatedTasksSterategy;
	private IterationPlannerManager planningManager;

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager
	 *            iteration planning manager
	 * 
	 * @param lastSprint
	 *            last sprint
	 * @param workpackages
	 *            work packages
	 */
	public TaskProvider(IterationPlannerManager iterationPlannerManager,
			WorkPackage lastSprint, List<WorkPackage> workpackages) {
		this.planningManager = iterationPlannerManager;
		this.lastSprint = lastSprint;
		this.workpackages = workpackages;

		relatedTasksSterategy = new ImperativeRelatedTasks();
	}

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager
	 *            iteration planning manager
	 * 
	 * @param iterationPlannerManager
	 */
	public TaskProvider(IterationPlannerManager iterationPlannerManager) {
		this.planningManager = iterationPlannerManager;
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
					lastSprint.setStartDate(new Date(lastSprint.getEndDate()
							.getTime()
							- 14L * 24L * 60L * 60L * 1000L));
				}
			}

		});

		return lastSprint;
	}

	/**
	 * @return the workPackages
	 */
	public List<WorkPackage> getWorkPackages() {
		if (workpackages == null) {
			workpackages = new ArrayList<WorkPackage>();
		}
		return workpackages;
	}

	/**
	 * sort tasks by priority.
	 * 
	 * @param tasks
	 *            tasks
	 * @return sorted task list
	 */
	public List<WorkItem> sortByPriority(List<WorkItem> tasks) {
		return null;
	}

	/**
	 * extract list of work items form FRs.
	 * 
	 * @param frs
	 *            a list of functional requirements
	 * @return a list of work items relating to these FRs.
	 */
	public List<WorkItem> getWorkItems(List<FunctionalRequirement> frs) {
		return null;
	}

	/**
	 * find an appropriate assignee for this task based on some criteria.
	 * 
	 * @param workItem
	 *            task
	 * @return appropriate assignee for this task.
	 */
	public User findAppropriateAssignee(WorkItem workItem) {

		return null;
	}

	/**
	 * Finds expertise of a user regarding a task. Expertise is number of
	 * related tasks which have this user as assignee.
	 * 
	 * @param assignee
	 *            assignee
	 * @param task
	 *            task
	 * @return int
	 */
	public double getExpertise(WorkItem task, User assignee) {

		int expertise = 0;

		List<WorkItem> relatedWorkItems = relatedTasksSterategy
				.getRelatedTasks(task);

		// count number of related tasks assigned to this user
		for (WorkItem wi : relatedWorkItems) {
			if (wi.getAssignee().equals(assignee)) {
				expertise += 1;
			}
		}

		return expertise;
	}
	
	/**
	 * returns a expertise for each assignee relating this task.
	 * @param task task
	 * @return a map of assignee to expertise relating this task
	 */
	public Map<User, Double> getExpertiseMap(WorkItem task){
		Map<User, Double> result = new HashMap<User, Double>();
		for(User assignee : planningManager.getAssigneeProvider().getAssignees()){
			result.put(assignee, getExpertise(task, assignee));
		}
		return result;
	}

	/**
	 * 
	 * @param lastSprint
	 *            last sprint
	 */
	public void setLastSprint(WorkPackage lastSprint) {
		this.lastSprint = lastSprint;
	}

	/**
	 * strategy to compute related tasks.
	 * 
	 * @param relatedTasksSterategy
	 *            relatedTasksSterategy
	 */
	public void setRelatedTasksSterategy(
			RelatedTasksSterategy relatedTasksSterategy) {
		this.relatedTasksSterategy = relatedTasksSterategy;
	}

	/**
	 * returns strategy to compute related tasks.
	 * 
	 * @return strategy to compute related tasks
	 */
	public RelatedTasksSterategy getRelatedTasksSterategy() {
		return relatedTasksSterategy;
	}

}
