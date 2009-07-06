/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.model.ModelElement;


/**
 * @author schroech
 *
 */
public abstract class UpdateStepTransformFeature extends UpdateStepTransformClass {

	/**
	 * @return The name of the feature that is about to be transformed
	 */
	public abstract String getFeatureName();

	/**
	 * @param feature
	 * The feature to be updated
	 * @param modelElement
	 * The model element to be updated
	 * @return
	 * The number of model elements updated
	 */
	public abstract int updateFeature(ModelElement modelElement, EStructuralFeature feature);

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#updateModelElement(org.unicase.model.ModelElement)
	 */
	@Override
	public int updateModelElement(ModelElement modelElement) {
		int numberOfUpdatedItems = 0;
		EStructuralFeature feature = null;
		
		feature = getTransformableEClass().getEStructuralFeature(getFeatureName());

		if (feature != null) {
				numberOfUpdatedItems += updateFeature(modelElement, feature);
		}
		return numberOfUpdatedItems;
	}


}