/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.component;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Component</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.component.Component#getPackages <em>Packages</em>}</li>
 *   <li>{@link org.unicase.model.component.Component#getOfferedServices <em>Offered Services</em>}</li>
 *   <li>{@link org.unicase.model.component.Component#getConsumedServices <em>Consumed Services</em>}</li>
 *   <li>{@link org.unicase.model.component.Component#getSubsystems <em>Subsystems</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.component.ComponentPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' reference list.
	 * @see org.unicase.model.component.ComponentPackage#getComponent_Packages()
	 * @model
	 * @generated
	 */
	EList<org.unicase.model.classes.Package> getPackages();

	/**
	 * Returns the value of the '<em><b>Offered Services</b></em>' containment reference list. The list contents are of
	 * type {@link org.unicase.model.component.ComponentService}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.component.ComponentService#getOfferingComponent <em>Offering Component</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offered Services</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Offered Services</em>' containment reference list.
	 * @see org.unicase.model.component.ComponentPackage#getComponent_OfferedServices()
	 * @see org.unicase.model.component.ComponentService#getOfferingComponent
	 * @model opposite="offeringComponent" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<ComponentService> getOfferedServices();

	/**
	 * Returns the value of the '<em><b>Consumed Services</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.component.ComponentService}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.component.ComponentService#getConsumingComponents <em>Consuming Components</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consumed Services</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Consumed Services</em>' reference list.
	 * @see org.unicase.model.component.ComponentPackage#getComponent_ConsumedServices()
	 * @see org.unicase.model.component.ComponentService#getConsumingComponents
	 * @model opposite="consumingComponents" keys="identifier"
	 * @generated
	 */
	EList<ComponentService> getConsumedServices();

	/**
	 * Returns the value of the '<em><b>Subsystems</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystems</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystems</em>' reference list.
	 * @see org.unicase.model.component.ComponentPackage#getComponent_Subsystems()
	 * @model
	 * @generated
	 */
	EList<org.unicase.model.classes.Package> getSubsystems();

} // Component
