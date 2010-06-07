/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.requirement.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import urml.requirement.RequirementPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		RequirementPackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the RequirementResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION,
					new RequirementResourceFactoryImpl());
			registrations.put(STAR_EXTENSION,
					new RequirementResourceFactoryImpl());
		}
		return registrations;
	}

} //RequirementXMLProcessor
