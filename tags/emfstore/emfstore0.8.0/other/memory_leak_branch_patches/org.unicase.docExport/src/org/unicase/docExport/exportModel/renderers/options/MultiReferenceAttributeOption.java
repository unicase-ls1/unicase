/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multi Reference Attribute Option</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption#getListOption <em>List
 * Option</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getMultiReferenceAttributeOption()
 * @model
 * @generated
 */
public interface MultiReferenceAttributeOption extends ReferenceAttributeOption {
	/**
	 * Returns the value of the '<em><b>List Option</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List Option</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>List Option</em>' containment reference.
	 * @see #setListOption(ListOption)
	 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage#getMultiReferenceAttributeOption_ListOption()
	 * @model containment="true"
	 * @generated
	 */
	ListOption getListOption();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption#getListOption
	 * <em>List Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>List Option</em>' containment reference.
	 * @see #getListOption()
	 * @generated
	 */
	void setListOption(ListOption value);

} // MultiReferenceAttributeOption
