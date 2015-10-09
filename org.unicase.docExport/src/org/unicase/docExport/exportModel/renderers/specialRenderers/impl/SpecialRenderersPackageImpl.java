/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.docExport.exportModel.ExportModelPackage;
import org.unicase.docExport.exportModel.impl.ExportModelPackageImpl;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.impl.DefaultRenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.impl.RenderersPackageImpl;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.impl.OptionsPackageImpl;
import org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.FhmMeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class SpecialRenderersPackageImpl extends EPackageImpl implements SpecialRenderersPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meetingRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass milestoneRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepsAttributeRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageFlatRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classAttributesRendererEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fhmMeetingRendererEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SpecialRenderersPackageImpl() {
		super(eNS_URI, SpecialRenderersFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SpecialRenderersPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SpecialRenderersPackage init() {
		if (isInited) return (SpecialRenderersPackage)EPackage.Registry.INSTANCE.getEPackage(SpecialRenderersPackage.eNS_URI);

		// Obtain or create and register package
		SpecialRenderersPackageImpl theSpecialRenderersPackage = (SpecialRenderersPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SpecialRenderersPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SpecialRenderersPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ExportModelPackageImpl theExportModelPackage = (ExportModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExportModelPackage.eNS_URI) instanceof ExportModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExportModelPackage.eNS_URI) : ExportModelPackage.eINSTANCE);
		RenderersPackageImpl theRenderersPackage = (RenderersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RenderersPackage.eNS_URI) instanceof RenderersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RenderersPackage.eNS_URI) : RenderersPackage.eINSTANCE);
		DefaultRenderersPackageImpl theDefaultRenderersPackage = (DefaultRenderersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefaultRenderersPackage.eNS_URI) instanceof DefaultRenderersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefaultRenderersPackage.eNS_URI) : DefaultRenderersPackage.eINSTANCE);
		OptionsPackageImpl theOptionsPackage = (OptionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OptionsPackage.eNS_URI) instanceof OptionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OptionsPackage.eNS_URI) : OptionsPackage.eINSTANCE);

		// Create package meta-data objects
		theSpecialRenderersPackage.createPackageContents();
		theExportModelPackage.createPackageContents();
		theRenderersPackage.createPackageContents();
		theDefaultRenderersPackage.createPackageContents();
		theOptionsPackage.createPackageContents();

		// Initialize created meta-data
		theSpecialRenderersPackage.initializePackageContents();
		theExportModelPackage.initializePackageContents();
		theRenderersPackage.initializePackageContents();
		theDefaultRenderersPackage.initializePackageContents();
		theOptionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSpecialRenderersPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SpecialRenderersPackage.eNS_URI, theSpecialRenderersPackage);
		return theSpecialRenderersPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeetingRenderer() {
		return meetingRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMilestoneRenderer() {
		return milestoneRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStepsAttributeRenderer() {
		return stepsAttributeRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodRenderer() {
		return methodRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageFlatRenderer() {
		return packageFlatRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassRenderer() {
		return classRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassAttributesRenderer() {
		return classAttributesRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFhmMeetingRenderer() {
		return fhmMeetingRendererEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialRenderersFactory getSpecialRenderersFactory() {
		return (SpecialRenderersFactory)getEFactoryInstance();
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
		meetingRendererEClass = createEClass(MEETING_RENDERER);

		milestoneRendererEClass = createEClass(MILESTONE_RENDERER);

		stepsAttributeRendererEClass = createEClass(STEPS_ATTRIBUTE_RENDERER);

		methodRendererEClass = createEClass(METHOD_RENDERER);

		packageFlatRendererEClass = createEClass(PACKAGE_FLAT_RENDERER);

		classRendererEClass = createEClass(CLASS_RENDERER);

		classAttributesRendererEClass = createEClass(CLASS_ATTRIBUTES_RENDERER);

		fhmMeetingRendererEClass = createEClass(FHM_MEETING_RENDERER);
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
		RenderersPackage theRenderersPackage = (RenderersPackage)EPackage.Registry.INSTANCE.getEPackage(RenderersPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		meetingRendererEClass.getESuperTypes().add(theRenderersPackage.getModelElementRenderer());
		milestoneRendererEClass.getESuperTypes().add(theRenderersPackage.getModelElementRenderer());
		stepsAttributeRendererEClass.getESuperTypes().add(theRenderersPackage.getAttributeRenderer());
		methodRendererEClass.getESuperTypes().add(theRenderersPackage.getAttributeRenderer());
		packageFlatRendererEClass.getESuperTypes().add(theRenderersPackage.getModelElementRenderer());
		classRendererEClass.getESuperTypes().add(theRenderersPackage.getModelElementRenderer());
		classAttributesRendererEClass.getESuperTypes().add(theRenderersPackage.getAttributeRenderer());
		fhmMeetingRendererEClass.getESuperTypes().add(this.getMeetingRenderer());

		// Initialize classes and features; add operations and parameters
		initEClass(meetingRendererEClass, MeetingRenderer.class, "MeetingRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(milestoneRendererEClass, MilestoneRenderer.class, "MilestoneRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stepsAttributeRendererEClass, StepsAttributeRenderer.class, "StepsAttributeRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(methodRendererEClass, MethodRenderer.class, "MethodRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(packageFlatRendererEClass, PackageFlatRenderer.class, "PackageFlatRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classRendererEClass, ClassRenderer.class, "ClassRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classAttributesRendererEClass, ClassAttributesRenderer.class, "ClassAttributesRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fhmMeetingRendererEClass, FhmMeetingRenderer.class, "FhmMeetingRenderer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} // SpecialRenderersPackageImpl
