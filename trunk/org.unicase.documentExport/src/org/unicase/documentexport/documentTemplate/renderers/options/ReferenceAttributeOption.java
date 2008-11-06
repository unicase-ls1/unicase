/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.options;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.ReferenceAttributeOption#isContained <em>Contained</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getReferenceAttributeOption()
 * @model abstract="true"
 * @generated
 */
public interface ReferenceAttributeOption extends AttributeOption {
	/**
	 * Returns the value of the '<em><b>Contained</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained</em>' attribute.
	 * @see #setContained(boolean)
	 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getReferenceAttributeOption_Contained()
	 * @model
	 * @generated
	 */
	boolean isContained();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.options.ReferenceAttributeOption#isContained <em>Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained</em>' attribute.
	 * @see #isContained()
	 * @generated
	 */
	void setContained(boolean value);

} // ReferenceAttributeOption
