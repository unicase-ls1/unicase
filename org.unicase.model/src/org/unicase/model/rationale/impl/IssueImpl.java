/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.impl.AnnotationImpl;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Criterion;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.Proposal;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.model.rationale.Solution;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Issue</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#isChecked <em>Checked</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getContainingWorkpackage <em>Containing Workpackage</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getAssociatedChangePackages <em>Associated Change Packages</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getAssignee <em>Assignee</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getProposals <em>Proposals</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getSolution <em>Solution</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getCriteria <em>Criteria</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getRefiningIssues <em>Refining Issues</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getRefinedIssue <em>Refined Issue</em>}</li>
 *   <li>{@link org.unicase.model.rationale.impl.IssueImpl#getFacilitator <em>Facilitator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IssueImpl extends AnnotationImpl implements Issue {
	/**
	 * The default value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #getAssociatedChangePackages() <em>Associated Change Packages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedChangePackages()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelChangePackage> associatedChangePackages;

	/**
	 * The cached value of the '{@link #getPredecessors() <em>Predecessors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPredecessors()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> predecessors;

	/**
	 * The cached value of the '{@link #getSuccessors() <em>Successors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessors()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> successors;

	/**
	 * The cached value of the '{@link #getAssignee() <em>Assignee</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignee()
	 * @generated
	 * @ordered
	 */
	protected OrgUnit assignee;

	/**
	 * The cached value of the '{@link #getParticipants() <em>Participants</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<OrgUnit> participants;

	/**
	 * The cached value of the '{@link #getProposals() <em>Proposals</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProposals()
	 * @generated
	 * @ordered
	 */
	protected EList<Proposal> proposals;

	/**
	 * The cached value of the '{@link #getSolution() <em>Solution</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSolution()
	 * @generated
	 * @ordered
	 */
	protected Solution solution;

	/**
	 * The cached value of the '{@link #getCriteria() <em>Criteria</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCriteria()
	 * @generated
	 * @ordered
	 */
	protected EList<Criterion> criteria;

	/**
	 * The cached value of the '{@link #getRefiningIssues()
	 * <em>Refining Issues</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRefiningIssues()
	 * @generated
	 * @ordered
	 */
	protected EList<Issue> refiningIssues;

	/**
	 * The cached value of the '{@link #getFacilitator() <em>Facilitator</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFacilitator()
	 * @generated
	 * @ordered
	 */
	protected User facilitator;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IssueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RationalePackage.Literals.ISSUE;
	}

	/**
	 * <!-- begin-user-doc --> Checks if the value returned by
	 * {@link #getSolution()} is not null.
	 * 
	 * @return whether a solution exists or not
	 * @author Florian Schneider <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isChecked() {
		return (getSolution() != null);
	}

	/**
	 * <!-- begin-user-doc -->This method does nothing because there is no
	 * information in the fact alone that the issue is solved.
	 * 
	 * @param newChecked
	 *            says the issue is solved but we ignore it
	 * @author Florian Schneider <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setChecked(boolean newChecked) {
		// do nothing
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage getContainingWorkpackage() {
		if (eContainerFeatureID != RationalePackage.ISSUE__CONTAINING_WORKPACKAGE)
			return null;
		return (WorkPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage basicGetContainingWorkpackage() {
		if (eContainerFeatureID != RationalePackage.ISSUE__CONTAINING_WORKPACKAGE)
			return null;
		return (WorkPackage) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingWorkpackage(
			WorkPackage newContainingWorkpackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainingWorkpackage,
				RationalePackage.ISSUE__CONTAINING_WORKPACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingWorkpackage(WorkPackage newContainingWorkpackage) {
		if (newContainingWorkpackage != eInternalContainer()
				|| (eContainerFeatureID != RationalePackage.ISSUE__CONTAINING_WORKPACKAGE && newContainingWorkpackage != null)) {
			if (EcoreUtil.isAncestor(this, newContainingWorkpackage))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingWorkpackage != null)
				msgs = ((InternalEObject) newContainingWorkpackage)
						.eInverseAdd(this,
								TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
								WorkPackage.class, msgs);
			msgs = basicSetContainingWorkpackage(newContainingWorkpackage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RationalePackage.ISSUE__CONTAINING_WORKPACKAGE,
					newContainingWorkpackage, newContainingWorkpackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelChangePackage> getAssociatedChangePackages() {
		if (associatedChangePackages == null) {
			associatedChangePackages = new EObjectResolvingEList<ModelChangePackage>(
					ModelChangePackage.class, this,
					RationalePackage.ISSUE__ASSOCIATED_CHANGE_PACKAGES);
		}
		return associatedChangePackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getPredecessors() {
		if (predecessors == null) {
			predecessors = new EObjectWithInverseResolvingEList.ManyInverse<WorkItem>(
					WorkItem.class, this, RationalePackage.ISSUE__PREDECESSORS,
					TaskPackage.WORK_ITEM__SUCCESSORS);
		}
		return predecessors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getSuccessors() {
		if (successors == null) {
			successors = new EObjectWithInverseResolvingEList.ManyInverse<WorkItem>(
					WorkItem.class, this, RationalePackage.ISSUE__SUCCESSORS,
					TaskPackage.WORK_ITEM__PREDECESSORS);
		}
		return successors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit getAssignee() {
		if (assignee != null && assignee.eIsProxy()) {
			InternalEObject oldAssignee = (InternalEObject) assignee;
			assignee = (OrgUnit) eResolveProxy(oldAssignee);
			if (assignee != oldAssignee) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RationalePackage.ISSUE__ASSIGNEE, oldAssignee,
							assignee));
			}
		}
		return assignee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit basicGetAssignee() {
		return assignee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignee(OrgUnit newAssignee,
			NotificationChain msgs) {
		OrgUnit oldAssignee = assignee;
		assignee = newAssignee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, RationalePackage.ISSUE__ASSIGNEE,
					oldAssignee, newAssignee);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignee(OrgUnit newAssignee) {
		if (newAssignee != assignee) {
			NotificationChain msgs = null;
			if (assignee != null)
				msgs = ((InternalEObject) assignee).eInverseRemove(this,
						OrganizationPackage.ORG_UNIT__ASSIGNMENTS,
						OrgUnit.class, msgs);
			if (newAssignee != null)
				msgs = ((InternalEObject) newAssignee).eInverseAdd(this,
						OrganizationPackage.ORG_UNIT__ASSIGNMENTS,
						OrgUnit.class, msgs);
			msgs = basicSetAssignee(newAssignee, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RationalePackage.ISSUE__ASSIGNEE, newAssignee, newAssignee));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Proposal> getProposals() {
		if (proposals == null) {
			proposals = new EObjectContainmentWithInverseEList.Resolving<Proposal>(
					Proposal.class, this, RationalePackage.ISSUE__PROPOSALS,
					RationalePackage.PROPOSAL__ISSUE);
		}
		return proposals;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Solution getSolution() {
		if (solution != null && solution.eIsProxy()) {
			InternalEObject oldSolution = (InternalEObject) solution;
			solution = (Solution) eResolveProxy(oldSolution);
			if (solution != oldSolution) {
				InternalEObject newSolution = (InternalEObject) solution;
				NotificationChain msgs = oldSolution.eInverseRemove(this,
						RationalePackage.SOLUTION__ISSUE, Solution.class, null);
				if (newSolution.eInternalContainer() == null) {
					msgs = newSolution.eInverseAdd(this,
							RationalePackage.SOLUTION__ISSUE, Solution.class,
							msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RationalePackage.ISSUE__SOLUTION, oldSolution,
							solution));
			}
		}
		return solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution basicGetSolution() {
		return solution;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSolution(Solution newSolution,
			NotificationChain msgs) {
		Solution oldSolution = solution;
		solution = newSolution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, RationalePackage.ISSUE__SOLUTION,
					oldSolution, newSolution);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolution(Solution newSolution) {
		if (newSolution != solution) {
			NotificationChain msgs = null;
			if (solution != null)
				msgs = ((InternalEObject) solution).eInverseRemove(this,
						RationalePackage.SOLUTION__ISSUE, Solution.class, msgs);
			if (newSolution != null)
				msgs = ((InternalEObject) newSolution).eInverseAdd(this,
						RationalePackage.SOLUTION__ISSUE, Solution.class, msgs);
			msgs = basicSetSolution(newSolution, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RationalePackage.ISSUE__SOLUTION, newSolution, newSolution));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Criterion> getCriteria() {
		if (criteria == null) {
			criteria = new EObjectResolvingEList<Criterion>(Criterion.class,
					this, RationalePackage.ISSUE__CRITERIA);
		}
		return criteria;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Issue> getRefiningIssues() {
		if (refiningIssues == null) {
			refiningIssues = new EObjectContainmentWithInverseEList.Resolving<Issue>(
					Issue.class, this, RationalePackage.ISSUE__REFINING_ISSUES,
					RationalePackage.ISSUE__REFINED_ISSUE);
		}
		return refiningIssues;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Issue getRefinedIssue() {
		if (eContainerFeatureID != RationalePackage.ISSUE__REFINED_ISSUE)
			return null;
		return (Issue) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Issue basicGetRefinedIssue() {
		if (eContainerFeatureID != RationalePackage.ISSUE__REFINED_ISSUE)
			return null;
		return (Issue) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefinedIssue(Issue newRefinedIssue,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRefinedIssue,
				RationalePackage.ISSUE__REFINED_ISSUE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefinedIssue(Issue newRefinedIssue) {
		if (newRefinedIssue != eInternalContainer()
				|| (eContainerFeatureID != RationalePackage.ISSUE__REFINED_ISSUE && newRefinedIssue != null)) {
			if (EcoreUtil.isAncestor(this, newRefinedIssue))
				throw new IllegalArgumentException(
						"Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRefinedIssue != null)
				msgs = ((InternalEObject) newRefinedIssue).eInverseAdd(this,
						RationalePackage.ISSUE__REFINING_ISSUES, Issue.class,
						msgs);
			msgs = basicSetRefinedIssue(newRefinedIssue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RationalePackage.ISSUE__REFINED_ISSUE, newRefinedIssue,
					newRefinedIssue));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User getFacilitator() {
		if (facilitator != null && facilitator.eIsProxy()) {
			InternalEObject oldFacilitator = (InternalEObject) facilitator;
			facilitator = (User) eResolveProxy(oldFacilitator);
			if (facilitator != oldFacilitator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							RationalePackage.ISSUE__FACILITATOR,
							oldFacilitator, facilitator));
			}
		}
		return facilitator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetFacilitator() {
		return facilitator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacilitator(User newFacilitator) {
		User oldFacilitator = facilitator;
		facilitator = newFacilitator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					RationalePackage.ISSUE__FACILITATOR, oldFacilitator,
					facilitator));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrgUnit> getParticipants() {
		if (participants == null) {
			participants = new EObjectWithInverseResolvingEList.ManyInverse<OrgUnit>(
					OrgUnit.class, this, RationalePackage.ISSUE__PARTICIPANTS,
					OrganizationPackage.ORG_UNIT__PARTICIPATIONS);
		}
		return participants;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RationalePackage.ISSUE__CONTAINING_WORKPACKAGE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingWorkpackage((WorkPackage) otherEnd, msgs);
		case RationalePackage.ISSUE__PREDECESSORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPredecessors())
					.basicAdd(otherEnd, msgs);
		case RationalePackage.ISSUE__SUCCESSORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSuccessors())
					.basicAdd(otherEnd, msgs);
		case RationalePackage.ISSUE__ASSIGNEE:
			if (assignee != null)
				msgs = ((InternalEObject) assignee).eInverseRemove(this,
						OrganizationPackage.ORG_UNIT__ASSIGNMENTS,
						OrgUnit.class, msgs);
			return basicSetAssignee((OrgUnit) otherEnd, msgs);
		case RationalePackage.ISSUE__PARTICIPANTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParticipants())
					.basicAdd(otherEnd, msgs);
		case RationalePackage.ISSUE__PROPOSALS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getProposals())
					.basicAdd(otherEnd, msgs);
		case RationalePackage.ISSUE__SOLUTION:
			if (solution != null)
				msgs = ((InternalEObject) solution).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- RationalePackage.ISSUE__SOLUTION, null, msgs);
			return basicSetSolution((Solution) otherEnd, msgs);
		case RationalePackage.ISSUE__REFINING_ISSUES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getRefiningIssues())
					.basicAdd(otherEnd, msgs);
		case RationalePackage.ISSUE__REFINED_ISSUE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetRefinedIssue((Issue) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RationalePackage.ISSUE__CONTAINING_WORKPACKAGE:
			return basicSetContainingWorkpackage(null, msgs);
		case RationalePackage.ISSUE__PREDECESSORS:
			return ((InternalEList<?>) getPredecessors()).basicRemove(otherEnd,
					msgs);
		case RationalePackage.ISSUE__SUCCESSORS:
			return ((InternalEList<?>) getSuccessors()).basicRemove(otherEnd,
					msgs);
		case RationalePackage.ISSUE__ASSIGNEE:
			return basicSetAssignee(null, msgs);
		case RationalePackage.ISSUE__PARTICIPANTS:
			return ((InternalEList<?>) getParticipants()).basicRemove(otherEnd,
					msgs);
		case RationalePackage.ISSUE__PROPOSALS:
			return ((InternalEList<?>) getProposals()).basicRemove(otherEnd,
					msgs);
		case RationalePackage.ISSUE__SOLUTION:
			return basicSetSolution(null, msgs);
		case RationalePackage.ISSUE__REFINING_ISSUES:
			return ((InternalEList<?>) getRefiningIssues()).basicRemove(
					otherEnd, msgs);
		case RationalePackage.ISSUE__REFINED_ISSUE:
			return basicSetRefinedIssue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID) {
		case RationalePackage.ISSUE__CONTAINING_WORKPACKAGE:
			return eInternalContainer().eInverseRemove(this,
					TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
					WorkPackage.class, msgs);
		case RationalePackage.ISSUE__REFINED_ISSUE:
			return eInternalContainer().eInverseRemove(this,
					RationalePackage.ISSUE__REFINING_ISSUES, Issue.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case RationalePackage.ISSUE__CHECKED:
			return isChecked() ? Boolean.TRUE : Boolean.FALSE;
		case RationalePackage.ISSUE__CONTAINING_WORKPACKAGE:
			if (resolve)
				return getContainingWorkpackage();
			return basicGetContainingWorkpackage();
		case RationalePackage.ISSUE__ASSOCIATED_CHANGE_PACKAGES:
			return getAssociatedChangePackages();
		case RationalePackage.ISSUE__PREDECESSORS:
			return getPredecessors();
		case RationalePackage.ISSUE__SUCCESSORS:
			return getSuccessors();
		case RationalePackage.ISSUE__ASSIGNEE:
			if (resolve)
				return getAssignee();
			return basicGetAssignee();
		case RationalePackage.ISSUE__PARTICIPANTS:
			return getParticipants();
		case RationalePackage.ISSUE__PROPOSALS:
			return getProposals();
		case RationalePackage.ISSUE__SOLUTION:
			if (resolve)
				return getSolution();
			return basicGetSolution();
		case RationalePackage.ISSUE__CRITERIA:
			return getCriteria();
		case RationalePackage.ISSUE__REFINING_ISSUES:
			return getRefiningIssues();
		case RationalePackage.ISSUE__REFINED_ISSUE:
			if (resolve)
				return getRefinedIssue();
			return basicGetRefinedIssue();
		case RationalePackage.ISSUE__FACILITATOR:
			if (resolve)
				return getFacilitator();
			return basicGetFacilitator();
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
		case RationalePackage.ISSUE__CHECKED:
			setChecked(((Boolean) newValue).booleanValue());
			return;
		case RationalePackage.ISSUE__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) newValue);
			return;
		case RationalePackage.ISSUE__ASSOCIATED_CHANGE_PACKAGES:
			getAssociatedChangePackages().clear();
			getAssociatedChangePackages().addAll(
					(Collection<? extends ModelChangePackage>) newValue);
			return;
		case RationalePackage.ISSUE__PREDECESSORS:
			getPredecessors().clear();
			getPredecessors().addAll((Collection<? extends WorkItem>) newValue);
			return;
		case RationalePackage.ISSUE__SUCCESSORS:
			getSuccessors().clear();
			getSuccessors().addAll((Collection<? extends WorkItem>) newValue);
			return;
		case RationalePackage.ISSUE__ASSIGNEE:
			setAssignee((OrgUnit) newValue);
			return;
		case RationalePackage.ISSUE__PARTICIPANTS:
			getParticipants().clear();
			getParticipants().addAll((Collection<? extends OrgUnit>) newValue);
			return;
		case RationalePackage.ISSUE__PROPOSALS:
			getProposals().clear();
			getProposals().addAll((Collection<? extends Proposal>) newValue);
			return;
		case RationalePackage.ISSUE__SOLUTION:
			setSolution((Solution) newValue);
			return;
		case RationalePackage.ISSUE__CRITERIA:
			getCriteria().clear();
			getCriteria().addAll((Collection<? extends Criterion>) newValue);
			return;
		case RationalePackage.ISSUE__REFINING_ISSUES:
			getRefiningIssues().clear();
			getRefiningIssues().addAll((Collection<? extends Issue>) newValue);
			return;
		case RationalePackage.ISSUE__REFINED_ISSUE:
			setRefinedIssue((Issue) newValue);
			return;
		case RationalePackage.ISSUE__FACILITATOR:
			setFacilitator((User) newValue);
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
		case RationalePackage.ISSUE__CHECKED:
			setChecked(CHECKED_EDEFAULT);
			return;
		case RationalePackage.ISSUE__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) null);
			return;
		case RationalePackage.ISSUE__ASSOCIATED_CHANGE_PACKAGES:
			getAssociatedChangePackages().clear();
			return;
		case RationalePackage.ISSUE__PREDECESSORS:
			getPredecessors().clear();
			return;
		case RationalePackage.ISSUE__SUCCESSORS:
			getSuccessors().clear();
			return;
		case RationalePackage.ISSUE__ASSIGNEE:
			setAssignee((OrgUnit) null);
			return;
		case RationalePackage.ISSUE__PARTICIPANTS:
			getParticipants().clear();
			return;
		case RationalePackage.ISSUE__PROPOSALS:
			getProposals().clear();
			return;
		case RationalePackage.ISSUE__SOLUTION:
			setSolution((Solution) null);
			return;
		case RationalePackage.ISSUE__CRITERIA:
			getCriteria().clear();
			return;
		case RationalePackage.ISSUE__REFINING_ISSUES:
			getRefiningIssues().clear();
			return;
		case RationalePackage.ISSUE__REFINED_ISSUE:
			setRefinedIssue((Issue) null);
			return;
		case RationalePackage.ISSUE__FACILITATOR:
			setFacilitator((User) null);
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
		case RationalePackage.ISSUE__CHECKED:
			return isChecked() != CHECKED_EDEFAULT;
		case RationalePackage.ISSUE__CONTAINING_WORKPACKAGE:
			return basicGetContainingWorkpackage() != null;
		case RationalePackage.ISSUE__ASSOCIATED_CHANGE_PACKAGES:
			return associatedChangePackages != null
					&& !associatedChangePackages.isEmpty();
		case RationalePackage.ISSUE__PREDECESSORS:
			return predecessors != null && !predecessors.isEmpty();
		case RationalePackage.ISSUE__SUCCESSORS:
			return successors != null && !successors.isEmpty();
		case RationalePackage.ISSUE__ASSIGNEE:
			return assignee != null;
		case RationalePackage.ISSUE__PARTICIPANTS:
			return participants != null && !participants.isEmpty();
		case RationalePackage.ISSUE__PROPOSALS:
			return proposals != null && !proposals.isEmpty();
		case RationalePackage.ISSUE__SOLUTION:
			return solution != null;
		case RationalePackage.ISSUE__CRITERIA:
			return criteria != null && !criteria.isEmpty();
		case RationalePackage.ISSUE__REFINING_ISSUES:
			return refiningIssues != null && !refiningIssues.isEmpty();
		case RationalePackage.ISSUE__REFINED_ISSUE:
			return basicGetRefinedIssue() != null;
		case RationalePackage.ISSUE__FACILITATOR:
			return facilitator != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Checkable.class) {
			switch (derivedFeatureID) {
			case RationalePackage.ISSUE__CHECKED:
				return TaskPackage.CHECKABLE__CHECKED;
			default:
				return -1;
			}
		}
		if (baseClass == WorkItem.class) {
			switch (derivedFeatureID) {
			case RationalePackage.ISSUE__CONTAINING_WORKPACKAGE:
				return TaskPackage.WORK_ITEM__CONTAINING_WORKPACKAGE;
			case RationalePackage.ISSUE__ASSOCIATED_CHANGE_PACKAGES:
				return TaskPackage.WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES;
			case RationalePackage.ISSUE__PREDECESSORS:
				return TaskPackage.WORK_ITEM__PREDECESSORS;
			case RationalePackage.ISSUE__SUCCESSORS:
				return TaskPackage.WORK_ITEM__SUCCESSORS;
			case RationalePackage.ISSUE__ASSIGNEE:
				return TaskPackage.WORK_ITEM__ASSIGNEE;
			case RationalePackage.ISSUE__PARTICIPANTS:
				return TaskPackage.WORK_ITEM__PARTICIPANTS;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Checkable.class) {
			switch (baseFeatureID) {
			case TaskPackage.CHECKABLE__CHECKED:
				return RationalePackage.ISSUE__CHECKED;
			default:
				return -1;
			}
		}
		if (baseClass == WorkItem.class) {
			switch (baseFeatureID) {
			case TaskPackage.WORK_ITEM__CONTAINING_WORKPACKAGE:
				return RationalePackage.ISSUE__CONTAINING_WORKPACKAGE;
			case TaskPackage.WORK_ITEM__ASSOCIATED_CHANGE_PACKAGES:
				return RationalePackage.ISSUE__ASSOCIATED_CHANGE_PACKAGES;
			case TaskPackage.WORK_ITEM__PREDECESSORS:
				return RationalePackage.ISSUE__PREDECESSORS;
			case TaskPackage.WORK_ITEM__SUCCESSORS:
				return RationalePackage.ISSUE__SUCCESSORS;
			case TaskPackage.WORK_ITEM__ASSIGNEE:
				return RationalePackage.ISSUE__ASSIGNEE;
			case TaskPackage.WORK_ITEM__PARTICIPANTS:
				return RationalePackage.ISSUE__PARTICIPANTS;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // IssueImpl
