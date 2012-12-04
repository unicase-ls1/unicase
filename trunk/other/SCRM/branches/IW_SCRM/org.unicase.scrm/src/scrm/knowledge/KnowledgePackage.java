/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

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
 * @see scrm.knowledge.KnowledgeFactory
 * @model kind="package"
 * @generated
 */
public interface KnowledgePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "knowledge";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/scrm/knowledge";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.scrm.knowledge";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KnowledgePackage eINSTANCE = scrm.knowledge.impl.KnowledgePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link scrm.knowledge.ScientificKnowledge <em>Scientific Knowledge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.ScientificKnowledge
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificKnowledge()
	 * @generated
	 */
	int SCIENTIFIC_KNOWLEDGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__NAME = ScrmPackage.SCRM_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__DESCRIPTION = ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__ANNOTATIONS = ScrmPackage.SCRM_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__ATTACHMENTS = ScrmPackage.SCRM_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES = ScrmPackage.SCRM_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__LEAF_SECTION = ScrmPackage.SCRM_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__STATE = ScrmPackage.SCRM_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__COMMENTS = ScrmPackage.SCRM_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__CREATION_DATE = ScrmPackage.SCRM_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__CREATOR = ScrmPackage.SCRM_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS = ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The number of structural features of the '<em>Scientific Knowledge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.ScientificProblemImpl <em>Scientific Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.ScientificProblemImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificProblem()
	 * @generated
	 */
	int SCIENTIFIC_PROBLEM = 1;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.AssumptionImpl <em>Assumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.AssumptionImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getAssumption()
	 * @generated
	 */
	int ASSUMPTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__ANNOTATIONS = SCIENTIFIC_KNOWLEDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__ATTACHMENTS = SCIENTIFIC_KNOWLEDGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__INCOMING_DOCUMENT_REFERENCES = SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__LEAF_SECTION = SCIENTIFIC_KNOWLEDGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__STATE = SCIENTIFIC_KNOWLEDGE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__COMMENTS = SCIENTIFIC_KNOWLEDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__CREATION_DATE = SCIENTIFIC_KNOWLEDGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__CREATOR = SCIENTIFIC_KNOWLEDGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Representing Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__REPRESENTING_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Solving Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__SOLVING_METHODS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Influenced Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Scientific Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.ModelImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ANNOTATIONS = SCIENTIFIC_KNOWLEDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ATTACHMENTS = SCIENTIFIC_KNOWLEDGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__INCOMING_DOCUMENT_REFERENCES = SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__LEAF_SECTION = SCIENTIFIC_KNOWLEDGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__STATE = SCIENTIFIC_KNOWLEDGE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__COMMENTS = SCIENTIFIC_KNOWLEDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CREATION_DATE = SCIENTIFIC_KNOWLEDGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__CREATOR = SCIENTIFIC_KNOWLEDGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Represented Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__REPRESENTED_PROBLEM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__REFINEMENTS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refined Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__REFINED_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Used In Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__USED_IN_METHODS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__DEPENDENCIES = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Involved Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__INVOLVED_DATA = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.MethodImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ANNOTATIONS = SCIENTIFIC_KNOWLEDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ATTACHMENTS = SCIENTIFIC_KNOWLEDGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__INCOMING_DOCUMENT_REFERENCES = SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__LEAF_SECTION = SCIENTIFIC_KNOWLEDGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__STATE = SCIENTIFIC_KNOWLEDGE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__COMMENTS = SCIENTIFIC_KNOWLEDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__CREATION_DATE = SCIENTIFIC_KNOWLEDGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__CREATOR = SCIENTIFIC_KNOWLEDGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Solved Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__SOLVED_PROBLEM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__DEPENDENCIES = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Realizing Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__REALIZING_REQUIREMENT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Using Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__USING_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Performance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__PERFORMANCE = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__ANNOTATIONS = SCIENTIFIC_KNOWLEDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__ATTACHMENTS = SCIENTIFIC_KNOWLEDGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__INCOMING_DOCUMENT_REFERENCES = SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__LEAF_SECTION = SCIENTIFIC_KNOWLEDGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__STATE = SCIENTIFIC_KNOWLEDGE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__COMMENTS = SCIENTIFIC_KNOWLEDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__CREATION_DATE = SCIENTIFIC_KNOWLEDGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__CREATOR = SCIENTIFIC_KNOWLEDGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Depending Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DEPENDING_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Depending Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DEPENDING_METHOD = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.ScientificKnowledge <em>Scientific Knowledge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scientific Knowledge</em>'.
	 * @see scrm.knowledge.ScientificKnowledge
	 * @generated
	 */
	EClass getScientificKnowledge();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.ScientificProblem <em>Scientific Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scientific Problem</em>'.
	 * @see scrm.knowledge.ScientificProblem
	 * @generated
	 */
	EClass getScientificProblem();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.ScientificProblem#getRepresentingModel <em>Representing Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Representing Model</em>'.
	 * @see scrm.knowledge.ScientificProblem#getRepresentingModel()
	 * @see #getScientificProblem()
	 * @generated
	 */
	EReference getScientificProblem_RepresentingModel();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.ScientificProblem#getSolvingMethods <em>Solving Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Solving Methods</em>'.
	 * @see scrm.knowledge.ScientificProblem#getSolvingMethods()
	 * @see #getScientificProblem()
	 * @generated
	 */
	EReference getScientificProblem_SolvingMethods();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.ScientificProblem#getInfluencedFeature <em>Influenced Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Influenced Feature</em>'.
	 * @see scrm.knowledge.ScientificProblem#getInfluencedFeature()
	 * @see #getScientificProblem()
	 * @generated
	 */
	EReference getScientificProblem_InfluencedFeature();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see scrm.knowledge.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Model#getRepresentedProblem <em>Represented Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Represented Problem</em>'.
	 * @see scrm.knowledge.Model#getRepresentedProblem()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_RepresentedProblem();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.knowledge.Model#getRefinements <em>Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refinements</em>'.
	 * @see scrm.knowledge.Model#getRefinements()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Refinements();

	/**
	 * Returns the meta object for the container reference '{@link scrm.knowledge.Model#getRefinedModel <em>Refined Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Refined Model</em>'.
	 * @see scrm.knowledge.Model#getRefinedModel()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_RefinedModel();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.Model#getUsedInMethods <em>Used In Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used In Methods</em>'.
	 * @see scrm.knowledge.Model#getUsedInMethods()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_UsedInMethods();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.Model#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see scrm.knowledge.Model#getDependencies()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_Dependencies();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.Model#getInvolvedData <em>Involved Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Involved Data</em>'.
	 * @see scrm.knowledge.Model#getInvolvedData()
	 * @see #getModel()
	 * @generated
	 */
	EReference getModel_InvolvedData();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see scrm.knowledge.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Method#getSolvedProblem <em>Solved Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Solved Problem</em>'.
	 * @see scrm.knowledge.Method#getSolvedProblem()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_SolvedProblem();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.Method#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see scrm.knowledge.Method#getDependencies()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Dependencies();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Method#getRealizingRequirement <em>Realizing Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Realizing Requirement</em>'.
	 * @see scrm.knowledge.Method#getRealizingRequirement()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_RealizingRequirement();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Method#getUsingModel <em>Using Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Using Model</em>'.
	 * @see scrm.knowledge.Method#getUsingModel()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_UsingModel();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Method#getPerformance <em>Performance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Performance</em>'.
	 * @see scrm.knowledge.Method#getPerformance()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Performance();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assumption</em>'.
	 * @see scrm.knowledge.Assumption
	 * @generated
	 */
	EClass getAssumption();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Assumption#getDependingModel <em>Depending Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depending Model</em>'.
	 * @see scrm.knowledge.Assumption#getDependingModel()
	 * @see #getAssumption()
	 * @generated
	 */
	EReference getAssumption_DependingModel();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Assumption#getDependingMethod <em>Depending Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depending Method</em>'.
	 * @see scrm.knowledge.Assumption#getDependingMethod()
	 * @see #getAssumption()
	 * @generated
	 */
	EReference getAssumption_DependingMethod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KnowledgeFactory getKnowledgeFactory();

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
		 * The meta object literal for the '{@link scrm.knowledge.ScientificKnowledge <em>Scientific Knowledge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.ScientificKnowledge
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificKnowledge()
		 * @generated
		 */
		EClass SCIENTIFIC_KNOWLEDGE = eINSTANCE.getScientificKnowledge();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.ScientificProblemImpl <em>Scientific Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.ScientificProblemImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificProblem()
		 * @generated
		 */
		EClass SCIENTIFIC_PROBLEM = eINSTANCE.getScientificProblem();

		/**
		 * The meta object literal for the '<em><b>Representing Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__REPRESENTING_MODEL = eINSTANCE
				.getScientificProblem_RepresentingModel();

		/**
		 * The meta object literal for the '<em><b>Solving Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__SOLVING_METHODS = eINSTANCE
				.getScientificProblem_SolvingMethods();

		/**
		 * The meta object literal for the '<em><b>Influenced Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE = eINSTANCE
				.getScientificProblem_InfluencedFeature();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.ModelImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Represented Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__REPRESENTED_PROBLEM = eINSTANCE
				.getModel_RepresentedProblem();

		/**
		 * The meta object literal for the '<em><b>Refinements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__REFINEMENTS = eINSTANCE.getModel_Refinements();

		/**
		 * The meta object literal for the '<em><b>Refined Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__REFINED_MODEL = eINSTANCE.getModel_RefinedModel();

		/**
		 * The meta object literal for the '<em><b>Used In Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__USED_IN_METHODS = eINSTANCE.getModel_UsedInMethods();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__DEPENDENCIES = eINSTANCE.getModel_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Involved Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL__INVOLVED_DATA = eINSTANCE.getModel_InvolvedData();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.MethodImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Solved Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__SOLVED_PROBLEM = eINSTANCE.getMethod_SolvedProblem();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__DEPENDENCIES = eINSTANCE.getMethod_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Realizing Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__REALIZING_REQUIREMENT = eINSTANCE
				.getMethod_RealizingRequirement();

		/**
		 * The meta object literal for the '<em><b>Using Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__USING_MODEL = eINSTANCE.getMethod_UsingModel();

		/**
		 * The meta object literal for the '<em><b>Performance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__PERFORMANCE = eINSTANCE.getMethod_Performance();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.AssumptionImpl <em>Assumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.AssumptionImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getAssumption()
		 * @generated
		 */
		EClass ASSUMPTION = eINSTANCE.getAssumption();

		/**
		 * The meta object literal for the '<em><b>Depending Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSUMPTION__DEPENDING_MODEL = eINSTANCE
				.getAssumption_DependingModel();

		/**
		 * The meta object literal for the '<em><b>Depending Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSUMPTION__DEPENDING_METHOD = eINSTANCE
				.getAssumption_DependingMethod();

	}

} //KnowledgePackage
