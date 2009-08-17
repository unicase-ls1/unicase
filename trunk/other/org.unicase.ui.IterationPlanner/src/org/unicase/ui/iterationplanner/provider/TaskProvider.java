/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Hodaie
 */
public class TaskProvider {

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

}
