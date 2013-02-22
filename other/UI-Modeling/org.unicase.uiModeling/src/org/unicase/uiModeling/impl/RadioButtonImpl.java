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
import org.unicase.uiModeling.RadioButton;
import org.unicase.uiModeling.RadioGroup;
import org.unicase.uiModeling.UiModelingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Radio Button</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.uiModeling.impl.RadioButtonImpl#getText <em>Text</em>}</li>
 * <li>{@link org.unicase.uiModeling.impl.RadioButtonImpl#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RadioButtonImpl extends UnicaseModelElementImpl implements RadioButton {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RadioButtonImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiModelingPackage.Literals.RADIO_BUTTON;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.RADIO_BUTTON__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RadioGroup getGroup() {
		if (eContainerFeatureID() != UiModelingPackage.RADIO_BUTTON__GROUP)
			return null;
		return (RadioGroup) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGroup(RadioGroup newGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newGroup, UiModelingPackage.RADIO_BUTTON__GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGroup(RadioGroup newGroup) {
		if (newGroup != eInternalContainer()
			|| (eContainerFeatureID() != UiModelingPackage.RADIO_BUTTON__GROUP && newGroup != null)) {
			if (EcoreUtil.isAncestor(this, newGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGroup != null)
				msgs = ((InternalEObject) newGroup).eInverseAdd(this, UiModelingPackage.RADIO_GROUP__BUTTONS,
					RadioGroup.class, msgs);
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.RADIO_BUTTON__GROUP, newGroup,
				newGroup));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UiModelingPackage.RADIO_BUTTON__GROUP:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetGroup((RadioGroup) otherEnd, msgs);
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
		case UiModelingPackage.RADIO_BUTTON__GROUP:
			return basicSetGroup(null, msgs);
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
		case UiModelingPackage.RADIO_BUTTON__GROUP:
			return eInternalContainer().eInverseRemove(this, UiModelingPackage.RADIO_GROUP__BUTTONS, RadioGroup.class,
				msgs);
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
		case UiModelingPackage.RADIO_BUTTON__TEXT:
			return getText();
		case UiModelingPackage.RADIO_BUTTON__GROUP:
			return getGroup();
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
		case UiModelingPackage.RADIO_BUTTON__TEXT:
			setText((String) newValue);
			return;
		case UiModelingPackage.RADIO_BUTTON__GROUP:
			setGroup((RadioGroup) newValue);
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
		case UiModelingPackage.RADIO_BUTTON__TEXT:
			setText(TEXT_EDEFAULT);
			return;
		case UiModelingPackage.RADIO_BUTTON__GROUP:
			setGroup((RadioGroup) null);
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
		case UiModelingPackage.RADIO_BUTTON__TEXT:
			return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		case UiModelingPackage.RADIO_BUTTON__GROUP:
			return getGroup() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} // RadioButtonImpl
