/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute Option</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#isHide <em>Hide</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#isOverwriteGlobalOption <em>Overwrite
 * Global Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#getAttributeText <em>Attribute Text
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#getOrderNumber <em>Order Number</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getAttributeOption()
 * @model abstract="true"
 * @generated
 */
public interface AttributeOption extends RendererOption {
	/**
	 * Returns the value of the '<em><b>Hide</b></em>' attribute. The default value is <code>"false"</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Hide</em>' attribute.
	 * @see #setHide(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getAttributeOption_Hide()
	 * @model default="false"
	 * @generated
	 */
	boolean isHide();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#isHide
	 * <em>Hide</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Hide</em>' attribute.
	 * @see #isHide()
	 * @generated
	 */
	void setHide(boolean value);

	/**
	 * Returns the value of the '<em><b>Overwrite Global Option</b></em>' attribute. The default value is
	 * <code>"false"</code>. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overwrite Global Option</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Overwrite Global Option</em>' attribute.
	 * @see #setOverwriteGlobalOption(boolean)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getAttributeOption_OverwriteGlobalOption()
	 * @model default="false"
	 * @generated
	 */
	boolean isOverwriteGlobalOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#isOverwriteGlobalOption
	 * <em>Overwrite Global Option</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Overwrite Global Option</em>' attribute.
	 * @see #isOverwriteGlobalOption()
	 * @generated
	 */
	void setOverwriteGlobalOption(boolean value);

	/**
	 * Returns the value of the '<em><b>Attribute Text</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Text</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attribute Text</em>' attribute.
	 * @see #setAttributeText(String)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getAttributeOption_AttributeText()
	 * @model
	 * @generated
	 */
	String getAttributeText();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#getAttributeText
	 * <em>Attribute Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Attribute Text</em>' attribute.
	 * @see #getAttributeText()
	 * @generated
	 */
	void setAttributeText(String value);

	/**
	 * Returns the value of the '<em><b>Order Number</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order Number</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Order Number</em>' attribute.
	 * @see #setOrderNumber(int)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getAttributeOption_OrderNumber()
	 * @model
	 * @generated
	 */
	int getOrderNumber();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.options.AttributeOption#getOrderNumber
	 * <em>Order Number</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Order Number</em>' attribute.
	 * @see #getOrderNumber()
	 * @generated
	 */
	void setOrderNumber(int value);

} // AttributeOption
