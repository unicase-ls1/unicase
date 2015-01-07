/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.classes.Association;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Inline Class Operation</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.implementation.operations.InlineClassOperation#getAssociation <em>Association</em>}</li>
 *   <li>{@link org.unicase.implementation.operations.InlineClassOperation#getInlineClass <em>Inline Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.implementation.operations.OperationsPackage#getInlineClassOperation()
 * @model annotation="http://unicase.org/operations description='A class reachable through a single-valued composition is inlined.' label='Inline Class'"
 * @generated
 */
public interface InlineClassOperation extends org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Association</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' containment reference.
	 * @see #setAssociation(org.eclipse.emf.emfstore.internal.common.model.ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getInlineClassOperation_Association()
	 * @model containment="true" required="true"
	 * @generated
	 */
	org.eclipse.emf.emfstore.internal.common.model.ModelElementId getAssociation();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.InlineClassOperation#getAssociation <em>Association</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' containment reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(org.eclipse.emf.emfstore.internal.common.model.ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Inline Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inline Class</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inline Class</em>' containment reference.
	 * @see #setInlineClass(org.eclipse.emf.emfstore.internal.common.model.ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getInlineClassOperation_InlineClass()
	 * @model containment="true" required="true"
	 * @generated
	 */
	org.eclipse.emf.emfstore.internal.common.model.ModelElementId getInlineClass();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.InlineClassOperation#getInlineClass <em>Inline Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inline Class</em>' containment reference.
	 * @see #getInlineClass()
	 * @generated
	 */
	void setInlineClass(org.eclipse.emf.emfstore.internal.common.model.ModelElementId value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getAssociation());'"
	 * @generated
	 */
	Association getAssociation(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Association> getPossibleAssociation(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getInlineClass());'"
	 * @generated
	 */
	org.unicase.model.classes.Class getInlineClass(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getPossibleInlineClass(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='The association must be a composition.'"
	 * @generated
	 */
	boolean validateAssociationComposition(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='The multiplicity of the association must be 1-to-1.'"
	 * @generated
	 */
	boolean validateAssociationMultiplicity(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='The class to be inlined must not have sub classes.'"
	 * @generated
	 */
	boolean validateInlineClassSubClasses(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='The class to be inlined must not be target of another association.'"
	 * @generated
	 */
	boolean validateInlineClassAssociationTarget(org.eclipse.emf.emfstore.internal.common.model.Project project);

} // InlineClassOperation
