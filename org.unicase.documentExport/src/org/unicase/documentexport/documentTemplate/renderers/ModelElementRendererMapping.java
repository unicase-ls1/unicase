/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element Renderer Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.ModelElementRendererMapping#getRenderer <em>Renderer</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.ModelElementRendererMapping#getEClassName <em>EClass Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.documentexport.documentTemplate.renderers.RenderersPackage#getModelElementRendererMapping()
 * @model
 * @generated
 */
public interface ModelElementRendererMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Renderer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renderer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renderer</em>' containment reference.
	 * @see #setRenderer(ModelElementRenderer)
	 * @see org.unicase.documentexport.documentTemplate.renderers.RenderersPackage#getModelElementRendererMapping_Renderer()
	 * @model containment="true"
	 * @generated
	 */
	ModelElementRenderer getRenderer();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.ModelElementRendererMapping#getRenderer <em>Renderer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Renderer</em>' containment reference.
	 * @see #getRenderer()
	 * @generated
	 */
	void setRenderer(ModelElementRenderer value);

	/**
	 * Returns the value of the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EClass Name</em>' attribute.
	 * @see #setEClassName(String)
	 * @see org.unicase.documentexport.documentTemplate.renderers.RenderersPackage#getModelElementRendererMapping_EClassName()
	 * @model
	 * @generated
	 */
	String getEClassName();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.ModelElementRendererMapping#getEClassName <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EClass Name</em>' attribute.
	 * @see #getEClassName()
	 * @generated
	 */
	void setEClassName(String value);

} // ModelElementRendererMapping
