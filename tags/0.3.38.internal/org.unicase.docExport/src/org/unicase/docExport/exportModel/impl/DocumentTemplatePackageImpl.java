/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.docExport.exportModel.DocumentTemplateFactory;
import org.unicase.docExport.exportModel.DocumentTemplatePackage;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl;
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
public class DocumentTemplatePackageImpl extends EPackageImpl implements DocumentTemplatePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass templateEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.docExport.exportModel.DocumentTemplatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DocumentTemplatePackageImpl() {
		super(eNS_URI, DocumentTemplateFactory.eINSTANCE);
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
	public static DocumentTemplatePackage init() {
		if (isInited)
			return (DocumentTemplatePackage) EPackage.Registry.INSTANCE.getEPackage(DocumentTemplatePackage.eNS_URI);

		// Obtain or create and register package
		DocumentTemplatePackageImpl theDocumentTemplatePackage = (DocumentTemplatePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI) instanceof DocumentTemplatePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI) : new DocumentTemplatePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		RenderersPackageImpl theRenderersPackage = (RenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RenderersPackage.eNS_URI) instanceof RenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RenderersPackage.eNS_URI) : RenderersPackage.eINSTANCE);
		DefaultRenderersPackageImpl theDefaultRenderersPackage = (DefaultRenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DefaultRenderersPackage.eNS_URI) instanceof DefaultRenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DefaultRenderersPackage.eNS_URI)
			: DefaultRenderersPackage.eINSTANCE);
		SpecialRenderersPackageImpl theSpecialRenderersPackage = (SpecialRenderersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(SpecialRenderersPackage.eNS_URI) instanceof SpecialRenderersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(SpecialRenderersPackage.eNS_URI)
			: SpecialRenderersPackage.eINSTANCE);
		OptionsPackageImpl theOptionsPackage = (OptionsPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(OptionsPackage.eNS_URI) instanceof OptionsPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(OptionsPackage.eNS_URI) : OptionsPackage.eINSTANCE);

		// Create package meta-data objects
		theDocumentTemplatePackage.createPackageContents();
		theRenderersPackage.createPackageContents();
		theDefaultRenderersPackage.createPackageContents();
		theSpecialRenderersPackage.createPackageContents();
		theOptionsPackage.createPackageContents();

		// Initialize created meta-data
		theDocumentTemplatePackage.initializePackageContents();
		theRenderersPackage.initializePackageContents();
		theDefaultRenderersPackage.initializePackageContents();
		theSpecialRenderersPackage.initializePackageContents();
		theOptionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDocumentTemplatePackage.freeze();

		return theDocumentTemplatePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTemplate() {
		return templateEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTemplate_ModelElementRendererMapping() {
		return (EReference) templateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTemplate_LayoutOptions() {
		return (EReference) templateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTemplate_GlobalRendererOptions() {
		return (EReference) templateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTemplate_Name() {
		return (EAttribute) templateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DocumentTemplateFactory getDocumentTemplateFactory() {
		return (DocumentTemplateFactory) getEFactoryInstance();
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
		templateEClass = createEClass(TEMPLATE);
		createEReference(templateEClass, TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING);
		createEReference(templateEClass, TEMPLATE__LAYOUT_OPTIONS);
		createEReference(templateEClass, TEMPLATE__GLOBAL_RENDERER_OPTIONS);
		createEAttribute(templateEClass, TEMPLATE__NAME);
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
		OptionsPackage theOptionsPackage = (OptionsPackage) EPackage.Registry.INSTANCE
			.getEPackage(OptionsPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theRenderersPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(templateEClass, Template.class, "Template", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplate_ModelElementRendererMapping(), theRenderersPackage.getModelElementRendererMapping(),
			null, "modelElementRendererMapping", null, 0, -1, Template.class, !IS_TRANSIENT, !IS_VOLATILE,
			IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplate_LayoutOptions(), theOptionsPackage.getLayoutOptions(), null, "layoutOptions", null,
			0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplate_GlobalRendererOptions(), theOptionsPackage.getAttributeOption(), null,
			"globalRendererOptions", null, 0, -1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTemplate_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Template.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // DocumentTemplatePackageImpl
