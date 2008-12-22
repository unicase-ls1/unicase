package org.unicase.model.task.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a activity is set for this ActionItem.
 * 
 * @author wesendonk
 * @author naughton
 */
public class ActionItemActivityConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof ActionItem) {
				ActivityType activity = ((ActionItem) eObj).getActivity();
				if (activity.getValue() == ActivityType.NONE_VALUE) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(ModelElement) eObj, "activity");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((ActionItem) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
