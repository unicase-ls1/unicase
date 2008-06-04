/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.impl.ModelElementImpl;

import org.unicase.model.rationale.Assessment;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationalePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proposal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.impl.ProposalImpl#getAssessments <em>Assessments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProposalImpl extends ModelElementImpl implements Proposal {
	/**
	 * The cached value of the '{@link #getAssessments() <em>Assessments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssessments()
	 * @generated
	 * @ordered
	 */
	protected EList<Assessment> assessments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProposalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RationalePackage.Literals.PROPOSAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assessment> getAssessments() {
		if (assessments == null) {
			assessments = new EObjectContainmentEList<Assessment>(Assessment.class, this, RationalePackage.PROPOSAL__ASSESSMENTS);
		}
		return assessments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RationalePackage.PROPOSAL__ASSESSMENTS:
				return ((InternalEList<?>)getAssessments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RationalePackage.PROPOSAL__ASSESSMENTS:
				return getAssessments();
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
			case RationalePackage.PROPOSAL__ASSESSMENTS:
				getAssessments().clear();
				getAssessments().addAll((Collection<? extends Assessment>)newValue);
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
			case RationalePackage.PROPOSAL__ASSESSMENTS:
				getAssessments().clear();
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
			case RationalePackage.PROPOSAL__ASSESSMENTS:
				return assessments != null && !assessments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProposalImpl
