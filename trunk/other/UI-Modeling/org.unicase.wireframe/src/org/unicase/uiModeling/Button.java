/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Button</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.Button#getStyle <em>Style</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getButton()
 * @model
 * @generated
 */
public interface Button extends Widget {
	/**
	 * Returns the value of the '<em><b>Style</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.uiModeling.ButtonStyle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' attribute.
	 * @see org.unicase.uiModeling.ButtonStyle
	 * @see #setStyle(ButtonStyle)
	 * @see org.unicase.uiModeling.UiModelingPackage#getButton_Style()
	 * @model
	 * @generated
	 */
	ButtonStyle getStyle();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.Button#getStyle <em>Style</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Style</em>' attribute.
	 * @see org.unicase.uiModeling.ButtonStyle
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(ButtonStyle value);

} // Button
