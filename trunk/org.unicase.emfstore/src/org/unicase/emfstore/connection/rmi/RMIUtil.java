/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.connection.rmi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.exceptions.SerializationException;

/**
 * Helper class for serializing and deserializing EObjects for RMI transport.
 * 
 * @author wesendonk
 * 
 */
public final class RMIUtil {

	private static final URI VIRTUAL_URI = URI.createURI("virtualUnicaseUri");

	/**
	 * Private constructor.
	 */
	private RMIUtil() {
		// nothing to do
	}

	/**
	 * Converts an EObject to a String.
	 * 
	 * @param object
	 *            the eObject
	 * @return String representation of the EObject
	 * @throws SerializationException
	 *             if a serialization problem occurs
	 */
	public static String eObjectToString(EObject object) throws SerializationException {
		if (object == null) {
			return null;
		}
		Resource res = (new ResourceSetImpl()).createResource(VIRTUAL_URI);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		res.getContents().add(EcoreUtil.copy(object));
		try {
			res.save(out, null);
		} catch (IOException e) {
			throw new SerializationException(e);
		}
		return out.toString();
	}

	/**
	 * Converts a String to an EObject. Note: String must be the result of
	 * {@link RMIUtil#eObjectToString(EObject)}
	 * 
	 * @param object
	 *            the String representation of the EObject
	 * @return the deserialized EObject
	 * @throws SerializationException
	 *             if deserialization fails
	 */
	public static EObject stringToEObject(String object)
			throws SerializationException {
		if (object == null) {
			return null;
		}
		Resource res = (new ResourceSetImpl()).createResource(VIRTUAL_URI);
		try {
			res.load(new ByteArrayInputStream(object.getBytes("UTF-8")), null);
		} catch (UnsupportedEncodingException e) {
			throw new SerializationException(e);
		} catch (IOException e) {
			throw new SerializationException(e);
		}

		EObject result = res.getContents().get(0);
		res.getContents().remove(result);
		return result;
	}

}
