/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.xmlrpc.util;

import org.apache.xmlrpc.serializer.TypeSerializerImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.ServerConfiguration;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.SerializationException;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * Serializer for EObjects.
 * 
 * @author wesendon
 */
public class EObjectSerializer extends TypeSerializerImpl {

	/**
	 * EObject Tag for parsing.
	 */
	public static final String EOBJECT_TAG = "EObject";

	/**
	 * {@inheritDoc}
	 */
	public void write(ContentHandler pHandler, Object pObject) throws SAXException {
		if (!(pObject instanceof EObject)) {
			throw new SAXException("Couldn't serialize, no EObject found");
		}
		try {
			// for now, href test should only be used in internal releases or dev mode
			boolean overrideHref = ServerConfiguration.isReleaseVersion();

			write(pHandler, EOBJECT_TAG, ModelUtil.eObjectToString((EObject) pObject, false, overrideHref));
		} catch (SerializationException e) {
			throw new SAXException("Couldn't serialize EObject", e);
		}
	}

}
