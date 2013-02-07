/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Radio Button</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.RadioButton#getText <em>Text</em>}</li>
 *   <li>{@link org.unicase.uiModeling.RadioButton#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getRadioButton()
 * @model
 * @generated
 */
public interface RadioButton extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.unicase.uiModeling.UiModelingPackage#getRadioButton_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.RadioButton#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.RadioGroup#getButtons <em>Buttons</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' container reference.
	 * @see #setGroup(RadioGroup)
	 * @see org.unicase.uiModeling.UiModelingPackage#getRadioButton_Group()
	 * @see org.unicase.uiModeling.RadioGroup#getButtons
	 * @model opposite="buttons" transient="false"
	 * @generated
	 */
	RadioGroup getGroup();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.RadioButton#getGroup <em>Group</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group</em>' container reference.
	 * @see #getGroup()
	 * @generated
	 */
	void setGroup(RadioGroup value);

} // RadioButton
