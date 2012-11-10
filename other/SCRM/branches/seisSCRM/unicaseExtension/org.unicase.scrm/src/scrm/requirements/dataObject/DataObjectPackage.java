/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements.dataObject;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see scrm.requirements.dataObject.DataObjectFactory
 * @model kind="package"
 * @generated
 */
public interface DataObjectPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dataObject";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/scrm/requirements/dataObject";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.scrm.requirements.dataObject";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DataObjectPackage eINSTANCE = scrm.requirements.dataObject.impl.DataObjectPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link scrm.requirements.dataObject.impl.DataDefinitionImpl <em>Data Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataObject.impl.DataDefinitionImpl
	 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getDataDefinition()
	 * @generated
	 */
	int DATA_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__NAME = RequirementsPackage.IREQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__DESCRIPTION = RequirementsPackage.IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__ANNOTATIONS = RequirementsPackage.IREQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__ATTACHMENTS = RequirementsPackage.IREQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__INCOMING_DOCUMENT_REFERENCES = RequirementsPackage.IREQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__LEAF_SECTION = RequirementsPackage.IREQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__STATE = RequirementsPackage.IREQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__COMMENTS = RequirementsPackage.IREQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__CREATION_DATE = RequirementsPackage.IREQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__CREATOR = RequirementsPackage.IREQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__DISPLAYING_DIAGRAMS = RequirementsPackage.IREQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Defined Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__DEFINED_REQUIREMENT = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Accuracy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__ACCURACY = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__RANGE = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__FORMAT = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__PROVIDED_INTERFACE = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__REQUIRED_INTERFACE = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Described Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION__DESCRIBED_MODEL = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Data Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DEFINITION_FEATURE_COUNT = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataObject.impl.SeismicSourceImpl <em>Seismic Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataObject.impl.SeismicSourceImpl
	 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getSeismicSource()
	 * @generated
	 */
	int SEISMIC_SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__NAME = DATA_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__DESCRIPTION = DATA_DEFINITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__ANNOTATIONS = DATA_DEFINITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__ATTACHMENTS = DATA_DEFINITION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__INCOMING_DOCUMENT_REFERENCES = DATA_DEFINITION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__LEAF_SECTION = DATA_DEFINITION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__STATE = DATA_DEFINITION__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__COMMENTS = DATA_DEFINITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__CREATION_DATE = DATA_DEFINITION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__CREATOR = DATA_DEFINITION__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__DISPLAYING_DIAGRAMS = DATA_DEFINITION__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Defined Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__DEFINED_REQUIREMENT = DATA_DEFINITION__DEFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Accuracy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__ACCURACY = DATA_DEFINITION__ACCURACY;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__RANGE = DATA_DEFINITION__RANGE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__FORMAT = DATA_DEFINITION__FORMAT;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__PROVIDED_INTERFACE = DATA_DEFINITION__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__REQUIRED_INTERFACE = DATA_DEFINITION__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Described Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE__DESCRIBED_MODEL = DATA_DEFINITION__DESCRIBED_MODEL;

	/**
	 * The number of structural features of the '<em>Seismic Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEISMIC_SOURCE_FEATURE_COUNT = DATA_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataObject.impl.ComputationalMeshImpl <em>Computational Mesh</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataObject.impl.ComputationalMeshImpl
	 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getComputationalMesh()
	 * @generated
	 */
	int COMPUTATIONAL_MESH = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__NAME = DATA_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__DESCRIPTION = DATA_DEFINITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__ANNOTATIONS = DATA_DEFINITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__ATTACHMENTS = DATA_DEFINITION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__INCOMING_DOCUMENT_REFERENCES = DATA_DEFINITION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__LEAF_SECTION = DATA_DEFINITION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__STATE = DATA_DEFINITION__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__COMMENTS = DATA_DEFINITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__CREATION_DATE = DATA_DEFINITION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__CREATOR = DATA_DEFINITION__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__DISPLAYING_DIAGRAMS = DATA_DEFINITION__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Defined Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__DEFINED_REQUIREMENT = DATA_DEFINITION__DEFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Accuracy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__ACCURACY = DATA_DEFINITION__ACCURACY;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__RANGE = DATA_DEFINITION__RANGE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__FORMAT = DATA_DEFINITION__FORMAT;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__PROVIDED_INTERFACE = DATA_DEFINITION__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__REQUIRED_INTERFACE = DATA_DEFINITION__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Described Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH__DESCRIBED_MODEL = DATA_DEFINITION__DESCRIBED_MODEL;

	/**
	 * The number of structural features of the '<em>Computational Mesh</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATIONAL_MESH_FEATURE_COUNT = DATA_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataObject.impl.SyntheticSeismogramImpl <em>Synthetic Seismogram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataObject.impl.SyntheticSeismogramImpl
	 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getSyntheticSeismogram()
	 * @generated
	 */
	int SYNTHETIC_SEISMOGRAM = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__NAME = DATA_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__DESCRIPTION = DATA_DEFINITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__ANNOTATIONS = DATA_DEFINITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__ATTACHMENTS = DATA_DEFINITION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__INCOMING_DOCUMENT_REFERENCES = DATA_DEFINITION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__LEAF_SECTION = DATA_DEFINITION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__STATE = DATA_DEFINITION__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__COMMENTS = DATA_DEFINITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__CREATION_DATE = DATA_DEFINITION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__CREATOR = DATA_DEFINITION__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__DISPLAYING_DIAGRAMS = DATA_DEFINITION__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Defined Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__DEFINED_REQUIREMENT = DATA_DEFINITION__DEFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Accuracy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__ACCURACY = DATA_DEFINITION__ACCURACY;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__RANGE = DATA_DEFINITION__RANGE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__FORMAT = DATA_DEFINITION__FORMAT;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__PROVIDED_INTERFACE = DATA_DEFINITION__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__REQUIRED_INTERFACE = DATA_DEFINITION__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Described Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM__DESCRIBED_MODEL = DATA_DEFINITION__DESCRIBED_MODEL;

	/**
	 * The number of structural features of the '<em>Synthetic Seismogram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNTHETIC_SEISMOGRAM_FEATURE_COUNT = DATA_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataObject.impl.StationImpl <em>Station</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataObject.impl.StationImpl
	 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getStation()
	 * @generated
	 */
	int STATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__NAME = DATA_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__DESCRIPTION = DATA_DEFINITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__ANNOTATIONS = DATA_DEFINITION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__ATTACHMENTS = DATA_DEFINITION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__INCOMING_DOCUMENT_REFERENCES = DATA_DEFINITION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__LEAF_SECTION = DATA_DEFINITION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__STATE = DATA_DEFINITION__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__COMMENTS = DATA_DEFINITION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__CREATION_DATE = DATA_DEFINITION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__CREATOR = DATA_DEFINITION__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__DISPLAYING_DIAGRAMS = DATA_DEFINITION__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Defined Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__DEFINED_REQUIREMENT = DATA_DEFINITION__DEFINED_REQUIREMENT;

	/**
	 * The feature id for the '<em><b>Accuracy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__ACCURACY = DATA_DEFINITION__ACCURACY;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__RANGE = DATA_DEFINITION__RANGE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__FORMAT = DATA_DEFINITION__FORMAT;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__PROVIDED_INTERFACE = DATA_DEFINITION__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__REQUIRED_INTERFACE = DATA_DEFINITION__REQUIRED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Described Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION__DESCRIBED_MODEL = DATA_DEFINITION__DESCRIBED_MODEL;

	/**
	 * The number of structural features of the '<em>Station</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATION_FEATURE_COUNT = DATA_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.requirements.dataObject.impl.ControlParameterImpl <em>Control Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.requirements.dataObject.impl.ControlParameterImpl
	 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getControlParameter()
	 * @generated
	 */
	int CONTROL_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__NAME = RequirementsPackage.IREQUIREMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__DESCRIPTION = RequirementsPackage.IREQUIREMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__ANNOTATIONS = RequirementsPackage.IREQUIREMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__ATTACHMENTS = RequirementsPackage.IREQUIREMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__INCOMING_DOCUMENT_REFERENCES = RequirementsPackage.IREQUIREMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__LEAF_SECTION = RequirementsPackage.IREQUIREMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__STATE = RequirementsPackage.IREQUIREMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__COMMENTS = RequirementsPackage.IREQUIREMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__CREATION_DATE = RequirementsPackage.IREQUIREMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__CREATOR = RequirementsPackage.IREQUIREMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__DISPLAYING_DIAGRAMS = RequirementsPackage.IREQUIREMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Controlled Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__CONTROLLED_PROCESS = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER__FORMAT = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Control Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PARAMETER_FEATURE_COUNT = RequirementsPackage.IREQUIREMENT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataObject.DataDefinition <em>Data Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Definition</em>'.
	 * @see scrm.requirements.dataObject.DataDefinition
	 * @generated
	 */
	EClass getDataDefinition();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataObject.DataDefinition#getDefinedRequirement <em>Defined Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Defined Requirement</em>'.
	 * @see scrm.requirements.dataObject.DataDefinition#getDefinedRequirement()
	 * @see #getDataDefinition()
	 * @generated
	 */
	EReference getDataDefinition_DefinedRequirement();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.dataObject.DataDefinition#getAccuracy <em>Accuracy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Accuracy</em>'.
	 * @see scrm.requirements.dataObject.DataDefinition#getAccuracy()
	 * @see #getDataDefinition()
	 * @generated
	 */
	EAttribute getDataDefinition_Accuracy();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.dataObject.DataDefinition#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see scrm.requirements.dataObject.DataDefinition#getRange()
	 * @see #getDataDefinition()
	 * @generated
	 */
	EAttribute getDataDefinition_Range();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.dataObject.DataDefinition#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see scrm.requirements.dataObject.DataDefinition#getFormat()
	 * @see #getDataDefinition()
	 * @generated
	 */
	EAttribute getDataDefinition_Format();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataObject.DataDefinition#getProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Interface</em>'.
	 * @see scrm.requirements.dataObject.DataDefinition#getProvidedInterface()
	 * @see #getDataDefinition()
	 * @generated
	 */
	EReference getDataDefinition_ProvidedInterface();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataObject.DataDefinition#getRequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Interface</em>'.
	 * @see scrm.requirements.dataObject.DataDefinition#getRequiredInterface()
	 * @see #getDataDefinition()
	 * @generated
	 */
	EReference getDataDefinition_RequiredInterface();

	/**
	 * Returns the meta object for the reference list '{@link scrm.requirements.dataObject.DataDefinition#getDescribedModel <em>Described Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Described Model</em>'.
	 * @see scrm.requirements.dataObject.DataDefinition#getDescribedModel()
	 * @see #getDataDefinition()
	 * @generated
	 */
	EReference getDataDefinition_DescribedModel();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataObject.SeismicSource <em>Seismic Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Seismic Source</em>'.
	 * @see scrm.requirements.dataObject.SeismicSource
	 * @generated
	 */
	EClass getSeismicSource();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataObject.ComputationalMesh <em>Computational Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computational Mesh</em>'.
	 * @see scrm.requirements.dataObject.ComputationalMesh
	 * @generated
	 */
	EClass getComputationalMesh();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataObject.SyntheticSeismogram <em>Synthetic Seismogram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Synthetic Seismogram</em>'.
	 * @see scrm.requirements.dataObject.SyntheticSeismogram
	 * @generated
	 */
	EClass getSyntheticSeismogram();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataObject.Station <em>Station</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Station</em>'.
	 * @see scrm.requirements.dataObject.Station
	 * @generated
	 */
	EClass getStation();

	/**
	 * Returns the meta object for class '{@link scrm.requirements.dataObject.ControlParameter <em>Control Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Parameter</em>'.
	 * @see scrm.requirements.dataObject.ControlParameter
	 * @generated
	 */
	EClass getControlParameter();

	/**
	 * Returns the meta object for the reference '{@link scrm.requirements.dataObject.ControlParameter#getControlledProcess <em>Controlled Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Controlled Process</em>'.
	 * @see scrm.requirements.dataObject.ControlParameter#getControlledProcess()
	 * @see #getControlParameter()
	 * @generated
	 */
	EReference getControlParameter_ControlledProcess();

	/**
	 * Returns the meta object for the attribute '{@link scrm.requirements.dataObject.ControlParameter#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see scrm.requirements.dataObject.ControlParameter#getFormat()
	 * @see #getControlParameter()
	 * @generated
	 */
	EAttribute getControlParameter_Format();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DataObjectFactory getDataObjectFactory();

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
		 * The meta object literal for the '{@link scrm.requirements.dataObject.impl.DataDefinitionImpl <em>Data Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataObject.impl.DataDefinitionImpl
		 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getDataDefinition()
		 * @generated
		 */
		EClass DATA_DEFINITION = eINSTANCE.getDataDefinition();

		/**
		 * The meta object literal for the '<em><b>Defined Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DEFINITION__DEFINED_REQUIREMENT = eINSTANCE
				.getDataDefinition_DefinedRequirement();

		/**
		 * The meta object literal for the '<em><b>Accuracy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DEFINITION__ACCURACY = eINSTANCE
				.getDataDefinition_Accuracy();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DEFINITION__RANGE = eINSTANCE.getDataDefinition_Range();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DEFINITION__FORMAT = eINSTANCE
				.getDataDefinition_Format();

		/**
		 * The meta object literal for the '<em><b>Provided Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DEFINITION__PROVIDED_INTERFACE = eINSTANCE
				.getDataDefinition_ProvidedInterface();

		/**
		 * The meta object literal for the '<em><b>Required Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DEFINITION__REQUIRED_INTERFACE = eINSTANCE
				.getDataDefinition_RequiredInterface();

		/**
		 * The meta object literal for the '<em><b>Described Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DEFINITION__DESCRIBED_MODEL = eINSTANCE
				.getDataDefinition_DescribedModel();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataObject.impl.SeismicSourceImpl <em>Seismic Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataObject.impl.SeismicSourceImpl
		 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getSeismicSource()
		 * @generated
		 */
		EClass SEISMIC_SOURCE = eINSTANCE.getSeismicSource();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataObject.impl.ComputationalMeshImpl <em>Computational Mesh</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataObject.impl.ComputationalMeshImpl
		 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getComputationalMesh()
		 * @generated
		 */
		EClass COMPUTATIONAL_MESH = eINSTANCE.getComputationalMesh();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataObject.impl.SyntheticSeismogramImpl <em>Synthetic Seismogram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataObject.impl.SyntheticSeismogramImpl
		 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getSyntheticSeismogram()
		 * @generated
		 */
		EClass SYNTHETIC_SEISMOGRAM = eINSTANCE.getSyntheticSeismogram();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataObject.impl.StationImpl <em>Station</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataObject.impl.StationImpl
		 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getStation()
		 * @generated
		 */
		EClass STATION = eINSTANCE.getStation();

		/**
		 * The meta object literal for the '{@link scrm.requirements.dataObject.impl.ControlParameterImpl <em>Control Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.requirements.dataObject.impl.ControlParameterImpl
		 * @see scrm.requirements.dataObject.impl.DataObjectPackageImpl#getControlParameter()
		 * @generated
		 */
		EClass CONTROL_PARAMETER = eINSTANCE.getControlParameter();

		/**
		 * The meta object literal for the '<em><b>Controlled Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_PARAMETER__CONTROLLED_PROCESS = eINSTANCE
				.getControlParameter_ControlledProcess();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_PARAMETER__FORMAT = eINSTANCE
				.getControlParameter_Format();

	}

} //DataObjectPackage
