/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.unicase.model.impl.ModelElementImpl;

import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.Solution;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.impl.SolutionImpl#getUnderlyingProposals <em>Underlying Proposals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SolutionImpl extends ModelElementImpl implements Solution {
	/**
	 * The cached value of the '{@link #getUnderlyingProposals() <em>Underlying Proposals</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnderlyingProposals()
	 * @generated
	 * @ordered
	 */
	protected EList<Proposal> underlyingProposals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RationalePackage.Literals.SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Proposal> getUnderlyingProposals() {
		if (underlyingProposals == null) {
			underlyingProposals = new EObjectResolvingEList<Proposal>(Proposal.class, this, RationalePackage.SOLUTION__UNDERLYING_PROPOSALS);
		}
		return underlyingProposals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RationalePackage.SOLUTION__UNDERLYING_PROPOSALS:
				return getUnderlyingProposals();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RationalePackage.SOLUTION__UNDERLYING_PROPOSALS:
				getUnderlyingProposals().clear();
				getUnderlyingProposals().addAll((Collection<? extends Proposal>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case RationalePackage.SOLUTION__UNDERLYING_PROPOSALS:
				getUnderlyingProposals().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case RationalePackage.SOLUTION__UNDERLYING_PROPOSALS:
				return underlyingProposals != null && !underlyingProposals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SolutionImpl
