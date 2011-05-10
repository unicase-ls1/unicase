/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.model.workSpaceModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ECP Workspace</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace#getProjects <em>Projects</em>}</li>
 * <li>{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace#getActiveProject <em>Active Project</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage#getECPWorkspace()
 * @model
 * @generated
 */
public interface ECPWorkspace extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject}.
	 * It is bidirectional and its opposite is '
	 * {@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject#getWorkspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage#getECPWorkspace_Projects()
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject#getWorkspace
	 * @model opposite="workspace" containment="true"
	 * @generated
	 */
	EList<ECPProject> getProjects();

	public ECPProject getProject(EObject me);

	public ECPProject getActiveProject();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace#getActiveProject
	 * <em>Active Project</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Active Project</em>' reference.
	 * @see #getActiveProject()
	 * @generated
	 */
	void setActiveProject(ECPProject value);

	public void setActiveModelelement(EObject eobject);

	/**
	 * Returns the editing domain.
	 * 
	 * @return the editing domain
	 */
	public EditingDomain getEditingDomain();

	/**
	 * Sets the editing domain.
	 * 
	 * @param editingDomain the editing domain
	 */
	public void setEditingDomain(EditingDomain editingDomain);

	/**
	 * Checks if the eobject is a root object in this workspace. Root objects are not the ECPProjects, but the wrapper
	 * objects, returned by ecpproject.getRootObject.
	 * 
	 * @param eObject the object to check if it is a root object
	 * @return if the object is a root object;
	 */
	public boolean isRootObject(EObject eObject);

} // ECPWorkspace
