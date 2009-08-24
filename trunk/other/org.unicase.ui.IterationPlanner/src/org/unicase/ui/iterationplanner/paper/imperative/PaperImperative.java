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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.model.Project;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.ui.iterationplanner.provider.AssigneeProvider;
import org.unicase.ui.iterationplanner.provider.ExpertiseMap;
import org.unicase.ui.iterationplanner.provider.ImperativeFindAssignee;
import org.unicase.workspace.WorkspaceManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

/**
 * @author Hodaie
 */
public class PaperImperative {

	private List<User> assigneesWithMoreThan10Tasks;
	private List<User> assigneesWithAtLeastOneTask;
	private List<User> allAssignees;

	private List<FunctionalRequirement> allFRs;
	private List<FunctionalRequirement> selectedFRs;

	private EList<WorkItem> allWorkItems;
	private List<WorkItem> allWorkItemsWithAssignee;
	private List<WorkItem> allWorkItemsWithAnnotatedMEsAndAssignee;
	private ArrayList<WorkItem> allWorkItemsWithAssigneesWithMoreThan10Task;

	public void start() {

		Project project = getProject();

		initFRs(project);

		IterationPlannerManager planningManager = new IterationPlannerManager();
		AssigneeProvider assigneeProvider = new AssigneeProvider(planningManager, new ImperativeFindAssignee());
		assigneeProvider.setAssignees(getAssignees(project));

		Map<FunctionalRequirement, ExpertiseMap> testSet = new HashMap<FunctionalRequirement, ExpertiseMap>();
		for (FunctionalRequirement fr : selectedFRs) {
			testSet.put(fr, assigneeProvider.getExpertiseMap(fr));
		}

		print(testSet);

	}

	/**
	 * @param testSet
	 */
	private void print(Map<FunctionalRequirement, ExpertiseMap> testSet) {
		Iterator<Entry<FunctionalRequirement, ExpertiseMap>> iterator = testSet.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println("=============================================================================");
			Entry<FunctionalRequirement, ExpertiseMap> next = iterator.next();
			System.out.println(next.getKey().getName());
			print(next.getValue());

		}
	}

	/**
	 * @param value
	 */
	private void print(ExpertiseMap emap) {
		Iterator<Entry<User, Double>> iterator = emap.getIterator();
		while (iterator.hasNext()) {
			Entry<User, Double> next = iterator.next();
			System.out.printf("%-10s%40.1f%n", next.getKey().getName(), next.getValue());

		}
	}

	/**
	 * @return
	 */
	private List<User> getAssignees(Project project) {
		List<User> result = new ArrayList<User>();
		allAssignees = project.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		for (User assignee : allAssignees) {
			if (assignee.getName().equals("kaserf")) {
				result.add(assignee);
			} else if (assignee.getName().equals("lachinge")) {
				result.add(assignee);
			} else if (assignee.getName().equals("flake")) {
				result.add(assignee);
			} else if (assignee.getName().equals("loock")) {
				result.add(assignee);
			}
		}
		return result;
	}

	/**
	 * @param project
	 */
	private void initFRs(Project project) {
		allFRs = project.getAllModelElementsbyClass(RequirementPackage.eINSTANCE.getFunctionalRequirement(),
			new BasicEList<FunctionalRequirement>());
		selectedFRs = new ArrayList<FunctionalRequirement>();
		int[] indices = getIndices(50, allFRs.size() - 1);
		for (int i = 0; i < indices.length; i++) {
			selectedFRs.add(allFRs.get(indices[i]));
		}
	}

	/**
	 * @param i
	 * @param size
	 * @return
	 */
	private int[] getIndices(int size, int topIndex) {
		// unique indices
		Random random = new Random();
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			int nextIndex = random.nextInt(topIndex + 1);
			while (contains(result, nextIndex)) {
				nextIndex = random.nextInt(topIndex + 1);
			}
			result[i] = nextIndex;
		}

		return result;
	}

	/**
	 * @param array
	 * @param nextIndex
	 * @return
	 */
	private boolean contains(int[] array, int value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return
	 */
	private Project getProject() {
		Project project;
		// project = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace().getProject();

		project = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(0).getProject();

		// String path = "";
		// try {
		// project = WorkspaceManager.getInstance().getCurrentWorkspace().importProject(path).getProject();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

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

// public void start() {
//
// Project project = getProject();
//
// initAssignees(project);
// initWorkItems(project);
// List<WorkItem> workItems = allWorkItemsWithAnnotatedMEsAndAssignee;
// List<User> assignees = assigneesWithAtLeastOneTask;
// IterationPlannerManager planningManager = new IterationPlannerManager();
// planningManager.getAssigneeProvider().setAssignees(assignees);
//
// Map<WorkItem, ExpertiseMap> testSet = new HashMap<WorkItem, ExpertiseMap>();
// AssigneeProvider assigneeProvider = new AssigneeProvider(planningManager, new ImperativeFindAssignee());
// for (WorkItem wi : workItems) {
// ExpertiseMap expertiseMap = assigneeProvider.getExpertiseMap(wi);
// print(expertiseMap, wi);
// testSet.put(wi, expertiseMap);
//
// }
//
// ((SimpleEvaluator) planningManager.getEvaluator()).computePercision(testSet);
// double firstPercision = ((SimpleEvaluator) planningManager.getEvaluator()).getFirstProposalPercision();
// double secondPercision = ((SimpleEvaluator) planningManager.getEvaluator()).getSecondProposalPercision();
//
// System.out.printf("first percision: %f%n", firstPercision);
// System.out.printf("scond percision: %f%n", secondPercision);
//
// int workItemsWithOutAnnotatedMEs = 0;
// for (WorkItem wi : workItems) {
// if (wi.getAnnotatedModelElements().size() == 0) {
// workItemsWithOutAnnotatedMEs++;
// }
// }
//
// System.out.println("num of work items: " + workItems.size());
// System.out.printf("work items without annotated MEs: %d (%f %%)", workItemsWithOutAnnotatedMEs,
// (double) workItemsWithOutAnnotatedMEs * 100 / workItems.size());
// }