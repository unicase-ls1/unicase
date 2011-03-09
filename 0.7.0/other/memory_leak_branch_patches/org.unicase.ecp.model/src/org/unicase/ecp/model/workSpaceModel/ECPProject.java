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
	 * @generated not
	 */
	boolean contains(EObject eObject);

	/**
	 * Returns all model elements contained in the project. Don't add elements
	 * to this collection. Instead use {@link #addModelElementToRoot(EObject)}
	 * or attach it as a child of an element of this collection.
	 * 
	 * 
	 * @return all model elements
	 * @generated not
	 */
	Collection<EObject> getAllModelElements();

	/**
	 * Returns all elements contained in the project that have the specified
	 * class type or one of its subtypes.
	 * 
	 * @param clazz
	 *            specified class type
	 * @param basicEList
	 *            list containing the results
	 * @return resulting list (is the same as the basicEList parameter, API will
	 *         be changed)
	 * @generated not
	 */
	// TODO: encapsulate 2nd parameter in the API
	Collection<EObject> getAllModelElementsbyClass(EClass clazz,
			BasicEList<EObject> basicEList);

	/**
	 * Specifies whether an element is a NonDomainElement (NDE). If the
	 * underlying layer doesn't support NDE, returns true. NDEs are model
	 * elements that are part of the model but shouldn't be visible to the user
	 * via the default UI. E.g. their are faded out in the navigator or you
	 * can't create them over the new model element dialog.F
	 * 
	 * @param eObject
	 *            object to test
	 * @return true if is NonDomainElement, false otherwise
	 * @generated not
	 */
	boolean isNonDomainElement(EObject eObject);

	void dispose();

	/**
	 * Allows to add an {@link ECPProjectListener}.
	 * 
	 * @param listener
	 *            listener
	 * @generated not
	 */
	void addECPProjectListener(ECPProjectListener listener);

	/**
	 * Allows to remove an {@link ECPProjectListener}.
	 * 
	 * @param listener
	 *            listener
	 * @generated not
	 */
	void removeECPProjectListener(ECPProjectListener listener);

	/**
	 * Notifies listeners about changes in the project.
	 * 
	 * @generated not
	 */
	void projectChanged();

	/**
	 * Notifies about deletion of a project.
	 * 
	 * @generated not
	 */
	void projectDeleted();

	/**
	 * Notifies about deletion of an model element.
	 * 
	 * @param eobject
	 */
	void modelelementDeleted(EObject eobject);

	/**
	 * Lets you add an element to the RootObject. This method is necessary since
	 * you don't know which feature of the RootObject to use.
	 * 
	 * @param eObject
	 * @generated not
	 */
	void addModelElementToRoot(EObject eObject);

	/**
	 * Returns the root object of the model, which is visible to the user. In
	 * general it is some sort of project.
	 * 
	 * @return eobject
	 */
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
