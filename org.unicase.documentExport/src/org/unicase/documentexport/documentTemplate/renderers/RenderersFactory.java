/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.documentexport.documentTemplate.renderers.RenderersPackage
 * @generated
 */
public interface RenderersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RenderersFactory eINSTANCE = org.unicase.documentexport.documentTemplate.renderers.impl.RenderersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model Element Renderer Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Element Renderer Mapping</em>'.
	 * @generated
	 */
	ModelElementRendererMapping createModelElementRendererMapping();

	/**
	 * Returns a new object of class '<em>Attribute Renderer Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Renderer Mapping</em>'.
	 * @generated
	 */
	AttributeRendererMapping createAttributeRendererMapping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RenderersPackage getRenderersPackage();

} //RenderersFactory
