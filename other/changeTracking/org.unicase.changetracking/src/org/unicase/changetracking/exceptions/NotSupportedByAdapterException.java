/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.exceptions;

/**
 * This exception may be thrown by an adapter or the commands it produces. If it
 * is thrown, it signals that this adapter does not support the invoked
 * operation.
 * 
 * @author jfinis
 * 
 */
public class NotSupportedByAdapterException extends VCSException {

	/**
	 * .
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * 
	 * @param arg0 description of the not supported feature.
	 */
	public NotSupportedByAdapterException(String arg0) {
		super(arg0 + " is not supported by this VCS adapter.");
	}

}
