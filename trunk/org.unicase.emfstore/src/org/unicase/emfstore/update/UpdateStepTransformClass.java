/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

/**
 * @author schroech
 *
 */
public abstract class UpdateStepTransformClass extends UpdateStepImpl {

	/**
	 * @return The {@link EClass} which is about to be transformed
	 */
	public abstract EClass getTransformableEClass();	
	
	
	/**
	 * @param modelElement
	 * The model element that should be updated
	 * @return The number of elements updated during execution
	 */
	public abstract int updateModelElement(ModelElement modelElement);
	
	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepImpl#updateProjectState(org.unicase.model.Project)
	 */
	@Override
	public int updateProjectState(Project state) {
		int numberOfUpdatedItems = 0;
		EList<ModelElement> allModelElementsbyClass = state.getAllModelElementsbyClass(getTransformableEClass(), 
				new BasicEList<ModelElement>());
		for (ModelElement modelElement : allModelElementsbyClass) {
			numberOfUpdatedItems += updateModelElement(modelElement);
		}
		
		return numberOfUpdatedItems;
	}
}
