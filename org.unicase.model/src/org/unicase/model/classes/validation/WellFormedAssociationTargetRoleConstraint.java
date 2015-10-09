/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.AssociationType;
import org.unicase.model.classes.ClassesPackage;

/**
 * Checks whether the source role of an association from the class model is a well-formed Java identifier.
 * 
 * @author herrmama
 */
public class WellFormedAssociationTargetRoleConstraint extends WellFormedNameConstraintBase {

	/**
	 * Constructor.
	 */
	public WellFormedAssociationTargetRoleConstraint() {
		super(ClassesPackage.Literals.ASSOCIATION__SOURCE_ROLE);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.classes.validation.WellFormedNameConstraintBase#applies(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected boolean applies(EObject element) {
		boolean applies = super.applies(element);
		if (applies) {
			Association association = (Association) element;
			if (association.getType() == AssociationType.DIRECTED_ASSOCIATION) {
				return false;
			}
		}
		return applies;
	}
}
