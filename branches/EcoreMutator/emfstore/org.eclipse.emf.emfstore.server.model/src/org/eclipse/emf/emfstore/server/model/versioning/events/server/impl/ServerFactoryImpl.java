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
package org.eclipse.emf.emfstore.server.model.versioning.events.server.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.*;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ProjectUpdatedEvent;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerFactory;
import org.eclipse.emf.emfstore.server.model.versioning.events.server.ServerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ServerFactoryImpl extends EFactoryImpl implements ServerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ServerFactory init() {
		try {
			ServerFactory theServerFactory = (ServerFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/emf/emfstore/server/model/versioning/events/server/"); 
			if (theServerFactory != null) {
				return theServerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ServerPackage.PROJECT_UPDATED_EVENT: return createProjectUpdatedEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectUpdatedEvent createProjectUpdatedEvent() {
		ProjectUpdatedEventImpl projectUpdatedEvent = new ProjectUpdatedEventImpl();
		return projectUpdatedEvent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerPackage getServerPackage() {
		return (ServerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ServerPackage getPackage() {
		return ServerPackage.eINSTANCE;
	}

} // ServerFactoryImpl
