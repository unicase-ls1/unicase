/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.xmiworkspacestructure;

import java.util.Collection;

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
	 * The <em>Xmi File Path</em> is the complete path to the xmi-file where the project is stored.
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
	 * Sets the path to the xmi file that is being loaded.
	 * @param filePath Complete path to the file.
	 * @see #getXmiFilePath()
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPFileProject_XmiFilePath()
	 * @models
	 * @generated
	 */
	void setXmiFilePath(String value);

	/**
	 * Set the workspace the project is contained in.
	 * @param workspace ECPWorkspace the project is contained in.
	 */
	void setWorkspace(ECPWorkspace workspace);
	
	/**
	 * Returns all model elements of the project.
	 */
	public Collection<EObject> getAllModelElements();

} // XMIECPFileProject
