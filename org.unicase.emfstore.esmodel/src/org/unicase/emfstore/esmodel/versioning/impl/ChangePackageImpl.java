/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Change Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getFowardDelta <em>Foward Delta</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getBackwardDelta <em>Backward Delta</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl#getProjectState <em>Project State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangePackageImpl extends EObjectImpl implements ChangePackage {
	/**
	 * The cached value of the '{@link #getFowardDelta() <em>Foward Delta</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFowardDelta()
	 * @generated
	 * @ordered
	 */
	protected ChangeDescription fowardDelta;

	/**
	 * The cached value of the '{@link #getBackwardDelta() <em>Backward Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackwardDelta()
	 * @generated
	 * @ordered
	 */
	protected ChangeDescription backwardDelta;

	/**
	 * The cached value of the '{@link #getProjectState() <em>Project State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectState()
	 * @generated
	 * @ordered
	 */
	protected Project projectState;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeDescription getFowardDelta() {
		return fowardDelta;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFowardDelta(
			ChangeDescription newFowardDelta, NotificationChain msgs) {
		ChangeDescription oldFowardDelta = fowardDelta;
		fowardDelta = newFowardDelta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA,
					oldFowardDelta, newFowardDelta);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFowardDelta(ChangeDescription newFowardDelta) {
		if (newFowardDelta != fowardDelta) {
			NotificationChain msgs = null;
			if (fowardDelta != null)
				msgs = ((InternalEObject) fowardDelta)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA,
								null, msgs);
			if (newFowardDelta != null)
				msgs = ((InternalEObject) newFowardDelta)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA,
								null, msgs);
			msgs = basicSetFowardDelta(newFowardDelta, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA,
					newFowardDelta, newFowardDelta));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeDescription getBackwardDelta() {
		return backwardDelta;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackwardDelta(
			ChangeDescription newBackwardDelta, NotificationChain msgs) {
		ChangeDescription oldBackwardDelta = backwardDelta;
		backwardDelta = newBackwardDelta;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA,
					oldBackwardDelta, newBackwardDelta);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackwardDelta(ChangeDescription newBackwardDelta) {
		if (newBackwardDelta != backwardDelta) {
			NotificationChain msgs = null;
			if (backwardDelta != null)
				msgs = ((InternalEObject) backwardDelta)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA,
								null, msgs);
			if (newBackwardDelta != null)
				msgs = ((InternalEObject) newBackwardDelta)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA,
								null, msgs);
			msgs = basicSetBackwardDelta(newBackwardDelta, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA,
					newBackwardDelta, newBackwardDelta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProjectState() {
		return projectState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectState(Project newProjectState,
			NotificationChain msgs) {
		Project oldProjectState = projectState;
		projectState = newProjectState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE,
					oldProjectState, newProjectState);
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
	public void setProjectState(Project newProjectState) {
		if (newProjectState != projectState) {
			NotificationChain msgs = null;
			if (projectState != null)
				msgs = ((InternalEObject) projectState)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE,
								null, msgs);
			if (newProjectState != null)
				msgs = ((InternalEObject) newProjectState)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE,
								null, msgs);
			msgs = basicSetProjectState(newProjectState, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE,
					newProjectState, newProjectState));
	}

	//begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage reverse() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	//end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA:
			return basicSetFowardDelta(null, msgs);
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
			return basicSetBackwardDelta(null, msgs);
		case VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE:
			return basicSetProjectState(null, msgs);
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
		case VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA:
			return getFowardDelta();
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
			return getBackwardDelta();
		case VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE:
			return getProjectState();
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
		case VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA:
			setFowardDelta((ChangeDescription) newValue);
			return;
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
			setBackwardDelta((ChangeDescription) newValue);
			return;
		case VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE:
			setProjectState((Project) newValue);
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
		case VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA:
			setFowardDelta((ChangeDescription) null);
			return;
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
			setBackwardDelta((ChangeDescription) null);
			return;
		case VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE:
			setProjectState((Project) null);
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
		case VersioningPackage.CHANGE_PACKAGE__FOWARD_DELTA:
			return fowardDelta != null;
		case VersioningPackage.CHANGE_PACKAGE__BACKWARD_DELTA:
			return backwardDelta != null;
		case VersioningPackage.CHANGE_PACKAGE__PROJECT_STATE:
			return projectState != null;
		}
		return super.eIsSet(featureID);
	}

} // ChangePackageImpl
