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
package org.eclipse.emf.emfstore.server.model.accesscontrol.roles.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.*;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ProjectAdminRole;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ReaderRole;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesFactory;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.RolesPackage;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.ServerAdmin;
import org.eclipse.emf.emfstore.server.model.accesscontrol.roles.WriterRole;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class RolesFactoryImpl extends EFactoryImpl implements RolesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static RolesFactory init() {
		try {
			RolesFactory theRolesFactory = (RolesFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://eclipse.org/emf/emfstore/server/model/roles");
			if (theRolesFactory != null) {
				return theRolesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RolesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RolesFactoryImpl() {
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
		case RolesPackage.READER_ROLE:
			return createReaderRole();
		case RolesPackage.WRITER_ROLE:
			return createWriterRole();
		case RolesPackage.PROJECT_ADMIN_ROLE:
			return createProjectAdminRole();
		case RolesPackage.SERVER_ADMIN:
			return createServerAdmin();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReaderRole createReaderRole() {
		ReaderRoleImpl readerRole = new ReaderRoleImpl();
		return readerRole;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WriterRole createWriterRole() {
		WriterRoleImpl writerRole = new WriterRoleImpl();
		return writerRole;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectAdminRole createProjectAdminRole() {
		ProjectAdminRoleImpl projectAdminRole = new ProjectAdminRoleImpl();
		return projectAdminRole;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ServerAdmin createServerAdmin() {
		ServerAdminImpl serverAdmin = new ServerAdminImpl();
		return serverAdmin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RolesPackage getRolesPackage() {
		return (RolesPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RolesPackage getPackage() {
		return RolesPackage.eINSTANCE;
	}

} // RolesFactoryImpl
