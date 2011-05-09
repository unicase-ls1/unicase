/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.ecore.EObject;

/**
 * Provides a message for the statusbar of the meeditor.
 * 
 * @author helming
 */
public interface StatusMessageProvider {
	/**
	 * If a status message provider can return a message for a certain element.
	 * 
	 * @param modelelement the modelelement
	 * @return the priority
	 */
	int canRender(EObject modelelement);

	/**
	 * Return the status message for a certain EObject.
	 * 
	 * @param modelelement the modelelement
	 * @return the status message
	 */
	String getMessage(EObject modelelement);
}
