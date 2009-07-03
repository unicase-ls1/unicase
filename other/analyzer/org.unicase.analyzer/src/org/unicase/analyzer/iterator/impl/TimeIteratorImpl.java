/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.analyzer.iterator.impl;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.TimeIterator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Iterator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.analyzer.iterator.impl.TimeIteratorImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.impl.TimeIteratorImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.unicase.analyzer.iterator.impl.TimeIteratorImpl#getStepLengthUnit <em>Step Length Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeIteratorImpl extends VersionIteratorImpl implements TimeIterator {
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
	 * The default value of the '{@link #getStepLengthUnit() <em>Step Length Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepLengthUnit()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_LENGTH_UNIT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStepLengthUnit() <em>Step Length Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepLengthUnit()
	 * @generated
	 * @ordered
	 */
	protected int stepLengthUnit = STEP_LENGTH_UNIT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeIteratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IteratorPackage.Literals.TIME_ITERATOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.TIME_ITERATOR__START_DATE, oldStartDate, startDate));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.TIME_ITERATOR__END_DATE, oldEndDate, endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStepLengthUnit() {
		return stepLengthUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepLengthUnit(int newStepLengthUnit) {
		int oldStepLengthUnit = stepLengthUnit;
		stepLengthUnit = newStepLengthUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT, oldStepLengthUnit, stepLengthUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IteratorPackage.TIME_ITERATOR__START_DATE:
				return getStartDate();
			case IteratorPackage.TIME_ITERATOR__END_DATE:
				return getEndDate();
			case IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT:
				return new Integer(getStepLengthUnit());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IteratorPackage.TIME_ITERATOR__START_DATE:
				setStartDate((Date)newValue);
				return;
			case IteratorPackage.TIME_ITERATOR__END_DATE:
				setEndDate((Date)newValue);
				return;
			case IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT:
				setStepLengthUnit(((Integer)newValue).intValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IteratorPackage.TIME_ITERATOR__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case IteratorPackage.TIME_ITERATOR__END_DATE:
				setEndDate(END_DATE_EDEFAULT);
				return;
			case IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT:
				setStepLengthUnit(STEP_LENGTH_UNIT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IteratorPackage.TIME_ITERATOR__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case IteratorPackage.TIME_ITERATOR__END_DATE:
				return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
			case IteratorPackage.TIME_ITERATOR__STEP_LENGTH_UNIT:
				return stepLengthUnit != STEP_LENGTH_UNIT_EDEFAULT;
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (startDate: ");
		result.append(startDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", stepLengthUnit: ");
		result.append(stepLengthUnit);
		result.append(')');
		return result.toString();
	}

} //TimeIteratorImpl
