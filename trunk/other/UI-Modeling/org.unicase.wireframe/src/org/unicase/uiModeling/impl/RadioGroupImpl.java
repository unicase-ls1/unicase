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
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Radio Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.impl.RadioGroupImpl#getSelectedIndex <em>Selected Index</em>}</li>
 *   <li>{@link org.unicase.uiModeling.impl.RadioGroupImpl#getButtons <em>Buttons</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RadioGroupImpl extends WidgetImpl implements RadioGroup {
	/**
	 * The default value of the '{@link #getSelectedIndex() <em>Selected Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int SELECTED_INDEX_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getSelectedIndex() <em>Selected Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedIndex()
	 * @generated
	 * @ordered
	 */
	protected int selectedIndex = SELECTED_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getButtons() <em>Buttons</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getButtons()
	 * @generated
	 * @ordered
	 */
	protected EList<RadioButton> buttons;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RadioGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiModelingPackage.Literals.RADIO_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSelectedIndex() {
		return selectedIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedIndex(int newSelectedIndex) {
		int oldSelectedIndex = selectedIndex;
		selectedIndex = newSelectedIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.RADIO_GROUP__SELECTED_INDEX, oldSelectedIndex, selectedIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiModelingPackage.RADIO_GROUP__SELECTED_INDEX:
				return getSelectedIndex();
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				return getButtons();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UiModelingPackage.RADIO_GROUP__SELECTED_INDEX:
				setSelectedIndex((Integer)newValue);
				return;
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				getButtons().clear();
				getButtons().addAll((Collection<? extends RadioButton>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UiModelingPackage.RADIO_GROUP__SELECTED_INDEX:
				setSelectedIndex(SELECTED_INDEX_EDEFAULT);
				return;
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				getButtons().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UiModelingPackage.RADIO_GROUP__SELECTED_INDEX:
				return selectedIndex != SELECTED_INDEX_EDEFAULT;
			case UiModelingPackage.RADIO_GROUP__BUTTONS:
				return buttons != null && !buttons.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (selectedIndex: ");
		result.append(selectedIndex);
		result.append(')');
		return result.toString();
	}

} //RadioGroupImpl
