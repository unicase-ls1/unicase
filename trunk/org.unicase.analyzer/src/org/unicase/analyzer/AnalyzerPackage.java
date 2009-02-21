/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.analyzer;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.analyzer.AnalyzerFactory
 * @model kind="package"
 * @generated
 */
public interface AnalyzerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "analyzer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/analyzer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.analyzer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalyzerPackage eINSTANCE = org.unicase.analyzer.impl.AnalyzerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl <em>Project Analysis Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.analyzer.impl.ProjectAnalysisDataImpl
	 * @see org.unicase.analyzer.impl.AnalyzerPackageImpl#getProjectAnalysisData()
	 * @generated
	 */
	int PROJECT_ANALYSIS_DATA = 0;

	/**
	 * The feature id for the '<em><b>Project State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ANALYSIS_DATA__PROJECT_STATE = 0;

	/**
	 * The feature id for the '<em><b>Change Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES = 1;

	/**
	 * The number of structural features of the '<em>Project Analysis Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ANALYSIS_DATA_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.unicase.analyzer.ProjectAnalysisData <em>Project Analysis Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change Packages</em>'.
	 * @see org.unicase.analyzer.ProjectAnalysisData#getChangePackages()
	 * @see #getProjectAnalysisData()
	 * @generated
	 */
	EReference getProjectAnalysisData_ChangePackages();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnalyzerFactory getAnalyzerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.analyzer.impl.ProjectAnalysisDataImpl <em>Project Analysis Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.analyzer.impl.ProjectAnalysisDataImpl
		 * @see org.unicase.analyzer.impl.AnalyzerPackageImpl#getProjectAnalysisData()
		 * @generated
		 */
		EClass PROJECT_ANALYSIS_DATA = eINSTANCE.getProjectAnalysisData();

		/**
		 * The meta object literal for the '<em><b>Project State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_ANALYSIS_DATA__PROJECT_STATE = eINSTANCE.getProjectAnalysisData_ProjectState();

		/**
		 * The meta object literal for the '<em><b>Change Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_ANALYSIS_DATA__CHANGE_PACKAGES = eINSTANCE.getProjectAnalysisData_ChangePackages();

	}

} //AnalyzerPackage
