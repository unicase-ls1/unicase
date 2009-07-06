package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a actor is connected to a usecase.
 * 
 * @author wesendon
 * @author naughton
 */
public class ActorUsecaseConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Actor) {
				EList<UseCase> useCases = ((Actor) eObj).getInitiatedUseCases();
				EList<UseCase> useCases2 = ((Actor) eObj)
						.getParticipatedUseCases();
				if (useCases.size() < 1 && useCases2.size() < 1) {
					//HN: extend to both
					EStructuralFeature errorFeature = ValidationConstraintHelper
							.getErrorFeatureForModelElement(
									(ModelElement) eObj,
									"initiatedUseCases");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((Actor) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
