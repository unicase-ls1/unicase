/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.component;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Service</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.component.ComponentService#getOfferingComponent <em>Offering Component</em>}</li>
 *   <li>{@link org.unicase.model.component.ComponentService#getConsumingComponents <em>Consuming Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.component.ComponentPackage#getComponentService()
 * @model
 * @generated
 */
public interface ComponentService extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Offering Component</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.component.Component#getOfferedServices <em>Offered Services</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offering Component</em>' container reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Offering Component</em>' container reference.
	 * @see #setOfferingComponent(Component)
	 * @see org.unicase.model.component.ComponentPackage#getComponentService_OfferingComponent()
	 * @see org.unicase.model.component.Component#getOfferedServices
	 * @model opposite="offeredServices" keys="identifier" transient="false"
	 *        annotation="org.unicase.ui.meeditor priority='10.0' position='left'"
	 * @generated
	 */
	Component getOfferingComponent();

	/**
	 * Sets the value of the '{@link org.unicase.model.component.ComponentService#getOfferingComponent <em>Offering Component</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offering Component</em>' container reference.
	 * @see #getOfferingComponent()
	 * @generated
	 */
	void setOfferingComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Consuming Components</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.component.Component}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.component.Component#getConsumedServices <em>Consumed Services</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consuming Components</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Consuming Components</em>' reference list.
	 * @see org.unicase.model.component.ComponentPackage#getComponentService_ConsumingComponents()
	 * @see org.unicase.model.component.Component#getConsumedServices
	 * @model opposite="consumedServices" keys="identifier"
	 *        annotation="org.unicase.ui.meeditor priority='10.0' position='right'"
	 * @generated
	 */
	EList<Component> getConsumingComponents();

} // ComponentService
