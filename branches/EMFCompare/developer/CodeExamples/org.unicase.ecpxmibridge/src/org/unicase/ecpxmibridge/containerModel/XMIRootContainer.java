/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpxmibridge.containerModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMI Root Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.ecpxmibridge.containerModel.XMIRootContainer#getContents <em>Contents</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.ecpxmibridge.containerModel.ContainerModelPackage#getXMIRootContainer()
 * @model
 * @generated
 */
public interface XMIRootContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Contents</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contents</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contents</em>' containment reference list.
	 * @see org.unicase.ecpxmibridge.containerModel.ContainerModelPackage#getXMIRootContainer_Contents()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<EObject> getContents();

} // XMIRootContainer
