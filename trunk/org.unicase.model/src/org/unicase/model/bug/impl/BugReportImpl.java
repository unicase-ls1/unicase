/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.bug.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.BugResolution;
import org.unicase.model.bug.BugStatus;
import org.unicase.model.bug.Severity;
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.impl.AnnotationImpl;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.requirement.Step;
import org.unicase.model.task.Assignable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getContainingWorkpackage <em>Containing Workpackage</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getAssociatedChangePackages <em>Associated Change Packages</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getAssignee <em>Assignee</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getStepsToReproduce <em>Steps To Reproduce</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getAssignedTo <em>Assigned To</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getResolution <em>Resolution</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getSeverity <em>Severity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BugReportImpl extends AnnotationImpl implements BugReport {
	/**
	 * The cached value of the '{@link #getAssociatedChangePackages() <em>Associated Change Packages</em>}' reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getAssociatedChangePackages()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelChangePackage> associatedChangePackages;

	/**
	 * The cached value of the '{@link #getPredecessors() <em>Predecessors</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPredecessors()
	 * @generated
	 * @ordered
	 */
	protected WorkItem predecessors;

	/**
	 * The cached value of the '{@link #getSuccessors() <em>Successors</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSuccessors()
	 * @generated
	 * @ordered
	 */
	protected WorkItem successors;

	/**
	 * The cached value of the '{@link #getStepsToReproduce() <em>Steps To Reproduce</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepsToReproduce()
	 * @generated
	 * @ordered
	 */
	protected EList<Step> stepsToReproduce;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final BugStatus STATUS_EDEFAULT = BugStatus.NEW;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected BugStatus status = STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssignedTo() <em>Assigned To</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAssignedTo()
	 * @generated
	 * @ordered
	 */
	protected OrgUnit assignedTo;

	/**
	 * The cached value of the '{@link #getResolution() <em>Resolution</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResolution()
	 * @generated
	 * @ordered
	 */
	protected BugResolution resolution;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final Severity SEVERITY_EDEFAULT = Severity.FEATURE;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected Severity severity = SEVERITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BugReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BugPackage.Literals.BUG_REPORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage getContainingWorkpackage() {
		if (eContainerFeatureID != BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE)
			return null;
		return (WorkPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingWorkpackage(
			WorkPackage newContainingWorkpackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainingWorkpackage,
				BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingWorkpackage(WorkPackage newContainingWorkpackage) {
		if (newContainingWorkpackage != eInternalContainer()
				|| (eContainerFeatureID != BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE && newContainingWorkpackage != null)) {
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
					BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE,
					newContainingWorkpackage, newContainingWorkpackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelChangePackage> getAssociatedChangePackages() {
		if (associatedChangePackages == null) {
			associatedChangePackages = new EObjectResolvingEList<ModelChangePackage>(
					ModelChangePackage.class, this,
					BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES);
		}
		return associatedChangePackages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkItem getPredecessors() {
		if (predecessors != null && predecessors.eIsProxy()) {
			InternalEObject oldPredecessors = (InternalEObject) predecessors;
			predecessors = (WorkItem) eResolveProxy(oldPredecessors);
			if (predecessors != oldPredecessors) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BugPackage.BUG_REPORT__PREDECESSORS,
							oldPredecessors, predecessors));
			}
		}
		return predecessors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkItem basicGetPredecessors() {
		return predecessors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPredecessors(WorkItem newPredecessors,
			NotificationChain msgs) {
		WorkItem oldPredecessors = predecessors;
		predecessors = newPredecessors;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BugPackage.BUG_REPORT__PREDECESSORS,
					oldPredecessors, newPredecessors);
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
	public void setPredecessors(WorkItem newPredecessors) {
		if (newPredecessors != predecessors) {
			NotificationChain msgs = null;
			if (predecessors != null)
				msgs = ((InternalEObject) predecessors)
						.eInverseRemove(this,
								TaskPackage.WORK_ITEM__SUCCESSORS,
								WorkItem.class, msgs);
			if (newPredecessors != null)
				msgs = ((InternalEObject) newPredecessors)
						.eInverseAdd(this, TaskPackage.WORK_ITEM__SUCCESSORS,
								WorkItem.class, msgs);
			msgs = basicSetPredecessors(newPredecessors, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BugPackage.BUG_REPORT__PREDECESSORS, newPredecessors,
					newPredecessors));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkItem getSuccessors() {
		if (successors != null && successors.eIsProxy()) {
			InternalEObject oldSuccessors = (InternalEObject) successors;
			successors = (WorkItem) eResolveProxy(oldSuccessors);
			if (successors != oldSuccessors) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BugPackage.BUG_REPORT__SUCCESSORS, oldSuccessors,
							successors));
			}
		}
		return successors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkItem basicGetSuccessors() {
		return successors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuccessors(WorkItem newSuccessors,
			NotificationChain msgs) {
		WorkItem oldSuccessors = successors;
		successors = newSuccessors;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BugPackage.BUG_REPORT__SUCCESSORS,
					oldSuccessors, newSuccessors);
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
	public void setSuccessors(WorkItem newSuccessors) {
		if (newSuccessors != successors) {
			NotificationChain msgs = null;
			if (successors != null)
				msgs = ((InternalEObject) successors).eInverseRemove(this,
						TaskPackage.WORK_ITEM__PREDECESSORS, WorkItem.class,
						msgs);
			if (newSuccessors != null)
				msgs = ((InternalEObject) newSuccessors).eInverseAdd(this,
						TaskPackage.WORK_ITEM__PREDECESSORS, WorkItem.class,
						msgs);
			msgs = basicSetSuccessors(newSuccessors, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BugPackage.BUG_REPORT__SUCCESSORS, newSuccessors,
					newSuccessors));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit getAssignee() {
		OrgUnit assignee = basicGetAssignee();
		return assignee != null && assignee.eIsProxy()
				? (OrgUnit) eResolveProxy((InternalEObject) assignee)
				: assignee;
	}

	/**
	 * <!-- begin-user-doc --> Delegates to {@link #basicGetAssignedTo()}.
	 * 
	 * @return the {@link OrgUnit} returned by {@link #basicGetAssignedTo()}
	 * @author Florian Schneider
	 * 
	 *         <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public OrgUnit basicGetAssignee() {
		return basicGetAssignedTo();
	}

	/**
	 * <!-- begin-user-doc --> Delegates to {@link #setAssignedTo(OrgUnit)}.
	 * 
	 * @param newAssignee
	 *            the new organizational unit that shall be assigned to resolve
	 *            this bug. <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setAssignee(OrgUnit newAssignee) {
		setAssignedTo(newAssignee);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Step> getStepsToReproduce() {
		if (stepsToReproduce == null) {
			stepsToReproduce = new EObjectResolvingEList<Step>(Step.class,
					this, BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE);
		}
		return stepsToReproduce;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BugStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(BugStatus newStatus) {
		BugStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BugPackage.BUG_REPORT__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit getAssignedTo() {
		if (assignedTo != null && assignedTo.eIsProxy()) {
			InternalEObject oldAssignedTo = (InternalEObject) assignedTo;
			assignedTo = (OrgUnit) eResolveProxy(oldAssignedTo);
			if (assignedTo != oldAssignedTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BugPackage.BUG_REPORT__ASSIGNED_TO, oldAssignedTo,
							assignedTo));
			}
		}
		return assignedTo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit basicGetAssignedTo() {
		return assignedTo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignedTo(OrgUnit newAssignedTo) {
		OrgUnit oldAssignedTo = assignedTo;
		assignedTo = newAssignedTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BugPackage.BUG_REPORT__ASSIGNED_TO, oldAssignedTo,
					assignedTo));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BugResolution getResolution() {
		if (resolution != null && resolution.eIsProxy()) {
			InternalEObject oldResolution = (InternalEObject) resolution;
			resolution = (BugResolution) eResolveProxy(oldResolution);
			if (resolution != oldResolution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BugPackage.BUG_REPORT__RESOLUTION, oldResolution,
							resolution));
			}
		}
		return resolution;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BugResolution basicGetResolution() {
		return resolution;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolution(BugResolution newResolution) {
		BugResolution oldResolution = resolution;
		resolution = newResolution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BugPackage.BUG_REPORT__RESOLUTION, oldResolution,
					resolution));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(Severity newSeverity) {
		Severity oldSeverity = severity;
		severity = newSeverity == null ? SEVERITY_EDEFAULT : newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BugPackage.BUG_REPORT__SEVERITY, oldSeverity, severity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainingWorkpackage((WorkPackage) otherEnd,
						msgs);
			case BugPackage.BUG_REPORT__PREDECESSORS :
				if (predecessors != null)
					msgs = ((InternalEObject) predecessors).eInverseRemove(
							this, TaskPackage.WORK_ITEM__SUCCESSORS,
							WorkItem.class, msgs);
				return basicSetPredecessors((WorkItem) otherEnd, msgs);
			case BugPackage.BUG_REPORT__SUCCESSORS :
				if (successors != null)
					msgs = ((InternalEObject) successors).eInverseRemove(this,
							TaskPackage.WORK_ITEM__PREDECESSORS,
							WorkItem.class, msgs);
				return basicSetSuccessors((WorkItem) otherEnd, msgs);
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
			case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE :
				return basicSetContainingWorkpackage(null, msgs);
			case BugPackage.BUG_REPORT__PREDECESSORS :
				return basicSetPredecessors(null, msgs);
			case BugPackage.BUG_REPORT__SUCCESSORS :
				return basicSetSuccessors(null, msgs);
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
			case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE :
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
			case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE :
				return getContainingWorkpackage();
			case BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES :
				return getAssociatedChangePackages();
			case BugPackage.BUG_REPORT__PREDECESSORS :
				if (resolve)
					return getPredecessors();
				return basicGetPredecessors();
			case BugPackage.BUG_REPORT__SUCCESSORS :
				if (resolve)
					return getSuccessors();
				return basicGetSuccessors();
			case BugPackage.BUG_REPORT__ASSIGNEE :
				if (resolve)
					return getAssignee();
				return basicGetAssignee();
			case BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE :
				return getStepsToReproduce();
			case BugPackage.BUG_REPORT__STATUS :
				return getStatus();
			case BugPackage.BUG_REPORT__ASSIGNED_TO :
				if (resolve)
					return getAssignedTo();
				return basicGetAssignedTo();
			case BugPackage.BUG_REPORT__RESOLUTION :
				if (resolve)
					return getResolution();
				return basicGetResolution();
			case BugPackage.BUG_REPORT__SEVERITY :
				return getSeverity();
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
			case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE :
				setContainingWorkpackage((WorkPackage) newValue);
				return;
			case BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES :
				getAssociatedChangePackages().clear();
				getAssociatedChangePackages().addAll(
						(Collection<? extends ModelChangePackage>) newValue);
				return;
			case BugPackage.BUG_REPORT__PREDECESSORS :
				setPredecessors((WorkItem) newValue);
				return;
			case BugPackage.BUG_REPORT__SUCCESSORS :
				setSuccessors((WorkItem) newValue);
				return;
			case BugPackage.BUG_REPORT__ASSIGNEE :
				setAssignee((OrgUnit) newValue);
				return;
			case BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE :
				getStepsToReproduce().clear();
				getStepsToReproduce().addAll(
						(Collection<? extends Step>) newValue);
				return;
			case BugPackage.BUG_REPORT__STATUS :
				setStatus((BugStatus) newValue);
				return;
			case BugPackage.BUG_REPORT__ASSIGNED_TO :
				setAssignedTo((OrgUnit) newValue);
				return;
			case BugPackage.BUG_REPORT__RESOLUTION :
				setResolution((BugResolution) newValue);
				return;
			case BugPackage.BUG_REPORT__SEVERITY :
				setSeverity((Severity) newValue);
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
			case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE :
				setContainingWorkpackage((WorkPackage) null);
				return;
			case BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES :
				getAssociatedChangePackages().clear();
				return;
			case BugPackage.BUG_REPORT__PREDECESSORS :
				setPredecessors((WorkItem) null);
				return;
			case BugPackage.BUG_REPORT__SUCCESSORS :
				setSuccessors((WorkItem) null);
				return;
			case BugPackage.BUG_REPORT__ASSIGNEE :
				setAssignee((OrgUnit) null);
				return;
			case BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE :
				getStepsToReproduce().clear();
				return;
			case BugPackage.BUG_REPORT__STATUS :
				setStatus(STATUS_EDEFAULT);
				return;
			case BugPackage.BUG_REPORT__ASSIGNED_TO :
				setAssignedTo((OrgUnit) null);
				return;
			case BugPackage.BUG_REPORT__RESOLUTION :
				setResolution((BugResolution) null);
				return;
			case BugPackage.BUG_REPORT__SEVERITY :
				setSeverity(SEVERITY_EDEFAULT);
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
			case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE :
				return getContainingWorkpackage() != null;
			case BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES :
				return associatedChangePackages != null
						&& !associatedChangePackages.isEmpty();
			case BugPackage.BUG_REPORT__PREDECESSORS :
				return predecessors != null;
			case BugPackage.BUG_REPORT__SUCCESSORS :
				return successors != null;
			case BugPackage.BUG_REPORT__ASSIGNEE :
				return basicGetAssignee() != null;
			case BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE :
				return stepsToReproduce != null && !stepsToReproduce.isEmpty();
			case BugPackage.BUG_REPORT__STATUS :
				return status != STATUS_EDEFAULT;
			case BugPackage.BUG_REPORT__ASSIGNED_TO :
				return assignedTo != null;
			case BugPackage.BUG_REPORT__RESOLUTION :
				return resolution != null;
			case BugPackage.BUG_REPORT__SEVERITY :
				return severity != SEVERITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Assignable.class) {
			switch (derivedFeatureID) {
				case BugPackage.BUG_REPORT__ASSIGNEE :
					return TaskPackage.ASSIGNABLE__ASSIGNEE;
				default :
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
		if (baseClass == Assignable.class) {
			switch (baseFeatureID) {
				case TaskPackage.ASSIGNABLE__ASSIGNEE :
					return BugPackage.BUG_REPORT__ASSIGNEE;
				default :
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (Status: ");
		result.append(status);
		result.append(", severity: ");
		result.append(severity);
		result.append(')');
		return result.toString();
	}

} // BugReportImpl
