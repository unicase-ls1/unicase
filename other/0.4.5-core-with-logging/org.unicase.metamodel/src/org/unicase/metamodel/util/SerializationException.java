/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel.util;

import org.eclipse.emf.ecore.EObject;

/**
 * Represents a failure in serialization or deserialization of an object.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class SerializationException extends Exception {

	/**
	 * Default constructor.
	 * 
	 * @param cause the cause
	 */
	public SerializationException(Throwable cause) {
		super("(De-)Serialization failed.", cause);
	}
	
	/**
	 * Default constructor.
	 * 
	 * @param eObject the eObject that failed to serialize
	 */
	public SerializationException(EObject eObject) {
		super("(De-)Serialization failed: " + eObject.toString());
	}

	/**
	 * Default constructor.
	 * 
	 * @param msg exception message
	 */
	public SerializationException(String msg) {
		super(msg);
	}
}
