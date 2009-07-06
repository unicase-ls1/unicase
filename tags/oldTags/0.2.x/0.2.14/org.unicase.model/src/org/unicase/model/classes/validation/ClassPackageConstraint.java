package org.unicase.model.classes.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.classes.Package;

/**
 * Checks whether a class is connected to a package.
 * 
 * @author wesendonk
 */
public class ClassPackageConstraint extends AbstractModelConstraint {

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof org.unicase.model.classes.Class) {
				Package package1 = ((org.unicase.model.classes.Class) eObj).getParentPackage();
				if (package1 == null) {
					return ctx.createFailureStatus(new Object[] { eObj.eClass()
							.getName()
							+ ": '" + ((org.unicase.model.classes.Class) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
