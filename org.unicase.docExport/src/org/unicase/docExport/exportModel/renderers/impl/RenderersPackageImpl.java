/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.impl.ExportModelPackageImpl;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.DocumentRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.RenderersFactory;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class RenderersPackageImpl extends EPackageImpl implements RenderersPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementRendererMappingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeRendererMappingEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RenderersPackageImpl() {
		super(eNS_URI, RenderersFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link RenderersPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RenderersPackage init() {
		if (isInited) return (RenderersPackage)EPackage.Registry.INSTANCE.getEPackage(RenderersPackage.eNS_URI);

		// Obtain or create and register package
		RenderersPackageImpl theRenderersPackage = (RenderersPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RenderersPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RenderersPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ExportModelPackageImpl theExportModelPackage = (ExportModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExportModelPackage.eNS_URI) instanceof ExportModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExportModelPackage.eNS_URI) : ExportModelPackage.eINSTANCE);
		DefaultRenderersPackageImpl theDefaultRenderersPackage = (DefaultRenderersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefaultRenderersPackage.eNS_URI) instanceof DefaultRenderersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefaultRenderersPackage.eNS_URI) : DefaultRenderersPackage.eINSTANCE);
		SpecialRenderersPackageImpl theSpecialRenderersPackage = (SpecialRenderersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SpecialRenderersPackage.eNS_URI) instanceof SpecialRenderersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SpecialRenderersPackage.eNS_URI) : SpecialRenderersPackage.eINSTANCE);
		OptionsPackageImpl theOptionsPackage = (OptionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OptionsPackage.eNS_URI) instanceof OptionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OptionsPackage.eNS_URI) : OptionsPackage.eINSTANCE);

		// Create package meta-data objects
		theRenderersPackage.createPackageContents();
		theExportModelPackage.createPackageContents();
		theDefaultRenderersPackage.createPackageContents();
		theSpecialRenderersPackage.createPackageContents();
		theOptionsPackage.createPackageContents();

		// Initialize created meta-data
		theRenderersPackage.initializePackageContents();
		theExportModelPackage.initializePackageContents();
		theDefaultRenderersPackage.initializePackageContents();
		theSpecialRenderersPackage.initializePackageContents();
		theOptionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRenderersPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RenderersPackage.eNS_URI, theRenderersPackage);
		return theRenderersPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementRenderer() {
		return modelElementRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementRenderer_RendererOptions() {
		return (EReference)modelElementRendererEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementRenderer_Template() {
		return (EReference)modelElementRendererEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementRenderer_AttributeRendererMapping() {
		return (EReference)modelElementRendererEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeRenderer() {
		return attributeRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeRenderer_AttributeOption() {
		return (EReference)attributeRendererEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRenderer() {
		return documentRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementRendererMapping() {
		return modelElementRendererMappingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementRendererMapping_Renderer() {
		return (EReference)modelElementRendererMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementRendererMapping_EClassName() {
		return (EAttribute)modelElementRendererMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeRendererMapping() {
		return attributeRendererMappingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeRendererMapping_AttributeRenderer() {
		return (EReference)attributeRendererMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeRendererMapping_FeatureName() {
		return (EAttribute)attributeRendererMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RenderersFactory getRenderersFactory() {
		return (RenderersFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modelElementRendererEClass = createEClass(MODEL_ELEMENT_RENDERER);
		createEReference(modelElementRendererEClass, MODEL_ELEMENT_RENDERER__RENDERER_OPTIONS);
		createEReference(modelElementRendererEClass, MODEL_ELEMENT_RENDERER__TEMPLATE);
		createEReference(modelElementRendererEClass, MODEL_ELEMENT_RENDERER__ATTRIBUTE_RENDERER_MAPPING);

		attributeRendererEClass = createEClass(ATTRIBUTE_RENDERER);
		createEReference(attributeRendererEClass, ATTRIBUTE_RENDERER__ATTRIBUTE_OPTION);

		documentRendererEClass = createEClass(DOCUMENT_RENDERER);

		modelElementRendererMappingEClass = createEClass(MODEL_ELEMENT_RENDERER_MAPPING);
		createEReference(modelElementRendererMappingEClass, MODEL_ELEMENT_RENDERER_MAPPING__RENDERER);
		createEAttribute(modelElementRendererMappingEClass, MODEL_ELEMENT_RENDERER_MAPPING__ECLASS_NAME);

		attributeRendererMappingEClass = createEClass(ATTRIBUTE_RENDERER_MAPPING);
		createEReference(attributeRendererMappingEClass, ATTRIBUTE_RENDERER_MAPPING__ATTRIBUTE_RENDERER);
		createEAttribute(attributeRendererMappingEClass, ATTRIBUTE_RENDERER_MAPPING__FEATURE_NAME);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DefaultRenderersPackage theDefaultRenderersPackage = (DefaultRenderersPackage)EPackage.Registry.INSTANCE.getEPackage(DefaultRenderersPackage.eNS_URI);
		SpecialRenderersPackage theSpecialRenderersPackage = (SpecialRenderersPackage)EPackage.Registry.INSTANCE.getEPackage(SpecialRenderersPackage.eNS_URI);
		OptionsPackage theOptionsPackage = (OptionsPackage)EPackage.Registry.INSTANCE.getEPackage(OptionsPackage.eNS_URI);
		ExportModelPackage theExportModelPackage = (ExportModelPackage)EPackage.Registry.INSTANCE.getEPackage(ExportModelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theDefaultRenderersPackage);
		getESubpackages().add(theSpecialRenderersPackage);
		getESubpackages().add(theOptionsPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(modelElementRendererEClass, ModelElementRenderer.class, "ModelElementRenderer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementRenderer_RendererOptions(), theOptionsPackage.getRendererOption(), null, "rendererOptions", null, 0, -1, ModelElementRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementRenderer_Template(), theExportModelPackage.getTemplate(), null, "template", null, 0, 1, ModelElementRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementRenderer_AttributeRendererMapping(), this.getAttributeRendererMapping(), null, "attributeRendererMapping", null, 0, -1, ModelElementRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeRendererEClass, AttributeRenderer.class, "AttributeRenderer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeRenderer_AttributeOption(), theOptionsPackage.getAttributeOption(), null, "attributeOption", null, 0, 1, AttributeRenderer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRendererEClass, DocumentRenderer.class, "DocumentRenderer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelElementRendererMappingEClass, ModelElementRendererMapping.class, "ModelElementRendererMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementRendererMapping_Renderer(), this.getModelElementRenderer(), null, "renderer", null, 0, 1, ModelElementRendererMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelElementRendererMapping_EClassName(), ecorePackage.getEString(), "eClassName", null, 0, 1, ModelElementRendererMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeRendererMappingEClass, AttributeRendererMapping.class, "AttributeRendererMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeRendererMapping_AttributeRenderer(), this.getAttributeRenderer(), null, "attributeRenderer", null, 0, 1, AttributeRendererMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeRendererMapping_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, AttributeRendererMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} // RenderersPackageImpl
