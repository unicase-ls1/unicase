/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.unicase.model.ModelPackage;

import scrm.ScrmPackage;
import scrm.impl.ScrmPackageImpl;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.impl.KnowledgePackageImpl;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataObject.BuildingModel;
import scrm.requirements.dataObject.ControlSchedule;
import scrm.requirements.dataObject.Data;
import scrm.requirements.dataObject.DataObjectFactory;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataObject.GeometryData;
import scrm.requirements.dataObject.HVACOperationInformation;
import scrm.requirements.dataObject.PowerConsumption;
import scrm.requirements.dataObject.Report;
import scrm.requirements.dataObject.WeatherData;
import scrm.requirements.dataProcess.DataProcessPackage;
import scrm.requirements.dataProcess.impl.DataProcessPackageImpl;
import scrm.requirements.impl.RequirementsPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DataObjectPackageImpl extends EPackageImpl implements
		DataObjectPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass weatherDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerConsumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hvacOperationInformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buildingModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlScheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geometryDataEClass = null;

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
	 * @see scrm.requirements.dataObject.DataObjectPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DataObjectPackageImpl() {
		super(eNS_URI, DataObjectFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DataObjectPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DataObjectPackage init() {
		if (isInited)
			return (DataObjectPackage) EPackage.Registry.INSTANCE
					.getEPackage(DataObjectPackage.eNS_URI);

		// Obtain or create and register package
		DataObjectPackageImpl theDataObjectPackage = (DataObjectPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof DataObjectPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new DataObjectPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();
		NotationPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ScrmPackageImpl theScrmPackage = (ScrmPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI) instanceof ScrmPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ScrmPackage.eNS_URI) : ScrmPackage.eINSTANCE);
		KnowledgePackageImpl theKnowledgePackage = (KnowledgePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI) instanceof KnowledgePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI)
				: KnowledgePackage.eINSTANCE);
		RequirementsPackageImpl theRequirementsPackage = (RequirementsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI) instanceof RequirementsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI)
				: RequirementsPackage.eINSTANCE);
		DataProcessPackageImpl theDataProcessPackage = (DataProcessPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(DataProcessPackage.eNS_URI) instanceof DataProcessPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DataProcessPackage.eNS_URI)
				: DataProcessPackage.eINSTANCE);

		// Create package meta-data objects
		theDataObjectPackage.createPackageContents();
		theScrmPackage.createPackageContents();
		theKnowledgePackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theDataProcessPackage.createPackageContents();

		// Initialize created meta-data
		theDataObjectPackage.initializePackageContents();
		theScrmPackage.initializePackageContents();
		theKnowledgePackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theDataProcessPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDataObjectPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DataObjectPackage.eNS_URI,
				theDataObjectPackage);
		return theDataObjectPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getData() {
		return dataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getData_DefinedRequirement() {
		return (EReference) dataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Accuracy() {
		return (EAttribute) dataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Range() {
		return (EAttribute) dataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Format() {
		return (EAttribute) dataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getData_ProvidedInterface() {
		return (EReference) dataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getData_RequiredInterface() {
		return (EReference) dataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getData_DescribedModel() {
		return (EReference) dataEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getData_Containing() {
		return (EReference) dataEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWeatherData() {
		return weatherDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPowerConsumption() {
		return powerConsumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHVACOperationInformation() {
		return hvacOperationInformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuildingModel() {
		return buildingModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReport() {
		return reportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlSchedule() {
		return controlScheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeometryData() {
		return geometryDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObjectFactory getDataObjectFactory() {
		return (DataObjectFactory) getEFactoryInstance();
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
		dataEClass = createEClass(DATA);
		createEReference(dataEClass, DATA__DEFINED_REQUIREMENT);
		createEAttribute(dataEClass, DATA__ACCURACY);
		createEAttribute(dataEClass, DATA__RANGE);
		createEAttribute(dataEClass, DATA__FORMAT);
		createEReference(dataEClass, DATA__PROVIDED_INTERFACE);
		createEReference(dataEClass, DATA__REQUIRED_INTERFACE);
		createEReference(dataEClass, DATA__DESCRIBED_MODEL);
		createEReference(dataEClass, DATA__CONTAINING);

		weatherDataEClass = createEClass(WEATHER_DATA);

		powerConsumptionEClass = createEClass(POWER_CONSUMPTION);

		hvacOperationInformationEClass = createEClass(HVAC_OPERATION_INFORMATION);

		buildingModelEClass = createEClass(BUILDING_MODEL);

		reportEClass = createEClass(REPORT);

		controlScheduleEClass = createEClass(CONTROL_SCHEDULE);

		geometryDataEClass = createEClass(GEOMETRY_DATA);
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
		RequirementsPackage theRequirementsPackage = (RequirementsPackage) EPackage.Registry.INSTANCE
				.getEPackage(RequirementsPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);
		KnowledgePackage theKnowledgePackage = (KnowledgePackage) EPackage.Registry.INSTANCE
				.getEPackage(KnowledgePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataEClass.getESuperTypes().add(
				theRequirementsPackage.getIRequirement());
		weatherDataEClass.getESuperTypes().add(this.getData());
		powerConsumptionEClass.getESuperTypes().add(this.getData());
		hvacOperationInformationEClass.getESuperTypes().add(this.getData());
		buildingModelEClass.getESuperTypes().add(this.getData());
		reportEClass.getESuperTypes().add(this.getData());
		controlScheduleEClass.getESuperTypes().add(this.getData());
		geometryDataEClass.getESuperTypes().add(this.getData());

		// Initialize classes and features; add operations and parameters
		initEClass(dataEClass, Data.class, "Data", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getData_DefinedRequirement(),
				theRequirementsPackage.getRequirement(),
				theRequirementsPackage.getRequirement_HandlingData(),
				"definedRequirement", null, 0, 1, Data.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getData_Accuracy(), theEcorePackage.getEString(),
				"accuracy", null, 0, 1, Data.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getData_Range(), ecorePackage.getEString(), "range",
				null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getData_Format(), ecorePackage.getEString(), "format",
				null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getData_ProvidedInterface(),
				theRequirementsPackage.getInterface(),
				theRequirementsPackage.getInterface_ProvidingData(),
				"providedInterface", null, 0, 1, Data.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getData_RequiredInterface(),
				theRequirementsPackage.getInterface(),
				theRequirementsPackage.getInterface_RequiringData(),
				"requiredInterface", null, 0, 1, Data.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getData_DescribedModel(),
				theKnowledgePackage.getModel(),
				theKnowledgePackage.getModel_InvolvedData(), "describedModel",
				null, 0, -1, Data.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getData_Containing(), this.getData(), null,
				"containing", null, 0, -1, Data.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(weatherDataEClass, WeatherData.class, "WeatherData",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(powerConsumptionEClass, PowerConsumption.class,
				"PowerConsumption", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(hvacOperationInformationEClass,
				HVACOperationInformation.class, "HVACOperationInformation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(buildingModelEClass, BuildingModel.class, "BuildingModel",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reportEClass, Report.class, "Report", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(controlScheduleEClass, ControlSchedule.class,
				"ControlSchedule", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(geometryDataEClass, GeometryData.class, "GeometryData",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// org.unicase.ui.meeditor
		createOrgAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.unicase.ui.meeditor</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.unicase.ui.meeditor";
		addAnnotation(getData_DefinedRequirement(), source, new String[] {
				"position", "left", "priority", "15" });
		addAnnotation(getData_Accuracy(), source, new String[] { "position",
				"left", "priority", "5" });
		addAnnotation(getData_Range(), source, new String[] { "position",
				"left", "priority", "6" });
		addAnnotation(getData_Format(), source, new String[] { "position",
				"left", "priority", "8" });
		addAnnotation(getData_DescribedModel(), source, new String[] {
				"position", "right", "priority", "8" });
		addAnnotation(getData_Containing(), source, new String[] { "position",
				"left", "priority", "4" });
	}

} //DataObjectPackageImpl
