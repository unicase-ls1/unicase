/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.options;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Reference Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption#getGlobalOption <em>Global Option</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption#getReferenceOption <em>Reference Option</em>}</li>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption#getListOption <em>List Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getMultiReferenceAttributeOption()
 * @model
 * @generated
 */
public interface MultiReferenceAttributeOption extends ReferenceAttributeOption {
	/**
	 * Returns the value of the '<em><b>Global Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Option</em>' reference.
	 * @see #setGlobalOption(MultiReferenceAttributeOption)
	 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getMultiReferenceAttributeOption_GlobalOption()
	 * @model
	 * @generated
	 */
	MultiReferenceAttributeOption getGlobalOption();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption#getGlobalOption <em>Global Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Option</em>' reference.
	 * @see #getGlobalOption()
	 * @generated
	 */
	void setGlobalOption(MultiReferenceAttributeOption value);

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
	 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getMultiReferenceAttributeOption_ReferenceOption()
	 * @model containment="true"
	 * @generated
	 */
	ReferenceOption getReferenceOption();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption#getReferenceOption <em>Reference Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference Option</em>' containment reference.
	 * @see #getReferenceOption()
	 * @generated
	 */
	void setReferenceOption(ReferenceOption value);

	/**
	 * Returns the value of the '<em><b>List Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List Option</em>' containment reference.
	 * @see #setListOption(ListOption)
	 * @see org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage#getMultiReferenceAttributeOption_ListOption()
	 * @model containment="true"
	 * @generated
	 */
	ListOption getListOption();

	/**
	 * Sets the value of the '{@link org.unicase.documentexport.documentTemplate.renderers.options.MultiReferenceAttributeOption#getListOption <em>List Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List Option</em>' containment reference.
	 * @see #getListOption()
	 * @generated
	 */
	void setListOption(ListOption value);
	
	//begin custom code
	ReferenceOption getReferenceOption(Boolean ignoreGlobalOption);
	ListOption getListOption(Boolean ignoreGlobalOption);
	//end custom code

} // MultiReferenceAttributeOption
