/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.impl;

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

import org.unicase.esmodel.EsmodelPackage;
import org.unicase.esmodel.ProjectHistory;

import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.ProjectId;
import org.unicase.esmodel.changemanagment.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.esmodel.impl.ProjectHistoryImpl#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.unicase.esmodel.impl.ProjectHistoryImpl#getProjectInfo <em>Project Info</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectHistoryImpl extends EObjectImpl implements ProjectHistory {
	/**
	 * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersions()
	 * @generated
	 * @ordered
	 */
	protected EList<Version> versions;

	/**
	 * The cached value of the '{@link #getProjectInfo() <em>Project Info</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectInfo()
	 * @generated
	 * @ordered
	 */
	protected ProjectInfo projectInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectHistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsmodelPackage.Literals.PROJECT_HISTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Version> getVersions() {
		if (versions == null) {
			versions = new EObjectContainmentEList<Version>(Version.class, this, EsmodelPackage.PROJECT_HISTORY__VERSIONS);
		}
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectInfo getProjectInfo() {
		if (projectInfo != null && projectInfo.eIsProxy()) {
			InternalEObject oldProjectInfo = (InternalEObject)projectInfo;
			projectInfo = (ProjectInfo)eResolveProxy(oldProjectInfo);
			if (projectInfo != oldProjectInfo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EsmodelPackage.PROJECT_HISTORY__PROJECT_INFO, oldProjectInfo, projectInfo));
			}
		}
		return projectInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectInfo basicGetProjectInfo() {
		return projectInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectInfo(ProjectInfo newProjectInfo) {
		ProjectInfo oldProjectInfo = projectInfo;
		projectInfo = newProjectInfo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsmodelPackage.PROJECT_HISTORY__PROJECT_INFO, oldProjectInfo, projectInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsmodelPackage.PROJECT_HISTORY__VERSIONS:
				return ((InternalEList<?>)getVersions()).basicRemove(otherEnd, msgs);
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
			case EsmodelPackage.PROJECT_HISTORY__VERSIONS:
				return getVersions();
			case EsmodelPackage.PROJECT_HISTORY__PROJECT_INFO:
				if (resolve) return getProjectInfo();
				return basicGetProjectInfo();
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
			case EsmodelPackage.PROJECT_HISTORY__VERSIONS:
				getVersions().clear();
				getVersions().addAll((Collection<? extends Version>)newValue);
				return;
			case EsmodelPackage.PROJECT_HISTORY__PROJECT_INFO:
				setProjectInfo((ProjectInfo)newValue);
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
			case EsmodelPackage.PROJECT_HISTORY__VERSIONS:
				getVersions().clear();
				return;
			case EsmodelPackage.PROJECT_HISTORY__PROJECT_INFO:
				setProjectInfo((ProjectInfo)null);
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
			case EsmodelPackage.PROJECT_HISTORY__VERSIONS:
				return versions != null && !versions.isEmpty();
			case EsmodelPackage.PROJECT_HISTORY__PROJECT_INFO:
				return projectInfo != null;
		}
		return super.eIsSet(featureID);
	}

} //ProjectHistoryImpl
