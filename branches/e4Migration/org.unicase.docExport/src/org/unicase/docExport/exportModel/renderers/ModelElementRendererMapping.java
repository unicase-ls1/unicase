/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Element Renderer Mapping</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping#getRenderer <em>Renderer</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping#getEClassName <em>EClass Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRendererMapping()
 * @model
 * @generated
 */
public interface ModelElementRendererMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Renderer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renderer</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renderer</em>' containment reference.
	 * @see #setRenderer(ModelElementRenderer)
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRendererMapping_Renderer()
	 * @model containment="true"
	 * @generated
	 */
	ModelElementRenderer getRenderer();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping#getRenderer <em>Renderer</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renderer</em>' containment reference.
	 * @see #getRenderer()
	 * @generated
	 */
	void setRenderer(ModelElementRenderer value);

	/**
	 * Returns the value of the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass Name</em>' attribute.
	 * @see #setEClassName(String)
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRendererMapping_EClassName()
	 * @model
	 * @generated
	 */
	String getEClassName();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping#getEClassName <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass Name</em>' attribute.
	 * @see #getEClassName()
	 * @generated
	 */
	void setEClassName(String value);

} // ModelElementRendererMapping
