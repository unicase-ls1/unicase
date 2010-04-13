/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementEObjectWrapper;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Create Delete Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#isDelete <em>Delete</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getModelElement <em>Model Element
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getSubOperations <em>Sub
 * Operations</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getModelElementWrappers <em>Model
 * Element Wrappers</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCreateDeleteOperation()
 * @model
 * @generated
 */
public interface CreateDeleteOperation extends AbstractOperation {
	/**
	 * Returns the value of the '<em><b>Delete</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Delete</em>' attribute.
	 * @see #setDelete(boolean)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCreateDeleteOperation_Delete()
	 * @model
	 * @generated
	 */
	boolean isDelete();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#isDelete
	 * <em>Delete</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Delete</em>' attribute.
	 * @see #isDelete()
	 * @generated
	 */
	void setDelete(boolean value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Element</em>' containment reference.
	 * @see #setModelElement(EObject)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCreateDeleteOperation_ModelElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EObject getModelElement();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getModelElement
	 * <em>Model Element</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Model Element</em>' containment reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Sub Operations</b></em>' containment reference list. The list contents are of
	 * type {@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Operations</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Operations</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCreateDeleteOperation_SubOperations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ReferenceOperation> getSubOperations();

	/**
	 * Returns the value of the '<em><b>Model Element Wrappers</b></em>' containment reference list. The list contents
	 * are of type {@link org.unicase.metamodel.ModelElementEObjectWrapper}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Wrappers</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Element Wrappers</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCreateDeleteOperation_ModelElementWrappers()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<ModelElementEObjectWrapper> getModelElementWrappers();

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

	/**
	 * Get all deleted model elements.
	 * 
	 * @return a set of the ids of the deleted elements.
	 */
	Set<ModelElementId> getAllDeletedModelElements();

	/**
	 * Retrieve the ModelElement of the given id in this operation. Returns null if element is not in this operation
	 * 
	 * @param modelElementId the model element id
	 * @return the model element or null
	 */
	ModelElement getModelElement(ModelElementId modelElementId);
} // CreateDeleteOperation
