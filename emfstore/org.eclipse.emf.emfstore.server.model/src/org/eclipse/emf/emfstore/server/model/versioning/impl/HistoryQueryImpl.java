/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>History Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryQueryImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryQueryImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryQueryImpl#getModelElements <em>Model Elements</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryQueryImpl#isIncludeChangePackage <em>Include Change Package</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HistoryQueryImpl extends EObjectImpl implements HistoryQuery {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec target;

	/**
	 * The cached value of the '{@link #getModelElements() <em>Model Elements</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> modelElements;

	/**
	 * The default value of the '{@link #isIncludeChangePackage() <em>Include Change Package</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIncludeChangePackage()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCLUDE_CHANGE_PACKAGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncludeChangePackage() <em>Include Change Package</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIncludeChangePackage()
	 * @generated
	 * @ordered
	 */
	protected boolean includeChangePackage = INCLUDE_CHANGE_PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected HistoryQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.HISTORY_QUERY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (PrimaryVersionSpec)eResolveProxy(oldSource);
			if (source != oldSource) {
				InternalEObject newSource = (InternalEObject)source;
				NotificationChain msgs = oldSource.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_QUERY__SOURCE, null, null);
				if (newSource.eInternalContainer() == null) {
					msgs = newSource.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_QUERY__SOURCE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VersioningPackage.HISTORY_QUERY__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(PrimaryVersionSpec newSource, NotificationChain msgs) {
		PrimaryVersionSpec oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_QUERY__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(PrimaryVersionSpec newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_QUERY__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_QUERY__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_QUERY__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (PrimaryVersionSpec)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				InternalEObject newTarget = (InternalEObject)target;
				NotificationChain msgs = oldTarget.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_QUERY__TARGET, null, null);
				if (newTarget.eInternalContainer() == null) {
					msgs = newTarget.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_QUERY__TARGET, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VersioningPackage.HISTORY_QUERY__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(PrimaryVersionSpec newTarget, NotificationChain msgs) {
		PrimaryVersionSpec oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_QUERY__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(PrimaryVersionSpec newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_QUERY__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VersioningPackage.HISTORY_QUERY__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_QUERY__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getModelElements() {
		if (modelElements == null) {
			modelElements = new EObjectContainmentEList.Resolving<ModelElementId>(ModelElementId.class, this, VersioningPackage.HISTORY_QUERY__MODEL_ELEMENTS);
		}
		return modelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncludeChangePackage() {
		return includeChangePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncludeChangePackage(boolean newIncludeChangePackage) {
		boolean oldIncludeChangePackage = includeChangePackage;
		includeChangePackage = newIncludeChangePackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.HISTORY_QUERY__INCLUDE_CHANGE_PACKAGE, oldIncludeChangePackage, includeChangePackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VersioningPackage.HISTORY_QUERY__SOURCE:
				return basicSetSource(null, msgs);
			case VersioningPackage.HISTORY_QUERY__TARGET:
				return basicSetTarget(null, msgs);
			case VersioningPackage.HISTORY_QUERY__MODEL_ELEMENTS:
				return ((InternalEList<?>)getModelElements()).basicRemove(otherEnd, msgs);
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
			case VersioningPackage.HISTORY_QUERY__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case VersioningPackage.HISTORY_QUERY__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case VersioningPackage.HISTORY_QUERY__MODEL_ELEMENTS:
				return getModelElements();
			case VersioningPackage.HISTORY_QUERY__INCLUDE_CHANGE_PACKAGE:
				return isIncludeChangePackage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VersioningPackage.HISTORY_QUERY__SOURCE:
				setSource((PrimaryVersionSpec)newValue);
				return;
			case VersioningPackage.HISTORY_QUERY__TARGET:
				setTarget((PrimaryVersionSpec)newValue);
				return;
			case VersioningPackage.HISTORY_QUERY__MODEL_ELEMENTS:
				getModelElements().clear();
				getModelElements().addAll((Collection<? extends ModelElementId>)newValue);
				return;
			case VersioningPackage.HISTORY_QUERY__INCLUDE_CHANGE_PACKAGE:
				setIncludeChangePackage((Boolean)newValue);
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
			case VersioningPackage.HISTORY_QUERY__SOURCE:
				setSource((PrimaryVersionSpec)null);
				return;
			case VersioningPackage.HISTORY_QUERY__TARGET:
				setTarget((PrimaryVersionSpec)null);
				return;
			case VersioningPackage.HISTORY_QUERY__MODEL_ELEMENTS:
				getModelElements().clear();
				return;
			case VersioningPackage.HISTORY_QUERY__INCLUDE_CHANGE_PACKAGE:
				setIncludeChangePackage(INCLUDE_CHANGE_PACKAGE_EDEFAULT);
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
			case VersioningPackage.HISTORY_QUERY__SOURCE:
				return source != null;
			case VersioningPackage.HISTORY_QUERY__TARGET:
				return target != null;
			case VersioningPackage.HISTORY_QUERY__MODEL_ELEMENTS:
				return modelElements != null && !modelElements.isEmpty();
			case VersioningPackage.HISTORY_QUERY__INCLUDE_CHANGE_PACKAGE:
				return includeChangePackage != INCLUDE_CHANGE_PACKAGE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (includeChangePackage: ");
		result.append(includeChangePackage);
		result.append(')');
		return result.toString();
	}

} // HistoryQueryImpl
