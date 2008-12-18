package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a nf-requirement is linked to a usecase.
 * 
 * @author wesendon
 * @author naughton
 */
public class RequirementUsecaseConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof NonFunctionalRequirement) {
				EList<UseCase> useCases = ((NonFunctionalRequirement) eObj).getRestrictedUseCases();
				if (useCases.size() < 1) {
					EStructuralFeature errorFeature = ValidationConstraintHelper
					.getErrorFeatureForModelElement(
							(ModelElement) eObj, "restrictedUseCases");
			ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((NonFunctionalRequirement) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
