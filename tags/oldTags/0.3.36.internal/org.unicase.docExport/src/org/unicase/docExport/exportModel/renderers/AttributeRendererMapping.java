/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute Renderer Mapping</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping#getAttributeRenderer <em>Attribute
 * Renderer</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping#getFeatureName <em>Feature Name</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getAttributeRendererMapping()
 * @model
 * @generated
 */
public interface AttributeRendererMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute Renderer</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Renderer</em>' containment reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attribute Renderer</em>' containment reference.
	 * @see #setAttributeRenderer(AttributeRenderer)
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getAttributeRendererMapping_AttributeRenderer()
	 * @model containment="true"
	 * @generated
	 */
	AttributeRenderer getAttributeRenderer();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping#getAttributeRenderer
	 * <em>Attribute Renderer</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Attribute Renderer</em>' containment reference.
	 * @see #getAttributeRenderer()
	 * @generated
	 */
	void setAttributeRenderer(AttributeRenderer value);

	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getAttributeRendererMapping_FeatureName()
	 * @model
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping#getFeatureName <em>Feature Name</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

} // AttributeRendererMapping
