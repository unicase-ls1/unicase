/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.DeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.DeleteOperationImpl#getObjectToDelete <em>Object To Delete</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeleteOperationImpl extends AtomicOperationImpl implements
		DeleteOperation {
	/**
	 * The cached value of the '{@link #getObjectToDelete() <em>Object To Delete</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectToDelete()
	 * @generated
	 * @ordered
	 */
	protected EObject objectToDelete;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.DELETE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getObjectToDelete() {
		if (objectToDelete != null && objectToDelete.eIsProxy()) {
			InternalEObject oldObjectToDelete = (InternalEObject) objectToDelete;
			objectToDelete = eResolveProxy(oldObjectToDelete);
			if (objectToDelete != oldObjectToDelete) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							OperationsPackage.DELETE_OPERATION__OBJECT_TO_DELETE,
							oldObjectToDelete, objectToDelete));
			}
		}
		return objectToDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetObjectToDelete() {
		return objectToDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectToDelete(EObject newObjectToDelete) {
		EObject oldObjectToDelete = objectToDelete;
		objectToDelete = newObjectToDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.DELETE_OPERATION__OBJECT_TO_DELETE,
					oldObjectToDelete, objectToDelete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.DELETE_OPERATION__OBJECT_TO_DELETE:
			if (resolve)
				return getObjectToDelete();
			return basicGetObjectToDelete();
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
		case OperationsPackage.DELETE_OPERATION__OBJECT_TO_DELETE:
			setObjectToDelete((EObject) newValue);
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
		case OperationsPackage.DELETE_OPERATION__OBJECT_TO_DELETE:
			setObjectToDelete((EObject) null);
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
		case OperationsPackage.DELETE_OPERATION__OBJECT_TO_DELETE:
			return objectToDelete != null;
		}
		return super.eIsSet(featureID);
	}

} //DeleteOperationImpl
