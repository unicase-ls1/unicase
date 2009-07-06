package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.task.ActionItem;

/**
 * Checks whether a usecase is connected to a functional requirement.
 * 
 * @author wesendonk
 */
public class UsecaseRequirementConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof UseCase) {
				EList<FunctionalRequirement> functionalRequirements = ((UseCase) eObj).getFunctionalRequirements();
				if (functionalRequirements==null) {
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((ActionItem) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
