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
package org.unicase.ui.iterationplanner.paper;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hodaie
 */
public abstract class TriageAccuracyAnalyzer implements DataAnalyzer {

	protected static int totalPredictions = 0;
	protected static int correctPredictions = 0;
	protected int totalPredictionsPerRevision = 0;
	protected int correctPredictionsPreRevision = 0;

	protected static int nullassignee = 0;

	protected Project clonedProject;

	public List<String> getName() {
		List<String> list = new ArrayList<String>();
		list.add("Revision");
		list.add("AggregateAccuracy");
		list.add("TotalPredictions");
		list.add("CorrectPredictions");
		list.add("TotalPredictionsPerRevision");
		list.add("CorrectPredictionsPreRevision");
		list.add("NumberOfWorkItems");

		return list;
	}

	public List<Object> getValue(ProjectAnalysisData data) {

		totalPredictionsPerRevision = 0;
		correctPredictionsPreRevision = 0;
		int oldTotalPredictions = totalPredictions;
		int oldCorrectPredictions = correctPredictions;

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
			// it is important to apply the operation first. Otherwise the assignee and work items are most the times
			// null, and we cannot do a prediction.
			try {
				operation.apply(clonedProject);
			} catch (Exception e) {
				// do nothing
			}

			if (!isRelvant(operation)) {
				continue;
			}

			Object assignee = getAssignee((ReferenceOperation) operation);
			List<Object> workItems = getWorkItems((ReferenceOperation) operation);
			if (assignee == null) {
				System.out.println("Assignee is NULL number: " + nullassignee);
			}
			for (Object wi : workItems) {
				predictAssigneee(wi, assignee);
			}

		}

		totalPredictionsPerRevision = totalPredictions - oldTotalPredictions;
		correctPredictionsPreRevision = correctPredictions - oldCorrectPredictions;

		// compute accuracy
		double aggregateAccuracy = ((double) correctPredictions) / totalPredictions;
		double accurarcyPerRevision = ((double) correctPredictionsPreRevision) / totalPredictionsPerRevision;
		value.add(data.getPrimaryVersionSpec().getIdentifier());
		value.add(aggregateAccuracy);
		value.add(totalPredictions);
		value.add(correctPredictions);
		value.add(totalPredictionsPerRevision);
		value.add(correctPredictionsPreRevision);
		value.add(getRelevantWorkItems().size());
		System.out.println(value.get(0) + " ---- " + value.get(1) + " ------- total pred: " + value.get(2)
			+ " ------ correct pred: " + value.get(3) + " ----- totalPredictionsPerRevison " + value.get(4)
			+ " ----- correctPredictionsPerRevisioin " + value.get(5) + " ---- #WIs: " + value.get(6));
		clonedProject = (Project) EcoreUtil.copy(data.getProjectState());
		return value;
	}

	public boolean isExportOnce() {
		return false;
	}

	/**
	 * @return
	 */
	protected List<UnicaseModelElement> getRelevantWorkItems() {
		List<WorkItem> allWorkItems = clonedProject.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
			new BasicEList<WorkItem>());
		ArrayList<UnicaseModelElement> relevantWorkItems = new ArrayList<UnicaseModelElement>();
		for (WorkItem wi : allWorkItems) {
			if (!(wi instanceof WorkPackage || wi instanceof Milestone)) {
				relevantWorkItems.add(wi);
			}
		}
		return relevantWorkItems;
	}

	protected List<Object> getWorkItems(ReferenceOperation operation) {
		List<Object> result = new ArrayList<Object>();
		if (operation instanceof SingleReferenceOperation) {
			// assignee is set for work item
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			Object wi = clonedProject.getModelElement(op.getModelElementId());
			result.add(wi);
			return result;
		} else if (operation instanceof MultiReferenceOperation) {
			// assignments is set for user
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			for (ModelElementId meId : op.getReferencedModelElements()) {
				Object wi = clonedProject.getModelElement(meId);
				result.add(wi);
			}
			return result;
		}
		return result;

	}

	protected boolean isRelvant(AbstractOperation operation) {
		if (!(operation instanceof ReferenceOperation)) {
			return false;
		}
		ReferenceOperation refOp = (ReferenceOperation) operation;
		if (refOp.getFeatureName().equals(TaskPackage.eINSTANCE.getWorkItem_Assignee().getName())) {
			return true;
		}
		if (refOp.getFeatureName().equals(OrganizationPackage.eINSTANCE.getOrgUnit_Assignments().getName())) {
			return true;
		}
		return false;
	}

	protected Object getAssignee(ReferenceOperation operation) {
		if (operation instanceof SingleReferenceOperation) {
			// assignee is set for work item
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			Object assignee = clonedProject.getModelElement(op.getNewValue());
			return assignee;
		} else if (operation instanceof MultiReferenceOperation) {
			// assignments is set for user
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			Object assigenee = clonedProject.getModelElement(op.getModelElementId());
			return assigenee;
		}
		return null;
	}

	protected abstract void predictAssigneee(Object wi, Object assignee);

}
