/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.linkrecommendation.recommendationStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.unicase.linkrecommendation.matchingStrategies.MEMatcher;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.recommendation.RecommendationStrategy;

/**
 * This class creates stands for a RecommendationStategy, that collects different strategies and returns the arithmetic
 * mean of the values.
 * 
 * @deprecated
 * @author Henning Femmer
 */
@Deprecated
public abstract class AbstractRecommendationStrategy implements RecommendationStrategy {
	private Collection<MEMatcher> matchers;
	private double threshold;

	/**
	 * The constructor.
	 * 
	 * @param threshold the initial threshold
	 */
	public AbstractRecommendationStrategy(double threshold) {
		matchers = new TreeSet<MEMatcher>();
		this.threshold = threshold;
	}

	/**
	 * Adds a matcher.
	 * 
	 * @param matchingStrategy the strategy
	 */
	public void addMEMatcher(MEMatcher matchingStrategy) {
		matchers.add(matchingStrategy);
	}

	/**
	 * Removes a matcher.
	 * 
	 * @param matchingStrategy the strategy
	 * @return true if successfull, false otherwise
	 */
	public boolean removeMEMatcher(MEMatcher matchingStrategy) {
		return matchers.remove(matchingStrategy);
	}

	/**
	 * Sets the threshold.
	 * 
	 * @param threshold the new threshold
	 */
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	/**
	 * Gets the threshold.
	 * 
	 * @return the threshold
	 */
	public double getThreshold() {
		return threshold;
	}

	/**
	 * This method calculates the arithmetic average of all results of the managers matchingStrategies and returns a
	 * hashmap of all values above the threshold.
	 * 
	 * @param base The UnicaseModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (ModelElement,Double)
	 */
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		HashMap<ModelElement, Double> hm = new HashMap<ModelElement, Double>(elements.size());
		double csLength = matchers.size();

		if (csLength > 0) {
			for (ModelElement me : elements) {
				double sum = 0;

				for (MEMatcher cs : matchers) {
					sum += cs.getMatchingValue(base, me);
				}
				sum /= csLength;

				if (sum / csLength >= threshold) {
					hm.put(me, sum);
				}
			}
		}

		return hm;
	}
}
