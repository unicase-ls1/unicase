/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.unicase.emfstore.esmodel.EsmodelFactory
 * @model kind="package"
 * @generated
 */
public interface EsmodelPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "esmodel";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/emfstore/esmodel";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	EsmodelPackage eINSTANCE = org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.impl.ProjectHistoryImpl <em>Project History</em>}
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.impl.ProjectHistoryImpl
	 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getProjectHistory()
	 * @generated
	 */
	int PROJECT_HISTORY = 0;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__PROJECT_ID = 0;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__VERSIONS = 1;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__PROJECT_NAME = 2;

	/**
	 * The feature id for the '<em><b>Project Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY__PROJECT_DESCRIPTION = 3;

	/**
	 * The number of structural features of the '<em>Project History</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_HISTORY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.impl.ProjectInfoImpl <em>Project Info</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.impl.ProjectInfoImpl
	 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getProjectInfo()
	 * @generated
	 */
	int PROJECT_INFO = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__PROJECT_ID = 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO__VERSION = 3;

	/**
	 * The number of structural features of the '<em>Project Info</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_INFO_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.impl.SessionIdImpl <em>Session Id</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.impl.SessionIdImpl
	 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getSessionId()
	 * @generated
	 */
	int SESSION_ID = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_ID__ID = MetamodelPackage.UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Session Id</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SESSION_ID_FEATURE_COUNT = MetamodelPackage.UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.impl.ServerSpaceImpl <em>Server Space</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.impl.ServerSpaceImpl
	 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getServerSpace()
	 * @generated
	 */
	int SERVER_SPACE = 3;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_SPACE__GROUPS = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_SPACE__PROJECTS = 1;

	/**
	 * The feature id for the '<em><b>Open Sessions</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_SPACE__OPEN_SESSIONS = 2;

	/**
	 * The feature id for the '<em><b>Users</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_SPACE__USERS = 3;

	/**
	 * The number of structural features of the '<em>Server Space</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_SPACE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.impl.ProjectIdImpl <em>Project Id</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.impl.ProjectIdImpl
	 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getProjectId()
	 * @generated
	 */
	int PROJECT_ID = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_ID__ID = MetamodelPackage.UNIQUE_IDENTIFIER__ID;

	/**
	 * The number of structural features of the '<em>Project Id</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_ID_FEATURE_COUNT = MetamodelPackage.UNIQUE_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.impl.VersionInfoImpl <em>Version Info</em>}'
	 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.impl.VersionInfoImpl
	 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getVersionInfo()
	 * @generated
	 */
	int VERSION_INFO = 5;

	/**
	 * The feature id for the '<em><b>Emf Store Version String</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO__EMF_STORE_VERSION_STRING = 0;

	/**
	 * The number of structural features of the '<em>Version Info</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_INFO_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.impl.ClientVersionInfoImpl
	 * <em>Client Version Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.impl.ClientVersionInfoImpl
	 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getClientVersionInfo()
	 * @generated
	 */
	int CLIENT_VERSION_INFO = 6;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLIENT_VERSION_INFO__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLIENT_VERSION_INFO__NAME = 1;

	/**
	 * The number of structural features of the '<em>Client Version Info</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CLIENT_VERSION_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.impl.FileIdentifierImpl <em>File Identifier</em>}
	 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.esmodel.impl.FileIdentifierImpl
	 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getFileIdentifier()
	 * @generated
	 */
	int FILE_IDENTIFIER = 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_IDENTIFIER__IDENTIFIER = MetamodelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>File Identifier</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FILE_IDENTIFIER_FEATURE_COUNT = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.ProjectHistory <em>Project History</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Project History</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectHistory
	 * @generated
	 */
	EClass getProjectHistory();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.ProjectHistory#getProjectId <em>Project Id</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Project Id</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectHistory#getProjectId()
	 * @see #getProjectHistory()
	 * @generated
	 */
	EReference getProjectHistory_ProjectId();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.ProjectHistory#getVersions <em>Versions</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Versions</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectHistory#getVersions()
	 * @see #getProjectHistory()
	 * @generated
	 */
	EReference getProjectHistory_Versions();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.ProjectHistory#getProjectName
	 * <em>Project Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectHistory#getProjectName()
	 * @see #getProjectHistory()
	 * @generated
	 */
	EAttribute getProjectHistory_ProjectName();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.ProjectHistory#getProjectDescription <em>Project Description</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Project Description</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectHistory#getProjectDescription()
	 * @see #getProjectHistory()
	 * @generated
	 */
	EAttribute getProjectHistory_ProjectDescription();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.ProjectInfo <em>Project Info</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Project Info</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectInfo
	 * @generated
	 */
	EClass getProjectInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.ProjectInfo#getName <em>Name</em>}
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectInfo#getName()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EAttribute getProjectInfo_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.ProjectInfo#getDescription
	 * <em>Description</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectInfo#getDescription()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EAttribute getProjectInfo_Description();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.ProjectInfo#getProjectId <em>Project Id</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Project Id</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectInfo#getProjectId()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EReference getProjectInfo_ProjectId();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.esmodel.ProjectInfo#getVersion <em>Version</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Version</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectInfo#getVersion()
	 * @see #getProjectInfo()
	 * @generated
	 */
	EReference getProjectInfo_Version();

	/**
	 * Returns the meta object for class ' {@link org.unicase.emfstore.esmodel.SessionId <em>Session Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Session Id</em>'.
	 * @see org.unicase.emfstore.esmodel.SessionId
	 * @generated
	 */
	EClass getSessionId();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.ServerSpace <em>Server Space</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Server Space</em>'.
	 * @see org.unicase.emfstore.esmodel.ServerSpace
	 * @generated
	 */
	EClass getServerSpace();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.ServerSpace#getGroups <em>Groups</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.unicase.emfstore.esmodel.ServerSpace#getGroups()
	 * @see #getServerSpace()
	 * @generated
	 */
	EReference getServerSpace_Groups();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.emfstore.esmodel.ServerSpace#getProjects
	 * <em>Projects</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Projects</em>'.
	 * @see org.unicase.emfstore.esmodel.ServerSpace#getProjects()
	 * @see #getServerSpace()
	 * @generated
	 */
	EReference getServerSpace_Projects();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.ServerSpace#getOpenSessions <em>Open Sessions</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Open Sessions</em>'.
	 * @see org.unicase.emfstore.esmodel.ServerSpace#getOpenSessions()
	 * @see #getServerSpace()
	 * @generated
	 */
	EReference getServerSpace_OpenSessions();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.esmodel.ServerSpace#getUsers <em>Users</em>}'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Users</em>'.
	 * @see org.unicase.emfstore.esmodel.ServerSpace#getUsers()
	 * @see #getServerSpace()
	 * @generated
	 */
	EReference getServerSpace_Users();

	/**
	 * Returns the meta object for class ' {@link org.unicase.emfstore.esmodel.ProjectId <em>Project Id</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Project Id</em>'.
	 * @see org.unicase.emfstore.esmodel.ProjectId
	 * @generated
	 */
	EClass getProjectId();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.VersionInfo <em>Version Info</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Version Info</em>'.
	 * @see org.unicase.emfstore.esmodel.VersionInfo
	 * @generated
	 */
	EClass getVersionInfo();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.VersionInfo#getEmfStoreVersionString <em>Emf Store Version String</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Emf Store Version String</em>'.
	 * @see org.unicase.emfstore.esmodel.VersionInfo#getEmfStoreVersionString()
	 * @see #getVersionInfo()
	 * @generated
	 */
	EAttribute getVersionInfo_EmfStoreVersionString();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.ClientVersionInfo
	 * <em>Client Version Info</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Client Version Info</em>'.
	 * @see org.unicase.emfstore.esmodel.ClientVersionInfo
	 * @generated
	 */
	EClass getClientVersionInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.ClientVersionInfo#getVersion
	 * <em>Version</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.unicase.emfstore.esmodel.ClientVersionInfo#getVersion()
	 * @see #getClientVersionInfo()
	 * @generated
	 */
	EAttribute getClientVersionInfo_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.ClientVersionInfo#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.esmodel.ClientVersionInfo#getName()
	 * @see #getClientVersionInfo()
	 * @generated
	 */
	EAttribute getClientVersionInfo_Name();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.FileIdentifier <em>File Identifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>File Identifier</em>'.
	 * @see org.unicase.emfstore.esmodel.FileIdentifier
	 * @generated
	 */
	EClass getFileIdentifier();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EsmodelFactory getEsmodelFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.impl.ProjectHistoryImpl
		 * <em>Project History</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.impl.ProjectHistoryImpl
		 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getProjectHistory()
		 * @generated
		 */
		EClass PROJECT_HISTORY = eINSTANCE.getProjectHistory();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_HISTORY__PROJECT_ID = eINSTANCE.getProjectHistory_ProjectId();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_HISTORY__VERSIONS = eINSTANCE.getProjectHistory_Versions();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT_HISTORY__PROJECT_NAME = eINSTANCE.getProjectHistory_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Project Description</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT_HISTORY__PROJECT_DESCRIPTION = eINSTANCE.getProjectHistory_ProjectDescription();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.impl.ProjectInfoImpl
		 * <em>Project Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.impl.ProjectInfoImpl
		 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getProjectInfo()
		 * @generated
		 */
		EClass PROJECT_INFO = eINSTANCE.getProjectInfo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT_INFO__NAME = eINSTANCE.getProjectInfo_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT_INFO__DESCRIPTION = eINSTANCE.getProjectInfo_Description();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_INFO__PROJECT_ID = eINSTANCE.getProjectInfo_ProjectId();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' containment reference feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_INFO__VERSION = eINSTANCE.getProjectInfo_Version();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.impl.SessionIdImpl <em>Session Id</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.impl.SessionIdImpl
		 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getSessionId()
		 * @generated
		 */
		EClass SESSION_ID = eINSTANCE.getSessionId();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.impl.ServerSpaceImpl
		 * <em>Server Space</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.impl.ServerSpaceImpl
		 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getServerSpace()
		 * @generated
		 */
		EClass SERVER_SPACE = eINSTANCE.getServerSpace();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVER_SPACE__GROUPS = eINSTANCE.getServerSpace_Groups();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' reference list feature. <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVER_SPACE__PROJECTS = eINSTANCE.getServerSpace_Projects();

		/**
		 * The meta object literal for the '<em><b>Open Sessions</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVER_SPACE__OPEN_SESSIONS = eINSTANCE.getServerSpace_OpenSessions();

		/**
		 * The meta object literal for the '<em><b>Users</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVER_SPACE__USERS = eINSTANCE.getServerSpace_Users();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.impl.ProjectIdImpl <em>Project Id</em>}'
		 * class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.impl.ProjectIdImpl
		 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getProjectId()
		 * @generated
		 */
		EClass PROJECT_ID = eINSTANCE.getProjectId();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.impl.VersionInfoImpl
		 * <em>Version Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.impl.VersionInfoImpl
		 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getVersionInfo()
		 * @generated
		 */
		EClass VERSION_INFO = eINSTANCE.getVersionInfo();

		/**
		 * The meta object literal for the '<em><b>Emf Store Version String</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute VERSION_INFO__EMF_STORE_VERSION_STRING = eINSTANCE.getVersionInfo_EmfStoreVersionString();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.impl.ClientVersionInfoImpl
		 * <em>Client Version Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.impl.ClientVersionInfoImpl
		 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getClientVersionInfo()
		 * @generated
		 */
		EClass CLIENT_VERSION_INFO = eINSTANCE.getClientVersionInfo();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CLIENT_VERSION_INFO__VERSION = eINSTANCE.getClientVersionInfo_Version();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CLIENT_VERSION_INFO__NAME = eINSTANCE.getClientVersionInfo_Name();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.impl.FileIdentifierImpl
		 * <em>File Identifier</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.esmodel.impl.FileIdentifierImpl
		 * @see org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl#getFileIdentifier()
		 * @generated
		 */
		EClass FILE_IDENTIFIER = eINSTANCE.getFileIdentifier();

	}

} // EsmodelPackage
