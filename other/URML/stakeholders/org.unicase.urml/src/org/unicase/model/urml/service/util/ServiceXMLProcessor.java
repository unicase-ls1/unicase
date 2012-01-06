/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.service.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.unicase.model.urml.service.ServicePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class ServiceXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ServicePackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the ServiceResourceFactoryImpl factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ServiceResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ServiceResourceFactoryImpl());
		}
		return registrations;
	}

} // ServiceXMLProcessor
