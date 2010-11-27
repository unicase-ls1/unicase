/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package XMIWorkspaceStructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMIECP Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link XMIWorkspaceStructure.XMIECPFolder#getXmiDirectoryPath <em>Xmi Directory Path</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.XMIECPFolder#getContainedFiles <em>Contained Files</em>}</li>
 *   <li>{@link XMIWorkspaceStructure.XMIECPFolder#getProjectResources <em>Project Resources</em>}</li>
 * </ul>
 * </p>
 *
 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPFolder()
 * @model
 * @generated
 */
public interface XMIECPFolder extends XMIECPContainer {
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
	 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPFolder_XmiDirectoryPath()
	 * @model
	 * @generated
	 */
	String getXmiDirectoryPath();

	/**
	 * Sets the value of the '{@link XMIWorkspaceStructure.XMIECPFolder#getXmiDirectoryPath <em>Xmi Directory Path</em>}' attribute.
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
	 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPFolder_ContainedFiles()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<?> getContainedFiles();

	/**
	 * Sets the value of the '{@link XMIWorkspaceStructure.XMIECPFolder#getContainedFiles <em>Contained Files</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained Files</em>' attribute.
	 * @see #getContainedFiles()
	 * @generated
	 */
	void setContainedFiles(EList<?> value);

	/**
	 * Returns the value of the '<em><b>Project Resources</b></em>' reference list.
	 * The list contents are of type {@link XMIWorkspaceStructure.XMIECPFileProject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Resources</em>' reference list.
	 * @see XMIWorkspaceStructure.XMIWorkspaceStructurePackage#getXMIECPFolder_ProjectResources()
	 * @model
	 * @generated
	 */
	EList<XMIECPFileProject> getProjectResources();

} // XMIECPFolder
