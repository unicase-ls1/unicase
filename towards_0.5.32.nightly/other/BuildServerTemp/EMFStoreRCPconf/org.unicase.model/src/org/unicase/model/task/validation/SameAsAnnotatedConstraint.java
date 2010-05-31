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
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * This rules checks if an annotation annotates a workItems whether it is contained in the same workpackage.
 * 
 * @author helming
 */
public class SameAsAnnotatedConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType != EMFEventType.NULL || (!(eObj instanceof WorkItem))) {
			return ctx.createSuccessStatus();
		}
		WorkItem workItem = (WorkItem) eObj;

		try {
			if (workItem.getMEState().equals(MEState.CLOSED) || workItem.getContainingWorkpackage() == null) {
				return ctx.createSuccessStatus();
			}
		} catch (CircularDependencyException e) {
			return ctx.createSuccessStatus();
		}

		EList<UnicaseModelElement> annotatedModelElements = workItem.getAnnotatedModelElements();
		for (UnicaseModelElement modelElement : annotatedModelElements) {
			if (modelElement instanceof WorkItem) {
				if (!workItem.getContainingWorkpackage().equals(((WorkItem) modelElement).getContainingWorkpackage())) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(UnicaseModelElement) eObj, "annotatedModelElements");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((WorkItem) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();

	}
}
