/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.impl;

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
import org.unicase.analyzer.AnalyzerPackage;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Project Analysis Data</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl#getProjectState <em>Project State</em>}</li>
 *   <li>{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl#getChangePackages <em>Change Packages</em>}</li>
 *   <li>{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl#getPrimaryVersionSpec <em>Primary Version Spec</em>}</li>
 *   <li>{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl#getProjectId <em>Project Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectAnalysisDataImpl extends EObjectImpl implements ProjectAnalysisData {
	/**
	 * The cached value of the '{@link #getProjectState() <em>Project State</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectState()
	 * @generated
	 * @ordered
	 */
	protected Project projectState;

	/**
	 * The cached value of the '{@link #getChangePackages() <em>Change Packages</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChangePackages()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangePackage> changePackages;

	/**
	 * The cached value of the '{@link #getPrimaryVersionSpec() <em>Primary Version Spec</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPrimaryVersionSpec()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec primaryVersionSpec;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectAnalysisDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.PROJECT_ANALYSIS_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProjectState() {
		return projectState;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProjectState(Project newProjectState, NotificationChain msgs) {
		Project oldProjectState = projectState;
		projectState = newProjectState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE, oldProjectState, newProjectState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectState(Project newProjectState) {
		if (newProjectState != projectState) {
			NotificationChain msgs = null;
			if (projectState != null)
				msgs = ((InternalEObject)projectState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE, null, msgs);
			if (newProjectState != null)
				msgs = ((InternalEObject)newProjectState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE, null, msgs);
			msgs = basicSetProjectState(newProjectState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE, newProjectState, newProjectState));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChangePackage> getChangePackages() {
		if (changePackages == null) {
			changePackages = new EObjectContainmentEList<ChangePackage>(ChangePackage.class, this, AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES);
		}
		return changePackages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec getPrimaryVersionSpec() {
		return primaryVersionSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimaryVersionSpec(PrimaryVersionSpec newPrimaryVersionSpec, NotificationChain msgs) {
		PrimaryVersionSpec oldPrimaryVersionSpec = primaryVersionSpec;
		primaryVersionSpec = newPrimaryVersionSpec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC, oldPrimaryVersionSpec, newPrimaryVersionSpec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryVersionSpec(PrimaryVersionSpec newPrimaryVersionSpec) {
		if (newPrimaryVersionSpec != primaryVersionSpec) {
			NotificationChain msgs = null;
			if (primaryVersionSpec != null)
				msgs = ((InternalEObject)primaryVersionSpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC, null, msgs);
			if (newPrimaryVersionSpec != null)
				msgs = ((InternalEObject)newPrimaryVersionSpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC, null, msgs);
			msgs = basicSetPrimaryVersionSpec(newPrimaryVersionSpec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC, newPrimaryVersionSpec, newPrimaryVersionSpec));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProjectId() {
		if (projectId != null && projectId.eIsProxy()) {
			InternalEObject oldProjectId = (InternalEObject)projectId;
			projectId = (ProjectId)eResolveProxy(oldProjectId);
			if (projectId != oldProjectId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_ID, oldProjectId, projectId));
			}
		}
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId basicGetProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_ID, oldProjectId, projectId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				return basicSetProjectState(null, msgs);
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				return ((InternalEList<?>)getChangePackages()).basicRemove(otherEnd, msgs);
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC:
				return basicSetPrimaryVersionSpec(null, msgs);
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
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				return getProjectState();
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				return getChangePackages();
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC:
				return getPrimaryVersionSpec();
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_ID:
				if (resolve) return getProjectId();
				return basicGetProjectId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				setProjectState((Project)newValue);
				return;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				getChangePackages().clear();
				getChangePackages().addAll((Collection<? extends ChangePackage>)newValue);
				return;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC:
				setPrimaryVersionSpec((PrimaryVersionSpec)newValue);
				return;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_ID:
				setProjectId((ProjectId)newValue);
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
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				setProjectState((Project)null);
				return;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				getChangePackages().clear();
				return;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC:
				setPrimaryVersionSpec((PrimaryVersionSpec)null);
				return;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_ID:
				setProjectId((ProjectId)null);
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
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				return projectState != null;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				return changePackages != null && !changePackages.isEmpty();
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC:
				return primaryVersionSpec != null;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_ID:
				return projectId != null;
		}
		return super.eIsSet(featureID);
	}

} // ProjectAnalysisDataImpl
