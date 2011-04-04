/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.common.model.workSpaceModel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelFactory
 * @model kind="package"
 * @generated
 */
public interface WorkSpaceModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workSpaceModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/ecp/workspaceModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.ecp.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	WorkSpaceModelPackage eINSTANCE = org.eclipse.emf.ecp.common.model.workSpaceModel.impl.WorkSpaceModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPWorkspaceImpl <em>ECP Workspace</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPWorkspaceImpl
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.impl.WorkSpaceModelPackageImpl#getECPWorkspace()
	 * @generated
	 */
	int ECP_WORKSPACE = 0;

	/**
	 * The feature id for the '<em><b>Projects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECP_WORKSPACE__PROJECTS = 0;

	/**
	 * The feature id for the '<em><b>Active Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECP_WORKSPACE__ACTIVE_PROJECT = 1;

	/**
	 * The number of structural features of the '<em>ECP Workspace</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECP_WORKSPACE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPProjectImpl <em>ECP Project</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPProjectImpl
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.impl.WorkSpaceModelPackageImpl#getECPProject()
	 * @generated
	 */
	int ECP_PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Workspace</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECP_PROJECT__WORKSPACE = 0;

	/**
	 * The feature id for the '<em><b>Root Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECP_PROJECT__ROOT_OBJECT = 1;

	/**
	 * The number of structural features of the '<em>ECP Project</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ECP_PROJECT_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace <em>ECP Workspace</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECP Workspace</em>'.
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace
	 * @generated
	 */
	EClass getECPWorkspace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace#getProjects <em>Projects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Projects</em>'.
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace#getProjects()
	 * @see #getECPWorkspace()
	 * @generated
	 */
	EReference getECPWorkspace_Projects();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace#getActiveProject <em>Active Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Active Project</em>'.
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace#getActiveProject()
	 * @see #getECPWorkspace()
	 * @generated
	 */
	EReference getECPWorkspace_ActiveProject();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject <em>ECP Project</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>ECP Project</em>'.
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject
	 * @generated
	 */
	EClass getECPProject();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject#getWorkspace <em>Workspace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Workspace</em>'.
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject#getWorkspace()
	 * @see #getECPProject()
	 * @generated
	 */
	EReference getECPProject_Workspace();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject#getRootObject <em>Root Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root Object</em>'.
	 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject#getRootObject()
	 * @see #getECPProject()
	 * @generated
	 */
	EReference getECPProject_RootObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkSpaceModelFactory getWorkSpaceModelFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPWorkspaceImpl <em>ECP Workspace</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPWorkspaceImpl
		 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.impl.WorkSpaceModelPackageImpl#getECPWorkspace()
		 * @generated
		 */
		EClass ECP_WORKSPACE = eINSTANCE.getECPWorkspace();

		/**
		 * The meta object literal for the '<em><b>Projects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECP_WORKSPACE__PROJECTS = eINSTANCE.getECPWorkspace_Projects();

		/**
		 * The meta object literal for the '<em><b>Active Project</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECP_WORKSPACE__ACTIVE_PROJECT = eINSTANCE.getECPWorkspace_ActiveProject();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPProjectImpl <em>ECP Project</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.impl.ECPProjectImpl
		 * @see org.eclipse.emf.ecp.common.model.workSpaceModel.impl.WorkSpaceModelPackageImpl#getECPProject()
		 * @generated
		 */
		EClass ECP_PROJECT = eINSTANCE.getECPProject();

		/**
		 * The meta object literal for the '<em><b>Workspace</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECP_PROJECT__WORKSPACE = eINSTANCE.getECPProject_Workspace();

		/**
		 * The meta object literal for the '<em><b>Root Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECP_PROJECT__ROOT_OBJECT = eINSTANCE.getECPProject_RootObject();

	}

} // WorkSpaceModelPackage
