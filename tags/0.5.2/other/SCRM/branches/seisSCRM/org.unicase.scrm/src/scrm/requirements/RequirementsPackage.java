/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import scrm.ScrmPackage;

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
	RequirementsPackage eINSTANCE = scrm.requirements.impl.RequirementsPackageImpl
			.init();

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__NAME = ScrmPackage.SCRM_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__DESCRIPTION = ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__DISPLAYING_DIAGRAMS = ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>IRequirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT_FEATURE_COUNT = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scrm.requirements.Interface <em>Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.Interface
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getInterface()
	 * @generated
	 */
	int INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__NAME = IREQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DESCRIPTION = IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CONTAINING_REQUIREMENT_SPACE = IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Providing Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PROVIDING_FEATURES = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Requiring Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__REQUIRING_FEATURES = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Providing Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__PROVIDING_DATA = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Requiring Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__REQUIRING_DATA = IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Details Of Providing Functions And Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES = IREQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Details Of Requiring Functions And Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES = IREQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.FeatureImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 4;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.HardwareImpl <em>Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.HardwareImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getHardware()
	 * @generated
	 */
	int HARDWARE = 5;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.ConstraintImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 6;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.RequirementImpl <em>Requirement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.RequirementImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__NAME = IREQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DESCRIPTION = IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CONTAINING_REQUIREMENT_SPACE = IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE;

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
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__HANDLING_DATA = IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REALIZED_METHOD = IREQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__PROVIDED_INTERFACE = IREQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REQUIRED_INTERFACE = IREQUIREMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.UserInterfaceImpl <em>User Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.UserInterfaceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getUserInterface()
	 * @generated
	 */
	int USER_INTERFACE = 7;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.SoftwareInterfaceImpl <em>Software Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.SoftwareInterfaceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getSoftwareInterface()
	 * @generated
	 */
	int SOFTWARE_INTERFACE = 8;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.PerformanceImpl <em>Performance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.PerformanceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getPerformance()
	 * @generated
	 */
	int PERFORMANCE = 9;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.RequirementSpaceImpl <em>Requirement Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.RequirementSpaceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getRequirementSpace()
	 * @generated
	 */
	int REQUIREMENT_SPACE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPACE__NAME = ScrmPackage.SCRM_SPACE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPACE__DESCRIPTION = ScrmPackage.SCRM_SPACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPACE__DISPLAYING_DIAGRAMS = ScrmPackage.SCRM_SPACE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Representing Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPACE__REPRESENTING_DIAGRAM = ScrmPackage.SCRM_SPACE__REPRESENTING_DIAGRAM;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPACE__CONTAINING_REQUIREMENT_SPACE = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contained Informationof Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Requirement Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_SPACE_FEATURE_COUNT = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = IREQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DESCRIPTION = IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONTAINING_REQUIREMENT_SPACE = IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Detailed Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DETAILED_REQUIREMENTS = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__SUB_FEATURES = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Feature</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__SUPER_FEATURE = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CONSTRAINTS = IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DEPENDENCIES = IREQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Required Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIRED_INTERFACES = IREQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Provided Interfaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__PROVIDED_INTERFACES = IREQUIREMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Influencing Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__INFLUENCING_PROBLEM = IREQUIREMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Required Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIRED_FEATURES = IREQUIREMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Requiring Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__REQUIRING_FEATURES = IREQUIREMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Excluded Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__EXCLUDED_FEATURES = IREQUIREMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Excluding Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__EXCLUDING_FEATURES = IREQUIREMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__NAME = IREQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__DESCRIPTION = IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__CONTAINING_REQUIREMENT_SPACE = IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Depending Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__DEPENDING_FEATURE = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__PROCESSOR = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__PLATFORM = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__MEMORY = IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = IREQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DESCRIPTION = IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CONTAINING_REQUIREMENT_SPACE = IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Restricted Feature</b></em>' reference.
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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__NAME = INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__DESCRIPTION = INTERFACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__DISPLAYING_DIAGRAMS = INTERFACE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__CONTAINING_REQUIREMENT_SPACE = INTERFACE__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Providing Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__PROVIDING_FEATURES = INTERFACE__PROVIDING_FEATURES;

	/**
	 * The feature id for the '<em><b>Requiring Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__REQUIRING_FEATURES = INTERFACE__REQUIRING_FEATURES;

	/**
	 * The feature id for the '<em><b>Providing Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__PROVIDING_DATA = INTERFACE__PROVIDING_DATA;

	/**
	 * The feature id for the '<em><b>Requiring Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__REQUIRING_DATA = INTERFACE__REQUIRING_DATA;

	/**
	 * The feature id for the '<em><b>Details Of Providing Functions And Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES = INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Details Of Requiring Functions And Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES = INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES;

	/**
	 * The number of structural features of the '<em>User Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE_FEATURE_COUNT = INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__NAME = INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__DESCRIPTION = INTERFACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__DISPLAYING_DIAGRAMS = INTERFACE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__CONTAINING_REQUIREMENT_SPACE = INTERFACE__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Providing Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__PROVIDING_FEATURES = INTERFACE__PROVIDING_FEATURES;

	/**
	 * The feature id for the '<em><b>Requiring Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__REQUIRING_FEATURES = INTERFACE__REQUIRING_FEATURES;

	/**
	 * The feature id for the '<em><b>Providing Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__PROVIDING_DATA = INTERFACE__PROVIDING_DATA;

	/**
	 * The feature id for the '<em><b>Requiring Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__REQUIRING_DATA = INTERFACE__REQUIRING_DATA;

	/**
	 * The feature id for the '<em><b>Details Of Providing Functions And Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES = INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Details Of Requiring Functions And Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES = INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES;

	/**
	 * The number of structural features of the '<em>Software Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE_FEATURE_COUNT = INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__NAME = REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__DESCRIPTION = REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__DISPLAYING_DIAGRAMS = REQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__CONTAINING_REQUIREMENT_SPACE = REQUIREMENT__CONTAINING_REQUIREMENT_SPACE;

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
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__HANDLING_DATA = REQUIREMENT__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__REALIZED_METHOD = REQUIREMENT__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__PROVIDED_INTERFACE = REQUIREMENT__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__REQUIRED_INTERFACE = REQUIREMENT__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Hardware</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__HARDWARE = REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Performance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE_FEATURE_COUNT = REQUIREMENT_FEATURE_COUNT + 1;

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
	 * Returns the meta object for the container reference '{@link scrm.requirements.IRequirement#getContainingRequirementSpace <em>Containing Requirement Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Requirement Space</em>'.
	 * @see scrm.requirements.IRequirement#getContainingRequirementSpace()
	 * @see #getIRequirement()
	 * @generated
	 */
	EReference getIRequirement_ContainingRequirementSpace();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.Interface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface</em>'.
	 * @see scrm.requirements.Interface
	 * @generated
	 */
	EClass getInterface();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Interface#getProvidingFeatures <em>Providing Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Providing Features</em>'.
	 * @see scrm.requirements.Interface#getProvidingFeatures()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_ProvidingFeatures();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Interface#getRequiringFeatures <em>Requiring Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requiring Features</em>'.
	 * @see scrm.requirements.Interface#getRequiringFeatures()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_RequiringFeatures();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Interface#getProvidingData <em>Providing Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Providing Data</em>'.
	 * @see scrm.requirements.Interface#getProvidingData()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_ProvidingData();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Interface#getRequiringData <em>Requiring Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requiring Data</em>'.
	 * @see scrm.requirements.Interface#getRequiringData()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_RequiringData();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Interface#getDetailsOfProvidingFunctionsAndProperties <em>Details Of Providing Functions And Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Details Of Providing Functions And Properties</em>'.
	 * @see scrm.requirements.Interface#getDetailsOfProvidingFunctionsAndProperties()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_DetailsOfProvidingFunctionsAndProperties();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Interface#getDetailsOfRequiringFunctionsAndProperties <em>Details Of Requiring Functions And Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Details Of Requiring Functions And Properties</em>'.
	 * @see scrm.requirements.Interface#getDetailsOfRequiringFunctionsAndProperties()
	 * @see #getInterface()
	 * @generated
	 */
	EReference getInterface_DetailsOfRequiringFunctionsAndProperties();

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
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constraints</em>'.
	 * @see scrm.requirements.Feature#getConstraints()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Constraints();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see scrm.requirements.Feature#getDependencies()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Dependencies();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getRequiredInterfaces <em>Required Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Interfaces</em>'.
	 * @see scrm.requirements.Feature#getRequiredInterfaces()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_RequiredInterfaces();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getProvidedInterfaces <em>Provided Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Provided Interfaces</em>'.
	 * @see scrm.requirements.Feature#getProvidedInterfaces()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ProvidedInterfaces();

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
	 * Returns the meta object for the reference '{@link scrm.requirements.Feature#getInfluencingProblem <em>Influencing Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Influencing Problem</em>'.
	 * @see scrm.requirements.Feature#getInfluencingProblem()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_InfluencingProblem();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getSubFeatures <em>Sub Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Features</em>'.
	 * @see scrm.requirements.Feature#getSubFeatures()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_SubFeatures();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getSuperFeature <em>Super Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Feature</em>'.
	 * @see scrm.requirements.Feature#getSuperFeature()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_SuperFeature();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getRequiredFeatures <em>Required Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Features</em>'.
	 * @see scrm.requirements.Feature#getRequiredFeatures()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_RequiredFeatures();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getRequiringFeatures <em>Requiring Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requiring Features</em>'.
	 * @see scrm.requirements.Feature#getRequiringFeatures()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_RequiringFeatures();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getExcludedFeatures <em>Excluded Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Excluded Features</em>'.
	 * @see scrm.requirements.Feature#getExcludedFeatures()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ExcludedFeatures();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getExcludingFeatures <em>Excluding Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Excluding Features</em>'.
	 * @see scrm.requirements.Feature#getExcludingFeatures()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ExcludingFeatures();

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
	 * Returns the meta object for the reference '{@link scrm.requirements.Hardware#getDependingFeature <em>Depending Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depending Feature</em>'.
	 * @see scrm.requirements.Hardware#getDependingFeature()
	 * @see #getHardware()
	 * @generated
	 */
	EReference getHardware_DependingFeature();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.Hardware#getProcessor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processor</em>'.
	 * @see scrm.requirements.Hardware#getProcessor()
	 * @see #getHardware()
	 * @generated
	 */
	EAttribute getHardware_Processor();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.Hardware#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform</em>'.
	 * @see scrm.requirements.Hardware#getPlatform()
	 * @see #getHardware()
	 * @generated
	 */
	EAttribute getHardware_Platform();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.Hardware#getMemory <em>Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory</em>'.
	 * @see scrm.requirements.Hardware#getMemory()
	 * @see #getHardware()
	 * @generated
	 */
	EAttribute getHardware_Memory();

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
	 * Returns the meta object for the reference '{@link scrm.requirements.Constraint#getRestrictedFeature <em>Restricted Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Restricted Feature</em>'.
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
	 * Returns the meta object for the reference list '{@link scrm.requirements.Requirement#getHandlingData <em>Handling Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Handling Data</em>'.
	 * @see scrm.requirements.Requirement#getHandlingData()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_HandlingData();

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
	 * Returns the meta object for the reference '{@link scrm.requirements.Requirement#getProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Interface</em>'.
	 * @see scrm.requirements.Requirement#getProvidedInterface()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_ProvidedInterface();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.Requirement#getRequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Interface</em>'.
	 * @see scrm.requirements.Requirement#getRequiredInterface()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_RequiredInterface();

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
	 * Returns the meta object for class '{@link scrm.requirements.SoftwareInterface <em>Software Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Interface</em>'.
	 * @see scrm.requirements.SoftwareInterface
	 * @generated
	 */
	EClass getSoftwareInterface();

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
	 * Returns the meta object for the reference '{@link scrm.requirements.Performance#getHardware <em>Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hardware</em>'.
	 * @see scrm.requirements.Performance#getHardware()
	 * @see #getPerformance()
	 * @generated
	 */
	EReference getPerformance_Hardware();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.RequirementSpace <em>Requirement Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Requirement Space</em>'.
	 * @see scrm.requirements.RequirementSpace
	 * @generated
	 */
	EClass getRequirementSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.RequirementSpace#getContainedInformationofRequirements <em>Contained Informationof Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Informationof Requirements</em>'.
	 * @see scrm.requirements.RequirementSpace#getContainedInformationofRequirements()
	 * @see #getRequirementSpace()
	 * @generated
	 */
	EReference getRequirementSpace_ContainedInformationofRequirements();

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
		 * The meta object literal for the '<em><b>Containing Requirement Space</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IREQUIREMENT__CONTAINING_REQUIREMENT_SPACE = eINSTANCE
				.getIRequirement_ContainingRequirementSpace();

		/**
		 * The meta object literal for the '{@link scrm.requirements.Interface <em>Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.Interface
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getInterface()
		 * @generated
		 */
		EClass INTERFACE = eINSTANCE.getInterface();

		/**
		 * The meta object literal for the '<em><b>Providing Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__PROVIDING_FEATURES = eINSTANCE
				.getInterface_ProvidingFeatures();

		/**
		 * The meta object literal for the '<em><b>Requiring Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__REQUIRING_FEATURES = eINSTANCE
				.getInterface_RequiringFeatures();

		/**
		 * The meta object literal for the '<em><b>Providing Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__PROVIDING_DATA = eINSTANCE
				.getInterface_ProvidingData();

		/**
		 * The meta object literal for the '<em><b>Requiring Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__REQUIRING_DATA = eINSTANCE
				.getInterface_RequiringData();

		/**
		 * The meta object literal for the '<em><b>Details Of Providing Functions And Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES = eINSTANCE
				.getInterface_DetailsOfProvidingFunctionsAndProperties();

		/**
		 * The meta object literal for the '<em><b>Details Of Requiring Functions And Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES = eINSTANCE
				.getInterface_DetailsOfRequiringFunctionsAndProperties();

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
		 * The meta object literal for the '<em><b>Constraints</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CONSTRAINTS = eINSTANCE.getFeature_Constraints();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__DEPENDENCIES = eINSTANCE.getFeature_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Required Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__REQUIRED_INTERFACES = eINSTANCE
				.getFeature_RequiredInterfaces();

		/**
		 * The meta object literal for the '<em><b>Provided Interfaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__PROVIDED_INTERFACES = eINSTANCE
				.getFeature_ProvidedInterfaces();

		/**
		 * The meta object literal for the '<em><b>Detailed Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__DETAILED_REQUIREMENTS = eINSTANCE
				.getFeature_DetailedRequirements();

		/**
		 * The meta object literal for the '<em><b>Influencing Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__INFLUENCING_PROBLEM = eINSTANCE
				.getFeature_InfluencingProblem();

		/**
		 * The meta object literal for the '<em><b>Sub Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__SUB_FEATURES = eINSTANCE.getFeature_SubFeatures();

		/**
		 * The meta object literal for the '<em><b>Super Feature</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__SUPER_FEATURE = eINSTANCE.getFeature_SuperFeature();

		/**
		 * The meta object literal for the '<em><b>Required Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__REQUIRED_FEATURES = eINSTANCE
				.getFeature_RequiredFeatures();

		/**
		 * The meta object literal for the '<em><b>Requiring Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__REQUIRING_FEATURES = eINSTANCE
				.getFeature_RequiringFeatures();

		/**
		 * The meta object literal for the '<em><b>Excluded Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__EXCLUDED_FEATURES = eINSTANCE
				.getFeature_ExcludedFeatures();

		/**
		 * The meta object literal for the '<em><b>Excluding Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__EXCLUDING_FEATURES = eINSTANCE
				.getFeature_ExcludingFeatures();

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
		 * The meta object literal for the '<em><b>Depending Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HARDWARE__DEPENDING_FEATURE = eINSTANCE
				.getHardware_DependingFeature();

		/**
		 * The meta object literal for the '<em><b>Processor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HARDWARE__PROCESSOR = eINSTANCE.getHardware_Processor();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HARDWARE__PLATFORM = eINSTANCE.getHardware_Platform();

		/**
		 * The meta object literal for the '<em><b>Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HARDWARE__MEMORY = eINSTANCE.getHardware_Memory();

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
		 * The meta object literal for the '<em><b>Restricted Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__RESTRICTED_FEATURE = eINSTANCE
				.getConstraint_RestrictedFeature();

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
		EReference REQUIREMENT__REFINEMENTS = eINSTANCE
				.getRequirement_Refinements();

		/**
		 * The meta object literal for the '<em><b>Refined Requirement</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REFINED_REQUIREMENT = eINSTANCE
				.getRequirement_RefinedRequirement();

		/**
		 * The meta object literal for the '<em><b>Specified Feature</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__SPECIFIED_FEATURE = eINSTANCE
				.getRequirement_SpecifiedFeature();

		/**
		 * The meta object literal for the '<em><b>Handling Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__HANDLING_DATA = eINSTANCE
				.getRequirement_HandlingData();

		/**
		 * The meta object literal for the '<em><b>Realized Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REALIZED_METHOD = eINSTANCE
				.getRequirement_RealizedMethod();

		/**
		 * The meta object literal for the '<em><b>Provided Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__PROVIDED_INTERFACE = eINSTANCE
				.getRequirement_ProvidedInterface();

		/**
		 * The meta object literal for the '<em><b>Required Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT__REQUIRED_INTERFACE = eINSTANCE
				.getRequirement_RequiredInterface();

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
		 * The meta object literal for the '{@link scrm.requirements.impl.SoftwareInterfaceImpl <em>Software Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.SoftwareInterfaceImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getSoftwareInterface()
		 * @generated
		 */
		EClass SOFTWARE_INTERFACE = eINSTANCE.getSoftwareInterface();

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
		 * The meta object literal for the '<em><b>Hardware</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERFORMANCE__HARDWARE = eINSTANCE.getPerformance_Hardware();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.RequirementSpaceImpl <em>Requirement Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.RequirementSpaceImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getRequirementSpace()
		 * @generated
		 */
		EClass REQUIREMENT_SPACE = eINSTANCE.getRequirementSpace();

		/**
		 * The meta object literal for the '<em><b>Contained Informationof Requirements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REQUIREMENT_SPACE__CONTAINED_INFORMATIONOF_REQUIREMENTS = eINSTANCE
				.getRequirementSpace_ContainedInformationofRequirements();

	}

} //RequirementsPackage
