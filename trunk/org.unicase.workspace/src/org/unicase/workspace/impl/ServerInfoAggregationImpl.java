/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.ServerInfoAggregation;
import org.unicase.workspace.WorkspacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Info Aggregation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.workspace.impl.ServerInfoAggregationImpl#getServerInfos <em>Server Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerInfoAggregationImpl extends EObjectImpl implements ServerInfoAggregation {
	/**
	 * The cached value of the '{@link #getServerInfos() <em>Server Infos</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerInfo> serverInfos;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerInfoAggregationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.SERVER_INFO_AGGREGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServerInfo> getServerInfos() {
		if (serverInfos == null) {
			serverInfos = new EObjectContainmentEList<ServerInfo>(ServerInfo.class, this, WorkspacePackage.SERVER_INFO_AGGREGATION__SERVER_INFOS);
		}
		return serverInfos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkspacePackage.SERVER_INFO_AGGREGATION__SERVER_INFOS:
				return ((InternalEList<?>)getServerInfos()).basicRemove(otherEnd, msgs);
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
			case WorkspacePackage.SERVER_INFO_AGGREGATION__SERVER_INFOS:
				return getServerInfos();
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
			case WorkspacePackage.SERVER_INFO_AGGREGATION__SERVER_INFOS:
				getServerInfos().clear();
				getServerInfos().addAll((Collection<? extends ServerInfo>)newValue);
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
			case WorkspacePackage.SERVER_INFO_AGGREGATION__SERVER_INFOS:
				getServerInfos().clear();
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
			case WorkspacePackage.SERVER_INFO_AGGREGATION__SERVER_INFOS:
				return serverInfos != null && !serverInfos.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServerInfoAggregationImpl
