/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.model.EsmodelPackage;
import org.unicase.emfstore.model.ProjectHistory;
import org.unicase.emfstore.model.ServerSpace;
import org.unicase.emfstore.model.SessionId;
import org.unicase.emfstore.model.accesscontrol.ACOrgUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Server Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.model.impl.ServerSpaceImpl#getOrgUnits <em>Org Units</em>}</li>
 *   <li>{@link org.unicase.emfstore.model.impl.ServerSpaceImpl#getProjects <em>Projects</em>}</li>
 *   <li>{@link org.unicase.emfstore.model.impl.ServerSpaceImpl#getOpenSessions <em>Open Sessions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerSpaceImpl extends EObjectImpl implements ServerSpace {
	/**
	 * The cached value of the '{@link #getOrgUnits() <em>Org Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrgUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<ACOrgUnit> orgUnits;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectHistory> projects;

	/**
	 * The cached value of the '{@link #getOpenSessions() <em>Open Sessions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenSessions()
	 * @generated
	 * @ordered
	 */
	protected EList<SessionId> openSessions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsmodelPackage.Literals.SERVER_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ACOrgUnit> getOrgUnits() {
		if (orgUnits == null) {
			orgUnits = new EObjectContainmentEList<ACOrgUnit>(ACOrgUnit.class, this, EsmodelPackage.SERVER_SPACE__ORG_UNITS);
		}
		return orgUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProjectHistory> getProjects() {
		if (projects == null) {
			projects = new EObjectContainmentEList<ProjectHistory>(ProjectHistory.class, this, EsmodelPackage.SERVER_SPACE__PROJECTS);
		}
		return projects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SessionId> getOpenSessions() {
		if (openSessions == null) {
			openSessions = new EObjectContainmentEList<SessionId>(SessionId.class, this, EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS);
		}
		return openSessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsmodelPackage.SERVER_SPACE__ORG_UNITS:
				return ((InternalEList<?>)getOrgUnits()).basicRemove(otherEnd, msgs);
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				return ((InternalEList<?>)getProjects()).basicRemove(otherEnd, msgs);
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				return ((InternalEList<?>)getOpenSessions()).basicRemove(otherEnd, msgs);
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
			case EsmodelPackage.SERVER_SPACE__ORG_UNITS:
				return getOrgUnits();
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				return getProjects();
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				return getOpenSessions();
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
			case EsmodelPackage.SERVER_SPACE__ORG_UNITS:
				getOrgUnits().clear();
				getOrgUnits().addAll((Collection<? extends ACOrgUnit>)newValue);
				return;
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends ProjectHistory>)newValue);
				return;
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				getOpenSessions().clear();
				getOpenSessions().addAll((Collection<? extends SessionId>)newValue);
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
			case EsmodelPackage.SERVER_SPACE__ORG_UNITS:
				getOrgUnits().clear();
				return;
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				getProjects().clear();
				return;
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				getOpenSessions().clear();
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
			case EsmodelPackage.SERVER_SPACE__ORG_UNITS:
				return orgUnits != null && !orgUnits.isEmpty();
			case EsmodelPackage.SERVER_SPACE__PROJECTS:
				return projects != null && !projects.isEmpty();
			case EsmodelPackage.SERVER_SPACE__OPEN_SESSIONS:
				return openSessions != null && !openSessions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ServerSpaceImpl
