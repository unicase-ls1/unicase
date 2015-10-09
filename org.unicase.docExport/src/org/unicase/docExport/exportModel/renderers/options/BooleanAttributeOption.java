/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Boolean Attribute Option</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
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
	 * Returns the value of the '<em><b>Boolean Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.docExport.exportModel.renderers.options.BooleanStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Style</em>' attribute isn't clear, there really should be more of a
	 * description here...
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Style</em>' attribute.
	 * @see org.unicase.docExport.exportModel.renderers.options.BooleanStyle
	 * @see #getBooleanStyle()
	 * @generated
	 */
	void setBooleanStyle(BooleanStyle value);

} // BooleanAttributeOption
