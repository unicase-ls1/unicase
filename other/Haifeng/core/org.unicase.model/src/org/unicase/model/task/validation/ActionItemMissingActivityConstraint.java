/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a activity is set for this ActionItem.
 * 
 * @author wesendonk
 * @author naughton
 */
public class ActionItemMissingActivityConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof ActionItem) {
				ActivityType activity = ((ActionItem) eObj).getActivity();
				if (activity.getValue() == ActivityType.NONE_VALUE) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(UnicaseModelElement) eObj, "activity");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((ActionItem) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
