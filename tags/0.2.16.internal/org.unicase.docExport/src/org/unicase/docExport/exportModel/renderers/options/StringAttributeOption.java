/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption#getGlobalOption <em>Global Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption#getTextOption <em>Text Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getStringAttributeOption()
 * @model
 * @generated
 */
public interface StringAttributeOption extends AttributeOption {
	/**
	 * Returns the value of the '<em><b>Global Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Option</em>' reference.
	 * @see #setGlobalOption(StringAttributeOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getStringAttributeOption_GlobalOption()
	 * @model
	 * @generated
	 */
	StringAttributeOption getGlobalOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption#getGlobalOption <em>Global Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Option</em>' reference.
	 * @see #getGlobalOption()
	 * @generated
	 */
	void setGlobalOption(StringAttributeOption value);

	/**
	 * Returns the value of the '<em><b>Text Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Option</em>' containment reference.
	 * @see #setTextOption(TextOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getStringAttributeOption_TextOption()
	 * @model containment="true"
	 * @generated
	 */
	TextOption getTextOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption#getTextOption <em>Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Option</em>' containment reference.
	 * @see #getTextOption()
	 * @generated
	 */
	void setTextOption(TextOption value);
	
	//begin custom code
	TextOption getTextOption(Boolean ignoreGlobalOption);
	//end custom code

} // StringAttributeOption
