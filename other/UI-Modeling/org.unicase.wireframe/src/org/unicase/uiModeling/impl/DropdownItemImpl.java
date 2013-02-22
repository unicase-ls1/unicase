/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.uiModeling.DropdownItem;
import org.unicase.uiModeling.DropdownList;
import org.unicase.uiModeling.UiModelingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Dropdown Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.uiModeling.impl.DropdownItemImpl#getList <em>List</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DropdownItemImpl extends UnicaseModelElementImpl implements DropdownItem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DropdownItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiModelingPackage.Literals.DROPDOWN_ITEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DropdownList getList() {
		if (eContainerFeatureID() != UiModelingPackage.DROPDOWN_ITEM__LIST)
			return null;
		return (DropdownList) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetList(DropdownList newList, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newList, UiModelingPackage.DROPDOWN_ITEM__LIST, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setList(DropdownList newList) {
		if (newList != eInternalContainer()
			|| (eContainerFeatureID() != UiModelingPackage.DROPDOWN_ITEM__LIST && newList != null)) {
			if (EcoreUtil.isAncestor(this, newList))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newList != null)
				msgs = ((InternalEObject) newList).eInverseAdd(this, UiModelingPackage.DROPDOWN_LIST__ITEMS,
					DropdownList.class, msgs);
			msgs = basicSetList(newList, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.DROPDOWN_ITEM__LIST, newList,
				newList));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UiModelingPackage.DROPDOWN_ITEM__LIST:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetList((DropdownList) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UiModelingPackage.DROPDOWN_ITEM__LIST:
			return basicSetList(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case UiModelingPackage.DROPDOWN_ITEM__LIST:
			return eInternalContainer().eInverseRemove(this, UiModelingPackage.DROPDOWN_LIST__ITEMS,
				DropdownList.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UiModelingPackage.DROPDOWN_ITEM__LIST:
			return getList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UiModelingPackage.DROPDOWN_ITEM__LIST:
			setList((DropdownList) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case UiModelingPackage.DROPDOWN_ITEM__LIST:
			setList((DropdownList) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case UiModelingPackage.DROPDOWN_ITEM__LIST:
			return getList() != null;
		}
		return super.eIsSet(featureID);
	}

} // DropdownItemImpl
