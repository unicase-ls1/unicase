/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.workspace.WorkspaceModelVersion;
import org.unicase.workspace.WorkspacePackage;

/*
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Version</b></em>'. <!-- end-user-doc -->
 * <p> The following features are implemented: <ul> <li>{@link
 * org.unicase.workspace.impl.WorkspaceModelVersionImpl#getModelReleaseNumber <em>Model Release Number</em>}</li> </ul>
 * </p>
 * @generated
 */
public class WorkspaceModelVersionImpl extends EObjectImpl implements WorkspaceModelVersion {
	/**
	 * The default value of the '{@link #getModelReleaseNumber() <em>Model Release Number</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelReleaseNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int MODEL_RELEASE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getModelReleaseNumber() <em>Model Release Number</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelReleaseNumber()
	 * @generated
	 * @ordered
	 */
	protected int modelReleaseNumber = MODEL_RELEASE_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceModelVersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WORKSPACE_MODEL_VERSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getModelReleaseNumber() {
		return modelReleaseNumber;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelReleaseNumber(int newModelReleaseNumber) {
		int oldModelReleaseNumber = modelReleaseNumber;
		modelReleaseNumber = newModelReleaseNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.WORKSPACE_MODEL_VERSION__MODEL_RELEASE_NUMBER, oldModelReleaseNumber,
				modelReleaseNumber));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WorkspacePackage.WORKSPACE_MODEL_VERSION__MODEL_RELEASE_NUMBER:
			return new Integer(getModelReleaseNumber());
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
		case WorkspacePackage.WORKSPACE_MODEL_VERSION__MODEL_RELEASE_NUMBER:
			setModelReleaseNumber(((Integer) newValue).intValue());
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
		case WorkspacePackage.WORKSPACE_MODEL_VERSION__MODEL_RELEASE_NUMBER:
			setModelReleaseNumber(MODEL_RELEASE_NUMBER_EDEFAULT);
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
		case WorkspacePackage.WORKSPACE_MODEL_VERSION__MODEL_RELEASE_NUMBER:
			return modelReleaseNumber != MODEL_RELEASE_NUMBER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modelReleaseNumber: ");
		result.append(modelReleaseNumber);
		result.append(')');
		return result.toString();
	}

} // WorkspaceModelVersionImpl
