/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.emfstore.internal.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.internal.client.properties.PropertyManager;
import org.eclipse.emf.emfstore.internal.common.model.EMFStoreProperty;
import org.eclipse.emf.emfstore.internal.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.internal.common.model.Project;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.emf.emfstore.internal.server.model.versioning.operations.AbstractOperation;
import org.unicase.dashboard.DashboardFactory;
import org.unicase.dashboard.DashboardNotification;
import org.unicase.dashboard.DashboardNotificationComposite;
import org.unicase.dashboard.DashboardPackage;
import org.unicase.dashboard.NotificationOperation;
import org.unicase.dashboard.util.DashboardPropertyKeys;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Notification Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.dashboard.impl.NotificationOperationImpl#getNotifications <em>Notifications</em>}</li>
 *   <li>{@link org.unicase.dashboard.impl.NotificationOperationImpl#isReversed <em>Reversed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NotificationOperationImpl
		extends
		org.eclipse.emf.emfstore.internal.server.model.versioning.operations.impl.AbstractOperationImpl
		implements NotificationOperation {
	/**
	 * The cached value of the '{@link #getNotifications() <em>Notifications</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNotifications()
	 * @generated
	 * @ordered
	 */
	protected EList<DashboardNotification> notifications;

	/**
	 * The default value of the '{@link #isReversed() <em>Reversed</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isReversed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REVERSED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isReversed() <em>Reversed</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isReversed()
	 * @generated
	 * @ordered
	 */
	protected boolean reversed = REVERSED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected NotificationOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DashboardPackage.Literals.NOTIFICATION_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DashboardNotification> getNotifications() {
		if (notifications == null) {
			notifications = new EObjectContainmentEList.Resolving<DashboardNotification>(
					DashboardNotification.class, this,
					DashboardPackage.NOTIFICATION_OPERATION__NOTIFICATIONS);
		}
		return notifications;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReversed() {
		return reversed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReversed(boolean newReversed) {
		boolean oldReversed = reversed;
		reversed = newReversed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DashboardPackage.NOTIFICATION_OPERATION__REVERSED,
					oldReversed, reversed));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DashboardPackage.NOTIFICATION_OPERATION__NOTIFICATIONS:
			return ((InternalEList<?>) getNotifications()).basicRemove(
					otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DashboardPackage.NOTIFICATION_OPERATION__NOTIFICATIONS:
			return getNotifications();
		case DashboardPackage.NOTIFICATION_OPERATION__REVERSED:
			return isReversed();
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
		case DashboardPackage.NOTIFICATION_OPERATION__NOTIFICATIONS:
			getNotifications().clear();
			getNotifications().addAll(
					(Collection<? extends DashboardNotification>) newValue);
			return;
		case DashboardPackage.NOTIFICATION_OPERATION__REVERSED:
			setReversed((Boolean) newValue);
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
		case DashboardPackage.NOTIFICATION_OPERATION__NOTIFICATIONS:
			getNotifications().clear();
			return;
		case DashboardPackage.NOTIFICATION_OPERATION__REVERSED:
			setReversed(REVERSED_EDEFAULT);
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
		case DashboardPackage.NOTIFICATION_OPERATION__NOTIFICATIONS:
			return notifications != null && !notifications.isEmpty();
		case DashboardPackage.NOTIFICATION_OPERATION__REVERSED:
			return reversed != REVERSED_EDEFAULT;
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
		result.append(" (reversed: ");
		result.append(reversed);
		result.append(')');
		return result.toString();
	}

	public void apply(IdEObjectCollection idEObjectCollection) {
		Project project = ModelUtil.getProject(idEObjectCollection);
		ProjectSpace projectSpace = null;
		EObject container = project.eContainer();
		while (container != null) {
			if (container instanceof ProjectSpace) {
				projectSpace = (ProjectSpace) container;
				break;
			}
		}
		if (projectSpace != null) {
			PropertyManager manager = projectSpace.getPropertyManager();
			EMFStoreProperty property = manager
					.getLocalProperty(DashboardPropertyKeys.NOTIFICATION_COMPOSITE);
			if (property != null) {
				EObject value = property.getValue();
				if (value != null
						&& value instanceof DashboardNotificationComposite) {
					DashboardNotificationComposite notificationComposite = (DashboardNotificationComposite) value;
					if (isReversed()) {
						notificationComposite.getNotifications().removeAll(
								getNotifications());
					} else {
						notificationComposite.getNotifications().addAll(
								getNotifications());
					}
				}
			} else {
				if (!isReversed()) {
					DashboardNotificationComposite notificationComposite = DashboardFactory.eINSTANCE
							.createDashboardNotificationComposite();
					notificationComposite.getNotifications().addAll(
							getNotifications());
					manager.setLocalProperty(
							DashboardPropertyKeys.NOTIFICATION_COMPOSITE,
							notificationComposite);
				}
			}
		}
	}

	public List<AbstractOperation> getLeafOperations() {
		return Collections.emptyList();
	}

	@Override
	public AbstractOperation reverse() {
		NotificationOperation operation = DashboardFactory.eINSTANCE
				.createNotificationOperation();
		operation.setReversed(true);
		operation.setClientDate(new Date());
		operation.getNotifications().addAll(getNotifications());

		return operation;
	}

} // NotificationOperationImpl
