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

/**
 * Helper class for serializing and deserializing EObjects for RMI transport.
 * @author wesendonk
 *
 */
public final class RMIUtil {

	/**
	 * Private constructor.
	 */
	private RMIUtil() {
		//nothing to do
	}

	/**
	 * Converts an EObject to a String using the resource attached to the object.
	 * 
	 * @param object the eObject
	 * @return String representation of the EObject
	 * @throws IOException if a serialization problem occurs
	 */
	//FIXME: Exception
	public static String eObjectToStringByResource(EObject object) throws IOException {
		// TODO null safety
		Resource res = object.eResource();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		res.save(out, null);
		return out.toString();
	}
	
	/**
	 * Converts an EObject to a String.
	 * 
	 * @param object the eObject
	 * @return String representation of the EObject
	 * @throws IOException if a serialization problem occurs
	 */
	//FIXME: Exception
	public static String eObjectToString(EObject object) throws IOException {
		// TODO Uri
		Resource res = (new ResourceSetImpl()).createResource(URI
				.createURI("eineTolleUri"));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		res.getContents().add(EcoreUtil.copy(object));
		res.save(out, null);
		return out.toString();
	}

	/**
	 * Converts a String to an EObject.
	 * Note: String must be the result of {@link RMIUtil#eObjectToString(EObject)}
	 * @param object the String representation of the EObject
	 * @return the deserialized EObject
	 * @throws UnsupportedEncodingException if encoding is invalid
	 * @throws IOException if deserialization fails
	 */
	//FIXME: Exceptions
	public static EObject stringToEObject(String object)
			throws UnsupportedEncodingException, IOException {
		// TODO Uri
		Resource res = (new ResourceSetImpl()).createResource(URI
				.createURI("eineNochTollereUri"));
		res.load(new ByteArrayInputStream(object.getBytes("UTF-8")), null);
		return res.getContents().get(0);
	}
	/**
	 * Converts a String to an EObject using a given resource.
	 * 
	 * Note: String must be the result of {@link RMIUtil#eObjectToString(EObject)}
	 * @param object the String representation of the EObject
	 * @param the resource
	 * @return the deserialized EObject
	 * @throws UnsupportedEncodingException if encoding is invalid
	 * @throws IOException if deserialization fails
	 */
	//FIXME: Exceptions
	public static EObject stringToEObject(String object, Resource res)
			throws UnsupportedEncodingException, IOException {
		res.load(new ByteArrayInputStream(object.getBytes("UTF-8")), null);
		return res.getContents().get(0);
	}
}
