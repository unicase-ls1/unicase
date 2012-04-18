/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import java.util.Arrays;

import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Package;

/**
 * Checks whether a class has a unique name within its parent package.
 * 
 * @author herrmama
 */
public class UniquePackageElementNameConstraint extends UniqueNameConstraintBase<Package> {

	/**
	 * Constructor.
	 */
	public UniquePackageElementNameConstraint() {
		super(ClassesPackage.Literals.PACKAGE_ELEMENT__PARENT_PACKAGE, Arrays
			.asList(ClassesPackage.Literals.PACKAGE__CONTAINED_PACKAGE_ELEMENTS));
	}

}
