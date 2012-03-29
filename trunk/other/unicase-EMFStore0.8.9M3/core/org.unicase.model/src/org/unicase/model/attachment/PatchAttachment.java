/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.attachment;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.release.Release;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Patch Attachment</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.attachment.PatchAttachment#getAppliedTo <em>Applied To</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.attachment.AttachmentPackage#getPatchAttachment()
 * @model
 * @generated
 */
public interface PatchAttachment extends FileAttachment {
	/**
	 * Returns the value of the '<em><b>Applied To</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.release.Release}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.release.Release#getAppliedPatches <em>Applied Patches</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied To</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Applied To</em>' reference list.
	 * @see org.unicase.model.attachment.AttachmentPackage#getPatchAttachment_AppliedTo()
	 * @see org.unicase.model.release.Release#getAppliedPatches
	 * @model opposite="appliedPatches"
	 * @generated
	 */
	EList<Release> getAppliedTo();

} // PatchAttachment
