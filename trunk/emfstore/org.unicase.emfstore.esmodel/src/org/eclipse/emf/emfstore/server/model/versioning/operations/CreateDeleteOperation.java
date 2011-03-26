/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning.operations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Create Delete Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#isDelete <em>Delete</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getSubOperations <em>Sub Operations</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getEObjectToIdMap <em>EObject To Id Map</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getCreateDeleteOperation()
 * @model
 * @generated
 */
public interface CreateDeleteOperation extends AbstractOperation {
	/**
	 * Returns the value of the '<em><b>Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete</em>' attribute.
	 * @see #setDelete(boolean)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getCreateDeleteOperation_Delete()
	 * @model
	 * @generated
	 */
	boolean isDelete();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#isDelete <em>Delete</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delete</em>' attribute.
	 * @see #isDelete()
	 * @generated
	 */
	void setDelete(boolean value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' containment reference.
	 * @see #setModelElement(EObject)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getCreateDeleteOperation_ModelElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EObject getModelElement();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.operations.CreateDeleteOperation#getModelElement <em>Model Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' containment reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Sub Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.server.model.versioning.operations.ReferenceOperation}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Sub Operations</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Operations</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getCreateDeleteOperation_SubOperations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ReferenceOperation> getSubOperations();

	/**
	 * Returns the value of the '<em><b>EObject To Id Map</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EObject},
	 * and the value is of type {@link org.eclipse.emf.emfstore.common.model.ModelElementId},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EObject To Id Map</em>' map isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EObject To Id Map</em>' map.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.operations.OperationsPackage#getCreateDeleteOperation_EObjectToIdMap()
	 * @model mapType="org.eclipse.emf.emfstore.server.model.versioning.operations.EObjectToModelElementIdMap<org.eclipse.emf.ecore.EObject, org.eclipse.emf.emfstore.common.model.ModelElementId>"
	 * @generated
	 */
	EMap<EObject, ModelElementId> getEObjectToIdMap();

	/**
	 * Get the id of the previous parent of the deleted element. Returns null if the deleted element did not have a
	 * parent at the time of deletion or the parent cannot be determined anymore since it has also been removed from the
	 * given project.
	 * 
	 * @param project the current project (needed to derive the parent)
	 * @return the element id
	 * @generated NOT
	 */
	ModelElementId getParentofDeletedElement(Project project);

	// /**
	// * Get all deleted model elements.
	// *
	// * @return a set of the ids of the deleted elements.
	// */
	// Set<ModelElementId> getAllDeletedModelElements();
} // CreateDeleteOperation
