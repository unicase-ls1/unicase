/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.orga.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.model.ModelPackage;

import org.unicase.model.diagram.DiagramPackage;

import org.unicase.model.orga.Employee;
import org.unicase.model.orga.OrgDiagram;
import org.unicase.model.orga.OrgaFactory;
import org.unicase.model.orga.OrgaPackage;
import org.unicase.model.orga.OrgaUnit;
import org.unicase.model.orga.Team;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OrgaPackageImpl extends EPackageImpl implements OrgaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orgaUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass teamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass employeeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orgDiagramEClass = null;

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
	 * @see org.unicase.model.orga.OrgaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OrgaPackageImpl() {
		super(eNS_URI, OrgaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OrgaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OrgaPackage init() {
		if (isInited) return (OrgaPackage)EPackage.Registry.INSTANCE.getEPackage(OrgaPackage.eNS_URI);

		// Obtain or create and register package
		OrgaPackageImpl theOrgaPackage = (OrgaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OrgaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OrgaPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOrgaPackage.createPackageContents();

		// Initialize created meta-data
		theOrgaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOrgaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OrgaPackage.eNS_URI, theOrgaPackage);
		return theOrgaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrgaUnit() {
		return orgaUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTeam() {
		return teamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTeam_HasOrgUnit() {
		return (EReference)teamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmployee() {
		return employeeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrgDiagram() {
		return orgDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrgaFactory getOrgaFactory() {
		return (OrgaFactory)getEFactoryInstance();
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
		orgaUnitEClass = createEClass(ORGA_UNIT);

		teamEClass = createEClass(TEAM);
		createEReference(teamEClass, TEAM__HAS_ORG_UNIT);

		employeeEClass = createEClass(EMPLOYEE);

		orgDiagramEClass = createEClass(ORG_DIAGRAM);
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
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		DiagramPackage theDiagramPackage = (DiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		orgaUnitEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		teamEClass.getESuperTypes().add(this.getOrgaUnit());
		employeeEClass.getESuperTypes().add(this.getOrgaUnit());
		orgDiagramEClass.getESuperTypes().add(theDiagramPackage.getMEDiagram());

		// Initialize classes and features; add operations and parameters
		initEClass(orgaUnitEClass, OrgaUnit.class, "OrgaUnit", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(teamEClass, Team.class, "Team", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTeam_HasOrgUnit(), this.getOrgaUnit(), null, "hasOrgUnit", null, 0, -1, Team.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(employeeEClass, Employee.class, "Employee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orgDiagramEClass, OrgDiagram.class, "OrgDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //OrgaPackageImpl
