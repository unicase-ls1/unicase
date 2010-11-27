/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.xmi.XMIWorkspaceStructure.impl;


import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.xmi.XMIWorkspaceStructure.XMIECPContainer;
import org.unicase.xmi.XMIWorkspaceStructure.XMIECPFileProject;
import org.unicase.xmi.XMIWorkspaceStructure.XMIECPFolder;
import org.unicase.xmi.XMIWorkspaceStructure.XMIECPProject;
import org.unicase.xmi.XMIWorkspaceStructure.XMIECPVirtualContainer;
import org.unicase.xmi.XMIWorkspaceStructure.XMIWorkspaceStructureFactory;
import org.unicase.xmi.XMIWorkspaceStructure.XMIWorkspaceStructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XMIWorkspaceStructurePackageImpl extends EPackageImpl implements XMIWorkspaceStructurePackage {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmiecpContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmiecpVirtualContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmiecpFolderEClass = null;

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
	 * @see org.unicase.xmi.XMIWorkspaceStructure.XMIWorkspaceStructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XMIWorkspaceStructurePackageImpl() {
		super(eNS_URI, XMIWorkspaceStructureFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link XMIWorkspaceStructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XMIWorkspaceStructurePackage init() {
		if (isInited) return (XMIWorkspaceStructurePackage)EPackage.Registry.INSTANCE.getEPackage(XMIWorkspaceStructurePackage.eNS_URI);

		// Obtain or create and register package
		XMIWorkspaceStructurePackageImpl theXMIWorkspaceStructurePackage = (XMIWorkspaceStructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XMIWorkspaceStructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XMIWorkspaceStructurePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theXMIWorkspaceStructurePackage.createPackageContents();

		// Initialize created meta-data
		theXMIWorkspaceStructurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXMIWorkspaceStructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XMIWorkspaceStructurePackage.eNS_URI, theXMIWorkspaceStructurePackage);
		return theXMIWorkspaceStructurePackage;
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
	public EAttribute getXMIECPProject_Elements() {
		return (EAttribute)xmiecpProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMIECPProject_EditingDomain() {
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
	public EClass getXMIECPContainer() {
		return xmiecpContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMIECPContainer_InternalProjects() {
		return (EAttribute)xmiecpContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMIECPVirtualContainer() {
		return xmiecpVirtualContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMIECPVirtualContainer_XmiFilePath() {
		return (EAttribute)xmiecpVirtualContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMIECPFolder() {
		return xmiecpFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMIECPFolder_XmiDirectoryPath() {
		return (EAttribute)xmiecpFolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMIECPFolder_ContainedFiles() {
		return (EAttribute)xmiecpFolderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMIECPFolder_ProjectResources() {
		return (EReference)xmiecpFolderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMIWorkspaceStructureFactory getXMIWorkspaceStructureFactory() {
		return (XMIWorkspaceStructureFactory)getEFactoryInstance();
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
		createEAttribute(xmiecpProjectEClass, XMIECP_PROJECT__ELEMENTS);
		createEAttribute(xmiecpProjectEClass, XMIECP_PROJECT__EDITING_DOMAIN);

		xmiecpFileProjectEClass = createEClass(XMIECP_FILE_PROJECT);
		createEAttribute(xmiecpFileProjectEClass, XMIECP_FILE_PROJECT__XMI_FILE_PATH);

		xmiecpContainerEClass = createEClass(XMIECP_CONTAINER);
		createEAttribute(xmiecpContainerEClass, XMIECP_CONTAINER__INTERNAL_PROJECTS);

		xmiecpVirtualContainerEClass = createEClass(XMIECP_VIRTUAL_CONTAINER);
		createEAttribute(xmiecpVirtualContainerEClass, XMIECP_VIRTUAL_CONTAINER__XMI_FILE_PATH);

		xmiecpFolderEClass = createEClass(XMIECP_FOLDER);
		createEAttribute(xmiecpFolderEClass, XMIECP_FOLDER__XMI_DIRECTORY_PATH);
		createEAttribute(xmiecpFolderEClass, XMIECP_FOLDER__CONTAINED_FILES);
		createEReference(xmiecpFolderEClass, XMIECP_FOLDER__PROJECT_RESOURCES);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		xmiecpFileProjectEClass.getESuperTypes().add(this.getXMIECPProject());
		xmiecpContainerEClass.getESuperTypes().add(this.getXMIECPProject());
		xmiecpVirtualContainerEClass.getESuperTypes().add(this.getXMIECPContainer());
		xmiecpFolderEClass.getESuperTypes().add(this.getXMIECPContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(xmiecpProjectEClass, XMIECPProject.class, "XMIECPProject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getXMIECPProject_Elements(), g1, "elements", null, 0, 1, XMIECPProject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMIECPProject_EditingDomain(), ecorePackage.getEString(), "editingDomain", null, 0, 1, XMIECPProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(xmiecpProjectEClass, null, "getAllElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(xmiecpFileProjectEClass, XMIECPFileProject.class, "XMIECPFileProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXMIECPFileProject_XmiFilePath(), ecorePackage.getEString(), "xmiFilePath", null, 0, 1, XMIECPFileProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmiecpContainerEClass, XMIECPContainer.class, "XMIECPContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getXMIECPContainer_InternalProjects(), g1, "internalProjects", null, 0, 1, XMIECPContainer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(xmiecpContainerEClass, null, "getContainedProjects", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(xmiecpVirtualContainerEClass, XMIECPVirtualContainer.class, "XMIECPVirtualContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXMIECPVirtualContainer_XmiFilePath(), ecorePackage.getEString(), "xmiFilePath", null, 0, 1, XMIECPVirtualContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmiecpFolderEClass, XMIECPFolder.class, "XMIECPFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXMIECPFolder_XmiDirectoryPath(), ecorePackage.getEString(), "xmiDirectoryPath", null, 0, 1, XMIECPFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getXMIECPFolder_ContainedFiles(), g1, "containedFiles", null, 0, 1, XMIECPFolder.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXMIECPFolder_ProjectResources(), this.getXMIECPFileProject(), null, "projectResources", null, 0, -1, XMIECPFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //XMIWorkspaceStructurePackageImpl
