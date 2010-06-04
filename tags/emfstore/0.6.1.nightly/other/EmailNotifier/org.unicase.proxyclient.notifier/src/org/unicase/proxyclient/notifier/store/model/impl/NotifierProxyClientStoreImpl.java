/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.proxyclient.notifier.store.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.proxyclient.notifier.store.model.NPCPackage;
import org.unicase.proxyclient.notifier.store.model.NotificationProject;
import org.unicase.proxyclient.notifier.store.model.NotifierProxyClientStore;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Notifier Proxy Client Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.proxyclient.notifier.store.model.impl.NotifierProxyClientStoreImpl#getProjects <em>Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotifierProxyClientStoreImpl extends EObjectImpl implements NotifierProxyClientStore {
	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<NotificationProject> projects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NotifierProxyClientStoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NPCPackage.Literals.NOTIFIER_PROXY_CLIENT_STORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NotificationProject> getProjects() {
		if (projects == null) {
			projects = new EObjectContainmentEList<NotificationProject>(NotificationProject.class, this, NPCPackage.NOTIFIER_PROXY_CLIENT_STORE__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NPCPackage.NOTIFIER_PROXY_CLIENT_STORE__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
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
			case NPCPackage.NOTIFIER_PROXY_CLIENT_STORE__PROJECTS:
				return getProjects();
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
			case NPCPackage.NOTIFIER_PROXY_CLIENT_STORE__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends NotificationProject>)newValue);
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
			case NPCPackage.NOTIFIER_PROXY_CLIENT_STORE__PROJECTS:
				getProjects().clear();
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
			case NPCPackage.NOTIFIER_PROXY_CLIENT_STORE__PROJECTS:
				return projects != null && !projects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NotifierProxyClientStoreImpl
