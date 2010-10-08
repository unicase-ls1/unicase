/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.danger.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.model.ModelPackage;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.danger.Asset;
import org.unicase.model.urml.danger.Danger;
import org.unicase.model.urml.danger.DangerFactory;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.danger.Mitigation;
import org.unicase.model.urml.danger.ProceduralMitigation;
import org.unicase.model.urml.feature.FeaturePackage;
import org.unicase.model.urml.feature.impl.FeaturePackageImpl;
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
 * 
 * @generated
 */
public class DangerPackageImpl extends EPackageImpl implements DangerPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass assetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dangerEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass mitigationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass proceduralMitigationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.model.urml.danger.DangerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DangerPackageImpl() {
		super(eNS_URI, DangerFactory.eINSTANCE);
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
	 * This method is used to initialize {@link DangerPackage#eINSTANCE} when that field is accessed. Clients should not
	 * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DangerPackage init() {
		if (isInited)
			return (DangerPackage) EPackage.Registry.INSTANCE.getEPackage(DangerPackage.eNS_URI);

		// Obtain or create and register package
		DangerPackageImpl theDangerPackage = (DangerPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DangerPackageImpl ? EPackage.Registry.INSTANCE
			.get(eNS_URI)
			: new DangerPackageImpl());

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
		RequirementPackageImpl theRequirementPackage = (RequirementPackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI) instanceof RequirementPackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(RequirementPackage.eNS_URI) : RequirementPackage.eINSTANCE);
		UsecasePackageImpl theUsecasePackage = (UsecasePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(UsecasePackage.eNS_URI) instanceof UsecasePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(UsecasePackage.eNS_URI) : UsecasePackage.eINSTANCE);
		ServicePackageImpl theServicePackage = (ServicePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI) instanceof ServicePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(ServicePackage.eNS_URI) : ServicePackage.eINSTANCE);
		FeaturePackageImpl theFeaturePackage = (FeaturePackageImpl) (EPackage.Registry.INSTANCE
			.getEPackage(FeaturePackage.eNS_URI) instanceof FeaturePackageImpl ? EPackage.Registry.INSTANCE
			.getEPackage(FeaturePackage.eNS_URI) : FeaturePackage.eINSTANCE);

		// Create package meta-data objects
		theDangerPackage.createPackageContents();
		theUrmlPackage.createPackageContents();
		theGoalPackage.createPackageContents();
		theRequirementPackage.createPackageContents();
		theUsecasePackage.createPackageContents();
		theServicePackage.createPackageContents();
		theFeaturePackage.createPackageContents();

		// Initialize created meta-data
		theDangerPackage.initializePackageContents();
		theUrmlPackage.initializePackageContents();
		theGoalPackage.initializePackageContents();
		theRequirementPackage.initializePackageContents();
		theUsecasePackage.initializePackageContents();
		theServicePackage.initializePackageContents();
		theFeaturePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDangerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DangerPackage.eNS_URI, theDangerPackage);
		return theDangerPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAsset() {
		return assetEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAsset_TriggeredDangers() {
		return (EReference) assetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAsset_HarmingDangers() {
		return (EReference) assetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDanger() {
		return dangerEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDanger_TriggeringAssets() {
		return (EReference) dangerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDanger_HarmedAssets() {
		return (EReference) dangerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDanger_Mitigations() {
		return (EReference) dangerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMitigation() {
		return mitigationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getMitigation_MitigatedDangers() {
		return (EReference) mitigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProceduralMitigation() {
		return proceduralMitigationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getProceduralMitigation_MitigationProcedure() {
		return (EAttribute) proceduralMitigationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DangerFactory getDangerFactory() {
		return (DangerFactory) getEFactoryInstance();
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
		assetEClass = createEClass(ASSET);
		createEReference(assetEClass, ASSET__TRIGGERED_DANGERS);
		createEReference(assetEClass, ASSET__HARMING_DANGERS);

		dangerEClass = createEClass(DANGER);
		createEReference(dangerEClass, DANGER__TRIGGERING_ASSETS);
		createEReference(dangerEClass, DANGER__HARMED_ASSETS);
		createEReference(dangerEClass, DANGER__MITIGATIONS);

		mitigationEClass = createEClass(MITIGATION);
		createEReference(mitigationEClass, MITIGATION__MITIGATED_DANGERS);

		proceduralMitigationEClass = createEClass(PROCEDURAL_MITIGATION);
		createEAttribute(proceduralMitigationEClass, PROCEDURAL_MITIGATION__MITIGATION_PROCEDURE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		assetEClass.getESuperTypes().add(theUrmlPackage.getUrmlModelElement());
		dangerEClass.getESuperTypes().add(theUrmlPackage.getUrmlModelElement());
		mitigationEClass.getESuperTypes().add(theUrmlPackage.getUrmlModelElement());
		proceduralMitigationEClass.getESuperTypes().add(this.getMitigation());

		// Initialize classes and features; add operations and parameters
		initEClass(assetEClass, Asset.class, "Asset", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAsset_TriggeredDangers(), this.getDanger(), this.getDanger_TriggeringAssets(),
			"triggeredDangers", null, 0, -1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAsset_HarmingDangers(), this.getDanger(), this.getDanger_HarmedAssets(), "harmingDangers",
			null, 0, -1, Asset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dangerEClass, Danger.class, "Danger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDanger_TriggeringAssets(), this.getAsset(), this.getAsset_TriggeredDangers(),
			"triggeringAssets", null, 0, -1, Danger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDanger_HarmedAssets(), this.getAsset(), this.getAsset_HarmingDangers(), "harmedAssets", null,
			0, -1, Danger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
			!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDanger_Mitigations(), this.getMitigation(), this.getMitigation_MitigatedDangers(),
			"mitigations", null, 0, -1, Danger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
			IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mitigationEClass, Mitigation.class, "Mitigation", IS_ABSTRACT, !IS_INTERFACE,
			IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMitigation_MitigatedDangers(), this.getDanger(), this.getDanger_Mitigations(),
			"mitigatedDangers", null, 0, -1, Mitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
			!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(proceduralMitigationEClass, ProceduralMitigation.class, "ProceduralMitigation", !IS_ABSTRACT,
			!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProceduralMitigation_MitigationProcedure(), ecorePackage.getEString(), "mitigationProcedure",
			null, 0, 1, ProceduralMitigation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
			IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} // DangerPackageImpl
