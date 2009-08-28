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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.iterationplanner.provider.AssigneeProvider;
import org.unicase.ui.iterationplanner.provider.TaskProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Hodaie
 */
public class ImperativeTriageAccuracyAnalyzer implements DataAnalyzer {

	private static int totalPredictions = 0;
	private static int correctPredictions = 0;
	private static int nullassignee = 0;

	private Project clonedProject;
	private AssigneeProvider assigneeProvider;
	private TaskProvider taskProvider;

	/**
	 * @param assigneeProvider
	 * @param taskProvider
	 */
	public ImperativeTriageAccuracyAnalyzer(AssigneeProvider assigneeProvider, TaskProvider taskProvider) {
		this.taskProvider = taskProvider;
		this.assigneeProvider = assigneeProvider;
	}

	public List<String> getName() {
		List<String> list = new ArrayList<String>();
		list.add("TriageAccuracy");
		return list;
	}

	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> value = new ArrayList<Object>();
		// find assignee operations
		// first step? just fetch the data.
		if (clonedProject == null) {
			clonedProject = (Project) EcoreUtil.copy(data.getProjectState());
			return value;
		}

		EList<ChangePackage> changePackages = data.getChangePackages();
		List<AbstractOperation> operations = new ArrayList<AbstractOperation>();

		// Check each change.
		for (ChangePackage changePackage : changePackages) {
			operations.addAll(changePackage.getOperations());
		}
		List<AbstractOperation> leafoperations = new ArrayList<AbstractOperation>();

		for (AbstractOperation operation : operations) {

			leafoperations.addAll(operation.getLeafOperations());
		}
		for (AbstractOperation operation : leafoperations) {
			if (!(operation instanceof ReferenceOperation)) {
				continue;
			}
			ReferenceOperation refOp = (ReferenceOperation) operation;
			if (refOp.getFeatureName().equals(TaskPackage.eINSTANCE.getWorkItem_Assignee().getName())) {

				Object assignee = findNewAssignee(refOp.getAllInvolvedModelElements());
				if (assignee == null) {
					System.out.println("Assignee is NULL number: " + nullassignee);
				}
				predictAssigneee(clonedProject.getModelElement(refOp.getModelElementId()), assignee);
			}

			// redraw the changes in the project
			try {
				operation.apply(clonedProject);
			} catch (Exception e) {
				// do nothing
			}
		}

		// compute accuracy
		double accuracy = ((double) correctPredictions / totalPredictions);
		value.add(accuracy);
		System.out.println(data.getPrimaryVersionSpec().getIdentifier() + " ---------- " + value.get(0)
			+ " ------- total pred: " + totalPredictions + " ------ correct pred: " + correctPredictions);
		clonedProject = (Project) EcoreUtil.copy(data.getProjectState());
		return value;
	}

	/**
	 * @param allInvolvedModelElements
	 * @return
	 */
	private Object findNewAssignee(Set<ModelElementId> allInvolvedModelElements) {
		for (ModelElementId meId : allInvolvedModelElements) {
			ModelElement me = clonedProject.getModelElement(meId);
			if (me instanceof User) {
				return me;
			}
		}
		return null;
	}

	private void predictAssigneee(Object wi, Object assignee) {
		if (!(wi instanceof BugReport || wi instanceof ActionItem || wi instanceof Issue)) {
			return;
		}
		if (!(assignee instanceof User)) {
			return;
		}
		totalPredictions++;

		assigneeProvider.setAssignees(getAssignees());
		User suggestedAssignee = assigneeProvider.getAppropriateAssignee((WorkItem) wi);

		if (suggestedAssignee != null && assignee != null && suggestedAssignee.equals(assignee)) {
			correctPredictions++;
		}

	}

	/**
	 * @return
	 */
	private List<User> getAssignees() {
		List<User> allAssignees = clonedProject.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE.getUser(),
			new BasicEList<User>());
		return allAssignees;
	}

	// /**
	// * @return
	// */
	// private List<ModelElement> getRelevantWorkItems() {
	// List<WorkItem> allWorkItems = clonedProject.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
	// new BasicEList<WorkItem>());
	// ArrayList<ModelElement> relevantWorkItems = new ArrayList<ModelElement>();
	// for (WorkItem wi : allWorkItems) {
	// if (!(wi instanceof WorkPackage || wi instanceof Milestone)) {
	// if (wi.getAnnotatedModelElements().size() > 0)
	// relevantWorkItems.add(wi);
	// }
	// }
	// return relevantWorkItems;
	// }

	public boolean isExportOnce() {
		return false;
	}

}
