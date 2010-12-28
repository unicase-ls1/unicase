/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure;

import org.eclipse.emf.common.util.EList;

import org.unicase.ecp.model.workSpaceModel.ECPProject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMIECP Project Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer#getInternalProjects <em>Internal Projects</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer#getContainerName <em>Container Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPProjectContainer()
 * @model abstract="true"
 * @generated
 */
public interface XMIECPProjectContainer extends ECPProject {
	/**
	 * Returns the value of the '<em><b>Internal Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Projects</em>' containment reference list.
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPProjectContainer_InternalProjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<XMIECPProject> getInternalProjects();

	/**
	 * Returns the value of the '<em><b>Container Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Name</em>' attribute.
	 * @see #setContainerName(String)
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPProjectContainer_ContainerName()
	 * @model
	 * @generated
	 */
	String getContainerName();

	/**
	 * Sets the value of the '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer#getContainerName <em>Container Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Name</em>' attribute.
	 * @see #getContainerName()
	 * @generated
	 */
	void setContainerName(String value);

} // XMIECPProjectContainer
