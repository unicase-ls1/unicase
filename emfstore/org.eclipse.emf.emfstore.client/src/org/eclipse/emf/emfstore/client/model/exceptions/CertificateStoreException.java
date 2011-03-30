/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.model.exceptions;

/**
 * CertificateStoreException is thrown when problems arise with the KeyStoreManager.
 * 
 * @author pfeifferc
 */
public class CertificateStoreException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message exception message
	 * @param cause reason for exception
	 */
	public CertificateStoreException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message exception message
	 */
	public CertificateStoreException(String message) {
		super(message);
	}

}
