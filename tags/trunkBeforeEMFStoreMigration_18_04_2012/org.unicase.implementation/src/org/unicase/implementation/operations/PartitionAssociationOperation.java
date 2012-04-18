/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations;

import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.classes.Association;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Partition Association Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.implementation.operations.PartitionAssociationOperation#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.implementation.operations.OperationsPackage#getPartitionAssociationOperation()
 * @model annotation="http://unicase.org/operations description='An association to an abstract class is partitioned into seperate associations for every subclass.' label='Partition Association'"
 * @generated
 */
public interface PartitionAssociationOperation extends SemanticCompositeOperation {
	/**
	 * Returns the value of the '<em><b>Association</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Association</em>' containment reference.
	 * @see #setAssociation(ModelElementId)
	 * @see org.unicase.implementation.operations.OperationsPackage#getPartitionAssociationOperation_Association()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ModelElementId getAssociation();

	/**
	 * Sets the value of the '{@link org.unicase.implementation.operations.PartitionAssociationOperation#getAssociation
	 * <em>Association</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Association</em>' containment reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(ModelElementId value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return OperationHelper.getElement(project, getAssociation());'"
	 * @generated
	 */
	Association getAssociation(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true" annotation=
	 *        "http://unicase.org/operations description='The type of the reference must be abstract and must have sub classes.'"
	 * @generated
	 */
	boolean validateAssociationTarget(Project project);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model required="true"
	 *        annotation="http://unicase.org/operations description='The reference must be multi-valued.'"
	 * @generated
	 */
	boolean validateAssociationMultiplicity(Project project);

} // PartitionAssociationOperation
