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
package org.unicase.ui.iterationplanner.assigneerecommendation;

import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;

import java.util.Collection;
import java.util.Map;

/**
 * @author Hodaie
 */
public class MLAssigneeRecommender {

	public Map<UnicaseModelElement, Double> getMatchingMap(WorkItem wi, Collection<OrgUnit> assignees) {
		return null;
	}

	public String getName() {
		return "MLAssigneeRecommender";
	}

}

// if (!(wi instanceof BugReport || wi instanceof ActionItem || wi instanceof Issue)) {
// return;
// }
// if (!(assignee instanceof OrgUnit)) {
// return;
// }
// totalPredictions++;
//
// meMatrix = new ModelElementMatrix(getRelevantWorkItems(), meMatrix.getFeatures());
//
// // put the WorkItem that is to be predicted to end of model elements
// // list
// // this is for classifier to predict assignee for this work item. see
// // Classificaiton.predictAssignee()
// meMatrix.getModelElements().remove(wi);
// meMatrix.getModelElements().add((ModelElement) wi);
//
// if (meMatrix.getModelElements().size() == 1) {
// return;
// }
// try {
// classification.init(meMatrix);
// } catch (Exception e) {
// e.printStackTrace();
// }
// String suggestedAssignee = null;
// try {
// suggestedAssignee = classification.predictAssignee();
// } catch (Exception e) {
// e.printStackTrace();
// }
// if (suggestedAssignee != null && assignee != null
// && areEqual(suggestedAssignee, ((OrgUnit) assignee).getName())) {
// correctPredictions++;
// }
