/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.emailnotifier.email;

/**
 * Exception Class for mails that cannot be send.
 * 
 * @author fuesescc
 */
@SuppressWarnings("serial")
public class MailNotSendException extends Exception {

	/**
	 * MailNotSendException Constructor.
	 */
	public MailNotSendException() {
		super();
	}

	/**
	 * MailNotSendException Constructor.
	 * 
	 * @param message Exception message
	 */
	public MailNotSendException(String message) {
		super(message);
	}

	/**
	 * MailNotSendException Constructor.
	 * 
	 * @param cause Exception cause
	 */
	public MailNotSendException(Throwable cause) {
		super(cause);
	}

	/**
	 * MailNotSendException Constructor.
	 * 
	 * @param message Exception message
	 * @param cause Exception cause
	 */
	public MailNotSendException(String message, Throwable cause) {
		super(message, cause);
	}

}
