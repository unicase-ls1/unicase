/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model.impl;

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

import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;

import org.eclipse.emf.emfstore.server.model.ProjectInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl#getProjectInfos <em>Project Infos</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl#getLastUsersession <em>Last Usersession</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl#getCertificateAlias <em>Certificate Alias</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerInfoImpl extends EObjectImpl implements ServerInfo {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final int PORT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected int port = PORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProjectInfos() <em>Project Infos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectInfo> projectInfos;

	/**
	 * The cached value of the '{@link #getLastUsersession() <em>Last Usersession</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUsersession()
	 * @generated
	 * @ordered
	 */
	protected Usersession lastUsersession;

	/**
	 * The default value of the '{@link #getCertificateAlias() <em>Certificate Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCertificateAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String CERTIFICATE_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCertificateAlias() <em>Certificate Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCertificateAlias()
	 * @generated
	 * @ordered
	 */
	protected String certificateAlias = CERTIFICATE_ALIAS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SERVER_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.SERVER_INFO__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.SERVER_INFO__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(int newPort) {
		int oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.SERVER_INFO__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProjectInfo> getProjectInfos() {
		if (projectInfos == null) {
			projectInfos = new EObjectContainmentEList.Resolving<ProjectInfo>(
					ProjectInfo.class, this,
					ModelPackage.SERVER_INFO__PROJECT_INFOS);
		}
		return projectInfos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession getLastUsersession() {
		if (lastUsersession != null && lastUsersession.eIsProxy()) {
			InternalEObject oldLastUsersession = (InternalEObject) lastUsersession;
			lastUsersession = (Usersession) eResolveProxy(oldLastUsersession);
			if (lastUsersession != oldLastUsersession) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ModelPackage.SERVER_INFO__LAST_USERSESSION,
							oldLastUsersession, lastUsersession));
			}
		}
		return lastUsersession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession basicGetLastUsersession() {
		return lastUsersession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastUsersession(Usersession newLastUsersession) {
		Usersession oldLastUsersession = lastUsersession;
		lastUsersession = newLastUsersession;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.SERVER_INFO__LAST_USERSESSION,
					oldLastUsersession, lastUsersession));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCertificateAlias() {
		return certificateAlias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCertificateAlias(String newCertificateAlias) {
		String oldCertificateAlias = certificateAlias;
		certificateAlias = newCertificateAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.SERVER_INFO__CERTIFICATE_ALIAS,
					oldCertificateAlias, certificateAlias));
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
		case ModelPackage.SERVER_INFO__PROJECT_INFOS:
			return ((InternalEList<?>) getProjectInfos()).basicRemove(otherEnd,
					msgs);
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
		case ModelPackage.SERVER_INFO__NAME:
			return getName();
		case ModelPackage.SERVER_INFO__URL:
			return getUrl();
		case ModelPackage.SERVER_INFO__PORT:
			return getPort();
		case ModelPackage.SERVER_INFO__PROJECT_INFOS:
			return getProjectInfos();
		case ModelPackage.SERVER_INFO__LAST_USERSESSION:
			if (resolve)
				return getLastUsersession();
			return basicGetLastUsersession();
		case ModelPackage.SERVER_INFO__CERTIFICATE_ALIAS:
			return getCertificateAlias();
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
		case ModelPackage.SERVER_INFO__NAME:
			setName((String) newValue);
			return;
		case ModelPackage.SERVER_INFO__URL:
			setUrl((String) newValue);
			return;
		case ModelPackage.SERVER_INFO__PORT:
			setPort((Integer) newValue);
			return;
		case ModelPackage.SERVER_INFO__PROJECT_INFOS:
			getProjectInfos().clear();
			getProjectInfos().addAll(
					(Collection<? extends ProjectInfo>) newValue);
			return;
		case ModelPackage.SERVER_INFO__LAST_USERSESSION:
			setLastUsersession((Usersession) newValue);
			return;
		case ModelPackage.SERVER_INFO__CERTIFICATE_ALIAS:
			setCertificateAlias((String) newValue);
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
		case ModelPackage.SERVER_INFO__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ModelPackage.SERVER_INFO__URL:
			setUrl(URL_EDEFAULT);
			return;
		case ModelPackage.SERVER_INFO__PORT:
			setPort(PORT_EDEFAULT);
			return;
		case ModelPackage.SERVER_INFO__PROJECT_INFOS:
			getProjectInfos().clear();
			return;
		case ModelPackage.SERVER_INFO__LAST_USERSESSION:
			setLastUsersession((Usersession) null);
			return;
		case ModelPackage.SERVER_INFO__CERTIFICATE_ALIAS:
			setCertificateAlias(CERTIFICATE_ALIAS_EDEFAULT);
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
		case ModelPackage.SERVER_INFO__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case ModelPackage.SERVER_INFO__URL:
			return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT
					.equals(url);
		case ModelPackage.SERVER_INFO__PORT:
			return port != PORT_EDEFAULT;
		case ModelPackage.SERVER_INFO__PROJECT_INFOS:
			return projectInfos != null && !projectInfos.isEmpty();
		case ModelPackage.SERVER_INFO__LAST_USERSESSION:
			return lastUsersession != null;
		case ModelPackage.SERVER_INFO__CERTIFICATE_ALIAS:
			return CERTIFICATE_ALIAS_EDEFAULT == null ? certificateAlias != null
					: !CERTIFICATE_ALIAS_EDEFAULT.equals(certificateAlias);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", url: ");
		result.append(url);
		result.append(", port: ");
		result.append(port);
		result.append(", certificateAlias: ");
		result.append(certificateAlias);
		result.append(')');
		return result.toString();
	}

} //ServerInfoImpl
