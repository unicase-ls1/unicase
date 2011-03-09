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
import org.unicase.model.task.WorkItem;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * This constraint checks whether a ActionItem has a assignee.
 * 
 * @author pfeifferc
 */
public class CircularDependencyConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext validationContext) {
		EObject eObject = validationContext.getTarget();
		EMFEventType eType = validationContext.getEventType();
		if (eType == EMFEventType.NULL) {
			if (eObject instanceof WorkItem) {
				WorkItem workItem = (WorkItem) eObject;
				for (WorkItem successor : workItem.getSuccessors()) {
					if (successor.getPredecessors().contains(workItem)) {
						EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
							workItem, "name");
						validationContext.addResult(errorFeature);
						return validationContext.createFailureStatus(new Object[] { eObject.eClass().getName() + ": '"
							+ workItem.getName() + "'" });
					}
				}
			}
		}
		return validationContext.createSuccessStatus();

	}
}
