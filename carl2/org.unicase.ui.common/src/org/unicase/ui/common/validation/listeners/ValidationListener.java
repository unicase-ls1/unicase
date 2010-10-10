/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.validation.listeners;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;

/**
 * The validation listener interface notifies its registered observers about changes in the ValidationResultProvider.
 * 
 * @author pfeifferc
 */
public interface ValidationListener {

	/**
	 * This method notifies {@link ValidationListener}s of changes.
	 * 
	 * @param rootElement root {@link EObject} for which the update happened
	 * @param eObject {@link EObject} which was validated
	 * @param constraintStati of the validated element
	 */
	void objectValidated(EObject rootElement, EObject eObject, Set<IConstraintStatus> constraintStati);

	/**
	 * This method notifies about a removal of the root element.
	 * 
	 * @param rootElement root {@link EObject} that was removed
	 */
	void rootRemoved(EObject rootElement);
}
