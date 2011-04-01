/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.model.workSpaceModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecp.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.ecp.model.workSpaceModel.WorkSpaceModelFactory;
import org.eclipse.emf.ecp.model.workSpaceModel.WorkSpaceModelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class WorkSpaceModelPackageImpl extends EPackageImpl implements WorkSpaceModelPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecpWorkspaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ecpProjectEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.ecp.model.workSpaceModel.WorkSpaceModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkSpaceModelPackageImpl() {
		super(eNS_URI, WorkSpaceModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * <p>
	 * This method is used to initialize {@link WorkSpaceModelPackage#eINSTANCE} when that field is accessed. Clients
	 * should not invoke it directly. Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorkSpaceModelPackage init() {
		if (isInited) return (WorkSpaceModelPackage)EPackage.Registry.INSTANCE.getEPackage(WorkSpaceModelPackage.eNS_URI);

		// Obtain or create and register package
		WorkSpaceModelPackageImpl theWorkSpaceModelPackage = (WorkSpaceModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WorkSpaceModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WorkSpaceModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theWorkSpaceModelPackage.createPackageContents();

		// Initialize created meta-data
		theWorkSpaceModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorkSpaceModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WorkSpaceModelPackage.eNS_URI, theWorkSpaceModelPackage);
		return theWorkSpaceModelPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECPWorkspace() {
		return ecpWorkspaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECPWorkspace_Projects() {
		return (EReference)ecpWorkspaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECPWorkspace_ActiveProject() {
		return (EReference)ecpWorkspaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getECPProject() {
		return ecpProjectEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECPProject_Workspace() {
		return (EReference)ecpProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getECPProject_RootObject() {
		return (EReference)ecpProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WorkSpaceModelFactory getWorkSpaceModelFactory() {
		return (WorkSpaceModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		ecpWorkspaceEClass = createEClass(ECP_WORKSPACE);
		createEReference(ecpWorkspaceEClass, ECP_WORKSPACE__PROJECTS);
		createEReference(ecpWorkspaceEClass, ECP_WORKSPACE__ACTIVE_PROJECT);

		ecpProjectEClass = createEClass(ECP_PROJECT);
		createEReference(ecpProjectEClass, ECP_PROJECT__WORKSPACE);
		createEReference(ecpProjectEClass, ECP_PROJECT__ROOT_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(ecpWorkspaceEClass, ECPWorkspace.class, "ECPWorkspace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getECPWorkspace_Projects(), this.getECPProject(), this.getECPProject_Workspace(), "projects", null, 0, -1, ECPWorkspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getECPWorkspace_ActiveProject(), this.getECPProject(), null, "activeProject", null, 0, 1, ECPWorkspace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ecpProjectEClass, ECPProject.class, "ECPProject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getECPProject_Workspace(), this.getECPWorkspace(), this.getECPWorkspace_Projects(), "workspace", null, 0, 1, ECPProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getECPProject_RootObject(), ecorePackage.getEObject(), null, "rootObject", null, 0, 1, ECPProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // WorkSpaceModelPackageImpl
