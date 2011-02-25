/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.requirement.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see urml.requirement.util.RequirementResourceImpl
 * @generated
 */
public class RequirementResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		XMLResource result = new RequirementResourceImpl(uri);
		result.getDefaultSaveOptions().put(
				XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		result.getDefaultLoadOptions().put(
				XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);

		result.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION,
				Boolean.TRUE);

		result.getDefaultLoadOptions().put(
				XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		result.getDefaultSaveOptions().put(
				XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);

		result.getDefaultLoadOptions().put(
				XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
		return result;
	}

} //RequirementResourceFactoryImpl
