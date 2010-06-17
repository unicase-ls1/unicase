/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a activity is set for this ActionItem.
 * 
 * @author wesendonk
 * @author naughton
 */
public class ActionItemEmbodiesRequirementConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext context) {
		EObject eObject = context.getTarget();
		EMFEventType eventType = context.getEventType();

		if (eventType != EMFEventType.NULL || !(eObject instanceof ActionItem)) {
			return context.createSuccessStatus();
		}
		ActionItem actionItem = (ActionItem) eObject;
		if (actionItem.isDone() || actionItem.getActivity().equals(ActivityType.MANAGEMENT)) {
			return context.createSuccessStatus();
		}
		EList<UnicaseModelElement> annotatedModelElements = actionItem.getAnnotatedModelElements();
		for (UnicaseModelElement me : annotatedModelElements) {
			if (me instanceof FunctionalRequirement) {
				return context.createSuccessStatus();
			}
		}
		if (!containsKeywords(actionItem)) {
			return context.createSuccessStatus();
		}
		EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
			(UnicaseModelElement) eObject, "annotatedModelElements");
		context.addResult(errorFeature);
		return context.createFailureStatus(new Object[] { eObject.eClass().getName() + ": '"
			+ ((ActionItem) eObject).getName() + "'" });
	}

	private boolean containsKeywords(ActionItem actionItem) {
		if (actionItem.getName().contains("new ActionItem")) {
			return false;
		}
		String[] keywords = { "should ", "must ", "require" };
		for (String keyword : keywords) {
			if (actionItem.getName().contains(keyword)) {
				return true;
			}
		}
		return false;
	}

}
