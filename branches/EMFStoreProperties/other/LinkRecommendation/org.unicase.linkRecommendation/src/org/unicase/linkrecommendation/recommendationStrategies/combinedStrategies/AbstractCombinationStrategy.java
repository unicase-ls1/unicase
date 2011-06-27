/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies.combinedStrategies;

import java.util.Collection;
import java.util.Map;

import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies.Updateable;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.recommendation.RecommendationStrategy;

/**
 * This strategy tries to combine different strategies.
 * 
 * @author Henning Femmer
 */
public abstract class AbstractCombinationStrategy implements RecommendationStrategy, Updateable {

	private RecommendationStrategy strategy1, strategy2;

	/**
	 * The constructor.
	 * 
	 * @param s1 the first strategy to combine
	 * @param s2 the second strategy to combine
	 */
	public AbstractCombinationStrategy(RecommendationStrategy s1, RecommendationStrategy s2) {
		this.strategy1 = s1;
		this.strategy2 = s2;
	}

	/**
	 * This method returns the result of the combination method. To change combination strategy overwrite the method
	 * combine().
	 * 
	 * @param base The ModelElement which is compared to the rest
	 * @param elements The potential elements linked to the base
	 * @return a Map (ModelElement,Double)
	 */
	public Map<ModelElement, Double> getMatchingMap(ModelElement base, Collection<ModelElement> elements) {
		Map<ModelElement, Double> map1 = strategy1.getMatchingMap(base, elements);
		Map<ModelElement, Double> map2 = strategy2.getMatchingMap(base, elements);
		Map<ModelElement, Double> result = combine(map1, map2);
		return result;
	}

	/**
	 * This method returns the result of combining the results of strategies.
	 * 
	 * @param map1 the first map
	 * @param map2 the second map
	 * @return the result
	 */
	public abstract Map<ModelElement, Double> combine(Map<ModelElement, Double> map1, Map<ModelElement, Double> map2);

	/**
	 * Name of this strategy.
	 * 
	 * @return names of both sub-strategies
	 * @see org.unicase.model.util.traceabilityrecommendation.RecommendationStrategy#getName()
	 */
	public String getName() {
		return strategy1.getName() + "+" + strategy2.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.linkrecommendation.recommendationStrategies.updateableStrategies.Updateable#updateStrategyData(java.util.Collection)
	 */
	public void updateStrategyData(ChangePackage cp) {
		if (strategy1 instanceof Updateable) {
			((Updateable) strategy1).updateStrategyData(cp);
		}
		if (strategy2 instanceof Updateable) {
			((Updateable) strategy2).updateStrategyData(cp);
		}
	}
}
