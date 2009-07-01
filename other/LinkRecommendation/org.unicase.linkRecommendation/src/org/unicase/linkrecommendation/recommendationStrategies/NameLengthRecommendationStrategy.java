/**
 * <copyright> Copyright (c) 2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.recommendationStrategies;

import org.unicase.linkrecommendation.matchingStrategies.NameLengthMatcher;

/**
 * This Manager compares Elements by the length of the name, the more similar, the better.
 * 
 * @author henning femmer
 */
public class NameLengthRecommendationStrategy extends AbstractRecommendationStrategy {

	public NameLengthRecommendationStrategy() {
		super(0.2);
		this.addMEComparator(new NameLengthMatcher());
	}
}
