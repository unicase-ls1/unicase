/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
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
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.impl.AnnotationImpl;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.ActivityType;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Action Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getContainingWorkpackage <em>Containing Workpackage</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getAssociatedChangePackages <em>Associated Change Packages</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getAssignee <em>Assignee</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getDueDate <em>Due Date</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#isChecked <em>Checked</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#isDone <em>Done</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getEstimate <em>Estimate</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionItemImpl extends AnnotationImpl implements ActionItem {
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
	 * The cached value of the '{@link #getPredecessors() <em>Predecessors</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPredecessors()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> predecessors;

	/**
	 * The cached value of the '{@link #getSuccessors() <em>Successors</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<OrgUnit> participants;

	/**
	 * The default value of the '{@link #getDueDate() <em>Due Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDueDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DUE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDueDate() <em>Due Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDueDate()
	 * @generated
	 * @ordered
	 */
	protected Date dueDate = DUE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isChecked() <em>Checked</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isChecked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECKED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isDone() <em>Done</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDone()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DONE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDone() <em>Done</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDone()
	 * @generated
	 * @ordered
	 */
	protected boolean done = DONE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEstimate() <em>Estimate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEstimate()
	 * @generated
	 * @ordered
	 */
	protected static final int ESTIMATE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEstimate() <em>Estimate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getEstimate()
	 * @generated
	 * @ordered
	 */
	protected int estimate = ESTIMATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getActivity() <em>Activity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected static final ActivityType ACTIVITY_EDEFAULT = ActivityType.NONE;

	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected ActivityType activity = ACTIVITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TaskPackage.Literals.ACTION_ITEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage getContainingWorkpackage() {
		if (eContainerFeatureID != TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE)
			return null;
		return (WorkPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage basicGetContainingWorkpackage() {
		if (eContainerFeatureID != TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE)
			return null;
		return (WorkPackage) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainingWorkpackage(WorkPackage newContainingWorkpackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContainingWorkpackage, TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingWorkpackage(WorkPackage newContainingWorkpackage) {
		if (newContainingWorkpackage != eInternalContainer()
				|| (eContainerFeatureID != TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE && newContainingWorkpackage != null)) {
			if (EcoreUtil.isAncestor(this, newContainingWorkpackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainingWorkpackage != null)
				msgs = ((InternalEObject) newContainingWorkpackage).eInverseAdd(this,
						TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS, WorkPackage.class, msgs);
			msgs = basicSetContainingWorkpackage(newContainingWorkpackage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE,
					newContainingWorkpackage, newContainingWorkpackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelChangePackage> getAssociatedChangePackages() {
		if (associatedChangePackages == null) {
			associatedChangePackages = new EObjectResolvingEList<ModelChangePackage>(ModelChangePackage.class, this,
					TaskPackage.ACTION_ITEM__ASSOCIATED_CHANGE_PACKAGES);
		}
		return associatedChangePackages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getPredecessors() {
		if (predecessors == null) {
			predecessors = new EObjectWithInverseResolvingEList.ManyInverse<WorkItem>(WorkItem.class, this,
					TaskPackage.ACTION_ITEM__PREDECESSORS, TaskPackage.WORK_ITEM__SUCCESSORS);
		}
		return predecessors;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getSuccessors() {
		if (successors == null) {
			successors = new EObjectWithInverseResolvingEList.ManyInverse<WorkItem>(WorkItem.class, this,
					TaskPackage.ACTION_ITEM__SUCCESSORS, TaskPackage.WORK_ITEM__PREDECESSORS);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TaskPackage.ACTION_ITEM__ASSIGNEE, oldAssignee,
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

	// begin of custom code
	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return the Done state of the ActionItem. <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isChecked() {
		return isDone();
	}

	/**
	 * <!-- begin-user-doc --> Sets the Done state of the ActionItem.
	 * 
	 * @param newChecked
	 *            the new state <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setChecked(boolean newChecked) {
		setDone(newChecked);
	}

	/**
	 * <!-- begin-user-doc -->
	 * .
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignee(OrgUnit newAssignee, NotificationChain msgs) {
		OrgUnit oldAssignee = assignee;
		assignee = newAssignee;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TaskPackage.ACTION_ITEM__ASSIGNEE,
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
				msgs = ((InternalEObject) assignee).eInverseRemove(this, OrganizationPackage.ORG_UNIT__ASSIGNMENTS,
						OrgUnit.class, msgs);
			if (newAssignee != null)
				msgs = ((InternalEObject) newAssignee).eInverseAdd(this, OrganizationPackage.ORG_UNIT__ASSIGNMENTS,
						OrgUnit.class, msgs);
			msgs = basicSetAssignee(newAssignee, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskPackage.ACTION_ITEM__ASSIGNEE, newAssignee, newAssignee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OrgUnit> getParticipants() {
		if (participants == null) {
			participants = new EObjectWithInverseResolvingEList.ManyInverse<OrgUnit>(OrgUnit.class, this,
					TaskPackage.ACTION_ITEM__PARTICIPANTS, OrganizationPackage.ORG_UNIT__PARTICIPATIONS);
		}
		return participants;
	}

	// end of custom code

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
			eNotify(new ENotificationImpl(this, Notification.SET, TaskPackage.ACTION_ITEM__DUE_DATE, oldDueDate, dueDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDone(boolean newDone) {
		boolean oldDone = done;
		done = newDone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskPackage.ACTION_ITEM__DONE, oldDone, done));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TaskPackage.ACTION_ITEM__ESTIMATE, oldEstimate, estimate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityType getActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivity(ActivityType newActivity) {
		ActivityType oldActivity = activity;
		activity = newActivity == null ? ACTIVITY_EDEFAULT : newActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TaskPackage.ACTION_ITEM__ACTIVITY, oldActivity, activity));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingWorkpackage((WorkPackage) otherEnd, msgs);
		case TaskPackage.ACTION_ITEM__PREDECESSORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPredecessors()).basicAdd(otherEnd, msgs);
		case TaskPackage.ACTION_ITEM__SUCCESSORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSuccessors()).basicAdd(otherEnd, msgs);
		case TaskPackage.ACTION_ITEM__ASSIGNEE:
			if (assignee != null)
				msgs = ((InternalEObject) assignee).eInverseRemove(this, OrganizationPackage.ORG_UNIT__ASSIGNMENTS,
						OrgUnit.class, msgs);
			return basicSetAssignee((OrgUnit) otherEnd, msgs);
		case TaskPackage.ACTION_ITEM__PARTICIPANTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParticipants()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE:
			return basicSetContainingWorkpackage(null, msgs);
		case TaskPackage.ACTION_ITEM__PREDECESSORS:
			return ((InternalEList<?>) getPredecessors()).basicRemove(otherEnd, msgs);
		case TaskPackage.ACTION_ITEM__SUCCESSORS:
			return ((InternalEList<?>) getSuccessors()).basicRemove(otherEnd, msgs);
		case TaskPackage.ACTION_ITEM__ASSIGNEE:
			return basicSetAssignee(null, msgs);
		case TaskPackage.ACTION_ITEM__PARTICIPANTS:
			return ((InternalEList<?>) getParticipants()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
		case TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE:
			return eInternalContainer().eInverseRemove(this, TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS, WorkPackage.class,
					msgs);
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
		case TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE:
			if (resolve)
				return getContainingWorkpackage();
			return basicGetContainingWorkpackage();
		case TaskPackage.ACTION_ITEM__ASSOCIATED_CHANGE_PACKAGES:
			return getAssociatedChangePackages();
		case TaskPackage.ACTION_ITEM__PREDECESSORS:
			return getPredecessors();
		case TaskPackage.ACTION_ITEM__SUCCESSORS:
			return getSuccessors();
		case TaskPackage.ACTION_ITEM__ASSIGNEE:
			if (resolve)
				return getAssignee();
			return basicGetAssignee();
		case TaskPackage.ACTION_ITEM__PARTICIPANTS:
			return getParticipants();
		case TaskPackage.ACTION_ITEM__DUE_DATE:
			return getDueDate();
		case TaskPackage.ACTION_ITEM__CHECKED:
			return isChecked() ? Boolean.TRUE : Boolean.FALSE;
		case TaskPackage.ACTION_ITEM__DONE:
			return isDone() ? Boolean.TRUE : Boolean.FALSE;
		case TaskPackage.ACTION_ITEM__ESTIMATE:
			return new Integer(getEstimate());
		case TaskPackage.ACTION_ITEM__ACTIVITY:
			return getActivity();
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
		case TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) newValue);
			return;
		case TaskPackage.ACTION_ITEM__ASSOCIATED_CHANGE_PACKAGES:
			getAssociatedChangePackages().clear();
			getAssociatedChangePackages().addAll((Collection<? extends ModelChangePackage>) newValue);
			return;
		case TaskPackage.ACTION_ITEM__PREDECESSORS:
			getPredecessors().clear();
			getPredecessors().addAll((Collection<? extends WorkItem>) newValue);
			return;
		case TaskPackage.ACTION_ITEM__SUCCESSORS:
			getSuccessors().clear();
			getSuccessors().addAll((Collection<? extends WorkItem>) newValue);
			return;
		case TaskPackage.ACTION_ITEM__ASSIGNEE:
			setAssignee((OrgUnit) newValue);
			return;
		case TaskPackage.ACTION_ITEM__PARTICIPANTS:
			getParticipants().clear();
			getParticipants().addAll((Collection<? extends OrgUnit>) newValue);
			return;
		case TaskPackage.ACTION_ITEM__DUE_DATE:
			setDueDate((Date) newValue);
			return;
		case TaskPackage.ACTION_ITEM__CHECKED:
			setChecked(((Boolean) newValue).booleanValue());
			return;
		case TaskPackage.ACTION_ITEM__DONE:
			setDone(((Boolean) newValue).booleanValue());
			return;
		case TaskPackage.ACTION_ITEM__ESTIMATE:
			setEstimate(((Integer) newValue).intValue());
			return;
		case TaskPackage.ACTION_ITEM__ACTIVITY:
			setActivity((ActivityType) newValue);
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
		case TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) null);
			return;
		case TaskPackage.ACTION_ITEM__ASSOCIATED_CHANGE_PACKAGES:
			getAssociatedChangePackages().clear();
			return;
		case TaskPackage.ACTION_ITEM__PREDECESSORS:
			getPredecessors().clear();
			return;
		case TaskPackage.ACTION_ITEM__SUCCESSORS:
			getSuccessors().clear();
			return;
		case TaskPackage.ACTION_ITEM__ASSIGNEE:
			setAssignee((OrgUnit) null);
			return;
		case TaskPackage.ACTION_ITEM__PARTICIPANTS:
			getParticipants().clear();
			return;
		case TaskPackage.ACTION_ITEM__DUE_DATE:
			setDueDate(DUE_DATE_EDEFAULT);
			return;
		case TaskPackage.ACTION_ITEM__CHECKED:
			setChecked(CHECKED_EDEFAULT);
			return;
		case TaskPackage.ACTION_ITEM__DONE:
			setDone(DONE_EDEFAULT);
			return;
		case TaskPackage.ACTION_ITEM__ESTIMATE:
			setEstimate(ESTIMATE_EDEFAULT);
			return;
		case TaskPackage.ACTION_ITEM__ACTIVITY:
			setActivity(ACTIVITY_EDEFAULT);
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
		case TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE:
			return basicGetContainingWorkpackage() != null;
		case TaskPackage.ACTION_ITEM__ASSOCIATED_CHANGE_PACKAGES:
			return associatedChangePackages != null && !associatedChangePackages.isEmpty();
		case TaskPackage.ACTION_ITEM__PREDECESSORS:
			return predecessors != null && !predecessors.isEmpty();
		case TaskPackage.ACTION_ITEM__SUCCESSORS:
			return successors != null && !successors.isEmpty();
		case TaskPackage.ACTION_ITEM__ASSIGNEE:
			return assignee != null;
		case TaskPackage.ACTION_ITEM__PARTICIPANTS:
			return participants != null && !participants.isEmpty();
		case TaskPackage.ACTION_ITEM__DUE_DATE:
			return DUE_DATE_EDEFAULT == null ? dueDate != null : !DUE_DATE_EDEFAULT.equals(dueDate);
		case TaskPackage.ACTION_ITEM__CHECKED:
			return isChecked() != CHECKED_EDEFAULT;
		case TaskPackage.ACTION_ITEM__DONE:
			return done != DONE_EDEFAULT;
		case TaskPackage.ACTION_ITEM__ESTIMATE:
			return estimate != ESTIMATE_EDEFAULT;
		case TaskPackage.ACTION_ITEM__ACTIVITY:
			return activity != ACTIVITY_EDEFAULT;
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
			case TaskPackage.ACTION_ITEM__CHECKED:
				return TaskPackage.CHECKABLE__CHECKED;
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
				return TaskPackage.ACTION_ITEM__CHECKED;
			default:
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
		result.append(" (dueDate: ");
		result.append(dueDate);
		result.append(", done: ");
		result.append(done);
		result.append(", estimate: ");
		result.append(estimate);
		result.append(", activity: ");
		result.append(activity);
		result.append(')');
		return result.toString();
	}

} // ActionItemImpl
