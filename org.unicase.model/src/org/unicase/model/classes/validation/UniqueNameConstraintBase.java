/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.classes.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.util.ValidationConstraintHelper;

/**
 * Base class for constraints which check uniqueness of names.
 * 
 * @param <C> The type of the context element
 * @author herrmama
 */
public abstract class UniqueNameConstraintBase<C extends EObject> extends AbstractModelConstraint {

	private EReference contextReference;

	private List<EReference> comparisonReferences;

	/**
	 * Constructor.
	 * 
	 * @param contextReference Reference to access the context element
	 * @param comparisonReferences References to access the comparison elements from the context element
	 */
	public UniqueNameConstraintBase(EReference contextReference, List<EReference> comparisonReferences) {
		this.contextReference = contextReference;
		this.comparisonReferences = comparisonReferences;
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

		if (eType == EMFEventType.NULL && eObj instanceof UnicaseModelElement) {
			UnicaseModelElement element = (UnicaseModelElement) eObj;
			C context = getContext(element);
			if (context != null) {
				List<? extends UnicaseModelElement> elements = getComparisonElements(context);
				if (!isUnique(element, elements)) {
					EStructuralFeature errorFeature = ValidationConstraintHelper.getErrorFeatureForModelElement(
						element, "name");
					ctx.addResult(errorFeature);
					return ctx.createFailureStatus(new Object[] { "'" + element.getName() + "'" });
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	@SuppressWarnings("unchecked")
	private C getContext(EObject element) {
		return (C) element.eGet(contextReference);
	}

	/**
	 * Return the elements to which the element should be compared.
	 * 
	 * @param context The context element
	 * @return The elements to which the element should be compared
	 */
	@SuppressWarnings("unchecked")
	protected List<? extends UnicaseModelElement> getComparisonElements(C context) {
		List<UnicaseModelElement> elements = new ArrayList<UnicaseModelElement>();
		for (EReference reference : comparisonReferences) {
			if (reference.isMany()) {
				elements.addAll((Collection<? extends UnicaseModelElement>) context.eGet(reference));
			} else {
				if (context.eIsSet(reference)) {
					elements.add((UnicaseModelElement) context.eGet(reference));
				}
			}
		}
		return elements;
	}

	private boolean isUnique(UnicaseModelElement element, List<? extends UnicaseModelElement> elements) {
		for (UnicaseModelElement e : elements) {
			if (element.getName() != null && e.getName() != null) {
				if (e != element && element.getName().equals(e.getName())) {
					return false;
				}
			}
		}
		return true;
	}
}
