package org.unicase.model.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.ModelElement;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a model element has a default "new: ..." name.
 * 
 * @author wesendonk
 * @author naughton
 */
public class ModelElementNewNameConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof ModelElement) {
				ModelElement modelElement = (ModelElement) eObj;
				String defaultName = "new " + eObj.eClass().getName();
				if (defaultName.equals(modelElement.getName())) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						modelElement, "name");
					ctx.addResult(errorFeature);

					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((ModelElement) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}
}
