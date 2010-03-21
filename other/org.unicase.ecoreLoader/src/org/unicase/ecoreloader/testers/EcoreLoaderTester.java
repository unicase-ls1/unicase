/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecoreloader.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.unicase.model.document.LeafSection;

/**
 * This property tester provides various test cases for the cut and paste operation.
 * 
 * @author weiglt
 */
public class EcoreLoaderTester extends PropertyTester {

	/**
	 * {@inheritDoc}
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if (property.equals("allowedLocation") && receiver instanceof org.eclipse.jface.viewers.TreeSelection) {

			if (((org.eclipse.jface.viewers.TreeSelection) receiver).getFirstElement() instanceof LeafSection) {
				return true;
			}
		}
		return false;
	}

}
