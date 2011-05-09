/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.xmiworkspacestructure;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.unicase.ecp.model.workSpaceModel.ECPProjectListener;
import org.unicase.ecp.model.workSpaceModel.ECPWorkspace;
import org.unicase.xmi.workspace.XmiUtil;
import org.unicase.xmi.workspace.XmiUtil.PROJECT_STATUS;

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
	 * Sets the workspace for the project
	 * @param workspace where the project is contained in
	 */
	void setWorkspace(ECPWorkspace workspace);
	
	/**
	 * Loads the project's resource or creates it.
	 */
	public void loadContents();
	
	/**
	 * Returns all model elements of the first level in the tree hierarchy.
	 */
	public Collection<EObject> getRootLevel();

	/**
	 * Returns the status of the project.
	 */
	public PROJECT_STATUS getProjectStatus();
	
	/**
	 * Sets the project status, e.g. when a project file is corrupted or not found.
	 * @param status Current project status.
	 */
	public void setProjectStatus(XmiUtil.PROJECT_STATUS status);
	
	/**
	 * Returns the listeners of the project so they can be informed when the project is removed from the workspace.
	 */
	public List<ECPProjectListener> getProjectListeners();
	
	/**
	 * Retrieve whether the filepath is relative to workspace
	 * @return true if the filepath is relative to workspace else false
	 */
	public boolean isWorkspacePath();
	
	/**
	 * Sets whether the filepath is relative to workspace 
	 * @param isWsP
	 */
	public void isWorkspacePath (boolean isWsP);
	
} // XMIECPFileProject
