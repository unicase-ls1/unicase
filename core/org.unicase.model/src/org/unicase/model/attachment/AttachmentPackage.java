/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.attachment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.attachment.AttachmentFactory
 * @model kind="package"
 * @generated
 */
public interface AttachmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "attachment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/attachment";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.attachment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	AttachmentPackage eINSTANCE = org.unicase.model.attachment.impl.AttachmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.attachment.impl.UrlAttachmentImpl <em>Url Attachment</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.attachment.impl.UrlAttachmentImpl
	 * @see org.unicase.model.attachment.impl.AttachmentPackageImpl#getUrlAttachment()
	 * @generated
	 */
	int URL_ATTACHMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__NAME = ModelPackage.ATTACHMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__DESCRIPTION = ModelPackage.ATTACHMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__ANNOTATIONS = ModelPackage.ATTACHMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__ATTACHMENTS = ModelPackage.ATTACHMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__INCOMING_DOCUMENT_REFERENCES = ModelPackage.ATTACHMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__LEAF_SECTION = ModelPackage.ATTACHMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__STATE = ModelPackage.ATTACHMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__COMMENTS = ModelPackage.ATTACHMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__CREATOR = ModelPackage.ATTACHMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__CREATION_DATE = ModelPackage.ATTACHMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__REFERRING_MODEL_ELEMENTS = ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT__URL = ModelPackage.ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Url Attachment</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URL_ATTACHMENT_FEATURE_COUNT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.attachment.impl.FileAttachmentImpl <em>File Attachment</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.attachment.impl.FileAttachmentImpl
	 * @see org.unicase.model.attachment.impl.AttachmentPackageImpl#getFileAttachment()
	 * @generated
	 */
	int FILE_ATTACHMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__NAME = ModelPackage.ATTACHMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__DESCRIPTION = ModelPackage.ATTACHMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__ANNOTATIONS = ModelPackage.ATTACHMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__ATTACHMENTS = ModelPackage.ATTACHMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__INCOMING_DOCUMENT_REFERENCES = ModelPackage.ATTACHMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__LEAF_SECTION = ModelPackage.ATTACHMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__STATE = ModelPackage.ATTACHMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.ATTACHMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__COMMENTS = ModelPackage.ATTACHMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__CREATOR = ModelPackage.ATTACHMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__CREATION_DATE = ModelPackage.ATTACHMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__REFERRING_MODEL_ELEMENTS = ModelPackage.ATTACHMENT__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__FILE_NAME = ModelPackage.ATTACHMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File Hash</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__FILE_HASH = ModelPackage.ATTACHMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>File ID</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__FILE_ID = ModelPackage.ATTACHMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>File Size</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__FILE_SIZE = ModelPackage.ATTACHMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Required Offline</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__REQUIRED_OFFLINE = ModelPackage.ATTACHMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>File Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__FILE_TYPE = ModelPackage.ATTACHMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Uploading</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__UPLOADING = ModelPackage.ATTACHMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Downloading</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT__DOWNLOADING = ModelPackage.ATTACHMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>File Attachment</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_ATTACHMENT_FEATURE_COUNT = ModelPackage.ATTACHMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.unicase.model.attachment.FileAttachmentType <em>File Attachment Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.model.attachment.FileAttachmentType
	 * @see org.unicase.model.attachment.impl.AttachmentPackageImpl#getFileAttachmentType()
	 * @generated
	 */
	int FILE_ATTACHMENT_TYPE = 2;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.attachment.UrlAttachment <em>Url Attachment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Url Attachment</em>'.
	 * @see org.unicase.model.attachment.UrlAttachment
	 * @generated
	 */
	EClass getUrlAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.UrlAttachment#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.unicase.model.attachment.UrlAttachment#getUrl()
	 * @see #getUrlAttachment()
	 * @generated
	 */
	EAttribute getUrlAttachment_Url();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.attachment.FileAttachment <em>File Attachment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Attachment</em>'.
	 * @see org.unicase.model.attachment.FileAttachment
	 * @generated
	 */
	EClass getFileAttachment();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.FileAttachment#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.unicase.model.attachment.FileAttachment#getFileName()
	 * @see #getFileAttachment()
	 * @generated
	 */
	EAttribute getFileAttachment_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.FileAttachment#getFileHash <em>File Hash</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Hash</em>'.
	 * @see org.unicase.model.attachment.FileAttachment#getFileHash()
	 * @see #getFileAttachment()
	 * @generated
	 */
	EAttribute getFileAttachment_FileHash();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.FileAttachment#getFileID <em>File ID</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File ID</em>'.
	 * @see org.unicase.model.attachment.FileAttachment#getFileID()
	 * @see #getFileAttachment()
	 * @generated
	 */
	EAttribute getFileAttachment_FileID();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.FileAttachment#getFileSize <em>File Size</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Size</em>'.
	 * @see org.unicase.model.attachment.FileAttachment#getFileSize()
	 * @see #getFileAttachment()
	 * @generated
	 */
	EAttribute getFileAttachment_FileSize();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.FileAttachment#isRequiredOffline <em>Required Offline</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required Offline</em>'.
	 * @see org.unicase.model.attachment.FileAttachment#isRequiredOffline()
	 * @see #getFileAttachment()
	 * @generated
	 */
	EAttribute getFileAttachment_RequiredOffline();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.FileAttachment#getFileType <em>File Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Type</em>'.
	 * @see org.unicase.model.attachment.FileAttachment#getFileType()
	 * @see #getFileAttachment()
	 * @generated
	 */
	EAttribute getFileAttachment_FileType();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.FileAttachment#isDownloading <em>Downloading</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Downloading</em>'.
	 * @see org.unicase.model.attachment.FileAttachment#isDownloading()
	 * @see #getFileAttachment()
	 * @generated
	 */
	EAttribute getFileAttachment_Downloading();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.attachment.FileAttachment#isUploading <em>Uploading</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uploading</em>'.
	 * @see org.unicase.model.attachment.FileAttachment#isUploading()
	 * @see #getFileAttachment()
	 * @generated
	 */
	EAttribute getFileAttachment_Uploading();

	/**
	 * Returns the meta object for enum '{@link org.unicase.model.attachment.FileAttachmentType <em>File Attachment Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>File Attachment Type</em>'.
	 * @see org.unicase.model.attachment.FileAttachmentType
	 * @generated
	 */
	EEnum getFileAttachmentType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AttachmentFactory getAttachmentFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.attachment.impl.UrlAttachmentImpl <em>Url Attachment</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.attachment.impl.UrlAttachmentImpl
		 * @see org.unicase.model.attachment.impl.AttachmentPackageImpl#getUrlAttachment()
		 * @generated
		 */
		EClass URL_ATTACHMENT = eINSTANCE.getUrlAttachment();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute URL_ATTACHMENT__URL = eINSTANCE.getUrlAttachment_Url();

		/**
		 * The meta object literal for the '{@link org.unicase.model.attachment.impl.FileAttachmentImpl <em>File Attachment</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.attachment.impl.FileAttachmentImpl
		 * @see org.unicase.model.attachment.impl.AttachmentPackageImpl#getFileAttachment()
		 * @generated
		 */
		EClass FILE_ATTACHMENT = eINSTANCE.getFileAttachment();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTACHMENT__FILE_NAME = eINSTANCE.getFileAttachment_FileName();

		/**
		 * The meta object literal for the '<em><b>File Hash</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTACHMENT__FILE_HASH = eINSTANCE.getFileAttachment_FileHash();

		/**
		 * The meta object literal for the '<em><b>File ID</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTACHMENT__FILE_ID = eINSTANCE.getFileAttachment_FileID();

		/**
		 * The meta object literal for the '<em><b>File Size</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTACHMENT__FILE_SIZE = eINSTANCE.getFileAttachment_FileSize();

		/**
		 * The meta object literal for the '<em><b>Required Offline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTACHMENT__REQUIRED_OFFLINE = eINSTANCE.getFileAttachment_RequiredOffline();

		/**
		 * The meta object literal for the '<em><b>File Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTACHMENT__FILE_TYPE = eINSTANCE.getFileAttachment_FileType();

		/**
		 * The meta object literal for the '<em><b>Downloading</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTACHMENT__DOWNLOADING = eINSTANCE.getFileAttachment_Downloading();

		/**
		 * The meta object literal for the '<em><b>Uploading</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_ATTACHMENT__UPLOADING = eINSTANCE.getFileAttachment_Uploading();

		/**
		 * The meta object literal for the '{@link org.unicase.model.attachment.FileAttachmentType <em>File Attachment Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.model.attachment.FileAttachmentType
		 * @see org.unicase.model.attachment.impl.AttachmentPackageImpl#getFileAttachmentType()
		 * @generated
		 */
		EEnum FILE_ATTACHMENT_TYPE = eINSTANCE.getFileAttachmentType();

	}

} // AttachmentPackage
