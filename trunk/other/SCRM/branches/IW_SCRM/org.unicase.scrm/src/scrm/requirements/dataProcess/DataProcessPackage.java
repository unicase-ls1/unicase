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
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.ErrorHandlingImpl <em>Error Handling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.ErrorHandlingImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getErrorHandling()
	 * @generated
	 */
	int ERROR_HANDLING = 3;

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
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__HANDLING_DATA = RequirementsPackage.REQUIREMENT__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REALIZED_METHOD = RequirementsPackage.REQUIREMENT__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PROVIDED_INTERFACE = RequirementsPackage.REQUIREMENT__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REQUIRED_INTERFACE = RequirementsPackage.REQUIREMENT__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__MANDATORY = RequirementsPackage.REQUIREMENT__MANDATORY;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PREDECESSOR = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__SUCCESSOR = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ERROR_HANDLING = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = RequirementsPackage.REQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.DataVisualizationProcessImpl <em>Data Visualization Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.DataVisualizationProcessImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getDataVisualizationProcess()
	 * @generated
	 */
	int DATA_VISUALIZATION_PROCESS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__HANDLING_DATA = PROCESS__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__PROVIDED_INTERFACE = PROCESS__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__REQUIRED_INTERFACE = PROCESS__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__MANDATORY = PROCESS__MANDATORY;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The number of structural features of the '<em>Data Visualization Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_VISUALIZATION_PROCESS_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.ReportGenerationProcessImpl <em>Report Generation Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.ReportGenerationProcessImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getReportGenerationProcess()
	 * @generated
	 */
	int REPORT_GENERATION_PROCESS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__HANDLING_DATA = PROCESS__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__PROVIDED_INTERFACE = PROCESS__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__REQUIRED_INTERFACE = PROCESS__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__MANDATORY = PROCESS__MANDATORY;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The number of structural features of the '<em>Report Generation Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPORT_GENERATION_PROCESS_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__HANDLING_DATA = PROCESS__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__PROVIDED_INTERFACE = PROCESS__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__REQUIRED_INTERFACE = PROCESS__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__MANDATORY = PROCESS__MANDATORY;

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
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLING__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

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
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.BuildingModelConstructionProcessImpl <em>Building Model Construction Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.BuildingModelConstructionProcessImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getBuildingModelConstructionProcess()
	 * @generated
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__HANDLING_DATA = PROCESS__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__PROVIDED_INTERFACE = PROCESS__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__REQUIRED_INTERFACE = PROCESS__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__MANDATORY = PROCESS__MANDATORY;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The number of structural features of the '<em>Building Model Construction Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_MODEL_CONSTRUCTION_PROCESS_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.CostMinimizationCalculationProcessImpl <em>Cost Minimization Calculation Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.CostMinimizationCalculationProcessImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getCostMinimizationCalculationProcess()
	 * @generated
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__HANDLING_DATA = PROCESS__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__PROVIDED_INTERFACE = PROCESS__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__REQUIRED_INTERFACE = PROCESS__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__MANDATORY = PROCESS__MANDATORY;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The number of structural features of the '<em>Cost Minimization Calculation Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COST_MINIMIZATION_CALCULATION_PROCESS_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.ControlSystemDesignProcessImpl <em>Control System Design Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.ControlSystemDesignProcessImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getControlSystemDesignProcess()
	 * @generated
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__HANDLING_DATA = PROCESS__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__PROVIDED_INTERFACE = PROCESS__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__REQUIRED_INTERFACE = PROCESS__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__MANDATORY = PROCESS__MANDATORY;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The number of structural features of the '<em>Control System Design Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_SYSTEM_DESIGN_PROCESS_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataProcess.impl.EnergyUsageCalculationProcessImpl <em>Energy Usage Calculation Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataProcess.impl.EnergyUsageCalculationProcessImpl
	 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getEnergyUsageCalculationProcess()
	 * @generated
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__NAME = PROCESS__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__DESCRIPTION = PROCESS__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__ANNOTATIONS = PROCESS__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__ATTACHMENTS = PROCESS__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__INCOMING_DOCUMENT_REFERENCES = PROCESS__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__LEAF_SECTION = PROCESS__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__STATE = PROCESS__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__COMMENTS = PROCESS__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__CREATION_DATE = PROCESS__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__CREATOR = PROCESS__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__DISPLAYING_DIAGRAMS = PROCESS__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__REFINEMENTS = PROCESS__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Requirement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__REFINED_REQUIREMENT = PROCESS__REFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Specified Feature</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__SPECIFIED_FEATURE = PROCESS__SPECIFIED_FEATURE;

	/**
	 * The feature id for the '<em><b>Handling Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__HANDLING_DATA = PROCESS__HANDLING_DATA;

	/**
	 * The feature id for the '<em><b>Realized Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__REALIZED_METHOD = PROCESS__REALIZED_METHOD;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__PROVIDED_INTERFACE = PROCESS__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__REQUIRED_INTERFACE = PROCESS__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__MANDATORY = PROCESS__MANDATORY;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__PREDECESSOR = PROCESS__PREDECESSOR;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__SUCCESSOR = PROCESS__SUCCESSOR;

	/**
	 * The feature id for the '<em><b>Error Handling</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS__ERROR_HANDLING = PROCESS__ERROR_HANDLING;

	/**
	 * The number of structural features of the '<em>Energy Usage Calculation Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENERGY_USAGE_CALCULATION_PROCESS_FEATURE_COUNT = PROCESS_FEATURE_COUNT + 0;

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
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.BuildingModelConstructionProcess <em>Building Model Construction Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Building Model Construction Process</em>'.
	 * @see scrm.requirements.dataProcess.BuildingModelConstructionProcess
	 * @generated
	 */
	EClass getBuildingModelConstructionProcess();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.CostMinimizationCalculationProcess <em>Cost Minimization Calculation Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cost Minimization Calculation Process</em>'.
	 * @see scrm.requirements.dataProcess.CostMinimizationCalculationProcess
	 * @generated
	 */
	EClass getCostMinimizationCalculationProcess();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.ControlSystemDesignProcess <em>Control System Design Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control System Design Process</em>'.
	 * @see scrm.requirements.dataProcess.ControlSystemDesignProcess
	 * @generated
	 */
	EClass getControlSystemDesignProcess();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.EnergyUsageCalculationProcess <em>Energy Usage Calculation Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Energy Usage Calculation Process</em>'.
	 * @see scrm.requirements.dataProcess.EnergyUsageCalculationProcess
	 * @generated
	 */
	EClass getEnergyUsageCalculationProcess();

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
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.DataVisualizationProcess <em>Data Visualization Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Visualization Process</em>'.
	 * @see scrm.requirements.dataProcess.DataVisualizationProcess
	 * @generated
	 */
	EClass getDataVisualizationProcess();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataProcess.ReportGenerationProcess <em>Report Generation Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Report Generation Process</em>'.
	 * @see scrm.requirements.dataProcess.ReportGenerationProcess
	 * @generated
	 */
	EClass getReportGenerationProcess();

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
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.BuildingModelConstructionProcessImpl <em>Building Model Construction Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.BuildingModelConstructionProcessImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getBuildingModelConstructionProcess()
		 * @generated
		 */
		EClass BUILDING_MODEL_CONSTRUCTION_PROCESS = eINSTANCE
				.getBuildingModelConstructionProcess();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.CostMinimizationCalculationProcessImpl <em>Cost Minimization Calculation Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.CostMinimizationCalculationProcessImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getCostMinimizationCalculationProcess()
		 * @generated
		 */
		EClass COST_MINIMIZATION_CALCULATION_PROCESS = eINSTANCE
				.getCostMinimizationCalculationProcess();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.ControlSystemDesignProcessImpl <em>Control System Design Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.ControlSystemDesignProcessImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getControlSystemDesignProcess()
		 * @generated
		 */
		EClass CONTROL_SYSTEM_DESIGN_PROCESS = eINSTANCE
				.getControlSystemDesignProcess();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.EnergyUsageCalculationProcessImpl <em>Energy Usage Calculation Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.EnergyUsageCalculationProcessImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getEnergyUsageCalculationProcess()
		 * @generated
		 */
		EClass ENERGY_USAGE_CALCULATION_PROCESS = eINSTANCE
				.getEnergyUsageCalculationProcess();

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
		 * The meta object literal for the '<em><b>Error Handling</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__ERROR_HANDLING = eINSTANCE
				.getProcess_ErrorHandling();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.DataVisualizationProcessImpl <em>Data Visualization Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.DataVisualizationProcessImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getDataVisualizationProcess()
		 * @generated
		 */
		EClass DATA_VISUALIZATION_PROCESS = eINSTANCE
				.getDataVisualizationProcess();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataProcess.impl.ReportGenerationProcessImpl <em>Report Generation Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataProcess.impl.ReportGenerationProcessImpl
		 * @see scrm.requirements.dataProcess.impl.DataProcessPackageImpl#getReportGenerationProcess()
		 * @generated
		 */
		EClass REPORT_GENERATION_PROCESS = eINSTANCE
				.getReportGenerationProcess();

	}

} //DataProcessPackage
