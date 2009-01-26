/**
 * <copyright> </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Date Attribute Option</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption#getGlobalOption <em>Global Option
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption#getDateStyle <em>Date Style</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getDateAttributeOption()
 * @model
 * @generated
 */
public interface DateAttributeOption extends AttributeOption {
	/**
	 * Returns the value of the '<em><b>Global Option</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Option</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Global Option</em>' reference.
	 * @see #setGlobalOption(DateAttributeOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getDateAttributeOption_GlobalOption()
	 * @model
	 * @generated
	 */
	DateAttributeOption getGlobalOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption#getGlobalOption
	 * <em>Global Option</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Global Option</em>' reference.
	 * @see #getGlobalOption()
	 * @generated
	 */
	void setGlobalOption(DateAttributeOption value);

	/**
	 * Returns the value of the '<em><b>Date Style</b></em>' attribute. The literals are from the enumeration
	 * {@link org.unicase.docExport.exportModel.renderers.options.DateStyle}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Style</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Date Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.DateStyle
	 * @see #setDateStyle(DateStyle)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getDateAttributeOption_DateStyle()
	 * @model
	 * @generated
	 */
	DateStyle getDateStyle();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption#getDateStyle <em>Date Style</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Date Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.DateStyle
	 * @see #getDateStyle()
	 * @generated
	 */
	void setDateStyle(DateStyle value);

} // DateAttributeOption
