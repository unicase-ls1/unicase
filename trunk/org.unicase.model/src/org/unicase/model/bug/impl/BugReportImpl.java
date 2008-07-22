/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.bug.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.BugReport;
import org.unicase.model.bug.BugResolution;
import org.unicase.model.bug.BugStatus;
import org.unicase.model.bug.Severity;
import org.unicase.model.change.ModelChangePackage;
import org.unicase.model.impl.AnnotationImpl;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.requirement.Step;
import org.unicase.model.task.WorkPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Report</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getContainingWorkpackage <em>Containing Workpackage</em>}</li>
 *   <li>{@link org.unicase.model.bug.impl.BugReportImpl#getAssociatedChangePackages <em>Associated Change Packages</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedChangePackages()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelChangePackage> associatedChangePackages;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkPackage getContainingWorkpackage() {
		if (containingWorkpackage != null && containingWorkpackage.eIsProxy()) {
			InternalEObject oldContainingWorkpackage = (InternalEObject) containingWorkpackage;
			containingWorkpackage = (WorkPackage) eResolveProxy(oldContainingWorkpackage);
			if (containingWorkpackage != oldContainingWorkpackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE,
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainingWorkpackage(WorkPackage newContainingWorkpackage) {
		WorkPackage oldContainingWorkpackage = containingWorkpackage;
		containingWorkpackage = newContainingWorkpackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE,
					oldContainingWorkpackage, containingWorkpackage));
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
					BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES);
		}
		return associatedChangePackages;
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE:
			if (resolve)
				return getContainingWorkpackage();
			return basicGetContainingWorkpackage();
		case BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES:
			return getAssociatedChangePackages();
		case BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE:
			return getStepsToReproduce();
		case BugPackage.BUG_REPORT__STATUS:
			return getStatus();
		case BugPackage.BUG_REPORT__ASSIGNED_TO:
			if (resolve)
				return getAssignedTo();
			return basicGetAssignedTo();
		case BugPackage.BUG_REPORT__RESOLUTION:
			if (resolve)
				return getResolution();
			return basicGetResolution();
		case BugPackage.BUG_REPORT__SEVERITY:
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
		case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) newValue);
			return;
		case BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES:
			getAssociatedChangePackages().clear();
			getAssociatedChangePackages().addAll(
					(Collection<? extends ModelChangePackage>) newValue);
			return;
		case BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE:
			getStepsToReproduce().clear();
			getStepsToReproduce().addAll((Collection<? extends Step>) newValue);
			return;
		case BugPackage.BUG_REPORT__STATUS:
			setStatus((BugStatus) newValue);
			return;
		case BugPackage.BUG_REPORT__ASSIGNED_TO:
			setAssignedTo((OrgUnit) newValue);
			return;
		case BugPackage.BUG_REPORT__RESOLUTION:
			setResolution((BugResolution) newValue);
			return;
		case BugPackage.BUG_REPORT__SEVERITY:
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
		case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE:
			setContainingWorkpackage((WorkPackage) null);
			return;
		case BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES:
			getAssociatedChangePackages().clear();
			return;
		case BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE:
			getStepsToReproduce().clear();
			return;
		case BugPackage.BUG_REPORT__STATUS:
			setStatus(STATUS_EDEFAULT);
			return;
		case BugPackage.BUG_REPORT__ASSIGNED_TO:
			setAssignedTo((OrgUnit) null);
			return;
		case BugPackage.BUG_REPORT__RESOLUTION:
			setResolution((BugResolution) null);
			return;
		case BugPackage.BUG_REPORT__SEVERITY:
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
		case BugPackage.BUG_REPORT__CONTAINING_WORKPACKAGE:
			return containingWorkpackage != null;
		case BugPackage.BUG_REPORT__ASSOCIATED_CHANGE_PACKAGES:
			return associatedChangePackages != null
					&& !associatedChangePackages.isEmpty();
		case BugPackage.BUG_REPORT__STEPS_TO_REPRODUCE:
			return stepsToReproduce != null && !stepsToReproduce.isEmpty();
		case BugPackage.BUG_REPORT__STATUS:
			return status != STATUS_EDEFAULT;
		case BugPackage.BUG_REPORT__ASSIGNED_TO:
			return assignedTo != null;
		case BugPackage.BUG_REPORT__RESOLUTION:
			return resolution != null;
		case BugPackage.BUG_REPORT__SEVERITY:
			return severity != SEVERITY_EDEFAULT;
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
		result.append(" (Status: ");
		result.append(status);
		result.append(", severity: ");
		result.append(severity);
		result.append(')');
		return result.toString();
	}

} // BugReportImpl
