/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Exception Event</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent#getExceptionTitle <em>Exception Title</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent#getExceptionStackTrace <em>Exception Stack Trace</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent#getExceptionCauseTitle <em>Exception Cause Title</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent#getExceptionCauseStackTrace <em>Exception Cause Stack Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getExceptionEvent()
 * @model
 * @generated
 */
public interface ExceptionEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Exception Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Title</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Title</em>' attribute.
	 * @see #setExceptionTitle(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getExceptionEvent_ExceptionTitle()
	 * @model
	 * @generated
	 */
	String getExceptionTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent#getExceptionTitle <em>Exception Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Title</em>' attribute.
	 * @see #getExceptionTitle()
	 * @generated
	 */
	void setExceptionTitle(String value);

	/**
	 * Returns the value of the '<em><b>Exception Stack Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Stack Trace</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Stack Trace</em>' attribute.
	 * @see #setExceptionStackTrace(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getExceptionEvent_ExceptionStackTrace()
	 * @model
	 * @generated
	 */
	String getExceptionStackTrace();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent#getExceptionStackTrace <em>Exception Stack Trace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Stack Trace</em>' attribute.
	 * @see #getExceptionStackTrace()
	 * @generated
	 */
	void setExceptionStackTrace(String value);

	/**
	 * Returns the value of the '<em><b>Exception Cause Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Cause Title</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Cause Title</em>' attribute.
	 * @see #setExceptionCauseTitle(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getExceptionEvent_ExceptionCauseTitle()
	 * @model
	 * @generated
	 */
	String getExceptionCauseTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent#getExceptionCauseTitle <em>Exception Cause Title</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Cause Title</em>' attribute.
	 * @see #getExceptionCauseTitle()
	 * @generated
	 */
	void setExceptionCauseTitle(String value);

	/**
	 * Returns the value of the '<em><b>Exception Cause Stack Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Cause Stack Trace</em>' attribute isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Cause Stack Trace</em>' attribute.
	 * @see #setExceptionCauseStackTrace(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getExceptionEvent_ExceptionCauseStackTrace()
	 * @model
	 * @generated
	 */
	String getExceptionCauseStackTrace();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.ExceptionEvent#getExceptionCauseStackTrace <em>Exception Cause Stack Trace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Cause Stack Trace</em>' attribute.
	 * @see #getExceptionCauseStackTrace()
	 * @generated
	 */
	void setExceptionCauseStackTrace(String value);

} // ExceptionEvent
