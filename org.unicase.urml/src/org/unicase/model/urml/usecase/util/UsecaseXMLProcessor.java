/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.usecase.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.unicase.model.urml.usecase.UsecasePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class UsecaseXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UsecaseXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		UsecasePackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the UsecaseResourceFactoryImpl factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new UsecaseResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new UsecaseResourceFactoryImpl());
		}
		return registrations;
	}

} // UsecaseXMLProcessor
