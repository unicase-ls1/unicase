/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies.combinedStrategies;

import org.unicase.linkrecommendation.recommendationStrategies.RelatedAssigneesRecommendation;
import org.unicase.linkrecommendation.recommendationStrategies.VectorSpaceModelStrategy;

/**
 * This class is a combination of VectorSpaceModel and RelatedAssigneesRecommendation, combined with the arithmetic
 * mean.
 * 
 * @author Henning Femmer
 */
public class VsmAndRarCombinedStrategy extends FactorCombinationStrategy {

	/**
	 * The constructor.
	 */
	public VsmAndRarCombinedStrategy() {
		super(new VectorSpaceModelStrategy(), new RelatedAssigneesRecommendation(), 0.5);
	}
}
