/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.recommendation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Henning Femmer
 */
public class ConstantThresholdSelection implements LinkSelectionStrategy {

	private double threshold;

	/**
	 * The constructor.
	 * 
	 * @param threshold the threshold
	 */
	public ConstantThresholdSelection(double threshold) {
		this.threshold = threshold;
	}

	/**
	 * This method returns a Map with all Elements over a constant threshold handed over in the constructor.
	 * 
	 * @param selectionMap the map indicating the probabilities of each element.
	 * @return the resulting map
	 */
	public Map<EObject, Double> selectCandidates(Map<EObject, Double> selectionMap) {
		Map<EObject, Double> result = new HashMap<EObject, Double>();

		if (selectionMap != null) {
			for (EObject me : selectionMap.keySet()) {
				Double val = selectionMap.get(me);
				if (val != null && val > threshold) {
					result.put(me, val);
				}
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.recommendation.LinkSelectionStrategy#getName()
	 */
	public String getName() {
		return "T=" + threshold;
	}
}
