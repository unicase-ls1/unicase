/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.docExport.exportModel.renderers.options.DateAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.DateStyle;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Date Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.DateAttributeOptionImpl#getGlobalOption <em>Global Option</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.DateAttributeOptionImpl#getDateStyle <em>Date Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DateAttributeOptionImpl extends AttributeOptionImpl implements DateAttributeOption {
	/**
	 * The cached value of the '{@link #getGlobalOption() <em>Global Option</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalOption()
	 * @generated
	 * @ordered
	 */
	protected DateAttributeOption globalOption;

	/**
	 * The default value of the '{@link #getDateStyle() <em>Date Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateStyle()
	 * @generated
	 * @ordered
	 */
	protected static final DateStyle DATE_STYLE_EDEFAULT = DateStyle.NICE1;

	/**
	 * The cached value of the '{@link #getDateStyle() <em>Date Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateStyle()
	 * @generated
	 * @ordered
	 */
	protected DateStyle dateStyle = DATE_STYLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DateAttributeOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.DATE_ATTRIBUTE_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateAttributeOption getGlobalOption() {
		if (globalOption != null && globalOption.eIsProxy()) {
			InternalEObject oldGlobalOption = (InternalEObject)globalOption;
			globalOption = (DateAttributeOption)eResolveProxy(oldGlobalOption);
			if (globalOption != oldGlobalOption) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptionsPackage.DATE_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
			}
		}
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateAttributeOption basicGetGlobalOption() {
		return globalOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOption(DateAttributeOption newGlobalOption) {
		DateAttributeOption oldGlobalOption = globalOption;
		globalOption = newGlobalOption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.DATE_ATTRIBUTE_OPTION__GLOBAL_OPTION, oldGlobalOption, globalOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateStyle getDateStyle() {
		return dateStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateStyle(DateStyle newDateStyle) {
		DateStyle oldDateStyle = dateStyle;
		dateStyle = newDateStyle == null ? DATE_STYLE_EDEFAULT : newDateStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.DATE_ATTRIBUTE_OPTION__DATE_STYLE, oldDateStyle, dateStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptionsPackage.DATE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				if (resolve) return getGlobalOption();
				return basicGetGlobalOption();
			case OptionsPackage.DATE_ATTRIBUTE_OPTION__DATE_STYLE:
				return getDateStyle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OptionsPackage.DATE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				setGlobalOption((DateAttributeOption)newValue);
				return;
			case OptionsPackage.DATE_ATTRIBUTE_OPTION__DATE_STYLE:
				setDateStyle((DateStyle)newValue);
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
			case OptionsPackage.DATE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				setGlobalOption((DateAttributeOption)null);
				return;
			case OptionsPackage.DATE_ATTRIBUTE_OPTION__DATE_STYLE:
				setDateStyle(DATE_STYLE_EDEFAULT);
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
			case OptionsPackage.DATE_ATTRIBUTE_OPTION__GLOBAL_OPTION:
				return globalOption != null;
			case OptionsPackage.DATE_ATTRIBUTE_OPTION__DATE_STYLE:
				return dateStyle != DATE_STYLE_EDEFAULT;
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
		result.append(" (dateStyle: ");
		result.append(dateStyle);
		result.append(')');
		return result.toString();
	}

} //DateAttributeOptionImpl
