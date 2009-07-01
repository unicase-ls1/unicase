/**
 * <copyright> Copyright (c) 2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.linkrecommendation;

import java.util.Collection;
import java.util.Map;

import org.unicase.linkrecommendation.recommendationStrategies.AbstractRecommendationStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.NameLengthRecommendationStrategy;
import org.unicase.model.ModelElement;

public class RecommendationManager {

	private static RecommendationManager singleton = new RecommendationManager();

	public static RecommendationManager getInstance() {
		return singleton;
	}

	public AbstractRecommendationStrategy createRecommendationStrategy(String type) {
		if (type == "dummy")
			return new NameLengthRecommendationStrategy();
		else
			return null;
	}

	public Map<ModelElement, Double> getMatchMap(String type, ModelElement base, Collection<ModelElement> elements) {
		AbstractRecommendationStrategy strategy = createRecommendationStrategy(type);
		return strategy.getMatchingMap(base, elements);
	}
}
