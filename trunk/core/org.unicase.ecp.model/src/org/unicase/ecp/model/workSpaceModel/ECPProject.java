/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecp.model.workSpaceModel;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ecp.model.ECPModelelementContext;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>ECP Project</b></em>'.
 * 
 * @implements ECPModelelementContext <!-- end-user-doc -->
 *             <p>
 *             The following features are supported:
 *             <ul>
 *             <li>
 *             {@link org.unicase.ecp.model.workSpaceModel.ECPProject#getWorkspace
 *             <em>Workspace</em>}</li>
 *             <li>
 *             {@link org.unicase.ecp.model.workSpaceModel.ECPProject#getRootObject
 *             <em>Root Object</em>}</li>
 *             </ul>
 *             </p>
 * @see org.unicase.ecp.model.workSpaceModel.WorkSpaceModelPackage#getECPProject()
 * @model abstract="true"
 * @generated
 */
public interface ECPProject extends EObject, ECPModelelementContext {

	/**
	 * Returns the value of the '<em><b>Workspace</b></em>' container reference.
	 * It is bidirectional and its opposite is '
	 * {@link org.unicase.ecp.model.workSpaceModel.ECPWorkspace#getProjects
	 * <em>Projects</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Workspace</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Workspace</em>' container reference.
	 * @see #setWorkspace(ECPWorkspace)
	 * @see org.unicase.ecp.model.workSpaceModel.WorkSpaceModelPackage#getECPProject_Workspace()
	 * @see org.unicase.ecp.model.workSpaceModel.ECPWorkspace#getProjects
	 * @model opposite="projects" transient="false"
	 * @generated
	 */
	ECPWorkspace getWorkspace();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.ecp.model.workSpaceModel.ECPProject#getWorkspace
	 * <em>Workspace</em>} ' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Workspace</em>' container reference.
	 * @see #getWorkspace()
	 * @generated
	 */
	void setWorkspace(ECPWorkspace value);

	/**
	 * Checks whether an EObject is contained in the project.
	 * 
	 * @param eObject
	 *            EObject
	 * @return true if is contained
	 */
	boolean contains(EObject eObject);

	/**
	 * Returns all model elements contained in the project. Don't add elements
	 * to this collection, instead use {@link #addModelElementToRoot(EObject)}
	 * or attach it as a child of an element of this collection.
	 * 
	 * 
	 * @return all model elements
	 */
	Collection<EObject> getAllModelElement();

	/**
	 * Returns all elements contained in the project of the specified class type or its subtypes.
	 * 
	 * @param clazz specified class type
	 * @param basicEList list containing the results
	 * TODO
	 * @return resulting list (is the same as the basicEList parameter, API will be changed)
	 */
	Collection<EObject> getAllModelElementsbyClass(EClass clazz,
			BasicEList<EObject> basicEList);

	/**
	 * Specifies whether an element is a NonDomainElement. If the underlying layer doesn't support NDE, return true.
	 * 
	 * @param eObject object of test
	 * @return true if is NonDomainElement
	 */
	boolean isNonDomainElement(EObject eObject);

	void dispose();

	void addECPProjectListener(ECPProjectListener listener);

	void removeECPProjectListener(ECPProjectListener listener);

	void projectChanged();

	void projectDeleted();

	void modelelementDeleted(EObject eobject);

	void addModelElementToRoot(EObject eObject);

	EObject getRootObject();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.ecp.model.workSpaceModel.ECPProject#getRootObject
	 * <em>Root Object</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Root Object</em>' reference.
	 * @see #getRootObject()
	 * @generated
	 */
	void setRootObject(EObject value);

} // ECPProject
