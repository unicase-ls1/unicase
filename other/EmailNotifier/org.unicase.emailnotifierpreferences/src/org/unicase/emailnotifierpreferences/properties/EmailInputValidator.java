/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emailnotifierpreferences.properties;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.eclipse.jface.dialogs.IInputValidator;

/**
 * This class validates a String. It is used to validate an email address.
 * 
 * @author fuesescc
 */
public class EmailInputValidator implements IInputValidator {

	public EmailInputValidator() {
	}

	/**
	 * Validates the String. Returns null for no error, or an error message
	 * 
	 * @param s the String to validate
	 * @return String The error message
	 * @author fuesescc
	 */
	public String isValid(String s) {
		int length = s.length();
		int posat = s.lastIndexOf("@");

		if (length > 254) {
			return "Email address is too long";
		}

		if (s.indexOf(" ") == 0) {
			return "No leading whitespaces allowed!";
		}

		try {
			new InternetAddress(s, true);

			// Assumption: Domain part of the email address should contain a dot
			if (s.toString().indexOf(".", (posat + 1)) == -1) {
				return "Domain part of email address does not contain a dot";
			}

			return null;

		} catch (AddressException e) {
			return e.getMessage();
		}
	}
}
