/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.rationale.impl.IssueImpl;

/*
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Merging Issue</b></em>'. <!-- end-user-doc -->
 * <p> The following features are implemented: <ul> <li>{@link
 * org.unicase.model.change.impl.MergingIssueImpl#getResolvingRevision <em>Resolving Revision</em>}</li> </ul> </p>
 * @generated
 */
public class MergingIssueImpl extends IssueImpl implements MergingIssue {
	/**
	 * The default value of the '{@link #getResolvingRevision() <em>Resolving Revision</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResolvingRevision()
	 * @generated
	 * @ordered
	 */
	protected static final int RESOLVING_REVISION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getResolvingRevision() <em>Resolving Revision</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResolvingRevision()
	 * @generated
	 * @ordered
	 */
	protected int resolvingRevision = RESOLVING_REVISION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MergingIssueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangePackage.Literals.MERGING_ISSUE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getResolvingRevision() {
		return resolvingRevision;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setResolvingRevision(int newResolvingRevision) {
		int oldResolvingRevision = resolvingRevision;
		resolvingRevision = newResolvingRevision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangePackage.MERGING_ISSUE__RESOLVING_REVISION,
				oldResolvingRevision, resolvingRevision));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangePackage.MERGING_ISSUE__RESOLVING_REVISION:
			return new Integer(getResolvingRevision());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ChangePackage.MERGING_ISSUE__RESOLVING_REVISION:
			setResolvingRevision(((Integer) newValue).intValue());
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ChangePackage.MERGING_ISSUE__RESOLVING_REVISION:
			setResolvingRevision(RESOLVING_REVISION_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ChangePackage.MERGING_ISSUE__RESOLVING_REVISION:
			return resolvingRevision != RESOLVING_REVISION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resolvingRevision: ");
		result.append(resolvingRevision);
		result.append(')');
		return result.toString();
	}

} // MergingIssueImpl
