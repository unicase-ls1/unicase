/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.impl.ExportModelPackageImpl;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultDocumentRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DefaultRenderersPackageImpl extends EPackageImpl implements DefaultRenderersPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass defaultModelElementRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass defaultAttributeRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass defaultDocumentRendererEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DefaultRenderersPackageImpl() {
		super(eNS_URI, DefaultRenderersFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * Simple dependencies are satisfied by calling this method on all dependent packages before doing anything else.
	 * This method drives initialization for interdependent packages directly, in parallel with this package, itself.
	 * <p>
	 * Of this package and its interdependencies, all packages which have not yet been registered by their URI values
	 * are first created and registered. The packages are then initialized in two steps: meta-model objects for all of
	 * the packages are created before any are initialized, since one package's meta-model objects may refer to those of
	 * another.
	 * <p>
	 * Invocation of this method will not affect any packages that have already been initialized. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DefaultRenderersPackage init() {
		if (isInited)
			return (DefaultRenderersPackage) EPackage.Registry.INSTANCE.getEPackage(DefaultRenderersPackage.eNS_URI);

		// Obtain or create and register package
		DefaultRenderersPackageImpl theDefaultRenderersPackage = (DefaultRenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI) instanceof DefaultRenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI) : new DefaultRenderersPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ExportModelPackageImpl theExportModelPackage = (ExportModelPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ExportModelPackage.eNS_URI) instanceof ExportModelPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ExportModelPackage.eNS_URI) : ExportModelPackage.eINSTANCE);
		RenderersPackageImpl theRenderersPackage = (RenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RenderersPackage.eNS_URI) instanceof RenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RenderersPackage.eNS_URI) : RenderersPackage.eINSTANCE);
		SpecialRenderersPackageImpl theSpecialRenderersPackage = (SpecialRenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(SpecialRenderersPackage.eNS_URI) instanceof SpecialRenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(SpecialRenderersPackage.eNS_URI)
			: SpecialRenderersPackage.eINSTANCE);
		OptionsPackageImpl theOptionsPackage = (OptionsPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(OptionsPackage.eNS_URI) instanceof OptionsPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(OptionsPackage.eNS_URI) : OptionsPackage.eINSTANCE);

		// Create package meta-data objects
		theDefaultRenderersPackage.createPackageContents();
		theExportModelPackage.createPackageContents();
		theRenderersPackage.createPackageContents();
		theSpecialRenderersPackage.createPackageContents();
		theOptionsPackage.createPackageContents();

		// Initialize created meta-data
		theDefaultRenderersPackage.initializePackageContents();
		theExportModelPackage.initializePackageContents();
		theRenderersPackage.initializePackageContents();
		theSpecialRenderersPackage.initializePackageContents();
		theOptionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDefaultRenderersPackage.freeze();

		return theDefaultRenderersPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefaultModelElementRenderer() {
		return defaultModelElementRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefaultAttributeRenderer() {
		return defaultAttributeRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefaultDocumentRenderer() {
		return defaultDocumentRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultRenderersFactory getDefaultRenderersFactory() {
		return (DefaultRenderersFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
	 * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		defaultModelElementRendererEClass = createEClass(DEFAULT_MODEL_ELEMENT_RENDERER);

		defaultAttributeRendererEClass = createEClass(DEFAULT_ATTRIBUTE_RENDERER);

		defaultDocumentRendererEClass = createEClass(DEFAULT_DOCUMENT_RENDERER);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
	 * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		RenderersPackage theRenderersPackage = (RenderersPackage) EPackage.Registry.INSTANCE
			.getEPackage(RenderersPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		defaultModelElementRendererEClass.getESuperTypes().add(theRenderersPackage.getModelElementRenderer());
		defaultAttributeRendererEClass.getESuperTypes().add(theRenderersPackage.getAttributeRenderer());
		defaultDocumentRendererEClass.getESuperTypes().add(theRenderersPackage.getDocumentRenderer());

		// Initialize classes and features; add operations and parameters
		initEClass(defaultModelElementRendererEClass, DefaultModelElementRenderer.class, "DefaultModelElementRenderer",
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultAttributeRendererEClass, DefaultAttributeRenderer.class, "DefaultAttributeRenderer",
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultDocumentRendererEClass, DefaultDocumentRenderer.class, "DefaultDocumentRenderer",
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} // DefaultRenderersPackageImpl
