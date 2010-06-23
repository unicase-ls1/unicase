/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.workSpaceModel;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.common.ECPModelelementContext;
import org.unicase.ui.common.MetaModelElementContext;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ECP Project</b></em>'.
 * 
 * @implements ECPModelelementContext <!-- end-user-doc -->
 *             <p>
 *             The following features are supported:
 *             <ul>
 *             <li>{@link org.unicase.ui.navigator.workSpaceModel.ECPProject#getWorkspace <em>Workspace</em>}</li>
 *             <li>{@link org.unicase.ui.navigator.workSpaceModel.ECPProject#getRootObject <em>Root Object</em>}</li>
 *             </ul>
 *             </p>
 * @see org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelPackage#getECPProject()
 * @model abstract="true"
 * @generated
 */
public interface ECPProject extends EObject, ECPModelelementContext {

	/**
	 * Returns the value of the '<em><b>Workspace</b></em>' container reference. It is bidirectional and its opposite is
	 * '{@link org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getProjects <em>Projects</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Workspace</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Workspace</em>' container reference.
	 * @see #setWorkspace(ECPWorkspace)
	 * @see org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelPackage#getECPProject_Workspace()
	 * @see org.unicase.ui.navigator.workSpaceModel.ECPWorkspace#getProjects
	 * @model opposite="projects" transient="false"
	 * @generated
	 */
	ECPWorkspace getWorkspace();

	/**
	 * Sets the value of the '{@link org.unicase.ui.navigator.workSpaceModel.ECPProject#getWorkspace <em>Workspace</em>}
	 * ' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Workspace</em>' container reference.
	 * @see #getWorkspace()
	 * @generated
	 */
	void setWorkspace(ECPWorkspace value);

	boolean contains(EObject eObject);

	Collection<EObject> getAllModelElement();

	Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList);

	MetaModelElementContext getMetaModelElementContext();

	boolean isNonDomainElement(EObject eObject);

	void dispose();

	void addECPProjectListener(ECPProjectListener listener);

	void removeECPProjectListener(ECPProjectListener listener);

	void projectChanged();

	void projectDeleted();

	void modelelementDeleted(EObject eobject);

	EObject getRootObject();

	/**
	 * Sets the value of the '{@link org.unicase.ui.navigator.workSpaceModel.ECPProject#getRootObject
	 * <em>Root Object</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Root Object</em>' reference.
	 * @see #getRootObject()
	 * @generated
	 */
	void setRootObject(EObject value);

} // ECPProject
