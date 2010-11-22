/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;

/**
 * This class is responsible for holding tasks to be planned, computing tasks related to a task (using
 * RelatedTasksStrategy), creating a list of assignee expertise regarding a task.
 * 
 * @author Hodaie
 */
public class TaskProvider {

	private List<WorkPackage> workpackages;
	private WorkPackage lastSprint;
	// private FindAssigneeStrategy relatedTasksSterategy;
	private IterationPlannerManager planningManager;

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param relatedTaskStrategy relateTaskStrategy
	 * @param lastSprint last sprint
	 * @param workpackages work packages
	 */
	public TaskProvider(IterationPlannerManager iterationPlannerManager, WorkPackage lastSprint,
		List<WorkPackage> workpackages) {
		this.planningManager = iterationPlannerManager;
		this.lastSprint = lastSprint;
		this.workpackages = workpackages;

	}

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param relatedTaskStrategy relateTaskStrategy
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
					lastSprint
						.setStartDate(new Date(lastSprint.getEndDate().getTime() - 14L * 24L * 60L * 60L * 1000L));
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
	 * @param tasks tasks
	 * @return sorted task list
	 */
	public List<WorkItem> sortByPriority(List<WorkItem> tasks) {
		return null;
	}

	/**
	 * extract list of work items form FRs.
	 * 
	 * @param frs a list of functional requirements
	 * @return a list of work items relating to these FRs.
	 */
	public List<WorkItem> getWorkItems(List<FunctionalRequirement> frs) {
		return null;
	}

	/**
	 * @param lastSprint last sprint
	 */
	public void setLastSprint(WorkPackage lastSprint) {
		this.lastSprint = lastSprint;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<WorkItem> getRelatedWorkItems(WorkItem workItem) {
		// find model elements requirements annotated with this task
		List<UnicaseModelElement> relatedMEs = new ArrayList<UnicaseModelElement>();
		relatedMEs.addAll(workItem.getAnnotatedModelElements());

		for (UnicaseModelElement me : workItem.getAnnotatedModelElements()) {
			if (me instanceof FunctionalRequirement) {
				relatedMEs.addAll(planningManager.getRequirementProvider().getAllRefiningRequirements(
					(FunctionalRequirement) me));
			}

		}

		List<WorkItem> relatedWorkItems = new ArrayList<WorkItem>();
		for (UnicaseModelElement me : relatedMEs) {
			for (Annotation annotation : me.getAnnotations()) {
				if (annotation instanceof WorkItem) {
					relatedWorkItems.add((WorkItem) annotation);
				}
			}
		}

		return relatedWorkItems;

	}

	/**
	 * @param fr
	 */
	public List<WorkItem> getRelatedWorkItems(FunctionalRequirement fr) {
		List<WorkItem> relatedWorkItems = new ArrayList<WorkItem>();
		// find related FRs
		List<FunctionalRequirement> relatedFRs = new ArrayList<FunctionalRequirement>();
		RequirementProvider requirementProvider = planningManager.getRequirementProvider();
		if (fr.getRefinedRequirement() != null && fr.getRefinedRequirement().getRefinedRequirement() != null) {
			relatedFRs.addAll(requirementProvider.getAllRefiningRequirements(fr.getRefinedRequirement()
				.getRefinedRequirement()));
		} else if (fr.getRefinedRequirement() != null) {

			relatedFRs.addAll(requirementProvider.getAllRefiningRequirements(fr.getRefinedRequirement()));
		} else {
			relatedFRs.addAll(requirementProvider.getAllRefiningRequirements(fr));
		}

		for (FunctionalRequirement freq : relatedFRs) {
			for (Annotation annotation : freq.getAnnotations()) {
				if (annotation instanceof WorkItem) {
					relatedWorkItems.add((WorkItem) annotation);
				}
			}
		}

		return relatedWorkItems;

	}
}
