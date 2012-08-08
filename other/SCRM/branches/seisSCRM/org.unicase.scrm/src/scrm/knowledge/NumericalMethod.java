/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.common.util.EList;

import scrm.requirements.Performance;
import scrm.requirements.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.knowledge.NumericalMethod#getSolvedProblem <em>Solved Problem</em>}</li>
 *   <li>{@link scrm.knowledge.NumericalMethod#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.NumericalMethod#getRealizingRequirement <em>Realizing Requirement</em>}</li>
 *   <li>{@link scrm.knowledge.NumericalMethod#getUsingMathematicalModel <em>Using Mathematical Model</em>}</li>
 *   <li>{@link scrm.knowledge.NumericalMethod#getPerformance <em>Performance</em>}</li>
 *   <li>{@link scrm.knowledge.NumericalMethod#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod()
 * @model
 * @generated
 */
public interface NumericalMethod extends ScientificKnowledge {
	/**
	 * Returns the value of the '<em><b>Solved Problem</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.ScientificProblem#getSolvingMethods <em>Solving Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solved Problem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solved Problem</em>' reference.
	 * @see #setSolvedProblem(ScientificProblem)
	 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod_SolvedProblem()
	 * @see scrm.knowledge.ScientificProblem#getSolvingMethods
	 * @model opposite="solvingMethods"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	ScientificProblem getSolvedProblem();

	/**
	 * Sets the value of the '{@link scrm.knowledge.NumericalMethod#getSolvedProblem <em>Solved Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solved Problem</em>' reference.
	 * @see #getSolvedProblem()
	 * @generated
	 */
	void setSolvedProblem(ScientificProblem value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
	 * The list contents are of type {@link scrm.knowledge.Assumption}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Assumption#getDependingMethod <em>Depending Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' reference list.
	 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod_Dependencies()
	 * @see scrm.knowledge.Assumption#getDependingMethod
	 * @model opposite="dependingMethod"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='10'"
	 * @generated
	 */
	EList<Assumption> getDependencies();

	/**
	 * Returns the value of the '<em><b>Realizing Requirement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Requirement#getRealizedMethod <em>Realized Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realizing Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realizing Requirement</em>' reference.
	 * @see #setRealizingRequirement(Requirement)
	 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod_RealizingRequirement()
	 * @see scrm.requirements.Requirement#getRealizedMethod
	 * @model opposite="realizedMethod"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='25'"
	 * @generated
	 */
	Requirement getRealizingRequirement();

	/**
	 * Sets the value of the '{@link scrm.knowledge.NumericalMethod#getRealizingRequirement <em>Realizing Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realizing Requirement</em>' reference.
	 * @see #getRealizingRequirement()
	 * @generated
	 */
	void setRealizingRequirement(Requirement value);

	/**
	 * Returns the value of the '<em><b>Using Mathematical Model</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.MathematicalModel#getUsedInNumericalMethods <em>Used In Numerical Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using Mathematical Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Using Mathematical Model</em>' reference.
	 * @see #setUsingMathematicalModel(MathematicalModel)
	 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod_UsingMathematicalModel()
	 * @see scrm.knowledge.MathematicalModel#getUsedInNumericalMethods
	 * @model opposite="usedInNumericalMethods"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='20'"
	 * @generated
	 */
	MathematicalModel getUsingMathematicalModel();

	/**
	 * Sets the value of the '{@link scrm.knowledge.NumericalMethod#getUsingMathematicalModel <em>Using Mathematical Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Using Mathematical Model</em>' reference.
	 * @see #getUsingMathematicalModel()
	 * @generated
	 */
	void setUsingMathematicalModel(MathematicalModel value);

	/**
	 * Returns the value of the '<em><b>Performance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Performance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Performance</em>' reference.
	 * @see #setPerformance(Performance)
	 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod_Performance()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='30'"
	 * @generated
	 */
	Performance getPerformance();

	/**
	 * Sets the value of the '{@link scrm.knowledge.NumericalMethod#getPerformance <em>Performance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Performance</em>' reference.
	 * @see #getPerformance()
	 * @generated
	 */
	void setPerformance(Performance value);

	/**
	 * Returns the value of the '<em><b>Algorithm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm</em>' attribute.
	 * @see #setAlgorithm(String)
	 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod_Algorithm()
	 * @model annotation="org.unicase.ui.meeditor position='left' priority='7'"
	 * @generated
	 */
	String getAlgorithm();

	/**
	 * Sets the value of the '{@link scrm.knowledge.NumericalMethod#getAlgorithm <em>Algorithm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm</em>' attribute.
	 * @see #getAlgorithm()
	 * @generated
	 */
	void setAlgorithm(String value);

} // NumericalMethod
