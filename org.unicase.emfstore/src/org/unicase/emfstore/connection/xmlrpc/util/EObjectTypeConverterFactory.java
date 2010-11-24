/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.connection.xmlrpc.util;

import org.apache.xmlrpc.common.TypeConverter;
import org.apache.xmlrpc.common.TypeConverterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * EObject Type Converter for XML RPC.
 * 
 * @author wesendon
 */
public class EObjectTypeConverterFactory extends TypeConverterFactoryImpl {

	private static final TypeConverter EOBJECTCONVERTER = new EObjectConverter();

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TypeConverter getTypeConverter(Class pClass) {
		if (EObject.class.isAssignableFrom(pClass)) {
			return EOBJECTCONVERTER;
		}
		return super.getTypeConverter(pClass);
	}

	/**
	 * EObject Converter.
	 * 
	 * @author wesendon
	 */
	private static final class EObjectConverter implements TypeConverter {
		public boolean isConvertable(Object pObject) {
			return pObject == null || pObject instanceof EObject;
		}

		public Object convert(Object pObject) {
			return pObject;
		}

		public Object backConvert(Object result) {
			return result;
		}
	}
}
