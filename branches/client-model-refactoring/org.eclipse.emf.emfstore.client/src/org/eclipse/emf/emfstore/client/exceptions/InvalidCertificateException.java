/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.exceptions;

/**
 * Exception that is thrown when the specified certificate can not be found, or
 * when the specified path does not point at a valid certificate.
 * 
 * @author Carl Pfeiffer
 */
public class InvalidCertificateException extends Exception {

	private static final long serialVersionUID = 1L;

	private String errorString;

	/**
	 * @param string
	 *            error string
	 */
	public InvalidCertificateException(String string) {
		this.errorString = string;
	}

	/**
	 * Returns error message.
	 * 
	 * @return error string
	 * @see java.lang.Throwable#toString()
	 */
	@Override
	public String toString() {
		return errorString;
	}

}
