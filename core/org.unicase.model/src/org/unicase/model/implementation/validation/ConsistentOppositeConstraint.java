/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.implementation.IReference;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether the opposite of the opposite is the reference itself.
 * 
 * @author herrmama
 */
public class ConsistentOppositeConstraint extends AbstractModelConstraint {

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
			if (eObj instanceof IReference) {
				IReference reference = (IReference) eObj;
				if (reference.getOppositeReference() != null
					&& reference.getOppositeReference().getOppositeReference() != reference) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						reference, "oppositeReference");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] {});
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
