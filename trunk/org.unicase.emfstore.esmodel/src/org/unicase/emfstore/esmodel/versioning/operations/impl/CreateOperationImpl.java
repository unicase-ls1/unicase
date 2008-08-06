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
import org.unicase.emfstore.esmodel.versioning.operations.CreateOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateOperationImpl#getObjectToCreate <em>Object To Create</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateOperationImpl extends AtomicOperationImpl implements
		CreateOperation {
	/**
	 * The cached value of the '{@link #getObjectToCreate() <em>Object To Create</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjectToCreate()
	 * @generated
	 * @ordered
	 */
	protected EObject objectToCreate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.CREATE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getObjectToCreate() {
		if (objectToCreate != null && objectToCreate.eIsProxy()) {
			InternalEObject oldObjectToCreate = (InternalEObject) objectToCreate;
			objectToCreate = eResolveProxy(oldObjectToCreate);
			if (objectToCreate != oldObjectToCreate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							OperationsPackage.CREATE_OPERATION__OBJECT_TO_CREATE,
							oldObjectToCreate, objectToCreate));
			}
		}
		return objectToCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetObjectToCreate() {
		return objectToCreate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjectToCreate(EObject newObjectToCreate) {
		EObject oldObjectToCreate = objectToCreate;
		objectToCreate = newObjectToCreate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.CREATE_OPERATION__OBJECT_TO_CREATE,
					oldObjectToCreate, objectToCreate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.CREATE_OPERATION__OBJECT_TO_CREATE:
			if (resolve)
				return getObjectToCreate();
			return basicGetObjectToCreate();
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
		case OperationsPackage.CREATE_OPERATION__OBJECT_TO_CREATE:
			setObjectToCreate((EObject) newValue);
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
		case OperationsPackage.CREATE_OPERATION__OBJECT_TO_CREATE:
			setObjectToCreate((EObject) null);
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
		case OperationsPackage.CREATE_OPERATION__OBJECT_TO_CREATE:
			return objectToCreate != null;
		}
		return super.eIsSet(featureID);
	}

} //CreateOperationImpl
