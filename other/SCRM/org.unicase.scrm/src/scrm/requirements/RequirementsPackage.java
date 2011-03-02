/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see scrm.requirements.RequirementsFactory
 * @model kind="package"
 * @generated
 */
public interface RequirementsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "requirements";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/scrm/requirements";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.scrm.requirements";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RequirementsPackage eINSTANCE = scrm.requirements.impl.RequirementsPackageImpl.init();

	/**
	 * The meta object id for the '{@link scrm.requirements.IRequirement <em>IRequirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.IRequirement
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getIRequirement()
	 * @generated
	 */
	int IREQUIREMENT = 0;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__USED_KNOWLEDGE = 0;

	/**
	 * The number of structural features of the '<em>IRequirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.FeatureImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 1;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__USED_KNOWLEDGE = IREQUIREMENT__USED_KNOWLEDGE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONSTRAINTS = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DEPENDENCIES = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required User Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIRED_USER_INTERFACE = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Provided User Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PROVIDED_USER_INTERFACES = IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Required Software Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIRED_SOFTWARE_INTERFACE = IREQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Provided Software Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PROVIDED_SOFTWARE_INTERFACES = IREQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Detailed Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DETAILED_REQUIREMENTS = IREQUIREMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.HardwareImpl <em>Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.HardwareImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getHardware()
	 * @generated
	 */
	int HARDWARE = 2;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__USED_KNOWLEDGE = IREQUIREMENT__USED_KNOWLEDGE;

	/**
	 * The feature id for the '<em><b>Depending Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__DEPENDING_FEATURE = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.ConstraintImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__USED_KNOWLEDGE = IREQUIREMENT__USED_KNOWLEDGE;

	/**
	 * The feature id for the '<em><b>Restricted Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__RESTRICTED_FEATURE = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.RequirementImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 4;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__USED_KNOWLEDGE = IREQUIREMENT__USED_KNOWLEDGE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REFINEMENTS = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REFINED_REQUIREMENT = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__SPECIFIED_FEATURE = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DEFINING_DATA = IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REALIZED_METHOD = IREQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.UserInterfaceImpl <em>User Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.UserInterfaceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getUserInterface()
	 * @generated
	 */
	int USER_INTERFACE = 5;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__USED_KNOWLEDGE = IREQUIREMENT__USED_KNOWLEDGE;

	/**
	 * The feature id for the '<em><b>Requiring Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__REQUIRING_FEATURE = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Providing Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__PROVIDING_FEATURE = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.SoftwareInterfaceImpl <em>Software Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.SoftwareInterfaceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getSoftwareInterface()
	 * @generated
	 */
	int SOFTWARE_INTERFACE = 6;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__USED_KNOWLEDGE = IREQUIREMENT__USED_KNOWLEDGE;

	/**
	 * The feature id for the '<em><b>Requiring Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__REQUIRING_FEATURE = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Providing Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__PROVIDING_FEATURE = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Software Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.ProcessImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 7;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__USED_KNOWLEDGE = REQUIREMENT__USED_KNOWLEDGE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REFINEMENTS = REQUIREMENT__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REFINED_REQUIREMENT = REQUIREMENT__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__SPECIFIED_FEATURE = REQUIREMENT__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DEFINING_DATA = REQUIREMENT__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REALIZED_METHOD = REQUIREMENT__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DATA_FLOW = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.PerformanceImpl <em>Performance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.PerformanceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getPerformance()
	 * @generated
	 */
	int PERFORMANCE = 8;

	/**
	 * The feature id for the '<em><b>Used Knowledge</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__USED_KNOWLEDGE = REQUIREMENT__USED_KNOWLEDGE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__REFINEMENTS = REQUIREMENT__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__REFINED_REQUIREMENT = REQUIREMENT__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__SPECIFIED_FEATURE = REQUIREMENT__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__DEFINING_DATA = REQUIREMENT__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__REALIZED_METHOD = REQUIREMENT__REALIZED_METHOD;

	/**
	 * The number of structural features of the '<em>Performance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.DataFlowImpl <em>Data Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.DataFlowImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getDataFlow()
	 * @generated
	 */
	int DATA_FLOW = 9;

	/**
	 * The feature id for the '<em><b>Specified Process</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW__SPECIFIED_PROCESS = 0;

	/**
	 * The number of structural features of the '<em>Data Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.DataDefinitionImpl <em>Data Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.DataDefinitionImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getDataDefinition()
	 * @generated
	 */
	int DATA_DEFINITION = 10;

	/**
	 * The feature id for the '<em><b>Defined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__DEFINED_REQUIREMENT = 0;

	/**
	 * The number of structural features of the '<em>Data Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link scrm.requirements.IRequirement <em>IRequirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>IRequirement</em>'.
	 * @see scrm.requirements.IRequirement
	 * @generated
	 */
	EClass getIRequirement();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.IRequirement#getUsedKnowledge <em>Used Knowledge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used Knowledge</em>'.
	 * @see scrm.requirements.IRequirement#getUsedKnowledge()
	 * @see #getIRequirement()
	 * @generated
	 */
	EReference getIRequirement_UsedKnowledge();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see scrm.requirements.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.Feature#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see scrm.requirements.Feature#getConstraints()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.Feature#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see scrm.requirements.Feature#getDependencies()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Dependencies();

	/**
	 * Returns the meta object for the containment reference '{@link scrm.requirements.Feature#getRequiredUserInterface <em>Required User Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Required User Interface</em>'.
	 * @see scrm.requirements.Feature#getRequiredUserInterface()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_RequiredUserInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.Feature#getProvidedUserInterfaces <em>Provided User Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided User Interfaces</em>'.
	 * @see scrm.requirements.Feature#getProvidedUserInterfaces()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ProvidedUserInterfaces();

	/**
	 * Returns the meta object for the containment reference '{@link scrm.requirements.Feature#getRequiredSoftwareInterface <em>Required Software Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Required Software Interface</em>'.
	 * @see scrm.requirements.Feature#getRequiredSoftwareInterface()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_RequiredSoftwareInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.Feature#getProvidedSoftwareInterfaces <em>Provided Software Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provided Software Interfaces</em>'.
	 * @see scrm.requirements.Feature#getProvidedSoftwareInterfaces()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ProvidedSoftwareInterfaces();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.Feature#getDetailedRequirements <em>Detailed Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Detailed Requirements</em>'.
	 * @see scrm.requirements.Feature#getDetailedRequirements()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_DetailedRequirements();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.Hardware <em>Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hardware</em>'.
	 * @see scrm.requirements.Hardware
	 * @generated
	 */
	EClass getHardware();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.Hardware#getDependingFeature <em>Depending Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Depending Feature</em>'.
	 * @see scrm.requirements.Hardware#getDependingFeature()
	 * @see #getHardware()
	 * @generated
	 */
	EReference getHardware_DependingFeature();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see scrm.requirements.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.Constraint#getRestrictedFeature <em>Restricted Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Restricted Feature</em>'.
	 * @see scrm.requirements.Constraint#getRestrictedFeature()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_RestrictedFeature();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see scrm.requirements.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.Requirement#getRefinements <em>Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refinements</em>'.
	 * @see scrm.requirements.Requirement#getRefinements()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Refinements();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.Requirement#getRefinedRequirement <em>Refined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Refined Requirement</em>'.
	 * @see scrm.requirements.Requirement#getRefinedRequirement()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_RefinedRequirement();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.Requirement#getSpecifiedFeature <em>Specified Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specified Feature</em>'.
	 * @see scrm.requirements.Requirement#getSpecifiedFeature()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_SpecifiedFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.Requirement#getDefiningData <em>Defining Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Defining Data</em>'.
	 * @see scrm.requirements.Requirement#getDefiningData()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_DefiningData();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.Requirement#getRealizedMethod <em>Realized Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Realized Method</em>'.
	 * @see scrm.requirements.Requirement#getRealizedMethod()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_RealizedMethod();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.UserInterface <em>User Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Interface</em>'.
	 * @see scrm.requirements.UserInterface
	 * @generated
	 */
	EClass getUserInterface();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.UserInterface#getRequiringFeature <em>Requiring Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Requiring Feature</em>'.
	 * @see scrm.requirements.UserInterface#getRequiringFeature()
	 * @see #getUserInterface()
	 * @generated
	 */
	EReference getUserInterface_RequiringFeature();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.UserInterface#getProvidingFeature <em>Providing Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Providing Feature</em>'.
	 * @see scrm.requirements.UserInterface#getProvidingFeature()
	 * @see #getUserInterface()
	 * @generated
	 */
	EReference getUserInterface_ProvidingFeature();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.SoftwareInterface <em>Software Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Interface</em>'.
	 * @see scrm.requirements.SoftwareInterface
	 * @generated
	 */
	EClass getSoftwareInterface();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.SoftwareInterface#getRequiringFeature <em>Requiring Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Requiring Feature</em>'.
	 * @see scrm.requirements.SoftwareInterface#getRequiringFeature()
	 * @see #getSoftwareInterface()
	 * @generated
	 */
	EReference getSoftwareInterface_RequiringFeature();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.SoftwareInterface#getProvidingFeature <em>Providing Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Providing Feature</em>'.
	 * @see scrm.requirements.SoftwareInterface#getProvidingFeature()
	 * @see #getSoftwareInterface()
	 * @generated
	 */
	EReference getSoftwareInterface_ProvidingFeature();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see scrm.requirements.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the containment reference '{@link scrm.requirements.Process#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Flow</em>'.
	 * @see scrm.requirements.Process#getDataFlow()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_DataFlow();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.Performance <em>Performance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Performance</em>'.
	 * @see scrm.requirements.Performance
	 * @generated
	 */
	EClass getPerformance();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.DataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow</em>'.
	 * @see scrm.requirements.DataFlow
	 * @generated
	 */
	EClass getDataFlow();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.DataFlow#getSpecifiedProcess <em>Specified Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Specified Process</em>'.
	 * @see scrm.requirements.DataFlow#getSpecifiedProcess()
	 * @see #getDataFlow()
	 * @generated
	 */
	EReference getDataFlow_SpecifiedProcess();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.DataDefinition <em>Data Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Definition</em>'.
	 * @see scrm.requirements.DataDefinition
	 * @generated
	 */
	EClass getDataDefinition();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.DataDefinition#getDefinedRequirement <em>Defined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Defined Requirement</em>'.
	 * @see scrm.requirements.DataDefinition#getDefinedRequirement()
	 * @see #getDataDefinition()
	 * @generated
	 */
	EReference getDataDefinition_DefinedRequirement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequirementsFactory getRequirementsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link scrm.requirements.IRequirement <em>IRequirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.IRequirement
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getIRequirement()
		 * @generated
		 */
		EClass IREQUIREMENT = eINSTANCE.getIRequirement();

		/**
		 * The meta object literal for the '<em><b>Used Knowledge</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IREQUIREMENT__USED_KNOWLEDGE = eINSTANCE.getIRequirement_UsedKnowledge();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.FeatureImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CONSTRAINTS = eINSTANCE.getFeature_Constraints();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__DEPENDENCIES = eINSTANCE.getFeature_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Required User Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__REQUIRED_USER_INTERFACE = eINSTANCE.getFeature_RequiredUserInterface();

		/**
		 * The meta object literal for the '<em><b>Provided User Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__PROVIDED_USER_INTERFACES = eINSTANCE.getFeature_ProvidedUserInterfaces();

		/**
		 * The meta object literal for the '<em><b>Required Software Interface</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__REQUIRED_SOFTWARE_INTERFACE = eINSTANCE.getFeature_RequiredSoftwareInterface();

		/**
		 * The meta object literal for the '<em><b>Provided Software Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__PROVIDED_SOFTWARE_INTERFACES = eINSTANCE.getFeature_ProvidedSoftwareInterfaces();

		/**
		 * The meta object literal for the '<em><b>Detailed Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__DETAILED_REQUIREMENTS = eINSTANCE.getFeature_DetailedRequirements();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.HardwareImpl <em>Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.HardwareImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getHardware()
		 * @generated
		 */
		EClass HARDWARE = eINSTANCE.getHardware();

		/**
		 * The meta object literal for the '<em><b>Depending Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HARDWARE__DEPENDING_FEATURE = eINSTANCE.getHardware_DependingFeature();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.ConstraintImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Restricted Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__RESTRICTED_FEATURE = eINSTANCE.getConstraint_RestrictedFeature();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.RequirementImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Refinements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REFINEMENTS = eINSTANCE.getRequirement_Refinements();

		/**
		 * The meta object literal for the '<em><b>Refined Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REFINED_REQUIREMENT = eINSTANCE.getRequirement_RefinedRequirement();

		/**
		 * The meta object literal for the '<em><b>Specified Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__SPECIFIED_FEATURE = eINSTANCE.getRequirement_SpecifiedFeature();

		/**
		 * The meta object literal for the '<em><b>Defining Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__DEFINING_DATA = eINSTANCE.getRequirement_DefiningData();

		/**
		 * The meta object literal for the '<em><b>Realized Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REALIZED_METHOD = eINSTANCE.getRequirement_RealizedMethod();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.UserInterfaceImpl <em>User Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.UserInterfaceImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getUserInterface()
		 * @generated
		 */
		EClass USER_INTERFACE = eINSTANCE.getUserInterface();

		/**
		 * The meta object literal for the '<em><b>Requiring Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERFACE__REQUIRING_FEATURE = eINSTANCE.getUserInterface_RequiringFeature();

		/**
		 * The meta object literal for the '<em><b>Providing Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_INTERFACE__PROVIDING_FEATURE = eINSTANCE.getUserInterface_ProvidingFeature();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.SoftwareInterfaceImpl <em>Software Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.SoftwareInterfaceImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getSoftwareInterface()
		 * @generated
		 */
		EClass SOFTWARE_INTERFACE = eINSTANCE.getSoftwareInterface();

		/**
		 * The meta object literal for the '<em><b>Requiring Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_INTERFACE__REQUIRING_FEATURE = eINSTANCE.getSoftwareInterface_RequiringFeature();

		/**
		 * The meta object literal for the '<em><b>Providing Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOFTWARE_INTERFACE__PROVIDING_FEATURE = eINSTANCE.getSoftwareInterface_ProvidingFeature();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.ProcessImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Data Flow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__DATA_FLOW = eINSTANCE.getProcess_DataFlow();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.PerformanceImpl <em>Performance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.PerformanceImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getPerformance()
		 * @generated
		 */
		EClass PERFORMANCE = eINSTANCE.getPerformance();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.DataFlowImpl <em>Data Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.DataFlowImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getDataFlow()
		 * @generated
		 */
		EClass DATA_FLOW = eINSTANCE.getDataFlow();

		/**
		 * The meta object literal for the '<em><b>Specified Process</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_FLOW__SPECIFIED_PROCESS = eINSTANCE.getDataFlow_SpecifiedProcess();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.DataDefinitionImpl <em>Data Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.DataDefinitionImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getDataDefinition()
		 * @generated
		 */
		EClass DATA_DEFINITION = eINSTANCE.getDataDefinition();

		/**
		 * The meta object literal for the '<em><b>Defined Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DEFINITION__DEFINED_REQUIREMENT = eINSTANCE.getDataDefinition_DefinedRequirement();

	}

} //RequirementsPackage
