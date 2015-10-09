/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.task.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.impl.AnnotationImpl;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.release.AbstractRelease;
import org.unicase.model.release.ReleasePackage;
import org.unicase.model.task.Milestone;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Milestone</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getContainingWorkpackage <em>Containing Workpackage</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getAssignee <em>Assignee</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getReviewer <em>Reviewer</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getDueDate <em>Due Date</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getEstimate <em>Estimate</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getEffort <em>Effort</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getIncludingReleases <em>Including Releases</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.MilestoneImpl#getContainedModelElements <em>Contained Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MilestoneImpl extends AnnotationImpl implements Milestone {
	/**
	 * The cached value of the '{@link #getPredecessors() <em>Predecessors</em>}' reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getAssignee()
	 * @generated
	 * @ordered
	 */
	protected OrgUnit assignee;
	/**
	 * The cached value of the '{@link #getReviewer() <em>Reviewer</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getReviewer()
	 * @generated
	 * @ordered
	 */
	protected User reviewer;
	/**
	 * The cached value of the '{@link #getParticipants() <em>Participants</em>}' reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<OrgUnit> participants;
	/**
	 * The default value of the '{@link #getDueDate() <em>Due Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDueDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DUE_DATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDueDate() <em>Due Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDueDate()
	 * @generated
	 * @ordered
	 */
	protected Date dueDate = DUE_DATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getEstimate() <em>Estimate</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getEstimate()
	 * @generated
	 * @ordered
	 */
	protected static final int ESTIMATE_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getEstimate() <em>Estimate</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getEstimate()
	 * @generated
	 * @ordered
	 */
	protected int estimate = ESTIMATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getEffort() <em>Effort</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getEffort()
	 * @generated
	 * @ordered
	 */
	protected static final int EFFORT_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getEffort() <em>Effort</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getEffort()
	 * @generated
	 * @ordered
	 */
	protected int effort = EFFORT_EDEFAULT;
	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final int PRIORITY_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected int priority = PRIORITY_EDEFAULT;
	/**
	 * The default value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isResolved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isResolved()
	 * @generated
	 * @ordered
	 */
	protected boolean resolved = RESOLVED_EDEFAULT;
	/**
	 * The cached value of the '{@link #getIncludingReleases() <em>Including Releases</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getIncludingReleases()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRelease> includingReleases;
	/**
	 * The cached value of the '{@link #getContainedModelElements() <em>Contained Model Elements</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getContainedModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<UnicaseModelElement> containedModelElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MilestoneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TaskPackage.Literals.MILESTONE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage getContainingWorkpackage() {
		if (eContainerFeatureID() != TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE)
			return null;
		return (WorkPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage basicGetContainingWorkpackage() {
		if (eContainerFeatureID() != TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE)
			return null;
		return (WorkPackage) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingWorkpackage(
			WorkPackage newContainingWorkpackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainingWorkpackage,
				TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingWorkpackage(WorkPackage newContainingWorkpackage) {
		if (newContainingWorkpackage != eInternalContainer()
				|| (eContainerFeatureID() != TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE && newContainingWorkpackage != null)) {
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
					TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE,
					newContainingWorkpackage, newContainingWorkpackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getPredecessors() {
		if (predecessors == null) {
			predecessors = new EObjectWithInverseResolvingEList.ManyInverse<WorkItem>(
					WorkItem.class, this, TaskPackage.MILESTONE__PREDECESSORS,
					TaskPackage.WORK_ITEM__SUCCESSORS);
		}
		return predecessors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getSuccessors() {
		if (successors == null) {
			successors = new EObjectWithInverseResolvingEList.ManyInverse<WorkItem>(
					WorkItem.class, this, TaskPackage.MILESTONE__SUCCESSORS,
					TaskPackage.WORK_ITEM__PREDECESSORS);
		}
		return successors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit getAssignee() {
		if (assignee != null && assignee.eIsProxy()) {
			InternalEObject oldAssignee = (InternalEObject) assignee;
			assignee = (OrgUnit) eResolveProxy(oldAssignee);
			if (assignee != oldAssignee) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							TaskPackage.MILESTONE__ASSIGNEE, oldAssignee,
							assignee));
			}
		}
		return assignee;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit basicGetAssignee() {
		return assignee;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignee(OrgUnit newAssignee,
			NotificationChain msgs) {
		OrgUnit oldAssignee = assignee;
		assignee = newAssignee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, TaskPackage.MILESTONE__ASSIGNEE,
					oldAssignee, newAssignee);
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
					TaskPackage.MILESTONE__ASSIGNEE, newAssignee, newAssignee));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User getReviewer() {
		if (reviewer != null && reviewer.eIsProxy()) {
			InternalEObject oldReviewer = (InternalEObject) reviewer;
			reviewer = (User) eResolveProxy(oldReviewer);
			if (reviewer != oldReviewer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							TaskPackage.MILESTONE__REVIEWER, oldReviewer,
							reviewer));
			}
		}
		return reviewer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public User basicGetReviewer() {
		return reviewer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReviewer(User newReviewer,
			NotificationChain msgs) {
		User oldReviewer = reviewer;
		reviewer = newReviewer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, TaskPackage.MILESTONE__REVIEWER,
					oldReviewer, newReviewer);
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
	public void setReviewer(User newReviewer) {
		if (newReviewer != reviewer) {
			NotificationChain msgs = null;
			if (reviewer != null)
				msgs = ((InternalEObject) reviewer).eInverseRemove(this,
						OrganizationPackage.USER__WORK_ITEMS_TO_REVIEW,
						User.class, msgs);
			if (newReviewer != null)
				msgs = ((InternalEObject) newReviewer).eInverseAdd(this,
						OrganizationPackage.USER__WORK_ITEMS_TO_REVIEW,
						User.class, msgs);
			msgs = basicSetReviewer(newReviewer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MILESTONE__REVIEWER, newReviewer, newReviewer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrgUnit> getParticipants() {
		if (participants == null) {
			participants = new EObjectWithInverseResolvingEList.ManyInverse<OrgUnit>(
					OrgUnit.class, this, TaskPackage.MILESTONE__PARTICIPANTS,
					OrganizationPackage.ORG_UNIT__PARTICIPATIONS);
		}
		return participants;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDueDate(Date newDueDate) {
		Date oldDueDate = dueDate;
		dueDate = newDueDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MILESTONE__DUE_DATE, oldDueDate, dueDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getEstimate() {
		return estimate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEstimate(int newEstimate) {
		int oldEstimate = estimate;
		estimate = newEstimate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MILESTONE__ESTIMATE, oldEstimate, estimate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getEffort() {
		return effort;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEffort(int newEffort) {
		int oldEffort = effort;
		effort = newEffort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MILESTONE__EFFORT, oldEffort, effort));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(int newPriority) {
		int oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MILESTONE__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResolved() {
		return resolved;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolved(boolean newResolved) {
		boolean oldResolved = resolved;
		resolved = newResolved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.MILESTONE__RESOLVED, oldResolved, resolved));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRelease> getIncludingReleases() {
		if (includingReleases == null) {
			includingReleases = new EObjectWithInverseResolvingEList.ManyInverse<AbstractRelease>(
					AbstractRelease.class, this,
					TaskPackage.MILESTONE__INCLUDING_RELEASES,
					ReleasePackage.ABSTRACT_RELEASE__INCLUDED_WORK_ITEMS);
		}
		return includingReleases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnicaseModelElement> getContainedModelElements() {
		if (containedModelElements == null) {
			containedModelElements = new EObjectResolvingEList<UnicaseModelElement>(
					UnicaseModelElement.class, this,
					TaskPackage.MILESTONE__CONTAINED_MODEL_ELEMENTS);
		}
		return containedModelElements;
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
		case TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingWorkpackage((WorkPackage) otherEnd, msgs);
		case TaskPackage.MILESTONE__PREDECESSORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPredecessors())
					.basicAdd(otherEnd, msgs);
		case TaskPackage.MILESTONE__SUCCESSORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSuccessors())
					.basicAdd(otherEnd, msgs);
		case TaskPackage.MILESTONE__ASSIGNEE:
			if (assignee != null)
				msgs = ((InternalEObject) assignee).eInverseRemove(this,
						OrganizationPackage.ORG_UNIT__ASSIGNMENTS,
						OrgUnit.class, msgs);
			return basicSetAssignee((OrgUnit) otherEnd, msgs);
		case TaskPackage.MILESTONE__REVIEWER:
			if (reviewer != null)
				msgs = ((InternalEObject) reviewer).eInverseRemove(this,
						OrganizationPackage.USER__WORK_ITEMS_TO_REVIEW,
						User.class, msgs);
			return basicSetReviewer((User) otherEnd, msgs);
		case TaskPackage.MILESTONE__PARTICIPANTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParticipants())
					.basicAdd(otherEnd, msgs);
		case TaskPackage.MILESTONE__INCLUDING_RELEASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getIncludingReleases())
					.basicAdd(otherEnd, msgs);
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
		case TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE:
			return basicSetContainingWorkpackage(null, msgs);
		case TaskPackage.MILESTONE__PREDECESSORS:
			return ((InternalEList<?>) getPredecessors()).basicRemove(otherEnd,
					msgs);
		case TaskPackage.MILESTONE__SUCCESSORS:
			return ((InternalEList<?>) getSuccessors()).basicRemove(otherEnd,
					msgs);
		case TaskPackage.MILESTONE__ASSIGNEE:
			return basicSetAssignee(null, msgs);
		case TaskPackage.MILESTONE__REVIEWER:
			return basicSetReviewer(null, msgs);
		case TaskPackage.MILESTONE__PARTICIPANTS:
			return ((InternalEList<?>) getParticipants()).basicRemove(otherEnd,
					msgs);
		case TaskPackage.MILESTONE__INCLUDING_RELEASES:
			return ((InternalEList<?>) getIncludingReleases()).basicRemove(
					otherEnd, msgs);
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
		switch (eContainerFeatureID()) {
		case TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE:
			return eInternalContainer().eInverseRemove(this,
					TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
					WorkPackage.class, msgs);
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
		case TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE:
			if (resolve)
				return getContainingWorkpackage();
			return basicGetContainingWorkpackage();
		case TaskPackage.MILESTONE__PREDECESSORS:
			return getPredecessors();
		case TaskPackage.MILESTONE__SUCCESSORS:
			return getSuccessors();
		case TaskPackage.MILESTONE__ASSIGNEE:
			if (resolve)
				return getAssignee();
			return basicGetAssignee();
		case TaskPackage.MILESTONE__REVIEWER:
			if (resolve)
				return getReviewer();
			return basicGetReviewer();
		case TaskPackage.MILESTONE__PARTICIPANTS:
			return getParticipants();
		case TaskPackage.MILESTONE__DUE_DATE:
			return getDueDate();
		case TaskPackage.MILESTONE__ESTIMATE:
			return getEstimate();
		case TaskPackage.MILESTONE__EFFORT:
			return getEffort();
		case TaskPackage.MILESTONE__PRIORITY:
			return getPriority();
		case TaskPackage.MILESTONE__RESOLVED:
			return isResolved();
		case TaskPackage.MILESTONE__INCLUDING_RELEASES:
			return getIncludingReleases();
		case TaskPackage.MILESTONE__CONTAINED_MODEL_ELEMENTS:
			return getContainedModelElements();
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
		case TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) newValue);
			return;
		case TaskPackage.MILESTONE__PREDECESSORS:
			getPredecessors().clear();
			getPredecessors().addAll((Collection<? extends WorkItem>) newValue);
			return;
		case TaskPackage.MILESTONE__SUCCESSORS:
			getSuccessors().clear();
			getSuccessors().addAll((Collection<? extends WorkItem>) newValue);
			return;
		case TaskPackage.MILESTONE__ASSIGNEE:
			setAssignee((OrgUnit) newValue);
			return;
		case TaskPackage.MILESTONE__REVIEWER:
			setReviewer((User) newValue);
			return;
		case TaskPackage.MILESTONE__PARTICIPANTS:
			getParticipants().clear();
			getParticipants().addAll((Collection<? extends OrgUnit>) newValue);
			return;
		case TaskPackage.MILESTONE__DUE_DATE:
			setDueDate((Date) newValue);
			return;
		case TaskPackage.MILESTONE__ESTIMATE:
			setEstimate((Integer) newValue);
			return;
		case TaskPackage.MILESTONE__EFFORT:
			setEffort((Integer) newValue);
			return;
		case TaskPackage.MILESTONE__PRIORITY:
			setPriority((Integer) newValue);
			return;
		case TaskPackage.MILESTONE__RESOLVED:
			setResolved((Boolean) newValue);
			return;
		case TaskPackage.MILESTONE__INCLUDING_RELEASES:
			getIncludingReleases().clear();
			getIncludingReleases().addAll(
					(Collection<? extends AbstractRelease>) newValue);
			return;
		case TaskPackage.MILESTONE__CONTAINED_MODEL_ELEMENTS:
			getContainedModelElements().clear();
			getContainedModelElements().addAll(
					(Collection<? extends UnicaseModelElement>) newValue);
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
		case TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) null);
			return;
		case TaskPackage.MILESTONE__PREDECESSORS:
			getPredecessors().clear();
			return;
		case TaskPackage.MILESTONE__SUCCESSORS:
			getSuccessors().clear();
			return;
		case TaskPackage.MILESTONE__ASSIGNEE:
			setAssignee((OrgUnit) null);
			return;
		case TaskPackage.MILESTONE__REVIEWER:
			setReviewer((User) null);
			return;
		case TaskPackage.MILESTONE__PARTICIPANTS:
			getParticipants().clear();
			return;
		case TaskPackage.MILESTONE__DUE_DATE:
			setDueDate(DUE_DATE_EDEFAULT);
			return;
		case TaskPackage.MILESTONE__ESTIMATE:
			setEstimate(ESTIMATE_EDEFAULT);
			return;
		case TaskPackage.MILESTONE__EFFORT:
			setEffort(EFFORT_EDEFAULT);
			return;
		case TaskPackage.MILESTONE__PRIORITY:
			setPriority(PRIORITY_EDEFAULT);
			return;
		case TaskPackage.MILESTONE__RESOLVED:
			setResolved(RESOLVED_EDEFAULT);
			return;
		case TaskPackage.MILESTONE__INCLUDING_RELEASES:
			getIncludingReleases().clear();
			return;
		case TaskPackage.MILESTONE__CONTAINED_MODEL_ELEMENTS:
			getContainedModelElements().clear();
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
		case TaskPackage.MILESTONE__CONTAINING_WORKPACKAGE:
			return basicGetContainingWorkpackage() != null;
		case TaskPackage.MILESTONE__PREDECESSORS:
			return predecessors != null && !predecessors.isEmpty();
		case TaskPackage.MILESTONE__SUCCESSORS:
			return successors != null && !successors.isEmpty();
		case TaskPackage.MILESTONE__ASSIGNEE:
			return assignee != null;
		case TaskPackage.MILESTONE__REVIEWER:
			return reviewer != null;
		case TaskPackage.MILESTONE__PARTICIPANTS:
			return participants != null && !participants.isEmpty();
		case TaskPackage.MILESTONE__DUE_DATE:
			return DUE_DATE_EDEFAULT == null ? dueDate != null
					: !DUE_DATE_EDEFAULT.equals(dueDate);
		case TaskPackage.MILESTONE__ESTIMATE:
			return estimate != ESTIMATE_EDEFAULT;
		case TaskPackage.MILESTONE__EFFORT:
			return effort != EFFORT_EDEFAULT;
		case TaskPackage.MILESTONE__PRIORITY:
			return priority != PRIORITY_EDEFAULT;
		case TaskPackage.MILESTONE__RESOLVED:
			return resolved != RESOLVED_EDEFAULT;
		case TaskPackage.MILESTONE__INCLUDING_RELEASES:
			return includingReleases != null && !includingReleases.isEmpty();
		case TaskPackage.MILESTONE__CONTAINED_MODEL_ELEMENTS:
			return containedModelElements != null
					&& !containedModelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (dueDate: ");
		result.append(dueDate);
		result.append(", estimate: ");
		result.append(estimate);
		result.append(", effort: ");
		result.append(effort);
		result.append(", priority: ");
		result.append(priority);
		result.append(", resolved: ");
		result.append(resolved);
		result.append(')');
		return result.toString();
	}

} // MilestoneImpl
