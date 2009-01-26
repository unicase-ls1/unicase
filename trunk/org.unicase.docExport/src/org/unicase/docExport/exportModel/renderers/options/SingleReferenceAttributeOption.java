/**
 * <copyright> </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Single Reference Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption#getGlobalOption <em>
 * Global Option</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getSingleReferenceAttributeOption()
 * @model
 * @generated
 */
public interface SingleReferenceAttributeOption extends ReferenceAttributeOption {
	/**
	 * Returns the value of the '<em><b>Global Option</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Option</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Global Option</em>' reference.
	 * @see #setGlobalOption(SingleReferenceAttributeOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getSingleReferenceAttributeOption_GlobalOption()
	 * @model
	 * @generated
	 */
	SingleReferenceAttributeOption getGlobalOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption#getGlobalOption
	 * <em>Global Option</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Global Option</em>' reference.
	 * @see #getGlobalOption()
	 * @generated
	 */
	void setGlobalOption(SingleReferenceAttributeOption value);

	// begin custom code
	ReferenceOption getReferenceOption(Boolean ignoreGlobalOption);
	// end custom code

} // SingleReferenceAttributeOption
