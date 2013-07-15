/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataProcess;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import scrm.ScrmPackage;
import scrm.requirements.RequirementsPackage;

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
 * @see scrm.requirements.dataProcess.DataProcessFactory
 * @model kind="package"
 * @generated
 */
public interface DataProcessPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dataProcess";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/scrm/requirements/dataProcess";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.scrm.requirements.dataProcess";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataProcessPackage eINSTANCE = scrm.requirements.dataProcess.impl.DataProcessPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.InputDataReadingImpl <em>Input Data Reading</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.InputDataReadingImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getInputDataReading()
	 * @generated
	 */
	int INPUT_DATA_READING = 1;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.DataHandlingImpl <em>Data Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.DataHandlingImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getDataHandling()
	 * @generated
	 */
	int DATA_HANDLING = 2;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.ResultsOutputImpl <em>Results Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.ResultsOutputImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getResultsOutput()
	 * @generated
	 */
	int RESULTS_OUTPUT = 3;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.ErrorHandlingImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getErrorHandling()
	 * @generated
	 */
	int ERROR_HANDLING = 4;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.StatusMonitoringImpl <em>Status Monitoring</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.StatusMonitoringImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getStatusMonitoring()
	 * @generated
	 */
	int STATUS_MONITORING = 5;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.ProcessImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = RequirementsPackage.REQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DESCRIPTION = RequirementsPackage.REQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ANNOTATIONS = RequirementsPackage.REQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ATTACHMENTS = RequirementsPackage.REQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__INCOMING_DOCUMENT_REFERENCES = RequirementsPackage.REQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__LEAF_SECTION = RequirementsPackage.REQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__STATE = RequirementsPackage.REQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__COMMENTS = RequirementsPackage.REQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CREATION_DATE = RequirementsPackage.REQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CREATOR = RequirementsPackage.REQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DISPLAYING_DIAGRAMS = RequirementsPackage.REQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CONTAINING_REQUIREMENT_SPACE = RequirementsPackage.REQUIREMENT__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REFINEMENTS = RequirementsPackage.REQUIREMENT__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REFINED_REQUIREMENT = RequirementsPackage.REQUIREMENT__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__SPECIFIED_FEATURE = RequirementsPackage.REQUIREMENT__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DEFINING_DATA = RequirementsPackage.REQUIREMENT__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REALIZED_METHOD = RequirementsPackage.REQUIREMENT__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DATA_FLOW = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PREDECESSOR = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__SUCCESSOR = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Containing Data Process Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CONTAINING_DATA_PROCESS_SPACE = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ERROR_HANDLING = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Status Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__STATUS_MONITORING = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__CONTAINING_REQUIREMENT_SPACE = PROCESS__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__DEFINING_DATA = PROCESS__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__DATA_FLOW = PROCESS__DATA_FLOW;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Containing Data Process Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__CONTAINING_DATA_PROCESS_SPACE = PROCESS__CONTAINING_DATA_PROCESS_SPACE;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The feature id for the '<em><b>Status Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING__STATUS_MONITORING = PROCESS__STATUS_MONITORING;

	/**
	 * The number of structural features of the '<em>Input Data Reading</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_DATA_READING_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__CONTAINING_REQUIREMENT_SPACE = PROCESS__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__DEFINING_DATA = PROCESS__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__DATA_FLOW = PROCESS__DATA_FLOW;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Containing Data Process Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__CONTAINING_DATA_PROCESS_SPACE = PROCESS__CONTAINING_DATA_PROCESS_SPACE;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The feature id for the '<em><b>Status Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING__STATUS_MONITORING = PROCESS__STATUS_MONITORING;

	/**
	 * The number of structural features of the '<em>Data Handling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_HANDLING_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__CONTAINING_REQUIREMENT_SPACE = PROCESS__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__DEFINING_DATA = PROCESS__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__DATA_FLOW = PROCESS__DATA_FLOW;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Containing Data Process Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__CONTAINING_DATA_PROCESS_SPACE = PROCESS__CONTAINING_DATA_PROCESS_SPACE;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The feature id for the '<em><b>Status Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT__STATUS_MONITORING = PROCESS__STATUS_MONITORING;

	/**
	 * The number of structural features of the '<em>Results Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULTS_OUTPUT_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__CONTAINING_REQUIREMENT_SPACE = PROCESS__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__DEFINING_DATA = PROCESS__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__DATA_FLOW = PROCESS__DATA_FLOW;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Containing Data Process Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__CONTAINING_DATA_PROCESS_SPACE = PROCESS__CONTAINING_DATA_PROCESS_SPACE;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The feature id for the '<em><b>Status Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__STATUS_MONITORING = PROCESS__STATUS_MONITORING;

	/**
	 * The feature id for the '<em><b>Handled Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__HANDLED_PROCESS = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Error Handling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__CONTAINING_REQUIREMENT_SPACE = PROCESS__CONTAINING_REQUIREMENT_SPACE;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__DEFINING_DATA = PROCESS__DEFINING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__DATA_FLOW = PROCESS__DATA_FLOW;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Containing Data Process Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__CONTAINING_DATA_PROCESS_SPACE = PROCESS__CONTAINING_DATA_PROCESS_SPACE;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The feature id for the '<em><b>Status Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__STATUS_MONITORING = PROCESS__STATUS_MONITORING;

	/**
	 * The feature id for the '<em><b>Monitored Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING__MONITORED_PROCESS = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Status Monitoring</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_MONITORING_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl <em>Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.DataProcessSpaceImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getDataProcessSpace()
	 * @generated
	 */
	int DATA_PROCESS_SPACE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__NAME = ScrmPackage.SCRM_SPACE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__DESCRIPTION = ScrmPackage.SCRM_SPACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__ANNOTATIONS = ScrmPackage.SCRM_SPACE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__ATTACHMENTS = ScrmPackage.SCRM_SPACE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__INCOMING_DOCUMENT_REFERENCES = ScrmPackage.SCRM_SPACE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__LEAF_SECTION = ScrmPackage.SCRM_SPACE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__STATE = ScrmPackage.SCRM_SPACE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__COMMENTS = ScrmPackage.SCRM_SPACE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__CREATION_DATE = ScrmPackage.SCRM_SPACE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__CREATOR = ScrmPackage.SCRM_SPACE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__DISPLAYING_DIAGRAMS = ScrmPackage.SCRM_SPACE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Representing Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__REPRESENTING_DIAGRAM = ScrmPackage.SCRM_SPACE__REPRESENTING_DIAGRAM;

	/**
	 * The feature id for the '<em><b>Containing Requirement Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__CONTAINING_REQUIREMENT_SPACE = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__REFINEMENTS = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__REFINED_REQUIREMENT = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__SPECIFIED_FEATURE = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Defining Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__DEFINING_DATA = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__REALIZED_METHOD = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Data Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__DATA_FLOW = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__PREDECESSOR = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__SUCCESSOR = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Containing Data Process Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__CONTAINING_DATA_PROCESS_SPACE = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__ERROR_HANDLING = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Status Monitoring</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__STATUS_MONITORING = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Contained Data Process Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PROCESS_SPACE_FEATURE_COUNT = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 13;

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.InputDataReading <em>Input Data Reading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Data Reading</em>'.
	 * @see scrm.requirements.dataProcess.InputDataReading
	 * @generated
	 */
	EClass getInputDataReading();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.DataHandling <em>Data Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Handling</em>'.
	 * @see scrm.requirements.dataProcess.DataHandling
	 * @generated
	 */
	EClass getDataHandling();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.ResultsOutput <em>Results Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Results Output</em>'.
	 * @see scrm.requirements.dataProcess.ResultsOutput
	 * @generated
	 */
	EClass getResultsOutput();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.ErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Handling</em>'.
	 * @see scrm.requirements.dataProcess.ErrorHandling
	 * @generated
	 */
	EClass getErrorHandling();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataProcess.ErrorHandling#getHandledProcess <em>Handled Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Handled Process</em>'.
	 * @see scrm.requirements.dataProcess.ErrorHandling#getHandledProcess()
	 * @see #getErrorHandling()
	 * @generated
	 */
	EReference getErrorHandling_HandledProcess();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.StatusMonitoring <em>Status Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status Monitoring</em>'.
	 * @see scrm.requirements.dataProcess.StatusMonitoring
	 * @generated
	 */
	EClass getStatusMonitoring();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataProcess.StatusMonitoring#getMonitoredProcess <em>Monitored Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Monitored Process</em>'.
	 * @see scrm.requirements.dataProcess.StatusMonitoring#getMonitoredProcess()
	 * @see #getStatusMonitoring()
	 * @generated
	 */
	EReference getStatusMonitoring_MonitoredProcess();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see scrm.requirements.dataProcess.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataProcess.Process#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Flow</em>'.
	 * @see scrm.requirements.dataProcess.Process#getDataFlow()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_DataFlow();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataProcess.Process#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor</em>'.
	 * @see scrm.requirements.dataProcess.Process#getPredecessor()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Predecessor();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataProcess.Process#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see scrm.requirements.dataProcess.Process#getSuccessor()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_Successor();

	/**
	 * Returns the meta object for the container reference '{@link scrm.requirements.dataProcess.Process#getContainingDataProcessSpace <em>Containing Data Process Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Data Process Space</em>'.
	 * @see scrm.requirements.dataProcess.Process#getContainingDataProcessSpace()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_ContainingDataProcessSpace();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataProcess.Process#getErrorHandling <em>Error Handling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Error Handling</em>'.
	 * @see scrm.requirements.dataProcess.Process#getErrorHandling()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_ErrorHandling();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataProcess.Process#getStatusMonitoring <em>Status Monitoring</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Status Monitoring</em>'.
	 * @see scrm.requirements.dataProcess.Process#getStatusMonitoring()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_StatusMonitoring();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.DataProcessSpace <em>Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Space</em>'.
	 * @see scrm.requirements.dataProcess.DataProcessSpace
	 * @generated
	 */
	EClass getDataProcessSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.requirements.dataProcess.DataProcessSpace#getContainedDataProcessSteps <em>Contained Data Process Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Data Process Steps</em>'.
	 * @see scrm.requirements.dataProcess.DataProcessSpace#getContainedDataProcessSteps()
	 * @see #getDataProcessSpace()
	 * @generated
	 */
	EReference getDataProcessSpace_ContainedDataProcessSteps();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataProcessFactory getDataProcessFactory();

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
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.InputDataReadingImpl <em>Input Data Reading</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.InputDataReadingImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getInputDataReading()
		 * @generated
		 */
		EClass INPUT_DATA_READING = eINSTANCE.getInputDataReading();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.DataHandlingImpl <em>Data Handling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.DataHandlingImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getDataHandling()
		 * @generated
		 */
		EClass DATA_HANDLING = eINSTANCE.getDataHandling();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.ResultsOutputImpl <em>Results Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.ResultsOutputImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getResultsOutput()
		 * @generated
		 */
		EClass RESULTS_OUTPUT = eINSTANCE.getResultsOutput();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.ErrorHandlingImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getErrorHandling()
		 * @generated
		 */
		EClass ERROR_HANDLING = eINSTANCE.getErrorHandling();

		/**
		 * The meta object literal for the '<em><b>Handled Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_HANDLING__HANDLED_PROCESS = eINSTANCE
				.getErrorHandling_HandledProcess();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.StatusMonitoringImpl <em>Status Monitoring</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.StatusMonitoringImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getStatusMonitoring()
		 * @generated
		 */
		EClass STATUS_MONITORING = eINSTANCE.getStatusMonitoring();

		/**
		 * The meta object literal for the '<em><b>Monitored Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATUS_MONITORING__MONITORED_PROCESS = eINSTANCE
				.getStatusMonitoring_MonitoredProcess();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.ProcessImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Data Flow</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__DATA_FLOW = eINSTANCE.getProcess_DataFlow();

		/**
		 * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__PREDECESSOR = eINSTANCE.getProcess_Predecessor();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__SUCCESSOR = eINSTANCE.getProcess_Successor();

		/**
		 * The meta object literal for the '<em><b>Containing Data Process Space</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__CONTAINING_DATA_PROCESS_SPACE = eINSTANCE
				.getProcess_ContainingDataProcessSpace();

		/**
		 * The meta object literal for the '<em><b>Error Handling</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__ERROR_HANDLING = eINSTANCE
				.getProcess_ErrorHandling();

		/**
		 * The meta object literal for the '<em><b>Status Monitoring</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__STATUS_MONITORING = eINSTANCE
				.getProcess_StatusMonitoring();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.DataProcessSpaceImpl <em>Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.DataProcessSpaceImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getDataProcessSpace()
		 * @generated
		 */
		EClass DATA_PROCESS_SPACE = eINSTANCE.getDataProcessSpace();

		/**
		 * The meta object literal for the '<em><b>Contained Data Process Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PROCESS_SPACE__CONTAINED_DATA_PROCESS_STEPS = eINSTANCE
				.getDataProcessSpace_ContainedDataProcessSteps();

	}

} //DataProcessPackage
