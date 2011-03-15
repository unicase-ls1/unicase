/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

/**
 * Abstract helper class to create constraints for EMF validation. Sub classes should implement.
 * 
 * @author helming
 */
public abstract class AbstractConstraint extends AbstractModelConstraint {
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
			Set<EStructuralFeature> errorFeatures = new HashSet<EStructuralFeature>();
			validate(eObj, errorFeatures);
			if (errorFeatures.isEmpty()) {
				return ctx.createSuccessStatus();
			} else {
				for (EStructuralFeature feature : errorFeatures) {
					ctx.addResult(feature);
				}
				return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() });
			}
		}
		return ctx.createSuccessStatus();

	}

	/**
	 * Validates an eobject and return a list of error features. Erro features cause a violation.
	 * 
	 * @param eObj the object to be validated.
	 * @param errorFeatures an empty list to be filled.
	 * @return a list of error features or an empty list, if there are no violations.
	 */
	protected abstract Set<EStructuralFeature> validate(EObject eObj, Set<EStructuralFeature> errorFeatures);

}
