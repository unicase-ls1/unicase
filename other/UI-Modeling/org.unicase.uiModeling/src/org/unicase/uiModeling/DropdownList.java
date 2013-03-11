/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Dropdown List</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.DropdownList#getItems <em>Items</em>}</li>
 *   <li>{@link org.unicase.uiModeling.DropdownList#getSelectedItem <em>Selected Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownList()
 * @model
 * @generated
 */
public interface DropdownList extends Widget {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.uiModeling.DropdownItem}.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.DropdownItem#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownList_Items()
	 * @see org.unicase.uiModeling.DropdownItem#getList
	 * @model opposite="list" containment="true"
	 * @generated
	 */
	EList<DropdownItem> getItems();

	/**
	 * Returns the value of the '<em><b>Selected Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Item</em>' reference.
	 * @see #setSelectedItem(DropdownItem)
	 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownList_SelectedItem()
	 * @model
	 * @generated
	 */
	DropdownItem getSelectedItem();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.DropdownList#getSelectedItem <em>Selected Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected Item</em>' reference.
	 * @see #getSelectedItem()
	 * @generated
	 */
	void setSelectedItem(DropdownItem value);

} // DropdownList
