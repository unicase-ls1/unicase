/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.model.ModelElement;

/**
 * @author schroech
 *
 */
public abstract class UpdateStepRemoveFeature extends UpdateStepTransformFeature {


	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#updateModelElement(org.unicase.model.ModelElement)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int updateFeature(ModelElement modelElement, EStructuralFeature feature) {
		int numberOfUpdatedItems = 0;

		Object featureValue = modelElement.eGet(feature);
		if (featureValue != null
				&& !((featureValue instanceof EList)
						&& (((EList) featureValue).size() != 0))) {

			modelElement.eUnset(feature);

			System.out.println("Unset feature \"" 
					+ getFeatureName()
					+ "\" of model element \""
					+ modelElement.getName()
					+ "\"");

			numberOfUpdatedItems++;
		}
		return numberOfUpdatedItems;
	}
}
