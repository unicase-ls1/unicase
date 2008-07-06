/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.impl.AnnotationImpl;
import org.unicase.model.organization.User;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Action Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getContainingWorkpackage <em>Containing Workpackage</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getAssociatedChangePackages <em>Associated Change Packages</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getAssignedTo <em>Assigned To</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getDueDate <em>Due Date</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#isDone <em>Done</em>}</li>
 *   <li>{@link org.unicase.model.task.impl.ActionItemImpl#getEstimate <em>Estimate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActionItemImpl extends AnnotationImpl implements ActionItem {
	/**
	 * The cached value of the '{@link #getContainingWorkpackage() <em>Containing Workpackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainingWorkpackage()
	 * @generated
	 * @ordered
	 */
	protected WorkPackage containingWorkpackage;

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
	 * The cached value of the '{@link #getAssignedTo() <em>Assigned To</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAssignedTo()
	 * @generated
	 * @ordered
	 */
	protected EList<User> assignedTo;

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
		if (containingWorkpackage != null && containingWorkpackage.eIsProxy()) {
			InternalEObject oldContainingWorkpackage = (InternalEObject) containingWorkpackage;
			containingWorkpackage = (WorkPackage) eResolveProxy(oldContainingWorkpackage);
			if (containingWorkpackage != oldContainingWorkpackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE,
							oldContainingWorkpackage, containingWorkpackage));
			}
		}
		return containingWorkpackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage basicGetContainingWorkpackage() {
		return containingWorkpackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingWorkpackage(WorkPackage newContainingWorkpackage) {
		WorkPackage oldContainingWorkpackage = containingWorkpackage;
		containingWorkpackage = newContainingWorkpackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.ACTION_ITEM__CONTAINING_WORKPACKAGE,
					oldContainingWorkpackage, containingWorkpackage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelChangePackage> getAssociatedChangePackages() {
		if (associatedChangePackages == null) {
			associatedChangePackages = new EObjectResolvingEList<ModelChangePackage>(
					ModelChangePackage.class, this,
					TaskPackage.ACTION_ITEM__ASSOCIATED_CHANGE_PACKAGES);
		}
		return associatedChangePackages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<User> getAssignedTo() {
		if (assignedTo == null) {
			assignedTo = new EObjectResolvingEList<User>(User.class, this,
					TaskPackage.ACTION_ITEM__ASSIGNED_TO);
		}
		return assignedTo;
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
					TaskPackage.ACTION_ITEM__DUE_DATE, oldDueDate, dueDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					TaskPackage.ACTION_ITEM__DONE, oldDone, done));
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
					TaskPackage.ACTION_ITEM__ESTIMATE, oldEstimate, estimate));
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
		case TaskPackage.ACTION_ITEM__ASSIGNED_TO:
			return getAssignedTo();
		case TaskPackage.ACTION_ITEM__DUE_DATE:
			return getDueDate();
		case TaskPackage.ACTION_ITEM__DONE:
			return isDone() ? Boolean.TRUE : Boolean.FALSE;
		case TaskPackage.ACTION_ITEM__ESTIMATE:
			return new Integer(getEstimate());
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
			getAssociatedChangePackages().addAll(
					(Collection<? extends ModelChangePackage>) newValue);
			return;
		case TaskPackage.ACTION_ITEM__ASSIGNED_TO:
			getAssignedTo().clear();
			getAssignedTo().addAll((Collection<? extends User>) newValue);
			return;
		case TaskPackage.ACTION_ITEM__DUE_DATE:
			setDueDate((Date) newValue);
			return;
		case TaskPackage.ACTION_ITEM__DONE:
			setDone(((Boolean) newValue).booleanValue());
			return;
		case TaskPackage.ACTION_ITEM__ESTIMATE:
			setEstimate(((Integer) newValue).intValue());
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
		case TaskPackage.ACTION_ITEM__ASSIGNED_TO:
			getAssignedTo().clear();
			return;
		case TaskPackage.ACTION_ITEM__DUE_DATE:
			setDueDate(DUE_DATE_EDEFAULT);
			return;
		case TaskPackage.ACTION_ITEM__DONE:
			setDone(DONE_EDEFAULT);
			return;
		case TaskPackage.ACTION_ITEM__ESTIMATE:
			setEstimate(ESTIMATE_EDEFAULT);
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
			return containingWorkpackage != null;
		case TaskPackage.ACTION_ITEM__ASSOCIATED_CHANGE_PACKAGES:
			return associatedChangePackages != null
					&& !associatedChangePackages.isEmpty();
		case TaskPackage.ACTION_ITEM__ASSIGNED_TO:
			return assignedTo != null && !assignedTo.isEmpty();
		case TaskPackage.ACTION_ITEM__DUE_DATE:
			return DUE_DATE_EDEFAULT == null ? dueDate != null
					: !DUE_DATE_EDEFAULT.equals(dueDate);
		case TaskPackage.ACTION_ITEM__DONE:
			return done != DONE_EDEFAULT;
		case TaskPackage.ACTION_ITEM__ESTIMATE:
			return estimate != ESTIMATE_EDEFAULT;
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
		result.append(", done: ");
		result.append(done);
		result.append(", estimate: ");
		result.append(estimate);
		result.append(')');
		return result.toString();
	}

} // ActionItemImpl
