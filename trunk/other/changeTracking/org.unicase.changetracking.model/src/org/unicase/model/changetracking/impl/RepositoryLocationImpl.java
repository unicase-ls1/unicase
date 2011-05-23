/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.model.changetracking.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.changetracking.ChangetrackingPackage;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;

import org.unicase.model.impl.UnicaseModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Location</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.impl.RepositoryLocationImpl#getStreams <em>Streams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RepositoryLocationImpl extends UnicaseModelElementImpl implements RepositoryLocation {
	/**
	 * The cached value of the '{@link #getStreams() <em>Streams</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStreams()
	 * @generated
	 * @ordered
	 */
	protected EList<RepositoryStream> streams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryLocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangetrackingPackage.Literals.REPOSITORY_LOCATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepositoryStream> getStreams() {
		if (streams == null) {
			streams = new EObjectWithInverseResolvingEList<RepositoryStream>(RepositoryStream.class, this, ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS, ChangetrackingPackage.REPOSITORY_STREAM__LOCATION);
		}
		return streams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getStreams()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS:
			return ((InternalEList<?>) getStreams()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS:
			return getStreams();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS:
			getStreams().clear();
			getStreams().addAll((Collection<? extends RepositoryStream>) newValue);
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
		case ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS:
			getStreams().clear();
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
		case ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS:
			return streams != null && !streams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RepositoryLocationImpl
