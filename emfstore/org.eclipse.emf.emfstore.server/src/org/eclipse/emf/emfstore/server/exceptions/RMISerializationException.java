/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.exceptions;

/**
 * Represents a failure in serialization or deserialization of an object.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class RMISerializationException extends SerializationException {

	/**
	 * Default constructor.
	 * 
	 * @param cause the cause
	 */
	public RMISerializationException(Throwable cause) {
		super("De-/Serialization failed", cause);
	}
}
