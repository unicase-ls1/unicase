/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.unicase.esmodel.*;

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
			case EsmodelPackage.VERSION: return createVersion();
			case EsmodelPackage.PROJECT_HISTORY: return createProjectHistory();
			case EsmodelPackage.CHANGE_PACKAGE: return createChangePackage();
			case EsmodelPackage.PROJECT_INFO: return createProjectInfo();
			case EsmodelPackage.HISTORY_INFO: return createHistoryInfo();
			case EsmodelPackage.SESSION_ID: return createSessionId();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
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
	public ChangePackage createChangePackage() {
		ChangePackageImpl changePackage = new ChangePackageImpl();
		return changePackage;
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
	public HistoryInfo createHistoryInfo() {
		HistoryInfoImpl historyInfo = new HistoryInfoImpl();
		return historyInfo;
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
