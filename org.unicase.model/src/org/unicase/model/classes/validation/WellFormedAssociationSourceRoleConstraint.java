/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.unicase.model.classes.ClassesPackage;

/**
 * Checks whether the target role of an association from the class model is a well-formed Java identifier.
 * 
 * @author herrmama
 */
public class WellFormedAssociationSourceRoleConstraint extends WellFormedNameConstraintBase {

	/**
	 * Constructor.
	 */
	public WellFormedAssociationSourceRoleConstraint() {
		super(ClassesPackage.Literals.ASSOCIATION__TARGET_ROLE);
	}
}
