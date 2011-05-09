/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.unicase.model.classes.ClassesPackage;

/**
 * Checks whether the target of an association is set.
 * 
 * @author herrmama
 */
public class AssociationTargetSetConstraint extends FeatureSetConstraintBase {

	/**
	 * Constructor.
	 */
	public AssociationTargetSetConstraint() {
		super(ClassesPackage.Literals.ASSOCIATION__TARGET);
	}

}
