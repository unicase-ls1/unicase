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
package org.eclipse.emf.emfstore.server.connection.xmlrpc.util;

import org.apache.xmlrpc.serializer.TypeSerializerImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.SerializationException;
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
	public void write(ContentHandler pHandler, Object pObject)
			throws SAXException {
		if (!(pObject instanceof EObject)) {
			throw new SAXException("Couldn't serialize, no EObject found");
		}
		try {
			write(pHandler, EOBJECT_TAG,
					ModelUtil.eObjectToString((EObject) pObject));
		} catch (SerializationException e) {
			throw new SAXException("Couldn't serialize EObject", e);
		}
	}
}
