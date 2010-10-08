/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.goal.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.danger.impl.DangerPackageImpl;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.impl.FeaturePackageImpl;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.goal.GoalFactory;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.GoalReference;
import org.unicase.model.urml.goal.GoalReferenceType;
import org.unicase.model.urml.goal.GoalType;
import org.unicase.model.urml.impl.UrmlPackageImpl;
import org.unicase.model.urml.requirement.RequirementPackage;
import org.unicase.model.urml.requirement.impl.RequirementPackageImpl;
import org.unicase.model.urml.service.ServicePackage;
import org.unicase.model.urml.service.impl.ServicePackageImpl;
import org.unicase.model.urml.usecase.UsecasePackage;
import org.unicase.model.urml.usecase.impl.UsecasePackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class GoalPackageImpl extends EPackageImpl implements GoalPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass goalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass goalReferenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum goalTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum goalReferenceTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.urml.goal.GoalPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GoalPackageImpl() {
		super(eNS_URI, GoalFactory.eINSTANCE);
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
	 * This method is used to initialize {@link GoalPackage#eINSTANCE} when that field is accessed. Clients should not
	 * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GoalPackage init() {
		if (isInited)
			return (GoalPackage) EPackage.Registry.INSTANCE.getEPackage(GoalPackage.eNS_URI);

		// Obtain or create and register package
		GoalPackageImpl theGoalPackage = (GoalPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GoalPackageImpl ? EPackage.Registry.INSTANCE
			.get(eNS_URI)
			: new GoalPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		UrmlPackageImpl theUrmlPackage = (UrmlPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UrmlPackage.eNS_URI) instanceof UrmlPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UrmlPackage.eNS_URI)
			: UrmlPackage.eINSTANCE);
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI) : RequirementPackage.eINSTANCE);
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(UsecasePackage.eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UsecasePackage.eNS_URI) : UsecasePackage.eINSTANCE);
		ServicePackageImpl theServicePackage = (ServicePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI) instanceof ServicePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI) : ServicePackage.eINSTANCE);
		DangerPackageImpl theDangerPackage = (DangerPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(DangerPackage.eNS_URI) instanceof DangerPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(DangerPackage.eNS_URI) : DangerPackage.eINSTANCE);
		FeaturePackageImpl theFeaturePackage = (FeaturePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(FeaturePackage.eNS_URI) instanceof FeaturePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(FeaturePackage.eNS_URI) : FeaturePackage.eINSTANCE);

		// Create package meta-data objects
		theGoalPackage.createPackageContents();
		theUrmlPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theServicePackage.createPackageContents();
		theDangerPackage.createPackageContents();
		theFeaturePackage.createPackageContents();

		// Initialize created meta-data
		theGoalPackage.initializePackageContents();
		theUrmlPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theServicePackage.initializePackageContents();
		theDangerPackage.initializePackageContents();
		theFeaturePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGoalPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GoalPackage.eNS_URI, theGoalPackage);
		return theGoalPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGoal() {
		return goalEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGoal_Soft() {
		return (EAttribute) goalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGoal_Type() {
		return (EAttribute) goalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoal_Stakeholders() {
		return (EReference) goalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoal_RealizedFeatures() {
		return (EReference) goalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoal_DetailingUseCases() {
		return (EReference) goalEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoal_SubGoals() {
		return (EReference) goalEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoal_ParentGoal() {
		return (EReference) goalEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoal_InfluencingGoals() {
		return (EReference) goalEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoal_InfluencedGoals() {
		return (EReference) goalEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getGoalReference() {
		return goalReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoalReference_Source() {
		return (EReference) goalReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getGoalReference_Target() {
		return (EReference) goalReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getGoalReference_Weight() {
		return (EAttribute) goalReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getGoalType() {
		return goalTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getGoalReferenceType() {
		return goalReferenceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GoalFactory getGoalFactory() {
		return (GoalFactory) getEFactoryInstance();
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
		goalEClass = createEClass(GOAL);
		createEAttribute(goalEClass, GOAL__SOFT);
		createEAttribute(goalEClass, GOAL__TYPE);
		createEReference(goalEClass, GOAL__STAKEHOLDERS);
		createEReference(goalEClass, GOAL__REALIZED_FEATURES);
		createEReference(goalEClass, GOAL__DETAILING_USE_CASES);
		createEReference(goalEClass, GOAL__SUB_GOALS);
		createEReference(goalEClass, GOAL__PARENT_GOAL);
		createEReference(goalEClass, GOAL__INFLUENCING_GOALS);
		createEReference(goalEClass, GOAL__INFLUENCED_GOALS);

		goalReferenceEClass = createEClass(GOAL_REFERENCE);
		createEReference(goalReferenceEClass, GOAL_REFERENCE__SOURCE);
		createEReference(goalReferenceEClass, GOAL_REFERENCE__TARGET);
		createEAttribute(goalReferenceEClass, GOAL_REFERENCE__WEIGHT);

		// Create enums
		goalTypeEEnum = createEEnum(GOAL_TYPE);
		goalReferenceTypeEEnum = createEEnum(GOAL_REFERENCE_TYPE);
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
		UrmlPackage theUrmlPackage = (UrmlPackage) EPackage.Registry.INSTANCE.getEPackage(UrmlPackage.eNS_URI);
		FeaturePackage theFeaturePackage = (FeaturePackage) EPackage.Registry.INSTANCE
			.getEPackage(FeaturePackage.eNS_URI);
		UsecasePackage theUsecasePackage = (UsecasePackage) EPackage.Registry.INSTANCE
			.getEPackage(UsecasePackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(MetamodelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		goalEClass.getESuperTypes().add(theUrmlPackage.getUrmlModelElement());
		goalReferenceEClass.getESuperTypes().add(theUrmlPackage.getUrmlModelElement());
		goalReferenceEClass.getESuperTypes().add(theMetamodelPackage.getAssociationClassElement());

		// Initialize classes and features; add operations and parameters
		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoal_Soft(), ecorePackage.getEBoolean(), "soft", null, 0, 1, Goal.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoal_Type(), this.getGoalType(), "type", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE,
			IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_Stakeholders(), theUrmlPackage.getStakeholder(), theUrmlPackage.getStakeholder_Goals(),
			"stakeholders", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_RealizedFeatures(), theFeaturePackage.getAbstractFeature(), theFeaturePackage
			.getAbstractFeature_Goals(), "realizedFeatures", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE,
			IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_DetailingUseCases(), theUsecasePackage.getApplicationDomainUseCase(), theUsecasePackage
			.getApplicationDomainUseCase_DetailedGoal(), "detailingUseCases", null, 0, 1, Goal.class, !IS_TRANSIENT,
			!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
			IS_ORDERED);
		initEReference(getGoal_SubGoals(), this.getGoal(), this.getGoal_ParentGoal(), "subGoals", null, 0, -1,
			Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
			IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_ParentGoal(), this.getGoal(), this.getGoal_SubGoals(), "parentGoal", null, 0, 1,
			Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
			IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_InfluencingGoals(), this.getGoalReference(), this.getGoalReference_Target(),
			"influencingGoals", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_InfluencedGoals(), this.getGoalReference(), this.getGoalReference_Source(),
			"influencedGoals", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalReferenceEClass, GoalReference.class, "GoalReference", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGoalReference_Source(), this.getGoal(), this.getGoal_InfluencedGoals(), "source", null, 0, 1,
			GoalReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoalReference_Target(), this.getGoal(), this.getGoal_InfluencingGoals(), "target", null, 0,
			1, GoalReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalReference_Weight(), this.getGoalReferenceType(), "weight", null, 0, 1,
			GoalReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(goalTypeEEnum, GoalType.class, "GoalType");
		addEEnumLiteral(goalTypeEEnum, GoalType.BUSINESS_GOAL);
		addEEnumLiteral(goalTypeEEnum, GoalType.PRODUCT_GOAL);
		addEEnumLiteral(goalTypeEEnum, GoalType.CUSTOMER_GOAL);
		addEEnumLiteral(goalTypeEEnum, GoalType.END_USER_GOAL);

		initEEnum(goalReferenceTypeEEnum, GoalReferenceType.class, "GoalReferenceType");
		addEEnumLiteral(goalReferenceTypeEEnum, GoalReferenceType.PLUS_PLUS);
		addEEnumLiteral(goalReferenceTypeEEnum, GoalReferenceType.PLUS);
		addEEnumLiteral(goalReferenceTypeEEnum, GoalReferenceType.MINUS);
		addEEnumLiteral(goalReferenceTypeEEnum, GoalReferenceType.MINUS_MINUS);
	}

} // GoalPackageImpl
