/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.attachment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.attachment.*;
import org.unicase.model.attachment.AttachmentFactory;
import org.unicase.model.attachment.AttachmentPackage;
import org.unicase.model.attachment.FileAttachment;
import org.unicase.model.attachment.FileAttachmentType;
import org.unicase.model.attachment.PatchAttachment;
import org.unicase.model.attachment.UrlAttachment;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class AttachmentFactoryImpl extends EFactoryImpl implements AttachmentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static AttachmentFactory init() {
		try {
			AttachmentFactory theAttachmentFactory = (AttachmentFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/model/attachment");
			if (theAttachmentFactory != null) {
				return theAttachmentFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AttachmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AttachmentFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case AttachmentPackage.URL_ATTACHMENT:
			return createUrlAttachment();
		case AttachmentPackage.FILE_ATTACHMENT:
			return createFileAttachment();
		case AttachmentPackage.PATCH_ATTACHMENT:
			return createPatchAttachment();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case AttachmentPackage.FILE_ATTACHMENT_TYPE:
			return createFileAttachmentTypeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case AttachmentPackage.FILE_ATTACHMENT_TYPE:
			return convertFileAttachmentTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UrlAttachment createUrlAttachment() {
		UrlAttachmentImpl urlAttachment = new UrlAttachmentImpl();
		return urlAttachment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FileAttachment createFileAttachment() {
		FileAttachmentImpl fileAttachment = new FileAttachmentImpl();
		return fileAttachment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PatchAttachment createPatchAttachment() {
		PatchAttachmentImpl patchAttachment = new PatchAttachmentImpl();
		return patchAttachment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FileAttachmentType createFileAttachmentTypeFromString(EDataType eDataType, String initialValue) {
		FileAttachmentType result = FileAttachmentType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
				+ eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFileAttachmentTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AttachmentPackage getAttachmentPackage() {
		return (AttachmentPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AttachmentPackage getPackage() {
		return AttachmentPackage.eINSTANCE;
	}

} // AttachmentFactoryImpl
