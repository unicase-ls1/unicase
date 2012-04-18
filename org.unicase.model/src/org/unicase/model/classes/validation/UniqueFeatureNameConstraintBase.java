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
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;

/**
 * Checks whether the name of a feature is unique within its parent class.
 * 
 * @author herrmama
 */
public abstract class UniqueFeatureNameConstraintBase extends AbstractModelConstraint {

	private EAttribute nameAttribute;

	private EReference classReference;

	/**
	 * Constructor.
	 * 
	 * @param classReference Reference to access the class
	 * @param nameAttribute Attribute to access the name
	 */
	public UniqueFeatureNameConstraintBase(EReference classReference, EAttribute nameAttribute) {
		this.classReference = classReference;
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

		if (eType == EMFEventType.NULL && isFeature(eObj)) {
			String name = getName(eObj);
			Class c = getClass(eObj);
			if (c != null && !isUnique(c, name, eObj)) {
				ctx.addResult(nameAttribute);
				return ctx.createFailureStatus(new Object[] { "'" + name + "'" });
			}
		}
		return ctx.createSuccessStatus();
	}

	private Class getClass(EObject eObj) {
		return (Class) eObj.eGet(classReference);
	}

	private String getName(EObject eObj) {
		return (String) eObj.eGet(nameAttribute);
	}

	private boolean isFeature(EObject element) {
		return element instanceof Attribute || element instanceof Association;
	}

	private boolean isUnique(Class c, String name, EObject element) {
		if (name != null) {
			for (Attribute a : ClassesHelper.getAllAttributes(c)) {
				if (a.getName() != null) {
					if (a != element && name.equals(a.getName())) {
						return false;
					}
				}
			}

			for (Association a : ClassesHelper.getAllOutgoingAssociations(c)) {
				if (a.getTargetRole() != null) {
					if (a != element && name.equals(a.getTargetRole())) {
						return false;
					}
				}
			}

			for (Association a : ClassesHelper.getAllIncomingAssociations(c)) {
				if (a.getSourceRole() != null) {
					if (a != element && name.equals(a.getSourceRole())) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
