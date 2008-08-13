/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.bug.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.bug.BugPackage;
import org.unicase.model.bug.BugResolution;
import org.unicase.model.bug.ResolutionType;
import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resolution</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.bug.impl.BugResolutionImpl#getResoultionType <em>Resoultion Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BugResolutionImpl extends ModelElementImpl implements
		BugResolution {
	/**
	 * The default value of the '{@link #getResoultionType() <em>Resoultion Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getResoultionType()
	 * @generated
	 * @ordered
	 */
	protected static final ResolutionType RESOULTION_TYPE_EDEFAULT = ResolutionType.FIXED;

	/**
	 * The cached value of the '{@link #getResoultionType() <em>Resoultion Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getResoultionType()
	 * @generated
	 * @ordered
	 */
	protected ResolutionType resoultionType = RESOULTION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected BugResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BugPackage.Literals.BUG_RESOLUTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ResolutionType getResoultionType() {
		return resoultionType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResoultionType(ResolutionType newResoultionType) {
		ResolutionType oldResoultionType = resoultionType;
		resoultionType = newResoultionType == null ? RESOULTION_TYPE_EDEFAULT
				: newResoultionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BugPackage.BUG_RESOLUTION__RESOULTION_TYPE,
					oldResoultionType, resoultionType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case BugPackage.BUG_RESOLUTION__RESOULTION_TYPE:
			return getResoultionType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BugPackage.BUG_RESOLUTION__RESOULTION_TYPE:
			setResoultionType((ResolutionType) newValue);
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
		case BugPackage.BUG_RESOLUTION__RESOULTION_TYPE:
			setResoultionType(RESOULTION_TYPE_EDEFAULT);
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
		case BugPackage.BUG_RESOLUTION__RESOULTION_TYPE:
			return resoultionType != RESOULTION_TYPE_EDEFAULT;
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
		result.append(" (resoultionType: ");
		result.append(resoultionType);
		result.append(')');
		return result.toString();
	}

} // BugResolutionImpl
