/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.model.changetracking.git.impl;

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
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.Stream;

import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitPackage;

import org.unicase.model.impl.UnicaseModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Branch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.git.impl.GitBranchImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.git.impl.GitBranchImpl#getRevisions <em>Revisions</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.git.impl.GitBranchImpl#getUsingStreams <em>Using Streams</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.git.impl.GitBranchImpl#getReferringChangePackages <em>Referring Change Packages</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.git.impl.GitBranchImpl#getBranchName <em>Branch Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GitBranchImpl extends UnicaseModelElementImpl implements GitBranch
{
	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected RepositoryLocation location;

	/**
	 * The cached value of the '{@link #getRevisions() <em>Revisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRevisions()
	 * @generated
	 * @ordered
	 */
	protected EList<RepositoryRevision> revisions;

	/**
	 * The cached value of the '{@link #getUsingStreams() <em>Using Streams</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsingStreams()
	 * @generated
	 * @ordered
	 */
	protected EList<Stream> usingStreams;

	/**
	 * The cached value of the '{@link #getReferringChangePackages() <em>Referring Change Packages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferringChangePackages()
	 * @generated
	 * @ordered
	 */
	protected EList<GitBranchChangePackage> referringChangePackages;

	/**
	 * The default value of the '{@link #getBranchName() <em>Branch Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchName()
	 * @generated
	 * @ordered
	 */
	protected static final String BRANCH_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBranchName() <em>Branch Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranchName()
	 * @generated
	 * @ordered
	 */
	protected String branchName = BRANCH_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GitBranchImpl()
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
		return GitPackage.Literals.GIT_BRANCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryLocation getLocation()
	{
		if (location != null && location.eIsProxy())
		{
			InternalEObject oldLocation = (InternalEObject)location;
			location = (RepositoryLocation)eResolveProxy(oldLocation);
			if (location != oldLocation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GitPackage.GIT_BRANCH__LOCATION, oldLocation, location));
			}
		}
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryLocation basicGetLocation()
	{
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(RepositoryLocation newLocation, NotificationChain msgs)
	{
		RepositoryLocation oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GitPackage.GIT_BRANCH__LOCATION, oldLocation, newLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(RepositoryLocation newLocation)
	{
		if (newLocation != location)
		{
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS, RepositoryLocation.class, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS, RepositoryLocation.class, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GitPackage.GIT_BRANCH__LOCATION, newLocation, newLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepositoryRevision> getRevisions()
	{
		if (revisions == null)
		{
			revisions = new EObjectWithInverseResolvingEList<RepositoryRevision>(RepositoryRevision.class, this, GitPackage.GIT_BRANCH__REVISIONS, ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM);
		}
		return revisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Stream> getUsingStreams()
	{
		if (usingStreams == null)
		{
			usingStreams = new EObjectWithInverseResolvingEList<Stream>(Stream.class, this, GitPackage.GIT_BRANCH__USING_STREAMS, ChangetrackingPackage.STREAM__REPOSITORY_STREAM);
		}
		return usingStreams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GitBranchChangePackage> getReferringChangePackages()
	{
		if (referringChangePackages == null)
		{
			referringChangePackages = new EObjectWithInverseResolvingEList<GitBranchChangePackage>(GitBranchChangePackage.class, this, GitPackage.GIT_BRANCH__REFERRING_CHANGE_PACKAGES, GitPackage.GIT_BRANCH_CHANGE_PACKAGE__BRANCH);
		}
		return referringChangePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBranchName()
	{
		return branchName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBranchName(String newBranchName)
	{
		String oldBranchName = branchName;
		branchName = newBranchName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GitPackage.GIT_BRANCH__BRANCH_NAME, oldBranchName, branchName));
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
			case GitPackage.GIT_BRANCH__LOCATION:
				if (location != null)
					msgs = ((InternalEObject)location).eInverseRemove(this, ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS, RepositoryLocation.class, msgs);
				return basicSetLocation((RepositoryLocation)otherEnd, msgs);
			case GitPackage.GIT_BRANCH__REVISIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRevisions()).basicAdd(otherEnd, msgs);
			case GitPackage.GIT_BRANCH__USING_STREAMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getUsingStreams()).basicAdd(otherEnd, msgs);
			case GitPackage.GIT_BRANCH__REFERRING_CHANGE_PACKAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferringChangePackages()).basicAdd(otherEnd, msgs);
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
			case GitPackage.GIT_BRANCH__LOCATION:
				return basicSetLocation(null, msgs);
			case GitPackage.GIT_BRANCH__REVISIONS:
				return ((InternalEList<?>)getRevisions()).basicRemove(otherEnd, msgs);
			case GitPackage.GIT_BRANCH__USING_STREAMS:
				return ((InternalEList<?>)getUsingStreams()).basicRemove(otherEnd, msgs);
			case GitPackage.GIT_BRANCH__REFERRING_CHANGE_PACKAGES:
				return ((InternalEList<?>)getReferringChangePackages()).basicRemove(otherEnd, msgs);
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
			case GitPackage.GIT_BRANCH__LOCATION:
				if (resolve) return getLocation();
				return basicGetLocation();
			case GitPackage.GIT_BRANCH__REVISIONS:
				return getRevisions();
			case GitPackage.GIT_BRANCH__USING_STREAMS:
				return getUsingStreams();
			case GitPackage.GIT_BRANCH__REFERRING_CHANGE_PACKAGES:
				return getReferringChangePackages();
			case GitPackage.GIT_BRANCH__BRANCH_NAME:
				return getBranchName();
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
			case GitPackage.GIT_BRANCH__LOCATION:
				setLocation((RepositoryLocation)newValue);
				return;
			case GitPackage.GIT_BRANCH__REVISIONS:
				getRevisions().clear();
				getRevisions().addAll((Collection<? extends RepositoryRevision>)newValue);
				return;
			case GitPackage.GIT_BRANCH__USING_STREAMS:
				getUsingStreams().clear();
				getUsingStreams().addAll((Collection<? extends Stream>)newValue);
				return;
			case GitPackage.GIT_BRANCH__REFERRING_CHANGE_PACKAGES:
				getReferringChangePackages().clear();
				getReferringChangePackages().addAll((Collection<? extends GitBranchChangePackage>)newValue);
				return;
			case GitPackage.GIT_BRANCH__BRANCH_NAME:
				setBranchName((String)newValue);
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
			case GitPackage.GIT_BRANCH__LOCATION:
				setLocation((RepositoryLocation)null);
				return;
			case GitPackage.GIT_BRANCH__REVISIONS:
				getRevisions().clear();
				return;
			case GitPackage.GIT_BRANCH__USING_STREAMS:
				getUsingStreams().clear();
				return;
			case GitPackage.GIT_BRANCH__REFERRING_CHANGE_PACKAGES:
				getReferringChangePackages().clear();
				return;
			case GitPackage.GIT_BRANCH__BRANCH_NAME:
				setBranchName(BRANCH_NAME_EDEFAULT);
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
			case GitPackage.GIT_BRANCH__LOCATION:
				return location != null;
			case GitPackage.GIT_BRANCH__REVISIONS:
				return revisions != null && !revisions.isEmpty();
			case GitPackage.GIT_BRANCH__USING_STREAMS:
				return usingStreams != null && !usingStreams.isEmpty();
			case GitPackage.GIT_BRANCH__REFERRING_CHANGE_PACKAGES:
				return referringChangePackages != null && !referringChangePackages.isEmpty();
			case GitPackage.GIT_BRANCH__BRANCH_NAME:
				return BRANCH_NAME_EDEFAULT == null ? branchName != null : !BRANCH_NAME_EDEFAULT.equals(branchName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (branchName: ");
		result.append(branchName);
		result.append(')');
		return result.toString();
	}

} //GitBranchImpl
