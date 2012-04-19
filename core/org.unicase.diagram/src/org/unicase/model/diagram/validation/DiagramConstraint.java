/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.requirement.UseCase;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether a diagram is empty.
 * 
 * @author hoecht
 */
public class DiagramConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof MEDiagram) {
				MEDiagram diagram = (MEDiagram) eObj;
				if (diagram.getElements() == null || diagram.getElements().size() < 1) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(MEDiagram) eObj, "name");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((UseCase) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

}
