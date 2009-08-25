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

public class TriageAccuracyAnalyzer implements DataAnalyzer {

	private static int totalPredictions = 0;
	private static int correctPredictions = 0;

	private Classification classification;
	private ModelElementMatrix meMatrix;

	private Project clonedProject;

	public TriageAccuracyAnalyzer(Classification classification, ModelElementMatrix m) {
		this.classification = classification;
		this.meMatrix = m;

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

		for (AbstractOperation operation : operations) {

			if (operation instanceof CompositeOperation) {
				operations.addAll(getAllSubOperations((CompositeOperation) operation));
			}
			if (!(operation instanceof ReferenceOperation)) {
				continue;
			}
			ReferenceOperation refOp = (ReferenceOperation) operation;
			if (refOp.getFeatureName().equals(TaskPackage.eINSTANCE.getWorkItem_Assignee().getName())) {
				Object assignee = findNewAssignee(refOp.getAllInvolvedModelElements());
				predictAssigneee(clonedProject.getModelElement(refOp.getModelElementId()), assignee);
			}

			// redraw the changes in the project
			if (operation.canApply(clonedProject)) {
				operation.apply(clonedProject);
				new Object();
			} else {
				System.out.println("Can't apply: " + operation.getName());
			}
		}

		// compute accuracy
		double accuracy = ((double) correctPredictions / totalPredictions);
		value.add(accuracy);
		System.out.println(data.getPrimaryVersionSpec().getIdentifier() + " ---------- " + value.get(0)
			+ " ------- total pred: " + totalPredictions + " ------ correct pred: " + correctPredictions
			+ " ---- #WIs: " + meMatrix.getModelElements().size());
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

	/**
	 * @param operation
	 * @return
	 */
	private Collection<? extends AbstractOperation> getAllSubOperations(CompositeOperation compOp) {
		List<AbstractOperation> allSubOps = new ArrayList<AbstractOperation>();
		for (AbstractOperation subOp : compOp.getSubOperations()) {
			if (subOp instanceof CompositeOperation) {
				allSubOps.addAll(getAllSubOperations((CompositeOperation) subOp));
			} else {
				allSubOps.add(subOp);
			}
		}

		return allSubOps;
	}

	private void predictAssigneee(Object wi, Object assignee) {
		if (!(wi instanceof BugReport || wi instanceof ActionItem || wi instanceof Issue)) {
			return;
		}
		if (!(assignee instanceof User)) {
			return;
		}
		totalPredictions++;

		meMatrix = new ModelElementMatrix(getRelevantWorkItems(), meMatrix.getFeatures());

		// put the WorkItem that is to be predicted to end of model elements list
		// this is for classifier to predict assignee for this work item. see Classificaiton.predictAssignee()
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
		if (suggestedAssignee != null && assignee != null && suggestedAssignee.equals(((User) assignee).getName())) {
			correctPredictions++;
		}

	}

	/**
	 * @return
	 */
	private List<ModelElement> getRelevantWorkItems() {
		List<WorkItem> allWorkItems = clonedProject.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getWorkItem(),
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
