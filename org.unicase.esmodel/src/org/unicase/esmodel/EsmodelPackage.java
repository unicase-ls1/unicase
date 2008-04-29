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
	 * The meta object id for the '{@link org.unicase.esmodel.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.VersionImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 0;

	/**
	 * The feature id for the '<em><b>Project State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PROJECT_STATE = 0;

	/**
	 * The feature id for the '<em><b>Primary Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PRIMARY_SPEC = 1;

	/**
	 * The feature id for the '<em><b>Tag Specs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__TAG_SPECS = 2;

	/**
	 * The feature id for the '<em><b>Next Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__NEXT_VERSION = 3;

	/**
	 * The feature id for the '<em><b>Previous Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PREVIOUS_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__CHANGES = 5;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.ProjectHistoryImpl <em>Project History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.ProjectHistoryImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getProjectHistory()
	 * @generated
	 */
	int PROJECT_HISTORY = 1;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__VERSIONS = 0;

	/**
	 * The number of structural features of the '<em>Project History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.ChangePackageImpl <em>Change Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.ChangePackageImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getChangePackage()
	 * @generated
	 */
	int CHANGE_PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Foward Delta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__FOWARD_DELTA = 0;

	/**
	 * The feature id for the '<em><b>Backward Delta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__BACKWARD_DELTA = 1;

	/**
	 * The number of structural features of the '<em>Change Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.ProjectInfoImpl <em>Project Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.ProjectInfoImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getProjectInfo()
	 * @generated
	 */
	int PROJECT_INFO = 3;

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
	 * The meta object id for the '{@link org.unicase.esmodel.impl.HistoryInfoImpl <em>History Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.HistoryInfoImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getHistoryInfo()
	 * @generated
	 */
	int HISTORY_INFO = 4;

	/**
	 * The number of structural features of the '<em>History Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.unicase.esmodel.impl.SessionIdImpl <em>Session Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.esmodel.impl.SessionIdImpl
	 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getSessionId()
	 * @generated
	 */
	int SESSION_ID = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_ID__IDENTIFIER = 0;

	/**
	 * The number of structural features of the '<em>Session Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SESSION_ID_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.unicase.esmodel.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.unicase.esmodel.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.Version#getProjectState <em>Project State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project State</em>'.
	 * @see org.unicase.esmodel.Version#getProjectState()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_ProjectState();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.Version#getPrimarySpec <em>Primary Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Spec</em>'.
	 * @see org.unicase.esmodel.Version#getPrimarySpec()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_PrimarySpec();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.esmodel.Version#getTagSpecs <em>Tag Specs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tag Specs</em>'.
	 * @see org.unicase.esmodel.Version#getTagSpecs()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_TagSpecs();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.Version#getNextVersion <em>Next Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Version</em>'.
	 * @see org.unicase.esmodel.Version#getNextVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_NextVersion();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.Version#getPreviousVersion <em>Previous Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Version</em>'.
	 * @see org.unicase.esmodel.Version#getPreviousVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_PreviousVersion();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.Version#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Changes</em>'.
	 * @see org.unicase.esmodel.Version#getChanges()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_Changes();

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
	 * Returns the meta object for class '{@link org.unicase.esmodel.ChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Package</em>'.
	 * @see org.unicase.esmodel.ChangePackage
	 * @generated
	 */
	EClass getChangePackage();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.ChangePackage#getFowardDelta <em>Foward Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Foward Delta</em>'.
	 * @see org.unicase.esmodel.ChangePackage#getFowardDelta()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_FowardDelta();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.esmodel.ChangePackage#getBackwardDelta <em>Backward Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Backward Delta</em>'.
	 * @see org.unicase.esmodel.ChangePackage#getBackwardDelta()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_BackwardDelta();

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
	 * Returns the meta object for class '{@link org.unicase.esmodel.HistoryInfo <em>History Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History Info</em>'.
	 * @see org.unicase.esmodel.HistoryInfo
	 * @generated
	 */
	EClass getHistoryInfo();

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
	 * Returns the meta object for the attribute '{@link org.unicase.esmodel.SessionId#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.unicase.esmodel.SessionId#getIdentifier()
	 * @see #getSessionId()
	 * @generated
	 */
	EAttribute getSessionId_Identifier();

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
		 * The meta object literal for the '{@link org.unicase.esmodel.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.impl.VersionImpl
		 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Project State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PROJECT_STATE = eINSTANCE.getVersion_ProjectState();

		/**
		 * The meta object literal for the '<em><b>Primary Spec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PRIMARY_SPEC = eINSTANCE.getVersion_PrimarySpec();

		/**
		 * The meta object literal for the '<em><b>Tag Specs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__TAG_SPECS = eINSTANCE.getVersion_TagSpecs();

		/**
		 * The meta object literal for the '<em><b>Next Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__NEXT_VERSION = eINSTANCE.getVersion_NextVersion();

		/**
		 * The meta object literal for the '<em><b>Previous Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PREVIOUS_VERSION = eINSTANCE.getVersion_PreviousVersion();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__CHANGES = eINSTANCE.getVersion_Changes();

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
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_HISTORY__VERSIONS = eINSTANCE.getProjectHistory_Versions();

		/**
		 * The meta object literal for the '{@link org.unicase.esmodel.impl.ChangePackageImpl <em>Change Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.impl.ChangePackageImpl
		 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getChangePackage()
		 * @generated
		 */
		EClass CHANGE_PACKAGE = eINSTANCE.getChangePackage();

		/**
		 * The meta object literal for the '<em><b>Foward Delta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_PACKAGE__FOWARD_DELTA = eINSTANCE.getChangePackage_FowardDelta();

		/**
		 * The meta object literal for the '<em><b>Backward Delta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_PACKAGE__BACKWARD_DELTA = eINSTANCE.getChangePackage_BackwardDelta();

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
		 * The meta object literal for the '{@link org.unicase.esmodel.impl.HistoryInfoImpl <em>History Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.esmodel.impl.HistoryInfoImpl
		 * @see org.unicase.esmodel.impl.EsmodelPackageImpl#getHistoryInfo()
		 * @generated
		 */
		EClass HISTORY_INFO = eINSTANCE.getHistoryInfo();

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
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SESSION_ID__IDENTIFIER = eINSTANCE.getSessionId_Identifier();

	}

} //EsmodelPackage
