/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.attachment;

import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.unicase.model.Attachment;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>File Attachment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.attachment.FileAttachment#getFileName <em>File Name</em>}</li>
 * <li>{@link org.unicase.model.attachment.FileAttachment#getFileHash <em>File Hash</em>}</li>
 * <li>{@link org.unicase.model.attachment.FileAttachment#getFileID <em>File ID</em>}</li>
 * <li>{@link org.unicase.model.attachment.FileAttachment#getFileSize <em>File Size</em>}</li>
 * <li>{@link org.unicase.model.attachment.FileAttachment#getFileType <em>File Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.attachment.AttachmentPackage#getFileAttachment()
 * @model
 * @generated
 */
public interface FileAttachment extends Attachment {
	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.unicase.model.attachment.AttachmentPackage#getFileAttachment_FileName()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='2' position='left'"
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.unicase.model.attachment.FileAttachment#getFileName <em>File Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>File Hash</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Hash</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>File Hash</em>' attribute.
	 * @see #setFileHash(String)
	 * @see org.unicase.model.attachment.AttachmentPackage#getFileAttachment_FileHash()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='2' position='left'"
	 * @generated
	 */
	String getFileHash();

	/**
	 * Sets the value of the '{@link org.unicase.model.attachment.FileAttachment#getFileHash <em>File Hash</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>File Hash</em>' attribute.
	 * @see #getFileHash()
	 * @generated
	 */
	void setFileHash(String value);

	/**
	 * Returns the value of the '<em><b>File ID</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File ID</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>File ID</em>' attribute.
	 * @see #setFileID(String)
	 * @see org.unicase.model.attachment.AttachmentPackage#getFileAttachment_FileID()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='2' position='left'"
	 * @generated
	 */
	@Deprecated
	String getFileID();

	/**
	 * Sets the value of the '{@link org.unicase.model.attachment.FileAttachment#getFileID <em>File ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>File ID</em>' attribute.
	 * @see #getFileID()
	 * @generated
	 */
	@Deprecated
	void setFileID(String value);

	/**
	 * Returns the value of the '<em><b>File Size</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Size</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>File Size</em>' attribute.
	 * @see #setFileSize(long)
	 * @see org.unicase.model.attachment.AttachmentPackage#getFileAttachment_FileSize()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='2' position='left'"
	 * @generated
	 */
	long getFileSize();

	/**
	 * Sets the value of the '{@link org.unicase.model.attachment.FileAttachment#getFileSize <em>File Size</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>File Size</em>' attribute.
	 * @see #getFileSize()
	 * @generated
	 */
	void setFileSize(long value);

	/**
	 * Returns the value of the '<em><b>File Type</b></em>' attribute. The literals are from the enumeration
	 * {@link org.unicase.model.attachment.FileAttachmentType}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Type</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>File Type</em>' attribute.
	 * @see org.unicase.model.attachment.FileAttachmentType
	 * @see #setFileType(FileAttachmentType)
	 * @see org.unicase.model.attachment.AttachmentPackage#getFileAttachment_FileType()
	 * @model
	 * @generated
	 */
	FileAttachmentType getFileType();

	/**
	 * Sets the value of the '{@link org.unicase.model.attachment.FileAttachment#getFileType <em>File Type</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>File Type</em>' attribute.
	 * @see org.unicase.model.attachment.FileAttachmentType
	 * @see #getFileType()
	 * @generated
	 */
	void setFileType(FileAttachmentType value);

	/**
	 * Returns the identifier of the file which can be used to retrieve the file itself This method is part of the new
	 * file api and should be used instead of the old getFileID
	 * 
	 * @return the file identifier
	 * @generated NOT
	 */
	FileIdentifier getFileIdentifier();

	/**
	 * Sets the file identifier of the attached file. This method is part of the new file API.
	 * 
	 * @param fileId the file id of the attached file
	 * @generated NOT
	 */
	void setFileIdentifier(FileIdentifier fileId);

} // FileAttachment
