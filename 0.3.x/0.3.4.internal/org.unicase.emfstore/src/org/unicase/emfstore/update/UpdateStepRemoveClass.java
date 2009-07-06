/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.update;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

/**
 * @author schroech
 */
public abstract class UpdateStepRemoveClass extends UpdateStepImpl {

	/**
	 * @return The {@link EClass} which is about to be transformed
	 */
	public abstract EClass getRemovableEClass();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.update.UpdateStepImpl#updateProjectState(org.unicase.model.Project)
	 */
	@Override
	public int updateProjectState(Project state) {
		int numberOfUpdatedItems = 0;
		EList<ModelElement> allModelElementsbyClass = state.getAllModelElementsbyClass(getRemovableEClass(),
			new BasicEList<ModelElement>(), false);

		for (ModelElement modelElement : allModelElementsbyClass) {
			System.out.println("Removed instance \"" + modelElement + "of class \"" + getRemovableEClass().getName()
				+ "\"");
			EcoreUtil.delete(modelElement);
			numberOfUpdatedItems++;
		}

		return numberOfUpdatedItems;
	}

}
