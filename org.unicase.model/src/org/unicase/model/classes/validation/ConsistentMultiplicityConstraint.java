/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
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
import org.unicase.model.classes.Association;
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
			if (eObj instanceof Association) {
				Association association = (Association) eObj;
				String sourceMultiplicityString = association.getSourceMultiplicity();
				String targetMultiplicityString = association.getTargetMultiplicity();

				MultiplicityParseResult sourceMultiplicity = ClassesHelper.parseMultiplicity(sourceMultiplicityString);
				MultiplicityParseResult targetMultiplicity = ClassesHelper.parseMultiplicity(targetMultiplicityString);
				boolean sourceValid = sourceMultiplicity.getMinimumMultiplicity() <= sourceMultiplicity
					.getMaximumMultiplicity() || sourceMultiplicity.getMaximumMultiplicity() == -1;
				boolean targetValid = targetMultiplicity.getMinimumMultiplicity() <= targetMultiplicity
					.getMaximumMultiplicity() || sourceMultiplicity.getMaximumMultiplicity() == -1;
				if (!sourceValid) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						association, "sourceMultiplicity");
					ctx.addResult(errorFeature);
				}
				if (!targetValid) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						association, "targetMultiplicity");
					ctx.addResult(errorFeature);
				}
				if (!targetValid || !sourceValid) {
					return ctx.createFailureStatus(new Object[] {});
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
