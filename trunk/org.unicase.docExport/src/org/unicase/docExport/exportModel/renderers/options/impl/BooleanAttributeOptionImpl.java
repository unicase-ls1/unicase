/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.BooleanStyle;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Boolean Attribute Option</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BooleanAttributeOptionImpl#getGlobalOption <em>
 * Global Option</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BooleanAttributeOptionImpl#getBooleanStyle <em>
 * Boolean Style</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BooleanAttributeOptionImpl extends AttributeOptionImpl implements BooleanAttributeOption {
	/**
	 * The cached value of the '{@link #getGlobalOption() <em>Global Option</em>}' reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGlobalOption()
	 * @generated
	 * @ordered
	 */
	protected BooleanAttributeOption globalOption;

	/**
	 * The default value of the '{@link #getBooleanStyle() <em>Boolean Style</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBooleanStyle()
	 * @generated
	 * @ordered
	 */
	protected static final BooleanStyle BOOLEAN_STYLE_EDEFAULT = BooleanStyle.IMAGE;

	/**
	 * The cached value of the '{@link #getBooleanStyle() <em>Boolean Style</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBooleanStyle()
	 * @generated
	 * @ordered
	 */
	protected BooleanStyle booleanStyle = BOOLEAN_STYLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BooleanAttributeOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.BOOLEAN_ATTRIBUTE_OPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanAttributeOption getGlobalOption() {
		if (globalOption != null && globalOption.eIsProxy()) {
			InternalEObject oldGlobalOption = (InternalEObject) globalOption;
			globalOption = (BooleanAttributeOption) eResolveProxy(oldGlobalOption);
			if (globalOption != oldGlobalOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
			}
		}
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanAttributeOption basicGetGlobalOption() {
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGlobalOption(BooleanAttributeOption newGlobalOption) {
		BooleanAttributeOption oldGlobalOption = globalOption;
		globalOption = newGlobalOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BooleanStyle getBooleanStyle() {
		return booleanStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBooleanStyle(BooleanStyle newBooleanStyle) {
		BooleanStyle oldBooleanStyle = booleanStyle;
		booleanStyle = newBooleanStyle == null ? BOOLEAN_STYLE_EDEFAULT : newBooleanStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__BOOLEAN_STYLE, oldBooleanStyle, booleanStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__GLOBAL_OPTION:
			if (resolve)
				return getGlobalOption();
			return basicGetGlobalOption();
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__BOOLEAN_STYLE:
			return getBooleanStyle();
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
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__GLOBAL_OPTION:
			setGlobalOption((BooleanAttributeOption) newValue);
			return;
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__BOOLEAN_STYLE:
			setBooleanStyle((BooleanStyle) newValue);
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
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__GLOBAL_OPTION:
			setGlobalOption((BooleanAttributeOption) null);
			return;
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__BOOLEAN_STYLE:
			setBooleanStyle(BOOLEAN_STYLE_EDEFAULT);
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
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__GLOBAL_OPTION:
			return globalOption != null;
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION__BOOLEAN_STYLE:
			return booleanStyle != BOOLEAN_STYLE_EDEFAULT;
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
		result.append(" (booleanStyle: ");
		result.append(booleanStyle);
		result.append(')');
		return result.toString();
	}

} // BooleanAttributeOptionImpl
