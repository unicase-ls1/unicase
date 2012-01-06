/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.metamodel.MetamodelPackage;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.urml.Phase;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.StakeholderRole;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.UrmlProjectSettings;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.danger.impl.DangerPackageImpl;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.impl.FeaturePackageImpl;
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.goal.impl.GoalPackageImpl;
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
public class UrmlPackageImpl extends EPackageImpl implements UrmlPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urmlModelElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stakeholderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urmlDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stakeholderRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass phaseSetEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass phaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass urmlProjectSettingsEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.urml.UrmlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UrmlPackageImpl() {
		super(eNS_URI, UrmlFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
			return (UrmlPackage) EPackage.Registry.INSTANCE
					.getEPackage(UrmlPackage.eNS_URI);

		// Obtain or create and register package
		UrmlPackageImpl theUrmlPackage = (UrmlPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof UrmlPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new UrmlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiagramPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
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
		FeaturePackageImpl theFeaturePackage = (FeaturePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(FeaturePackage.eNS_URI) instanceof FeaturePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(FeaturePackage.eNS_URI) : FeaturePackage.eINSTANCE);

		// Create package meta-data objects
		theUrmlPackage.createPackageContents();
		theGoalPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theServicePackage.createPackageContents();
		theDangerPackage.createPackageContents();
		theFeaturePackage.createPackageContents();

		// Initialize created meta-data
		theUrmlPackage.initializePackageContents();
		theGoalPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theServicePackage.initializePackageContents();
		theDangerPackage.initializePackageContents();
		theFeaturePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUrmlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UrmlPackage.eNS_URI, theUrmlPackage);
		return theUrmlPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	public EAttribute getUrmlModelElement_Reviewed() {
		return (EAttribute) urmlModelElementEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUrmlModelElement_Associations() {
		return (EReference) urmlModelElementEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStakeholder() {
		return stakeholderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholder_Goals() {
		return (EReference) stakeholderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	public EClass getStakeholderRole() {
		return stakeholderRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholderRole_ReviewSet() {
		return (EReference) stakeholderRoleEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStakeholderRole_FilterSet() {
		return (EReference) stakeholderRoleEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetEntry() {
		return setEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetEntry_Key() {
		return (EReference) setEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetEntry_Value() {
		return (EReference) setEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhaseSetEntry() {
		return phaseSetEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhaseSetEntry_Key() {
		return (EReference) phaseSetEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhaseSetEntry_Value() {
		return (EReference) phaseSetEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhase() {
		return phaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhase_AllowedAssociations() {
		return (EReference) phaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUrmlProjectSettings() {
		return urmlProjectSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUrmlProjectSettings_ActivePhase() {
		return (EReference) urmlProjectSettingsEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UrmlFactory getUrmlFactory() {
		return (UrmlFactory) getEFactoryInstance();
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
		urmlModelElementEClass = createEClass(URML_MODEL_ELEMENT);
		createEReference(urmlModelElementEClass,
				URML_MODEL_ELEMENT__ASSOCIATIONS);
		createEAttribute(urmlModelElementEClass, URML_MODEL_ELEMENT__REVIEWED);

		stakeholderEClass = createEClass(STAKEHOLDER);
		createEReference(stakeholderEClass, STAKEHOLDER__GOALS);

		urmlDiagramEClass = createEClass(URML_DIAGRAM);

		stakeholderRoleEClass = createEClass(STAKEHOLDER_ROLE);
		createEReference(stakeholderRoleEClass, STAKEHOLDER_ROLE__REVIEW_SET);
		createEReference(stakeholderRoleEClass, STAKEHOLDER_ROLE__FILTER_SET);

		setEntryEClass = createEClass(SET_ENTRY);
		createEReference(setEntryEClass, SET_ENTRY__KEY);
		createEReference(setEntryEClass, SET_ENTRY__VALUE);

		phaseSetEntryEClass = createEClass(PHASE_SET_ENTRY);
		createEReference(phaseSetEntryEClass, PHASE_SET_ENTRY__KEY);
		createEReference(phaseSetEntryEClass, PHASE_SET_ENTRY__VALUE);

		phaseEClass = createEClass(PHASE);
		createEReference(phaseEClass, PHASE__ALLOWED_ASSOCIATIONS);

		urmlProjectSettingsEClass = createEClass(URML_PROJECT_SETTINGS);
		createEReference(urmlProjectSettingsEClass,
				URML_PROJECT_SETTINGS__ACTIVE_PHASE);
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
		GoalPackage theGoalPackage = (GoalPackage) EPackage.Registry.INSTANCE
				.getEPackage(GoalPackage.eNS_URI);
		RequirementPackage theRequirementPackage = (RequirementPackage) EPackage.Registry.INSTANCE
				.getEPackage(RequirementPackage.eNS_URI);
		UsecasePackage theUsecasePackage = (UsecasePackage) EPackage.Registry.INSTANCE
				.getEPackage(UsecasePackage.eNS_URI);
		ServicePackage theServicePackage = (ServicePackage) EPackage.Registry.INSTANCE
				.getEPackage(ServicePackage.eNS_URI);
		DangerPackage theDangerPackage = (DangerPackage) EPackage.Registry.INSTANCE
				.getEPackage(DangerPackage.eNS_URI);
		FeaturePackage theFeaturePackage = (FeaturePackage) EPackage.Registry.INSTANCE
				.getEPackage(FeaturePackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ModelPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		DiagramPackage theDiagramPackage = (DiagramPackage) EPackage.Registry.INSTANCE
				.getEPackage(DiagramPackage.eNS_URI);
		MetamodelPackage theMetamodelPackage = (MetamodelPackage) EPackage.Registry.INSTANCE
				.getEPackage(MetamodelPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theGoalPackage);
		getESubpackages().add(theRequirementPackage);
		getESubpackages().add(theUsecasePackage);
		getESubpackages().add(theServicePackage);
		getESubpackages().add(theDangerPackage);
		getESubpackages().add(theFeaturePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		urmlModelElementEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());
		stakeholderEClass.getESuperTypes().add(this.getUrmlModelElement());
		urmlDiagramEClass.getESuperTypes()
				.add(theDiagramPackage.getMEDiagram());
		stakeholderRoleEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());
		stakeholderRoleEClass.getESuperTypes().add(
				theMetamodelPackage.getNonDomainElement());
		phaseEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());
		phaseEClass.getESuperTypes().add(
				theMetamodelPackage.getNonDomainElement());
		urmlProjectSettingsEClass.getESuperTypes().add(
				theModelPackage.getUnicaseModelElement());
		urmlProjectSettingsEClass.getESuperTypes().add(
				theMetamodelPackage.getNonDomainElement());

		// Initialize classes and features; add operations and parameters
		initEClass(urmlModelElementEClass, UrmlModelElement.class,
				"UrmlModelElement", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUrmlModelElement_Associations(),
				this.getUrmlModelElement(), null, "associations", null, 0, -1,
				UrmlModelElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUrmlModelElement_Reviewed(),
				theEcorePackage.getEBoolean(), "reviewed", null, 0, 1,
				UrmlModelElement.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(stakeholderEClass, Stakeholder.class, "Stakeholder",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStakeholder_Goals(), theGoalPackage.getGoal(),
				theGoalPackage.getGoal_Stakeholders(), "goals", null, 0, -1,
				Stakeholder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(urmlDiagramEClass, URMLDiagram.class, "URMLDiagram",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stakeholderRoleEClass, StakeholderRole.class,
				"StakeholderRole", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStakeholderRole_ReviewSet(), this.getSetEntry(),
				null, "reviewSet", null, 0, -1, StakeholderRole.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getStakeholderRole_FilterSet(), this.getSetEntry(),
				null, "filterSet", null, 0, -1, StakeholderRole.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(setEntryEClass, Map.Entry.class, "SetEntry", !IS_ABSTRACT,
				!IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetEntry_Key(), theEcorePackage.getEClass(), null,
				"key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetEntry_Value(),
				theEcorePackage.getEStructuralFeature(), null, "value", null,
				0, -1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(phaseSetEntryEClass, Map.Entry.class, "PhaseSetEntry",
				!IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPhaseSetEntry_Key(), theEcorePackage.getEClass(),
				null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhaseSetEntry_Value(), theEcorePackage.getEClass(),
				null, "value", null, 0, -1, Map.Entry.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(phaseEClass, Phase.class, "Phase", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPhase_AllowedAssociations(), this.getPhaseSetEntry(),
				null, "allowedAssociations", null, 0, -1, Phase.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(urmlProjectSettingsEClass, UrmlProjectSettings.class,
				"UrmlProjectSettings", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUrmlProjectSettings_ActivePhase(), this.getPhase(),
				null, "activePhase", null, 0, 1, UrmlProjectSettings.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // UrmlPackageImpl
