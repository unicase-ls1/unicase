/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.xmlrpc.util;

import org.apache.xmlrpc.parser.AtomicParser;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.common.model.util.SerializationException;
import org.xml.sax.SAXException;

/**
 * Parser for EObjects.
 * 
 * @author wesendon
 */
public class EObjectTypeParser extends AtomicParser {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setResult(String pResult) throws SAXException {
		try {
			super.setResult(ModelUtil.stringToEObject(pResult));
		} catch (SerializationException e) {
			throw new SAXException("Couldn't parse EObject", e);
		}
	}

}
