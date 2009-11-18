/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.implementation.IAttribute;
import org.unicase.model.implementation.IClass;

/**
 * Checks whether a class has at most one attribute which is id.
 * 
 * @author herrmama
 */
public class AtMostOneIdConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.validation.AbstractModelConstraint#validate(org.eclipse.emf.validation.IValidationContext)
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (eObj instanceof IClass) {
				IClass c = (IClass) eObj;
				if (getNumberOfIdAttributes(c) > 1) {
					return ctx.createFailureStatus(new Object[] {});
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	private int getNumberOfIdAttributes(IClass c) {
		int n = 0;
		for (IAttribute attribute : getAllAttributes(c)) {
			if (attribute.isId()) {
				n++;
			}
		}
		return n;
	}

	private List<IAttribute> getAllAttributes(IClass c) {
		List<IAttribute> features = new ArrayList<IAttribute>();
		features.addAll(c.getAttributes());
		for (IClass superClass : c.getSuperClasses()) {
			features.addAll(getAllAttributes(superClass));
		}
		return features;
	}
}
