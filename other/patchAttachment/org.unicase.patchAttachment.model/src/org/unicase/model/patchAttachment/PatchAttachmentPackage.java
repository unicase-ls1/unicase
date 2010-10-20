/**
 *  <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *  accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *  distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 *
 * $Id$
 */
package org.unicase.model.patchAttachment;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.unicase.model.attachment.AttachmentPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.patchAttachment.PatchAttachmentFactory
 * @model kind="package"
 * @generated
 */
public interface PatchAttachmentPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the\n accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this\n distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "patchAttachment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/patch";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.patch";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PatchAttachmentPackage eINSTANCE = org.unicase.model.patchAttachment.impl.PatchAttachmentPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.patchAttachment.impl.PatchAttachmentImpl <em>Patch Attachment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.patchAttachment.impl.PatchAttachmentImpl
	 * @see org.unicase.model.patchAttachment.impl.PatchAttachmentPackageImpl#getPatchAttachment()
	 * @generated
	 */
	int PATCH_ATTACHMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__NAME = AttachmentPackage.FILE_ATTACHMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__DESCRIPTION = AttachmentPackage.FILE_ATTACHMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__ANNOTATIONS = AttachmentPackage.FILE_ATTACHMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__ATTACHMENTS = AttachmentPackage.FILE_ATTACHMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__INCOMING_DOCUMENT_REFERENCES = AttachmentPackage.FILE_ATTACHMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__LEAF_SECTION = AttachmentPackage.FILE_ATTACHMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__STATE = AttachmentPackage.FILE_ATTACHMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES = AttachmentPackage.FILE_ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__COMMENTS = AttachmentPackage.FILE_ATTACHMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__CREATION_DATE = AttachmentPackage.FILE_ATTACHMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__CREATOR = AttachmentPackage.FILE_ATTACHMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__REFERRING_MODEL_ELEMENTS = AttachmentPackage.FILE_ATTACHMENT__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__FILE_NAME = AttachmentPackage.FILE_ATTACHMENT__FILE_NAME;

	/**
	 * The feature id for the '<em><b>File Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__FILE_HASH = AttachmentPackage.FILE_ATTACHMENT__FILE_HASH;

	/**
	 * The feature id for the '<em><b>File ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__FILE_ID = AttachmentPackage.FILE_ATTACHMENT__FILE_ID;

	/**
	 * The feature id for the '<em><b>File Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__FILE_SIZE = AttachmentPackage.FILE_ATTACHMENT__FILE_SIZE;

	/**
	 * The feature id for the '<em><b>Required Offline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__REQUIRED_OFFLINE = AttachmentPackage.FILE_ATTACHMENT__REQUIRED_OFFLINE;

	/**
	 * The feature id for the '<em><b>File Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__FILE_TYPE = AttachmentPackage.FILE_ATTACHMENT__FILE_TYPE;

	/**
	 * The feature id for the '<em><b>Uploading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__UPLOADING = AttachmentPackage.FILE_ATTACHMENT__UPLOADING;

	/**
	 * The feature id for the '<em><b>Downloading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT__DOWNLOADING = AttachmentPackage.FILE_ATTACHMENT__DOWNLOADING;

	/**
	 * The number of structural features of the '<em>Patch Attachment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATCH_ATTACHMENT_FEATURE_COUNT = AttachmentPackage.FILE_ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.patchAttachment.PatchAttachment <em>Patch Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Patch Attachment</em>'.
	 * @see org.unicase.model.patchAttachment.PatchAttachment
	 * @generated
	 */
	EClass getPatchAttachment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PatchAttachmentFactory getPatchAttachmentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.patchAttachment.impl.PatchAttachmentImpl <em>Patch Attachment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.patchAttachment.impl.PatchAttachmentImpl
		 * @see org.unicase.model.patchAttachment.impl.PatchAttachmentPackageImpl#getPatchAttachment()
		 * @generated
		 */
		EClass PATCH_ATTACHMENT = eINSTANCE.getPatchAttachment();

	}

} //PatchAttachmentPackage
