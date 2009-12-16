/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.matchingStrategies;

import org.unicase.model.ModelElement;

/**
 * This method tries to match the similarity of the length of elements.
 * 
 * @author Henning Femmer
 */
public class NameLengthMatcher implements MEMatcher {

	/**
	 * This method compares the length ob ModelElement name. Equal length returns 1 less equal returns smaller value.
	 * 
	 * @param m1 ModelElement to compare
	 * @param m2 ModelElement to compare with
	 * @return a value in (0..1] where 1 is equal.
	 * @see org.unicase.linkrecommendation.matchingStrategies.MEMatcher#getMatchingValue(org.unicase.model.ModelElement,
	 *      org.unicase.model.ModelElement)
	 */
	public double getMatchingValue(ModelElement m1, final ModelElement m2) {
		if (m1 != null && m2 != null && m1.getName() != null && m2.getName() != null) {
			double val = Math.abs(m1.getName().length() - m2.getName().length());
			if (val != 0) {
				val = 1 / val;
			} else {
				val = 1;
			}
			return val;
		} else {
			return 0;
		}
	}

}
