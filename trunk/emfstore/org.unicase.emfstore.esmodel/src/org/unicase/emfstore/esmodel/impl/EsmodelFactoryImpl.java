/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.ClientVersionInfo;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.FileIdentifier;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.ServerSpace;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.VersionInfo;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class EsmodelFactoryImpl extends EFactoryImpl implements EsmodelFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static EsmodelFactory init() {
		try {
			EsmodelFactory theEsmodelFactory = (EsmodelFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/emfstore/esmodel");
			if (theEsmodelFactory != null) {
				return theEsmodelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EsmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EsmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case EsmodelPackage.PROJECT_HISTORY:
			return createProjectHistory();
		case EsmodelPackage.PROJECT_INFO:
			return createProjectInfo();
		case EsmodelPackage.SESSION_ID:
			return createSessionId();
		case EsmodelPackage.SERVER_SPACE:
			return createServerSpace();
		case EsmodelPackage.PROJECT_ID:
			return createProjectId();
		case EsmodelPackage.VERSION_INFO:
			return createVersionInfo();
		case EsmodelPackage.CLIENT_VERSION_INFO:
			return createClientVersionInfo();
		case EsmodelPackage.FILE_IDENTIFIER:
			return createFileIdentifier();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectHistory createProjectHistory() {
		ProjectHistoryImpl projectHistory = new ProjectHistoryImpl();
		return projectHistory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectInfo createProjectInfo() {
		ProjectInfoImpl projectInfo = new ProjectInfoImpl();
		return projectInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SessionId createSessionId() {
		SessionIdImpl sessionId = new SessionIdImpl();
		return sessionId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ServerSpace createServerSpace() {
		ServerSpaceImpl serverSpace = new ServerSpaceImpl();
		return serverSpace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectId createProjectId() {
		ProjectIdImpl projectId = new ProjectIdImpl();
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public VersionInfo createVersionInfo() {
		VersionInfoImpl versionInfo = new VersionInfoImpl();
		return versionInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClientVersionInfo createClientVersionInfo() {
		ClientVersionInfoImpl clientVersionInfo = new ClientVersionInfoImpl();
		return clientVersionInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FileIdentifier createFileIdentifier() {
		FileIdentifierImpl fileIdentifier = new FileIdentifierImpl();
		return fileIdentifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EsmodelPackage getEsmodelPackage() {
		return (EsmodelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EsmodelPackage getPackage() {
		return EsmodelPackage.eINSTANCE;
	}

} // EsmodelFactoryImpl
