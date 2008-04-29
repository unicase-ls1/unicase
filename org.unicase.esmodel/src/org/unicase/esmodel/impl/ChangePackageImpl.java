/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.change.ChangeDescription;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.unicase.esmodel.ChangePackage;
import org.unicase.esmodel.EsmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.esmodel.impl.ChangePackageImpl#getFowardDelta <em>Foward Delta</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.ChangePackageImpl#getBackwardDelta <em>Backward Delta</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangePackageImpl extends EObjectImpl implements ChangePackage {
	/**
	 * The cached value of the '{@link #getFowardDelta() <em>Foward Delta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFowardDelta()
	 * @generated
	 * @ordered
	 */
	protected ChangeDescription fowardDelta;

	/**
	 * The cached value of the '{@link #getBackwardDelta() <em>Backward Delta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackwardDelta()
	 * @generated
	 * @ordered
	 */
	protected ChangeDescription backwardDelta;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsmodelPackage.Literals.CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeDescription getFowardDelta() {
		if (fowardDelta != null && fowardDelta.eIsProxy()) {
			InternalEObject oldFowardDelta = (InternalEObject)fowardDelta;
			fowardDelta = (ChangeDescription)eResolveProxy(oldFowardDelta);
			if (fowardDelta != oldFowardDelta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.CHANGE_PACKAGE__FOWARD_DELTA, oldFowardDelta, fowardDelta));
			}
		}
		return fowardDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeDescription basicGetFowardDelta() {
		return fowardDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeDescription getBackwardDelta() {
		if (backwardDelta != null && backwardDelta.eIsProxy()) {
			InternalEObject oldBackwardDelta = (InternalEObject)backwardDelta;
			backwardDelta = (ChangeDescription)eResolveProxy(oldBackwardDelta);
			if (backwardDelta != oldBackwardDelta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.CHANGE_PACKAGE__BACKWARD_DELTA, oldBackwardDelta, backwardDelta));
			}
		}
		return backwardDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeDescription basicGetBackwardDelta() {
		return backwardDelta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackwardDelta(ChangeDescription newBackwardDelta) {
		ChangeDescription oldBackwardDelta = backwardDelta;
		backwardDelta = newBackwardDelta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.CHANGE_PACKAGE__BACKWARD_DELTA, oldBackwardDelta, backwardDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage reverse() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsmodelPackage.CHANGE_PACKAGE__FOWARD_DELTA:
				if (resolve) return getFowardDelta();
				return basicGetFowardDelta();
			case EsmodelPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
				if (resolve) return getBackwardDelta();
				return basicGetBackwardDelta();
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
			case EsmodelPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
				setBackwardDelta((ChangeDescription)newValue);
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
			case EsmodelPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
				setBackwardDelta((ChangeDescription)null);
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
			case EsmodelPackage.CHANGE_PACKAGE__FOWARD_DELTA:
				return fowardDelta != null;
			case EsmodelPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
				return backwardDelta != null;
		}
		return super.eIsSet(featureID);
	}

} //ChangePackageImpl
