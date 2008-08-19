/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.ModelPackage;
import org.unicase.model.ReaderInfo;
import org.unicase.model.organization.OrgUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Reader Info</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.impl.ReaderInfoImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.unicase.model.impl.ReaderInfoImpl#getReaderId <em>Reader Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReaderInfoImpl extends IdentifiableElementImpl implements
		ReaderInfo {
	/**
	 * The default value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date = DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReaderId() <em>Reader Id</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReaderId()
	 * @generated
	 * @ordered
	 */
	protected OrgUnit readerId;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ReaderInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.READER_INFO;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.READER_INFO__DATE, oldDate, date));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit getReaderId() {
		if (readerId != null && readerId.eIsProxy()) {
			InternalEObject oldReaderId = (InternalEObject) readerId;
			readerId = (OrgUnit) eResolveProxy(oldReaderId);
			if (readerId != oldReaderId) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ModelPackage.READER_INFO__READER_ID, oldReaderId,
							readerId));
			}
		}
		return readerId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OrgUnit basicGetReaderId() {
		return readerId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReaderId(OrgUnit newReaderId) {
		OrgUnit oldReaderId = readerId;
		readerId = newReaderId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelPackage.READER_INFO__READER_ID, oldReaderId, readerId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ModelPackage.READER_INFO__DATE:
			return getDate();
		case ModelPackage.READER_INFO__READER_ID:
			if (resolve)
				return getReaderId();
			return basicGetReaderId();
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
		case ModelPackage.READER_INFO__DATE:
			setDate((Date) newValue);
			return;
		case ModelPackage.READER_INFO__READER_ID:
			setReaderId((OrgUnit) newValue);
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
		case ModelPackage.READER_INFO__DATE:
			setDate(DATE_EDEFAULT);
			return;
		case ModelPackage.READER_INFO__READER_ID:
			setReaderId((OrgUnit) null);
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
		case ModelPackage.READER_INFO__DATE:
			return DATE_EDEFAULT == null ? date != null : !DATE_EDEFAULT
					.equals(date);
		case ModelPackage.READER_INFO__READER_ID:
			return readerId != null;
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
		result.append(" (date: ");
		result.append(date);
		result.append(')');
		return result.toString();
	}

} // ReaderInfoImpl
