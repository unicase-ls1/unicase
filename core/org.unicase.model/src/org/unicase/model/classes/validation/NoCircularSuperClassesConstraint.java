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
import org.unicase.model.classes.Class;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Check whether the inheritance relationship is circular.
 * 
 * @author herrmama
 */
public class NoCircularSuperClassesConstraint extends AbstractModelConstraint {

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
			if (eObj instanceof Class) {
				Class c = (Class) eObj;
				if (isCircular(c)) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(c,
						"superClasses");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] {});
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	private boolean isCircular(Class c) {
		for (Class s : ClassesHelper.getAllSuperClasses(c)) {
			if (s.getSuperClasses().contains(c)) {
				return true;
			}
		}
		return false;
	}
}
