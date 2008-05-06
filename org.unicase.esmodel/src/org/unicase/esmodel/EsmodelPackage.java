/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;

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
 * @see org.unicase.esmodel.EsmodelFactory
 * @model kind="package"
 * @generated
 */
public interface EsmodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "esmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.esmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EsmodelPackage eINSTANCE = org.unicase.esmodel.impl.EsmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.ProjectHistoryImpl <em>Project History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.ProjectHistoryImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getProjectHistory()
	 * @generated
	 */
	int PROJECT_HISTORY = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__VERSIONS = 3;

	/**
	 * The number of structural features of the '<em>Project History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.ProjectInfoImpl <em>Project Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.ProjectInfoImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getProjectInfo()
	 * @generated
	 */
	int PROJECT_INFO = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__PROJECT_ID = 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__VERSION = 3;

	/**
	 * The number of structural features of the '<em>Project Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.SessionIdImpl <em>Session Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.SessionIdImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getSessionId()
	 * @generated
	 */
	int SESSION_ID = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_ID__ID = ModelPackage.UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Session Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_ID_FEATURE_COUNT = ModelPackage.UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.AdministrationImpl <em>Administration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.AdministrationImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getAdministration()
	 * @generated
	 */
	int ADMINISTRATION = 3;

	/**
	 * The feature id for the '<em><b>Org Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION__ORG_UNITS = 0;

	/**
	 * The number of structural features of the '<em>Administration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.ProjectIdImpl <em>Project Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.ProjectIdImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getProjectId()
	 * @generated
	 */
	int PROJECT_ID = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ID__ID = ModelPackage.UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Project Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_ID_FEATURE_COUNT = ModelPackage.UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.ProjectHistory <em>Project History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project History</em>'.
	 * @see org.unicase.esmodel.ProjectHistory
	 * @generated
	 */
	EClass getProjectHistory();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.esmodel.ProjectHistory#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Identifier</em>'.
	 * @see org.unicase.esmodel.ProjectHistory#getIdentifier()
	 * @see #getProjectHistory()
	 * @generated
	 */
	EReference getProjectHistory_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.ProjectHistory#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.esmodel.ProjectHistory#getName()
	 * @see #getProjectHistory()
	 * @generated
	 */
	EAttribute getProjectHistory_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.ProjectHistory#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.esmodel.ProjectHistory#getDescription()
	 * @see #getProjectHistory()
	 * @generated
	 */
	EAttribute getProjectHistory_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.esmodel.ProjectHistory#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see org.unicase.esmodel.ProjectHistory#getVersions()
	 * @see #getProjectHistory()
	 * @generated
	 */
	EReference getProjectHistory_Versions();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.ProjectInfo <em>Project Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Info</em>'.
	 * @see org.unicase.esmodel.ProjectInfo
	 * @generated
	 */
	EClass getProjectInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.ProjectInfo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.esmodel.ProjectInfo#getName()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EAttribute getProjectInfo_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.ProjectInfo#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.esmodel.ProjectInfo#getDescription()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EAttribute getProjectInfo_Description();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.ProjectInfo#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project Id</em>'.
	 * @see org.unicase.esmodel.ProjectInfo#getProjectId()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EReference getProjectInfo_ProjectId();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.ProjectInfo#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Version</em>'.
	 * @see org.unicase.esmodel.ProjectInfo#getVersion()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EReference getProjectInfo_Version();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.SessionId <em>Session Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Session Id</em>'.
	 * @see org.unicase.esmodel.SessionId
	 * @generated
	 */
	EClass getSessionId();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.Administration <em>Administration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Administration</em>'.
	 * @see org.unicase.esmodel.Administration
	 * @generated
	 */
	EClass getAdministration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.esmodel.Administration#getOrgUnits <em>Org Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Org Units</em>'.
	 * @see org.unicase.esmodel.Administration#getOrgUnits()
	 * @see #getAdministration()
	 * @generated
	 */
	EReference getAdministration_OrgUnits();

	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.ProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Id</em>'.
	 * @see org.unicase.esmodel.ProjectId
	 * @generated
	 */
	EClass getProjectId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EsmodelFactory getEsmodelFactory();

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
		 * The meta object literal for the '{@link org.unicase.esmodel.impl.ProjectHistoryImpl <em>Project History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.impl.ProjectHistoryImpl
		 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getProjectHistory()
		 * @generated
		 */
		EClass PROJECT_HISTORY = eINSTANCE.getProjectHistory();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_HISTORY__IDENTIFIER = eINSTANCE.getProjectHistory_Identifier();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_HISTORY__NAME = eINSTANCE.getProjectHistory_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_HISTORY__DESCRIPTION = eINSTANCE.getProjectHistory_Description();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_HISTORY__VERSIONS = eINSTANCE.getProjectHistory_Versions();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.impl.ProjectInfoImpl <em>Project Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.impl.ProjectInfoImpl
		 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getProjectInfo()
		 * @generated
		 */
		EClass PROJECT_INFO = eINSTANCE.getProjectInfo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_INFO__NAME = eINSTANCE.getProjectInfo_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_INFO__DESCRIPTION = eINSTANCE.getProjectInfo_Description();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_INFO__PROJECT_ID = eINSTANCE.getProjectInfo_ProjectId();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_INFO__VERSION = eINSTANCE.getProjectInfo_Version();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.impl.SessionIdImpl <em>Session Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.impl.SessionIdImpl
		 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getSessionId()
		 * @generated
		 */
		EClass SESSION_ID = eINSTANCE.getSessionId();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.impl.AdministrationImpl <em>Administration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.impl.AdministrationImpl
		 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getAdministration()
		 * @generated
		 */
		EClass ADMINISTRATION = eINSTANCE.getAdministration();

		/**
		 * The meta object literal for the '<em><b>Org Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADMINISTRATION__ORG_UNITS = eINSTANCE.getAdministration_OrgUnits();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.impl.ProjectIdImpl <em>Project Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.impl.ProjectIdImpl
		 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getProjectId()
		 * @generated
		 */
		EClass PROJECT_ID = eINSTANCE.getProjectId();

	}

} //EsmodelPackage
