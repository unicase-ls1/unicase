/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.unicase.linkrecommendation.TDFrequencyMatrix;
import org.unicase.model.ModelElement;

/**
 * @author henning
 */
public class VectorSpaceModelStrategy implements RecommendationStrategy {

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

		TDFrequencyMatrix tdf = new TDFrequencyMatrix();
		// add the target element's words
		tdf.addWordsToDictionaries(getMEsText(base));
		// create list of possible words
		for (ModelElement me : elements) {
			// add the target element's words
			tdf.addWordsToDictionaries(getMEsText(me));
		}

		// create an index for every word (for tfmatrix)
		tdf.createIndices();

		// create term frequency matrix
		tdf.createTDFMatrix();

		// normalize numbers
		tdf.normalizeDocuments();

		// idf
		tdf.transformIDF();

		// determine values
		int indexBase = tdf.getDocumentIndex(getMEsText(base));
		for (ModelElement me : elements) {
			int indexElements = tdf.getDocumentIndex(getMEsText(me));
			double value = tdf.dotProduct(indexBase, indexElements);
			// cos
			hm.put(me, value);
		}
		return hm;
	}

	private String getMEsText(ModelElement me) {
		return me.getName() + " " + me.getDescriptionPlainText();
	}

}
