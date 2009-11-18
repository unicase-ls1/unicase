/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.validation;

import org.unicase.model.implementation.ImplementationPackage;

/**
 * Checks whether a reference has a unique name within its parent class.
 * 
 * @author herrmama
 */
public class UniqueReferenceNameConstraint extends UniqueFeatureNameConstraintBase {

	/**
	 * Constructor.
	 */
	public UniqueReferenceNameConstraint() {
		super(ImplementationPackage.Literals.IREFERENCE__PARENT_CLASS);
	}

}
