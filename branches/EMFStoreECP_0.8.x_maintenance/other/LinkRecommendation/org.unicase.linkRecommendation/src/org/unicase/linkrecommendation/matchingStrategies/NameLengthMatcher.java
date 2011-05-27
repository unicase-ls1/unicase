/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendation.matchingStrategies;

import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;

/**
 * This method tries to match the similarity of the length of elements.
 * 
 * @author Henning Femmer
 * @deprecated
 */
@Deprecated
public class NameLengthMatcher implements MEMatcher {

	/**
	 * This method compares the length ob UnicaseModelElement name. Equal length returns 1 less equal returns smaller
	 * value.
	 * 
	 * @param m1 UnicaseModelElement to compare
	 * @param m2 UnicaseModelElement to compare with
	 * @return a value in (0..1] where 1 is equal.
	 * @see org.unicase.linkrecommendation.matchingStrategies.MEMatcher#getMatchingValue(org.unicase.model.UnicaseModelElement,
	 *      org.unicase.model.UnicaseModelElement)
	 */
	public double getMatchingValue(ModelElement m1, final ModelElement m2) {
		UnicaseModelElement um1 = null, um2 = null;
		if (m1 instanceof UnicaseModelElement && m2 instanceof UnicaseModelElement) {
			um1 = (UnicaseModelElement) m1;
			um2 = (UnicaseModelElement) m2;
		}

		if (um1 != null && um2 != null && um1.getName() != null && um2.getName() != null) {
			double val = Math.abs(um1.getName().length() - um2.getName().length());
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
