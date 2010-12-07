/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure.impl;

import XMIWorkspaceStructure.XMIECPContainer;
import XMIWorkspaceStructure.XMIECPProject;
import XMIWorkspaceStructure.XMIWorkspaceStructurePackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMIECP Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.impl.XMIECPContainerImpl#getInternalProjects <em>Internal Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class XMIECPContainerImpl extends EObjectImpl implements XMIECPContainer {
	/**
	 * The cached value of the '{@link #getInternalProjects() <em>Internal Projects</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInternalProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<XMIECPProject> internalProjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMIECPContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XMIWorkspaceStructurePackage.Literals.XMIECP_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XMIECPProject> getInternalProjects() {
		if (internalProjects == null) {
			internalProjects = new EObjectResolvingEList<XMIECPProject>(XMIECPProject.class, this, XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS);
		}
		return internalProjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS:
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
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS:
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
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS:
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
			case XMIWorkspaceStructurePackage.XMIECP_CONTAINER__INTERNAL_PROJECTS:
				return internalProjects != null && !internalProjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XMIECPContainerImpl
