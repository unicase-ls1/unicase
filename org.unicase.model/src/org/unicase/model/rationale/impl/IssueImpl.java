/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.impl.ModelElementImpl;

import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.Solution;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Issue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getProposals <em>Proposals</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getSolution <em>Solution</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getCriteria <em>Criteria</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getRefiningIssues <em>Refining Issues</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getRefinedIssue <em>Refined Issue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IssueImpl extends ModelElementImpl implements Issue {
	/**
	 * The cached value of the '{@link #getProposals() <em>Proposals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProposals()
	 * @generated
	 * @ordered
	 */
	protected EList<Proposal> proposals;

	/**
	 * The cached value of the '{@link #getSolution() <em>Solution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolution()
	 * @generated
	 * @ordered
	 */
	protected Solution solution;

	/**
	 * The cached value of the '{@link #getCriteria() <em>Criteria</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCriteria()
	 * @generated
	 * @ordered
	 */
	protected EList<Criterion> criteria;

	/**
	 * The cached value of the '{@link #getRefiningIssues() <em>Refining Issues</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefiningIssues()
	 * @generated
	 * @ordered
	 */
	protected EList<Issue> refiningIssues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IssueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RationalePackage.Literals.ISSUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Proposal> getProposals() {
		if (proposals == null) {
			proposals = new EObjectContainmentEList<Proposal>(Proposal.class, this, RationalePackage.ISSUE__PROPOSALS);
		}
		return proposals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution getSolution() {
		return solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSolution(Solution newSolution, NotificationChain msgs) {
		Solution oldSolution = solution;
		solution = newSolution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RationalePackage.ISSUE__SOLUTION, oldSolution, newSolution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolution(Solution newSolution) {
		if (newSolution != solution) {
			NotificationChain msgs = null;
			if (solution != null)
				msgs = ((InternalEObject)solution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RationalePackage.ISSUE__SOLUTION, null, msgs);
			if (newSolution != null)
				msgs = ((InternalEObject)newSolution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RationalePackage.ISSUE__SOLUTION, null, msgs);
			msgs = basicSetSolution(newSolution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RationalePackage.ISSUE__SOLUTION, newSolution, newSolution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Criterion> getCriteria() {
		if (criteria == null) {
			criteria = new EObjectResolvingEList<Criterion>(Criterion.class, this, RationalePackage.ISSUE__CRITERIA);
		}
		return criteria;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Issue> getRefiningIssues() {
		if (refiningIssues == null) {
			refiningIssues = new EObjectContainmentWithInverseEList<Issue>(Issue.class, this, RationalePackage.ISSUE__REFINING_ISSUES, RationalePackage.ISSUE__REFINED_ISSUE);
		}
		return refiningIssues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Issue getRefinedIssue() {
		if (eContainerFeatureID != RationalePackage.ISSUE__REFINED_ISSUE) return null;
		return (Issue)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedIssue(Issue newRefinedIssue, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRefinedIssue, RationalePackage.ISSUE__REFINED_ISSUE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedIssue(Issue newRefinedIssue) {
		if (newRefinedIssue != eInternalContainer() || (eContainerFeatureID != RationalePackage.ISSUE__REFINED_ISSUE && newRefinedIssue != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedIssue))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedIssue != null)
				msgs = ((InternalEObject)newRefinedIssue).eInverseAdd(this, RationalePackage.ISSUE__REFINING_ISSUES, Issue.class, msgs);
			msgs = basicSetRefinedIssue(newRefinedIssue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RationalePackage.ISSUE__REFINED_ISSUE, newRefinedIssue, newRefinedIssue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RationalePackage.ISSUE__REFINING_ISSUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRefiningIssues()).basicAdd(otherEnd, msgs);
			case RationalePackage.ISSUE__REFINED_ISSUE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRefinedIssue((Issue)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RationalePackage.ISSUE__PROPOSALS:
				return ((InternalEList<?>)getProposals()).basicRemove(otherEnd, msgs);
			case RationalePackage.ISSUE__SOLUTION:
				return basicSetSolution(null, msgs);
			case RationalePackage.ISSUE__REFINING_ISSUES:
				return ((InternalEList<?>)getRefiningIssues()).basicRemove(otherEnd, msgs);
			case RationalePackage.ISSUE__REFINED_ISSUE:
				return basicSetRefinedIssue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case RationalePackage.ISSUE__REFINED_ISSUE:
				return eInternalContainer().eInverseRemove(this, RationalePackage.ISSUE__REFINING_ISSUES, Issue.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RationalePackage.ISSUE__PROPOSALS:
				return getProposals();
			case RationalePackage.ISSUE__SOLUTION:
				return getSolution();
			case RationalePackage.ISSUE__CRITERIA:
				return getCriteria();
			case RationalePackage.ISSUE__REFINING_ISSUES:
				return getRefiningIssues();
			case RationalePackage.ISSUE__REFINED_ISSUE:
				return getRefinedIssue();
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
			case RationalePackage.ISSUE__PROPOSALS:
				getProposals().clear();
				getProposals().addAll((Collection<? extends Proposal>)newValue);
				return;
			case RationalePackage.ISSUE__SOLUTION:
				setSolution((Solution)newValue);
				return;
			case RationalePackage.ISSUE__CRITERIA:
				getCriteria().clear();
				getCriteria().addAll((Collection<? extends Criterion>)newValue);
				return;
			case RationalePackage.ISSUE__REFINING_ISSUES:
				getRefiningIssues().clear();
				getRefiningIssues().addAll((Collection<? extends Issue>)newValue);
				return;
			case RationalePackage.ISSUE__REFINED_ISSUE:
				setRefinedIssue((Issue)newValue);
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
			case RationalePackage.ISSUE__PROPOSALS:
				getProposals().clear();
				return;
			case RationalePackage.ISSUE__SOLUTION:
				setSolution((Solution)null);
				return;
			case RationalePackage.ISSUE__CRITERIA:
				getCriteria().clear();
				return;
			case RationalePackage.ISSUE__REFINING_ISSUES:
				getRefiningIssues().clear();
				return;
			case RationalePackage.ISSUE__REFINED_ISSUE:
				setRefinedIssue((Issue)null);
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
			case RationalePackage.ISSUE__PROPOSALS:
				return proposals != null && !proposals.isEmpty();
			case RationalePackage.ISSUE__SOLUTION:
				return solution != null;
			case RationalePackage.ISSUE__CRITERIA:
				return criteria != null && !criteria.isEmpty();
			case RationalePackage.ISSUE__REFINING_ISSUES:
				return refiningIssues != null && !refiningIssues.isEmpty();
			case RationalePackage.ISSUE__REFINED_ISSUE:
				return getRefinedIssue() != null;
		}
		return super.eIsSet(featureID);
	}

} //IssueImpl
