/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure;

import org.eclipse.emf.common.util.EList;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMIECP Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFolder#getXmiDirectoryPath <em>Xmi Directory Path</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFolder#getContainedFiles <em>Contained Files</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPFolder()
 * @model
 * @generated
 */
public interface XMIECPFolder extends XMIECPProjectContainer {
	/**
	 * Returns the value of the '<em><b>Xmi Directory Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xmi Directory Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xmi Directory Path</em>' attribute.
	 * @see #setXmiDirectoryPath(String)
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPFolder_XmiDirectoryPath()
	 * @model
	 * @generated
	 */
	String getXmiDirectoryPath();

	/**
	 * Sets the value of the '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPFolder#getXmiDirectoryPath <em>Xmi Directory Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xmi Directory Path</em>' attribute.
	 * @see #getXmiDirectoryPath()
	 * @generated
	 */
	void setXmiDirectoryPath(String value);

	/**
	 * Returns the value of the '<em><b>Contained Files</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Files</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Files</em>' attribute.
	 * @see #setContainedFiles(EList)
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPFolder_ContainedFiles()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<String> getContainedFiles();
	
	/**
	 * Sets the workspace for the contained projects.
	 * @param ws ECPWorkspace that will manage the projects.
	 */
	void setWorkspace(ECPWorkspace ws);

} // XMIECPFolder
