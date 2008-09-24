/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.update;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.ModelElement;

/**
 * @author schroech
 *
 */
public abstract class UpdateStepRemoveClass extends UpdateStepTransformClass {

	/**
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.update.UpdateStepTransformClass#updateModelElement(org.unicase.model.ModelElement)
	 */
	@Override
	public int updateModelElement(ModelElement modelElement) {
		EcoreUtil.remove(modelElement);
		return 1;
	}


}
