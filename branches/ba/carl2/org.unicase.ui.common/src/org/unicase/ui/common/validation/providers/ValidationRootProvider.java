/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.validation.providers;

import org.eclipse.emf.ecore.EObject;

/**
 * Provides the root for the validation result provider.
 * 
 * @author pfeifferc
 */
public class ValidationRootProvider {

	/**
	 * @param eObject to return the root {@link EObject} for
	 * @return the root {@link EObject}
	 */
	public EObject getRootFor(EObject eObject) {
		EObject currentContainer = eObject;
		while (currentContainer != null) {
			currentContainer = currentContainer.eContainer();
		}
		return currentContainer;
	}
}