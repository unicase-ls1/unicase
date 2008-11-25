package org.unicase.model.task.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.task.ActionItem;

/**
 * This constraint checks whether a ActionItem has a assignee.
 * 
 * @author wesendonk
 * 
 */
public class ActionItemAssigneeConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {

		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof ActionItem) {
				if (((ActionItem) eObj).getAssignee() == null) {
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((ActionItem) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();

	}
}
