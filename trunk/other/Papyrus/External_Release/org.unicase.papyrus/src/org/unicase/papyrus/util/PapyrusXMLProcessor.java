/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.unicase.papyrus.PapyrusPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class PapyrusXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PapyrusXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		PapyrusPackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the PapyrusResourceFactoryImpl factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new PapyrusResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new PapyrusResourceFactoryImpl());
		}
		return registrations;
	}

} // PapyrusXMLProcessor
