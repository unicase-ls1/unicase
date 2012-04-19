/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.unicase.model.ModelPackage;
import org.unicase.model.classes.ClassesPackage;

/**
 * Checks whether the name of an attribute is unique within its parent class.
 * 
 * @author herrmama
 */
public class UniqueAttributeNameConstraint extends UniqueFeatureNameConstraintBase {

	/**
	 * Constructor.
	 */
	public UniqueAttributeNameConstraint() {
		super(ClassesPackage.Literals.ATTRIBUTE__DEFINING_CLASS, ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME);
	}

}
