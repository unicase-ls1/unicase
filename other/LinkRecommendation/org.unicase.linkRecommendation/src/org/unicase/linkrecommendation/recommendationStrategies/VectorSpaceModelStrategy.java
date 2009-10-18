/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.unicase.linkrecommendation.RecUtils;
import org.unicase.linkrecommendation.TDFrequencyMatrix;
import org.unicase.model.ModelElement;
import org.unicase.model.util.traceabilityrecommendation.RecommendationStrategy;

/**
 * @author Henning Femmer
 */
public class VectorSpaceModelStrategy implements RecommendationStrategy {

	/**
	 * This method returns value pairs (ModelElement, Double) which indicate how probable a certain element might be
	 * linked.
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (ModelElement,Double)
	 */
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		HashMap<ModelElement, Double> hm = new HashMap<ModelElement, Double>(elements.size());
		Map<ModelElement, Integer> indices = new HashMap<ModelElement, Integer>();

		TDFrequencyMatrix tdf = new TDFrequencyMatrix();
		// add the target element's words
		int index = tdf.addWordsToDictionaries(RecUtils.getMEsText(base));
		indices.put(base, index);
		// create list of possible words
		for (ModelElement me : elements) {
			// add the target element's words
			index = tdf.addWordsToDictionaries(RecUtils.getMEsText(me));
			indices.put(me, index);
		}

		// create term frequency matrix
		tdf.createTDFMatrix();

		// normalize numbers
		tdf.normalizeDocuments();

		// idf
		tdf.transformIDF();

		// System.out.println(tdf);

		int indexBase = indices.get(base);
		// determine values
		for (ModelElement me : elements) {
			int indexElement = indices.get(me);
			double value = tdf.cos(indexBase, indexElement);
			if (Double.valueOf(value).equals(Double.NaN)) {
				value = 0;
			}
			hm.put(me, value);
		}
		return hm;
	}

	/**
	 * Returns the name of this strategy for output reasons.
	 * 
	 * @return the name
	 */
	public String getName() {
		return "VSM";
	}

}
