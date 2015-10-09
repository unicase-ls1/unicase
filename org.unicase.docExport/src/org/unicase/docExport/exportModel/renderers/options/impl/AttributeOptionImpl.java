/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Option</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl#isHide <em>Hide</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl#isOverwriteGlobalOption <em>
 * Overwrite Global Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl#getAttributeText <em>
 * Attribute Text</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.AttributeOptionImpl#getOrderNumber <em>Order
 * Number</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class AttributeOptionImpl extends RendererOptionImpl implements AttributeOption {
	/**
	 * The default value of the '{@link #isHide() <em>Hide</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isHide()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHide() <em>Hide</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #isHide()
	 * @generated
	 * @ordered
	 */
	protected boolean hide = HIDE_EDEFAULT;

	/**
	 * The default value of the '{@link #isOverwriteGlobalOption() <em>Overwrite Global Option</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isOverwriteGlobalOption()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OVERWRITE_GLOBAL_OPTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOverwriteGlobalOption() <em>Overwrite Global Option</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isOverwriteGlobalOption()
	 * @generated
	 * @ordered
	 */
	protected boolean overwriteGlobalOption = OVERWRITE_GLOBAL_OPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeText() <em>Attribute Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeText()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeText() <em>Attribute Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeText()
	 * @generated
	 * @ordered
	 */
	protected String attributeText = ATTRIBUTE_TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrderNumber() <em>Order Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrderNumber() <em>Order Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getOrderNumber()
	 * @generated
	 * @ordered
	 */
	protected int orderNumber = ORDER_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.ATTRIBUTE_OPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHide() {
		return hide;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHide(boolean newHide) {
		boolean oldHide = hide;
		hide = newHide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.ATTRIBUTE_OPTION__HIDE, oldHide, hide));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverwriteGlobalOption() {
		return overwriteGlobalOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverwriteGlobalOption(boolean newOverwriteGlobalOption) {
		boolean oldOverwriteGlobalOption = overwriteGlobalOption;
		overwriteGlobalOption = newOverwriteGlobalOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION, oldOverwriteGlobalOption, overwriteGlobalOption));
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 * @return the text of the attribute, which should be used instead of the feature name, if not null
	 */
	public String getAttributeText() {
		if (attributeText == null) {
			return "";
		}
		return attributeText;
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeText(String newAttributeText) {
		String oldAttributeText = attributeText;
		attributeText = newAttributeText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.ATTRIBUTE_OPTION__ATTRIBUTE_TEXT, oldAttributeText, attributeText));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrderNumber(int newOrderNumber) {
		int oldOrderNumber = orderNumber;
		orderNumber = newOrderNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.ATTRIBUTE_OPTION__ORDER_NUMBER, oldOrderNumber, orderNumber));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptionsPackage.ATTRIBUTE_OPTION__HIDE:
				return isHide();
			case OptionsPackage.ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION:
				return isOverwriteGlobalOption();
			case OptionsPackage.ATTRIBUTE_OPTION__ATTRIBUTE_TEXT:
				return getAttributeText();
			case OptionsPackage.ATTRIBUTE_OPTION__ORDER_NUMBER:
				return getOrderNumber();
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
			case OptionsPackage.ATTRIBUTE_OPTION__HIDE:
				setHide((Boolean)newValue);
				return;
			case OptionsPackage.ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION:
				setOverwriteGlobalOption((Boolean)newValue);
				return;
			case OptionsPackage.ATTRIBUTE_OPTION__ATTRIBUTE_TEXT:
				setAttributeText((String)newValue);
				return;
			case OptionsPackage.ATTRIBUTE_OPTION__ORDER_NUMBER:
				setOrderNumber((Integer)newValue);
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
			case OptionsPackage.ATTRIBUTE_OPTION__HIDE:
				setHide(HIDE_EDEFAULT);
				return;
			case OptionsPackage.ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION:
				setOverwriteGlobalOption(OVERWRITE_GLOBAL_OPTION_EDEFAULT);
				return;
			case OptionsPackage.ATTRIBUTE_OPTION__ATTRIBUTE_TEXT:
				setAttributeText(ATTRIBUTE_TEXT_EDEFAULT);
				return;
			case OptionsPackage.ATTRIBUTE_OPTION__ORDER_NUMBER:
				setOrderNumber(ORDER_NUMBER_EDEFAULT);
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
			case OptionsPackage.ATTRIBUTE_OPTION__HIDE:
				return hide != HIDE_EDEFAULT;
			case OptionsPackage.ATTRIBUTE_OPTION__OVERWRITE_GLOBAL_OPTION:
				return overwriteGlobalOption != OVERWRITE_GLOBAL_OPTION_EDEFAULT;
			case OptionsPackage.ATTRIBUTE_OPTION__ATTRIBUTE_TEXT:
				return ATTRIBUTE_TEXT_EDEFAULT == null ? attributeText != null : !ATTRIBUTE_TEXT_EDEFAULT.equals(attributeText);
			case OptionsPackage.ATTRIBUTE_OPTION__ORDER_NUMBER:
				return orderNumber != ORDER_NUMBER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hide: ");
		result.append(hide);
		result.append(", overwriteGlobalOption: ");
		result.append(overwriteGlobalOption);
		result.append(", attributeText: ");
		result.append(attributeText);
		result.append(", orderNumber: ");
		result.append(orderNumber);
		result.append(')');
		return result.toString();
	}

} // AttributeOptionImpl
