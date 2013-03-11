/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.uiModeling.DropdownItem;
import org.unicase.uiModeling.DropdownList;
import org.unicase.uiModeling.UiModelingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Dropdown List</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.impl.DropdownListImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.unicase.uiModeling.impl.DropdownListImpl#getSelectedItem <em>Selected Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DropdownListImpl extends WidgetImpl implements DropdownList {
	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList<DropdownItem> items;

	/**
	 * The cached value of the '{@link #getSelectedItem() <em>Selected Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedItem()
	 * @generated
	 * @ordered
	 */
	protected DropdownItem selectedItem;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DropdownListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiModelingPackage.Literals.DROPDOWN_LIST;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DropdownItem> getItems() {
		if (items == null) {
			items = new EObjectContainmentWithInverseEList<DropdownItem>(DropdownItem.class, this, UiModelingPackage.DROPDOWN_LIST__ITEMS, UiModelingPackage.DROPDOWN_ITEM__LIST);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DropdownItem getSelectedItem() {
		if (selectedItem != null && selectedItem.eIsProxy()) {
			InternalEObject oldSelectedItem = (InternalEObject)selectedItem;
			selectedItem = (DropdownItem)eResolveProxy(oldSelectedItem);
			if (selectedItem != oldSelectedItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiModelingPackage.DROPDOWN_LIST__SELECTED_ITEM, oldSelectedItem, selectedItem));
			}
		}
		return selectedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DropdownItem basicGetSelectedItem() {
		return selectedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedItem(DropdownItem newSelectedItem) {
		DropdownItem oldSelectedItem = selectedItem;
		selectedItem = newSelectedItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.DROPDOWN_LIST__SELECTED_ITEM, oldSelectedItem, selectedItem));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiModelingPackage.DROPDOWN_LIST__ITEMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getItems()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiModelingPackage.DROPDOWN_LIST__ITEMS:
				return ((InternalEList<?>)getItems()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiModelingPackage.DROPDOWN_LIST__ITEMS:
				return getItems();
			case UiModelingPackage.DROPDOWN_LIST__SELECTED_ITEM:
				if (resolve) return getSelectedItem();
				return basicGetSelectedItem();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UiModelingPackage.DROPDOWN_LIST__ITEMS:
				getItems().clear();
				getItems().addAll((Collection<? extends DropdownItem>)newValue);
				return;
			case UiModelingPackage.DROPDOWN_LIST__SELECTED_ITEM:
				setSelectedItem((DropdownItem)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UiModelingPackage.DROPDOWN_LIST__ITEMS:
				getItems().clear();
				return;
			case UiModelingPackage.DROPDOWN_LIST__SELECTED_ITEM:
				setSelectedItem((DropdownItem)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UiModelingPackage.DROPDOWN_LIST__ITEMS:
				return items != null && !items.isEmpty();
			case UiModelingPackage.DROPDOWN_LIST__SELECTED_ITEM:
				return selectedItem != null;
		}
		return super.eIsSet(featureID);
	}

} // DropdownListImpl
