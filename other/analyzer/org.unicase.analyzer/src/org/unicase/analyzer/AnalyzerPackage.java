/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.analyzer.AnalyzerFactory
 * @model kind="package"
 * @generated
 */
public interface AnalyzerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "analyzer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/analyzer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.analyzer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	AnalyzerPackage eINSTANCE = org.unicase.analyzer.impl.AnalyzerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl <em>Project Analysis Data</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.analyzer.impl.ProjectAnalysisDataImpl
	 * @see org.unicase.analyzer.impl.AnalyzerPackageImpl#getProjectAnalysisData()
	 * @generated
	 */
	int PROJECT_ANALYSIS_DATA = 0;

	/**
	 * The feature id for the '<em><b>Project State</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ANALYSIS_DATA__PROJECT_STATE = 0;

	/**
	 * The feature id for the '<em><b>Change Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES = 1;

	/**
	 * The feature id for the '<em><b>Primary Version Spec</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC = 2;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ANALYSIS_DATA__PROJECT_ID = 3;

	/**
	 * The number of structural features of the '<em>Project Analysis Data</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ANALYSIS_DATA_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.analyzer.impl.AnalyzerConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.analyzer.impl.AnalyzerConfigurationImpl
	 * @see org.unicase.analyzer.impl.AnalyzerPackageImpl#getAnalyzerConfiguration()
	 * @generated
	 */
	int ANALYZER_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_CONFIGURATION__ITERATOR = 0;

	/**
	 * The feature id for the '<em><b>Analyzer Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_CONFIGURATION__ANALYZER_NAME = 1;

	/**
	 * The feature id for the '<em><b>Exporter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_CONFIGURATION__EXPORTER = 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYZER_CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * Returns the meta object for class '{@link org.unicase.analyzer.ProjectAnalysisData <em>Project Analysis Data</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Analysis Data</em>'.
	 * @see org.unicase.analyzer.ProjectAnalysisData
	 * @generated
	 */
	EClass getProjectAnalysisData();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.analyzer.ProjectAnalysisData#getProjectState <em>Project State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project State</em>'.
	 * @see org.unicase.analyzer.ProjectAnalysisData#getProjectState()
	 * @see #getProjectAnalysisData()
	 * @generated
	 */
	EReference getProjectAnalysisData_ProjectState();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.analyzer.ProjectAnalysisData#getChangePackages <em>Change Packages</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change Packages</em>'.
	 * @see org.unicase.analyzer.ProjectAnalysisData#getChangePackages()
	 * @see #getProjectAnalysisData()
	 * @generated
	 */
	EReference getProjectAnalysisData_ChangePackages();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.analyzer.ProjectAnalysisData#getPrimaryVersionSpec <em>Primary Version Spec</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Primary Version Spec</em>'.
	 * @see org.unicase.analyzer.ProjectAnalysisData#getPrimaryVersionSpec()
	 * @see #getProjectAnalysisData()
	 * @generated
	 */
	EReference getProjectAnalysisData_PrimaryVersionSpec();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.analyzer.ProjectAnalysisData#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project Id</em>'.
	 * @see org.unicase.analyzer.ProjectAnalysisData#getProjectId()
	 * @see #getProjectAnalysisData()
	 * @generated
	 */
	EReference getProjectAnalysisData_ProjectId();

	/**
	 * Returns the meta object for class '{@link org.unicase.analyzer.AnalyzerConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.unicase.analyzer.AnalyzerConfiguration
	 * @generated
	 */
	EClass getAnalyzerConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.analyzer.AnalyzerConfiguration#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see org.unicase.analyzer.AnalyzerConfiguration#getIterator()
	 * @see #getAnalyzerConfiguration()
	 * @generated
	 */
	EReference getAnalyzerConfiguration_Iterator();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.analyzer.AnalyzerConfiguration#getAnalyzerName <em>Analyzer Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Analyzer Name</em>'.
	 * @see org.unicase.analyzer.AnalyzerConfiguration#getAnalyzerName()
	 * @see #getAnalyzerConfiguration()
	 * @generated
	 */
	EAttribute getAnalyzerConfiguration_AnalyzerName();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.analyzer.AnalyzerConfiguration#getExporter <em>Exporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exporter</em>'.
	 * @see org.unicase.analyzer.AnalyzerConfiguration#getExporter()
	 * @see #getAnalyzerConfiguration()
	 * @generated
	 */
	EReference getAnalyzerConfiguration_Exporter();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnalyzerFactory getAnalyzerFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl <em>Project Analysis Data</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.analyzer.impl.ProjectAnalysisDataImpl
		 * @see org.unicase.analyzer.impl.AnalyzerPackageImpl#getProjectAnalysisData()
		 * @generated
		 */
		EClass PROJECT_ANALYSIS_DATA = eINSTANCE.getProjectAnalysisData();

		/**
		 * The meta object literal for the '<em><b>Project State</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_ANALYSIS_DATA__PROJECT_STATE = eINSTANCE.getProjectAnalysisData_ProjectState();

		/**
		 * The meta object literal for the '<em><b>Change Packages</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES = eINSTANCE.getProjectAnalysisData_ChangePackages();

		/**
		 * The meta object literal for the '<em><b>Primary Version Spec</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_ANALYSIS_DATA__PRIMARY_VERSION_SPEC = eINSTANCE.getProjectAnalysisData_PrimaryVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_ANALYSIS_DATA__PROJECT_ID = eINSTANCE.getProjectAnalysisData_ProjectId();

		/**
		 * The meta object literal for the '{@link org.unicase.analyzer.impl.AnalyzerConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.analyzer.impl.AnalyzerConfigurationImpl
		 * @see org.unicase.analyzer.impl.AnalyzerPackageImpl#getAnalyzerConfiguration()
		 * @generated
		 */
		EClass ANALYZER_CONFIGURATION = eINSTANCE.getAnalyzerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYZER_CONFIGURATION__ITERATOR = eINSTANCE.getAnalyzerConfiguration_Iterator();

		/**
		 * The meta object literal for the '<em><b>Analyzer Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYZER_CONFIGURATION__ANALYZER_NAME = eINSTANCE.getAnalyzerConfiguration_AnalyzerName();

		/**
		 * The meta object literal for the '<em><b>Exporter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYZER_CONFIGURATION__EXPORTER = eINSTANCE.getAnalyzerConfiguration_Exporter();

	}

} // AnalyzerPackage
