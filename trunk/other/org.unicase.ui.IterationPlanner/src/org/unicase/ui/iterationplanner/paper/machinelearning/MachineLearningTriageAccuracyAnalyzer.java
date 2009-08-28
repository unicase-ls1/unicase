package org.unicase.ui.iterationplanner.paper.machinelearning;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * This class asks the classifier for assignee predictions on each revision of
 * project.
 * 
 * @author hodaie
 * 
 */
public class MachineLearningTriageAccuracyAnalyzer implements DataAnalyzer {

	private static int totalPredictions = 0;
	private static int correctPredictions = 0;
	private int totalPredictionsPerRevision = 0;
	private int correctPredictionsPreRevision = 0;

	private static int nullassignee = 0;

	private Classification classification;
	private ModelElementMatrix meMatrix;

	private Project clonedProject;

	public MachineLearningTriageAccuracyAnalyzer(Classification classification,
			ModelElementMatrix m) {
		this.classification = classification;
		this.meMatrix = m;

	}

	public List<String> getName() {
		List<String> list = new ArrayList<String>();
		list.add("Revision");
		list.add("AggregateAccuracy");
		list.add("AccuracyPerRevision");
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
			if (!(operation instanceof ReferenceOperation)) {
				continue;
			}
			ReferenceOperation refOp = (ReferenceOperation) operation;
			if (refOp.getFeatureName().equals(
					TaskPackage.eINSTANCE.getWorkItem_Assignee().getName())) {

				Object assignee = findNewAssignee(refOp
						.getAllInvolvedModelElements());
				if (assignee == null) {
					System.out.println("Assignee is NULL number: "
							+ nullassignee);
				}
				predictAssigneee(clonedProject.getModelElement(refOp
						.getModelElementId()), assignee);
			}

			// redraw the changes in the project
			try {
				operation.apply(clonedProject);
			} catch (Exception e) {
				// do nothing
			}
		}

		totalPredictionsPerRevision = totalPredictions - oldTotalPredictions;
		correctPredictionsPreRevision = correctPredictions - oldCorrectPredictions;
		
		// compute accuracy
		double aggregateAccuracy = (double) correctPredictions / totalPredictions;
		double accurarcyPerRevision = (double)correctPredictionsPreRevision/totalPredictionsPerRevision;
		value.add(value.add(data.getPrimaryVersionSpec()));
		value.add(aggregateAccuracy);
		value.add(accurarcyPerRevision);
		System.out.println(value.get(0)
				+ " ---- " + value.get(1) + " ----- " + value.get(2) + " ------- total pred: "
				+ totalPredictions + " ------ correct pred: "
				+ correctPredictions + " ----- totalPredictionsPerRevison " + totalPredictionsPerRevision  +" ----- correctPredictionsPerRevisioin " + correctPredictionsPreRevision + " ---- #WIs: "
				+ meMatrix.getModelElements().size());
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

		meMatrix = new ModelElementMatrix(getRelevantWorkItems(), meMatrix
				.getFeatures());

		// put the WorkItem that is to be predicted to end of model elements
		// list
		// this is for classifier to predict assignee for this work item. see
		// Classificaiton.predictAssignee()
		meMatrix.getModelElements().remove(wi);
		meMatrix.getModelElements().add((ModelElement) wi);

		if (meMatrix.getModelElements().size() == 1) {
			return;
		}
		try {
			classification.init(meMatrix);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String suggestedAssignee = null;
		try {
			suggestedAssignee = classification.predictAssignee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (suggestedAssignee != null && assignee != null
				&& suggestedAssignee.equals(((User) assignee).getName())) {
			correctPredictions++;
		}

	}

	/**
	 * @return
	 */
	private List<ModelElement> getRelevantWorkItems() {
		List<WorkItem> allWorkItems = clonedProject
				.getAllModelElementsbyClass(
						TaskPackage.eINSTANCE.getWorkItem(),
						new BasicEList<WorkItem>());
		ArrayList<ModelElement> relevantWorkItems = new ArrayList<ModelElement>();
		for (WorkItem wi : allWorkItems) {
			if (!(wi instanceof WorkPackage || wi instanceof Milestone)) {
				relevantWorkItems.add(wi);
			}
		}
		return relevantWorkItems;
	}

	public boolean isExportOnce() {
		return false;
	}

}
