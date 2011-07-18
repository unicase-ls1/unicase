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
package org.eclipse.emf.emfstore.server.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.IdentifiableElement;
import org.eclipse.emf.emfstore.common.model.UniqueIdentifier;
import org.eclipse.emf.emfstore.server.model.*;
import org.eclipse.emf.emfstore.server.model.ClientVersionInfo;
import org.eclipse.emf.emfstore.server.model.FileIdentifier;
import org.eclipse.emf.emfstore.server.model.ModelPackage;
import org.eclipse.emf.emfstore.server.model.ProjectHistory;
import org.eclipse.emf.emfstore.server.model.ProjectId;
import org.eclipse.emf.emfstore.server.model.ProjectInfo;
import org.eclipse.emf.emfstore.server.model.ServerSpace;
import org.eclipse.emf.emfstore.server.model.SessionId;
import org.eclipse.emf.emfstore.server.model.VersionInfo;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance
	 * object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelSwitch<Adapter> modelSwitch = new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseProjectHistory(ProjectHistory object) {
				return createProjectHistoryAdapter();
			}
			@Override
			public Adapter caseProjectInfo(ProjectInfo object) {
				return createProjectInfoAdapter();
			}
			@Override
			public Adapter caseSessionId(SessionId object) {
				return createSessionIdAdapter();
			}
			@Override
			public Adapter caseServerSpace(ServerSpace object) {
				return createServerSpaceAdapter();
			}
			@Override
			public Adapter caseProjectId(ProjectId object) {
				return createProjectIdAdapter();
			}
			@Override
			public Adapter caseVersionInfo(VersionInfo object) {
				return createVersionInfoAdapter();
			}
			@Override
			public Adapter caseClientVersionInfo(ClientVersionInfo object) {
				return createClientVersionInfoAdapter();
			}
			@Override
			public Adapter caseFileIdentifier(FileIdentifier object) {
				return createFileIdentifierAdapter();
			}
			@Override
			public Adapter caseUniqueIdentifier(UniqueIdentifier object) {
				return createUniqueIdentifierAdapter();
			}
			@Override
			public Adapter caseIdentifiableElement(IdentifiableElement object) {
				return createIdentifiableElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.ProjectHistory <em>Project History</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.ProjectHistory
	 * @generated
	 */
	public Adapter createProjectHistoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.ProjectInfo <em>Project Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.ProjectInfo
	 * @generated
	 */
	public Adapter createProjectInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.SessionId <em>Session Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.SessionId
	 * @generated
	 */
	public Adapter createSessionIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.ServerSpace <em>Server Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.ServerSpace
	 * @generated
	 */
	public Adapter createServerSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.ProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.ProjectId
	 * @generated
	 */
	public Adapter createProjectIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.VersionInfo <em>Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.VersionInfo
	 * @generated
	 */
	public Adapter createVersionInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.ClientVersionInfo <em>Client Version Info</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.ClientVersionInfo
	 * @generated
	 */
	public Adapter createClientVersionInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.server.model.FileIdentifier <em>File Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.server.model.FileIdentifier
	 * @generated
	 */
	public Adapter createFileIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.common.model.UniqueIdentifier <em>Unique Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.common.model.UniqueIdentifier
	 * @generated
	 */
	public Adapter createUniqueIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.emfstore.common.model.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.emfstore.common.model.IdentifiableElement
	 * @generated
	 */
	public Adapter createIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ModelAdapterFactory
