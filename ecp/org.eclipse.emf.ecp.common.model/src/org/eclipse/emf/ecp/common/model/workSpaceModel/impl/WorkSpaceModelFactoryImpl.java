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
package org.eclipse.emf.ecp.common.model.workSpaceModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelFactory;
import org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class WorkSpaceModelFactoryImpl extends EFactoryImpl implements WorkSpaceModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WorkSpaceModelFactory init() {
		try {
			WorkSpaceModelFactory theWorkSpaceModelFactory = (WorkSpaceModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/emf/ecp/common/model/workspaceModel"); 
			if (theWorkSpaceModelFactory != null) {
				return theWorkSpaceModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorkSpaceModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkSpaceModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WorkSpaceModelPackage.ECP_WORKSPACE: return createECPWorkspace();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ECPWorkspace createECPWorkspace() {
		ECPWorkspaceImpl ecpWorkspace = new ECPWorkspaceImpl();
		return ecpWorkspace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkSpaceModelPackage getWorkSpaceModelPackage() {
		return (WorkSpaceModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WorkSpaceModelPackage getPackage() {
		return WorkSpaceModelPackage.eINSTANCE;
	}

} // WorkSpaceModelFactoryImpl
