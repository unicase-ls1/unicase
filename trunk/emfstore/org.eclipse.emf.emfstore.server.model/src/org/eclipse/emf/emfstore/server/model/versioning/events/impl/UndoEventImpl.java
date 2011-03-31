/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage;
import org.eclipse.emf.emfstore.server.model.versioning.events.UndoEvent;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Undo Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.impl.UndoEventImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UndoEventImpl extends EventImpl implements UndoEvent {
	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected AbstractOperation operation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UndoEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.UNDO_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractOperation getOperation() {
		if (operation != null && operation.eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject)operation;
			operation = (AbstractOperation)eResolveProxy(oldOperation);
			if (operation != oldOperation) {
				InternalEObject newOperation = (InternalEObject)operation;
				NotificationChain msgs = oldOperation.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.UNDO_EVENT__OPERATION, null, null);
				if (newOperation.eInternalContainer() == null) {
					msgs = newOperation.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.UNDO_EVENT__OPERATION, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.UNDO_EVENT__OPERATION, oldOperation, operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractOperation basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(AbstractOperation newOperation, NotificationChain msgs) {
		AbstractOperation oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EventsPackage.UNDO_EVENT__OPERATION, oldOperation, newOperation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(AbstractOperation newOperation) {
		if (newOperation != operation) {
			NotificationChain msgs = null;
			if (operation != null)
				msgs = ((InternalEObject)operation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EventsPackage.UNDO_EVENT__OPERATION, null, msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EventsPackage.UNDO_EVENT__OPERATION, null, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.UNDO_EVENT__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EventsPackage.UNDO_EVENT__OPERATION:
				return basicSetOperation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.UNDO_EVENT__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
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
			case EventsPackage.UNDO_EVENT__OPERATION:
				setOperation((AbstractOperation)newValue);
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
			case EventsPackage.UNDO_EVENT__OPERATION:
				setOperation((AbstractOperation)null);
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
			case EventsPackage.UNDO_EVENT__OPERATION:
				return operation != null;
		}
		return super.eIsSet(featureID);
	}

} // UndoEventImpl
