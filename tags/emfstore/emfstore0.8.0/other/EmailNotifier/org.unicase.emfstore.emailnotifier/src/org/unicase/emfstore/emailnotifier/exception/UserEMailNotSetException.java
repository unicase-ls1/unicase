/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.exception;

/**
 * 
 * @author staudta
 *
 */
public class UserEMailNotSetException extends Exception {

	private static final long serialVersionUID = -5476387569735775253L;
	
	/**
	 * Constructor.
	 * 
	 * @param username the user name that hasn't been found
	 */
	public UserEMailNotSetException(String username) {
		super("The user with the username "+username+" hasn't set an email address.");
	}
}
