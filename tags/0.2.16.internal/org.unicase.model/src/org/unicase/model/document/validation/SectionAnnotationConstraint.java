package org.unicase.model.document.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.Annotation;
import org.unicase.model.document.Section;

/**
 * Checks whether annotations are connected to sections.
 * 
 * @author wesendonk
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
				EList<Annotation> annotations = ((Section) eObj).getAnnotations();
				if (annotations.size() > 0) {
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((Section) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
