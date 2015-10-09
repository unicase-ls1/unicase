/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attachment</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.Attachment#getReferringModelElements <em>Referring Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getAttachment()
 * @model abstract="true"
 * @generated
 */
public interface Attachment extends UnicaseModelElement {
	/**
	 * Returns the value of the '<em><b>Referring Model Elements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.UnicaseModelElement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.UnicaseModelElement#getAttachments <em>Attachments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referring Model Elements</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referring Model Elements</em>' reference list.
	 * @see org.unicase.model.ModelPackage#getAttachment_ReferringModelElements()
	 * @see org.unicase.model.UnicaseModelElement#getAttachments
	 * @model opposite="attachments"
	 * @generated
	 */
	EList<UnicaseModelElement> getReferringModelElements();

} // Attachment
