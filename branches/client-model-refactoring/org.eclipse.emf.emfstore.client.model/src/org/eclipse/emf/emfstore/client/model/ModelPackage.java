/**
 * <copyright> Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Unversitaet Muenchen. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.eclipse.emf.emfstore.client.model;

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
 * @see org.eclipse.emf.emfstore.client.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/emfstore/client/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emfstore.client.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.client.model.impl.WorkspaceDataInternalImpl <em>Workspace Data Internal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.client.model.impl.WorkspaceDataInternalImpl
	 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getWorkspaceDataInternal()
	 * @generated
	 */
	int WORKSPACE_DATA_INTERNAL = 0;

	/**
	 * The feature id for the '<em><b>Internal Project Spaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES = 0;

	/**
	 * The feature id for the '<em><b>Internal Server Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS = 1;

	/**
	 * The feature id for the '<em><b>Internal Usersessions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS = 2;

	/**
	 * The feature id for the '<em><b>Internal Active Project Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE = 3;

	/**
	 * The number of structural features of the '<em>Workspace Data Internal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_DATA_INTERNAL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl <em>Server Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl
	 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getServerInfo()
	 * @generated
	 */
	int SERVER_INFO = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__NAME = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__URL = 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__PORT = 2;

	/**
	 * The feature id for the '<em><b>Project Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__PROJECT_INFOS = 3;

	/**
	 * The feature id for the '<em><b>Last Usersession</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__LAST_USERSESSION = 4;

	/**
	 * The feature id for the '<em><b>Certificate Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__CERTIFICATE_ALIAS = 5;

	/**
	 * The number of structural features of the '<em>Server Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl <em>Usersession</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl
	 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getUsersession()
	 * @generated
	 */
	int USERSESSION = 2;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__USERNAME = 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Session Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__SESSION_ID = 2;

	/**
	 * The feature id for the '<em><b>Persistent Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__PERSISTENT_PASSWORD = 3;

	/**
	 * The feature id for the '<em><b>Server Info</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__SERVER_INFO = 4;

	/**
	 * The feature id for the '<em><b>Save Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__SAVE_PASSWORD = 5;

	/**
	 * The feature id for the '<em><b>AC User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__AC_USER = 6;

	/**
	 * The feature id for the '<em><b>Changed Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__CHANGED_PROPERTIES = 7;

	/**
	 * The number of structural features of the '<em>Usersession</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl <em>Project Space Data Internal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl
	 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getProjectSpaceDataInternal()
	 * @generated
	 */
	int PROJECT_SPACE_DATA_INTERNAL = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__IDENTIFIER = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__PROJECT_NAME = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__PROJECT_DESCRIPTION = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Usersession</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__USERSESSION = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__LAST_UPDATED = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Resource Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__RESOURCE_COUNT = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Dirty</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__DIRTY = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Old Log Messages</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__OLD_LOG_MESSAGES = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Waiting Uploads</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Project Data Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL__PROJECT_DATA_PATH = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Project Space Data Internal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_DATA_INTERNAL_FEATURE_COUNT = org.eclipse.emf.emfstore.common.model.ModelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.client.model.impl.OperationCompositeImpl <em>Operation Composite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.client.model.impl.OperationCompositeImpl
	 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getOperationComposite()
	 * @generated
	 */
	int OPERATION_COMPOSITE = 4;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_COMPOSITE__OPERATIONS = 0;

	/**
	 * The number of structural features of the '<em>Operation Composite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_COMPOSITE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.client.model.impl.PendingFileTransferImpl <em>Pending File Transfer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.client.model.impl.PendingFileTransferImpl
	 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getPendingFileTransfer()
	 * @generated
	 */
	int PENDING_FILE_TRANSFER = 5;

	/**
	 * The feature id for the '<em><b>Attachment Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__ATTACHMENT_ID = 0;

	/**
	 * The feature id for the '<em><b>File Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__FILE_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Chunk Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__CHUNK_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Upload</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__UPLOAD = 3;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__FILE_NAME = 4;

	/**
	 * The feature id for the '<em><b>Preliminary File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME = 5;

	/**
	 * The number of structural features of the '<em>Pending File Transfer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.client.model.impl.ProjectDataImpl <em>Project Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.client.model.impl.ProjectDataImpl
	 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getProjectData()
	 * @generated
	 */
	int PROJECT_DATA = 6;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DATA__PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Local Operations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DATA__LOCAL_OPERATIONS = 1;

	/**
	 * The number of structural features of the '<em>Project Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_DATA_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal <em>Workspace Data Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workspace Data Internal</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal
	 * @generated
	 */
	EClass getWorkspaceDataInternal();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalProjectSpaces <em>Internal Project Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Project Spaces</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalProjectSpaces()
	 * @see #getWorkspaceDataInternal()
	 * @generated
	 */
	EReference getWorkspaceDataInternal_InternalProjectSpaces();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalServerInfos <em>Internal Server Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Server Infos</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalServerInfos()
	 * @see #getWorkspaceDataInternal()
	 * @generated
	 */
	EReference getWorkspaceDataInternal_InternalServerInfos();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalUsersessions <em>Internal Usersessions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Internal Usersessions</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalUsersessions()
	 * @see #getWorkspaceDataInternal()
	 * @generated
	 */
	EReference getWorkspaceDataInternal_InternalUsersessions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalActiveProjectSpace <em>Internal Active Project Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Internal Active Project Space</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.WorkspaceDataInternal#getInternalActiveProjectSpace()
	 * @see #getWorkspaceDataInternal()
	 * @generated
	 */
	EReference getWorkspaceDataInternal_InternalActiveProjectSpace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.client.model.ServerInfo <em>Server Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Server Info</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ServerInfo
	 * @generated
	 */
	EClass getServerInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ServerInfo#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ServerInfo#getName()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ServerInfo#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ServerInfo#getUrl()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ServerInfo#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ServerInfo#getPort()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_Port();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.client.model.ServerInfo#getProjectInfos <em>Project Infos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Project Infos</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ServerInfo#getProjectInfos()
	 * @see #getServerInfo()
	 * @generated
	 */
	EReference getServerInfo_ProjectInfos();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.client.model.ServerInfo#getLastUsersession <em>Last Usersession</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Usersession</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ServerInfo#getLastUsersession()
	 * @see #getServerInfo()
	 * @generated
	 */
	EReference getServerInfo_LastUsersession();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ServerInfo#getCertificateAlias <em>Certificate Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Certificate Alias</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ServerInfo#getCertificateAlias()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_CertificateAlias();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.client.model.Usersession <em>Usersession</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usersession</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession
	 * @generated
	 */
	EClass getUsersession();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.Usersession#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#getUsername()
	 * @see #getUsersession()
	 * @generated
	 */
	EAttribute getUsersession_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.Usersession#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#getPassword()
	 * @see #getUsersession()
	 * @generated
	 */
	EAttribute getUsersession_Password();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.client.model.Usersession#getSessionId <em>Session Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Session Id</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#getSessionId()
	 * @see #getUsersession()
	 * @generated
	 */
	EReference getUsersession_SessionId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.Usersession#getPersistentPassword <em>Persistent Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistent Password</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#getPersistentPassword()
	 * @see #getUsersession()
	 * @generated
	 */
	EAttribute getUsersession_PersistentPassword();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.client.model.Usersession#getServerInfo <em>Server Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Server Info</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#getServerInfo()
	 * @see #getUsersession()
	 * @generated
	 */
	EReference getUsersession_ServerInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.Usersession#isSavePassword <em>Save Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Save Password</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#isSavePassword()
	 * @see #getUsersession()
	 * @generated
	 */
	EAttribute getUsersession_SavePassword();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.client.model.Usersession#getACUser <em>AC User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>AC User</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#getACUser()
	 * @see #getUsersession()
	 * @generated
	 */
	EReference getUsersession_ACUser();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.client.model.Usersession#getChangedProperties <em>Changed Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Changed Properties</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.Usersession#getChangedProperties()
	 * @see #getUsersession()
	 * @generated
	 */
	EReference getUsersession_ChangedProperties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal <em>Project Space Data Internal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Space Data Internal</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal
	 * @generated
	 */
	EClass getProjectSpaceDataInternal();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project Id</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectId()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EReference getProjectSpaceDataInternal_ProjectId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectName()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EAttribute getProjectSpaceDataInternal_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectDescription <em>Project Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Description</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectDescription()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EAttribute getProjectSpaceDataInternal_ProjectDescription();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getUsersession <em>Usersession</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Usersession</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getUsersession()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EReference getProjectSpaceDataInternal_Usersession();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getLastUpdated <em>Last Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Updated</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getLastUpdated()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EAttribute getProjectSpaceDataInternal_LastUpdated();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getBaseVersion <em>Base Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Version</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getBaseVersion()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EReference getProjectSpaceDataInternal_BaseVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getResourceCount <em>Resource Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Count</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getResourceCount()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EAttribute getProjectSpaceDataInternal_ResourceCount();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#isDirty <em>Dirty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dirty</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#isDirty()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EAttribute getProjectSpaceDataInternal_Dirty();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getOldLogMessages <em>Old Log Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Old Log Messages</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getOldLogMessages()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EAttribute getProjectSpaceDataInternal_OldLogMessages();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getWaitingUploads <em>Waiting Uploads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Waiting Uploads</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getWaitingUploads()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EReference getProjectSpaceDataInternal_WaitingUploads();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectDataPath <em>Project Data Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Data Path</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectSpaceDataInternal#getProjectDataPath()
	 * @see #getProjectSpaceDataInternal()
	 * @generated
	 */
	EAttribute getProjectSpaceDataInternal_ProjectDataPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.client.model.OperationComposite <em>Operation Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Composite</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.OperationComposite
	 * @generated
	 */
	EClass getOperationComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.client.model.OperationComposite#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.OperationComposite#getOperations()
	 * @see #getOperationComposite()
	 * @generated
	 */
	EReference getOperationComposite_Operations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer <em>Pending File Transfer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pending File Transfer</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.PendingFileTransfer
	 * @generated
	 */
	EClass getPendingFileTransfer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getAttachmentId <em>Attachment Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attachment Id</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getAttachmentId()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EReference getPendingFileTransfer_AttachmentId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getFileVersion <em>File Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Version</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getFileVersion()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_FileVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getChunkNumber <em>Chunk Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chunk Number</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getChunkNumber()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_ChunkNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#isUpload <em>Upload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upload</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.PendingFileTransfer#isUpload()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_Upload();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getFileName()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getPreliminaryFileName <em>Preliminary File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Preliminary File Name</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.PendingFileTransfer#getPreliminaryFileName()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_PreliminaryFileName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.client.model.ProjectData <em>Project Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Data</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectData
	 * @generated
	 */
	EClass getProjectData();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.client.model.ProjectData#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectData#getProject()
	 * @see #getProjectData()
	 * @generated
	 */
	EReference getProjectData_Project();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.client.model.ProjectData#getLocalOperations <em>Local Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Operations</em>'.
	 * @see org.eclipse.emf.emfstore.client.model.ProjectData#getLocalOperations()
	 * @see #getProjectData()
	 * @generated
	 */
	EReference getProjectData_LocalOperations();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.client.model.impl.WorkspaceDataInternalImpl <em>Workspace Data Internal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.client.model.impl.WorkspaceDataInternalImpl
		 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getWorkspaceDataInternal()
		 * @generated
		 */
		EClass WORKSPACE_DATA_INTERNAL = eINSTANCE.getWorkspaceDataInternal();

		/**
		 * The meta object literal for the '<em><b>Internal Project Spaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_DATA_INTERNAL__INTERNAL_PROJECT_SPACES = eINSTANCE
				.getWorkspaceDataInternal_InternalProjectSpaces();

		/**
		 * The meta object literal for the '<em><b>Internal Server Infos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_DATA_INTERNAL__INTERNAL_SERVER_INFOS = eINSTANCE
				.getWorkspaceDataInternal_InternalServerInfos();

		/**
		 * The meta object literal for the '<em><b>Internal Usersessions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_DATA_INTERNAL__INTERNAL_USERSESSIONS = eINSTANCE
				.getWorkspaceDataInternal_InternalUsersessions();

		/**
		 * The meta object literal for the '<em><b>Internal Active Project Space</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE_DATA_INTERNAL__INTERNAL_ACTIVE_PROJECT_SPACE = eINSTANCE
				.getWorkspaceDataInternal_InternalActiveProjectSpace();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl <em>Server Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.client.model.impl.ServerInfoImpl
		 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getServerInfo()
		 * @generated
		 */
		EClass SERVER_INFO = eINSTANCE.getServerInfo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__NAME = eINSTANCE.getServerInfo_Name();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__URL = eINSTANCE.getServerInfo_Url();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__PORT = eINSTANCE.getServerInfo_Port();

		/**
		 * The meta object literal for the '<em><b>Project Infos</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_INFO__PROJECT_INFOS = eINSTANCE
				.getServerInfo_ProjectInfos();

		/**
		 * The meta object literal for the '<em><b>Last Usersession</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_INFO__LAST_USERSESSION = eINSTANCE
				.getServerInfo_LastUsersession();

		/**
		 * The meta object literal for the '<em><b>Certificate Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__CERTIFICATE_ALIAS = eINSTANCE
				.getServerInfo_CertificateAlias();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl <em>Usersession</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.client.model.impl.UsersessionImpl
		 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getUsersession()
		 * @generated
		 */
		EClass USERSESSION = eINSTANCE.getUsersession();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USERSESSION__USERNAME = eINSTANCE.getUsersession_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USERSESSION__PASSWORD = eINSTANCE.getUsersession_Password();

		/**
		 * The meta object literal for the '<em><b>Session Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USERSESSION__SESSION_ID = eINSTANCE
				.getUsersession_SessionId();

		/**
		 * The meta object literal for the '<em><b>Persistent Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USERSESSION__PERSISTENT_PASSWORD = eINSTANCE
				.getUsersession_PersistentPassword();

		/**
		 * The meta object literal for the '<em><b>Server Info</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USERSESSION__SERVER_INFO = eINSTANCE
				.getUsersession_ServerInfo();

		/**
		 * The meta object literal for the '<em><b>Save Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USERSESSION__SAVE_PASSWORD = eINSTANCE
				.getUsersession_SavePassword();

		/**
		 * The meta object literal for the '<em><b>AC User</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USERSESSION__AC_USER = eINSTANCE.getUsersession_ACUser();

		/**
		 * The meta object literal for the '<em><b>Changed Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USERSESSION__CHANGED_PROPERTIES = eINSTANCE
				.getUsersession_ChangedProperties();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl <em>Project Space Data Internal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.client.model.impl.ProjectSpaceDataInternalImpl
		 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getProjectSpaceDataInternal()
		 * @generated
		 */
		EClass PROJECT_SPACE_DATA_INTERNAL = eINSTANCE
				.getProjectSpaceDataInternal();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_SPACE_DATA_INTERNAL__PROJECT_ID = eINSTANCE
				.getProjectSpaceDataInternal_ProjectId();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE_DATA_INTERNAL__PROJECT_NAME = eINSTANCE
				.getProjectSpaceDataInternal_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Project Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE_DATA_INTERNAL__PROJECT_DESCRIPTION = eINSTANCE
				.getProjectSpaceDataInternal_ProjectDescription();

		/**
		 * The meta object literal for the '<em><b>Usersession</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_SPACE_DATA_INTERNAL__USERSESSION = eINSTANCE
				.getProjectSpaceDataInternal_Usersession();

		/**
		 * The meta object literal for the '<em><b>Last Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE_DATA_INTERNAL__LAST_UPDATED = eINSTANCE
				.getProjectSpaceDataInternal_LastUpdated();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_SPACE_DATA_INTERNAL__BASE_VERSION = eINSTANCE
				.getProjectSpaceDataInternal_BaseVersion();

		/**
		 * The meta object literal for the '<em><b>Resource Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE_DATA_INTERNAL__RESOURCE_COUNT = eINSTANCE
				.getProjectSpaceDataInternal_ResourceCount();

		/**
		 * The meta object literal for the '<em><b>Dirty</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE_DATA_INTERNAL__DIRTY = eINSTANCE
				.getProjectSpaceDataInternal_Dirty();

		/**
		 * The meta object literal for the '<em><b>Old Log Messages</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE_DATA_INTERNAL__OLD_LOG_MESSAGES = eINSTANCE
				.getProjectSpaceDataInternal_OldLogMessages();

		/**
		 * The meta object literal for the '<em><b>Waiting Uploads</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_SPACE_DATA_INTERNAL__WAITING_UPLOADS = eINSTANCE
				.getProjectSpaceDataInternal_WaitingUploads();

		/**
		 * The meta object literal for the '<em><b>Project Data Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE_DATA_INTERNAL__PROJECT_DATA_PATH = eINSTANCE
				.getProjectSpaceDataInternal_ProjectDataPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.client.model.impl.OperationCompositeImpl <em>Operation Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.client.model.impl.OperationCompositeImpl
		 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getOperationComposite()
		 * @generated
		 */
		EClass OPERATION_COMPOSITE = eINSTANCE.getOperationComposite();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_COMPOSITE__OPERATIONS = eINSTANCE
				.getOperationComposite_Operations();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.client.model.impl.PendingFileTransferImpl <em>Pending File Transfer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.client.model.impl.PendingFileTransferImpl
		 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getPendingFileTransfer()
		 * @generated
		 */
		EClass PENDING_FILE_TRANSFER = eINSTANCE.getPendingFileTransfer();

		/**
		 * The meta object literal for the '<em><b>Attachment Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PENDING_FILE_TRANSFER__ATTACHMENT_ID = eINSTANCE
				.getPendingFileTransfer_AttachmentId();

		/**
		 * The meta object literal for the '<em><b>File Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__FILE_VERSION = eINSTANCE
				.getPendingFileTransfer_FileVersion();

		/**
		 * The meta object literal for the '<em><b>Chunk Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__CHUNK_NUMBER = eINSTANCE
				.getPendingFileTransfer_ChunkNumber();

		/**
		 * The meta object literal for the '<em><b>Upload</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__UPLOAD = eINSTANCE
				.getPendingFileTransfer_Upload();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__FILE_NAME = eINSTANCE
				.getPendingFileTransfer_FileName();

		/**
		 * The meta object literal for the '<em><b>Preliminary File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME = eINSTANCE
				.getPendingFileTransfer_PreliminaryFileName();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.client.model.impl.ProjectDataImpl <em>Project Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.client.model.impl.ProjectDataImpl
		 * @see org.eclipse.emf.emfstore.client.model.impl.ModelPackageImpl#getProjectData()
		 * @generated
		 */
		EClass PROJECT_DATA = eINSTANCE.getProjectData();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_DATA__PROJECT = eINSTANCE.getProjectData_Project();

		/**
		 * The meta object literal for the '<em><b>Local Operations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_DATA__LOCAL_OPERATIONS = eINSTANCE
				.getProjectData_LocalOperations();

	}

} //ModelPackage
