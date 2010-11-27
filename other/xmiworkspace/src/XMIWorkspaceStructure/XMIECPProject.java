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
 * A representation of the model object '<em><b>XMIECP Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.XMIECPProject#getElements <em>Elements</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.XMIECPProject#getEditingDomain <em>Editing Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPProject()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface XMIECPProject extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' attribute.
	 * @see #setElements(EList)
	 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPProject_Elements()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<?> getElements();

	/**
	 * Sets the value of the '{@link XMIWorkspaceStructure.XMIECPProject#getElements <em>Elements</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elements</em>' attribute.
	 * @see #getElements()
	 * @generated
	 */
	void setElements(EList<?> value);

	/**
	 * Returns the value of the '<em><b>Editing Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editing Domain</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editing Domain</em>' attribute.
	 * @see #setEditingDomain(String)
	 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPProject_EditingDomain()
	 * @model
	 * @generated
	 */
	String getEditingDomain();

	/**
	 * Sets the value of the '{@link XMIWorkspaceStructure.XMIECPProject#getEditingDomain <em>Editing Domain</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editing Domain</em>' attribute.
	 * @see #getEditingDomain()
	 * @generated
	 */
	void setEditingDomain(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<?> getAllElements();

} // XMIECPProject
