/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Dropdown Item</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.DropdownItem#getList <em>List</em>}</li>
 *   <li>{@link org.unicase.uiModeling.DropdownItem#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownItem()
 * @model
 * @generated
 */
public interface DropdownItem extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>List</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.DropdownList#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' container reference.
	 * @see #setList(DropdownList)
	 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownItem_List()
	 * @see org.unicase.uiModeling.DropdownList#getItems
	 * @model opposite="items" transient="false"
	 * @generated
	 */
	DropdownList getList();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.DropdownItem#getList <em>List</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' container reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(DropdownList value);

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
	 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownItem_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.DropdownItem#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // DropdownItem
