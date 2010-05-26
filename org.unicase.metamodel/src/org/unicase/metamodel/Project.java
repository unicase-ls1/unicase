/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.metamodel;

import java.util.Map;
import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.util.ProjectChangeObserver;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Project</b></em>'.
 * 
 * @implements IAdaptable <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.metamodel.Project#getModelElements <em>Model Elements</em>}</li>
 *   <li>{@link org.unicase.metamodel.Project#getEobjectsIdMap <em>Eobjects Id Map</em>}</li>
 *   <li>{@link org.unicase.metamodel.Project#getNewEObjectsIdMap <em>New EObjects Id Map</em>}</li>
 *   <li>{@link org.unicase.metamodel.Project#getDeletedEObjectIdMap <em>Deleted EObject Id Map</em>}</li>
 *   <li>{@link org.unicase.metamodel.Project#getDeletedModelElements <em>Deleted Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.metamodel.MetamodelPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject, IAdaptable {

	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.unicase.metamodel.MetamodelPackage#getProject_ModelElements()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	EList<EObject> getModelElements();

	/**
	 * Returns the value of the '<em><b>Eobjects Id Map</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EObject},
	 * and the value is of type {@link org.unicase.metamodel.ModelElementId},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eobjects Id Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eobjects Id Map</em>' map.
	 * @see org.unicase.metamodel.MetamodelPackage#getProject_EobjectsIdMap()
	 * @model mapType="org.unicase.metamodel.EObjectToModelElementIdMap<org.eclipse.emf.ecore.EObject, org.unicase.metamodel.ModelElementId>"
	 * @generated
	 */
	EMap<EObject, ModelElementId> getEobjectsIdMap();

	/**
	 * Returns the value of the '<em><b>New EObjects Id Map</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EObject},
	 * and the value is of type {@link org.unicase.metamodel.ModelElementId},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New EObjects Id Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New EObjects Id Map</em>' map.
	 * @see org.unicase.metamodel.MetamodelPackage#getProject_NewEObjectsIdMap()
	 * @model mapType="org.unicase.metamodel.EObjectToModelElementIdMap<org.eclipse.emf.ecore.EObject, org.unicase.metamodel.ModelElementId>"
	 * @generated
	 */
	EMap<EObject, ModelElementId> getNewEObjectsIdMap();

	/**
	 * Returns the value of the '<em><b>Deleted EObject Id Map</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EObject},
	 * and the value is of type {@link org.unicase.metamodel.ModelElementId},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted EObject Id Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted EObject Id Map</em>' map.
	 * @see org.unicase.metamodel.MetamodelPackage#getProject_DeletedEObjectIdMap()
	 * @model mapType="org.unicase.metamodel.EObjectToModelElementIdMap<org.eclipse.emf.ecore.EObject, org.unicase.metamodel.ModelElementId>" ordered="false"
	 * @generated
	 */
	EMap<EObject, ModelElementId> getDeletedEObjectIdMap();

	/**
	 * Returns the value of the '<em><b>Deleted Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted Model Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted Model Elements</em>' containment reference list.
	 * @see org.unicase.metamodel.MetamodelPackage#getProject_DeletedModelElements()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	EList<EObject> getDeletedModelElements();

	/**
	 * Retrieve a list of ALL model elements of a certain type in project.
	 * 
	 * @param <T> a subtype of model element
	 * @param modelElementClass the eclass (must be a subtype of model element)
	 * @param list a list of model elements, can be emtpy, but must be of the same type as the modelElementClass
	 *            indicates.
	 * @param subclasses whether to also include all subclasses of the given EClass in the list
	 * @return a list of model elements of the given type
	 * @generated NOT
	 */
	<T extends EObject> EList<T> getAllModelElementsbyClass(EClass modelElementClass, EList<T> list, Boolean subclasses);

	/**
	 * Retrieve a list of ALL model elements of a certain type in project.
	 * 
	 * @param <T> a subtype of model element
	 * @param modelElementClass the eclass (must be a subtype of model element)
	 * @param list a list of model elements, can be emtpy, but must be of the same type as the modelElementClass
	 *            indicates.
	 * @return a list of model elements of the given type
	 * @generated NOT
	 */
	<T extends EObject> EList<T> getAllModelElementsbyClass(EClass modelElementClass, EList<T> list);

	/**
	 * Retrieve a list of model elements of a certain type in project that are directly contained in the project.
	 * 
	 * @param <T> a subtype of model element
	 * @param modelElementClass the eclass (must be a subtype of model element)
	 * @param list a list of model elements, can be emtpy, but must be of the same type as the modelElementClass
	 *            indicates.
	 * @return a list of model elements of the given type
	 * @generated NOT
	 */
	<T extends EObject> EList<T> getModelElementsByClass(EClass modelElementClass, EList<T> list);

	/**
	 * Returns whether the project contains a model element with the same id.
	 * 
	 * @param modelElement the id
	 * @return true if the project contains such a model element
	 */
	boolean contains(EObject modelElement);

	/**
	 * Returns whether the project contains the exact same instance of the model element.
	 * 
	 * @param modelElement the model element
	 * @return true if the project contains the instance
	 */
	boolean containsInstance(EObject modelElement);

	/**
	 * Get the model element with the given id from the project.
	 * 
	 * @param modelElementId the model element id
	 * @return the model element or null if it is not in the project
	 */
	EObject getModelElement(ModelElementId modelElementId);

	/**
	 * Add an observer to the project. Will be notified on project changes. See {@link ProjectChangeObserver}.
	 * 
	 * @param projectChangeObserver the change observer
	 */
	void addProjectChangeObserver(ProjectChangeObserver projectChangeObserver);

	/**
	 * Remove an observer to the project. See {@link ProjectChangeObserver}.
	 * 
	 * @param projectChangeObserver the change observer
	 */
	void removeProjectChangeObserver(ProjectChangeObserver projectChangeObserver);

	/**
	 * Delete an element from the Project including all its containments and cross references.
	 * 
	 * @param modelElementImpl the model element to delete
	 */
	void deleteModelElement(EObject modelElementImpl);

	/**
	 * Add a model element to the project.
	 * 
	 * @param newModelElement the new model element
	 */
	void addModelElement(EObject newModelElement);

	/**
	 * Returns whether the project contains a model element with the same id.
	 * 
	 * @param modelElementId the id
	 * @return true if the project contains such a model element
	 */
	boolean contains(ModelElementId modelElementId);

	/**
	 * Get all model elements of a project.
	 * 
	 * @return a list of model elements
	 */
	EList<EObject> getAllModelElements();

	// TODO: EMFPlainObjectTransition: NEW method, should be removed and replaced by getAllModelElementsyClass, if possible
	EList<EObject> getAllModelElementsAsList();

	/**
	 * Deletes a project by notifying all project change observers about the deletion.
	 */
	void delete();

	/**
	 * Retrieve the ModelELement wrapper for an EObject.
	 * 
	 * @param eObject the eObject
	 * @return the wrapper
	 */
	ModelElementId getModelElementId(EObject eObject);

	/**
	 * Add a model element to the project including the existing wrappers of the model element and its siblings.
	 * 
	 * @param newModelElement the new model element
	 * @param wrappers the wrappers
	 */
	void addModelElement(EObject newModelElement, Map<EObject, ModelElementId> map); //(EObject newModelElement, Collection<ModelElementId> ids);
} // Project
