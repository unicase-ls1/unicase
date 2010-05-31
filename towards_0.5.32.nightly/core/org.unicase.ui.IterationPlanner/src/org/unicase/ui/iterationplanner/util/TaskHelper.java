/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.util;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.IterationPlannerManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Hodaie
 */
public class TaskHelper {

	private List<WorkPackage> workpackages;
	private WorkPackage lastSprint;

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param relatedTaskStrategy relateTaskStrategy
	 * @param lastSprint last sprint
	 * @param workpackages work packages
	 */
	public TaskHelper(IterationPlannerManager iterationPlannerManager, WorkPackage lastSprint,
		List<WorkPackage> workpackages) {
		this.lastSprint = lastSprint;
		this.workpackages = workpackages;

	}

	/**
	 * Constructor.
	 * 
	 * @param iterationPlannerManager iteration planning manager
	 * @param relatedTaskStrategy relateTaskStrategy
	 */
	public TaskHelper(IterationPlannerManager iterationPlannerManager) {

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
	public static List<WorkItem> getRelatedWorkItems(WorkItem workItem) {
		// find model elements annotated with this task
		List<UnicaseModelElement> relatedMEs = new ArrayList<UnicaseModelElement>();
		relatedMEs.addAll(workItem.getAnnotatedModelElements());

		// if you found a requirement in related MEs then take its parent
		// and add all refinig requirements of parenet requiremnt to related MEs
		for (UnicaseModelElement me : workItem.getAnnotatedModelElements()) {
			if (me instanceof FunctionalRequirement) {
				FunctionalRequirement parentRequirement = ((FunctionalRequirement) me).getRefinedRequirement();
				if (parentRequirement == null) {
					parentRequirement = (FunctionalRequirement) me;
				}
				relatedMEs.addAll(RequirementHelper.getAllRefiningRequirements(parentRequirement));
			}

		}

		// all work items annotating related model elements are relevant
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
		if (fr.getRefinedRequirement() != null && fr.getRefinedRequirement().getRefinedRequirement() != null) {
			relatedFRs.addAll(RequirementHelper.getAllRefiningRequirements(fr.getRefinedRequirement()
				.getRefinedRequirement()));
		} else if (fr.getRefinedRequirement() != null) {

			relatedFRs.addAll(RequirementHelper.getAllRefiningRequirements(fr.getRefinedRequirement()));
		} else {
			relatedFRs.addAll(RequirementHelper.getAllRefiningRequirements(fr));
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
