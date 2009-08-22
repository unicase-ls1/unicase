/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.TraceEvent;
import org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;

/**
 * Recommends a link based on the previous read history based on Association Rule Mining.
 * 
 * @author koegel
 */
public class ARMStrategy implements RecommendationStrategy, Updateable {

	private static final String ARM_STRATEGY = "ARM Strategy";
	private Map<String, Double> linkCountMap;

	/**
	 * Default Constructor.
	 */
	public ARMStrategy() {
		linkCountMap = new HashMap<String, Double>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy#getMatchingMap(org.unicase.model.ModelElement,
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
			}
			result.put(linkTarget, linkCount);
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
	 * @see org.unicase.linkrecommendation.recommendationStrategies.RecommendationStrategy#getName()
	 */
	public String getName() {
		return ARM_STRATEGY;
	}

	/**
	 * Updates the data of the strategy with a new ProjectAnalysisData object.
	 * 
	 * @param cp the new data
	 */
	public void updateStrategyData(Collection<ChangePackage> cp) {
		for (ChangePackage changePackage : cp) {
			for (Event event : changePackage.getEvents()) {
				if (event instanceof TraceEvent) {
					TraceEvent traceEvent = (TraceEvent) event;
					ModelElementId sourceElementId = traceEvent.getSourceElement();
					ModelElementId targetElementId = traceEvent.getTargetElement();
					String key = sourceElementId.getId() + targetElementId.getId();
					Double linkCount = linkCountMap.get(key);
					if (linkCount == null) {
						linkCountMap.put(key, new Double(1));
					} else {
						linkCountMap.put(key, new Double(linkCount.doubleValue() + 1));
					}
				}
			}
		}
	}

}
