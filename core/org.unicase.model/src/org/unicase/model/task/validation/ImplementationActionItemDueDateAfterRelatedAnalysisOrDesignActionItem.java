/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.rationale.Issue;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * This validation rules checks if there is an annotation on the annotated model element which is from the activities
 * analysis or design and has an earlier due date.
 * 
 * @author helming
 */
public class ImplementationActionItemDueDateAfterRelatedAnalysisOrDesignActionItem extends AbstractModelConstraint {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType != EMFEventType.NULL || (!(eObj instanceof ActionItem) && !(eObj instanceof Issue))) {
			return ctx.createSuccessStatus();
		}
		Annotation annotation = (Annotation) eObj;
		ActivityType activity;
		Date dueDate;
		activity = TaskValidationHelper.getActivity(annotation);
		dueDate = TaskValidationHelper.getDueDate(annotation);

		if (!activity.equals(ActivityType.IMPLEMENTATION)) {
			return ctx.createSuccessStatus();
		}
		EList<UnicaseModelElement> annotatedModelElements = annotation.getAnnotatedModelElements();
		List<Annotation> otherAnnotations = new ArrayList<Annotation>();
		for (UnicaseModelElement me : annotatedModelElements) {
			otherAnnotations.addAll(me.getAnnotations());
		}
		for (Annotation otherAnnotation : otherAnnotations) {
			if ((!(otherAnnotation instanceof ActionItem) && !(otherAnnotation instanceof Issue))) {
				continue;
			}
			ActivityType otherActivity = TaskValidationHelper.getActivity(otherAnnotation);
			if (otherActivity.equals(ActivityType.ANALYSIS) || otherActivity.equals(ActivityType.SYSTEM_DESIGN)
				|| otherActivity.equals(ActivityType.OBJECT_DESIGN)) {
				if (dueDate != null && TaskValidationHelper.getDueDate(otherAnnotation) != null
					&& TaskValidationHelper.getDueDate(otherAnnotation).after(dueDate)) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(UnicaseModelElement) eObj, "dueDate");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((ActionItem) eObj).getName() + "'" });
				}
			}
		}

		return ctx.createSuccessStatus();

	}

}
