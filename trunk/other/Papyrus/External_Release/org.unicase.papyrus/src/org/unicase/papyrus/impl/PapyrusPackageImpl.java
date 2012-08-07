/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.unicase.papyrus.PapyrusFactory;
import org.unicase.papyrus.PapyrusPackage;
import org.unicase.papyrus.SysMLClass;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.papyrus.SysMLModel;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.UMLModel;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class PapyrusPackageImpl extends EPackageImpl implements PapyrusPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass umlModelEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass sysMLModelEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass sysMLClassEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum umlDiagramTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum sysMLDiagramTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.papyrus.PapyrusPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrusPackageImpl() {
		super(eNS_URI, PapyrusFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * <p>
	 * This method is used to initialize {@link PapyrusPackage#eINSTANCE} when that field is accessed. Clients should
	 * not invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @return a newly initialized {@link PapyrusPackage}
	 * @generated
	 */
	public static PapyrusPackage init() {
		if (isInited) {
			return (PapyrusPackage) EPackage.Registry.INSTANCE.getEPackage(PapyrusPackage.eNS_URI);
		}

		// Obtain or create and register package
		PapyrusPackageImpl thePapyrusPackage = (PapyrusPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PapyrusPackageImpl ? EPackage.Registry.INSTANCE
			.get(eNS_URI) : new PapyrusPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrusPackage.createPackageContents();

		// Initialize created meta-data
		thePapyrusPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrusPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PapyrusPackage.eNS_URI, thePapyrusPackage);
		return thePapyrusPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUMLModel() {
		return umlModelEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getUMLModel_GmfDiagram() {
		return (EReference) umlModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUMLModel_DiagramType() {
		return (EAttribute) umlModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSysMLModel() {
		return sysMLModelEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSysMLModel_GmfDiagram() {
		return (EReference) sysMLModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSysMLModel_DiagramType() {
		return (EAttribute) sysMLModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSysMLClass() {
		return sysMLClassEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSysMLClass_GmfDiagram() {
		return (EReference) sysMLClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getUMLDiagramType() {
		return umlDiagramTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getSysMLDiagramType() {
		return sysMLDiagramTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PapyrusFactory getPapyrusFactory() {
		return (PapyrusFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
	 * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		umlModelEClass = createEClass(UML_MODEL);
		createEReference(umlModelEClass, UML_MODEL__GMF_DIAGRAM);
		createEAttribute(umlModelEClass, UML_MODEL__DIAGRAM_TYPE);

		sysMLModelEClass = createEClass(SYS_ML_MODEL);
		createEReference(sysMLModelEClass, SYS_ML_MODEL__GMF_DIAGRAM);
		createEAttribute(sysMLModelEClass, SYS_ML_MODEL__DIAGRAM_TYPE);

		sysMLClassEClass = createEClass(SYS_ML_CLASS);
		createEReference(sysMLClassEClass, SYS_ML_CLASS__GMF_DIAGRAM);

		// Create enums
		umlDiagramTypeEEnum = createEEnum(UML_DIAGRAM_TYPE);
		sysMLDiagramTypeEEnum = createEEnum(SYS_ML_DIAGRAM_TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
	 * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		NotationPackage theNotationPackage = (NotationPackage) EPackage.Registry.INSTANCE
			.getEPackage(NotationPackage.eNS_URI);

		// Change critical GMF runtime information
		if (theNotationPackage.getView_SourceEdges().isChangeable()) {
			theNotationPackage.getView_SourceEdges().setChangeable(false);
		}
		if (theNotationPackage.getView_TargetEdges().isChangeable()) {
			theNotationPackage.getView_TargetEdges().setChangeable(false);
		}

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		umlModelEClass.getESuperTypes().add(theUMLPackage.getModel());
		sysMLModelEClass.getESuperTypes().add(theUMLPackage.getModel());
		sysMLClassEClass.getESuperTypes().add(theUMLPackage.getClass_());

		// Initialize classes and features; add operations and parameters
		initEClass(umlModelEClass, UMLModel.class, "UMLModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUMLModel_GmfDiagram(), theNotationPackage.getDiagram(), null, "gmfDiagram", null, 0, 1,
			UMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLModel_DiagramType(), this.getUMLDiagramType(), "diagramType", "", 0, 1, UMLModel.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sysMLModelEClass, SysMLModel.class, "SysMLModel", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSysMLModel_GmfDiagram(), theNotationPackage.getDiagram(), null, "gmfDiagram", null, 0, 1,
			SysMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSysMLModel_DiagramType(), this.getSysMLDiagramType(), "diagramType", null, 0, 1,
			SysMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		initEClass(sysMLClassEClass, SysMLClass.class, "SysMLClass", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSysMLClass_GmfDiagram(), theNotationPackage.getDiagram(), null, "gmfDiagram", null, 0, 1,
			SysMLClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(umlDiagramTypeEEnum, UMLDiagramType.class, "UMLDiagramType");
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.NO_DIAGRAM);
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.ACTIVITY);
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.CLASS);
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.COMMUNICATION);
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.COMPOSITE);
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.PACKAGE);
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.SEQUENCE);
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.STATE_MACHINE);
		addEEnumLiteral(umlDiagramTypeEEnum, UMLDiagramType.USE_CASE);

		initEEnum(sysMLDiagramTypeEEnum, SysMLDiagramType.class, "SysMLDiagramType");
		addEEnumLiteral(sysMLDiagramTypeEEnum, SysMLDiagramType.NO_DIAGRAM);
		addEEnumLiteral(sysMLDiagramTypeEEnum, SysMLDiagramType.PARAMETRIC);
		addEEnumLiteral(sysMLDiagramTypeEEnum, SysMLDiagramType.BLOCK_DEFINITION);
		addEEnumLiteral(sysMLDiagramTypeEEnum, SysMLDiagramType.REQUIREMENT);
		addEEnumLiteral(sysMLDiagramTypeEEnum, SysMLDiagramType.INTERNAL_BLOCK);

		// Create resource
		createResource(eNS_URI);
	}

} // PapyrusPackageImpl
