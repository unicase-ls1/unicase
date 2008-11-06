/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.documentexport.documentTemplate.renderers.options.OptionsFactory;
import org.unicase.documentexport.documentTemplate.renderers.options.OptionsPackage;
import org.unicase.documentexport.documentTemplate.renderers.options.ReferenceOption;
import org.unicase.documentexport.documentTemplate.renderers.options.TextOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.documentexport.documentTemplate.renderers.options.impl.ReferenceOptionImpl#getTextOption <em>Text Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceOptionImpl extends RendererOptionImpl implements ReferenceOption {
	/**
	 * The cached value of the '{@link #getTextOption() <em>Text Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextOption()
	 * @generated
	 * @ordered
	 */
	protected TextOption textOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ReferenceOptionImpl() {
		super();
		textOption = OptionsFactory.eINSTANCE.createTextOption();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.REFERENCE_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextOption getTextOption() {
		return textOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTextOption(TextOption newTextOption, NotificationChain msgs) {
		TextOption oldTextOption = textOption;
		textOption = newTextOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.REFERENCE_OPTION__TEXT_OPTION, oldTextOption, newTextOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextOption(TextOption newTextOption) {
		if (newTextOption != textOption) {
			NotificationChain msgs = null;
			if (textOption != null)
				msgs = ((InternalEObject)textOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.REFERENCE_OPTION__TEXT_OPTION, null, msgs);
			if (newTextOption != null)
				msgs = ((InternalEObject)newTextOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.REFERENCE_OPTION__TEXT_OPTION, null, msgs);
			msgs = basicSetTextOption(newTextOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.REFERENCE_OPTION__TEXT_OPTION, newTextOption, newTextOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptionsPackage.REFERENCE_OPTION__TEXT_OPTION:
				return basicSetTextOption(null, msgs);
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
			case OptionsPackage.REFERENCE_OPTION__TEXT_OPTION:
				return getTextOption();
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
			case OptionsPackage.REFERENCE_OPTION__TEXT_OPTION:
				setTextOption((TextOption)newValue);
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
			case OptionsPackage.REFERENCE_OPTION__TEXT_OPTION:
				setTextOption((TextOption)null);
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
			case OptionsPackage.REFERENCE_OPTION__TEXT_OPTION:
				return textOption != null;
		}
		return super.eIsSet(featureID);
	}

} //ReferenceOptionImpl
