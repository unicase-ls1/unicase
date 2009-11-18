/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.validation;

import java.util.Arrays;

import org.unicase.model.implementation.IPackage;
import org.unicase.model.implementation.ImplementationPackage;

/**
 * Checks whether an enumeration has a unique name within its parent package.
 * 
 * @author herrmama
 */
public class UniqueEnumerationNameConstraint extends UniqueNameConstraintBase<IPackage> {

	/**
	 * Constructor.
	 */
	public UniqueEnumerationNameConstraint() {
		super(ImplementationPackage.Literals.IENUMERATION__PARENT_PACKAGE, Arrays.asList(
			ImplementationPackage.Literals.IPACKAGE__CLASSES, ImplementationPackage.Literals.IPACKAGE__ENUMERATIONS));
	}
}
