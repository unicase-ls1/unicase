/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.linkrecommendation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.unicase.linkrecommendation.recommendationStrategies.LSIStrategy;
import org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy;
import org.unicase.model.ModelElement;

/**
 * This class is used as a singleton for providing link recommendation.
 * 
 * @author Henning Femmer
 */
public class RecommendationManager {

	private static RecommendationManager singleton = new RecommendationManager();

	/**
	 * The singleton.
	 * 
	 * @return the singleton
	 */
	public static RecommendationManager getInstance() {
		return singleton;
	}

	/**
	 * Returns a recommendationStrategy to the specified type.
	 * 
	 * @return a recommendationStrategy to the specified type
	 */
	public RecommendationStrategy createRecommendationStrategy() {
		return new LSIStrategy();
		// return new VectorSpaceModelStrategy();
	}

	/**
	 * Calculates the relevance of all elements to the base and returns these values.
	 * 
	 * @param base the element which is going to be the reference.
	 * @param elements all elements to be mapped
	 * @return a map modelElement -> double value reference. The higher the better. Value should be in (0..1]
	 */
	public Map<ModelElement, Double> getMatchMap(final ModelElement base, final Collection<ModelElement> elements) {
		RecommendationStrategy strategy = createRecommendationStrategy();

		if (strategy != null) {
			return strategy.getMatchingMap(base, elements);
		}

		return new HashMap<ModelElement, Double>();
	}
}
