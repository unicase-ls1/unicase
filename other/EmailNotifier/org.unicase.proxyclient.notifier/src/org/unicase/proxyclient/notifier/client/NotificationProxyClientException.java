/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.proxyclient.notifier.client;

/**
 * All exceptions that can occur inside of the notifier proxy client will be wrapped to this Exception.
 * 
 * @author staudta
 */
public class NotificationProxyClientException extends Exception {
	
	private static final long serialVersionUID = -8703595758145263985L;
	
	/**
	 * Constructor.
	 * 
	 * @param message message
	 */
	public NotificationProxyClientException(String message) {
		super(message);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param message message
	 * @param e cause
	 */
	public NotificationProxyClientException(String message, Exception e) {
		super(message, e);
	}
	
}
