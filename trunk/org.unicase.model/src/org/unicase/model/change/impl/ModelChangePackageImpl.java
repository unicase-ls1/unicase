/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.change.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Model Change Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.change.impl.ModelChangePackageImpl#getSourceVersion <em>Source Version</em>}</li>
 *   <li>{@link org.unicase.model.change.impl.ModelChangePackageImpl#getTargetVersion <em>Target Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelChangePackageImpl extends ModelElementImpl implements
		ModelChangePackage {
	/**
	 * The default value of the '{@link #getSourceVersion() <em>Source Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSourceVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int SOURCE_VERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSourceVersion() <em>Source Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSourceVersion()
	 * @generated
	 * @ordered
	 */
	protected int sourceVersion = SOURCE_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetVersion() <em>Target Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTargetVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int TARGET_VERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTargetVersion() <em>Target Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTargetVersion()
	 * @generated
	 * @ordered
	 */
	protected int targetVersion = TARGET_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangePackage.Literals.MODEL_CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getSourceVersion() {
		return sourceVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceVersion(int newSourceVersion) {
		int oldSourceVersion = sourceVersion;
		sourceVersion = newSourceVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangePackage.MODEL_CHANGE_PACKAGE__SOURCE_VERSION,
					oldSourceVersion, sourceVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getTargetVersion() {
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetVersion(int newTargetVersion) {
		int oldTargetVersion = targetVersion;
		targetVersion = newTargetVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangePackage.MODEL_CHANGE_PACKAGE__TARGET_VERSION,
					oldTargetVersion, targetVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangePackage.MODEL_CHANGE_PACKAGE__SOURCE_VERSION:
			return new Integer(getSourceVersion());
		case ChangePackage.MODEL_CHANGE_PACKAGE__TARGET_VERSION:
			return new Integer(getTargetVersion());
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
		case ChangePackage.MODEL_CHANGE_PACKAGE__SOURCE_VERSION:
			setSourceVersion(((Integer) newValue).intValue());
			return;
		case ChangePackage.MODEL_CHANGE_PACKAGE__TARGET_VERSION:
			setTargetVersion(((Integer) newValue).intValue());
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
		case ChangePackage.MODEL_CHANGE_PACKAGE__SOURCE_VERSION:
			setSourceVersion(SOURCE_VERSION_EDEFAULT);
			return;
		case ChangePackage.MODEL_CHANGE_PACKAGE__TARGET_VERSION:
			setTargetVersion(TARGET_VERSION_EDEFAULT);
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
		case ChangePackage.MODEL_CHANGE_PACKAGE__SOURCE_VERSION:
			return sourceVersion != SOURCE_VERSION_EDEFAULT;
		case ChangePackage.MODEL_CHANGE_PACKAGE__TARGET_VERSION:
			return targetVersion != TARGET_VERSION_EDEFAULT;
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
		result.append(" (sourceVersion: ");
		result.append(sourceVersion);
		result.append(", targetVersion: ");
		result.append(targetVersion);
		result.append(')');
		return result.toString();
	}

} // ModelChangePackageImpl
