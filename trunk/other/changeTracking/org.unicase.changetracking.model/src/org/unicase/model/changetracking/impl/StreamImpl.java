/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
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

import org.unicase.model.changetracking.ChangetrackingPackage;
import org.unicase.model.changetracking.Release;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;

import org.unicase.model.impl.UnicaseModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stream</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.impl.StreamImpl#getReleases <em>Releases</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.impl.StreamImpl#getRepositoryStream <em>Repository Stream</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StreamImpl extends UnicaseModelElementImpl implements Stream
{
	/**
	 * The cached value of the '{@link #getReleases() <em>Releases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleases()
	 * @generated
	 * @ordered
	 */
	protected EList<Release> releases;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreamImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ChangetrackingPackage.Literals.STREAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Release> getReleases()
	{
		if (releases == null)
		{
			releases = new EObjectWithInverseResolvingEList<Release>(Release.class, this, ChangetrackingPackage.STREAM__RELEASES, ChangetrackingPackage.RELEASE__STREAM);
		}
		return releases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryStream getRepositoryStream()
	{
		if (repositoryStream != null && repositoryStream.eIsProxy())
		{
			InternalEObject oldRepositoryStream = (InternalEObject)repositoryStream;
			repositoryStream = (RepositoryStream)eResolveProxy(oldRepositoryStream);
			if (repositoryStream != oldRepositoryStream)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ChangetrackingPackage.STREAM__REPOSITORY_STREAM, oldRepositoryStream, repositoryStream));
			}
		}
		return repositoryStream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryStream basicGetRepositoryStream()
	{
		return repositoryStream;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepositoryStream(RepositoryStream newRepositoryStream, NotificationChain msgs)
	{
		RepositoryStream oldRepositoryStream = repositoryStream;
		repositoryStream = newRepositoryStream;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.STREAM__REPOSITORY_STREAM, oldRepositoryStream, newRepositoryStream);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryStream(RepositoryStream newRepositoryStream)
	{
		if (newRepositoryStream != repositoryStream)
		{
			NotificationChain msgs = null;
			if (repositoryStream != null)
				msgs = ((InternalEObject)repositoryStream).eInverseRemove(this, ChangetrackingPackage.REPOSITORY_STREAM__USING_STREAMS, RepositoryStream.class, msgs);
			if (newRepositoryStream != null)
				msgs = ((InternalEObject)newRepositoryStream).eInverseAdd(this, ChangetrackingPackage.REPOSITORY_STREAM__USING_STREAMS, RepositoryStream.class, msgs);
			msgs = basicSetRepositoryStream(newRepositoryStream, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangetrackingPackage.STREAM__REPOSITORY_STREAM, newRepositoryStream, newRepositoryStream));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ChangetrackingPackage.STREAM__RELEASES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReleases()).basicAdd(otherEnd, msgs);
			case ChangetrackingPackage.STREAM__REPOSITORY_STREAM:
				if (repositoryStream != null)
					msgs = ((InternalEObject)repositoryStream).eInverseRemove(this, ChangetrackingPackage.REPOSITORY_STREAM__USING_STREAMS, RepositoryStream.class, msgs);
				return basicSetRepositoryStream((RepositoryStream)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ChangetrackingPackage.STREAM__RELEASES:
				return ((InternalEList<?>)getReleases()).basicRemove(otherEnd, msgs);
			case ChangetrackingPackage.STREAM__REPOSITORY_STREAM:
				return basicSetRepositoryStream(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ChangetrackingPackage.STREAM__RELEASES:
				return getReleases();
			case ChangetrackingPackage.STREAM__REPOSITORY_STREAM:
				if (resolve) return getRepositoryStream();
				return basicGetRepositoryStream();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ChangetrackingPackage.STREAM__RELEASES:
				getReleases().clear();
				getReleases().addAll((Collection<? extends Release>)newValue);
				return;
			case ChangetrackingPackage.STREAM__REPOSITORY_STREAM:
				setRepositoryStream((RepositoryStream)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ChangetrackingPackage.STREAM__RELEASES:
				getReleases().clear();
				return;
			case ChangetrackingPackage.STREAM__REPOSITORY_STREAM:
				setRepositoryStream((RepositoryStream)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ChangetrackingPackage.STREAM__RELEASES:
				return releases != null && !releases.isEmpty();
			case ChangetrackingPackage.STREAM__REPOSITORY_STREAM:
				return repositoryStream != null;
		}
		return super.eIsSet(featureID);
	}

} //StreamImpl
