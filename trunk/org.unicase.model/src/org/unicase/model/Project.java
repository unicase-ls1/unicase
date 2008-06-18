/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Project</b></em>'.
 * 
 * @implements IAdaptable <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.Project#getModelElements <em>Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject, IAdaptable {

	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.unicase.model.ModelPackage#getProject_ModelElements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ModelElement> getModelElements();

	/**
	 * <!-- begin-user-doc --> Add a Model Element to the project as direct
	 * content. This is only necessary if the model element is not contained in
	 * any other model element. <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addModelElement(ModelElement modelElement);

	/**
	 * <!-- begin-user-doc --> Return all model elements in the project
	 * including model elements transitively contained by project.
	 * <!--end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<ModelElement> getAllModelElements();

	/**
	 * <!-- begin-user-doc -->
	 * Return all model elements that are instances of the given class in the project
	 * including model elements transitively contained by project.
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModelElement> getAllModelElementsbyClass(EClass modelElementClass);

	/**
	 * <!-- begin-user-doc --> 
	 * Return model elements that are instances of the given class in the project.
	 * Only returns Model Elements directly contained in the project.
	 * <!-- end-user-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ModelElement> getModelElementsByClass(EClass modelElementClass);

} // Project
