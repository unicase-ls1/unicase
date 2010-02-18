/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.emfstore.esmodel.accesscontrol.ACGroup;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnit;
import org.unicase.emfstore.esmodel.accesscontrol.ACOrgUnitId;
import org.unicase.emfstore.esmodel.accesscontrol.ACUser;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.emfstore.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.emfstore.esmodel.impl.EsmodelPackageImpl;
import org.unicase.emfstore.esmodel.notification.NotificationPackage;
import org.unicase.emfstore.esmodel.notification.impl.NotificationPackageImpl;
import org.unicase.emfstore.esmodel.url.UrlPackage;
import org.unicase.emfstore.esmodel.url.impl.UrlPackageImpl;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;
import org.unicase.emfstore.esmodel.versioning.events.EventsPackage;
import org.unicase.emfstore.esmodel.versioning.events.impl.EventsPackageImpl;
import org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticPackage;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticPackageImpl;
import org.unicase.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class AccesscontrolPackageImpl extends EPackageImpl implements AccesscontrolPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass acUserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass acOrgUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass acGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass acOrgUnitIdEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass orgUnitPropertyEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AccesscontrolPackageImpl() {
		super(eNS_URI, AccesscontrolFactory.eINSTANCE);
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
	 * This method is used to initialize {@link AccesscontrolPackage#eINSTANCE} when that field is accessed. Clients
	 * should not invoke it directly. Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AccesscontrolPackage init() {
		if (isInited)
			return (AccesscontrolPackage) EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI);

		// Obtain or create and register package
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl) (EPackage.Registry.INSTANCE
			.get(eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
			: new AccesscontrolPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MetamodelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(EsmodelPackage.eNS_URI) : EsmodelPackage.eINSTANCE);
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(VersioningPackage.eNS_URI) : VersioningPackage.eINSTANCE);
		OperationsPackageImpl theOperationsPackage = (OperationsPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(OperationsPackage.eNS_URI) instanceof OperationsPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(OperationsPackage.eNS_URI) : OperationsPackage.eINSTANCE);
		SemanticPackageImpl theSemanticPackage = (SemanticPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(SemanticPackage.eNS_URI) instanceof SemanticPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(SemanticPackage.eNS_URI) : SemanticPackage.eINSTANCE);
		EventsPackageImpl theEventsPackage = (EventsPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);
		NotificationPackageImpl theNotificationPackage = (NotificationPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(NotificationPackage.eNS_URI) instanceof NotificationPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(NotificationPackage.eNS_URI) : NotificationPackage.eINSTANCE);
		UrlPackageImpl theUrlPackage = (UrlPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UrlPackage.eNS_URI) instanceof UrlPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UrlPackage.eNS_URI)
			: UrlPackage.eINSTANCE);

		// Create package meta-data objects
		theAccesscontrolPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theOperationsPackage.createPackageContents();
		theSemanticPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theRolesPackage.createPackageContents();
		theNotificationPackage.createPackageContents();
		theUrlPackage.createPackageContents();

		// Initialize created meta-data
		theAccesscontrolPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theOperationsPackage.initializePackageContents();
		theSemanticPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();
		theNotificationPackage.initializePackageContents();
		theUrlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAccesscontrolPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AccesscontrolPackage.eNS_URI, theAccesscontrolPackage);
		return theAccesscontrolPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getACUser() {
		return acUserEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getACUser_FirstName() {
		return (EAttribute) acUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getACUser_LastName() {
		return (EAttribute) acUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getACOrgUnit() {
		return acOrgUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getACOrgUnit_Name() {
		return (EAttribute) acOrgUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getACOrgUnit_Roles() {
		return (EReference) acOrgUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getACOrgUnit_Description() {
		return (EAttribute) acOrgUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getACOrgUnit_Properties() {
		return (EReference) acOrgUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getACGroup() {
		return acGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getACGroup_Members() {
		return (EReference) acGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getACOrgUnitId() {
		return acOrgUnitIdEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOrgUnitProperty() {
		return orgUnitPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getOrgUnitProperty_Name() {
		return (EAttribute) orgUnitPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getOrgUnitProperty_Value() {
		return (EAttribute) orgUnitPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOrgUnitProperty_Project() {
		return (EReference) orgUnitPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AccesscontrolFactory getAccesscontrolFactory() {
		return (AccesscontrolFactory) getEFactoryInstance();
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
		acUserEClass = createEClass(AC_USER);
		createEAttribute(acUserEClass, AC_USER__FIRST_NAME);
		createEAttribute(acUserEClass, AC_USER__LAST_NAME);

		acOrgUnitEClass = createEClass(AC_ORG_UNIT);
		createEAttribute(acOrgUnitEClass, AC_ORG_UNIT__NAME);
		createEReference(acOrgUnitEClass, AC_ORG_UNIT__ROLES);
		createEAttribute(acOrgUnitEClass, AC_ORG_UNIT__DESCRIPTION);
		createEReference(acOrgUnitEClass, AC_ORG_UNIT__PROPERTIES);

		acGroupEClass = createEClass(AC_GROUP);
		createEReference(acGroupEClass, AC_GROUP__MEMBERS);

		acOrgUnitIdEClass = createEClass(AC_ORG_UNIT_ID);

		orgUnitPropertyEClass = createEClass(ORG_UNIT_PROPERTY);
		createEAttribute(orgUnitPropertyEClass, ORG_UNIT_PROPERTY__NAME);
		createEAttribute(orgUnitPropertyEClass, ORG_UNIT_PROPERTY__VALUE);
		createEReference(orgUnitPropertyEClass, ORG_UNIT_PROPERTY__PROJECT);
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
		RolesPackage theRolesPackage = (RolesPackage) EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(MetamodelPackage.eNS_URI);
		EsmodelPackage theEsmodelPackage = (EsmodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(EsmodelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theRolesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		acUserEClass.getESuperTypes().add(this.getACOrgUnit());
		acOrgUnitEClass.getESuperTypes().add(theMetamodelPackage.getIdentifiableElement());
		acGroupEClass.getESuperTypes().add(this.getACOrgUnit());
		acOrgUnitIdEClass.getESuperTypes().add(theMetamodelPackage.getUniqueIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(acUserEClass, ACUser.class, "ACUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getACUser_FirstName(), ecorePackage.getEString(), "firstName", null, 0, 1, ACUser.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getACUser_LastName(), ecorePackage.getEString(), "lastName", null, 0, 1, ACUser.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(acOrgUnitEClass, ACOrgUnit.class, "ACOrgUnit", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getACOrgUnit_Name(), ecorePackage.getEString(), "name", null, 1, 1, ACOrgUnit.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getACOrgUnit_Roles(), theRolesPackage.getRole(), null, "roles", null, 0, -1, ACOrgUnit.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEAttribute(getACOrgUnit_Description(), ecorePackage.getEString(), "description", null, 0, 1,
			ACOrgUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getACOrgUnit_Properties(), this.getOrgUnitProperty(), null, "properties", null, 0, -1,
			ACOrgUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(acOrgUnitEClass, this.getACOrgUnitId(), "getId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(acGroupEClass, ACGroup.class, "ACGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getACGroup_Members(), this.getACOrgUnit(), null, "members", null, 0, -1, ACGroup.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getACGroup_Members().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(acOrgUnitIdEClass, ACOrgUnitId.class, "ACOrgUnitId", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(orgUnitPropertyEClass, OrgUnitProperty.class, "OrgUnitProperty", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrgUnitProperty_Name(), ecorePackage.getEString(), "name", null, 0, 1, OrgUnitProperty.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrgUnitProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1,
			OrgUnitProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getOrgUnitProperty_Project(), theEsmodelPackage.getProjectId(), null, "project", null, 0, 1,
			OrgUnitProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getOrgUnitProperty_Project().getEKeys().add(theMetamodelPackage.getUniqueIdentifier_Id());
	}

} // AccesscontrolPackageImpl
