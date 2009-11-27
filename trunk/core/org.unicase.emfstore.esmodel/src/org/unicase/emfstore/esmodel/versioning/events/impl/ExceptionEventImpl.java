/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Exception Event</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl#getExceptionTitle <em>Exception
 * Title</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl#getExceptionStackTrace <em>
 * Exception Stack Trace</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl#getExceptionCauseTitle <em>
 * Exception Cause Title</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.impl.ExceptionEventImpl#getExceptionCauseStackTrace <em>
 * Exception Cause Stack Trace</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ExceptionEventImpl extends EventImpl implements ExceptionEvent {
	/**
	 * The default value of the '{@link #getExceptionTitle() <em>Exception Title</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getExceptionTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExceptionTitle() <em>Exception Title</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getExceptionTitle()
	 * @generated
	 * @ordered
	 */
	protected String exceptionTitle = EXCEPTION_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExceptionStackTrace() <em>Exception Stack Trace</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExceptionStackTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_STACK_TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExceptionStackTrace() <em>Exception Stack Trace</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExceptionStackTrace()
	 * @generated
	 * @ordered
	 */
	protected String exceptionStackTrace = EXCEPTION_STACK_TRACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExceptionCauseTitle() <em>Exception Cause Title</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExceptionCauseTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_CAUSE_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExceptionCauseTitle() <em>Exception Cause Title</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExceptionCauseTitle()
	 * @generated
	 * @ordered
	 */
	protected String exceptionCauseTitle = EXCEPTION_CAUSE_TITLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExceptionCauseStackTrace() <em>Exception Cause Stack Trace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExceptionCauseStackTrace()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCEPTION_CAUSE_STACK_TRACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExceptionCauseStackTrace() <em>Exception Cause Stack Trace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExceptionCauseStackTrace()
	 * @generated
	 * @ordered
	 */
	protected String exceptionCauseStackTrace = EXCEPTION_CAUSE_STACK_TRACE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ExceptionEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventsPackage.Literals.EXCEPTION_EVENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getExceptionTitle() {
		return exceptionTitle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionTitle(String newExceptionTitle) {
		String oldExceptionTitle = exceptionTitle;
		exceptionTitle = newExceptionTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EXCEPTION_EVENT__EXCEPTION_TITLE, oldExceptionTitle, exceptionTitle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getExceptionStackTrace() {
		return exceptionStackTrace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionStackTrace(String newExceptionStackTrace) {
		String oldExceptionStackTrace = exceptionStackTrace;
		exceptionStackTrace = newExceptionStackTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EXCEPTION_EVENT__EXCEPTION_STACK_TRACE, oldExceptionStackTrace, exceptionStackTrace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getExceptionCauseTitle() {
		return exceptionCauseTitle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionCauseTitle(String newExceptionCauseTitle) {
		String oldExceptionCauseTitle = exceptionCauseTitle;
		exceptionCauseTitle = newExceptionCauseTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE, oldExceptionCauseTitle, exceptionCauseTitle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getExceptionCauseStackTrace() {
		return exceptionCauseStackTrace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExceptionCauseStackTrace(String newExceptionCauseStackTrace) {
		String oldExceptionCauseStackTrace = exceptionCauseStackTrace;
		exceptionCauseStackTrace = newExceptionCauseStackTrace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE, oldExceptionCauseStackTrace, exceptionCauseStackTrace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_TITLE:
				return getExceptionTitle();
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_STACK_TRACE:
				return getExceptionStackTrace();
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE:
				return getExceptionCauseTitle();
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE:
				return getExceptionCauseStackTrace();
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
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_TITLE:
				setExceptionTitle((String)newValue);
				return;
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_STACK_TRACE:
				setExceptionStackTrace((String)newValue);
				return;
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE:
				setExceptionCauseTitle((String)newValue);
				return;
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE:
				setExceptionCauseStackTrace((String)newValue);
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
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_TITLE:
				setExceptionTitle(EXCEPTION_TITLE_EDEFAULT);
				return;
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_STACK_TRACE:
				setExceptionStackTrace(EXCEPTION_STACK_TRACE_EDEFAULT);
				return;
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE:
				setExceptionCauseTitle(EXCEPTION_CAUSE_TITLE_EDEFAULT);
				return;
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE:
				setExceptionCauseStackTrace(EXCEPTION_CAUSE_STACK_TRACE_EDEFAULT);
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
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_TITLE:
				return EXCEPTION_TITLE_EDEFAULT == null ? exceptionTitle != null : !EXCEPTION_TITLE_EDEFAULT.equals(exceptionTitle);
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_STACK_TRACE:
				return EXCEPTION_STACK_TRACE_EDEFAULT == null ? exceptionStackTrace != null : !EXCEPTION_STACK_TRACE_EDEFAULT.equals(exceptionStackTrace);
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_TITLE:
				return EXCEPTION_CAUSE_TITLE_EDEFAULT == null ? exceptionCauseTitle != null : !EXCEPTION_CAUSE_TITLE_EDEFAULT.equals(exceptionCauseTitle);
			case EventsPackage.EXCEPTION_EVENT__EXCEPTION_CAUSE_STACK_TRACE:
				return EXCEPTION_CAUSE_STACK_TRACE_EDEFAULT == null ? exceptionCauseStackTrace != null : !EXCEPTION_CAUSE_STACK_TRACE_EDEFAULT.equals(exceptionCauseStackTrace);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ExceptionTitle: ");
		result.append(exceptionTitle);
		result.append(", ExceptionStackTrace: ");
		result.append(exceptionStackTrace);
		result.append(", ExceptionCauseTitle: ");
		result.append(exceptionCauseTitle);
		result.append(", ExceptionCauseStackTrace: ");
		result.append(exceptionCauseStackTrace);
		result.append(')');
		return result.toString();
	}

} // ExceptionEventImpl
