/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.common.util.EList;

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
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod()
 * @model
 * @generated
 */
public interface NumericalMethod extends ScientificKnowledge {
	/**
	 * Returns the value of the '<em><b>Solved Problem</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.ScientificProblem#getSolvingMethod <em>Solving Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solved Problem</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solved Problem</em>' container reference.
	 * @see #setSolvedProblem(ScientificProblem)
	 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod_SolvedProblem()
	 * @see scrm.knowledge.ScientificProblem#getSolvingMethod
	 * @model opposite="solvingMethod" transient="false"
	 * @generated
	 */
	ScientificProblem getSolvedProblem();

	/**
	 * Sets the value of the '{@link scrm.knowledge.NumericalMethod#getSolvedProblem <em>Solved Problem</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solved Problem</em>' container reference.
	 * @see #getSolvedProblem()
	 * @generated
	 */
	void setSolvedProblem(ScientificProblem value);

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.knowledge.Assumption}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Assumption#getDependingMethod <em>Depending Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see scrm.knowledge.KnowledgePackage#getNumericalMethod_Dependencies()
	 * @see scrm.knowledge.Assumption#getDependingMethod
	 * @model opposite="dependingMethod" containment="true"
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

} // NumericalMethod
