/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
import org.unicase.emfstore.esmodel.versioning.ChangePackage;

import org.unicase.model.Project;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Analysis Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl#getProjectState <em>Project State</em>}</li>
 *   <li>{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl#getChangePackages <em>Change Packages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProjectAnalysisDataImpl extends EObjectImpl implements ProjectAnalysisData {
	/**
	 * The cached value of the '{@link #getProjectState() <em>Project State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjectState()
	 * @generated
	 * @ordered
	 */
	protected Project projectState;

	/**
	 * The cached value of the '{@link #getChangePackages() <em>Change Packages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangePackages()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangePackage> changePackages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectAnalysisDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.PROJECT_ANALYSIS_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProjectState() {
		return projectState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChangePackage> getChangePackages() {
		if (changePackages == null) {
			changePackages = new EObjectContainmentEList<ChangePackage>(ChangePackage.class, this, AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES);
		}
		return changePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				return basicSetProjectState(null, msgs);
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				return ((InternalEList<?>)getChangePackages()).basicRemove(otherEnd, msgs);
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
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				return getProjectState();
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				return getChangePackages();
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
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				setProjectState((Project)newValue);
				return;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				getChangePackages().clear();
				getChangePackages().addAll((Collection<? extends ChangePackage>)newValue);
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
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				setProjectState((Project)null);
				return;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				getChangePackages().clear();
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
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__PROJECT_STATE:
				return projectState != null;
			case AnalyzerPackage.PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES:
				return changePackages != null && !changePackages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProjectAnalysisDataImpl
