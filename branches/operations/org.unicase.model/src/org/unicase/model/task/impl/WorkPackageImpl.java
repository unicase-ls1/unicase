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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.impl.AnnotationImpl;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Work Package</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.task.impl.WorkPackageImpl#getContainingWorkpackage <em>Containing Workpackage</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.WorkPackageImpl#getAssociatedChangePackages <em>Associated Change Packages</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.WorkPackageImpl#getPredecessors <em>Predecessors</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.WorkPackageImpl#getSuccessors <em>Successors</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.WorkPackageImpl#getContainedWorkItems <em>Contained Work Items</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.WorkPackageImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.WorkPackageImpl#getEndDate <em>End Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkPackageImpl extends AnnotationImpl implements WorkPackage {
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
	 * The cached value of the '{@link #getContainedWorkItems() <em>Contained Work Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedWorkItems()
	 * @generated
	 * @ordered
	 */
	protected EList<WorkItem> containedWorkItems;

	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_DATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date startDate = START_DATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date END_DATE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected Date endDate = END_DATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TaskPackage.Literals.WORK_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage getContainingWorkpackage() {
		if (eContainerFeatureID != TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE)
			return null;
		return (WorkPackage) eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage basicGetContainingWorkpackage() {
		if (eContainerFeatureID != TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE)
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
				TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingWorkpackage(WorkPackage newContainingWorkpackage) {
		if (newContainingWorkpackage != eInternalContainer()
				|| (eContainerFeatureID != TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE && newContainingWorkpackage != null)) {
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
					TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE,
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
					TaskPackage.WORK_PACKAGE__ASSOCIATED_CHANGE_PACKAGES);
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
					WorkItem.class, this,
					TaskPackage.WORK_PACKAGE__PREDECESSORS,
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
					WorkItem.class, this, TaskPackage.WORK_PACKAGE__SUCCESSORS,
					TaskPackage.WORK_ITEM__PREDECESSORS);
		}
		return successors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorkItem> getContainedWorkItems() {
		if (containedWorkItems == null) {
			containedWorkItems = new EObjectContainmentWithInverseEList.Resolving<WorkItem>(
					WorkItem.class, this,
					TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS,
					TaskPackage.WORK_ITEM__CONTAINING_WORKPACKAGE);
		}
		return containedWorkItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.WORK_PACKAGE__START_DATE, oldStartDate,
					startDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDate(Date newEndDate) {
		Date oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.WORK_PACKAGE__END_DATE, oldEndDate, endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetContainingWorkpackage((WorkPackage) otherEnd, msgs);
		case TaskPackage.WORK_PACKAGE__PREDECESSORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPredecessors())
					.basicAdd(otherEnd, msgs);
		case TaskPackage.WORK_PACKAGE__SUCCESSORS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getSuccessors())
					.basicAdd(otherEnd, msgs);
		case TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getContainedWorkItems())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE:
			return basicSetContainingWorkpackage(null, msgs);
		case TaskPackage.WORK_PACKAGE__PREDECESSORS:
			return ((InternalEList<?>) getPredecessors()).basicRemove(otherEnd,
					msgs);
		case TaskPackage.WORK_PACKAGE__SUCCESSORS:
			return ((InternalEList<?>) getSuccessors()).basicRemove(otherEnd,
					msgs);
		case TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS:
			return ((InternalEList<?>) getContainedWorkItems()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID) {
		case TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE:
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
		case TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE:
			if (resolve)
				return getContainingWorkpackage();
			return basicGetContainingWorkpackage();
		case TaskPackage.WORK_PACKAGE__ASSOCIATED_CHANGE_PACKAGES:
			return getAssociatedChangePackages();
		case TaskPackage.WORK_PACKAGE__PREDECESSORS:
			return getPredecessors();
		case TaskPackage.WORK_PACKAGE__SUCCESSORS:
			return getSuccessors();
		case TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS:
			return getContainedWorkItems();
		case TaskPackage.WORK_PACKAGE__START_DATE:
			return getStartDate();
		case TaskPackage.WORK_PACKAGE__END_DATE:
			return getEndDate();
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
		case TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) newValue);
			return;
		case TaskPackage.WORK_PACKAGE__ASSOCIATED_CHANGE_PACKAGES:
			getAssociatedChangePackages().clear();
			getAssociatedChangePackages().addAll(
					(Collection<? extends ModelChangePackage>) newValue);
			return;
		case TaskPackage.WORK_PACKAGE__PREDECESSORS:
			getPredecessors().clear();
			getPredecessors().addAll((Collection<? extends WorkItem>) newValue);
			return;
		case TaskPackage.WORK_PACKAGE__SUCCESSORS:
			getSuccessors().clear();
			getSuccessors().addAll((Collection<? extends WorkItem>) newValue);
			return;
		case TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS:
			getContainedWorkItems().clear();
			getContainedWorkItems().addAll(
					(Collection<? extends WorkItem>) newValue);
			return;
		case TaskPackage.WORK_PACKAGE__START_DATE:
			setStartDate((Date) newValue);
			return;
		case TaskPackage.WORK_PACKAGE__END_DATE:
			setEndDate((Date) newValue);
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
		case TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) null);
			return;
		case TaskPackage.WORK_PACKAGE__ASSOCIATED_CHANGE_PACKAGES:
			getAssociatedChangePackages().clear();
			return;
		case TaskPackage.WORK_PACKAGE__PREDECESSORS:
			getPredecessors().clear();
			return;
		case TaskPackage.WORK_PACKAGE__SUCCESSORS:
			getSuccessors().clear();
			return;
		case TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS:
			getContainedWorkItems().clear();
			return;
		case TaskPackage.WORK_PACKAGE__START_DATE:
			setStartDate(START_DATE_EDEFAULT);
			return;
		case TaskPackage.WORK_PACKAGE__END_DATE:
			setEndDate(END_DATE_EDEFAULT);
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
		case TaskPackage.WORK_PACKAGE__CONTAINING_WORKPACKAGE:
			return basicGetContainingWorkpackage() != null;
		case TaskPackage.WORK_PACKAGE__ASSOCIATED_CHANGE_PACKAGES:
			return associatedChangePackages != null
					&& !associatedChangePackages.isEmpty();
		case TaskPackage.WORK_PACKAGE__PREDECESSORS:
			return predecessors != null && !predecessors.isEmpty();
		case TaskPackage.WORK_PACKAGE__SUCCESSORS:
			return successors != null && !successors.isEmpty();
		case TaskPackage.WORK_PACKAGE__CONTAINED_WORK_ITEMS:
			return containedWorkItems != null && !containedWorkItems.isEmpty();
		case TaskPackage.WORK_PACKAGE__START_DATE:
			return START_DATE_EDEFAULT == null ? startDate != null
					: !START_DATE_EDEFAULT.equals(startDate);
		case TaskPackage.WORK_PACKAGE__END_DATE:
			return END_DATE_EDEFAULT == null ? endDate != null
					: !END_DATE_EDEFAULT.equals(endDate);
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (startDate: ");
		result.append(startDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(')');
		return result.toString();
	}

} // WorkPackageImpl
