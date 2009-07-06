/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption#getGlobalOption <em>Global Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption#getBooleanStyle <em>Boolean Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBooleanAttributeOption()
 * @model
 * @generated
 */
public interface BooleanAttributeOption extends AttributeOption {
	/**
	 * Returns the value of the '<em><b>Global Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Option</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Option</em>' reference.
	 * @see #setGlobalOption(BooleanAttributeOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBooleanAttributeOption_GlobalOption()
	 * @model
	 * @generated
	 */
	BooleanAttributeOption getGlobalOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption#getGlobalOption <em>Global Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Option</em>' reference.
	 * @see #getGlobalOption()
	 * @generated
	 */
	void setGlobalOption(BooleanAttributeOption value);

	/**
	 * Returns the value of the '<em><b>Boolean Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.docExport.exportModel.renderers.options.BooleanStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.BooleanStyle
	 * @see #setBooleanStyle(BooleanStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getBooleanAttributeOption_BooleanStyle()
	 * @model
	 * @generated
	 */
	BooleanStyle getBooleanStyle();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption#getBooleanStyle <em>Boolean Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.BooleanStyle
	 * @see #getBooleanStyle()
	 * @generated
	 */
	void setBooleanStyle(BooleanStyle value);

} // BooleanAttributeOption
