/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.connection.xmlrpc.util;

import org.apache.ws.commons.util.NamespaceContextImpl;
import org.apache.xmlrpc.common.TypeFactoryImpl;
import org.apache.xmlrpc.common.XmlRpcController;
import org.apache.xmlrpc.common.XmlRpcStreamConfig;
import org.apache.xmlrpc.parser.TypeParser;
import org.apache.xmlrpc.serializer.TypeSerializer;
import org.eclipse.emf.ecore.EObject;
import org.xml.sax.SAXException;

/**
 * Type Facotry for XML RPC Transportation.
 * 
 * @author wesendon
 */
public class EObjectTypeFactory extends TypeFactoryImpl {

	/**
	 * Default constructor.
	 * 
	 * @param pController constroller.
	 */
	public EObjectTypeFactory(XmlRpcController pController) {
		super(pController);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeParser getParser(XmlRpcStreamConfig pConfig, NamespaceContextImpl pContext, String pURI,
		String pLocalName) {
		if (EObjectSerializer.EOBJECT_TAG.equals(pLocalName)) {
			return new EObjectTypeParser();
		} else {
			return super.getParser(pConfig, pContext, pURI, pLocalName);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TypeSerializer getSerializer(XmlRpcStreamConfig pConfig, Object pObject) throws SAXException {
		if (pObject instanceof EObject) {
			return new EObjectSerializer();
		} else {
			return super.getSerializer(pConfig, pObject);
		}
	}

}
