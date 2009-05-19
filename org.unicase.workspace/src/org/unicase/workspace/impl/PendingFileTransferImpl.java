/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.PendingFileTransfer;
import org.unicase.workspace.WorkspacePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Pending File Transfer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.workspace.impl.PendingFileTransferImpl#getAttachmentId <em>Attachment Id</em>}</li>
 * <li>{@link org.unicase.workspace.impl.PendingFileTransferImpl#getFileVersion <em>File Version</em>}</li>
 * <li>{@link org.unicase.workspace.impl.PendingFileTransferImpl#getFilePath <em>File Path</em>}</li>
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
	protected static final String FILE_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileVersion() <em>File Version</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFileVersion()
	 * @generated
	 * @ordered
	 */
	protected String fileVersion = FILE_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilePath() <em>File Path</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFilePath()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilePath() <em>File Path</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getFilePath()
	 * @generated
	 * @ordered
	 */
	protected String filePath = FILE_PATH_EDEFAULT;

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
	public String getFileVersion() {
		return fileVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFileVersion(String newFileVersion) {
		String oldFileVersion = fileVersion;
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
	public String getFilePath() {
		return filePath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFilePath(String newFilePath) {
		String oldFilePath = filePath;
		filePath = newFilePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkspacePackage.PENDING_FILE_TRANSFER__FILE_PATH,
				oldFilePath, filePath));
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
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_PATH:
			return getFilePath();
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
			setFileVersion((String) newValue);
			return;
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_PATH:
			setFilePath((String) newValue);
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
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_PATH:
			setFilePath(FILE_PATH_EDEFAULT);
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
			return FILE_VERSION_EDEFAULT == null ? fileVersion != null : !FILE_VERSION_EDEFAULT.equals(fileVersion);
		case WorkspacePackage.PENDING_FILE_TRANSFER__FILE_PATH:
			return FILE_PATH_EDEFAULT == null ? filePath != null : !FILE_PATH_EDEFAULT.equals(filePath);
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
		result.append(", filePath: ");
		result.append(filePath);
		result.append(')');
		return result.toString();
	}

} // PendingFileTransferImpl
