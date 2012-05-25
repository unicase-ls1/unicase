/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

/**
 * Checks whether an attribute's value of an element is a well-formed Java identifier.
 * 
 * @author herrmi
 */
public abstract class WellFormedNameConstraintBase extends AbstractModelConstraint {

	private EAttribute nameAttribute;

	/**
	 * Constructor.
	 * 
	 * @param nameAttribute attribute to obtain the name
	 */
	protected WellFormedNameConstraintBase(EAttribute nameAttribute) {
		this.nameAttribute = nameAttribute;
	}

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
			if (applies(eObj)) {
				String name = (String) eObj.eGet(nameAttribute);
				if (!isWellFormed(name)) {
					ctx.addResult(nameAttribute);
					return ctx.createFailureStatus(new Object[] { "'" + name + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	/**
	 * Check whether this constraint applies to the element.
	 * 
	 * @param element Element
	 * @return true if it applies, false otherwise
	 */
	protected boolean applies(EObject element) {
		return element.eClass() == nameAttribute.getEContainingClass()
			|| element.eClass().getEAllSuperTypes().contains(nameAttribute.getEContainingClass());
	}

	/**
	 * Checks whether a name is a well-formed Java identifier.
	 */
	private boolean isWellFormed(String name) {
		boolean result = false;
		if (name != null) {
			int length = name.length();
			if (length > 0 && Character.isJavaIdentifierStart(name.codePointAt(0))) {
				result = true;
				for (int i = Character.offsetByCodePoints(name, 0, 1); i < length; i = Character.offsetByCodePoints(
					name, i, 1)) {
					if (!Character.isJavaIdentifierPart(name.codePointAt(i))) {
						result = false;
						break;
					}
				}
			}
		}
		return result;
	}
}
