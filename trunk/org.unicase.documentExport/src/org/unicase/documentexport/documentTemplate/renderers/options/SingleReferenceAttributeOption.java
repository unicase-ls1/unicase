/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.options;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Reference Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.SingleReferenceAttributeOption#getGlobalOption <em>Global Option</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.SingleReferenceAttributeOption#getReferenceOption <em>Reference Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getSingleReferenceAttributeOption()
 * @model
 * @generated
 */
public interface SingleReferenceAttributeOption extends ReferenceAttributeOption {
	/**
	 * Returns the value of the '<em><b>Global Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Option</em>' reference.
	 * @see #setGlobalOption(SingleReferenceAttributeOption)
	 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getSingleReferenceAttributeOption_GlobalOption()
	 * @model
	 * @generated
	 */
	SingleReferenceAttributeOption getGlobalOption();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.options.SingleReferenceAttributeOption#getGlobalOption <em>Global Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Option</em>' reference.
	 * @see #getGlobalOption()
	 * @generated
	 */
	void setGlobalOption(SingleReferenceAttributeOption value);

	/**
	 * Returns the value of the '<em><b>Reference Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Option</em>' containment reference.
	 * @see #setReferenceOption(ReferenceOption)
	 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getSingleReferenceAttributeOption_ReferenceOption()
	 * @model containment="true"
	 * @generated
	 */
	ReferenceOption getReferenceOption();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.options.SingleReferenceAttributeOption#getReferenceOption <em>Reference Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Option</em>' containment reference.
	 * @see #getReferenceOption()
	 * @generated
	 */
	void setReferenceOption(ReferenceOption value);
	
	//begin custom code
	ReferenceOption getReferenceOption(Boolean ignoreGlobalOption);
	//end custom code

} // SingleReferenceAttributeOption
