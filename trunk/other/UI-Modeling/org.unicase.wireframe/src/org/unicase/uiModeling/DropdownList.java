/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dropdown List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.DropdownList#getSelectedIndex <em>Selected Index</em>}</li>
 *   <li>{@link org.unicase.uiModeling.DropdownList#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownList()
 * @model
 * @generated
 */
public interface DropdownList extends Widget {
	/**
	 * Returns the value of the '<em><b>Selected Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selected Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selected Index</em>' attribute.
	 * @see #setSelectedIndex(int)
	 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownList_SelectedIndex()
	 * @model default="-1"
	 * @generated
	 */
	int getSelectedIndex();

	/**
	 * Sets the value of the '{@link org.unicase.uiModeling.DropdownList#getSelectedIndex <em>Selected Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selected Index</em>' attribute.
	 * @see #getSelectedIndex()
	 * @generated
	 */
	void setSelectedIndex(int value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.uiModeling.DropdownItem}.
	 * It is bidirectional and its opposite is '{@link org.unicase.uiModeling.DropdownItem#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.unicase.uiModeling.UiModelingPackage#getDropdownList_Items()
	 * @see org.unicase.uiModeling.DropdownItem#getList
	 * @model opposite="list" containment="true"
	 * @generated
	 */
	EList<DropdownItem> getItems();

} // DropdownList
