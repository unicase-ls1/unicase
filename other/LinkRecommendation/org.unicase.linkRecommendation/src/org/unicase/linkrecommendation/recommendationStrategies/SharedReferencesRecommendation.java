/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.unicase.model.ModelElement;

/**
 * This strategy analyzes the creation dates and other static data of an element.
 * 
 * @author Henning Femmer
 */
public class SharedReferencesRecommendation implements RecommendationStrategy {

	private int depth = 1;

	/**
	 * The constructor.
	 * 
	 * @param depth the depth of search.
	 */
	public SharedReferencesRecommendation(int depth) {
		this.depth = depth;
	}

	/**
	 * This methods checks the links of the elements and searches for equalities, thus creating some kind of context an
	 * element is in.
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (ModelElement,Double)
	 */
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		Map<ModelElement, Double> result = new HashMap<ModelElement, Double>();
		double max = 1;

		/* CHANGE: ITERATE BASE AS WELL */
		Set<ModelElement> baseRelated = base.getLinkedModelElements();
		Collection<ModelElement> modelsToAdd = new LinkedList<ModelElement>();
		baseRelated.add(base);
		for (int i = 0; i < depth; i++) {
			for (ModelElement subElement : baseRelated) {
				modelsToAdd.addAll(subElement.getLinkedModelElements());
			}
			baseRelated.addAll(modelsToAdd);
		}

		for (ModelElement me : elements) {
			// get all elements
			Set<ModelElement> meRelated = new HashSet<ModelElement>();
			modelsToAdd = new LinkedList<ModelElement>();
			meRelated.add(me);
			for (int i = 0; i < depth; i++) {
				for (ModelElement subElement : meRelated) {
					modelsToAdd.addAll(subElement.getLinkedModelElements());
				}
				meRelated.addAll(modelsToAdd);
			}

			// find the number of common elements
			double common = countCommonElements(baseRelated, meRelated);
			result.put(me, common);
			// calc the maximum
			if (common > max) {
				max = common;
			}
		}

		// normalize results
		for (ModelElement element : elements) {
			double val = result.get(element);
			val /= max;
			result.put(element, val);
		}

		return result;
	}

	private int countCommonElements(Set<? extends Object> baseRelated, Set<? extends Object> meRelated) {
		int count = 0;

		// This flips elements if a is bigger than be -> A is always smaller than B
		if (baseRelated.size() > meRelated.size()) {
			return countCommonElements(meRelated, baseRelated);
		}

		for (Object aRelated : baseRelated) {
			if (meRelated.contains(aRelated)) {
				count++;
			}
		}

		return count;
	}

	/**
	 * Returns "DRS".
	 * 
	 * @return DRS
	 * @see org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy#getName()
	 */
	public String getName() {
		return "SRR(Depth=" + depth + ")";
	}

}
