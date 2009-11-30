/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.MergingProposal;
import org.unicase.model.change.ModelChangePackage;
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
public class MergingProposalImpl extends ProposalImpl implements MergingProposal {
	/**
	 * The cached value of the '{@link #getConflictingProposals() <em>Conflicting Proposals</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConflictingProposals()
	 * @generated
	 * @ordered
	 */
	protected EList<MergingProposal> conflictingProposals;

	/**
	 * The cached value of the '{@link #getPendingChanges() <em>Pending Changes</em>}' reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getPendingChanges()
	 * @generated
	 * @ordered
	 */
	protected ModelChangePackage pendingChanges;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MergingProposalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangePackage.Literals.MERGING_PROPOSAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<MergingProposal> getConflictingProposals() {
		if (conflictingProposals == null) {
			conflictingProposals = new EObjectResolvingEList<MergingProposal>(MergingProposal.class, this,
				ChangePackage.MERGING_PROPOSAL__CONFLICTING_PROPOSALS);
		}
		return conflictingProposals;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelChangePackage getPendingChanges() {
		if (pendingChanges != null && pendingChanges.eIsProxy()) {
			InternalEObject oldPendingChanges = (InternalEObject) pendingChanges;
			pendingChanges = (ModelChangePackage) eResolveProxy(oldPendingChanges);
			if (pendingChanges != oldPendingChanges) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						ChangePackage.MERGING_PROPOSAL__PENDING_CHANGES, oldPendingChanges, pendingChanges));
			}
		}
		return pendingChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelChangePackage basicGetPendingChanges() {
		return pendingChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPendingChanges(ModelChangePackage newPendingChanges) {
		ModelChangePackage oldPendingChanges = pendingChanges;
		pendingChanges = newPendingChanges;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangePackage.MERGING_PROPOSAL__PENDING_CHANGES,
				oldPendingChanges, pendingChanges));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__CONFLICTING_PROPOSALS:
			return getConflictingProposals();
		case ChangePackage.MERGING_PROPOSAL__PENDING_CHANGES:
			if (resolve)
				return getPendingChanges();
			return basicGetPendingChanges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__CONFLICTING_PROPOSALS:
			getConflictingProposals().clear();
			getConflictingProposals().addAll((Collection<? extends MergingProposal>) newValue);
			return;
		case ChangePackage.MERGING_PROPOSAL__PENDING_CHANGES:
			setPendingChanges((ModelChangePackage) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__CONFLICTING_PROPOSALS:
			getConflictingProposals().clear();
			return;
		case ChangePackage.MERGING_PROPOSAL__PENDING_CHANGES:
			setPendingChanges((ModelChangePackage) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ChangePackage.MERGING_PROPOSAL__CONFLICTING_PROPOSALS:
			return conflictingProposals != null && !conflictingProposals.isEmpty();
		case ChangePackage.MERGING_PROPOSAL__PENDING_CHANGES:
			return pendingChanges != null;
		}
		return super.eIsSet(featureID);
	}

} // MergingProposalImpl
