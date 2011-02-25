/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Context for a modelelement.
 * 
 * @author helming
 */
public interface ECPModelelementContext {
	/**
	 * returns all model elements in a context.
	 * 
	 * @return a list of model elements
	 */
	Collection<EObject> getAllModelElements();

	/**
	 * Returns the editing domain.
	 * 
	 * @return the editing domain
	 */
	EditingDomain getEditingDomain();

}
