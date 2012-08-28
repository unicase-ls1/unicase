/**
 *  <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *  accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *  distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 *
 * $Id$
 */
package org.unicase.model.patchAttachment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.unicase.model.patchAttachment.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PatchAttachmentFactoryImpl extends EFactoryImpl implements
		PatchAttachmentFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the\n accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this\n distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PatchAttachmentFactory init() {
		try {
			PatchAttachmentFactory thePatchAttachmentFactory = (PatchAttachmentFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/patch");
			if (thePatchAttachmentFactory != null) {
				return thePatchAttachmentFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PatchAttachmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatchAttachmentFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case PatchAttachmentPackage.PATCH_ATTACHMENT:
			return createPatchAttachment();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatchAttachment createPatchAttachment() {
		PatchAttachmentImpl patchAttachment = new PatchAttachmentImpl();
		return patchAttachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatchAttachmentPackage getPatchAttachmentPackage() {
		return (PatchAttachmentPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PatchAttachmentPackage getPackage() {
		return PatchAttachmentPackage.eINSTANCE;
	}

} //PatchAttachmentFactoryImpl
