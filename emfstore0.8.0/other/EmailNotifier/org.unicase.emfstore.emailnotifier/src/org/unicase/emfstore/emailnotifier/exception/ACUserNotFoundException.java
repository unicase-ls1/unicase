/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.exception;

/**
 * ACUserNotFoundException.
 * 
 * @author staudta
 *
 */
public class ACUserNotFoundException extends Exception {
	
	private static final long serialVersionUID = -8430460598257054149L;
	
	/**
	 * Constructor with the possibility to define for which user name an ACUser couldn't be found.
	 * 
	 * @param username a user name
	 */
	public ACUserNotFoundException(String username) {
		super("A ac user with the name "+username+" was not found.");
	}
}
