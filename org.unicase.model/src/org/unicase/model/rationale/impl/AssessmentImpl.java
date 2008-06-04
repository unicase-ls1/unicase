/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.model.impl.ModelElementImpl;

import org.unicase.model.rationale.Assessment;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationalePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assessment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.impl.AssessmentImpl#getProposal <em>Proposal</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.AssessmentImpl#getCriterion <em>Criterion</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.AssessmentImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssessmentImpl extends ModelElementImpl implements Assessment {
	/**
	 * The cached value of the '{@link #getProposal() <em>Proposal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProposal()
	 * @generated
	 * @ordered
	 */
	protected Proposal proposal;

	/**
	 * The cached value of the '{@link #getCriterion() <em>Criterion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCriterion()
	 * @generated
	 * @ordered
	 */
	protected Criterion criterion;

	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssessmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RationalePackage.Literals.ASSESSMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Proposal getProposal() {
		if (proposal != null && proposal.eIsProxy()) {
			InternalEObject oldProposal = (InternalEObject)proposal;
			proposal = (Proposal)eResolveProxy(oldProposal);
			if (proposal != oldProposal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RationalePackage.ASSESSMENT__PROPOSAL, oldProposal, proposal));
			}
		}
		return proposal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Proposal basicGetProposal() {
		return proposal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProposal(Proposal newProposal) {
		Proposal oldProposal = proposal;
		proposal = newProposal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RationalePackage.ASSESSMENT__PROPOSAL, oldProposal, proposal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Criterion getCriterion() {
		if (criterion != null && criterion.eIsProxy()) {
			InternalEObject oldCriterion = (InternalEObject)criterion;
			criterion = (Criterion)eResolveProxy(oldCriterion);
			if (criterion != oldCriterion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RationalePackage.ASSESSMENT__CRITERION, oldCriterion, criterion));
			}
		}
		return criterion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Criterion basicGetCriterion() {
		return criterion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCriterion(Criterion newCriterion) {
		Criterion oldCriterion = criterion;
		criterion = newCriterion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RationalePackage.ASSESSMENT__CRITERION, oldCriterion, criterion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RationalePackage.ASSESSMENT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RationalePackage.ASSESSMENT__PROPOSAL:
				if (resolve) return getProposal();
				return basicGetProposal();
			case RationalePackage.ASSESSMENT__CRITERION:
				if (resolve) return getCriterion();
				return basicGetCriterion();
			case RationalePackage.ASSESSMENT__VALUE:
				return new Integer(getValue());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RationalePackage.ASSESSMENT__PROPOSAL:
				setProposal((Proposal)newValue);
				return;
			case RationalePackage.ASSESSMENT__CRITERION:
				setCriterion((Criterion)newValue);
				return;
			case RationalePackage.ASSESSMENT__VALUE:
				setValue(((Integer)newValue).intValue());
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
			case RationalePackage.ASSESSMENT__PROPOSAL:
				setProposal((Proposal)null);
				return;
			case RationalePackage.ASSESSMENT__CRITERION:
				setCriterion((Criterion)null);
				return;
			case RationalePackage.ASSESSMENT__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case RationalePackage.ASSESSMENT__PROPOSAL:
				return proposal != null;
			case RationalePackage.ASSESSMENT__CRITERION:
				return criterion != null;
			case RationalePackage.ASSESSMENT__VALUE:
				return value != VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //AssessmentImpl
