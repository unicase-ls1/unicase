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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.recommendation.RecommendationStrategy;

/**
 * This strategy analyzes the creation dates and other static data of an element.
 * 
 * @author Henning Femmer
 */
public class SharedReferencesRecommendation implements RecommendationStrategy {

	private EReference correctReference;
	private boolean ignoreMEs;
	private int maxNumber = 50;

	/**
	 * This is the constructor for number based recommendation.
	 * 
	 * @param maxNumber the maximum number
	 */
	public SharedReferencesRecommendation(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	/**
	 * The constructor for evaluation. Don't use it for runtime suggestions. ;)
	 * 
	 * @param maxNumber maximum number of elements to be counted.
	 * @param correctReference the reference to be ignored.
	 */
	public SharedReferencesRecommendation(int maxNumber, EReference correctReference) {
		this.maxNumber = maxNumber;
		this.correctReference = correctReference;

		if (correctReference != null) {
			this.ignoreMEs = true;
		} else {
			this.ignoreMEs = false;
		}
	}

	// /**
	// * The constructor for evaluation. Don't use it for runtime suggestions. ;)
	// *
	// * @param depth the depth of search
	// * @param correctReference the correct MEs, they will be subtracted
	// */
	// @Deprecated
	// public SharedReferencesRecommendation(int depth, EReference correctReference) {
	// this.depth = depth;
	// this.correctReference = correctReference;
	// this.isMax = false;
	//
	// if (correctReference != null) {
	// this.ignoreMEs = true;
	// } else {
	// this.ignoreMEs = false;
	// }
	// }

	/**
	 * This methods checks the links of the elements and searches for equalities, thus creating some kind of context an
	 * element is in.
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (ModelElement,Double)
	 */
	@SuppressWarnings("unchecked")
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		Map<ModelElement, Double> result = new HashMap<ModelElement, Double>();
		EList<ModelElement> correctMEs = null;
		double max = 1;

		// for test cases only: remove already existing relations
		if (ignoreMEs && correctReference != null && base.eGet(correctReference) instanceof EList) {
			correctMEs = (EList<ModelElement>) base.eGet(correctReference);
		}

		/* CHANGE: ITERATE BASE, size / depth */
		Set<ModelElement> baseRelated = new HashSet<ModelElement>();

		baseRelated.add(base);
		// for (int i = 0; i < depth; i++) {
		int oldVal = 0;
		while (baseRelated.size() < maxNumber && oldVal < baseRelated.size()) {
			oldVal = baseRelated.size();
			addRelatedElements(base, correctMEs, baseRelated);
		}

		for (ModelElement me : elements) {
			// get all elements
			Set<ModelElement> meRelated = new HashSet<ModelElement>();
			meRelated.add(me);
			// for (int i = 0; i < depth; i++) {
			oldVal = 0;
			while (oldVal < meRelated.size() && meRelated.size() < maxNumber) {
				oldVal = meRelated.size();
				addRelatedElements(base, correctMEs, meRelated);
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

	/**
	 * If certain elements are to be ignored they are removed.
	 * 
	 * @param base the base
	 * @param correctMEs the correctMEs to be ignored
	 * @param baseRelated the list to which correct elements are added.
	 */
	public void addRelatedElements(ModelElement base, EList<ModelElement> correctMEs, Set<ModelElement> baseRelated) {
		Collection<ModelElement> modelsToAdd = new LinkedList<ModelElement>();
		for (ModelElement subElement : baseRelated) {
			Collection<ModelElement> newMEs = subElement.getLinkedModelElements();
			if (correctMEs != null && correctMEs.contains(subElement)) {
				newMEs.remove(base);
			} else if (correctMEs != null && subElement == base) {
				newMEs.removeAll(correctMEs);
			}
			modelsToAdd.addAll(newMEs);
		}
		baseRelated.addAll(modelsToAdd);
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
	 * @see org.unicase.model.util.traceabilityrecommendation.RecommendationStrategy#getName()
	 */
	public String getName() {
		return "SRR(Max=" + this.maxNumber + ")";
	}

}
