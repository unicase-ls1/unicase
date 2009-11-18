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
import org.unicase.model.implementation.IFeature;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks if the minimum multiplicity of a feature is valid.
 * 
 * @author herrmama
 */
public class ValidMaximumMultiplicityConstraint extends AbstractModelConstraint {

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
			if (eObj instanceof IFeature) {
				IFeature feature = (IFeature) eObj;
				int maximumMultiplicity = feature.getMaximumMultiplicity();
				boolean valid = maximumMultiplicity >= -1;
				if (!valid) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						feature, "maximumMultiplicity");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { maximumMultiplicity });
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
