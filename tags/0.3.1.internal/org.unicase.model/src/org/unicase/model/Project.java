/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.util.ProjectChangeObserver;

/*
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Project</b></em>'.
 * @implements IAdaptable <!-- end-user-doc --> <p> The following features are supported: <ul> <li>{@link
 * org.unicase.model.Project#getModelElements <em>Model Elements</em>}</li> </ul> </p>
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
	 * If the meaning of the '<em>Model Elements</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.unicase.model.ModelPackage#getProject_ModelElements()
	 * @model containment="true" resolveProxies="true" keys="identifier" ordered="false"
	 * @generated
	 */
	EList<ModelElement> getModelElements();

	/**
	 * <!-- begin-user-doc --> Add a Model Element to the project as direct content. This is only necessary if the model
	 * element is not contained in any other model element. <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addModelElement(ModelElement modelElement);

	/**
	 * <!-- begin-user-doc --> Return all model elements in the project including model elements transitively contained
	 * by project. <!--end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<ModelElement> getAllModelElements();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model ordered="false" listMany="true"
	 * @generated
	 */
	<T extends ModelElement> EList<T> getAllModelElementsbyClass(EClass modelElementClass, EList<T> list);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model ordered="false" listMany="true"
	 * @generated
	 */
	<T extends ModelElement> EList<T> getModelElementsByClass(EClass modelElementClass, EList<T> list);

	/**
	 * <!-- begin-user-doc --> Retrieve a list of model elements of a certain type in project.
	 * 
	 * @param <T> a subtype of model element
	 * @param modelElementClass the eclass (must be a subtype of model element)
	 * @param list a list of model elements, can be emtpy, but must be of the same type as the modelElementClass
	 *            indicates.
	 * @param subclasses whether to also include all subclasses of the given EClass in the list
	 * @return a list of model elements of the given type <!-- end-user-doc -->
	 * @model ordered="false" listMany="true" subclasses ="false"
	 * @generated NOT
	 */
	<T extends ModelElement> EList<T> getAllModelElementsbyClass(EClass modelElementClass, EList<T> list,
		Boolean subclasses);

	/**
	 * <!-- begin-user-doc --> Returns whether the project contains a model element with the same id. <!-- end-user-doc
	 * -->
	 * 
	 * @model
	 * @generated
	 */
	boolean contains(ModelElement modelElement);

	/**
	 * Returns whether the project contains a model element with the same id.
	 * 
	 * @param modelElementId the id
	 * @return true if the project contains such a model element
	 */
	boolean contains(ModelElementId modelElementId);

	/**
	 * Returns whether the project contains the exact same instance of the model element.
	 * 
	 * @param modelElement the model element
	 * @return true if the project contains the instance
	 */
	boolean containsInstance(ModelElement modelElement);

	/**
	 * Get the model element with the given id from the project.
	 * 
	 * @param modelElementId the model element id
	 * @return the model element or null if it is not in the project
	 */
	ModelElement getModelElement(ModelElementId modelElementId);

	/**
	 * Add an observer to the project. Will be notified on project changes. See {@link ProjectChangeObserver}.
	 * 
	 * @param projectChangeObserver
	 */
	void addProjectChangeObserver(ProjectChangeObserver projectChangeObserver);

	/**
	 * Remove an observer to the project. See {@link ProjectChangeObserver}.
	 * 
	 * @param projectChangeObserver
	 */
	void removeProjectChangeObserver(ProjectChangeObserver projectChangeObserver);
} // Project
