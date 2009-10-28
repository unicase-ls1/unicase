/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * This validation rule checks if a refining requirement has annotated tasks which have earlier due dates then the
 * refinied requirements.
 * 
 * @author helming
 */
public class RefiningAfterRefinedConstraint extends AbstractModelConstraint {
	/**
	 * default constructor.
	 */
	public RefiningAfterRefinedConstraint() {
		// TODO Auto-generated constructor stub
	}

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
			if (me instanceof FunctionalRequirement) {
				otherAnnotations.addAll(getRefiningAnnoations((FunctionalRequirement) me));
			}
		}
		for (Annotation otherAnnotation : otherAnnotations) {
			if ((!(otherAnnotation instanceof ActionItem) && !(otherAnnotation instanceof Issue))) {
				continue;
			}
			ActivityType otherActivity = TaskValidationHelper.getActivity(otherAnnotation);
			if (otherActivity.equals(ActivityType.ANALYSIS) || otherActivity.equals(ActivityType.SYSTEM_DESIGN)
				|| otherActivity.equals(ActivityType.OBJECT_DESIGN)
				|| otherActivity.equals(ActivityType.IMPLEMENTATION)) {
				if (TaskValidationHelper.getDueDate(otherAnnotation).after(dueDate)) {
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

	private Collection<? extends Annotation> getRefiningAnnoations(FunctionalRequirement fr) {
		Set<Annotation> ret = new HashSet<Annotation>();
		EList<FunctionalRequirement> refiningRequirements = fr.getRefiningRequirements();
		for (FunctionalRequirement functionalRequirement : refiningRequirements) {
			ret.addAll(functionalRequirement.getAnnotations());
			ret.addAll(getRefiningAnnoations(functionalRequirement));
		}
		return ret;
	}

}
