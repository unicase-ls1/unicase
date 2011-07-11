/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.unicase.model.urml.UrmlPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class UrmlXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UrmlXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		UrmlPackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the UrmlResourceFactoryImpl factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new UrmlResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new UrmlResourceFactoryImpl());
		}
		return registrations;
	}

} // UrmlXMLProcessor
