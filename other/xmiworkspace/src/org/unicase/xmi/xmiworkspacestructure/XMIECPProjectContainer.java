/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMIECP Project Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProjectContainer#getInternalProjects <em>Internal Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPProjectContainer()
 * @model abstract="true"
 * @generated
 */
public interface XMIECPProjectContainer extends EObject {
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

} // XMIECPProjectContainer
