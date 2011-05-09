package org.unicase.model.urml.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.model.util.ValidationConstraintHelper;

public class TerminalRequirementConstraint extends AbstractModelConstraint {
	@Override
	public IStatus validate(IValidationContext ctx) {
		EMFEventType eType = ctx.getEventType();
		if (eType == EMFEventType.NULL) {
			EObject eObj = ctx.getTarget();
			if (eObj instanceof Requirement) {
				if (eObj.eContents().isEmpty() && !((Requirement) eObj).isTerminal()) {
					ctx.addResult(ValidationConstraintHelper.getErrorFeatureForModelElement((UnicaseModelElement) eObj,
						"terminal"));
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((UnicaseModelElement) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
