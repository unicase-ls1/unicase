/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMIECP Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.XMIECPContainer#getInternalProjects <em>Internal Projects</em>}</li>
 * </ul>
 * </p>
 *
 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPContainer()
 * @model abstract="true"
 * @generated
 */
public interface XMIECPContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Internal Projects</b></em>' reference list.
	 * The list contents are of type {@link XMIWorkspaceStructure.XMIECPProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Projects</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Projects</em>' reference list.
	 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPContainer_InternalProjects()
	 * @model
	 * @generated
	 */
	EList<XMIECPProject> getInternalProjects();

} // XMIECPContainer
