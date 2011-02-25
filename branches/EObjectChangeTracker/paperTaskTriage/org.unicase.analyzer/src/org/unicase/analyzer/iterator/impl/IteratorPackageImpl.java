/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.analyzer.AnalyzerPackage;
import org.unicase.analyzer.exporters.ExportersPackage;
import org.unicase.analyzer.exporters.impl.ExportersPackageImpl;
import org.unicase.analyzer.impl.AnalyzerPackageImpl;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class IteratorPackageImpl extends EPackageImpl implements IteratorPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionIteratorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timeIteratorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionSpecQueryEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.analyzer.iterator.IteratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IteratorPackageImpl() {
		super(eNS_URI, IteratorFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IteratorPackage init() {
		if (isInited) return (IteratorPackage)EPackage.Registry.INSTANCE.getEPackage(IteratorPackage.eNS_URI);

		// Obtain or create and register package
		IteratorPackageImpl theIteratorPackage = (IteratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof IteratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new IteratorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EsmodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AnalyzerPackageImpl theAnalyzerPackage = (AnalyzerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnalyzerPackage.eNS_URI) instanceof AnalyzerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnalyzerPackage.eNS_URI) : AnalyzerPackage.eINSTANCE);
		ExportersPackageImpl theExportersPackage = (ExportersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExportersPackage.eNS_URI) instanceof ExportersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExportersPackage.eNS_URI) : ExportersPackage.eINSTANCE);

		// Create package meta-data objects
		theIteratorPackage.createPackageContents();
		theAnalyzerPackage.createPackageContents();
		theExportersPackage.createPackageContents();

		// Initialize created meta-data
		theIteratorPackage.initializePackageContents();
		theAnalyzerPackage.initializePackageContents();
		theExportersPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIteratorPackage.freeze();

		return theIteratorPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionIterator() {
		return versionIteratorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionIterator_StepLength() {
		return (EAttribute)versionIteratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersionIterator_ProjectId() {
		return (EReference)versionIteratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionIterator_Forward() {
		return (EAttribute)versionIteratorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionIterator_ReturnProjectDataCopy() {
		return (EAttribute)versionIteratorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersionIterator_VersionSpecQuery() {
		return (EReference)versionIteratorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVersionIterator_Default() {
		return (EAttribute)versionIteratorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimeIterator() {
		return timeIteratorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeIterator_StartDate() {
		return (EAttribute)timeIteratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeIterator_EndDate() {
		return (EAttribute)timeIteratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimeIterator_StepLengthUnit() {
		return (EAttribute)timeIteratorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVersionSpecQuery() {
		return versionSpecQueryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersionSpecQuery_EndVersion() {
		return (EReference)versionSpecQueryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVersionSpecQuery_StartVersion() {
		return (EReference)versionSpecQueryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorFactory getIteratorFactory() {
		return (IteratorFactory)getEFactoryInstance();
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
		versionIteratorEClass = createEClass(VERSION_ITERATOR);
		createEAttribute(versionIteratorEClass, VERSION_ITERATOR__STEP_LENGTH);
		createEReference(versionIteratorEClass, VERSION_ITERATOR__PROJECT_ID);
		createEAttribute(versionIteratorEClass, VERSION_ITERATOR__FORWARD);
		createEAttribute(versionIteratorEClass, VERSION_ITERATOR__RETURN_PROJECT_DATA_COPY);
		createEReference(versionIteratorEClass, VERSION_ITERATOR__VERSION_SPEC_QUERY);
		createEAttribute(versionIteratorEClass, VERSION_ITERATOR__DEFAULT);

		timeIteratorEClass = createEClass(TIME_ITERATOR);
		createEAttribute(timeIteratorEClass, TIME_ITERATOR__START_DATE);
		createEAttribute(timeIteratorEClass, TIME_ITERATOR__END_DATE);
		createEAttribute(timeIteratorEClass, TIME_ITERATOR__STEP_LENGTH_UNIT);

		versionSpecQueryEClass = createEClass(VERSION_SPEC_QUERY);
		createEReference(versionSpecQueryEClass, VERSION_SPEC_QUERY__END_VERSION);
		createEReference(versionSpecQueryEClass, VERSION_SPEC_QUERY__START_VERSION);
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
		EsmodelPackage theEsmodelPackage = (EsmodelPackage)EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		VersioningPackage theVersioningPackage = (VersioningPackage)EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		timeIteratorEClass.getESuperTypes().add(this.getVersionIterator());

		// Initialize classes and features; add operations and parameters
		initEClass(versionIteratorEClass, VersionIterator.class, "VersionIterator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionIterator_StepLength(), ecorePackage.getEInt(), "stepLength", null, 0, 1, VersionIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersionIterator_ProjectId(), theEsmodelPackage.getProjectId(), null, "projectId", null, 0, 1, VersionIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionIterator_Forward(), ecorePackage.getEBoolean(), "forward", null, 0, 1, VersionIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionIterator_ReturnProjectDataCopy(), theEcorePackage.getEBoolean(), "returnProjectDataCopy", null, 0, 1, VersionIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersionIterator_VersionSpecQuery(), this.getVersionSpecQuery(), null, "versionSpecQuery", null, 0, 1, VersionIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersionIterator_Default(), theEcorePackage.getEBoolean(), "default", null, 0, 1, VersionIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeIteratorEClass, TimeIterator.class, "TimeIterator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeIterator_StartDate(), ecorePackage.getEDate(), "startDate", null, 0, 1, TimeIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeIterator_EndDate(), ecorePackage.getEDate(), "endDate", null, 0, 1, TimeIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeIterator_StepLengthUnit(), theEcorePackage.getEInt(), "stepLengthUnit", null, 0, 1, TimeIterator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionSpecQueryEClass, VersionSpecQuery.class, "VersionSpecQuery", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVersionSpecQuery_EndVersion(), theVersioningPackage.getVersionSpec(), null, "endVersion", null, 0, 1, VersionSpecQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersionSpecQuery_StartVersion(), theVersioningPackage.getVersionSpec(), null, "startVersion", null, 0, 1, VersionSpecQuery.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} // IteratorPackageImpl
