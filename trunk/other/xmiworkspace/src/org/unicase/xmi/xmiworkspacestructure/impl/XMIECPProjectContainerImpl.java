/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.domain.EditingDomain;

import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP Project Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.impl.XMIECPProjectContainerImpl#getInternalProjects <em>Internal Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XMIECPProjectContainerImpl extends EObjectImpl implements XMIECPProjectContainer {
	/**
	 * The cached value of the '{@link #getInternalProjects() <em>Internal Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<XMIECPProject> internalProjects;

	/**
	 * Workspace the container is in.
	 */
	protected ECPWorkspace workspace;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMIECPProjectContainerImpl() {
		super();
		
		workspace = null; // initialize with null
	}
	
	public void setWorkspace(ECPWorkspace value) {
		this.workspace = value;
	}
	
	public ECPWorkspace getWorkspace() {
		return workspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmiworkspacestructurePackage.Literals.XMIECP_PROJECT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XMIECPProject> getInternalProjects() {
		if (internalProjects == null) {
			internalProjects = new EObjectContainmentEList<XMIECPProject>(XMIECPProject.class, this, XmiworkspacestructurePackage.XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS);
		}
		return internalProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmiworkspacestructurePackage.XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS:
				return ((InternalEList<?>)getInternalProjects()).basicRemove(otherEnd, msgs);
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
			case XmiworkspacestructurePackage.XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS:
				return getInternalProjects();
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
			case XmiworkspacestructurePackage.XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS:
				getInternalProjects().clear();
				getInternalProjects().addAll((Collection<? extends XMIECPProject>)newValue);
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
			case XmiworkspacestructurePackage.XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS:
				getInternalProjects().clear();
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
			case XmiworkspacestructurePackage.XMIECP_PROJECT_CONTAINER__INTERNAL_PROJECTS:
				return internalProjects != null && !internalProjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
} //XMIECPProjectContainerImpl
