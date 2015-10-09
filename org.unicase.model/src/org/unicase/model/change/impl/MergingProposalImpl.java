/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.MergingProposal;
import org.unicase.model.rationale.impl.ProposalImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Merging Proposal</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.model.change.impl.MergingProposalImpl#getConflictingProposals <em>Conflicting Proposals</em>}</li>
 * <li>{@link org.unicase.model.change.impl.MergingProposalImpl#getPendingChanges <em>Pending Changes</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MergingProposalImpl extends ProposalImpl implements
		MergingProposal {
	/**
	 * The cached value of the '{@link #getPendingOperations() <em>Pending Operations</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPendingOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractOperation> pendingOperations;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MergingProposalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangePackage.Literals.MERGING_PROPOSAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractOperation> getPendingOperations() {
		if (pendingOperations == null) {
			pendingOperations = new EObjectContainmentEList.Resolving<AbstractOperation>(
					AbstractOperation.class, this,
					ChangePackage.MERGING_PROPOSAL__PENDING_OPERATIONS);
		}
		return pendingOperations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__PENDING_OPERATIONS:
			return ((InternalEList<?>) getPendingOperations()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__PENDING_OPERATIONS:
			return getPendingOperations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__PENDING_OPERATIONS:
			getPendingOperations().clear();
			getPendingOperations().addAll(
					(Collection<? extends AbstractOperation>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__PENDING_OPERATIONS:
			getPendingOperations().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__PENDING_OPERATIONS:
			return pendingOperations != null && !pendingOperations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // MergingProposalImpl
