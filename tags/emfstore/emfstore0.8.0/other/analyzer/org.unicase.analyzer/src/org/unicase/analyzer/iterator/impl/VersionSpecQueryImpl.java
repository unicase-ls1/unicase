/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Version Spec Query</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.analyzer.iterator.impl.VersionSpecQueryImpl#getEndVersion <em>End Version</em>}</li>
 * <li>{@link org.unicase.analyzer.iterator.impl.VersionSpecQueryImpl#getStartVersion <em>Start Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VersionSpecQueryImpl extends EObjectImpl implements VersionSpecQuery {
	/**
	 * The cached value of the '{@link #getEndVersion() <em>End Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEndVersion()
	 * @generated
	 * @ordered
	 */
	protected VersionSpec endVersion;

	/**
	 * The cached value of the '{@link #getStartVersion() <em>Start Version</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getStartVersion()
	 * @generated
	 * @ordered
	 */
	protected VersionSpec startVersion;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionSpecQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IteratorPackage.Literals.VERSION_SPEC_QUERY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpec getEndVersion() {
		return endVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndVersion(VersionSpec newEndVersion, NotificationChain msgs) {
		VersionSpec oldEndVersion = endVersion;
		endVersion = newEndVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_SPEC_QUERY__END_VERSION, oldEndVersion, newEndVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndVersion(VersionSpec newEndVersion) {
		if (newEndVersion != endVersion) {
			NotificationChain msgs = null;
			if (endVersion != null)
				msgs = ((InternalEObject)endVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_SPEC_QUERY__END_VERSION, null, msgs);
			if (newEndVersion != null)
				msgs = ((InternalEObject)newEndVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_SPEC_QUERY__END_VERSION, null, msgs);
			msgs = basicSetEndVersion(newEndVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_SPEC_QUERY__END_VERSION, newEndVersion, newEndVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpec getStartVersion() {
		return startVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartVersion(VersionSpec newStartVersion, NotificationChain msgs) {
		VersionSpec oldStartVersion = startVersion;
		startVersion = newStartVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_SPEC_QUERY__START_VERSION, oldStartVersion, newStartVersion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartVersion(VersionSpec newStartVersion) {
		if (newStartVersion != startVersion) {
			NotificationChain msgs = null;
			if (startVersion != null)
				msgs = ((InternalEObject)startVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_SPEC_QUERY__START_VERSION, null, msgs);
			if (newStartVersion != null)
				msgs = ((InternalEObject)newStartVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IteratorPackage.VERSION_SPEC_QUERY__START_VERSION, null, msgs);
			msgs = basicSetStartVersion(newStartVersion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.VERSION_SPEC_QUERY__START_VERSION, newStartVersion, newStartVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IteratorPackage.VERSION_SPEC_QUERY__END_VERSION:
				return basicSetEndVersion(null, msgs);
			case IteratorPackage.VERSION_SPEC_QUERY__START_VERSION:
				return basicSetStartVersion(null, msgs);
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
			case IteratorPackage.VERSION_SPEC_QUERY__END_VERSION:
				return getEndVersion();
			case IteratorPackage.VERSION_SPEC_QUERY__START_VERSION:
				return getStartVersion();
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
			case IteratorPackage.VERSION_SPEC_QUERY__END_VERSION:
				setEndVersion((VersionSpec)newValue);
				return;
			case IteratorPackage.VERSION_SPEC_QUERY__START_VERSION:
				setStartVersion((VersionSpec)newValue);
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
			case IteratorPackage.VERSION_SPEC_QUERY__END_VERSION:
				setEndVersion((VersionSpec)null);
				return;
			case IteratorPackage.VERSION_SPEC_QUERY__START_VERSION:
				setStartVersion((VersionSpec)null);
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
			case IteratorPackage.VERSION_SPEC_QUERY__END_VERSION:
				return endVersion != null;
			case IteratorPackage.VERSION_SPEC_QUERY__START_VERSION:
				return startVersion != null;
		}
		return super.eIsSet(featureID);
	}

} // VersionSpecQueryImpl
