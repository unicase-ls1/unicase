/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage;
import org.unicase.documentexport.documentTemplate.renderers.options.ReferenceAttributeOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Attribute Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.impl.ReferenceAttributeOptionImpl#isContained <em>Contained</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ReferenceAttributeOptionImpl extends AttributeOptionImpl implements ReferenceAttributeOption {
	/**
	 * The default value of the '{@link #isContained() <em>Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContained()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContained() <em>Contained</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContained()
	 * @generated
	 * @ordered
	 */
	protected boolean contained = CONTAINED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceAttributeOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.REFERENCE_ATTRIBUTE_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContained() {
		return contained;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContained(boolean newContained) {
		boolean oldContained = contained;
		contained = newContained;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED, oldContained, contained));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED:
				return isContained() ? Boolean.TRUE : Boolean.FALSE;
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
			case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED:
				setContained(((Boolean)newValue).booleanValue());
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
			case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED:
				setContained(CONTAINED_EDEFAULT);
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
			case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED:
				return contained != CONTAINED_EDEFAULT;
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
		result.append(" (contained: ");
		result.append(contained);
		result.append(')');
		return result.toString();
	}

} //ReferenceAttributeOptionImpl
