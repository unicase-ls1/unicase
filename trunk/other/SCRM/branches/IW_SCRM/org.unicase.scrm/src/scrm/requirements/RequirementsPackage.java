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
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__ANNOTATIONS = ScrmPackage.SCRM_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__ATTACHMENTS = ScrmPackage.SCRM_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__INCOMING_DOCUMENT_REFERENCES = ScrmPackage.SCRM_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__LEAF_SECTION = ScrmPackage.SCRM_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__STATE = ScrmPackage.SCRM_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__COMMENTS = ScrmPackage.SCRM_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__CREATION_DATE = ScrmPackage.SCRM_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__CREATOR = ScrmPackage.SCRM_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT__DISPLAYING_DIAGRAMS = ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The number of structural features of the '<em>IRequirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IREQUIREMENT_FEATURE_COUNT = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ANNOTATIONS = IREQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__ATTACHMENTS = IREQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__INCOMING_DOCUMENT_REFERENCES = IREQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__LEAF_SECTION = IREQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__STATE = IREQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__COMMENTS = IREQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CREATION_DATE = IREQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__CREATOR = IREQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

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
	int FEATURE = 3;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.ConstraintImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 5;

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
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ANNOTATIONS = IREQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ATTACHMENTS = IREQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__INCOMING_DOCUMENT_REFERENCES = IREQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__LEAF_SECTION = IREQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__STATE = IREQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__COMMENTS = IREQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CREATION_DATE = IREQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__CREATOR = IREQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

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
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MANDATORY = IREQUIREMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.UserInterfaceImpl <em>User Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.UserInterfaceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getUserInterface()
	 * @generated
	 */
	int USER_INTERFACE = 6;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.SoftwareInterfaceImpl <em>Software Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.SoftwareInterfaceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getSoftwareInterface()
	 * @generated
	 */
	int SOFTWARE_INTERFACE = 7;

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
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ANNOTATIONS = IREQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ATTACHMENTS = IREQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__INCOMING_DOCUMENT_REFERENCES = IREQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__LEAF_SECTION = IREQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__STATE = IREQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__COMMENTS = IREQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CREATION_DATE = IREQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CREATOR = IREQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

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
	 * The feature id for the '<em><b>Computational Hardware</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__COMPUTATIONAL_HARDWARE = IREQUIREMENT_FEATURE_COUNT + 4;

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
	 * The meta object id for the '{@link scrm.requirements.impl.ComputionalHardwareImpl <em>Computional Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.ComputionalHardwareImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getComputionalHardware()
	 * @generated
	 */
	int COMPUTIONAL_HARDWARE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__NAME = IREQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__DESCRIPTION = IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__ANNOTATIONS = IREQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__ATTACHMENTS = IREQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__INCOMING_DOCUMENT_REFERENCES = IREQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__LEAF_SECTION = IREQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__STATE = IREQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__COMMENTS = IREQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__CREATION_DATE = IREQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__CREATOR = IREQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Depending Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__DEPENDING_FEATURE = IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__PROCESSOR = IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Platform</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__PLATFORM = IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE__MEMORY = IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Computional Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTIONAL_HARDWARE_FEATURE_COUNT = IREQUIREMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ANNOTATIONS = IREQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ATTACHMENTS = IREQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__INCOMING_DOCUMENT_REFERENCES = IREQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__LEAF_SECTION = IREQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__STATE = IREQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__COMMENTS = IREQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CREATION_DATE = IREQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__CREATOR = IREQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DISPLAYING_DIAGRAMS = IREQUIREMENT__DISPLAYING_DIAGRAMS;

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
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__ANNOTATIONS = INTERFACE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__ATTACHMENTS = INTERFACE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__INCOMING_DOCUMENT_REFERENCES = INTERFACE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__LEAF_SECTION = INTERFACE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__STATE = INTERFACE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__COMMENTS = INTERFACE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__CREATION_DATE = INTERFACE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__CREATOR = INTERFACE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_INTERFACE__DISPLAYING_DIAGRAMS = INTERFACE__DISPLAYING_DIAGRAMS;

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
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__ANNOTATIONS = INTERFACE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__ATTACHMENTS = INTERFACE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__INCOMING_DOCUMENT_REFERENCES = INTERFACE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__LEAF_SECTION = INTERFACE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__STATE = INTERFACE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__COMMENTS = INTERFACE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__CREATION_DATE = INTERFACE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__CREATOR = INTERFACE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__DISPLAYING_DIAGRAMS = INTERFACE__DISPLAYING_DIAGRAMS;

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
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE__VERSION = INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Software Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_INTERFACE_FEATURE_COUNT = INTERFACE_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__ANNOTATIONS = REQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__ATTACHMENTS = REQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__INCOMING_DOCUMENT_REFERENCES = REQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__LEAF_SECTION = REQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__STATE = REQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__COMMENTS = REQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__CREATION_DATE = REQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__CREATOR = REQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__DISPLAYING_DIAGRAMS = REQUIREMENT__DISPLAYING_DIAGRAMS;

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
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERFORMANCE__MANDATORY = REQUIREMENT__MANDATORY;

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
	 * The meta object id for the '{@link scrm.requirements.impl.HardwareInterfaceImpl <em>Hardware Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.HardwareInterfaceImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getHardwareInterface()
	 * @generated
	 */
	int HARDWARE_INTERFACE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__NAME = INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__DESCRIPTION = INTERFACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__ANNOTATIONS = INTERFACE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__ATTACHMENTS = INTERFACE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__INCOMING_DOCUMENT_REFERENCES = INTERFACE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__LEAF_SECTION = INTERFACE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__STATE = INTERFACE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__COMMENTS = INTERFACE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__CREATION_DATE = INTERFACE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__CREATOR = INTERFACE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__DISPLAYING_DIAGRAMS = INTERFACE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Providing Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__PROVIDING_FEATURES = INTERFACE__PROVIDING_FEATURES;

	/**
	 * The feature id for the '<em><b>Requiring Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__REQUIRING_FEATURES = INTERFACE__REQUIRING_FEATURES;

	/**
	 * The feature id for the '<em><b>Providing Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__PROVIDING_DATA = INTERFACE__PROVIDING_DATA;

	/**
	 * The feature id for the '<em><b>Requiring Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__REQUIRING_DATA = INTERFACE__REQUIRING_DATA;

	/**
	 * The feature id for the '<em><b>Details Of Providing Functions And Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES = INTERFACE__DETAILS_OF_PROVIDING_FUNCTIONS_AND_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Details Of Requiring Functions And Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES = INTERFACE__DETAILS_OF_REQUIRING_FUNCTIONS_AND_PROPERTIES;

	/**
	 * The number of structural features of the '<em>Hardware Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_INTERFACE_FEATURE_COUNT = INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.impl.RegulatoryPolicyImpl <em>Regulatory Policy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.impl.RegulatoryPolicyImpl
	 * @see scrm.requirements.impl.RequirementsPackageImpl#getRegulatoryPolicy()
	 * @generated
	 */
	int REGULATORY_POLICY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__DESCRIPTION = CONSTRAINT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__ANNOTATIONS = CONSTRAINT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__ATTACHMENTS = CONSTRAINT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__INCOMING_DOCUMENT_REFERENCES = CONSTRAINT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__LEAF_SECTION = CONSTRAINT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__STATE = CONSTRAINT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__COMMENTS = CONSTRAINT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__CREATION_DATE = CONSTRAINT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__CREATOR = CONSTRAINT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__DISPLAYING_DIAGRAMS = CONSTRAINT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Restricted Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY__RESTRICTED_FEATURE = CONSTRAINT__RESTRICTED_FEATURE;

	/**
	 * The number of structural features of the '<em>Regulatory Policy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGULATORY_POLICY_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

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
	 * Returns the meta object for the reference list '{@link scrm.requirements.Feature#getComputationalHardware <em>Computational Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Computational Hardware</em>'.
	 * @see scrm.requirements.Feature#getComputationalHardware()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_ComputationalHardware();

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
	 * Returns the meta object for class '{@link scrm.requirements.ComputionalHardware <em>Computional Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computional Hardware</em>'.
	 * @see scrm.requirements.ComputionalHardware
	 * @generated
	 */
	EClass getComputionalHardware();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.ComputionalHardware#getDependingFeature <em>Depending Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depending Feature</em>'.
	 * @see scrm.requirements.ComputionalHardware#getDependingFeature()
	 * @see #getComputionalHardware()
	 * @generated
	 */
	EReference getComputionalHardware_DependingFeature();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.ComputionalHardware#getProcessor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processor</em>'.
	 * @see scrm.requirements.ComputionalHardware#getProcessor()
	 * @see #getComputionalHardware()
	 * @generated
	 */
	EAttribute getComputionalHardware_Processor();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.ComputionalHardware#getPlatform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Platform</em>'.
	 * @see scrm.requirements.ComputionalHardware#getPlatform()
	 * @see #getComputionalHardware()
	 * @generated
	 */
	EAttribute getComputionalHardware_Platform();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.ComputionalHardware#getMemory <em>Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory</em>'.
	 * @see scrm.requirements.ComputionalHardware#getMemory()
	 * @see #getComputionalHardware()
	 * @generated
	 */
	EAttribute getComputionalHardware_Memory();

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
	 * Returns the meta object for the attribute '{@link scrm.requirements.Requirement#isMandatory <em>Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mandatory</em>'.
	 * @see scrm.requirements.Requirement#isMandatory()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Mandatory();

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
	 * Returns the meta object for the attribute '{@link scrm.requirements.SoftwareInterface#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see scrm.requirements.SoftwareInterface#getVersion()
	 * @see #getSoftwareInterface()
	 * @generated
	 */
	EAttribute getSoftwareInterface_Version();

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
	 * Returns the meta object for class '{@link scrm.requirements.HardwareInterface <em>Hardware Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hardware Interface</em>'.
	 * @see scrm.requirements.HardwareInterface
	 * @generated
	 */
	EClass getHardwareInterface();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.RegulatoryPolicy <em>Regulatory Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Regulatory Policy</em>'.
	 * @see scrm.requirements.RegulatoryPolicy
	 * @generated
	 */
	EClass getRegulatoryPolicy();

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
		 * The meta object literal for the '<em><b>Computational Hardware</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__COMPUTATIONAL_HARDWARE = eINSTANCE
				.getFeature_ComputationalHardware();

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
		 * The meta object literal for the '{@link scrm.requirements.impl.ComputionalHardwareImpl <em>Computional Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.ComputionalHardwareImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getComputionalHardware()
		 * @generated
		 */
		EClass COMPUTIONAL_HARDWARE = eINSTANCE.getComputionalHardware();

		/**
		 * The meta object literal for the '<em><b>Depending Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTIONAL_HARDWARE__DEPENDING_FEATURE = eINSTANCE
				.getComputionalHardware_DependingFeature();

		/**
		 * The meta object literal for the '<em><b>Processor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTIONAL_HARDWARE__PROCESSOR = eINSTANCE
				.getComputionalHardware_Processor();

		/**
		 * The meta object literal for the '<em><b>Platform</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTIONAL_HARDWARE__PLATFORM = eINSTANCE
				.getComputionalHardware_Platform();

		/**
		 * The meta object literal for the '<em><b>Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTIONAL_HARDWARE__MEMORY = eINSTANCE
				.getComputionalHardware_Memory();

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
		 * The meta object literal for the '<em><b>Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REQUIREMENT__MANDATORY = eINSTANCE
				.getRequirement_Mandatory();

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
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE_INTERFACE__VERSION = eINSTANCE
				.getSoftwareInterface_Version();

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
		 * The meta object literal for the '{@link scrm.requirements.impl.HardwareInterfaceImpl <em>Hardware Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.HardwareInterfaceImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getHardwareInterface()
		 * @generated
		 */
		EClass HARDWARE_INTERFACE = eINSTANCE.getHardwareInterface();

		/**
		 * The meta object literal for the '{@link scrm.requirements.impl.RegulatoryPolicyImpl <em>Regulatory Policy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.impl.RegulatoryPolicyImpl
		 * @see scrm.requirements.impl.RequirementsPackageImpl#getRegulatoryPolicy()
		 * @generated
		 */
		EClass REGULATORY_POLICY = eINSTANCE.getRegulatoryPolicy();

	}

} //RequirementsPackage
