/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.recommendation.RecommendationStrategy;

/**
 * Recommends a link based on the previous read history based on Association Rule Mining.
 * 
 * @author koegel
 */
public class ARMStrategy implements RecommendationStrategy, Updateable {

	private static final String ARM_STRATEGY = "ARM Strategy";
	private Map<String, Double> linkCountMap;
	private int numberUpdates;

	/**
	 * Default Constructor.
	 */
	public ARMStrategy() {
		linkCountMap = new HashMap<String, Double>();
		numberUpdates = 0;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.traceabilityrecommendation.RecommendationStrategy#getMatchingMap(org.unicase.model.ModelElement,
	 *      java.util.Collection)
	 */
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		Map<ModelElement, Double> result = new HashMap<ModelElement, Double>();
		String sourceId = base.getIdentifier();
		double totalLinkCount = 0;
		for (ModelElement linkTarget : elements) {
			Double linkCount = linkCountMap.get(sourceId + linkTarget.getIdentifier());
			if (linkCount == null) {
				linkCount = new Double(0);
			} else {
				result.put(linkTarget, linkCount);
			}
			totalLinkCount += linkCount.doubleValue();
		}
		if (totalLinkCount != 0) {
			for (ModelElement targetElement : result.keySet()) {
				result.put(targetElement, new Double(result.get(targetElement).doubleValue() / totalLinkCount));
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.traceabilityrecommendation.RecommendationStrategy#getName()
	 */
	public String getName() {
		return ARM_STRATEGY;
	}

	/**
	 * Calls the update method for every single changePackage transmitted.
	 * 
	 * @param changePackages the change packages
	 */
	public void updateStrategyData(Collection<ChangePackage> changePackages) {
		for (ChangePackage cp : changePackages) {
			updateStrategyData(cp);
		}
	}

	/**
	 * Updates the data of the strategy with a new ProjectAnalysisData object.
	 * 
	 * @param changePackage the new data
	 */
	public void updateStrategyData(ChangePackage changePackage) {
		List<AbstractOperation> leafOperations = changePackage.getLeafOperations();
		for (int i = 0; i < leafOperations.size(); i++) {

			ModelElementId sourceElementId = leafOperations.get(i).getModelElementId();
			ModelElementId targetElementId;

			for (int j = i + 1; j < leafOperations.size(); j++) {

				// for (int offset = 1; offset < 11; offset++) {
				// if (i + offset < leafOperations.size()) {
				// targetElementId = leafOperations.get(i + offset).getModelElementId();
				targetElementId = leafOperations.get(j).getModelElementId();

				updateCount(sourceElementId.getId() + targetElementId.getId());
				updateCount(targetElementId.getId() + sourceElementId.getId());
				// } else {
				// break;
				// }
				// }
			}
		}

		// System.out.println(numberUpdates);

	}

	/**
	 * @param key
	 */
	private void updateCount(String key) {
		numberUpdates++;
		Double linkCount = linkCountMap.get(key);
		if (linkCount == null) {
			linkCountMap.put(key, new Double(1));
		} else {
			linkCountMap.put(key, new Double(linkCount.doubleValue() + 1));
		}
	}

}
