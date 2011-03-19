/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.observers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.ProjectSpace;

/**
 * Enables the modification of attributes of newly created model elements. IMPORTANT: do not modify any references. This
 * interfaces is only intended to modify attributes of model elements like creation date/creator and the like.
 * 
 * @author emueller
 */
// TODO Chain use ObserverBus and extends IObserver
public interface PostCreationListener {

	/**
	 * Called when a new model element has been created. Use this method to to modify attributes of a newly created
	 * model element.
	 * 
	 * @param projectSpace the project space that contains the project which contains the newly created model element
	 * @param modelElement the model element that has been created
	 */
	void onCreation(ProjectSpace projectSpace, EObject modelElement);
}
