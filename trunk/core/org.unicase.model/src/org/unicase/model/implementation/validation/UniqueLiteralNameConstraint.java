/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.validation;

import java.util.Arrays;

import org.unicase.model.implementation.IEnumeration;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * Checks whether a literal has a unique name within its parent enumeration.
 * 
 * @author herrmama
 */
public class UniqueLiteralNameConstraint extends UniqueNameConstraintBase<IEnumeration> {

	/**
	 * Constructor.
	 */
	public UniqueLiteralNameConstraint() {
		super(ImplementationPackage.Literals.ILITERAL__PARENT_ENUMERATION, Arrays
			.asList(ImplementationPackage.Literals.IENUMERATION__LITERALS));
	}

}
