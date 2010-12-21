/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMIECP File Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject#getXmiFilePath <em>Xmi File Path</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject#getBaseElements <em>Base Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPFileProject()
 * @model
 * @generated
 */
public interface XMIECPFileProject extends XMIECPProject {
	/**
	 * Returns the value of the '<em><b>Xmi File Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmi File Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmi File Path</em>' attribute.
	 * @see #setXmiFilePath(String)
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPFileProject_XmiFilePath()
	 * @model
	 * @generated
	 */
	String getXmiFilePath();

	/**
	 * Sets the path to the xmi-file where the project contents are stored.
	 * @param newXmiFilePath The complete path to the xmi-file.
	 */
	void setXmiFilePath(String value);

	/**
	 * Returns the value of the '<em><b>Base Elements</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.common.util.EList}&lt;org.eclipse.emf.ecore.EObject>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Elements</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Elements</em>' attribute list.
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPFileProject_BaseElements()
	 * @model transient="true"
	 * @generated
	 */
	EList<EObject> getBaseElements();
	
	/**
	 * Sets the workspace for the project
	 * @param workspace where the project is contained in
	 */
	void setWorkspace(ECPWorkspace workspace);
	
	/**
	 * Returns all model elements of the first level in the tree hierarchy.
	 */
	public Collection<EObject> getRootLevel();

} // XMIECPFileProject
