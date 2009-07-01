/**
 * <copyright> Copyright (c) 2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.linkrecommendation.recommendationStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.unicase.linkrecommendation.matchingStrategies.MEMatcher;
import org.unicase.model.ModelElement;

public abstract class AbstractRecommendationStrategy {
	Collection<MEMatcher> comparators;
	double threshold;

	public AbstractRecommendationStrategy(double threshold) {
		comparators = new TreeSet<MEMatcher>();
		this.threshold = threshold;
	}

	public void addMEComparator(MEMatcher comparatorStrategy) {
		comparators.add(comparatorStrategy);
	}

	public boolean removeMEComparator(MEMatcher comparatorStrategy) {
		return comparators.remove(comparatorStrategy);
	}

	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	public double getThreshold() {
		return threshold;
	}

	/**
	 * This method calculates the arithmetic average of all results of the managers matchingStrategies and returns a
	 * hashmap of all values above the threshold.
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (ModelElement,Double)
	 */
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		HashMap<ModelElement, Double> hm = new HashMap<ModelElement, Double>(elements.size());
		double csLength = comparators.size();

		try {
			for (ModelElement me : elements) {
				double sum = 0;

				for (MEMatcher cs : comparators) {
					sum += cs.getMatchingValue(base, me);
				}
				sum /= csLength;

				if (sum / csLength >= threshold) {
					hm.put(me, sum);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hm;
	}
}
