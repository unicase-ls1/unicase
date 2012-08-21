/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.NonDomainElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Subscription Composite</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.dashboard.SubscriptionComposite#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.dashboard.DashboardPackage#getSubscriptionComposite()
 * @model
 * @generated
 */
public interface SubscriptionComposite extends NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Subscriptions</b></em>' containment reference list. The list contents are of
	 * type {@link org.eclipse.emf.emfstore.common.model.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscriptions</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Subscriptions</em>' containment reference list.
	 * @see org.unicase.dashboard.DashboardPackage#getSubscriptionComposite_Subscriptions()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ModelElementId> getSubscriptions();

} // SubscriptionComposite
