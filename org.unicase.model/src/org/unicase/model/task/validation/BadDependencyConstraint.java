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
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * This constraint checks whether a ActionItem has a assignee.
 * 
 * @author pfeifferc
 */
public class BadDependencyConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext validationContext) {
		EObject eObject = validationContext.getTarget();
		EMFEventType eType = validationContext.getEventType();
		if (eType == EMFEventType.NULL) {
			if (eObject instanceof WorkPackage) {
				WorkPackage workPackage = (WorkPackage) eObject;
				for (WorkItem workItem : workPackage.getAllContainedWorkItems()) {
					for (WorkItem successor : workItem.getSuccessors()) {
						if (successor.getContainingWorkpackage() == null
							|| !successor.getContainingWorkpackage().getModelElementId().getId().equals(
								workPackage.getModelElementId().getId())) {
							EStructuralFeature errorFeature = ValidationConstraintHelper
								.getErrorFeatureForModelElement(workPackage, "name");
							validationContext.addResult(errorFeature);
							return validationContext.createFailureStatus(new Object[] { eObject.eClass().getName()
								+ ": '" + workPackage.getName() + "'" });

						}
					}
					for (WorkItem predecessor : workItem.getPredecessors()) {
						if (predecessor.getContainingWorkpackage() == null
							|| !predecessor.getContainingWorkpackage().getModelElementId().getId().equals(
								workPackage.getModelElementId().getId())) {
							EStructuralFeature errorFeature = ValidationConstraintHelper
								.getErrorFeatureForModelElement((UnicaseModelElement) eObject, "name");
							validationContext.addResult(errorFeature);
							return validationContext.createFailureStatus(new Object[] { eObject.eClass().getName()
								+ ": '" + ((WorkPackage) eObject).getName() + "'" });
						}
					}
				}
			}
		}
		return validationContext.createSuccessStatus();

	}
}
