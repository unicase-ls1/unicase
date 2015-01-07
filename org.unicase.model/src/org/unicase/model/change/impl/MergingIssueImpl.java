/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.rationale.impl.IssueImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Merging Issue</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.change.impl.MergingIssueImpl#getBaseVersion <em>Base Version</em>}</li>
 *   <li>{@link org.unicase.model.change.impl.MergingIssueImpl#getTargetVersion <em>Target Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MergingIssueImpl extends IssueImpl implements MergingIssue {
	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec baseVersion;

	/**
	 * The cached value of the '{@link #getTargetVersion() <em>Target Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetVersion()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec targetVersion;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MergingIssueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangePackage.Literals.MERGING_ISSUE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec getBaseVersion() {
		if (baseVersion != null && baseVersion.eIsProxy()) {
			InternalEObject oldBaseVersion = (InternalEObject) baseVersion;
			baseVersion = (org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec) eResolveProxy(oldBaseVersion);
			if (baseVersion != oldBaseVersion) {
				InternalEObject newBaseVersion = (InternalEObject) baseVersion;
				NotificationChain msgs = oldBaseVersion.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChangePackage.MERGING_ISSUE__BASE_VERSION,
						null, null);
				if (newBaseVersion.eInternalContainer() == null) {
					msgs = newBaseVersion
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- ChangePackage.MERGING_ISSUE__BASE_VERSION,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ChangePackage.MERGING_ISSUE__BASE_VERSION,
							oldBaseVersion, baseVersion));
			}
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec basicGetBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseVersion(
			org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec newBaseVersion,
			NotificationChain msgs) {
		org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChangePackage.MERGING_ISSUE__BASE_VERSION, oldBaseVersion,
					newBaseVersion);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseVersion(
			org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec newBaseVersion) {
		if (newBaseVersion != baseVersion) {
			NotificationChain msgs = null;
			if (baseVersion != null)
				msgs = ((InternalEObject) baseVersion).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChangePackage.MERGING_ISSUE__BASE_VERSION,
						null, msgs);
			if (newBaseVersion != null)
				msgs = ((InternalEObject) newBaseVersion).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ChangePackage.MERGING_ISSUE__BASE_VERSION,
						null, msgs);
			msgs = basicSetBaseVersion(newBaseVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangePackage.MERGING_ISSUE__BASE_VERSION, newBaseVersion,
					newBaseVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec getTargetVersion() {
		if (targetVersion != null && targetVersion.eIsProxy()) {
			InternalEObject oldTargetVersion = (InternalEObject) targetVersion;
			targetVersion = (org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec) eResolveProxy(oldTargetVersion);
			if (targetVersion != oldTargetVersion) {
				InternalEObject newTargetVersion = (InternalEObject) targetVersion;
				NotificationChain msgs = oldTargetVersion.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChangePackage.MERGING_ISSUE__TARGET_VERSION,
						null, null);
				if (newTargetVersion.eInternalContainer() == null) {
					msgs = newTargetVersion
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- ChangePackage.MERGING_ISSUE__TARGET_VERSION,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ChangePackage.MERGING_ISSUE__TARGET_VERSION,
							oldTargetVersion, targetVersion));
			}
		}
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec basicGetTargetVersion() {
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetVersion(
			org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec newTargetVersion,
			NotificationChain msgs) {
		org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec oldTargetVersion = targetVersion;
		targetVersion = newTargetVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChangePackage.MERGING_ISSUE__TARGET_VERSION,
					oldTargetVersion, newTargetVersion);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetVersion(
			org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec newTargetVersion) {
		if (newTargetVersion != targetVersion) {
			NotificationChain msgs = null;
			if (targetVersion != null)
				msgs = ((InternalEObject) targetVersion).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChangePackage.MERGING_ISSUE__TARGET_VERSION,
						null, msgs);
			if (newTargetVersion != null)
				msgs = ((InternalEObject) newTargetVersion).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ChangePackage.MERGING_ISSUE__TARGET_VERSION,
						null, msgs);
			msgs = basicSetTargetVersion(newTargetVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangePackage.MERGING_ISSUE__TARGET_VERSION,
					newTargetVersion, newTargetVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangePackage.MERGING_ISSUE__BASE_VERSION:
			return basicSetBaseVersion(null, msgs);
		case ChangePackage.MERGING_ISSUE__TARGET_VERSION:
			return basicSetTargetVersion(null, msgs);
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
		case ChangePackage.MERGING_ISSUE__BASE_VERSION:
			if (resolve)
				return getBaseVersion();
			return basicGetBaseVersion();
		case ChangePackage.MERGING_ISSUE__TARGET_VERSION:
			if (resolve)
				return getTargetVersion();
			return basicGetTargetVersion();
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
		case ChangePackage.MERGING_ISSUE__BASE_VERSION:
			setBaseVersion((org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec) newValue);
			return;
		case ChangePackage.MERGING_ISSUE__TARGET_VERSION:
			setTargetVersion((org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec) newValue);
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
		case ChangePackage.MERGING_ISSUE__BASE_VERSION:
			setBaseVersion((org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec) null);
			return;
		case ChangePackage.MERGING_ISSUE__TARGET_VERSION:
			setTargetVersion((org.eclipse.emf.emfstore.internal.server.model.versioning.PrimaryVersionSpec) null);
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
		case ChangePackage.MERGING_ISSUE__BASE_VERSION:
			return baseVersion != null;
		case ChangePackage.MERGING_ISSUE__TARGET_VERSION:
			return targetVersion != null;
		}
		return super.eIsSet(featureID);
	}

} // MergingIssueImpl
