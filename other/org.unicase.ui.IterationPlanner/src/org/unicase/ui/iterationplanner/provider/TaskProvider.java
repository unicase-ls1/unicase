/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hodaie
 */
public class TaskProvider {

	private List<FunctionalRequirement> requirements;
	private List<WorkPackage> workpackages;
	private WorkPackage lastSprint;

	/**
	 * Constructor.
	 * 
	 * @param lastSprint
	 *            last sprint
	 * @param workpackages
	 *            work packages
	 * @param requirements
	 *            requirements
	 */
	public TaskProvider(WorkPackage lastSprint, List<WorkPackage> workpackages,
			List<FunctionalRequirement> requirements) {
		this.lastSprint = lastSprint;
		this.workpackages = workpackages;
		this.requirements = requirements;
	}

	/**
	 * Constructor.
	 */
	public TaskProvider() {
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
	 * @return set of functional requirements to be implemented in sprints.
	 */
	public List<FunctionalRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new ArrayList<FunctionalRequirement>();
		}
		return requirements;
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
	public int getExpertise(WorkItem task, User assignee) {

		int expertise = 0;

		// find functional requirements annotated with this task
		Set<FunctionalRequirement> annotatedReqs = new HashSet<FunctionalRequirement>();
		for (ModelElement me : task.getAnnotatedModelElements()) {
			if (me instanceof FunctionalRequirement) {
				annotatedReqs.add((FunctionalRequirement) me);
			}
		}

		// find refining and refined requirements for each annotated requirement
		Set<FunctionalRequirement> relatedRequirements = new HashSet<FunctionalRequirement>();
		relatedRequirements.addAll(annotatedReqs);
		for (FunctionalRequirement req : annotatedReqs) {
			// ??? should we go through all the hierarchy?
			relatedRequirements.add(req.getRefinedRequirement());
			relatedRequirements.addAll(req.getRefiningRequirements());
		}

		// find related tasks (task annotating related requirements)
		Set<WorkItem> relatedWorkItems = new HashSet<WorkItem>();
		for (FunctionalRequirement req : relatedRequirements) {
			for (Annotation annotation : req.getAnnotations()) {
				if (annotation instanceof WorkItem) {
					relatedWorkItems.add((WorkItem) annotation);
				}
			}
		}

		// count number of related tasks assigned to this user
		for (WorkItem wi : relatedWorkItems) {
			if (wi.getAssignee().equals(assignee)) {
				expertise += 1;
			}
		}

		return expertise;
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
	 * tmp.
	 * @param reqs functional requirements
	 */
	public void setRequirements(List<FunctionalRequirement> reqs) {
		this.requirements = reqs;
	}

}
