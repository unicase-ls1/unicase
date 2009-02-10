/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.ModelElement;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether the name starts with a number.
 * 
 * @author hoecht
 */
public class ModelElementNameConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof ModelElement) {

				ModelElement me = (ModelElement) eObj;
				if (startsWithANumber(me.getName())) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(ModelElement) eObj, "name");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((ModelElement) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	private boolean startsWithANumber(String string) {
		if (string == null) {
			return false;
		}
		for (int i = 1; i <= 9; i++) {
			if (string.startsWith(String.valueOf(i))) {
				return true;
			}
		}

		return false;
	}

}
