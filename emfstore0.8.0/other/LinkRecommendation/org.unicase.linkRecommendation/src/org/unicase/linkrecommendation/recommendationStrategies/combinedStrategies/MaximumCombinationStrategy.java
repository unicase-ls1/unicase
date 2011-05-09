/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies.combinedStrategies;

import java.util.Map;

import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.recommendation.RecommendationStrategy;

/**
 * This method returns the maximum.
 * 
 * @author Henning Femmer
 */
public class MaximumCombinationStrategy extends AbstractCombinationStrategy {

	/**
	 * The constructor.
	 * 
	 * @param s1 the first strategy
	 * @param s2 the second strategy
	 */
	public MaximumCombinationStrategy(RecommendationStrategy s1, RecommendationStrategy s2) {
		super(s1, s2);
	}

	/**
	 * This method returns always the maximum of two values.
	 * 
	 * @param map1 the first result map
	 * @param map2 the second result map
	 * @return one resulting map from the two input maps
	 * @see org.unicase.linkrecommendation.recommendationStrategies.combinedStrategies.AbstractCombinationStrategy#combine(java.util.Map,
	 *      java.util.Map)
	 */
	@Override
	public Map<ModelElement, Double> combine(Map<ModelElement, Double> map1, Map<ModelElement, Double> map2) {
		for (ModelElement me : map2.keySet()) {
			Double val1 = map1.get(me);
			Double val2 = map2.get(me);

			if (val1 == null) {
				val1 = 0.0;
			}
			if (val2 == null) {
				val2 = 0.0;
			}

			map1.put(me, Math.max(val1, val2));
		}
		return map1;
	}

	/**
	 * The name.
	 * 
	 * @return name
	 * @see org.unicase.linkrecommendation.recommendationStrategies.combinedStrategies.AbstractCombinationStrategy#getName()
	 */
	@Override
	public String getName() {
		return "Max. " + super.getName();
	}
}
