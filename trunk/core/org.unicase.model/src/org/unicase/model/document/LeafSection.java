/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.document;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Leaf Section</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.document.LeafSection#getModelElements <em>Model Elements</em>}</li>
 * <li>{@link org.unicase.model.document.LeafSection#getReferencedModelElements <em>Referenced Model Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.document.DocumentPackage#getLeafSection()
 * @model
 * @generated
 */
public interface LeafSection extends Section {
	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' containment reference list. The list contents are of
	 * type {@link org.eclipse.emf.ecore.EObject}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.unicase.model.document.DocumentPackage#getLeafSection_ModelElements()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='20.0' position='right'"
	 * @generated
	 */
	EList<EObject> getModelElements();

	/**
	 * Returns the value of the '<em><b>Referenced Model Elements</b></em>' reference list. The list contents are of
	 * type {@link org.eclipse.emf.ecore.EObject}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Model Elements</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referenced Model Elements</em>' reference list.
	 * @see org.unicase.model.document.DocumentPackage#getLeafSection_ReferencedModelElements()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='21.0' position='right'"
	 * @generated
	 */
	EList<EObject> getReferencedModelElements();

} // LeafSection
