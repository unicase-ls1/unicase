/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.model.changetracking.patch.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.model.attachment.FileAttachmentType;
import org.unicase.model.changetracking.impl.ChangePackageImpl;
import org.unicase.model.changetracking.patch.PatchChangePackage;
import org.unicase.model.changetracking.patch.PatchPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl#getFileHash <em>File Hash</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl#getFileID <em>File ID</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl#getFileSize <em>File Size</em>}</li>
 *   <li>{@link org.unicase.model.changetracking.patch.impl.PatchChangePackageImpl#getFileType <em>File Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatchChangePackageImpl extends ChangePackageImpl implements
		PatchChangePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileHash() <em>File Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileHash()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_HASH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileHash() <em>File Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileHash()
	 * @generated
	 * @ordered
	 */
	protected String fileHash = FILE_HASH_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileID() <em>File ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileID()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileID() <em>File ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileID()
	 * @generated
	 * @ordered
	 */
	protected String fileID = FILE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileSize() <em>File Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileSize()
	 * @generated
	 * @ordered
	 */
	protected static final long FILE_SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getFileSize() <em>File Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileSize()
	 * @generated
	 * @ordered
	 */
	protected long fileSize = FILE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileType() <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileType()
	 * @generated
	 * @ordered
	 */
	protected static final FileAttachmentType FILE_TYPE_EDEFAULT = FileAttachmentType.BINARY;

	/**
	 * The cached value of the '{@link #getFileType() <em>File Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileType()
	 * @generated
	 * @ordered
	 */
	protected FileAttachmentType fileType = FILE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatchChangePackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatchPackage.Literals.PATCH_CHANGE_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PatchPackage.PATCH_CHANGE_PACKAGE__FILE_NAME, oldFileName,
					fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileHash() {
		return fileHash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileHash(String newFileHash) {
		String oldFileHash = fileHash;
		fileHash = newFileHash;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PatchPackage.PATCH_CHANGE_PACKAGE__FILE_HASH, oldFileHash,
					fileHash));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileID() {
		return fileID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileID(String newFileID) {
		String oldFileID = fileID;
		fileID = newFileID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PatchPackage.PATCH_CHANGE_PACKAGE__FILE_ID, oldFileID,
					fileID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileSize(long newFileSize) {
		long oldFileSize = fileSize;
		fileSize = newFileSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PatchPackage.PATCH_CHANGE_PACKAGE__FILE_SIZE, oldFileSize,
					fileSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileAttachmentType getFileType() {
		return fileType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileType(FileAttachmentType newFileType) {
		FileAttachmentType oldFileType = fileType;
		fileType = newFileType == null ? FILE_TYPE_EDEFAULT : newFileType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PatchPackage.PATCH_CHANGE_PACKAGE__FILE_TYPE, oldFileType,
					fileType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_NAME:
			return getFileName();
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_HASH:
			return getFileHash();
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_ID:
			return getFileID();
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_SIZE:
			return getFileSize();
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_TYPE:
			return getFileType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_NAME:
			setFileName((String) newValue);
			return;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_HASH:
			setFileHash((String) newValue);
			return;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_ID:
			setFileID((String) newValue);
			return;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_SIZE:
			setFileSize((Long) newValue);
			return;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_TYPE:
			setFileType((FileAttachmentType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_NAME:
			setFileName(FILE_NAME_EDEFAULT);
			return;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_HASH:
			setFileHash(FILE_HASH_EDEFAULT);
			return;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_ID:
			setFileID(FILE_ID_EDEFAULT);
			return;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_SIZE:
			setFileSize(FILE_SIZE_EDEFAULT);
			return;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_TYPE:
			setFileType(FILE_TYPE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_NAME:
			return FILE_NAME_EDEFAULT == null ? fileName != null
					: !FILE_NAME_EDEFAULT.equals(fileName);
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_HASH:
			return FILE_HASH_EDEFAULT == null ? fileHash != null
					: !FILE_HASH_EDEFAULT.equals(fileHash);
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_ID:
			return FILE_ID_EDEFAULT == null ? fileID != null
					: !FILE_ID_EDEFAULT.equals(fileID);
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_SIZE:
			return fileSize != FILE_SIZE_EDEFAULT;
		case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_TYPE:
			return fileType != FILE_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FileAttachment.class) {
			switch (derivedFeatureID) {
			case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_NAME:
				return AttachmentPackage.FILE_ATTACHMENT__FILE_NAME;
			case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_HASH:
				return AttachmentPackage.FILE_ATTACHMENT__FILE_HASH;
			case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_ID:
				return AttachmentPackage.FILE_ATTACHMENT__FILE_ID;
			case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_SIZE:
				return AttachmentPackage.FILE_ATTACHMENT__FILE_SIZE;
			case PatchPackage.PATCH_CHANGE_PACKAGE__FILE_TYPE:
				return AttachmentPackage.FILE_ATTACHMENT__FILE_TYPE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FileAttachment.class) {
			switch (baseFeatureID) {
			case AttachmentPackage.FILE_ATTACHMENT__FILE_NAME:
				return PatchPackage.PATCH_CHANGE_PACKAGE__FILE_NAME;
			case AttachmentPackage.FILE_ATTACHMENT__FILE_HASH:
				return PatchPackage.PATCH_CHANGE_PACKAGE__FILE_HASH;
			case AttachmentPackage.FILE_ATTACHMENT__FILE_ID:
				return PatchPackage.PATCH_CHANGE_PACKAGE__FILE_ID;
			case AttachmentPackage.FILE_ATTACHMENT__FILE_SIZE:
				return PatchPackage.PATCH_CHANGE_PACKAGE__FILE_SIZE;
			case AttachmentPackage.FILE_ATTACHMENT__FILE_TYPE:
				return PatchPackage.PATCH_CHANGE_PACKAGE__FILE_TYPE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fileName: ");
		result.append(fileName);
		result.append(", fileHash: ");
		result.append(fileHash);
		result.append(", fileID: ");
		result.append(fileID);
		result.append(", fileSize: ");
		result.append(fileSize);
		result.append(", fileType: ");
		result.append(fileType);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.attachment.FileAttachment#getFileIdentifier()
	 */
	public FileIdentifier getFileIdentifier() {
		if (fileID == null) {
			return null;
		}
		FileIdentifier fid = EsmodelFactory.eINSTANCE.createFileIdentifier();
		fid.setIdentifier(fileID);
		return fid;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.attachment.FileAttachment#setFileIdentifier(org.unicase.emfstore.esmodel.FileIdentifier)
	 */
	public void setFileIdentifier(FileIdentifier fileId) {
		if (fileId == null) {
			setFileID(null);
		} else {
			setFileID(fileId.getIdentifier());
		}
	}

} //PatchChangePackageImpl
