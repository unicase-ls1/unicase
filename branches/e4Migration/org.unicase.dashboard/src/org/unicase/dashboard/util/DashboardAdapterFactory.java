/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.DashboardPackage;
import org.unicase.dashboard.NotificationOperation;
import org.unicase.dashboard.SubscriptionComposite;
import org.unicase.dashboard.TaskTraceClassesComposite;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.unicase.dashboard.DashboardPackage
 * @generated
 */
public class DashboardAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static DashboardPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DashboardAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DashboardPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
	 * the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DashboardSwitch<Adapter> modelSwitch = new DashboardSwitch<Adapter>() {
		@Override
		public Adapter caseDashboardNotification(DashboardNotification object) {
			return createDashboardNotificationAdapter();
		}

		@Override
		public Adapter caseDashboardNotificationComposite(
				DashboardNotificationComposite object) {
			return createDashboardNotificationCompositeAdapter();
		}

		@Override
		public Adapter caseSubscriptionComposite(SubscriptionComposite object) {
			return createSubscriptionCompositeAdapter();
		}

		@Override
		public Adapter caseTaskTraceClassesComposite(
				TaskTraceClassesComposite object) {
			return createTaskTraceClassesCompositeAdapter();
		}

		@Override
		public Adapter caseNotificationOperation(NotificationOperation object) {
			return createNotificationOperationAdapter();
		}

		@Override
		public Adapter caseNonDomainElement(
				org.eclipse.emf.emfstore.internal.common.model.NonDomainElement object) {
			return createNonDomainElementAdapter();
		}

		@Override
		public Adapter caseIdentifiableElement(
				org.eclipse.emf.emfstore.internal.common.model.IdentifiableElement object) {
			return createIdentifiableElementAdapter();
		}

		@Override
		public Adapter caseAbstractOperation(
				org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation object) {
			return createAbstractOperationAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.dashboard.DashboardNotification
	 * <em>Notification</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.dashboard.DashboardNotification
	 * @generated
	 */
	public Adapter createDashboardNotificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.dashboard.DashboardNotificationComposite <em>Notification Composite</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.dashboard.DashboardNotificationComposite
	 * @generated
	 */
	public Adapter createDashboardNotificationCompositeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.dashboard.SubscriptionComposite <em>Subscription Composite</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.dashboard.SubscriptionComposite
	 * @generated
	 */
	public Adapter createSubscriptionCompositeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.dashboard.TaskTraceClassesComposite <em>Task Trace Classes Composite</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.dashboard.TaskTraceClassesComposite
	 * @generated
	 */
	public Adapter createTaskTraceClassesCompositeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.dashboard.NotificationOperation <em>Notification Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.dashboard.NotificationOperation
	 * @generated
	 */
	public Adapter createNotificationOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.internal.common.model.NonDomainElement <em>Non Domain Element</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.internal.common.model.NonDomainElement
	 * @generated
	 */
	public Adapter createNonDomainElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.internal.common.model.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.internal.common.model.IdentifiableElement
	 * @generated
	 */
	public Adapter createIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation <em>Abstract Operation</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation
	 * @generated
	 */
	public Adapter createAbstractOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // DashboardAdapterFactory
