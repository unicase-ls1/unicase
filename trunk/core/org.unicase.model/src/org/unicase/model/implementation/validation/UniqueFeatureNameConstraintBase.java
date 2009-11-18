/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.implementation.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.implementation.IClass;
import org.unicase.model.implementation.IFeature;

/**
 * Base class for constraints which check uniqueness of feature names.
 * 
 * @author herrmama
 */
public abstract class UniqueFeatureNameConstraintBase extends UniqueNameConstraintBase<IClass> {

	/**
	 * Constructor.
	 * 
	 * @param contextReference Reference to access the context element
	 */
	public UniqueFeatureNameConstraintBase(EReference contextReference) {
		super(contextReference, new ArrayList<EReference>());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.implementation.validation.UniqueNameConstraintBase#getComparisonElements(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected List<? extends UnicaseModelElement> getComparisonElements(IClass context) {
		return getAllFeatures(context);
	}

	private List<IFeature> getAllFeatures(IClass c) {
		List<IFeature> features = new ArrayList<IFeature>();
		features.addAll(c.getAttributes());
		features.addAll(c.getOutgoingReferences());
		for (IClass superClass : c.getSuperClasses()) {
			features.addAll(getAllFeatures(superClass));
		}
		return features;
	}
}
