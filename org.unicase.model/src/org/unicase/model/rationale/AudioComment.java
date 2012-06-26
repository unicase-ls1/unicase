/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.attachment.FileAttachment;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Audio Comment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.rationale.AudioComment#getAudioFile <em>Audio File</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.rationale.RationalePackage#getAudioComment()
 * @model
 * @generated
 */
public interface AudioComment extends EObject {
	/**
	 * Returns the value of the '<em><b>Audio File</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Audio File</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Audio File</em>' containment reference.
	 * @see #setAudioFile(FileAttachment)
	 * @see org.unicase.model.rationale.RationalePackage#getAudioComment_AudioFile()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	FileAttachment getAudioFile();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.AudioComment#getAudioFile <em>Audio File</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Audio File</em>' containment reference.
	 * @see #getAudioFile()
	 * @generated
	 */
	void setAudioFile(FileAttachment value);

} // AudioComment
