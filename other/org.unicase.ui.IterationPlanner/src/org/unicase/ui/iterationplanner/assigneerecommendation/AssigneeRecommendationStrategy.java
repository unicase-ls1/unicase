/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.iterationplanner.assigneerecommendation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.recommendation.RecommendationStrategy;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.preferences.UnicasePreferenceConstants;

public class AssigneeRecommendationStrategy implements RecommendationStrategy {

	private static final boolean SIMPLE_RECOMMENDER = true;

	public AssigneeRecommendationStrategy() {
	}

	public Map<UnicaseModelElement, Double> getMatchingMap(UnicaseModelElement base,
		Collection<UnicaseModelElement> elements) {
		boolean useAssigneeRecommendation = org.unicase.ui.common.Activator.getDefault().getPreferenceStore()
			.getBoolean(UnicasePreferenceConstants.ENABLE_ASSIGNEE_RECOMMENDATION);
		if (!useAssigneeRecommendation) {
			return new HashMap<UnicaseModelElement, Double>();
		}
		Collection<OrgUnit> assignees = new ArrayList<OrgUnit>();
		for (UnicaseModelElement me : elements) {
			if (me instanceof OrgUnit) {
				assignees.add((OrgUnit) me);
			}
		}
		if (SIMPLE_RECOMMENDER) {
			return new SimpleAssigneeRecommender().getMatchingMap((WorkItem) base, assignees);
		} else {
			return new MLAssigneeRecommender().getMatchingMap((WorkItem) base, assignees);
		}
	}

	public String getName() {
		if (SIMPLE_RECOMMENDER) {
			return "SimpleAssigneeRecommender";
		} else {
			return "MLAssigneeRecommender";
		}
	}

	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		return null;
	}
}
