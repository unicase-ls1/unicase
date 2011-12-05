/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.emfstore.client.model.*;
import org.eclipse.emf.emfstore.client.model.EventComposite;
import org.eclipse.emf.emfstore.client.model.ModelFactory;
import org.eclipse.emf.emfstore.client.model.ModelPackage;
import org.eclipse.emf.emfstore.client.model.NotificationComposite;
import org.eclipse.emf.emfstore.client.model.OperationComposite;
import org.eclipse.emf.emfstore.client.model.PendingFileTransfer;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.ServerInfo;
import org.eclipse.emf.emfstore.client.model.Usersession;
import org.eclipse.emf.emfstore.client.model.Workspace;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelFactoryImpl extends EFactoryImpl implements ModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelFactory init() {
		try {
			ModelFactory theModelFactory = (ModelFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://eclipse.org/emf/emfstore/client/model");
			if (theModelFactory != null) {
				return theModelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactoryImpl() {
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
		case ModelPackage.WORKSPACE:
			return createWorkspace();
		case ModelPackage.SERVER_INFO:
			return createServerInfo();
		case ModelPackage.USERSESSION:
			return createUsersession();
		case ModelPackage.PROJECT_SPACE:
			return createProjectSpace();
		case ModelPackage.OPERATION_COMPOSITE:
			return createOperationComposite();
		case ModelPackage.PENDING_FILE_TRANSFER:
			return createPendingFileTransfer();
		case ModelPackage.EVENT_COMPOSITE:
			return createEventComposite();
		case ModelPackage.NOTIFICATION_COMPOSITE:
			return createNotificationComposite();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace createWorkspace() {
		WorkspaceImpl workspace = new WorkspaceImpl();
		return workspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerInfo createServerInfo() {
		ServerInfoImpl serverInfo = new ServerInfoImpl();
		return serverInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Usersession createUsersession() {
		UsersessionImpl usersession = new UsersessionImpl();
		return usersession;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectSpace createProjectSpace() {
		ProjectSpaceImpl projectSpace = new ProjectSpaceImpl();
		return projectSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationComposite createOperationComposite() {
		OperationCompositeImpl operationComposite = new OperationCompositeImpl();
		return operationComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PendingFileTransfer createPendingFileTransfer() {
		PendingFileTransferImpl pendingFileTransfer = new PendingFileTransferImpl();
		return pendingFileTransfer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventComposite createEventComposite() {
		EventCompositeImpl eventComposite = new EventCompositeImpl();
		return eventComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationComposite createNotificationComposite() {
		NotificationCompositeImpl notificationComposite = new NotificationCompositeImpl();
		return notificationComposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelPackage getModelPackage() {
		return (ModelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelPackage getPackage() {
		return ModelPackage.eINSTANCE;
	}

} // ModelFactoryImpl
