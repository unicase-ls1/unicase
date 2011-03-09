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
	KnowledgePackage eINSTANCE = scrm.knowledge.impl.KnowledgePackageImpl.init();

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
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__IDENTIFIER = ScrmPackage.SCRM_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__REQUIREMENTS = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

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
	int SCIENTIFIC_PROBLEM = 1;

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
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__IDENTIFIER = SCIENTIFIC_KNOWLEDGE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__REQUIREMENTS = SCIENTIFIC_KNOWLEDGE__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Representing Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__REPRESENTING_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Solving Method</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__SOLVING_METHOD = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link scrm.knowledge.impl.MathematicalModelImpl <em>Mathematical Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.MathematicalModelImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getMathematicalModel()
	 * @generated
	 */
	int MATHEMATICAL_MODEL = 2;

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
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__IDENTIFIER = SCIENTIFIC_KNOWLEDGE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__REQUIREMENTS = SCIENTIFIC_KNOWLEDGE__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Represented Problem</b></em>' container reference.
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
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__DEPENDENCIES = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Theory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__THEORY = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Mathematical Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sub Mathematical Model</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Containing Mathematical Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__CONTAINING_MATHEMATICAL_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Numerical Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL__NUMERICAL_METHODS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Mathematical Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_MODEL_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.NumericalMethodImpl <em>Numerical Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.NumericalMethodImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getNumericalMethod()
	 * @generated
	 */
	int NUMERICAL_METHOD = 3;

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
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__IDENTIFIER = SCIENTIFIC_KNOWLEDGE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__REQUIREMENTS = SCIENTIFIC_KNOWLEDGE__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Solved Problem</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__SOLVED_PROBLEM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
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
	 * The feature id for the '<em><b>Mathematical Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__MATHEMATICAL_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Theory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__THEORY = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__ALGORITHM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Performance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__PERFORMANCE = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Numerical Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 7;

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
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__IDENTIFIER = SCIENTIFIC_KNOWLEDGE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__REQUIREMENTS = SCIENTIFIC_KNOWLEDGE__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Depending Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DEPENDING_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Depending Method</b></em>' container reference.
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
	 * Returns the meta object for the reference list '{@link scrm.knowledge.ScientificKnowledge#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requirements</em>'.
	 * @see scrm.knowledge.ScientificKnowledge#getRequirements()
	 * @see #getScientificKnowledge()
	 * @generated
	 */
	EReference getScientificKnowledge_Requirements();

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
	 * Returns the meta object for the containment reference '{@link scrm.knowledge.ScientificProblem#getRepresentingModel <em>Representing Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Representing Model</em>'.
	 * @see scrm.knowledge.ScientificProblem#getRepresentingModel()
	 * @see #getScientificProblem()
	 * @generated
	 */
	EReference getScientificProblem_RepresentingModel();

	/**
	 * Returns the meta object for the containment reference '{@link scrm.knowledge.ScientificProblem#getSolvingMethod <em>Solving Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Solving Method</em>'.
	 * @see scrm.knowledge.ScientificProblem#getSolvingMethod()
	 * @see #getScientificProblem()
	 * @generated
	 */
	EReference getScientificProblem_SolvingMethod();

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
	 * Returns the meta object for the container reference '{@link scrm.knowledge.MathematicalModel#getRepresentedProblem <em>Represented Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Represented Problem</em>'.
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
	 * Returns the meta object for the containment reference list '{@link scrm.knowledge.MathematicalModel#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see scrm.knowledge.MathematicalModel#getDependencies()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_Dependencies();

	/**
	 * Returns the meta object for the attribute '{@link scrm.knowledge.MathematicalModel#getTheory <em>Theory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Theory</em>'.
	 * @see scrm.knowledge.MathematicalModel#getTheory()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EAttribute getMathematicalModel_Theory();

	/**
	 * Returns the meta object for the attribute '{@link scrm.knowledge.MathematicalModel#getMathematicalExpression <em>Mathematical Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mathematical Expression</em>'.
	 * @see scrm.knowledge.MathematicalModel#getMathematicalExpression()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EAttribute getMathematicalModel_MathematicalExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.knowledge.MathematicalModel#getSubMathematicalModel <em>Sub Mathematical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Mathematical Model</em>'.
	 * @see scrm.knowledge.MathematicalModel#getSubMathematicalModel()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_SubMathematicalModel();

	/**
	 * Returns the meta object for the container reference '{@link scrm.knowledge.MathematicalModel#getContainingMathematicalModel <em>Containing Mathematical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Containing Mathematical Model</em>'.
	 * @see scrm.knowledge.MathematicalModel#getContainingMathematicalModel()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_ContainingMathematicalModel();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.MathematicalModel#getNumericalMethods <em>Numerical Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Numerical Methods</em>'.
	 * @see scrm.knowledge.MathematicalModel#getNumericalMethods()
	 * @see #getMathematicalModel()
	 * @generated
	 */
	EReference getMathematicalModel_NumericalMethods();

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
	 * Returns the meta object for the container reference '{@link scrm.knowledge.NumericalMethod#getSolvedProblem <em>Solved Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Solved Problem</em>'.
	 * @see scrm.knowledge.NumericalMethod#getSolvedProblem()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_SolvedProblem();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.knowledge.NumericalMethod#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
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
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getMathematicalModel <em>Mathematical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mathematical Model</em>'.
	 * @see scrm.knowledge.NumericalMethod#getMathematicalModel()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_MathematicalModel();

	/**
	 * Returns the meta object for the attribute '{@link scrm.knowledge.NumericalMethod#getTheory <em>Theory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Theory</em>'.
	 * @see scrm.knowledge.NumericalMethod#getTheory()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EAttribute getNumericalMethod_Theory();

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
	 * Returns the meta object for class '{@link scrm.knowledge.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assumption</em>'.
	 * @see scrm.knowledge.Assumption
	 * @generated
	 */
	EClass getAssumption();

	/**
	 * Returns the meta object for the container reference '{@link scrm.knowledge.Assumption#getDependingModel <em>Depending Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Depending Model</em>'.
	 * @see scrm.knowledge.Assumption#getDependingModel()
	 * @see #getAssumption()
	 * @generated
	 */
	EReference getAssumption_DependingModel();

	/**
	 * Returns the meta object for the container reference '{@link scrm.knowledge.Assumption#getDependingMethod <em>Depending Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Depending Method</em>'.
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
		 * The meta object literal for the '<em><b>Requirements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_KNOWLEDGE__REQUIREMENTS = eINSTANCE.getScientificKnowledge_Requirements();

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
		 * The meta object literal for the '<em><b>Representing Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__REPRESENTING_MODEL = eINSTANCE.getScientificProblem_RepresentingModel();

		/**
		 * The meta object literal for the '<em><b>Solving Method</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__SOLVING_METHOD = eINSTANCE.getScientificProblem_SolvingMethod();

		/**
		 * The meta object literal for the '<em><b>Influenced Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE = eINSTANCE.getScientificProblem_InfluencedFeature();

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
		 * The meta object literal for the '<em><b>Represented Problem</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__REPRESENTED_PROBLEM = eINSTANCE.getMathematicalModel_RepresentedProblem();

		/**
		 * The meta object literal for the '<em><b>Refinements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__REFINEMENTS = eINSTANCE.getMathematicalModel_Refinements();

		/**
		 * The meta object literal for the '<em><b>Refined Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__REFINED_MODEL = eINSTANCE.getMathematicalModel_RefinedModel();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__DEPENDENCIES = eINSTANCE.getMathematicalModel_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Theory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATHEMATICAL_MODEL__THEORY = eINSTANCE.getMathematicalModel_Theory();

		/**
		 * The meta object literal for the '<em><b>Mathematical Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATHEMATICAL_MODEL__MATHEMATICAL_EXPRESSION = eINSTANCE.getMathematicalModel_MathematicalExpression();

		/**
		 * The meta object literal for the '<em><b>Sub Mathematical Model</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__SUB_MATHEMATICAL_MODEL = eINSTANCE.getMathematicalModel_SubMathematicalModel();

		/**
		 * The meta object literal for the '<em><b>Containing Mathematical Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__CONTAINING_MATHEMATICAL_MODEL = eINSTANCE.getMathematicalModel_ContainingMathematicalModel();

		/**
		 * The meta object literal for the '<em><b>Numerical Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_MODEL__NUMERICAL_METHODS = eINSTANCE.getMathematicalModel_NumericalMethods();

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
		 * The meta object literal for the '<em><b>Solved Problem</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__SOLVED_PROBLEM = eINSTANCE.getNumericalMethod_SolvedProblem();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__DEPENDENCIES = eINSTANCE.getNumericalMethod_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Realizing Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__REALIZING_REQUIREMENT = eINSTANCE.getNumericalMethod_RealizingRequirement();

		/**
		 * The meta object literal for the '<em><b>Mathematical Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__MATHEMATICAL_MODEL = eINSTANCE.getNumericalMethod_MathematicalModel();

		/**
		 * The meta object literal for the '<em><b>Theory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERICAL_METHOD__THEORY = eINSTANCE.getNumericalMethod_Theory();

		/**
		 * The meta object literal for the '<em><b>Algorithm</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERICAL_METHOD__ALGORITHM = eINSTANCE.getNumericalMethod_Algorithm();

		/**
		 * The meta object literal for the '<em><b>Performance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__PERFORMANCE = eINSTANCE.getNumericalMethod_Performance();

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
		 * The meta object literal for the '<em><b>Depending Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSUMPTION__DEPENDING_MODEL = eINSTANCE.getAssumption_DependingModel();

		/**
		 * The meta object literal for the '<em><b>Depending Method</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSUMPTION__DEPENDING_METHOD = eINSTANCE.getAssumption_DependingMethod();

	}

} //KnowledgePackage
