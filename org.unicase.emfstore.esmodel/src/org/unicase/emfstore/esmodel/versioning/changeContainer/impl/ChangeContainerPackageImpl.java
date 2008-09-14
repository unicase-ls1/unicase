/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.changeContainer.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.impl.AccesscontrolPackageImpl;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainer;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerFactory;
import org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerPackage;
import org.unicase.emfstore.esmodel.versioning.changeContainer.CompositeChangeContainer;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChangeContainerPackageImpl extends EPackageImpl implements
		ChangeContainerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeChangeContainerEClass = null;

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
	 * @see org.unicase.emfstore.esmodel.versioning.changeContainer.ChangeContainerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ChangeContainerPackageImpl() {
		super(eNS_URI, ChangeContainerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ChangeContainerPackage init() {
		if (isInited)
			return (ChangeContainerPackage) EPackage.Registry.INSTANCE
					.getEPackage(ChangeContainerPackage.eNS_URI);

		// Obtain or create and register package
		ChangeContainerPackageImpl theChangeContainerPackage = (ChangeContainerPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof ChangeContainerPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI)
				: new ChangeContainerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ChangePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EsmodelPackage.eNS_URI)
				: EsmodelPackage.eINSTANCE);
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(VersioningPackage.eNS_URI)
				: VersioningPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI)
				: OperationsPackage.eINSTANCE);
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(AccesscontrolPackage.eNS_URI)
				: AccesscontrolPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RolesPackage.eNS_URI)
				: RolesPackage.eINSTANCE);

		// Create package meta-data objects
		theChangeContainerPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theAccesscontrolPackage.createPackageContents();
		theRolesPackage.createPackageContents();

		// Initialize created meta-data
		theChangeContainerPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theAccesscontrolPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theChangeContainerPackage.freeze();

		return theChangeContainerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangeContainer() {
		return changeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeContainer_ForwardDelta() {
		return (EAttribute) changeContainerEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeContainer_BackwardDelta() {
		return (EAttribute) changeContainerEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeChangeContainer() {
		return compositeChangeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeChangeContainer_Name() {
		return (EAttribute) compositeChangeContainerEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeChangeContainer_Description() {
		return (EAttribute) compositeChangeContainerEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeContainerFactory getChangeContainerFactory() {
		return (ChangeContainerFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		changeContainerEClass = createEClass(CHANGE_CONTAINER);
		createEAttribute(changeContainerEClass, CHANGE_CONTAINER__FORWARD_DELTA);
		createEAttribute(changeContainerEClass,
				CHANGE_CONTAINER__BACKWARD_DELTA);

		compositeChangeContainerEClass = createEClass(COMPOSITE_CHANGE_CONTAINER);
		createEAttribute(compositeChangeContainerEClass,
				COMPOSITE_CHANGE_CONTAINER__NAME);
		createEAttribute(compositeChangeContainerEClass,
				COMPOSITE_CHANGE_CONTAINER__DESCRIPTION);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI);
		OperationsPackage theOperationsPackage = (OperationsPackage) EPackage.Registry.INSTANCE
				.getEPackage(OperationsPackage.eNS_URI);
		ChangePackage theChangePackage = (ChangePackage) EPackage.Registry.INSTANCE
				.getEPackage(ChangePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		compositeChangeContainerEClass.getESuperTypes().add(
				this.getChangeContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(changeContainerEClass, ChangeContainer.class,
				"ChangeContainer", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChangeContainer_ForwardDelta(), ecorePackage
				.getEString(), "forwardDelta", null, 1, 1,
				ChangeContainer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getChangeContainer_BackwardDelta(), ecorePackage
				.getEString(), "backwardDelta", null, 1, 1,
				ChangeContainer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		addEOperation(changeContainerEClass, this.getChangeContainer(),
				"reverse", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(changeContainerEClass, null, "apply", 0,
				1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage.getProject(), "project", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		addEOperation(changeContainerEClass, theOperationsPackage
				.getAbstractOperation(), "getOperations", 0, -1, IS_UNIQUE,
				IS_ORDERED);

		op = addEOperation(changeContainerEClass, null, "init", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage.getProject(), "project", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theChangePackage.getChangeDescription(),
				"backwardChangeDescription", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(compositeChangeContainerEClass,
				CompositeChangeContainer.class, "CompositeChangeContainer",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeChangeContainer_Name(), ecorePackage
				.getEString(), "name", null, 0, 1,
				CompositeChangeContainer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getCompositeChangeContainer_Description(), ecorePackage
				.getEString(), "description", null, 0, 1,
				CompositeChangeContainer.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		op = addEOperation(compositeChangeContainerEClass, null, "init", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theModelPackage.getProject(), "project", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theChangePackage.getChangeDescription(),
				"backwardChangeDescription", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "description", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		// Create annotations
		// teneo.jpa
		createTeneoAnnotations();
	}

	/**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTeneoAnnotations() {
		String source = "teneo.jpa";
		addAnnotation(getChangeContainer_ForwardDelta(), source, new String[] {
				"value", "@Type(type=\"text\")" });
		addAnnotation(getChangeContainer_BackwardDelta(), source, new String[] {
				"value", "@Type(type=\"text\")" });
	}

} //ChangeContainerPackageImpl
