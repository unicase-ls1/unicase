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
import org.unicase.uiModeling.Checkbox;
import org.unicase.uiModeling.CheckboxGroup;
import org.unicase.uiModeling.UiModelingPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Checkbox</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.uiModeling.impl.CheckboxImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.unicase.uiModeling.impl.CheckboxImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.unicase.uiModeling.impl.CheckboxImpl#isChecked <em>Checked</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckboxImpl extends UnicaseModelElementImpl implements Checkbox {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECKED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected boolean checked = CHECKED_EDEFAULT;
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckboxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UiModelingPackage.Literals.CHECKBOX;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CheckboxGroup getGroup() {
		if (eContainerFeatureID() != UiModelingPackage.CHECKBOX__GROUP) return null;
		return (CheckboxGroup)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroup(CheckboxGroup newGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGroup, UiModelingPackage.CHECKBOX__GROUP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(CheckboxGroup newGroup) {
		if (newGroup != eInternalContainer() || (eContainerFeatureID() != UiModelingPackage.CHECKBOX__GROUP && newGroup != null)) {
			if (EcoreUtil.isAncestor(this, newGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGroup != null)
				msgs = ((InternalEObject)newGroup).eInverseAdd(this, UiModelingPackage.CHECKBOX_GROUP__BOXES, CheckboxGroup.class, msgs);
			msgs = basicSetGroup(newGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.CHECKBOX__GROUP, newGroup, newGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.CHECKBOX__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChecked(boolean newChecked) {
		boolean oldChecked = checked;
		checked = newChecked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UiModelingPackage.CHECKBOX__CHECKED, oldChecked, checked));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UiModelingPackage.CHECKBOX__GROUP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGroup((CheckboxGroup)otherEnd, msgs);
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
			case UiModelingPackage.CHECKBOX__GROUP:
				return basicSetGroup(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case UiModelingPackage.CHECKBOX__GROUP:
				return eInternalContainer().eInverseRemove(this, UiModelingPackage.CHECKBOX_GROUP__BOXES, CheckboxGroup.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UiModelingPackage.CHECKBOX__GROUP:
				return getGroup();
			case UiModelingPackage.CHECKBOX__TEXT:
				return getText();
			case UiModelingPackage.CHECKBOX__CHECKED:
				return isChecked();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UiModelingPackage.CHECKBOX__GROUP:
				setGroup((CheckboxGroup)newValue);
				return;
			case UiModelingPackage.CHECKBOX__TEXT:
				setText((String)newValue);
				return;
			case UiModelingPackage.CHECKBOX__CHECKED:
				setChecked((Boolean)newValue);
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
			case UiModelingPackage.CHECKBOX__GROUP:
				setGroup((CheckboxGroup)null);
				return;
			case UiModelingPackage.CHECKBOX__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case UiModelingPackage.CHECKBOX__CHECKED:
				setChecked(CHECKED_EDEFAULT);
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
			case UiModelingPackage.CHECKBOX__GROUP:
				return getGroup() != null;
			case UiModelingPackage.CHECKBOX__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case UiModelingPackage.CHECKBOX__CHECKED:
				return checked != CHECKED_EDEFAULT;
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
		result.append(" (text: ");
		result.append(text);
		result.append(", checked: ");
		result.append(checked);
		result.append(')');
		return result.toString();
	}

} // CheckboxImpl
