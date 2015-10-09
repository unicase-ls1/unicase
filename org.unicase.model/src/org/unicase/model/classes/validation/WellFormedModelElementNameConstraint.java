/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.unicase.model.ModelPackage;

/**
 * Checks whether the name of an element from the class model is a well-formed Java identifier.
 * 
 * @author herrmama
 */
public class WellFormedModelElementNameConstraint extends WellFormedNameConstraintBase {

	/**
	 * Constructor.
	 * 
	 * @param nameAttribute
	 */
	public WellFormedModelElementNameConstraint() {
		super(ModelPackage.Literals.UNICASE_MODEL_ELEMENT__NAME);
	}

}
