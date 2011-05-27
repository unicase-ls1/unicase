/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.xmiworkspacestructure.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.ecp.model.workSpaceModel.WorkSpaceModelPackage;

import org.unicase.xmi.xmiworkspacestructure.XMIECPFileProject;
import org.unicase.xmi.xmiworkspacestructure.XMIECPProject;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructureFactory;
import org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmiworkspacestructurePackageImpl extends EPackageImpl implements XmiworkspacestructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmiecpProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmiecpFileProjectEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.xmi.xmiworkspacestructure.XmiworkspacestructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XmiworkspacestructurePackageImpl() {
		super(eNS_URI, XmiworkspacestructureFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link XmiworkspacestructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XmiworkspacestructurePackage init() {
		if (isInited) return (XmiworkspacestructurePackage)EPackage.Registry.INSTANCE.getEPackage(XmiworkspacestructurePackage.eNS_URI);

		// Obtain or create and register package
		XmiworkspacestructurePackageImpl theXmiworkspacestructurePackage = (XmiworkspacestructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XmiworkspacestructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XmiworkspacestructurePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		WorkSpaceModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theXmiworkspacestructurePackage.createPackageContents();

		// Initialize created meta-data
		theXmiworkspacestructurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXmiworkspacestructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XmiworkspacestructurePackage.eNS_URI, theXmiworkspacestructurePackage);
		return theXmiworkspacestructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMIECPProject() {
		return xmiecpProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMIECPProject_ProjectName() {
		return (EAttribute)xmiecpProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMIECPProject_ProjectDescription() {
		return (EAttribute)xmiecpProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMIECPFileProject() {
		return xmiecpFileProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMIECPFileProject_XmiFilePath() {
		return (EAttribute)xmiecpFileProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmiworkspacestructureFactory getXmiworkspacestructureFactory() {
		return (XmiworkspacestructureFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		xmiecpProjectEClass = createEClass(XMIECP_PROJECT);
		createEAttribute(xmiecpProjectEClass, XMIECP_PROJECT__PROJECT_NAME);
		createEAttribute(xmiecpProjectEClass, XMIECP_PROJECT__PROJECT_DESCRIPTION);

		xmiecpFileProjectEClass = createEClass(XMIECP_FILE_PROJECT);
		createEAttribute(xmiecpFileProjectEClass, XMIECP_FILE_PROJECT__XMI_FILE_PATH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		WorkSpaceModelPackage theWorkSpaceModelPackage = (WorkSpaceModelPackage)EPackage.Registry.INSTANCE.getEPackage(WorkSpaceModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xmiecpProjectEClass.getESuperTypes().add(theWorkSpaceModelPackage.getECPProject());
		xmiecpFileProjectEClass.getESuperTypes().add(this.getXMIECPProject());

		// Initialize classes and features; add operations and parameters
		initEClass(xmiecpProjectEClass, XMIECPProject.class, "XMIECPProject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXMIECPProject_ProjectName(), ecorePackage.getEString(), "projectName", "\"New Project\"", 0, 1, XMIECPProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMIECPProject_ProjectDescription(), ecorePackage.getEString(), "projectDescription", "\"Empty new Project\"", 0, 1, XMIECPProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmiecpFileProjectEClass, XMIECPFileProject.class, "XMIECPFileProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXMIECPFileProject_XmiFilePath(), ecorePackage.getEString(), "xmiFilePath", null, 0, 1, XMIECPFileProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XmiworkspacestructurePackageImpl
