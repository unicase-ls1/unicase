/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.DashboardPackage;
import org.unicase.dashboard.NotificationOperation;
import org.unicase.dashboard.SubscriptionComposite;
import org.unicase.dashboard.TaskTraceClassesComposite;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.unicase.dashboard.DashboardPackage
 * @generated
 */
public class DashboardSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static DashboardPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DashboardSwitch() {
		if (modelPackage == null) {
			modelPackage = DashboardPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(
					eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case DashboardPackage.DASHBOARD_NOTIFICATION: {
			DashboardNotification dashboardNotification = (DashboardNotification) theEObject;
			T result = caseDashboardNotification(dashboardNotification);
			if (result == null)
				result = caseNonDomainElement(dashboardNotification);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DashboardPackage.DASHBOARD_NOTIFICATION_COMPOSITE: {
			DashboardNotificationComposite dashboardNotificationComposite = (DashboardNotificationComposite) theEObject;
			T result = caseDashboardNotificationComposite(dashboardNotificationComposite);
			if (result == null)
				result = caseNonDomainElement(dashboardNotificationComposite);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DashboardPackage.SUBSCRIPTION_COMPOSITE: {
			SubscriptionComposite subscriptionComposite = (SubscriptionComposite) theEObject;
			T result = caseSubscriptionComposite(subscriptionComposite);
			if (result == null)
				result = caseNonDomainElement(subscriptionComposite);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DashboardPackage.TASK_TRACE_CLASSES_COMPOSITE: {
			TaskTraceClassesComposite taskTraceClassesComposite = (TaskTraceClassesComposite) theEObject;
			T result = caseTaskTraceClassesComposite(taskTraceClassesComposite);
			if (result == null)
				result = caseNonDomainElement(taskTraceClassesComposite);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case DashboardPackage.NOTIFICATION_OPERATION: {
			NotificationOperation notificationOperation = (NotificationOperation) theEObject;
			T result = caseNotificationOperation(notificationOperation);
			if (result == null)
				result = caseAbstractOperation(notificationOperation);
			if (result == null)
				result = caseNonDomainElement(notificationOperation);
			if (result == null)
				result = caseIdentifiableElement(notificationOperation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDashboardNotification(DashboardNotification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Notification Composite</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Notification Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDashboardNotificationComposite(
			DashboardNotificationComposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subscription Composite</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subscription Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubscriptionComposite(SubscriptionComposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Trace Classes Composite</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Trace Classes Composite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskTraceClassesComposite(TaskTraceClassesComposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Notification Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Notification Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotificationOperation(NotificationOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Domain Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Domain Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonDomainElement(
			org.eclipse.emf.emfstore.internal.common.model.NonDomainElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiableElement(
			org.eclipse.emf.emfstore.internal.common.model.IdentifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractOperation(
			org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // DashboardSwitch
