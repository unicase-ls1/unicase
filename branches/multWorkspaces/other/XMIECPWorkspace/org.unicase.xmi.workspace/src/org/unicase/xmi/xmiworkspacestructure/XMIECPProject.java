/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.xmiworkspacestructure;

import org.unicase.ecp.model.workSpaceModel.ECPProject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMIECP Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject#getProjectDescription <em>Project Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPProject()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface XMIECPProject extends ECPProject {
	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * The default value is <code>"\"New Project\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPProject_ProjectName()
	 * @model default="\"New Project\""
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Project Description</b></em>' attribute.
	 * The default value is <code>"\"Empty new Project\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Description</em>' attribute.
	 * @see #setProjectDescription(String)
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#getXMIECPProject_ProjectDescription()
	 * @model default="\"Empty new Project\""
	 * @generated
	 */
	String getProjectDescription();

	/**
	 * Sets the value of the '{@link org.unicase.xmi.xmiworkspacestructure.XMIECPProject#getProjectDescription <em>Project Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Description</em>' attribute.
	 * @see #getProjectDescription()
	 * @generated
	 */
	void setProjectDescription(String value);

} // XMIECPProject
