/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Checks whether the name starts with a number followed by a dot.
 * 
 * @author hoecht
 */
public class RequirementMissingNameConstraint extends AbstractModelConstraint {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();

		if (eType == EMFEventType.NULL) {
			if (isRequirement(eObj)) {
				UnicaseModelElement me = (UnicaseModelElement) eObj;
				if (startsWithANumber(me.getName())) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						(UnicaseModelElement) eObj, "name");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { eObj.eClass().getName() + ": '"
						+ ((UnicaseModelElement) eObj).getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	private boolean isRequirement(EObject eObj) {
		EList<EClassifier> classifiers = RequirementPackage.eINSTANCE.getEClassifiers();
		for (EClassifier classifier : classifiers) {
			if (classifier instanceof EClass) {
				EClass eclass = (EClass) classifier;
				if (eclass.isInstance(eObj)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean startsWithANumber(String string) {
		if (string == null) {
			return false;
		}

		if (string.startsWith(".") || string.startsWith(")")) {
			return true;
		}

		for (int i = 1; i <= 9; i++) {
			if (string.startsWith(String.valueOf(i))) {
				return startsWithANumber(string.substring(1));
			}
		}

		return false;
	}
}
