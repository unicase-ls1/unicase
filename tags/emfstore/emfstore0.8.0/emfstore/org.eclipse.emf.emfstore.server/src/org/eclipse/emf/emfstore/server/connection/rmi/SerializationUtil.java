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
package org.eclipse.emf.emfstore.server.connection.rmi;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.SerializationException;
import org.eclipse.emf.emfstore.server.exceptions.RMISerializationException;

/**
 * Helper class for serializing and deserializing EObjects for RMI transport.
 * 
 * @author wesendonk
 */
public final class SerializationUtil {

	/**
	 * Private constructor.
	 */
	private SerializationUtil() {
		// nothing to do
	}

	/**
	 * Converts an EObject to a String.
	 * 
	 * @param object the eObject
	 * @return String representation of the EObject
	 * @throws RMISerializationException if a serialization problem occurs
	 */
	public static String eObjectToString(EObject object) throws RMISerializationException {
		try {
			return ModelUtil.eObjectToString(object);
		} catch (SerializationException e) {
			throw new RMISerializationException(e);
		}
	}

	/**
	 * Converts a String to an EObject. Note: String must be the result of
	 * {@link SerializationUtil#eObjectToString(EObject)}
	 * 
	 * @param object the String representation of the EObject
	 * @return the deserialized EObject
	 * @throws RMISerializationException if deserialization fails
	 */
	public static EObject stringToEObject(String object) throws RMISerializationException {
		try {
			return ModelUtil.stringToEObject(object);
		} catch (SerializationException e) {
			throw new RMISerializationException(e);
		}
	}

}
