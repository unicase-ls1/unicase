/**
 *  <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *  accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *  distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 *
 * $Id$
 */
package org.unicase.model.patchAttachment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.model.ModelPackage;

import org.unicase.model.attachment.AttachmentPackage;

import org.unicase.model.patchAttachment.PatchAttachment;
import org.unicase.model.patchAttachment.PatchAttachmentFactory;
import org.unicase.model.patchAttachment.PatchAttachmentPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PatchAttachmentPackageImpl extends EPackageImpl implements
		PatchAttachmentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the\n accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this\n distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patchAttachmentEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.patchAttachment.PatchAttachmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PatchAttachmentPackageImpl() {
		super(eNS_URI, PatchAttachmentFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PatchAttachmentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PatchAttachmentPackage init() {
		if (isInited)
			return (PatchAttachmentPackage) EPackage.Registry.INSTANCE
					.getEPackage(PatchAttachmentPackage.eNS_URI);

		// Obtain or create and register package
		PatchAttachmentPackageImpl thePatchAttachmentPackage = (PatchAttachmentPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof PatchAttachmentPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI)
				: new PatchAttachmentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePatchAttachmentPackage.createPackageContents();

		// Initialize created meta-data
		thePatchAttachmentPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePatchAttachmentPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PatchAttachmentPackage.eNS_URI,
				thePatchAttachmentPackage);
		return thePatchAttachmentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatchAttachment() {
		return patchAttachmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatchAttachmentFactory getPatchAttachmentFactory() {
		return (PatchAttachmentFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		patchAttachmentEClass = createEClass(PATCH_ATTACHMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		AttachmentPackage theAttachmentPackage = (AttachmentPackage) EPackage.Registry.INSTANCE
				.getEPackage(AttachmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		patchAttachmentEClass.getESuperTypes().add(
				theAttachmentPackage.getFileAttachment());

		// Initialize classes and features; add operations and parameters
		initEClass(patchAttachmentEClass, PatchAttachment.class,
				"PatchAttachment", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PatchAttachmentPackageImpl
