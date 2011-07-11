/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.feature.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.danger.impl.DangerPackageImpl;
import org.unicase.model.urml.feature.AbstractFeature;
import org.unicase.model.urml.feature.Feature;
import org.unicase.model.urml.feature.FeatureFactory;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.Product;
import org.unicase.model.urml.feature.VariationPoint;
import org.unicase.model.urml.feature.VariationPointInstance;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.impl.GoalPackageImpl;
import org.unicase.model.urml.impl.UrmlPackageImpl;
import org.unicase.model.urml.requirement.RequirementPackage;
import org.unicase.model.urml.requirement.impl.RequirementPackageImpl;
import org.unicase.model.urml.service.ServicePackage;
import org.unicase.model.urml.service.impl.ServicePackageImpl;
import org.unicase.model.urml.usecase.UsecasePackage;
import org.unicase.model.urml.usecase.impl.UsecasePackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class FeaturePackageImpl extends EPackageImpl implements FeaturePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractFeatureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variationPointEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variationPointInstanceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.urml.feature.FeaturePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FeaturePackageImpl() {
		super(eNS_URI, FeatureFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FeaturePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FeaturePackage init() {
		if (isInited)
			return (FeaturePackage) EPackage.Registry.INSTANCE
					.getEPackage(FeaturePackage.eNS_URI);

		// Obtain or create and register package
		FeaturePackageImpl theFeaturePackage = (FeaturePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof FeaturePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new FeaturePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiagramPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		UrmlPackageImpl theUrmlPackage = (UrmlPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(UrmlPackage.eNS_URI) instanceof UrmlPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(UrmlPackage.eNS_URI) : UrmlPackage.eINSTANCE);
		GoalPackageImpl theGoalPackage = (GoalPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(GoalPackage.eNS_URI) instanceof GoalPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(GoalPackage.eNS_URI) : GoalPackage.eINSTANCE);
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI)
				: RequirementPackage.eINSTANCE);
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
		theFeaturePackage.createPackageContents();
		theUrmlPackage.createPackageContents();
		theGoalPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theServicePackage.createPackageContents();
		theDangerPackage.createPackageContents();

		// Initialize created meta-data
		theFeaturePackage.initializePackageContents();
		theUrmlPackage.initializePackageContents();
		theGoalPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theServicePackage.initializePackageContents();
		theDangerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFeaturePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FeaturePackage.eNS_URI,
				theFeaturePackage);
		return theFeaturePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractFeature() {
		return abstractFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_Goals() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_DetailingFunctionalRequirements() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_ConstrainingNonFunctionalRequirements() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_DetailingUseCases() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_ParentFeature() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_SubFeatures() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_ExcludingFeatures() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_ExcludedFeatures() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_RequiringFeatures() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_RequiredFeatures() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_OptionalParentVariationPoint() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractFeature_VariationPointInstances() {
		return (EReference) abstractFeatureEClass.getEStructuralFeatures().get(
				11);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Products() {
		return (EReference) featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationPoint() {
		return variationPointEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPoint_OptionalSubFeatures() {
		return (EReference) variationPointEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariationPoint_Multiplicity() {
		return (EAttribute) variationPointEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPoint_Instances() {
		return (EReference) variationPointEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariationPointInstance() {
		return variationPointInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPointInstance_VariationPoint() {
		return (EReference) variationPointInstanceEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPointInstance_Products() {
		return (EReference) variationPointInstanceEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariationPointInstance_SelectedFeatures() {
		return (EReference) variationPointInstanceEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProduct() {
		return productEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduct_VariationPointInstances() {
		return (EReference) productEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProduct_Features() {
		return (EReference) productEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureFactory getFeatureFactory() {
		return (FeatureFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		abstractFeatureEClass = createEClass(ABSTRACT_FEATURE);
		createEReference(abstractFeatureEClass, ABSTRACT_FEATURE__GOALS);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__DETAILING_USE_CASES);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__PARENT_FEATURE);
		createEReference(abstractFeatureEClass, ABSTRACT_FEATURE__SUB_FEATURES);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__EXCLUDING_FEATURES);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__EXCLUDED_FEATURES);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__REQUIRING_FEATURES);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__REQUIRED_FEATURES);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__OPTIONAL_PARENT_VARIATION_POINT);
		createEReference(abstractFeatureEClass,
				ABSTRACT_FEATURE__VARIATION_POINT_INSTANCES);

		featureEClass = createEClass(FEATURE);
		createEReference(featureEClass, FEATURE__PRODUCTS);

		variationPointEClass = createEClass(VARIATION_POINT);
		createEReference(variationPointEClass,
				VARIATION_POINT__OPTIONAL_SUB_FEATURES);
		createEAttribute(variationPointEClass, VARIATION_POINT__MULTIPLICITY);
		createEReference(variationPointEClass, VARIATION_POINT__INSTANCES);

		variationPointInstanceEClass = createEClass(VARIATION_POINT_INSTANCE);
		createEReference(variationPointInstanceEClass,
				VARIATION_POINT_INSTANCE__VARIATION_POINT);
		createEReference(variationPointInstanceEClass,
				VARIATION_POINT_INSTANCE__PRODUCTS);
		createEReference(variationPointInstanceEClass,
				VARIATION_POINT_INSTANCE__SELECTED_FEATURES);

		productEClass = createEClass(PRODUCT);
		createEReference(productEClass, PRODUCT__VARIATION_POINT_INSTANCES);
		createEReference(productEClass, PRODUCT__FEATURES);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UrmlPackage theUrmlPackage = (UrmlPackage) EPackage.Registry.INSTANCE
				.getEPackage(UrmlPackage.eNS_URI);
		GoalPackage theGoalPackage = (GoalPackage) EPackage.Registry.INSTANCE
				.getEPackage(GoalPackage.eNS_URI);
		RequirementPackage theRequirementPackage = (RequirementPackage) EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI);
		UsecasePackage theUsecasePackage = (UsecasePackage) EPackage.Registry.INSTANCE
				.getEPackage(UsecasePackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractFeatureEClass.getESuperTypes().add(
				theUrmlPackage.getUrmlModelElement());
		featureEClass.getESuperTypes().add(this.getAbstractFeature());
		variationPointEClass.getESuperTypes().add(this.getAbstractFeature());
		variationPointInstanceEClass.getESuperTypes().add(
				theUrmlPackage.getUrmlModelElement());
		productEClass.getESuperTypes()
				.add(theUrmlPackage.getUrmlModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractFeatureEClass, AbstractFeature.class,
				"AbstractFeature", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractFeature_Goals(), theGoalPackage.getGoal(),
				theGoalPackage.getGoal_RealizedFeatures(), "goals", null, 0,
				-1, AbstractFeature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractFeature_DetailingFunctionalRequirements(),
				theRequirementPackage.getFunctionalRequirement(),
				theRequirementPackage
						.getFunctionalRequirement_DetailedFeatures(),
				"detailingFunctionalRequirements", null, 0, -1,
				AbstractFeature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(
				getAbstractFeature_ConstrainingNonFunctionalRequirements(),
				theRequirementPackage.getNonFunctionalRequirement(),
				theRequirementPackage
						.getNonFunctionalRequirement_ConstrainedFeatures(),
				"constrainingNonFunctionalRequirements", null, 0, -1,
				AbstractFeature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractFeature_DetailingUseCases(),
				theUsecasePackage.getSolutionDomainUseCase(),
				theUsecasePackage.getSolutionDomainUseCase_DetailedFeature(),
				"detailingUseCases", null, 0, -1, AbstractFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getAbstractFeature_ParentFeature(),
				this.getAbstractFeature(),
				this.getAbstractFeature_SubFeatures(), "parentFeature", null,
				0, 1, AbstractFeature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractFeature_SubFeatures(),
				this.getAbstractFeature(),
				this.getAbstractFeature_ParentFeature(), "subFeatures", null,
				0, -1, AbstractFeature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractFeature_ExcludingFeatures(),
				this.getAbstractFeature(),
				this.getAbstractFeature_ExcludedFeatures(),
				"excludingFeatures", null, 0, -1, AbstractFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getAbstractFeature_ExcludedFeatures(),
				this.getAbstractFeature(),
				this.getAbstractFeature_ExcludingFeatures(),
				"excludedFeatures", null, 0, -1, AbstractFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getAbstractFeature_RequiringFeatures(),
				this.getAbstractFeature(),
				this.getAbstractFeature_RequiredFeatures(),
				"requiringFeatures", null, 0, -1, AbstractFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getAbstractFeature_RequiredFeatures(),
				this.getAbstractFeature(),
				this.getAbstractFeature_RequiringFeatures(),
				"requiredFeatures", null, 0, -1, AbstractFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getAbstractFeature_OptionalParentVariationPoint(),
				this.getVariationPoint(),
				this.getVariationPoint_OptionalSubFeatures(),
				"optionalParentVariationPoint", null, 0, 1,
				AbstractFeature.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractFeature_VariationPointInstances(),
				this.getVariationPointInstance(),
				this.getVariationPointInstance_SelectedFeatures(),
				"variationPointInstances", null, 0, -1, AbstractFeature.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeature_Products(), this.getProduct(),
				this.getProduct_Features(), "products", null, 0, -1,
				Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(variationPointEClass, VariationPoint.class,
				"VariationPoint", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariationPoint_OptionalSubFeatures(),
				this.getAbstractFeature(),
				this.getAbstractFeature_OptionalParentVariationPoint(),
				"optionalSubFeatures", null, 0, -1, VariationPoint.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getVariationPoint_Multiplicity(),
				theEcorePackage.getEInt(), "multiplicity", null, 0, 1,
				VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getVariationPoint_Instances(),
				this.getVariationPointInstance(),
				this.getVariationPointInstance_VariationPoint(), "instances",
				null, 0, -1, VariationPoint.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variationPointInstanceEClass, VariationPointInstance.class,
				"VariationPointInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariationPointInstance_VariationPoint(),
				this.getVariationPoint(), this.getVariationPoint_Instances(),
				"variationPoint", null, 0, 1, VariationPointInstance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getVariationPointInstance_Products(), this.getProduct(),
				this.getProduct_VariationPointInstances(), "products", null, 0,
				-1, VariationPointInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariationPointInstance_SelectedFeatures(),
				this.getAbstractFeature(),
				this.getAbstractFeature_VariationPointInstances(),
				"selectedFeatures", null, 0, -1, VariationPointInstance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(productEClass, Product.class, "Product", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProduct_VariationPointInstances(),
				this.getVariationPointInstance(),
				this.getVariationPointInstance_Products(),
				"variationPointInstances", null, 0, -1, Product.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getProduct_Features(), this.getFeature(),
				this.getFeature_Products(), "features", null, 0, -1,
				Product.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
	}

} // FeaturePackageImpl
