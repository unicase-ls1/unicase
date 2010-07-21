/**
 * <copyright> </copyright> $Id$
 */
package urml.feature.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import urml.feature.FeaturePackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class FeatureXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		FeaturePackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the FeatureResourceFactoryImpl factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new FeatureResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new FeatureResourceFactoryImpl());
		}
		return registrations;
	}

} // FeatureXMLProcessor
