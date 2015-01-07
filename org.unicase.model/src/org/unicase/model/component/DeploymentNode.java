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
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Node</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.component.DeploymentNode#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.component.ComponentPackage#getDeploymentNode()
 * @model
 * @generated
 */
public interface DeploymentNode extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.component.Component}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see org.unicase.model.component.ComponentPackage#getDeploymentNode_Components()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='10.0' position='right'"
	 * @generated
	 */
	EList<Component> getComponents();

} // Node
