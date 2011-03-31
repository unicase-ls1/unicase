/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Pending File Transfer</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getAttachmentId <em>Attachment Id</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getFileVersion <em>File Version</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getChunkNumber <em>Chunk Number</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#isUpload <em>Upload</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getPreliminaryFileName <em>Preliminary File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getPendingFileTransfer()
 * @model
 * @generated
 */
public interface PendingFileTransfer extends EObject {
	/**
	 * Returns the value of the '<em><b>Attachment Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachment Id</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment Id</em>' containment reference.
	 * @see #setAttachmentId(ModelElementId)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getPendingFileTransfer_AttachmentId()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getAttachmentId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getAttachmentId <em>Attachment Id</em>}' containment reference.
	 * <!-- begin-user-doc --> A null value indicates that the transfer
	 * is to be cancelled. <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment Id</em>' containment reference.
	 * @see #getAttachmentId()
	 * @generated
	 */
	void setAttachmentId(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>File Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Version</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Version</em>' attribute.
	 * @see #setFileVersion(int)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getPendingFileTransfer_FileVersion()
	 * @model
	 * @generated
	 */
	int getFileVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getFileVersion <em>File Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Version</em>' attribute.
	 * @see #getFileVersion()
	 * @generated
	 */
	void setFileVersion(int value);

	/**
	 * Returns the value of the '<em><b>Chunk Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chunk Number</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chunk Number</em>' attribute.
	 * @see #setChunkNumber(int)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getPendingFileTransfer_ChunkNumber()
	 * @model
	 * @generated
	 */
	int getChunkNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getChunkNumber <em>Chunk Number</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chunk Number</em>' attribute.
	 * @see #getChunkNumber()
	 * @generated
	 */
	void setChunkNumber(int value);

	/**
	 * Returns the value of the '<em><b>Upload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upload</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upload</em>' attribute.
	 * @see #setUpload(boolean)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getPendingFileTransfer_Upload()
	 * @model
	 * @generated
	 */
	boolean isUpload();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#isUpload <em>Upload</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upload</em>' attribute.
	 * @see #isUpload()
	 * @generated
	 */
	void setUpload(boolean value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getPendingFileTransfer_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Preliminary File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preliminary File Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preliminary File Name</em>' attribute.
	 * @see #setPreliminaryFileName(String)
	 * @see org.eclipse.emf.emfstore.client.model.ModelPackage#getPendingFileTransfer_PreliminaryFileName()
	 * @model
	 * @generated
	 */
	String getPreliminaryFileName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getPreliminaryFileName <em>Preliminary File Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preliminary File Name</em>' attribute.
	 * @see #getPreliminaryFileName()
	 * @generated
	 */
	void setPreliminaryFileName(String value);

} // PendingFileTransfer
