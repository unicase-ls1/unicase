/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.unicase.model.classes.ClassesPackage;

/**
 * Checks whether the source role of an association is unique within its parent class.
 * 
 * @author herrmama
 */
public class UniqueAssociationSourceRoleConstraint extends UniqueFeatureNameConstraintBase {

	/**
	 * Constructor.
	 */
	public UniqueAssociationSourceRoleConstraint() {
		super(ClassesPackage.Literals.ASSOCIATION__TARGET, ClassesPackage.Literals.ASSOCIATION__SOURCE_ROLE);
	}

}
