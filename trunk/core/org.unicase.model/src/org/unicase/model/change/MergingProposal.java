/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.rationale.Proposal;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Merging Proposal</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.change.MergingProposal#getConflictingProposals <em>Conflicting Proposals</em>}</li>
 * <li>{@link org.unicase.model.change.MergingProposal#getPendingChanges <em>Pending Changes</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.change.ChangePackage#getMergingProposal()
 * @model
 * @generated
 */
public interface MergingProposal extends Proposal {
	/**
	 * Returns the value of the '<em><b>Conflicting Proposals</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.change.MergingProposal}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conflicting Proposals</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Conflicting Proposals</em>' reference list.
	 * @see org.unicase.model.change.ChangePackage#getMergingProposal_ConflictingProposals()
	 * @model
	 * @generated
	 */
	EList<MergingProposal> getConflictingProposals();

	/**
	 * Returns the value of the '<em><b>Pending Changes</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pending Changes</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Pending Changes</em>' reference.
	 * @see #setPendingChanges(ModelChangePackage)
	 * @see org.unicase.model.change.ChangePackage#getMergingProposal_PendingChanges()
	 * @model
	 * @generated
	 */
	ModelChangePackage getPendingChanges();

	/**
	 * Sets the value of the '{@link org.unicase.model.change.MergingProposal#getPendingChanges
	 * <em>Pending Changes</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Pending Changes</em>' reference.
	 * @see #getPendingChanges()
	 * @generated
	 */
	void setPendingChanges(ModelChangePackage value);

} // MergingProposal
