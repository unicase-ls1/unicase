/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.document;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Leaf Section</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.document.LeafSection#getModelElements <em>Model Elements</em>}</li>
 *   <li>{@link org.unicase.model.document.LeafSection#getReferencedModelElements <em>Referenced Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.document.DocumentPackage#getLeafSection()
 * @model
 * @generated
 */
public interface LeafSection extends Section {
	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.ModelElement#getLeafSection <em>Leaf Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.unicase.model.document.DocumentPackage#getLeafSection_ModelElements()
	 * @see org.unicase.model.ModelElement#getLeafSection
	 * @model opposite="leafSection" containment="true" keys="identifier"
	 * @generated
	 */
	EList<ModelElement> getModelElements();

	/**
	 * Returns the value of the '<em><b>Referenced Model Elements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.ModelElement#getIncomingDocumentReferences <em>Incoming Document References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Model Elements</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Model Elements</em>' reference list.
	 * @see org.unicase.model.document.DocumentPackage#getLeafSection_ReferencedModelElements()
	 * @see org.unicase.model.ModelElement#getIncomingDocumentReferences
	 * @model opposite="incomingDocumentReferences" keys="identifier"
	 * @generated
	 */
	EList<ModelElement> getReferencedModelElements();

} // LeafSection
