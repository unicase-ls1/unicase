/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

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
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS = ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Knowledge Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scientific Knowledge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.ScientificProblemImpl <em>Scientific Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.ScientificProblemImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificProblem()
	 * @generated
	 */
	int SCIENTIFIC_PROBLEM = 2;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.MathematicalModelImpl <em>Mathematical Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.MathematicalModelImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getMathematicalModel()
	 * @generated
	 */
	int MATHEMATICAL_MODEL = 3;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.NumericalMethodImpl <em>Numerical Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.NumericalMethodImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getNumericalMethod()
	 * @generated
	 */
	int NUMERICAL_METHOD = 4;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.AssumptionImpl <em>Assumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.AssumptionImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getAssumption()
	 * @generated
	 */
	int ASSUMPTION = 5;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.KnowledgeSpaceImpl <em>Space</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.KnowledgeSpaceImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getKnowledgeSpace()
	 * @generated
	 */
	int KNOWLEDGE_SPACE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_SPACE__NAME = ScrmPackage.SCRM_SPACE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_SPACE__DESCRIPTION = ScrmPackage.SCRM_SPACE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_SPACE__DISPLAYING_DIAGRAMS = ScrmPackage.SCRM_SPACE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Representing Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_SPACE__REPRESENTING_DIAGRAM = ScrmPackage.SCRM_SPACE__REPRESENTING_DIAGRAM;

	/**
	 * The feature id for the '<em><b>Containing Knowledge Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_SPACE__CONTAINING_KNOWLEDGE_SPACE = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Contained Scientific Knowledge</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Space</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOWLEDGE_SPACE_FEATURE_COUNT = ScrmPackage.SCRM_SPACE_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Knowledge Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__CONTAINING_KNOWLEDGE_SPACE = SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Knowledge Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE = SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE;

	/**
	 * The feature id for the '<em><b>Represented Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__REPRESENTED_PROBLEM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__REFINEMENTS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refined Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__REFINED_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Used In Numerical Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__USED_IN_NUMERICAL_METHODS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__DEPENDENCIES = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Involved Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__INVOLVED_DATA = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mathematical Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Knowledge Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__CONTAINING_KNOWLEDGE_SPACE = SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE;

	/**
	 * The feature id for the '<em><b>Solved Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__SOLVED_PROBLEM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__DEPENDENCIES = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Realizing Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__REALIZING_REQUIREMENT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Using Mathematical Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__USING_MATHEMATICAL_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Performance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__PERFORMANCE = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__ALGORITHM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Numerical Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 6;

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
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Knowledge Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__CONTAINING_KNOWLEDGE_SPACE = SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE;

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
	 * The meta object id for the '{@link scrm.knowledge.impl.GeophysicalModelImpl <em>Geophysical Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.GeophysicalModelImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getGeophysicalModel()
	 * @generated
	 */
	int GEOPHYSICAL_MODEL = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__NAME = MATHEMATICAL_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__DESCRIPTION = MATHEMATICAL_MODEL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__DISPLAYING_DIAGRAMS = MATHEMATICAL_MODEL__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Containing Knowledge Space</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE = MATHEMATICAL_MODEL__CONTAINING_KNOWLEDGE_SPACE;

	/**
	 * The feature id for the '<em><b>Represented Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM = MATHEMATICAL_MODEL__REPRESENTED_PROBLEM;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__REFINEMENTS = MATHEMATICAL_MODEL__REFINEMENTS;

	/**
	 * The feature id for the '<em><b>Refined Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__REFINED_MODEL = MATHEMATICAL_MODEL__REFINED_MODEL;

	/**
	 * The feature id for the '<em><b>Used In Numerical Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS = MATHEMATICAL_MODEL__USED_IN_NUMERICAL_METHODS;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__DEPENDENCIES = MATHEMATICAL_MODEL__DEPENDENCIES;

	/**
	 * The feature id for the '<em><b>Involved Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL__INVOLVED_DATA = MATHEMATICAL_MODEL__INVOLVED_DATA;

	/**
	 * The number of structural features of the '<em>Geophysical Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEOPHYSICAL_MODEL_FEATURE_COUNT = MATHEMATICAL_MODEL_FEATURE_COUNT + 0;

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
	 * Returns the meta object for the container reference '{@link scrm.knowledge.ScientificKnowledge#getContainingKnowledgeSpace <em>Containing Knowledge Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Knowledge Space</em>'.
	 * @see scrm.knowledge.ScientificKnowledge#getContainingKnowledgeSpace()
	 * @see #getScientificKnowledge()
	 * @generated
	 */
	EReference getScientificKnowledge_ContainingKnowledgeSpace();

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
	 * Returns the meta object for class '{@link scrm.knowledge.MathematicalModel <em>Mathematical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mathematical Model</em>'.
	 * @see scrm.knowledge.MathematicalModel
	 * @generated
	 */
	EClass getMathematicalModel();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.MathematicalModel#getRepresentedProblem <em>Represented Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Represented Problem</em>'.
	 * @see scrm.knowledge.MathematicalModel#getRepresentedProblem()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_RepresentedProblem();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.knowledge.MathematicalModel#getRefinements <em>Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refinements</em>'.
	 * @see scrm.knowledge.MathematicalModel#getRefinements()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_Refinements();

	/**
	 * Returns the meta object for the container reference '{@link scrm.knowledge.MathematicalModel#getRefinedModel <em>Refined Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Refined Model</em>'.
	 * @see scrm.knowledge.MathematicalModel#getRefinedModel()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_RefinedModel();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.MathematicalModel#getUsedInNumericalMethods <em>Used In Numerical Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used In Numerical Methods</em>'.
	 * @see scrm.knowledge.MathematicalModel#getUsedInNumericalMethods()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_UsedInNumericalMethods();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.MathematicalModel#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see scrm.knowledge.MathematicalModel#getDependencies()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_Dependencies();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.MathematicalModel#getInvolvedData <em>Involved Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Involved Data</em>'.
	 * @see scrm.knowledge.MathematicalModel#getInvolvedData()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_InvolvedData();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.NumericalMethod <em>Numerical Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical Method</em>'.
	 * @see scrm.knowledge.NumericalMethod
	 * @generated
	 */
	EClass getNumericalMethod();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getSolvedProblem <em>Solved Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Solved Problem</em>'.
	 * @see scrm.knowledge.NumericalMethod#getSolvedProblem()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_SolvedProblem();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.NumericalMethod#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see scrm.knowledge.NumericalMethod#getDependencies()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_Dependencies();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getRealizingRequirement <em>Realizing Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Realizing Requirement</em>'.
	 * @see scrm.knowledge.NumericalMethod#getRealizingRequirement()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_RealizingRequirement();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getUsingMathematicalModel <em>Using Mathematical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Using Mathematical Model</em>'.
	 * @see scrm.knowledge.NumericalMethod#getUsingMathematicalModel()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_UsingMathematicalModel();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getPerformance <em>Performance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Performance</em>'.
	 * @see scrm.knowledge.NumericalMethod#getPerformance()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_Performance();

	/**
	 * Returns the meta object for the attribute '{@link scrm.knowledge.NumericalMethod#getAlgorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm</em>'.
	 * @see scrm.knowledge.NumericalMethod#getAlgorithm()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EAttribute getNumericalMethod_Algorithm();

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
	 * Returns the meta object for class '{@link scrm.knowledge.GeophysicalModel <em>Geophysical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Geophysical Model</em>'.
	 * @see scrm.knowledge.GeophysicalModel
	 * @generated
	 */
	EClass getGeophysicalModel();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.KnowledgeSpace <em>Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Space</em>'.
	 * @see scrm.knowledge.KnowledgeSpace
	 * @generated
	 */
	EClass getKnowledgeSpace();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.knowledge.KnowledgeSpace#getContainedScientificKnowledge <em>Contained Scientific Knowledge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Scientific Knowledge</em>'.
	 * @see scrm.knowledge.KnowledgeSpace#getContainedScientificKnowledge()
	 * @see #getKnowledgeSpace()
	 * @generated
	 */
	EReference getKnowledgeSpace_ContainedScientificKnowledge();

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
		 * The meta object literal for the '<em><b>Containing Knowledge Space</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_KNOWLEDGE__CONTAINING_KNOWLEDGE_SPACE = eINSTANCE
				.getScientificKnowledge_ContainingKnowledgeSpace();

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
		 * The meta object literal for the '{@link scrm.knowledge.impl.MathematicalModelImpl <em>Mathematical Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.MathematicalModelImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getMathematicalModel()
		 * @generated
		 */
		EClass MATHEMATICAL_MODEL = eINSTANCE.getMathematicalModel();

		/**
		 * The meta object literal for the '<em><b>Represented Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__REPRESENTED_PROBLEM = eINSTANCE
				.getMathematicalModel_RepresentedProblem();

		/**
		 * The meta object literal for the '<em><b>Refinements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__REFINEMENTS = eINSTANCE
				.getMathematicalModel_Refinements();

		/**
		 * The meta object literal for the '<em><b>Refined Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__REFINED_MODEL = eINSTANCE
				.getMathematicalModel_RefinedModel();

		/**
		 * The meta object literal for the '<em><b>Used In Numerical Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__USED_IN_NUMERICAL_METHODS = eINSTANCE
				.getMathematicalModel_UsedInNumericalMethods();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__DEPENDENCIES = eINSTANCE
				.getMathematicalModel_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Involved Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__INVOLVED_DATA = eINSTANCE
				.getMathematicalModel_InvolvedData();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.NumericalMethodImpl <em>Numerical Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.NumericalMethodImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getNumericalMethod()
		 * @generated
		 */
		EClass NUMERICAL_METHOD = eINSTANCE.getNumericalMethod();

		/**
		 * The meta object literal for the '<em><b>Solved Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__SOLVED_PROBLEM = eINSTANCE
				.getNumericalMethod_SolvedProblem();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__DEPENDENCIES = eINSTANCE
				.getNumericalMethod_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Realizing Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__REALIZING_REQUIREMENT = eINSTANCE
				.getNumericalMethod_RealizingRequirement();

		/**
		 * The meta object literal for the '<em><b>Using Mathematical Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__USING_MATHEMATICAL_MODEL = eINSTANCE
				.getNumericalMethod_UsingMathematicalModel();

		/**
		 * The meta object literal for the '<em><b>Performance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__PERFORMANCE = eINSTANCE
				.getNumericalMethod_Performance();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERICAL_METHOD__ALGORITHM = eINSTANCE
				.getNumericalMethod_Algorithm();

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

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.GeophysicalModelImpl <em>Geophysical Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.GeophysicalModelImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getGeophysicalModel()
		 * @generated
		 */
		EClass GEOPHYSICAL_MODEL = eINSTANCE.getGeophysicalModel();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.KnowledgeSpaceImpl <em>Space</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.KnowledgeSpaceImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getKnowledgeSpace()
		 * @generated
		 */
		EClass KNOWLEDGE_SPACE = eINSTANCE.getKnowledgeSpace();

		/**
		 * The meta object literal for the '<em><b>Contained Scientific Knowledge</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNOWLEDGE_SPACE__CONTAINED_SCIENTIFIC_KNOWLEDGE = eINSTANCE
				.getKnowledgeSpace_ContainedScientificKnowledge();

	}

} //KnowledgePackage
