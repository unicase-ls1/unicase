/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

/**
 * Checks whether a feature's value of an element is a set.
 * 
 * @author herrmama
 */
public class FeatureSetConstraintBase extends AbstractModelConstraint {

	private EStructuralFeature feature;

	/**
	 * Constructor.
	 * 
	 * @param feature feature which should be set
	 */
	protected FeatureSetConstraintBase(EStructuralFeature feature) {
		this.feature = feature;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (applies(eObj)) {
				Object value = eObj.eGet(feature);
				if (value == null) {
					ctx.addResult(feature);
					return ctx.createFailureStatus(new Object[0]);
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Check whether this constraint applies to the element.
	 * 
	 * @param element Element
	 * @return true if it applies, false otherwise
	 */
	protected boolean applies(EObject element) {
		return element.eClass() == feature.getEContainingClass()
			|| element.eClass().getEAllSuperTypes().contains(feature.getEContainingClass());
	}

}
