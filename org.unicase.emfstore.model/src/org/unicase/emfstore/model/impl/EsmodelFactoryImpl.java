/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.unicase.emfstore.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EsmodelFactoryImpl extends EFactoryImpl implements EsmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EsmodelFactory init() {
		try {
			EsmodelFactory theEsmodelFactory = (EsmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/esmodel"); 
			if (theEsmodelFactory != null) {
				return theEsmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EsmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsmodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EsmodelPackage.PROJECT_HISTORY: return createProjectHistory();
			case EsmodelPackage.PROJECT_INFO: return createProjectInfo();
			case EsmodelPackage.SESSION_ID: return createSessionId();
			case EsmodelPackage.SERVER_SPACE: return createServerSpace();
			case EsmodelPackage.PROJECT_ID: return createProjectId();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectHistory createProjectHistory() {
		ProjectHistoryImpl projectHistory = new ProjectHistoryImpl();
		return projectHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectInfo createProjectInfo() {
		ProjectInfoImpl projectInfo = new ProjectInfoImpl();
		return projectInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SessionId createSessionId() {
		SessionIdImpl sessionId = new SessionIdImpl();
		return sessionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerSpace createServerSpace() {
		ServerSpaceImpl serverSpace = new ServerSpaceImpl();
		return serverSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId createProjectId() {
		ProjectIdImpl projectId = new ProjectIdImpl();
		return projectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsmodelPackage getEsmodelPackage() {
		return (EsmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EsmodelPackage getPackage() {
		return EsmodelPackage.eINSTANCE;
	}

} //EsmodelFactoryImpl
