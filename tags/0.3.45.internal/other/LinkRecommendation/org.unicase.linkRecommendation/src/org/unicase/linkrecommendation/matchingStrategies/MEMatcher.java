/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.matchingStrategies;

import org.unicase.model.ModelElement;

/**
 * @author henning
 */
public interface MEMatcher {
	/**
	 * This method matches relevace between two elements on an scale [0..1].
	 * 
	 * @param m1 first element
	 * @param m2 second element
	 * @return a double in [0..1]
	 */
	double getMatchingValue(ModelElement m1, ModelElement m2);
}