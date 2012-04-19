/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import java.util.Arrays;

import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Enumeration;

/**
 * Checks whether a literal has a unique name within its parent enumeration.
 * 
 * @author herrmama
 */
public class UniqueLiteralNameConstraint extends UniqueNameConstraintBase<Enumeration> {

	/**
	 * Constructor.
	 */
	public UniqueLiteralNameConstraint() {
		super(ClassesPackage.Literals.LITERAL__ENUMERATION, Arrays
			.asList(ClassesPackage.Literals.ENUMERATION__LITERALS));
	}

}
