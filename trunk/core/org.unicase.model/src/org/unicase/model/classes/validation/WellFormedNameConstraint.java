/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether the name of an element from the implementation model is a well-formed Java identifier.
 * 
 * @author herrmama
 */
public class WellFormedNameConstraint extends AbstractModelConstraint {

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
			if (eObj instanceof UnicaseModelElement) {
				UnicaseModelElement element = (UnicaseModelElement) eObj;
				String name = element.getName();
				if (!isWellFormed(name)) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						element, "name");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { "'" + name + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Checks whether a name is a well-formed Java identifier.
	 */
	private boolean isWellFormed(String name) {
		boolean result = false;
		if (name != null) {
			int length = name.length();
			if (length > 0 && Character.isJavaIdentifierStart(name.codePointAt(0))) {
				result = true;
				for (int i = Character.offsetByCodePoints(name, 0, 1); i < length; i = Character.offsetByCodePoints(
					name, i, 1)) {
					if (!Character.isJavaIdentifierPart(name.codePointAt(i))) {
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}
}
