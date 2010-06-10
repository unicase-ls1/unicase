/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.unicase.metamodel.MetamodelPackage;

import org.unicase.model.ModelPackage;

import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.urml.Feature;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;

import urml.danger.DangerPackage;

import urml.danger.impl.DangerPackageImpl;

import urml.goal.GoalPackage;

import urml.goal.impl.GoalPackageImpl;

import urml.requirement.RequirementPackage;

import urml.requirement.impl.RequirementPackageImpl;

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
public class UrmlPackageImpl extends EPackageImpl implements UrmlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urmlModelElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stakeholderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urmlDiagramEClass = null;

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
	 * @see org.unicase.model.urml.UrmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UrmlPackageImpl() {
		super(eNS_URI, UrmlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UrmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UrmlPackage init() {
		if (isInited)
			return (UrmlPackage) EPackage.Registry.INSTANCE.getEPackage(UrmlPackage.eNS_URI);

		// Obtain or create and register package
		UrmlPackageImpl theUrmlPackage = (UrmlPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UrmlPackageImpl ? EPackage.Registry.INSTANCE
			.get(eNS_URI)
			: new UrmlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		GoalPackageImpl theGoalPackage = (GoalPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(GoalPackage.eNS_URI) instanceof GoalPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(GoalPackage.eNS_URI)
			: GoalPackage.eINSTANCE);
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

		// Create package meta-data objects
		theUrmlPackage.createPackageContents();
		theGoalPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theServicePackage.createPackageContents();
		theDangerPackage.createPackageContents();

		// Initialize created meta-data
		theUrmlPackage.initializePackageContents();
		theGoalPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theServicePackage.initializePackageContents();
		theDangerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUrmlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UrmlPackage.eNS_URI, theUrmlPackage);
		return theUrmlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUrmlModelElement() {
		return urmlModelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_Goals() {
		return (EReference) featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_DetailingFunctionalRequirements() {
		return (EReference) featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_ConstrainingNonFunctionalRequirements() {
		return (EReference) featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_DetailingUseCases() {
		return (EReference) featureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_ParentFeature() {
		return (EReference) featureEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeature_SubFeatures() {
		return (EReference) featureEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStakeholder() {
		return stakeholderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholder_Goals() {
		return (EReference) stakeholderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getURMLDiagram() {
		return urmlDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UrmlFactory getUrmlFactory() {
		return (UrmlFactory) getEFactoryInstance();
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
		urmlModelElementEClass = createEClass(URML_MODEL_ELEMENT);

		featureEClass = createEClass(FEATURE);
		createEReference(featureEClass, FEATURE__GOALS);
		createEReference(featureEClass, FEATURE__DETAILING_FUNCTIONAL_REQUIREMENTS);
		createEReference(featureEClass, FEATURE__CONSTRAINING_NON_FUNCTIONAL_REQUIREMENTS);
		createEReference(featureEClass, FEATURE__DETAILING_USE_CASES);
		createEReference(featureEClass, FEATURE__PARENT_FEATURE);
		createEReference(featureEClass, FEATURE__SUB_FEATURES);

		stakeholderEClass = createEClass(STAKEHOLDER);
		createEReference(stakeholderEClass, STAKEHOLDER__GOALS);

		urmlDiagramEClass = createEClass(URML_DIAGRAM);
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
		GoalPackage theGoalPackage = (GoalPackage) EPackage.Registry.INSTANCE.getEPackage(GoalPackage.eNS_URI);
		RequirementPackage theRequirementPackage = (RequirementPackage) EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI);
		UsecasePackage theUsecasePackage = (UsecasePackage) EPackage.Registry.INSTANCE
			.getEPackage(UsecasePackage.eNS_URI);
		ServicePackage theServicePackage = (ServicePackage) EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI);
		DangerPackage theDangerPackage = (DangerPackage) EPackage.Registry.INSTANCE.getEPackage(DangerPackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
			.getEPackage(MetamodelPackage.eNS_URI);
		DiagramPackage theDiagramPackage = (DiagramPackage) EPackage.Registry.INSTANCE
			.getEPackage(DiagramPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGoalPackage);
		getESubpackages().add(theRequirementPackage);
		getESubpackages().add(theUsecasePackage);
		getESubpackages().add(theServicePackage);
		getESubpackages().add(theDangerPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		urmlModelElementEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		featureEClass.getESuperTypes().add(this.getUrmlModelElement());
		stakeholderEClass.getESuperTypes().add(this.getUrmlModelElement());
		urmlDiagramEClass.getESuperTypes().add(theDiagramPackage.getMEDiagram());

		// Initialize classes and features; add operations and parameters
		initEClass(urmlModelElementEClass, UrmlModelElement.class, "UrmlModelElement", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeature_Goals(), theGoalPackage.getGoal(), theGoalPackage.getGoal_RealizedFeatures(),
			"goals", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFeature_Goals().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getFeature_DetailingFunctionalRequirements(), theRequirementPackage.getFunctionalRequirement(),
			theRequirementPackage.getFunctionalRequirement_DetailedFeatures(), "detailingFunctionalRequirements", null,
			0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFeature_DetailingFunctionalRequirements().getEKeys().add(
			theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getFeature_ConstrainingNonFunctionalRequirements(), theRequirementPackage
			.getNonFunctionalRequirement(), theRequirementPackage.getNonFunctionalRequirement_ConstrainedFeatures(),
			"constrainingNonFunctionalRequirements", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE,
			IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFeature_ConstrainingNonFunctionalRequirements().getEKeys().add(
			theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getFeature_DetailingUseCases(), theUsecasePackage.getSolutionDomainUseCase(), theUsecasePackage
			.getSolutionDomainUseCase_DetailedFeature(), "detailingUseCases", null, 0, -1, Feature.class,
			!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
			!IS_DERIVED, IS_ORDERED);
		getFeature_DetailingUseCases().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getFeature_ParentFeature(), this.getFeature(), this.getFeature_SubFeatures(), "parentFeature",
			null, 0, 1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFeature_ParentFeature().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());
		initEReference(getFeature_SubFeatures(), this.getFeature(), this.getFeature_ParentFeature(), "subFeatures",
			null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getFeature_SubFeatures().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(stakeholderEClass, Stakeholder.class, "Stakeholder", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStakeholder_Goals(), theGoalPackage.getGoal(), theGoalPackage.getGoal_Stakeholders(),
			"goals", null, 0, 1, Stakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getStakeholder_Goals().getEKeys().add(theMetamodelPackage.getIdentifiableElement_Identifier());

		initEClass(urmlDiagramEClass, URMLDiagram.class, "URMLDiagram", !IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //UrmlPackageImpl
