package org.unicase.ui.iterationplanner.paper.machinelearning;

import org.unicase.model.UnicaseModelElement;
import org.unicase.model.bug.BugReport;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.ui.iterationplanner.paper.TriageAccuracyAnalyzer;

/**
 * This class asks the classifier for assignee predictions on each revision of project.
 * 
 * @author hodaie
 */
public class MachineLearningTriageAccuracyAnalyzer extends TriageAccuracyAnalyzer {

	private Classification classification;
	private ModelElementMatrix meMatrix;

	public MachineLearningTriageAccuracyAnalyzer(Classification classification, ModelElementMatrix m) {
		this.classification = classification;
		this.meMatrix = m;

	}

	protected void predictAssigneee(Object wi, Object assignee) {
		if (!(wi instanceof BugReport || wi instanceof ActionItem || wi instanceof Issue)) {
			return;
		}
		if (!(assignee instanceof OrgUnit)) {
			return;
		}
		totalPredictions++;

		meMatrix = new ModelElementMatrix(getRelevantWorkItems(), meMatrix.getFeatures());

		// put the WorkItem that is to be predicted to end of model elements
		// list
		// this is for classifier to predict assignee for this work item. see
		// Classificaiton.predictAssignee()
		meMatrix.getModelElements().remove(wi);
		meMatrix.getModelElements().add((UnicaseModelElement) wi);

		if (meMatrix.getModelElements().size() == 1) {
			return;
		}
		String suggestedAssignee = null;
		try {
			classification.init(meMatrix);
			suggestedAssignee = classification.predictAssignee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (suggestedAssignee != null && assignee != null
			&& areEqual(suggestedAssignee, ((OrgUnit) assignee).getName())) {
			correctPredictions++;
		}

	}

	/**
	 * @param suggestedAssignee
	 * @param name
	 * @return
	 */
	private boolean areEqual(String suggestedAssignee, String actualAssignee) {
		suggestedAssignee = suggestedAssignee.toLowerCase().trim();
		actualAssignee = actualAssignee.toLowerCase().trim();
		if (suggestedAssignee.startsWith(actualAssignee)) {
			return true;
		} else if (actualAssignee.startsWith(suggestedAssignee)) {
			return true;
		}
		return false;
	}

}
