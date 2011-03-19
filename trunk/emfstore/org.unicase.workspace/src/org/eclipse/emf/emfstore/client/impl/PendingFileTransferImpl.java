/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.emfstore.client.PendingFileTransfer;
import org.eclipse.emf.emfstore.client.WorkspacePackage;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pending File Transfer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.client.impl.PendingFileTransferImpl#getAttachmentId <em>Attachment Id</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.client.impl.PendingFileTransferImpl#getFileVersion <em>File Version</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.client.impl.PendingFileTransferImpl#getChunkNumber <em>Chunk Number</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.client.impl.PendingFileTransferImpl#isUpload <em>Upload</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.client.impl.PendingFileTransferImpl#getFileName <em>File Name</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.client.impl.PendingFileTransferImpl#getPreliminaryFileName <em>Preliminary File Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PendingFileTransferImpl extends EObjectImpl implements PendingFileTransfer {
	/**
	 * The cached value of the '{@link #getAttachmentId() <em>Attachment Id</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAttachmentId()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId attachmentId;

	/**
	 * The default value of the '{@link #getFileVersion() <em>File Version</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFileVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int FILE_VERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFileVersion() <em>File Version</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFileVersion()
	 * @generated
	 * @ordered
	 */
	protected int fileVersion = FILE_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getChunkNumber() <em>Chunk Number</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getChunkNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int CHUNK_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getChunkNumber() <em>Chunk Number</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getChunkNumber()
	 * @generated
	 * @ordered
	 */
	protected int chunkNumber = CHUNK_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #isUpload() <em>Upload</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isUpload()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UPLOAD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUpload() <em>Upload</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isUpload()
	 * @generated
	 * @ordered
	 */
	protected boolean upload = UPLOAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPreliminaryFileName() <em>Preliminary File Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPreliminaryFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRELIMINARY_FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPreliminaryFileName() <em>Preliminary File Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPreliminaryFileName()
	 * @generated
	 * @ordered
	 */
	protected String preliminaryFileName = PRELIMINARY_FILE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PendingFileTransferImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.PENDING_FILE_TRANSFER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getAttachmentId() {
		if (attachmentId != null && attachmentId.eIsProxy()) {
			InternalEObject oldAttachmentId = (InternalEObject) attachmentId;
			attachmentId = (ModelElementId) eResolveProxy(oldAttachmentId);
			if (attachmentId != oldAttachmentId) {
				InternalEObject newAttachmentId = (InternalEObject) attachmentId;
				NotificationChain msgs = oldAttachmentId.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID, null, null);
				if (newAttachmentId.eInternalContainer() == null) {
					msgs = newAttachmentId.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
						WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID, oldAttachmentId, attachmentId));
			}
		}
		return attachmentId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId basicGetAttachmentId() {
		return attachmentId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetAttachmentId(ModelElementId newAttachmentId, NotificationChain msgs) {
		ModelElementId oldAttachmentId = attachmentId;
		attachmentId = newAttachmentId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID, oldAttachmentId, newAttachmentId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAttachmentId(ModelElementId newAttachmentId) {
		if (newAttachmentId != attachmentId) {
			NotificationChain msgs = null;
			if (attachmentId != null)
				msgs = ((InternalEObject) attachmentId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID, null, msgs);
			if (newAttachmentId != null)
				msgs = ((InternalEObject) newAttachmentId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID, null, msgs);
			msgs = basicSetAttachmentId(newAttachmentId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID, newAttachmentId, newAttachmentId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getFileVersion() {
		return fileVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFileVersion(int newFileVersion) {
		int oldFileVersion = fileVersion;
		fileVersion = newFileVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PENDING_FILE_TRANSFER__FILE_VERSION,
				oldFileVersion, fileVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getChunkNumber() {
		return chunkNumber;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setChunkNumber(int newChunkNumber) {
		int oldChunkNumber = chunkNumber;
		chunkNumber = newChunkNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PENDING_FILE_TRANSFER__CHUNK_NUMBER,
				oldChunkNumber, chunkNumber));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isUpload() {
		return upload;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUpload(boolean newUpload) {
		boolean oldUpload = upload;
		upload = newUpload;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PENDING_FILE_TRANSFER__UPLOAD,
				oldUpload, upload));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PENDING_FILE_TRANSFER__FILE_NAME,
				oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPreliminaryFileName() {
		return preliminaryFileName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPreliminaryFileName(String newPreliminaryFileName) {
		String oldPreliminaryFileName = preliminaryFileName;
		preliminaryFileName = newPreliminaryFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				WorkspacePackage.PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME, oldPreliminaryFileName,
				preliminaryFileName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID:
			return basicSetAttachmentId(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID:
			if (resolve)
				return getAttachmentId();
			return basicGetAttachmentId();
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_VERSION:
			return getFileVersion();
		case WorkspacePackage.PENDING_FILE_TRANSFER__CHUNK_NUMBER:
			return getChunkNumber();
		case WorkspacePackage.PENDING_FILE_TRANSFER__UPLOAD:
			return isUpload();
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_NAME:
			return getFileName();
		case WorkspacePackage.PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME:
			return getPreliminaryFileName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID:
			setAttachmentId((ModelElementId) newValue);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_VERSION:
			setFileVersion((Integer) newValue);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__CHUNK_NUMBER:
			setChunkNumber((Integer) newValue);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__UPLOAD:
			setUpload((Boolean) newValue);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_NAME:
			setFileName((String) newValue);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME:
			setPreliminaryFileName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID:
			setAttachmentId((ModelElementId) null);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_VERSION:
			setFileVersion(FILE_VERSION_EDEFAULT);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__CHUNK_NUMBER:
			setChunkNumber(CHUNK_NUMBER_EDEFAULT);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__UPLOAD:
			setUpload(UPLOAD_EDEFAULT);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_NAME:
			setFileName(FILE_NAME_EDEFAULT);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME:
			setPreliminaryFileName(PRELIMINARY_FILE_NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case WorkspacePackage.PENDING_FILE_TRANSFER__ATTACHMENT_ID:
			return attachmentId != null;
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_VERSION:
			return fileVersion != FILE_VERSION_EDEFAULT;
		case WorkspacePackage.PENDING_FILE_TRANSFER__CHUNK_NUMBER:
			return chunkNumber != CHUNK_NUMBER_EDEFAULT;
		case WorkspacePackage.PENDING_FILE_TRANSFER__UPLOAD:
			return upload != UPLOAD_EDEFAULT;
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_NAME:
			return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
		case WorkspacePackage.PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME:
			return PRELIMINARY_FILE_NAME_EDEFAULT == null ? preliminaryFileName != null
				: !PRELIMINARY_FILE_NAME_EDEFAULT.equals(preliminaryFileName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileVersion: ");
		result.append(fileVersion);
		result.append(", chunkNumber: ");
		result.append(chunkNumber);
		result.append(", upload: ");
		result.append(upload);
		result.append(", fileName: ");
		result.append(fileName);
		result.append(", preliminaryFileName: ");
		result.append(preliminaryFileName);
		result.append(')');
		return result.toString();
	}

} // PendingFileTransferImpl
