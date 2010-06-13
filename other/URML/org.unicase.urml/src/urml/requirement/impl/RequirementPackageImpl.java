/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.metamodel.MetamodelPackage;

import org.unicase.model.ModelPackage;

import org.unicase.model.urml.UrmlPackage;

import org.unicase.model.urml.impl.UrmlPackageImpl;

import urml.danger.DangerPackage;

import urml.danger.impl.DangerPackageImpl;

import urml.goal.GoalPackage;

import urml.goal.impl.GoalPackageImpl;

import urml.requirement.FunctionalRequirement;
import urml.requirement.NonFunctionalRequirement;
import urml.requirement.Requirement;
import urml.requirement.RequirementFactory;
import urml.requirement.RequirementPackage;

import urml.service.ServicePackage;

import urml.service.impl.ServicePackageImpl;

import urml.usecase.UsecasePackage;

import urml.usecase.impl.UsecasePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RequirementPackageImpl extends EPackageImpl implements RequirementPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionalRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonFunctionalRequirementEClass = null;

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
	 * @see urml.requirement.RequirementPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RequirementPackageImpl() {
		super(eNS_URI, RequirementFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RequirementPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RequirementPackage init() {
		if (isInited)
			return (RequirementPackage) EPackage.Registry.INSTANCE.getEPackage(RequirementPackage.eNS_URI);

		// Obtain or create and register package
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
			.get(eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
			: new RequirementPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		UrmlPackageImpl theUrmlPackage = (UrmlPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UrmlPackage.eNS_URI) instanceof UrmlPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UrmlPackage.eNS_URI)
			: UrmlPackage.eINSTANCE);
		GoalPackageImpl theGoalPackage = (GoalPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(GoalPackage.eNS_URI) instanceof GoalPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(GoalPackage.eNS_URI)
			: GoalPackage.eINSTANCE);
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(UsecasePackage.eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UsecasePackage.eNS_URI) : UsecasePackage.eINSTANCE);
		ServicePackageImpl theServicePackage = (ServicePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI) instanceof ServicePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI) : ServicePackage.eINSTANCE);
		DangerPackageImpl theDangerPackage = (DangerPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DangerPackage.eNS_URI) instanceof DangerPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DangerPackage.eNS_URI) : DangerPackage.eINSTANCE);

		// Create package meta-data objects
		theRequirementPackage.createPackageContents();
		theUrmlPackage.createPackageContents();
		theGoalPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theServicePackage.createPackageContents();
		theDangerPackage.createPackageContents();

		// Initialize created meta-data
		theRequirementPackage.initializePackageContents();
		theUrmlPackage.initializePackageContents();
		theGoalPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theServicePackage.initializePackageContents();
		theDangerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRequirementPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RequirementPackage.eNS_URI, theRequirementPackage);
		return theRequirementPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_ImplementingServices() {
		return (EReference) requirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionalRequirement() {
		return functionalRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionalRequirement_DetailedFeatures() {
		return (EReference) functionalRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionalRequirement_SubRequirements() {
		return (EReference) functionalRequirementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionalRequirement_ParentRequirement() {
		return (EReference) functionalRequirementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonFunctionalRequirement() {
		return nonFunctionalRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonFunctionalRequirement_ConstrainedFeatures() {
		return (EReference) nonFunctionalRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementFactory getRequirementFactory() {
		return (RequirementFactory) getEFactoryInstance();
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
		requirementEClass = createEClass(REQUIREMENT);
		createEReference(requirementEClass, REQUIREMENT__IMPLEMENTING_SERVICES);

		functionalRequirementEClass = createEClass(FUNCTIONAL_REQUIREMENT);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__DETAILED_FEATURES);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__SUB_REQUIREMENTS);
		createEReference(functionalRequirementEClass, FUNCTIONAL_REQUIREMENT__PARENT_REQUIREMENT);

		nonFunctionalRequirementEClass = createEClass(NON_FUNCTIONAL_REQUIREMENT);
		createEReference(nonFunctionalRequirementEClass, NON_FUNCTIONAL_REQUIREMENT__CONSTRAINED_FEATURES);
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
		DangerPackage theDangerPackage = (DangerPackage) EPackage.Registry.INSTANCE.getEPackage(DangerPackage.eNS_URI);
		ServicePackage theServicePackage = (ServicePackage) EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(MetamodelPackage.eNS_URI);
		UrmlPackage theUrmlPackage = (UrmlPackage) EPackage.Registry.INSTANCE.getEPackage(UrmlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		requirementEClass.getESuperTypes().add(theDangerPackage.getMitigation());
		functionalRequirementEClass.getESuperTypes().add(this.getRequirement());
		nonFunctionalRequirementEClass.getESuperTypes().add(this.getRequirement());

		// Initialize classes and features; add operations and parameters
		initEClass(requirementEClass, Requirement.class, "Requirement", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirement_ImplementingServices(), theServicePackage.getService(), theServicePackage
			.getService_SatisfiedRequirements(), "implementingServices", null, 0, -1, Requirement.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		getRequirement_ImplementingServices().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(functionalRequirementEClass, FunctionalRequirement.class, "FunctionalRequirement", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionalRequirement_DetailedFeatures(), theUrmlPackage.getFeature(), theUrmlPackage
			.getFeature_DetailingFunctionalRequirements(), "detailedFeatures", null, 0, -1,
			FunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFunctionalRequirement_DetailedFeatures().getEKeys().add(
			theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getFunctionalRequirement_SubRequirements(), this.getFunctionalRequirement(), this
			.getFunctionalRequirement_ParentRequirement(), "subRequirements", null, 0, -1, FunctionalRequirement.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionalRequirement_ParentRequirement(), this.getFunctionalRequirement(), this
			.getFunctionalRequirement_SubRequirements(), "parentRequirement", null, 0, 1, FunctionalRequirement.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getFunctionalRequirement_ParentRequirement().getEKeys().add(
			theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(nonFunctionalRequirementEClass, NonFunctionalRequirement.class, "NonFunctionalRequirement",
			!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNonFunctionalRequirement_ConstrainedFeatures(), theUrmlPackage.getFeature(), theUrmlPackage
			.getFeature_ConstrainingNonFunctionalRequirements(), "constrainedFeatures", null, 0, -1,
			NonFunctionalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getNonFunctionalRequirement_ConstrainedFeatures().getEKeys().add(
			theMetamodelPackage.getIdentifiableElement_Identifier());
	}

} //RequirementPackageImpl
