/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pull Up Operation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.implementation.operations.PullUpOperation#getSuperClass <em>Super Class</em>}</li>
 * <li>{@link org.unicase.implementation.operations.PullUpOperation#getAttributes <em>Attributes</em>}</li>
 * <li>{@link org.unicase.implementation.operations.PullUpOperation#getOutgoingAssociations <em>Outgoing Associations
 * </em>}</li>
 * <li>{@link org.unicase.implementation.operations.PullUpOperation#getIncomingAssociations <em>Incoming Associations
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.implementation.operations.OperationsPackage#getPullUpOperation()
 * @model annotation=
 *        "http://unicase.org/operations description='Attributes and associations are pulled up into a common super class.' label='Pull Up Attributes and Associations'"
 * @generated
 */
public interface PullUpOperation extends org.eclipse.emf.emfstore.internal.server.model.versioning.operations.semantic.SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' containment reference.
	 * @see #setSuperClass(org.eclipse.emf.emfstore.internal.common.model.ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getPullUpOperation_SuperClass()
	 * @model containment="true" required="true"
	 * @generated
	 */
	org.eclipse.emf.emfstore.internal.common.model.ModelElementId getSuperClass();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.PullUpOperation#getSuperClass <em>Super Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' containment reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(org.eclipse.emf.emfstore.internal.common.model.ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.internal.common.model.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getPullUpOperation_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> getAttributes();

	/**
	 * Returns the value of the '<em><b>Outgoing Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.internal.common.model.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Associations</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Associations</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getPullUpOperation_OutgoingAssociations()
	 * @model containment="true"
	 * @generated
	 */
	EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> getOutgoingAssociations();

	/**
	 * Returns the value of the '<em><b>Incoming Associations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.emfstore.internal.common.model.ModelElementId}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Associations</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Associations</em>' containment reference list.
	 * @see org.unicase.implementation.operations.OperationsPackage#getPullUpOperation_IncomingAssociations()
	 * @model containment="true"
	 * @generated
	 */
	EList<org.eclipse.emf.emfstore.internal.common.model.ModelElementId> getIncomingAssociations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getSuperClass());'"
	 * @generated
	 */
	org.unicase.model.classes.Class getSuperClass(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getPossibleSuperClasses(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getAttributes());'"
	 * @generated
	 */
	EList<Attribute> getAttributes(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Attribute> getPossibleAttributes(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getOutgoingAssociations());'"
	 * @generated
	 */
	EList<Association> getOutgoingAssociations(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Association> getPossibleOutgoingAssociations(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElements(project, getIncomingAssociations());'"
	 * @generated
	 */
	EList<Association> getIncomingAssociations(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Association> getPossibleIncomingAssociations(org.eclipse.emf.emfstore.internal.common.model.Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='At least one attribute or association must be pulled up.'"
	 * @generated
	 */
	boolean validateAttributesAssociations(org.eclipse.emf.emfstore.internal.common.model.Project project);

} // PullUpOperation
