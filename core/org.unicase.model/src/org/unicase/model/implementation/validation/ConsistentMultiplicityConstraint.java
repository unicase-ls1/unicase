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
 * Checks whether minimum and maximum multiplicity of a feature are consistent.
 * 
 * @author herrmama
 */
public class ConsistentMultiplicityConstraint extends AbstractModelConstraint {

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
				int minimumMultiplicity = feature.getMinimumMultiplicity();
				int maximumMultiplicity = feature.getMaximumMultiplicity();
				boolean valid = minimumMultiplicity <= maximumMultiplicity
					|| maximumMultiplicity == -1;
				if (!valid) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						feature, "minimumMultiplicity");
					ctx.addResult(errorFeature);
					errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(feature,
						"maximumMultiplicity");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { minimumMultiplicity,
						maximumMultiplicity });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
