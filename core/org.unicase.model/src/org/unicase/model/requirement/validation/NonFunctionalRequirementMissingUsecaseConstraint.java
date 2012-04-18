/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a nf-requirement is linked to a usecase.
 * 
 * @author wesendon
 * @author naughton
 */
public class NonFunctionalRequirementMissingUsecaseConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof NonFunctionalRequirement) {
				EList<UseCase> useCases = ((NonFunctionalRequirement) eObj).getRestrictedUseCases();
				if (useCases.size() < 1) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(UnicaseModelElement) eObj, "restrictedUseCases");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((NonFunctionalRequirement) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
