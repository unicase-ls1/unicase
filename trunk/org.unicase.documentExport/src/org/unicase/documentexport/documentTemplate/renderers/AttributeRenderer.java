/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.documentexport.documentTemplate.Template;
import org.unicase.documentexport.documentTemplate.renderers.options.AttributeOption;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Renderer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.AttributeRenderer#getAttributeOption <em>Attribute Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.documentexport.documentTemplate.renderers.RenderersPackage#getAttributeRenderer()
 * @model abstract="true"
 * @generated
 */
public interface AttributeRenderer extends EObject {

	/**
	 * Returns the value of the '<em><b>Attribute Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Option</em>' reference.
	 * @see #setAttributeOption(AttributeOption)
	 * @see org.unicase.documentexport.documentTemplate.renderers.RenderersPackage#getAttributeRenderer_AttributeOption()
	 * @model
	 * @generated
	 */
	AttributeOption getAttributeOption();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.AttributeRenderer#getAttributeOption <em>Attribute Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Option</em>' reference.
	 * @see #getAttributeOption()
	 * @generated
	 */
	void setAttributeOption(AttributeOption value);

	//begin custom code
	void render(
			EStructuralFeature feature, 
			ModelElement modelElement,
			UCompositeSection section, 
			Template template);
	//end custom code
} // AttributeRenderer
