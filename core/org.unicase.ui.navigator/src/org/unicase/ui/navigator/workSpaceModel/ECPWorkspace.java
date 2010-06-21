/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.workSpaceModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ECP Workspace</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getProjects <em>Projects</em>}</li>
 * <li>{@link org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getActiveProject <em>Active Project</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelPackage#getECPWorkspace()
 * @model
 * @generated
 */
public interface ECPWorkspace extends EObject {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.ui.navigator.workSpaceModel.ECPProject}. It is bidirectional and its opposite is '
	 * {@link org.unicase.ui.navigator.workSpaceModel.ECPProject#getWorkspace <em>Workspace</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelPackage#getECPWorkspace_Projects()
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPProject#getWorkspace
	 * @model opposite="workspace" containment="true"
	 * @generated
	 */
	EList<ECPProject> getProjects();

	public ECPProject getProject(EObject me);

	public ECPProject getActiveProject();

	/**
	 * Sets the value of the '{@link org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getActiveProject
	 * <em>Active Project</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Active Project</em>' reference.
	 * @see #getActiveProject()
	 * @generated
	 */
	void setActiveProject(ECPProject value);

	public void setActiveModelelement(EObject eobject);

	/**
	 * Returns the transaction editing domain.
	 * 
	 * @return the editing domain
	 */
	public TransactionalEditingDomain getEditingDomain();

	/**
	 * Sets the transaction editing domain.
	 * 
	 * @param editingDomain the editing domain
	 */
	public void setEditingDomain(TransactionalEditingDomain editingDomain);

} // ECPWorkspace
