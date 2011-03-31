/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model.util;

import org.eclipse.emf.ecore.EObject;

/**
 * Represents a failure in serialization or deserialization of an object.
 * 
 * @author koegel
 */
@SuppressWarnings("serial")
public class SerializationException extends Exception {

	private static final String DE_SERIALIZATION_FAILED = "(De-)Serialization failed";

	/**
	 * Default constructor.
	 * 
	 * @param cause the cause
	 */
	public SerializationException(Throwable cause) {
		super(DE_SERIALIZATION_FAILED + ".", cause);
	}

	/**
	 * Default constructor.
	 * 
	 * @param eObject the eObject that failed to serialize
	 */
	public SerializationException(EObject eObject) {
		super(DE_SERIALIZATION_FAILED + ": " + eObject.toString());
	}

	/**
	 * Default constructor.
	 * 
	 * @param msg exception message
	 */
	public SerializationException(String msg) {
		super(DE_SERIALIZATION_FAILED + ": " + msg);
	}
}
