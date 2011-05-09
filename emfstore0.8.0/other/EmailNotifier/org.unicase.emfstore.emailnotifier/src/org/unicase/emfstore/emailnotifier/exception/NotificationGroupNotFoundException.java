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
public class NotificationGroupNotFoundException extends Exception {
	
	private static final long serialVersionUID = 198172506333439025L;
	
	/**
	 * Constructor.
	 */
	public NotificationGroupNotFoundException() {
		super();
	}
	
	/**
	 * Constructor with cause exception.
	 * 
	 * @param e exception that caused this exception
	 */
	public NotificationGroupNotFoundException(Exception e) {
		super(e);
	}
	
}
