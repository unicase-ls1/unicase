/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.organization.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.User;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * @author pfeifferc
 */
public class UserMissingLastName extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext context) {
		EObject eObject = context.getTarget();
		EMFEventType eventType = context.getEventType();

		if (eventType != EMFEventType.NULL || !(eObject instanceof User)) {
			return context.createSuccessStatus();
		}
		User user = (User) eObject;
		if (user.getLastName() == null || user.getLastName().equals("")) {
			EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
				(UnicaseModelElement) eObject, "lastName");
			context.addResult(errorFeature);
			return context.createFailureStatus(new Object[] { eObject.eClass().getName() + ": '"
				+ eObject.eClass().getName() + "'" });
		} else {
			return context.createSuccessStatus();
		}
	}
}
