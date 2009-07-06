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
 * "Renames" a feature by transferring the value of one feature to another
 */
public abstract class UpdateStepRenameFeature extends UpdateStepTransformClass {

	/**
	 * @return The name of the source feature whose value will be transferred 
	 */
	public abstract String getSourceFeatureName();

	/**
	 * @return The name of the target feature to which the value source feature will be transferred 
	 */
	public abstract String getTargetFeatureName();  


	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#updateModelElement(org.unicase.model.ModelElement)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int updateModelElement(ModelElement modelElement) {
		int numberOfUpdatedItems = 0;

		EStructuralFeature sourceFeature = null;
		EStructuralFeature targetFeature = null;

		sourceFeature = getTransformableEClass().getEStructuralFeature(getSourceFeatureName());
		targetFeature = getTransformableEClass().getEStructuralFeature(getTargetFeatureName());

		if (sourceFeature == null
				|| targetFeature == null) {
			return 0;
		}

		Object sourceValue = modelElement.eGet(sourceFeature, true);

		if (sourceValue == null
				|| ((sourceValue instanceof EList)
						&& ((EList) sourceValue).size() == 0)) {
			return 0;
		}

		if (sourceFeature.isMany()) {
			if (targetFeature.isMany()) {
				modelElement.eSet(targetFeature, sourceValue);
			}else{
				modelElement.eSet(targetFeature, ((EList) sourceValue).get(0));
			}
		}else{
			if (targetFeature.isMany()) {
				EList targetValue = (EList) modelElement.eGet(targetFeature);
				targetValue.add(sourceValue);
			}else{
				modelElement.eSet(targetFeature, sourceValue);
			}
		}
		
		modelElement.eUnset(sourceFeature);

		System.out.println("Renamed feature \"" 
				+ getSourceFeatureName()
				+ "\" of model element \""
				+ modelElement.getName()
				+ "\" to \"" 
				+ getTargetFeatureName()
				+ "\"");

		return ++numberOfUpdatedItems;
	}
}
