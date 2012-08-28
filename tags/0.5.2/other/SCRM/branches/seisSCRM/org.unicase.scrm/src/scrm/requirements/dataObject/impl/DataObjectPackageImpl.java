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

import scrm.ScrmPackage;
import scrm.impl.ScrmPackageImpl;
import scrm.knowledge.KnowledgePackage;
import scrm.knowledge.impl.KnowledgePackageImpl;
import scrm.requirements.RequirementsPackage;
import scrm.requirements.dataObject.ComputationalMesh;
import scrm.requirements.dataObject.ControlParameter;
import scrm.requirements.dataObject.DataDefinition;
import scrm.requirements.dataObject.DataObjectFactory;
import scrm.requirements.dataObject.DataObjectPackage;
import scrm.requirements.dataObject.SeismicSource;
import scrm.requirements.dataObject.Station;
import scrm.requirements.dataObject.SyntheticSeismogram;
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
	private EClass dataDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seismicSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computationalMeshEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass syntheticSeismogramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlParameterEClass = null;

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
	public EClass getDataDefinition() {
		return dataDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDefinition_DefinedRequirement() {
		return (EReference) dataDefinitionEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataDefinition_Accuracy() {
		return (EAttribute) dataDefinitionEClass.getEStructuralFeatures()
				.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataDefinition_Range() {
		return (EAttribute) dataDefinitionEClass.getEStructuralFeatures()
				.get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataDefinition_Format() {
		return (EAttribute) dataDefinitionEClass.getEStructuralFeatures()
				.get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDefinition_ProvidedInterface() {
		return (EReference) dataDefinitionEClass.getEStructuralFeatures()
				.get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDefinition_RequiredInterface() {
		return (EReference) dataDefinitionEClass.getEStructuralFeatures()
				.get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataDefinition_DescribedModel() {
		return (EReference) dataDefinitionEClass.getEStructuralFeatures()
				.get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeismicSource() {
		return seismicSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputationalMesh() {
		return computationalMeshEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSyntheticSeismogram() {
		return syntheticSeismogramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStation() {
		return stationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlParameter() {
		return controlParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlParameter_ControlledProcess() {
		return (EReference) controlParameterEClass.getEStructuralFeatures()
				.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControlParameter_Format() {
		return (EAttribute) controlParameterEClass.getEStructuralFeatures()
				.get(1);
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
		dataDefinitionEClass = createEClass(DATA_DEFINITION);
		createEReference(dataDefinitionEClass,
				DATA_DEFINITION__DEFINED_REQUIREMENT);
		createEAttribute(dataDefinitionEClass, DATA_DEFINITION__ACCURACY);
		createEAttribute(dataDefinitionEClass, DATA_DEFINITION__RANGE);
		createEAttribute(dataDefinitionEClass, DATA_DEFINITION__FORMAT);
		createEReference(dataDefinitionEClass,
				DATA_DEFINITION__PROVIDED_INTERFACE);
		createEReference(dataDefinitionEClass,
				DATA_DEFINITION__REQUIRED_INTERFACE);
		createEReference(dataDefinitionEClass, DATA_DEFINITION__DESCRIBED_MODEL);

		seismicSourceEClass = createEClass(SEISMIC_SOURCE);

		computationalMeshEClass = createEClass(COMPUTATIONAL_MESH);

		syntheticSeismogramEClass = createEClass(SYNTHETIC_SEISMOGRAM);

		stationEClass = createEClass(STATION);

		controlParameterEClass = createEClass(CONTROL_PARAMETER);
		createEReference(controlParameterEClass,
				CONTROL_PARAMETER__CONTROLLED_PROCESS);
		createEAttribute(controlParameterEClass, CONTROL_PARAMETER__FORMAT);
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
		DataProcessPackage theDataProcessPackage = (DataProcessPackage) EPackage.Registry.INSTANCE
				.getEPackage(DataProcessPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataDefinitionEClass.getESuperTypes().add(
				theRequirementsPackage.getIRequirement());
		seismicSourceEClass.getESuperTypes().add(this.getDataDefinition());
		computationalMeshEClass.getESuperTypes().add(this.getDataDefinition());
		syntheticSeismogramEClass.getESuperTypes()
				.add(this.getDataDefinition());
		stationEClass.getESuperTypes().add(this.getDataDefinition());
		controlParameterEClass.getESuperTypes().add(
				theRequirementsPackage.getIRequirement());

		// Initialize classes and features; add operations and parameters
		initEClass(dataDefinitionEClass, DataDefinition.class,
				"DataDefinition", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataDefinition_DefinedRequirement(),
				theRequirementsPackage.getRequirement(),
				theRequirementsPackage.getRequirement_HandlingData(),
				"definedRequirement", null, 0, 1, DataDefinition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getDataDefinition_Accuracy(),
				theEcorePackage.getEString(), "accuracy", null, 0, 1,
				DataDefinition.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getDataDefinition_Range(), ecorePackage.getEString(),
				"range", null, 0, 1, DataDefinition.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataDefinition_Format(), ecorePackage.getEString(),
				"format", null, 0, 1, DataDefinition.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getDataDefinition_ProvidedInterface(),
				theRequirementsPackage.getInterface(),
				theRequirementsPackage.getInterface_ProvidingData(),
				"providedInterface", null, 0, 1, DataDefinition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getDataDefinition_RequiredInterface(),
				theRequirementsPackage.getInterface(),
				theRequirementsPackage.getInterface_RequiringData(),
				"requiredInterface", null, 0, 1, DataDefinition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getDataDefinition_DescribedModel(),
				theKnowledgePackage.getMathematical_GeophysicalModel(),
				theKnowledgePackage
						.getMathematical_GeophysicalModel_InvolvedData(),
				"describedModel", null, 0, -1, DataDefinition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(seismicSourceEClass, SeismicSource.class, "SeismicSource",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(computationalMeshEClass, ComputationalMesh.class,
				"ComputationalMesh", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(syntheticSeismogramEClass, SyntheticSeismogram.class,
				"SyntheticSeismogram", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(stationEClass, Station.class, "Station", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(controlParameterEClass, ControlParameter.class,
				"ControlParameter", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControlParameter_ControlledProcess(),
				theDataProcessPackage.getProcess(),
				theDataProcessPackage.getProcess_ControlParameters(),
				"controlledProcess", null, 0, 1, ControlParameter.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getControlParameter_Format(), ecorePackage.getEString(),
				"format", null, 0, 1, ControlParameter.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

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
		addAnnotation(getDataDefinition_DefinedRequirement(), source,
				new String[] { "position", "left", "priority", "15" });
		addAnnotation(getDataDefinition_Accuracy(), source, new String[] {
				"position", "left", "priority", "5" });
		addAnnotation(getDataDefinition_Range(), source, new String[] {
				"position", "left", "priority", "6" });
		addAnnotation(getDataDefinition_Format(), source, new String[] {
				"position", "left", "priority", "8" });
		addAnnotation(getDataDefinition_DescribedModel(), source, new String[] {
				"position", "right", "priority", "8" });
		addAnnotation(getControlParameter_Format(), source, new String[] {
				"position", "left", "priority", "8" });
	}

} //DataObjectPackageImpl
