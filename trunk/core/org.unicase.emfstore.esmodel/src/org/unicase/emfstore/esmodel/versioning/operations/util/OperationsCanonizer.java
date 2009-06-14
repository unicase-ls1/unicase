/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.emfstore.esmodel.versioning.operations.util;

import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Canonizes a list of operations. Removes all operations that are not necessary to achieve the same result when the
 * list of operations is applied to a project. Contract: project.apply(opList) = project.apply(cannonizedOpList)
 * 
 * @author koegel
 */
public final class OperationsCanonizer {

	/**
	 * Private constructor.
	 */
	private OperationsCanonizer() {
		// do nothing
	}

	/**
	 * Canonize the operation list.
	 * 
	 * @param operations a list of operations (the list is order by creation time)
	 */
	public static void canonize(List<AbstractOperation> operations) {
		// not doing anything, for the time being
	}

}
