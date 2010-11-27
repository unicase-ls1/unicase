/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.XMIWorkspaceStructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMIECP Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.xmi.XMIWorkspaceStructure.XMIECPContainer#getInternalProjects <em>Internal Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.xmi.XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPContainer()
 * @model abstract="true"
 * @generated
 */
public interface XMIECPContainer extends XMIECPProject {
	/**
	 * Returns the value of the '<em><b>Internal Projects</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Projects</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Projects</em>' attribute.
	 * @see #setInternalProjects(EList)
	 * @see org.unicase.xmi.XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPContainer_InternalProjects()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<?> getInternalProjects();

	/**
	 * Sets the value of the '{@link org.unicase.xmi.XMIWorkspaceStructure.XMIECPContainer#getInternalProjects <em>Internal Projects</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Projects</em>' attribute.
	 * @see #getInternalProjects()
	 * @generated
	 */
	void setInternalProjects(EList<?> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<?> getContainedProjects();

} // XMIECPContainer
