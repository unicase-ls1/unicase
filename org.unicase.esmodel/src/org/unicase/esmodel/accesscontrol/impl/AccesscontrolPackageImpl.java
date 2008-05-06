/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.accesscontrol.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.esmodel.EsmodelPackage;
import org.unicase.esmodel.accesscontrol.AccesscontrolFactory;
import org.unicase.esmodel.accesscontrol.AccesscontrolPackage;
import org.unicase.esmodel.accesscontrol.Group;
import org.unicase.esmodel.accesscontrol.OrgUnit;
import org.unicase.esmodel.accesscontrol.OrgUnitId;
import org.unicase.esmodel.accesscontrol.User;
import org.unicase.esmodel.accesscontrol.roles.RolesPackage;
import org.unicase.esmodel.accesscontrol.roles.impl.RolesPackageImpl;
import org.unicase.esmodel.changemanagment.ChangemanagmentPackage;
import org.unicase.esmodel.changemanagment.impl.ChangemanagmentPackageImpl;
import org.unicase.esmodel.impl.EsmodelPackageImpl;
import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccesscontrolPackageImpl extends EPackageImpl implements AccesscontrolPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orgUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orgUnitIdEClass = null;

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
	 * @see org.unicase.esmodel.accesscontrol.AccesscontrolPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AccesscontrolPackageImpl() {
		super(eNS_URI, AccesscontrolFactory.eINSTANCE);
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
	public static AccesscontrolPackage init() {
		if (isInited) return (AccesscontrolPackage)EPackage.Registry.INSTANCE.getEPackage(AccesscontrolPackage.eNS_URI);

		// Obtain or create and register package
		AccesscontrolPackageImpl theAccesscontrolPackage = (AccesscontrolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AccesscontrolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AccesscontrolPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ChangePackage.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EsmodelPackageImpl theEsmodelPackage = (EsmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI) instanceof EsmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EsmodelPackage.eNS_URI) : EsmodelPackage.eINSTANCE);
		ChangemanagmentPackageImpl theChangemanagmentPackage = (ChangemanagmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ChangemanagmentPackage.eNS_URI) instanceof ChangemanagmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ChangemanagmentPackage.eNS_URI) : ChangemanagmentPackage.eINSTANCE);
		RolesPackageImpl theRolesPackage = (RolesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) instanceof RolesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI) : RolesPackage.eINSTANCE);

		// Create package meta-data objects
		theAccesscontrolPackage.createPackageContents();
		theEsmodelPackage.createPackageContents();
		theChangemanagmentPackage.createPackageContents();
		theRolesPackage.createPackageContents();

		// Initialize created meta-data
		theAccesscontrolPackage.initializePackageContents();
		theEsmodelPackage.initializePackageContents();
		theChangemanagmentPackage.initializePackageContents();
		theRolesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAccesscontrolPackage.freeze();

		return theAccesscontrolPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_FirstName() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_LastName() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrgUnit() {
		return orgUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrgUnit_Name() {
		return (EAttribute)orgUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrgUnit_Roles() {
		return (EReference)orgUnitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrgUnit_Id() {
		return (EReference)orgUnitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOrgUnit_Description() {
		return (EAttribute)orgUnitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroup_Members() {
		return (EReference)groupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrgUnitId() {
		return orgUnitIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccesscontrolFactory getAccesscontrolFactory() {
		return (AccesscontrolFactory)getEFactoryInstance();
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
		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__FIRST_NAME);
		createEAttribute(userEClass, USER__LAST_NAME);

		orgUnitEClass = createEClass(ORG_UNIT);
		createEAttribute(orgUnitEClass, ORG_UNIT__NAME);
		createEReference(orgUnitEClass, ORG_UNIT__ROLES);
		createEReference(orgUnitEClass, ORG_UNIT__ID);
		createEAttribute(orgUnitEClass, ORG_UNIT__DESCRIPTION);

		groupEClass = createEClass(GROUP);
		createEReference(groupEClass, GROUP__MEMBERS);

		orgUnitIdEClass = createEClass(ORG_UNIT_ID);
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
		RolesPackage theRolesPackage = (RolesPackage)EPackage.Registry.INSTANCE.getEPackage(RolesPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theRolesPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		groupEClass.getESuperTypes().add(this.getOrgUnit());
		orgUnitIdEClass.getESuperTypes().add(theModelPackage.getUniqueIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_FirstName(), ecorePackage.getEString(), "firstName", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_LastName(), ecorePackage.getEString(), "lastName", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orgUnitEClass, OrgUnit.class, "OrgUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOrgUnit_Name(), ecorePackage.getEString(), "name", null, 1, 1, OrgUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrgUnit_Roles(), theRolesPackage.getRole(), null, "roles", null, 0, -1, OrgUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOrgUnit_Id(), this.getOrgUnitId(), null, "id", null, 0, 1, OrgUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOrgUnit_Description(), ecorePackage.getEString(), "description", null, 0, 1, OrgUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroup_Members(), this.getOrgUnit(), null, "members", null, 0, -1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orgUnitIdEClass, OrgUnitId.class, "OrgUnitId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //AccesscontrolPackageImpl
