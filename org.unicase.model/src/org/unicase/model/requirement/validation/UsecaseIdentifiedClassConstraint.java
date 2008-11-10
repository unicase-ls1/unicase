package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.classes.Class;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.ActionItem;

/**
 * Checks whether a usecase is connected to a identified class.
 * 
 * @author wesendonk
 */
public class UsecaseIdentifiedClassConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof UseCase) {
				EList<Class> identifiedClasses = ((UseCase) eObj).getIdentifiedClasses();
				if (identifiedClasses == null) {
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((ActionItem) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
