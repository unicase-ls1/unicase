/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.Issue;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a activity is set for this ActionItem.
 * 
 * @author wesendonk
 * @author naughton
 */
public class DiscussionShouldBeIssueConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext context) {
		EObject eObject = context.getTarget();
		EMFEventType eventType = context.getEventType();

		if (eventType != EMFEventType.NULL || eObject instanceof Comment || eObject instanceof Issue) {
			return context.createSuccessStatus();
		}

		int count = 0;
		for (EObject element : ModelUtil.getAllContainedModelElements(eObject, false)) {
			if (element instanceof Comment) {
				count += ModelUtil.getAllContainedModelElements(element, false).size();
				count++;
			}
		}
		if (count > 6) {
			EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
				(UnicaseModelElement) eObject, "comments");
			context.addResult(errorFeature);
			return context.createFailureStatus(new Object[] { eObject.eClass().getName() + ": '"
				+ eObject.eClass().getName() + "'" });
		}
		return context.createSuccessStatus();

	}
}
