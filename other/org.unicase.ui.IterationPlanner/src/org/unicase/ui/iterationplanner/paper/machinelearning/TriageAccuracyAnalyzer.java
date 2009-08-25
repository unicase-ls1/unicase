package org.unicase.ui.iterationplanner.paper.machinelearning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
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
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;

public class TriageAccuracyAnalyzer implements DataAnalyzer {

	private static int totalPredictions = 0;
	private static int correctPredictions = 0;

	private Classification classification;
	private ModelElementMatrix meMatrix;

	private Project clonedProject;

	public TriageAccuracyAnalyzer(Classification classification,
			ModelElementMatrix m) {
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
			
			
			List<ModelElement> involvedMEs = new ArrayList<ModelElement>();
			for(ModelElementId meId : operation.getAllInvolvedModelElements()){
				involvedMEs.add(clonedProject.getModelElement(meId));
			}

			for(ModelElement me : involvedMEs){
				if (me instanceof ActionItem || me instanceof BugReport || me instanceof Issue) {
					// predict assignee
					predictAssigneee((WorkItem) me);
				}
			}
			

//			EReference eReference = getReference(operation, me);
//			if (!TaskPackage.eINSTANCE.getWorkItem_Assignee()
//					.equals(eReference)) {
//				continue;
//			}

			
			
			// redraw the changes in the project
			if (operation.canApply(clonedProject)) {
				operation.apply(clonedProject);
			} else  {
				System.out.println("Can't apply: " + operation.getName());
			}
		}

		// compute accuracy
		double accuracy = ((double)correctPredictions /  totalPredictions);
		value.add(accuracy);
		System.out.println(data.getPrimaryVersionSpec().getIdentifier() + " ---------- " + value.get(0) + " ------- total pred: " + totalPredictions + " ------ correct pred: " + correctPredictions + " ---- #WIs: " + meMatrix.getModelElements().size()); 
		return value;
	}

//	private EReference getReference(AbstractOperation operation, ModelElement me) {
//		if (me == null || operation == null) {
//			return null;
//		}
//
//		if (operation instanceof ReferenceOperation) {
//			String featureName = ((ReferenceOperation) operation)
//					.getFeatureName();
//			if (featureName == null) {
//				return null;
//			}
//
//			for (EReference ref : me.eClass().getEAllReferences()) {
//				String name = ref.getName();
//
//				if (name != null && name.equals(featureName)) {
//					return ref;
//				}
//			}
//		}
//
//		return null;
//	}

	private void predictAssigneee(WorkItem wi) {
		totalPredictions++;
		meMatrix.addModelElement(wi);
		if(meMatrix.getModelElements().size() == 1){
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
		if (suggestedAssignee != null
				&& wi.getAssignee() != null && suggestedAssignee.equals(wi.getAssignee().getName())) {
			correctPredictions++;
		}

	}

	public boolean isExportOnce() {
		return false;
	}

}
