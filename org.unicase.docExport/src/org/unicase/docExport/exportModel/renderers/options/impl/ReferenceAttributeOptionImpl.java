/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Reference Attribute Option</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl#isContained <em>
 * Contained</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.ReferenceAttributeOptionImpl#getReferenceOption
 * <em>Reference Option</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class ReferenceAttributeOptionImpl extends AttributeOptionImpl implements ReferenceAttributeOption {
	/**
	 * The default value of the '{@link #isContained() <em>Contained</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isContained()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContained() <em>Contained</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isContained()
	 * @generated
	 * @ordered
	 */
	protected boolean contained = CONTAINED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferenceOption() <em>Reference Option</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferenceOption()
	 * @generated
	 * @ordered
	 */
	protected ReferenceOption referenceOption;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ReferenceAttributeOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.REFERENCE_ATTRIBUTE_OPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isContained() {
		return contained;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setContained(boolean newContained) {
		boolean oldContained = contained;
		contained = newContained;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED,
				oldContained, contained));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReferenceOption getReferenceOption() {
		return referenceOption;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetReferenceOption(ReferenceOption newReferenceOption, NotificationChain msgs) {
		ReferenceOption oldReferenceOption = referenceOption;
		referenceOption = newReferenceOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION, oldReferenceOption, newReferenceOption);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferenceOption(ReferenceOption newReferenceOption) {
		if (newReferenceOption != referenceOption) {
			NotificationChain msgs = null;
			if (referenceOption != null)
				msgs = ((InternalEObject) referenceOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION, null, msgs);
			if (newReferenceOption != null)
				msgs = ((InternalEObject) newReferenceOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION, null, msgs);
			msgs = basicSetReferenceOption(newReferenceOption, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION, newReferenceOption, newReferenceOption));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
			return basicSetReferenceOption(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED:
			return isContained();
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
			return getReferenceOption();
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
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED:
			setContained((Boolean) newValue);
			return;
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
			setReferenceOption((ReferenceOption) newValue);
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
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED:
			setContained(CONTAINED_EDEFAULT);
			return;
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
			setReferenceOption((ReferenceOption) null);
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
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__CONTAINED:
			return contained != CONTAINED_EDEFAULT;
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION__REFERENCE_OPTION:
			return referenceOption != null;
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
		result.append(" (contained: ");
		result.append(contained);
		result.append(')');
		return result.toString();
	}

} // ReferenceAttributeOptionImpl
