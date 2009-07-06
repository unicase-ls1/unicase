package org.unicase.model.task.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

/**
 * Validator for ActionItems.
 * 
 * @author unicase
 * 
 */
public class ActionItemConstraint extends AbstractModelConstraint {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {

		// EObject eObj = ctx.getTarget();
		// EMFEventType eType = ctx.getEventType();

		return ctx.createSuccessStatus();

	}

}
