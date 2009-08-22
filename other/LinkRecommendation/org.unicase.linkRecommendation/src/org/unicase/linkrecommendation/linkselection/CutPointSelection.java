/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.linkselection;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.unicase.model.ModelElement;

/**
 * This strategy returns just the first x results, according to their ranking in the map.
 * 
 * @author Henning Femmer
 */
public class CutPointSelection implements LinkSelectionStrategy {

	private int cutPoint;

	/**
	 * The constructor.
	 * 
	 * @param cutPoint the cutPoint: this value determines how many elements are selected
	 */
	public CutPointSelection(int cutPoint) {
		this.cutPoint = cutPoint;
	}

	/**
	 * This method returns a Map with the x highest probabilities.
	 * 
	 * @param selectionMap the map indicating the probabilities of each element.
	 * @return the resulting map
	 */
	public SortedMap<ModelElement, Double> selectCandidates(Map<ModelElement, Double> selectionMap) {
		TreeMap<ModelElement, Double> result = new TreeMap<ModelElement, Double>(
			new ProbabilityComparator(selectionMap));

		// add just non-zeros
		for (ModelElement me : selectionMap.keySet()) {
			Double val = selectionMap.get(me);
			if (val != null && val > 0) {
				result.put(me, val);
			}
		}

		Object[] sortedKeyArray = result.keySet().toArray();
		if (sortedKeyArray.length > cutPoint) {
			ModelElement last = (ModelElement) sortedKeyArray[cutPoint];
			return result.headMap(last);
		} else { // less suggestions than cut point demands
			return result;
		}
	}

	/**
	 * Compares elements by their probability.
	 * 
	 * @author Henning Femmer
	 */
	class ProbabilityComparator implements java.util.Comparator<ModelElement> {

		private Map<ModelElement, Double> probabilityMap;

		/**
		 * The constructor.
		 * 
		 * @param selectionMap the map
		 */
		public ProbabilityComparator(Map<ModelElement, Double> selectionMap) {
			this.probabilityMap = selectionMap;
		}

		/**
		 * {@inheritDoc}
		 */
		public int compare(ModelElement o1, ModelElement o2) {
			return probabilityMap.get(o2).compareTo(probabilityMap.get(o1));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.linkrecommendation.linkselection.LinkSelectionStrategy#getName()
	 */
	public String getName() {
		return "CP=" + this.cutPoint;
	}
}
