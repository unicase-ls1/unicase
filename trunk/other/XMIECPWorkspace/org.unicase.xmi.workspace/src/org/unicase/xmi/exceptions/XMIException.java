/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.exceptions;

import org.unicase.ecp.model.Activator;

/**
 * General Exception for the XMIECPWorkspace.
 * @author matti, markus
 *
 */
public abstract class XMIException extends Throwable {

	/**
	 * Generated ID for serialization.
	 */
	private static final long serialVersionUID = 3140461347714378143L;

	/**
	 * Message to be displayed.
	 */
	protected String message; // needs to be protected, because it's used in the subclasses
	
	/**
	 * Exception that has been thrown.
	 */
	protected Exception exception; // needs to be protected, because it's used in the subclasses
	
	/**
	 * Writes the events to the message-log.
	 */
	protected void log() {
		Activator.getDefault().logException(message, exception);
	}
}
