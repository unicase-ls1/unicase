/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.changetracking.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.ChangetrackingPackage;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.impl.UnicaseModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Revision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.impl.RepositoryRevisionImpl#getRepositoryStream <em>Repository Stream</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.RepositoryRevisionImpl#getBuiltWithReleases <em>Built With Releases</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RepositoryRevisionImpl extends UnicaseModelElementImpl
		implements RepositoryRevision {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * The cached value of the '{@link #getRepositoryStream() <em>Repository Stream</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryStream()
	 * @generated
	 * @ordered
	 */
	protected RepositoryStream repositoryStream;

	/**
	 * The cached value of the '{@link #getBuiltWithReleases() <em>Built With Releases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuiltWithReleases()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangeTrackingRelease> builtWithReleases;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryRevisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangetrackingPackage.Literals.REPOSITORY_REVISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryStream getRepositoryStream() {
		if (repositoryStream != null && repositoryStream.eIsProxy()) {
			InternalEObject oldRepositoryStream = (InternalEObject) repositoryStream;
			repositoryStream = (RepositoryStream) eResolveProxy(oldRepositoryStream);
			if (repositoryStream != oldRepositoryStream) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM,
							oldRepositoryStream, repositoryStream));
			}
		}
		return repositoryStream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryStream basicGetRepositoryStream() {
		return repositoryStream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepositoryStream(
			RepositoryStream newRepositoryStream, NotificationChain msgs) {
		RepositoryStream oldRepositoryStream = repositoryStream;
		repositoryStream = newRepositoryStream;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
					this,
					Notification.SET,
					ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM,
					oldRepositoryStream, newRepositoryStream);
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
	public void setRepositoryStream(RepositoryStream newRepositoryStream) {
		if (newRepositoryStream != repositoryStream) {
			NotificationChain msgs = null;
			if (repositoryStream != null)
				msgs = ((InternalEObject) repositoryStream).eInverseRemove(
						this,
						ChangetrackingPackage.REPOSITORY_STREAM__REVISIONS,
						RepositoryStream.class, msgs);
			if (newRepositoryStream != null)
				msgs = ((InternalEObject) newRepositoryStream).eInverseAdd(
						this,
						ChangetrackingPackage.REPOSITORY_STREAM__REVISIONS,
						RepositoryStream.class, msgs);
			msgs = basicSetRepositoryStream(newRepositoryStream, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM,
					newRepositoryStream, newRepositoryStream));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChangeTrackingRelease> getBuiltWithReleases() {
		if (builtWithReleases == null) {
			builtWithReleases = new EObjectWithInverseResolvingEList<ChangeTrackingRelease>(
					ChangeTrackingRelease.class,
					this,
					ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES,
					ChangetrackingPackage.CHANGE_TRACKING_RELEASE__BUILT_REVISION);
		}
		return builtWithReleases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM:
			if (repositoryStream != null)
				msgs = ((InternalEObject) repositoryStream).eInverseRemove(
						this,
						ChangetrackingPackage.REPOSITORY_STREAM__REVISIONS,
						RepositoryStream.class, msgs);
			return basicSetRepositoryStream((RepositoryStream) otherEnd, msgs);
		case ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getBuiltWithReleases())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM:
			return basicSetRepositoryStream(null, msgs);
		case ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES:
			return ((InternalEList<?>) getBuiltWithReleases()).basicRemove(
					otherEnd, msgs);
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
		case ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM:
			if (resolve)
				return getRepositoryStream();
			return basicGetRepositoryStream();
		case ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES:
			return getBuiltWithReleases();
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
		case ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM:
			setRepositoryStream((RepositoryStream) newValue);
			return;
		case ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES:
			getBuiltWithReleases().clear();
			getBuiltWithReleases().addAll(
					(Collection<? extends ChangeTrackingRelease>) newValue);
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
		case ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM:
			setRepositoryStream((RepositoryStream) null);
			return;
		case ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES:
			getBuiltWithReleases().clear();
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
		case ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM:
			return repositoryStream != null;
		case ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES:
			return builtWithReleases != null && !builtWithReleases.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RepositoryRevisionImpl
