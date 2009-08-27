/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.paper.imperative;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.model.Project;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.ui.iterationplanner.evaluator.SimpleEvaluator;
import org.unicase.ui.iterationplanner.provider.AssigneeProvider;
import org.unicase.ui.iterationplanner.provider.ExpertiseMap;
import org.unicase.ui.iterationplanner.provider.ImperativeAssigneePrediction;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * @author Hodaie
 */
public class PaperImperative {

	private List<User> assigneesWithMoreThan10Tasks;
	private List<User> assigneesWithAtLeastOneTask;
	private List<User> allAssignees;


	private EList<WorkItem> allWorkItems;
	private List<WorkItem> allWorkItemsWithAssignee;
	private List<WorkItem> allWorkItemsWithAnnotatedMEsAndAssignee;
	private ArrayList<WorkItem> allWorkItemsWithAssigneesWithMoreThan10Task;
	private ProjectSpace projectSpace;

	public void start() {

		projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(0);
		Project project = getProject();

		
		initAssignees(project);
		initWorkItems(project);
		List<WorkItem> workItems = allWorkItemsWithAnnotatedMEsAndAssignee;
		List<User> assignees = allAssignees;
		IterationPlannerManager planningManager = new IterationPlannerManager();
	
		Map<WorkItem, ExpertiseMap> testSet = new HashMap<WorkItem, ExpertiseMap>();
		AssigneeProvider assigneeProvider = new AssigneeProvider(
				planningManager, new ImperativeAssigneePrediction());
		assigneeProvider.setAssignees(assignees);
		for (WorkItem wi : workItems) {
			ExpertiseMap expertiseMap = assigneeProvider.getExpertiseMap(wi);
			print(expertiseMap, wi);
			testSet.put(wi, expertiseMap);

		}

		((SimpleEvaluator) planningManager.getEvaluator())
				.computeAccuracy(testSet);
		double firstPercision = ((SimpleEvaluator) planningManager
				.getEvaluator()).getFirstProposalPercision();
		double secondPercision = ((SimpleEvaluator) planningManager
				.getEvaluator()).getSecondProposalPercision();

		System.out.printf("first percision: %f%n", firstPercision);
		System.out.printf("scond percision: %f%n", secondPercision);

		int workItemsWithOutAnnotatedMEs = 0;
		for (WorkItem wi : workItems) {
			if (wi.getAnnotatedModelElements().size() == 0) {
				workItemsWithOutAnnotatedMEs++;
			}
		}

		System.out.println("num of work items: " + workItems.size());
		System.out.printf("work items without annotated MEs: %d (%f %%)",
				workItemsWithOutAnnotatedMEs,
				(double) workItemsWithOutAnnotatedMEs * 100 / workItems.size());

		
		

	}



	

	/**
	 * @return
	 */
	private Project getProject() {
		Project project  = projectSpace.getProject();
		return project;
	}

	private void print(ExpertiseMap expertiseMap, WorkItem wi) {
		System.out.println("=============================================================================");
		System.out.println(wi.getName() + " ----> " + wi.getAssignee().getName() + " ("
			+ expertiseMap.sortByExpertise().get(0).getKey().getName() + ")");
		Iterator<Entry<User, Double>> iterator = expertiseMap.getIterator();
		while (iterator.hasNext()) {
			Entry<User, Double> next = iterator.next();
			System.out.printf("%-10s%40.1f%n", next.getKey().getName(), next.getValue());
		}
	}

	private void initWorkItems(Project project) {

		allWorkItems = project.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<WorkItem>());

		allWorkItemsWithAssignee = new ArrayList<WorkItem>();
		allWorkItemsWithAnnotatedMEsAndAssignee = new ArrayList<WorkItem>();
		allWorkItemsWithAssigneesWithMoreThan10Task = new ArrayList<WorkItem>();
		for (WorkItem wi : allWorkItems) {
			if (!(wi instanceof WorkPackage || wi instanceof Milestone) && wi.getAssignee() != null
				&& !(wi.getAssignee() instanceof Group)) {
				allWorkItemsWithAssignee.add(wi);
				if (assigneesWithMoreThan10Tasks.contains(wi.getAssignee())) {
					allWorkItemsWithAssigneesWithMoreThan10Task.add(wi);
				}

				if (wi.getAnnotatedModelElements().size() > 0) {
					allWorkItemsWithAnnotatedMEsAndAssignee.add(wi);
				}

			}

		}

	}

	private List<WorkItem> getWorkItems(WorkPackage wp) {
		List<WorkItem> result = new ArrayList<WorkItem>();
		for (WorkItem wi : wp.getContainedWorkItems()) {
			if (wi instanceof WorkPackage) {
				result.addAll(((WorkPackage) wi).getContainedWorkItems());
			} else {
				result.add(wi);
			}
		}

		return result;
	}

	private List<WorkItem> getWorkItems(List<WorkPackage> wps) {
		List<WorkItem> result = new ArrayList<WorkItem>();
		for (WorkPackage wp : wps) {
			result.addAll(getWorkItems(wp));
		}
		return result;
	}

	private void initAssignees(Project project) {
		allAssignees = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		assigneesWithAtLeastOneTask = new ArrayList<User>();
		assigneesWithMoreThan10Tasks = new ArrayList<User>();
		for (User assignee : allAssignees) {
			if (assignee.getAssignments().size() > 0) {
				assigneesWithAtLeastOneTask.add(assignee);
			}
			if (assignee.getAssignments().size() > 10) {
				assigneesWithMoreThan10Tasks.add(assignee);
			}
		}

	}
}

