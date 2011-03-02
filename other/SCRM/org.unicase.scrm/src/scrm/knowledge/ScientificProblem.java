/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import scrm.requirements.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scientific Problem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.knowledge.ScientificProblem#getRepresentingModel <em>Representing Model</em>}</li>
 *   <li>{@link scrm.knowledge.ScientificProblem#getSolvingMethod <em>Solving Method</em>}</li>
 *   <li>{@link scrm.knowledge.ScientificProblem#getInfluencedFeature <em>Influenced Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getScientificProblem()
 * @model
 * @generated
 */
public interface ScientificProblem extends ScientificKnowledge {
	/**
	 * Returns the value of the '<em><b>Representing Model</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.MathematicalModel#getRepresentedProblem <em>Represented Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representing Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representing Model</em>' containment reference.
	 * @see #setRepresentingModel(MathematicalModel)
	 * @see scrm.knowledge.KnowledgePackage#getScientificProblem_RepresentingModel()
	 * @see scrm.knowledge.MathematicalModel#getRepresentedProblem
	 * @model opposite="representedProblem" containment="true"
	 * @generated
	 */
	MathematicalModel getRepresentingModel();

	/**
	 * Sets the value of the '{@link scrm.knowledge.ScientificProblem#getRepresentingModel <em>Representing Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representing Model</em>' containment reference.
	 * @see #getRepresentingModel()
	 * @generated
	 */
	void setRepresentingModel(MathematicalModel value);

	/**
	 * Returns the value of the '<em><b>Solving Method</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.NumericalMethod#getSolvedProblem <em>Solved Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solving Method</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solving Method</em>' containment reference.
	 * @see #setSolvingMethod(NumericalMethod)
	 * @see scrm.knowledge.KnowledgePackage#getScientificProblem_SolvingMethod()
	 * @see scrm.knowledge.NumericalMethod#getSolvedProblem
	 * @model opposite="solvedProblem" containment="true"
	 * @generated
	 */
	NumericalMethod getSolvingMethod();

	/**
	 * Sets the value of the '{@link scrm.knowledge.ScientificProblem#getSolvingMethod <em>Solving Method</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solving Method</em>' containment reference.
	 * @see #getSolvingMethod()
	 * @generated
	 */
	void setSolvingMethod(NumericalMethod value);

	/**
	 * Returns the value of the '<em><b>Influenced Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Influenced Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Influenced Feature</em>' reference.
	 * @see #setInfluencedFeature(Feature)
	 * @see scrm.knowledge.KnowledgePackage#getScientificProblem_InfluencedFeature()
	 * @model
	 * @generated
	 */
	Feature getInfluencedFeature();

	/**
	 * Sets the value of the '{@link scrm.knowledge.ScientificProblem#getInfluencedFeature <em>Influenced Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Influenced Feature</em>' reference.
	 * @see #getInfluencedFeature()
	 * @generated
	 */
	void setInfluencedFeature(Feature value);

} // ScientificProblem
