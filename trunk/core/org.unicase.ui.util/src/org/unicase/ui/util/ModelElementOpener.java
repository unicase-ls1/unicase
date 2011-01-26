/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.util;

import org.eclipse.emf.ecore.EObject;

/**
 * Modelelement opener offer the functionality to open a specific model element. Standard opener is the model element
 * editor. Example for specific opener are the diagrams.
 * 
 * @author helming
 */
public interface ModelElementOpener {
	/**
	 * Constant to return if the opener should not open the modelelement.
	 */
	int DONOTOPEN = -1;

	/**
	 * Checks whether the model element should be opened by this opener, depending on the priority. The model element
	 * will be opened with the registered opener with the highest priority.
	 * 
	 * @param modelElement the model element to check
	 * @return a priority indicating how well the opener can open the element
	 */
	int canOpen(EObject modelElement);

	/**
	 * The action to open the model element.
	 * 
	 * @param modelElement the model element to open
	 */
	void openModelElement(EObject modelElement);
}
