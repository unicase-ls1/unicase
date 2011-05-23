/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.model.changetracking.git.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.changetracking.impl.RepositoryLocationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.git.impl.GitRepositoryImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.git.impl.GitRepositoryImpl#getIdentifyingCommitHash <em>Identifying Commit Hash</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GitRepositoryImpl extends RepositoryLocationImpl implements GitRepository {
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getIdentifyingCommitHash() <em>Identifying Commit Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifyingCommitHash()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFYING_COMMIT_HASH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifyingCommitHash() <em>Identifying Commit Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifyingCommitHash()
	 * @generated
	 * @ordered
	 */
	protected String identifyingCommitHash = IDENTIFYING_COMMIT_HASH_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GitRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GitPackage.Literals.GIT_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GitPackage.GIT_REPOSITORY__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdentifyingCommitHash() {
		return identifyingCommitHash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifyingCommitHash(String newIdentifyingCommitHash) {
		String oldIdentifyingCommitHash = identifyingCommitHash;
		identifyingCommitHash = newIdentifyingCommitHash;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GitPackage.GIT_REPOSITORY__IDENTIFYING_COMMIT_HASH, oldIdentifyingCommitHash, identifyingCommitHash));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case GitPackage.GIT_REPOSITORY__URL:
			return getUrl();
		case GitPackage.GIT_REPOSITORY__IDENTIFYING_COMMIT_HASH:
			return getIdentifyingCommitHash();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case GitPackage.GIT_REPOSITORY__URL:
			setUrl((String) newValue);
			return;
		case GitPackage.GIT_REPOSITORY__IDENTIFYING_COMMIT_HASH:
			setIdentifyingCommitHash((String) newValue);
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
		case GitPackage.GIT_REPOSITORY__URL:
			setUrl(URL_EDEFAULT);
			return;
		case GitPackage.GIT_REPOSITORY__IDENTIFYING_COMMIT_HASH:
			setIdentifyingCommitHash(IDENTIFYING_COMMIT_HASH_EDEFAULT);
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
		case GitPackage.GIT_REPOSITORY__URL:
			return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
		case GitPackage.GIT_REPOSITORY__IDENTIFYING_COMMIT_HASH:
			return IDENTIFYING_COMMIT_HASH_EDEFAULT == null ? identifyingCommitHash != null : !IDENTIFYING_COMMIT_HASH_EDEFAULT.equals(identifyingCommitHash);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (url: ");
		result.append(url);
		result.append(", identifyingCommitHash: ");
		result.append(identifyingCommitHash);
		result.append(')');
		return result.toString();
	}

} //GitRepositoryImpl
