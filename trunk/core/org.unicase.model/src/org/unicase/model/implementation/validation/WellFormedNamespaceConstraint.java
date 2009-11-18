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
import org.unicase.model.implementation.IPackage;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether the namespace of the package is well formed.
 * 
 * @author herrmama
 */
public class WellFormedNamespaceConstraint extends AbstractModelConstraint {

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
			if (eObj instanceof IPackage) {
				IPackage element = (IPackage) eObj;
				String namespace = element.getNamespace();
				if (!isWellFormed(namespace)) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						element, "namespace");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { "'" + namespace + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Checks whether a name is a well-formed Java namespace.
	 */
	private boolean isWellFormed(String name) {
		boolean result = false;
		if (name != null) {
			int length = name.length();
			if (length > 0 && Character.isJavaIdentifierStart(name.codePointAt(0))
				&& Character.isJavaIdentifierPart(name.codePointAt(length - 1))) {
				result = true;
				for (int i = Character.offsetByCodePoints(name, 0, 1); i < length; i = Character.offsetByCodePoints(
					name, i, 1)) {
					if (name.codePointAt(i) != '.' && !Character.isJavaIdentifierPart(name.codePointAt(i))) {
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}
}
