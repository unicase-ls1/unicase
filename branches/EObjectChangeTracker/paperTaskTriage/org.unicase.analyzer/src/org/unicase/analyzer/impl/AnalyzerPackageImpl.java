/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.AnalyzerFactory;
import org.unicase.analyzer.AnalyzerPackage;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.exporters.ExportersPackage;
import org.unicase.analyzer.exporters.impl.ExportersPackageImpl;
import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.impl.IteratorPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class AnalyzerPackageImpl extends EPackageImpl implements AnalyzerPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass projectAnalysisDataEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass analyzerConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.analyzer.AnalyzerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnalyzerPackageImpl() {
		super(eNS_URI, AnalyzerFactory.eINSTANCE);
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
	public static AnalyzerPackage init() {
		if (isInited)
			return (AnalyzerPackage) EPackage.Registry.INSTANCE.getEPackage(AnalyzerPackage.eNS_URI);

		// Obtain or create and register package
		AnalyzerPackageImpl theAnalyzerPackage = (AnalyzerPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AnalyzerPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(eNS_URI)
			: new AnalyzerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EsmodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		IteratorPackageImpl theIteratorPackage = (IteratorPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(IteratorPackage.eNS_URI) instanceof IteratorPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(IteratorPackage.eNS_URI) : IteratorPackage.eINSTANCE);
		ExportersPackageImpl theExportersPackage = (ExportersPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ExportersPackage.eNS_URI) instanceof ExportersPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ExportersPackage.eNS_URI) : ExportersPackage.eINSTANCE);

		// Create package meta-data objects
		theAnalyzerPackage.createPackageContents();
		theIteratorPackage.createPackageContents();
		theExportersPackage.createPackageContents();

		// Initialize created meta-data
		theAnalyzerPackage.initializePackageContents();
		theIteratorPackage.initializePackageContents();
		theExportersPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnalyzerPackage.freeze();

		return theAnalyzerPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProjectAnalysisData() {
		return projectAnalysisDataEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectAnalysisData_ProjectState() {
		return (EReference) projectAnalysisDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectAnalysisData_ChangePackages() {
		return (EReference) projectAnalysisDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectAnalysisData_PrimaryVersionSpec() {
		return (EReference) projectAnalysisDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProjectAnalysisData_ProjectId() {
		return (EReference) projectAnalysisDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAnalyzerConfiguration() {
		return analyzerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAnalyzerConfiguration_Iterator() {
		return (EReference) analyzerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAnalyzerConfiguration_AnalyzerName() {
		return (EAttribute) analyzerConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAnalyzerConfiguration_Exporter() {
		return (EReference) analyzerConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AnalyzerFactory getAnalyzerFactory() {
		return (AnalyzerFactory) getEFactoryInstance();
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
		projectAnalysisDataEClass = createEClass(PROJECT_ANALYSIS_DATA);
		createEReference(projectAnalysisDataEClass, PROJECT_ANALYSIS_DATA__PROJECT_STATE);
		createEReference(projectAnalysisDataEClass, PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES);
		createEReference(projectAnalysisDataEClass, PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC);
		createEReference(projectAnalysisDataEClass, PROJECT_ANALYSIS_DATA__PROJECT_ID);

		analyzerConfigurationEClass = createEClass(ANALYZER_CONFIGURATION);
		createEReference(analyzerConfigurationEClass, ANALYZER_CONFIGURATION__ITERATOR);
		createEAttribute(analyzerConfigurationEClass, ANALYZER_CONFIGURATION__ANALYZER_NAME);
		createEReference(analyzerConfigurationEClass, ANALYZER_CONFIGURATION__EXPORTER);
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
		IteratorPackage theIteratorPackage = (IteratorPackage) EPackage.Registry.INSTANCE
			.getEPackage(IteratorPackage.eNS_URI);
		ExportersPackage theExportersPackage = (ExportersPackage) EPackage.Registry.INSTANCE
			.getEPackage(ExportersPackage.eNS_URI);
		MetamodelPackage theModelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(MetamodelPackage.eNS_URI);
		VersioningPackage theVersioningPackage = (VersioningPackage) EPackage.Registry.INSTANCE
			.getEPackage(VersioningPackage.eNS_URI);
		EsmodelPackage theEsmodelPackage = (EsmodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(EsmodelPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theIteratorPackage);
		getESubpackages().add(theExportersPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(projectAnalysisDataEClass, ProjectAnalysisData.class, "ProjectAnalysisData", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProjectAnalysisData_ProjectState(), theModelPackage.getProject(), null, "projectState", null,
			0, 1, ProjectAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectAnalysisData_ChangePackages(), theVersioningPackage.getChangePackage(), null,
			"changePackages", null, 0, -1, ProjectAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectAnalysisData_PrimaryVersionSpec(), theVersioningPackage.getPrimaryVersionSpec(), null,
			"primaryVersionSpec", null, 0, 1, ProjectAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProjectAnalysisData_ProjectId(), theEsmodelPackage.getProjectId(), null, "projectId", null,
			0, 1, ProjectAnalysisData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(analyzerConfigurationEClass, AnalyzerConfiguration.class, "AnalyzerConfiguration", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnalyzerConfiguration_Iterator(), theIteratorPackage.getVersionIterator(), null, "iterator",
			null, 0, 1, AnalyzerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalyzerConfiguration_AnalyzerName(), theEcorePackage.getEString(), "analyzerName", null, 0,
			1, AnalyzerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
			IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnalyzerConfiguration_Exporter(), theExportersPackage.getExporter(), null, "exporter", null,
			0, 1, AnalyzerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // AnalyzerPackageImpl
