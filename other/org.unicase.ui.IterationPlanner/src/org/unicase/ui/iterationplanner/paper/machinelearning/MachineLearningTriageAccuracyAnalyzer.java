package org.unicase.ui.iterationplanner.paper.machinelearning;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.OrganizationPackage;
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
		list.add("TotalPredictionsPerRevision");
		list.add("CorrectPredictionsPreRevision");

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
			if (!isRelvant(operation)) {
				continue;
			}

			Object assignee = getAssignee((ReferenceOperation)operation);
			List<Object> workItems = getWorkItems((ReferenceOperation)operation);
			if (assignee == null) {
				System.out.println("Assignee is NULL number: " + nullassignee);
			}
			for (Object wi : workItems) {
				predictAssigneee(wi, assignee);
			}

			// redraw the changes in the project
			try {
				operation.apply(clonedProject);
			} catch (Exception e) {
				// do nothing
			}
		}

		totalPredictionsPerRevision = totalPredictions - oldTotalPredictions;
		correctPredictionsPreRevision = correctPredictions
				- oldCorrectPredictions;

		// compute accuracy
		double aggregateAccuracy = ((double) correctPredictions)
				/ totalPredictions;
		double accurarcyPerRevision = ((double) correctPredictionsPreRevision)
				/ totalPredictionsPerRevision;
		value.add(data.getPrimaryVersionSpec().getIdentifier());
		value.add(aggregateAccuracy);
		value.add(totalPredictionsPerRevision);
		value.add(correctPredictionsPreRevision);
		System.out.println(value.get(0) + " ---- " + value.get(1)
				+ " ------- total pred: " + totalPredictions
				+ " ------ correct pred: " + correctPredictions
				+ " ----- totalPredictionsPerRevison " + value.get(2)
				+ " ----- correctPredictionsPerRevisioin " + value.get(3)
				+ " ---- #WIs: " + meMatrix.getModelElements().size());
		clonedProject = (Project) EcoreUtil.copy(data.getProjectState());
		return value;
	}

	private List<Object> getWorkItems(ReferenceOperation operation) {
		List<Object> result = new ArrayList<Object>();
		if(operation instanceof SingleReferenceOperation){
			// assignee is set for work item
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			Object wi =clonedProject.getModelElement(op.getModelElementId());
			result.add(wi);
			return result;
		}else if(operation instanceof MultiReferenceOperation){
			// assignments is set for user
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			for(ModelElementId meId : op.getReferencedModelElements()){
				result.add(clonedProject.getModelElement(meId));
			}
			return result;
		}
		return result;
		
	}

	private Object getAssignee(ReferenceOperation operation) {
		if(operation instanceof SingleReferenceOperation){
			// assignee is set for work item
			SingleReferenceOperation op = (SingleReferenceOperation) operation;
			return clonedProject.getModelElement(op.getNewValue());
		}else if(operation instanceof MultiReferenceOperation){
			// assignments is set for user
			MultiReferenceOperation op = (MultiReferenceOperation) operation;
			return clonedProject.getModelElement(op.getModelElementId());
		}
		return null;
	}

	private boolean isRelvant(AbstractOperation operation) {
		if (!(operation instanceof ReferenceOperation)) {
			return false;
		}
		ReferenceOperation refOp = (ReferenceOperation) operation;
		if (refOp.getFeatureName().equals(
				TaskPackage.eINSTANCE.getWorkItem_Assignee().getName())) {
			return true;
		}
		if (refOp.getFeatureName().equals(
				OrganizationPackage.eINSTANCE.getOrgUnit_Assignments()
						.getName())) {
			return true;
		}
		return false;
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
