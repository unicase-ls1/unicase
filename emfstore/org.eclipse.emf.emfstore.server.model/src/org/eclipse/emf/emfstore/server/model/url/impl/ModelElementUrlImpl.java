/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.url.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrl;
import org.eclipse.emf.emfstore.server.model.url.ModelElementUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ProjectUrlFragment;
import org.eclipse.emf.emfstore.server.model.url.ServerUrl;
import org.eclipse.emf.emfstore.server.model.url.UrlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Element Url</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlImpl#getServerUrl <em>Server Url</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlImpl#getProjectUrlFragment <em>Project Url Fragment
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.url.impl.ModelElementUrlImpl#getModelElementUrlFragment <em>Model Element Url
 * Fragment</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ModelElementUrlImpl extends EObjectImpl implements ModelElementUrl {
	private static final String UNICASE_PROTOCOL_PREFIX = "unicase://";

	/**
	 * The cached value of the '{@link #getServerUrl() <em>Server Url</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getServerUrl()
	 * @generated
	 * @ordered
	 */
	protected ServerUrl serverUrl;

	/**
	 * The cached value of the '{@link #getProjectUrlFragment() <em>Project Url Fragment</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProjectUrlFragment()
	 * @generated
	 * @ordered
	 */
	protected ProjectUrlFragment projectUrlFragment;

	/**
	 * The cached value of the '{@link #getModelElementUrlFragment() <em>Model Element Url Fragment</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getModelElementUrlFragment()
	 * @generated
	 * @ordered
	 */
	protected ModelElementUrlFragment modelElementUrlFragment;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementUrlImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrlPackage.Literals.MODEL_ELEMENT_URL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerUrl getServerUrl() {
		if (serverUrl != null && serverUrl.eIsProxy()) {
			InternalEObject oldServerUrl = (InternalEObject)serverUrl;
			serverUrl = (ServerUrl)eResolveProxy(oldServerUrl);
			if (serverUrl != oldServerUrl) {
				InternalEObject newServerUrl = (InternalEObject)serverUrl;
				NotificationChain msgs = oldServerUrl.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__SERVER_URL, null, null);
				if (newServerUrl.eInternalContainer() == null) {
					msgs = newServerUrl.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__SERVER_URL, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrlPackage.MODEL_ELEMENT_URL__SERVER_URL, oldServerUrl, serverUrl));
			}
		}
		return serverUrl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerUrl basicGetServerUrl() {
		return serverUrl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServerUrl(ServerUrl newServerUrl, NotificationChain msgs) {
		ServerUrl oldServerUrl = serverUrl;
		serverUrl = newServerUrl;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrlPackage.MODEL_ELEMENT_URL__SERVER_URL, oldServerUrl, newServerUrl);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerUrl(ServerUrl newServerUrl) {
		if (newServerUrl != serverUrl) {
			NotificationChain msgs = null;
			if (serverUrl != null)
				msgs = ((InternalEObject)serverUrl).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__SERVER_URL, null, msgs);
			if (newServerUrl != null)
				msgs = ((InternalEObject)newServerUrl).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__SERVER_URL, null, msgs);
			msgs = basicSetServerUrl(newServerUrl, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UrlPackage.MODEL_ELEMENT_URL__SERVER_URL, newServerUrl, newServerUrl));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectUrlFragment getProjectUrlFragment() {
		if (projectUrlFragment != null && projectUrlFragment.eIsProxy()) {
			InternalEObject oldProjectUrlFragment = (InternalEObject)projectUrlFragment;
			projectUrlFragment = (ProjectUrlFragment)eResolveProxy(oldProjectUrlFragment);
			if (projectUrlFragment != oldProjectUrlFragment) {
				InternalEObject newProjectUrlFragment = (InternalEObject)projectUrlFragment;
				NotificationChain msgs = oldProjectUrlFragment.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT, null, null);
				if (newProjectUrlFragment.eInternalContainer() == null) {
					msgs = newProjectUrlFragment.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT, oldProjectUrlFragment, projectUrlFragment));
			}
		}
		return projectUrlFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectUrlFragment basicGetProjectUrlFragment() {
		return projectUrlFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectUrlFragment(ProjectUrlFragment newProjectUrlFragment, NotificationChain msgs) {
		ProjectUrlFragment oldProjectUrlFragment = projectUrlFragment;
		projectUrlFragment = newProjectUrlFragment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT, oldProjectUrlFragment, newProjectUrlFragment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectUrlFragment(ProjectUrlFragment newProjectUrlFragment) {
		if (newProjectUrlFragment != projectUrlFragment) {
			NotificationChain msgs = null;
			if (projectUrlFragment != null)
				msgs = ((InternalEObject)projectUrlFragment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT, null, msgs);
			if (newProjectUrlFragment != null)
				msgs = ((InternalEObject)newProjectUrlFragment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT, null, msgs);
			msgs = basicSetProjectUrlFragment(newProjectUrlFragment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT, newProjectUrlFragment, newProjectUrlFragment));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementUrlFragment getModelElementUrlFragment() {
		if (modelElementUrlFragment != null && modelElementUrlFragment.eIsProxy()) {
			InternalEObject oldModelElementUrlFragment = (InternalEObject)modelElementUrlFragment;
			modelElementUrlFragment = (ModelElementUrlFragment)eResolveProxy(oldModelElementUrlFragment);
			if (modelElementUrlFragment != oldModelElementUrlFragment) {
				InternalEObject newModelElementUrlFragment = (InternalEObject)modelElementUrlFragment;
				NotificationChain msgs = oldModelElementUrlFragment.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT, null, null);
				if (newModelElementUrlFragment.eInternalContainer() == null) {
					msgs = newModelElementUrlFragment.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT, oldModelElementUrlFragment, modelElementUrlFragment));
			}
		}
		return modelElementUrlFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementUrlFragment basicGetModelElementUrlFragment() {
		return modelElementUrlFragment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElementUrlFragment(ModelElementUrlFragment newModelElementUrlFragment,
		NotificationChain msgs) {
		ModelElementUrlFragment oldModelElementUrlFragment = modelElementUrlFragment;
		modelElementUrlFragment = newModelElementUrlFragment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT, oldModelElementUrlFragment, newModelElementUrlFragment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementUrlFragment(ModelElementUrlFragment newModelElementUrlFragment) {
		if (newModelElementUrlFragment != modelElementUrlFragment) {
			NotificationChain msgs = null;
			if (modelElementUrlFragment != null)
				msgs = ((InternalEObject)modelElementUrlFragment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT, null, msgs);
			if (newModelElementUrlFragment != null)
				msgs = ((InternalEObject)newModelElementUrlFragment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT, null, msgs);
			msgs = basicSetModelElementUrlFragment(newModelElementUrlFragment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT, newModelElementUrlFragment, newModelElementUrlFragment));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UrlPackage.MODEL_ELEMENT_URL__SERVER_URL:
				return basicSetServerUrl(null, msgs);
			case UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT:
				return basicSetProjectUrlFragment(null, msgs);
			case UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT:
				return basicSetModelElementUrlFragment(null, msgs);
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
			case UrlPackage.MODEL_ELEMENT_URL__SERVER_URL:
				if (resolve) return getServerUrl();
				return basicGetServerUrl();
			case UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT:
				if (resolve) return getProjectUrlFragment();
				return basicGetProjectUrlFragment();
			case UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT:
				if (resolve) return getModelElementUrlFragment();
				return basicGetModelElementUrlFragment();
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
			case UrlPackage.MODEL_ELEMENT_URL__SERVER_URL:
				setServerUrl((ServerUrl)newValue);
				return;
			case UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT:
				setProjectUrlFragment((ProjectUrlFragment)newValue);
				return;
			case UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT:
				setModelElementUrlFragment((ModelElementUrlFragment)newValue);
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
			case UrlPackage.MODEL_ELEMENT_URL__SERVER_URL:
				setServerUrl((ServerUrl)null);
				return;
			case UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT:
				setProjectUrlFragment((ProjectUrlFragment)null);
				return;
			case UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT:
				setModelElementUrlFragment((ModelElementUrlFragment)null);
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
			case UrlPackage.MODEL_ELEMENT_URL__SERVER_URL:
				return serverUrl != null;
			case UrlPackage.MODEL_ELEMENT_URL__PROJECT_URL_FRAGMENT:
				return projectUrlFragment != null;
			case UrlPackage.MODEL_ELEMENT_URL__MODEL_ELEMENT_URL_FRAGMENT:
				return modelElementUrlFragment != null;
		}
		return super.eIsSet(featureID);
	}

	public String getUrlString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(UNICASE_PROTOCOL_PREFIX);
		stringBuilder.append(getServerUrl().getUrlString());
		stringBuilder.append("/");
		stringBuilder.append(getProjectUrlFragment().getUrlString());
		stringBuilder.append("/");
		stringBuilder.append(getModelElementUrlFragment().getUrlString());
		return stringBuilder.toString();
	}

} // ModelElementUrlImpl
