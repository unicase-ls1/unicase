package org.unicase.model.document.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.document.Section;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether annotations are connected to sections.
 * 
 * @author wesendonk
 * @author naughton
 */
public class SectionAnnotationConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Section) {
				EList<Annotation> annotations = ((Section) eObj)
						.getAnnotations();
				if (annotations.size() > 0) {
					EStructuralFeature errorFeature = ValidationConstraintHelper
							.getErrorFeatureForModelElement(
									(ModelElement) eObj, "annotations");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((Section) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
