/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.MergeEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Merge Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl#getNumberOfConflicts <em>Number Of
 * Conflicts</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl#getTotalTime <em>Total Time</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl#getBaseVersion <em>Base Version</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl#getTargetVersion <em>Target Version
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.MergeEventImpl#getLocalChanges <em>Local Changes</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MergeEventImpl extends EventImpl implements MergeEvent {
	/**
	 * The default value of the '{@link #getNumberOfConflicts() <em>Number Of Conflicts</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNumberOfConflicts()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_OF_CONFLICTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumberOfConflicts() <em>Number Of Conflicts</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNumberOfConflicts()
	 * @generated
	 * @ordered
	 */
	protected int numberOfConflicts = NUMBER_OF_CONFLICTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalTime() <em>Total Time</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTotalTime()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalTime() <em>Total Time</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getTotalTime()
	 * @generated
	 * @ordered
	 */
	protected int totalTime = TOTAL_TIME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	/**
	 * The cached value of the '{@link #getTargetVersion() <em>Target Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec targetVersion;

	/**
	 * The cached value of the '{@link #getLocalChanges() <em>Local Changes</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLocalChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> localChanges;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MergeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.MERGE_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getNumberOfConflicts() {
		return numberOfConflicts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNumberOfConflicts(int newNumberOfConflicts) {
		int oldNumberOfConflicts = numberOfConflicts;
		numberOfConflicts = newNumberOfConflicts;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_EVENT__NUMBER_OF_CONFLICTS,
				oldNumberOfConflicts, numberOfConflicts));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getTotalTime() {
		return totalTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTotalTime(int newTotalTime) {
		int oldTotalTime = totalTime;
		totalTime = newTotalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_EVENT__TOTAL_TIME, oldTotalTime,
				totalTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec getBaseVersion() {
		if (baseVersion != null && baseVersion.eIsProxy()) {
			InternalEObject oldBaseVersion = (InternalEObject) baseVersion;
			baseVersion = (PrimaryVersionSpec) eResolveProxy(oldBaseVersion);
			if (baseVersion != oldBaseVersion) {
				InternalEObject newBaseVersion = (InternalEObject) baseVersion;
				NotificationChain msgs = oldBaseVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_EVENT__BASE_VERSION, null, null);
				if (newBaseVersion.eInternalContainer() == null) {
					msgs = newBaseVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.MERGE_EVENT__BASE_VERSION, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventsPackage.MERGE_EVENT__BASE_VERSION,
						oldBaseVersion, baseVersion));
			}
		}
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec basicGetBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetBaseVersion(PrimaryVersionSpec newBaseVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.MERGE_EVENT__BASE_VERSION, oldBaseVersion, newBaseVersion);
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
	public void setBaseVersion(PrimaryVersionSpec newBaseVersion) {
		if (newBaseVersion != baseVersion) {
			NotificationChain msgs = null;
			if (baseVersion != null)
				msgs = ((InternalEObject) baseVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_EVENT__BASE_VERSION, null, msgs);
			if (newBaseVersion != null)
				msgs = ((InternalEObject) newBaseVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_EVENT__BASE_VERSION, null, msgs);
			msgs = basicSetBaseVersion(newBaseVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_EVENT__BASE_VERSION,
				newBaseVersion, newBaseVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec getTargetVersion() {
		if (targetVersion != null && targetVersion.eIsProxy()) {
			InternalEObject oldTargetVersion = (InternalEObject) targetVersion;
			targetVersion = (PrimaryVersionSpec) eResolveProxy(oldTargetVersion);
			if (targetVersion != oldTargetVersion) {
				InternalEObject newTargetVersion = (InternalEObject) targetVersion;
				NotificationChain msgs = oldTargetVersion.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_EVENT__TARGET_VERSION, null, null);
				if (newTargetVersion.eInternalContainer() == null) {
					msgs = newTargetVersion.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- EventsPackage.MERGE_EVENT__TARGET_VERSION, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						EventsPackage.MERGE_EVENT__TARGET_VERSION, oldTargetVersion, targetVersion));
			}
		}
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec basicGetTargetVersion() {
		return targetVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTargetVersion(PrimaryVersionSpec newTargetVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldTargetVersion = targetVersion;
		targetVersion = newTargetVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				EventsPackage.MERGE_EVENT__TARGET_VERSION, oldTargetVersion, newTargetVersion);
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
	public void setTargetVersion(PrimaryVersionSpec newTargetVersion) {
		if (newTargetVersion != targetVersion) {
			NotificationChain msgs = null;
			if (targetVersion != null)
				msgs = ((InternalEObject) targetVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_EVENT__TARGET_VERSION, null, msgs);
			if (newTargetVersion != null)
				msgs = ((InternalEObject) newTargetVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- EventsPackage.MERGE_EVENT__TARGET_VERSION, null, msgs);
			msgs = basicSetTargetVersion(newTargetVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.MERGE_EVENT__TARGET_VERSION,
				newTargetVersion, newTargetVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<AbstractOperation> getLocalChanges() {
		if (localChanges == null) {
			localChanges = new EObjectContainmentEList.Resolving<AbstractOperation>(AbstractOperation.class, this,
				EventsPackage.MERGE_EVENT__LOCAL_CHANGES);
		}
		return localChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EventsPackage.MERGE_EVENT__BASE_VERSION:
			return basicSetBaseVersion(null, msgs);
		case EventsPackage.MERGE_EVENT__TARGET_VERSION:
			return basicSetTargetVersion(null, msgs);
		case EventsPackage.MERGE_EVENT__LOCAL_CHANGES:
			return ((InternalEList<?>) getLocalChanges()).basicRemove(otherEnd, msgs);
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
		case EventsPackage.MERGE_EVENT__NUMBER_OF_CONFLICTS:
			return getNumberOfConflicts();
		case EventsPackage.MERGE_EVENT__TOTAL_TIME:
			return getTotalTime();
		case EventsPackage.MERGE_EVENT__BASE_VERSION:
			if (resolve)
				return getBaseVersion();
			return basicGetBaseVersion();
		case EventsPackage.MERGE_EVENT__TARGET_VERSION:
			if (resolve)
				return getTargetVersion();
			return basicGetTargetVersion();
		case EventsPackage.MERGE_EVENT__LOCAL_CHANGES:
			return getLocalChanges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EventsPackage.MERGE_EVENT__NUMBER_OF_CONFLICTS:
			setNumberOfConflicts((Integer) newValue);
			return;
		case EventsPackage.MERGE_EVENT__TOTAL_TIME:
			setTotalTime((Integer) newValue);
			return;
		case EventsPackage.MERGE_EVENT__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) newValue);
			return;
		case EventsPackage.MERGE_EVENT__TARGET_VERSION:
			setTargetVersion((PrimaryVersionSpec) newValue);
			return;
		case EventsPackage.MERGE_EVENT__LOCAL_CHANGES:
			getLocalChanges().clear();
			getLocalChanges().addAll((Collection<? extends AbstractOperation>) newValue);
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
		case EventsPackage.MERGE_EVENT__NUMBER_OF_CONFLICTS:
			setNumberOfConflicts(NUMBER_OF_CONFLICTS_EDEFAULT);
			return;
		case EventsPackage.MERGE_EVENT__TOTAL_TIME:
			setTotalTime(TOTAL_TIME_EDEFAULT);
			return;
		case EventsPackage.MERGE_EVENT__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) null);
			return;
		case EventsPackage.MERGE_EVENT__TARGET_VERSION:
			setTargetVersion((PrimaryVersionSpec) null);
			return;
		case EventsPackage.MERGE_EVENT__LOCAL_CHANGES:
			getLocalChanges().clear();
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
		case EventsPackage.MERGE_EVENT__NUMBER_OF_CONFLICTS:
			return numberOfConflicts != NUMBER_OF_CONFLICTS_EDEFAULT;
		case EventsPackage.MERGE_EVENT__TOTAL_TIME:
			return totalTime != TOTAL_TIME_EDEFAULT;
		case EventsPackage.MERGE_EVENT__BASE_VERSION:
			return baseVersion != null;
		case EventsPackage.MERGE_EVENT__TARGET_VERSION:
			return targetVersion != null;
		case EventsPackage.MERGE_EVENT__LOCAL_CHANGES:
			return localChanges != null && !localChanges.isEmpty();
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
		result.append(" (numberOfConflicts: ");
		result.append(numberOfConflicts);
		result.append(", totalTime: ");
		result.append(totalTime);
		result.append(')');
		return result.toString();
	}

} // MergeEventImpl
