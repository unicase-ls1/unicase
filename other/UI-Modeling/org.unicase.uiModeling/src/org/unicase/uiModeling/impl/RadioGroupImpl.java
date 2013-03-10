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
import org.unicase.uiModeling.RadioButton;
import org.unicase.uiModeling.RadioGroup;
import org.unicase.uiModeling.UiModelingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Radio Group</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.impl.RadioGroupImpl#getButtons <em>Buttons</em>}</li>
 *   <li>{@link org.unicase.uiModeling.impl.RadioGroupImpl#getSelectedItem <em>Selected Item</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RadioGroupImpl extends WidgetImpl implements RadioGroup {
	/**
	 * The cached value of the '{@link #getButtons() <em>Buttons</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getButtons()
	 * @generated
	 * @ordered
	 */
	protected EList<RadioButton> buttons;

	/**
	 * The cached value of the '{@link #getSelectedItem() <em>Selected Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedItem()
	 * @generated
	 * @ordered
	 */
	protected RadioButton selectedItem;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RadioGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiModelingPackage.Literals.RADIO_GROUP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RadioButton> getButtons() {
		if (buttons == null) {
			buttons = new EObjectContainmentWithInverseEList<RadioButton>(RadioButton.class, this, UiModelingPackage.RADIO_GROUP__BUTTONS, UiModelingPackage.RADIO_BUTTON__GROUP);
		}
		return buttons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RadioButton getSelectedItem() {
		if (selectedItem != null && selectedItem.eIsProxy()) {
			InternalEObject oldSelectedItem = (InternalEObject)selectedItem;
			selectedItem = (RadioButton)eResolveProxy(oldSelectedItem);
			if (selectedItem != oldSelectedItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UiModelingPackage.RADIO_GROUP__SELECTED_ITEM, oldSelectedItem, selectedItem));
			}
		}
		return selectedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RadioButton basicGetSelectedItem() {
		return selectedItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedItem(RadioButton newSelectedItem) {
		RadioButton oldSelectedItem = selectedItem;
		selectedItem = newSelectedItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.RADIO_GROUP__SELECTED_ITEM, oldSelectedItem, selectedItem));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getButtons()).basicAdd(otherEnd, msgs);
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
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				return ((InternalEList<?>)getButtons()).basicRemove(otherEnd, msgs);
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
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				return getButtons();
			case UiModelingPackage.RADIO_GROUP__SELECTED_ITEM:
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
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				getButtons().clear();
				getButtons().addAll((Collection<? extends RadioButton>)newValue);
				return;
			case UiModelingPackage.RADIO_GROUP__SELECTED_ITEM:
				setSelectedItem((RadioButton)newValue);
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
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				getButtons().clear();
				return;
			case UiModelingPackage.RADIO_GROUP__SELECTED_ITEM:
				setSelectedItem((RadioButton)null);
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
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				return buttons != null && !buttons.isEmpty();
			case UiModelingPackage.RADIO_GROUP__SELECTED_ITEM:
				return selectedItem != null;
		}
		return super.eIsSet(featureID);
	}

} // RadioGroupImpl
