/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link scrm.knowledge.ScientificProblem#getSolvingMethods <em>Solving Methods</em>}</li>
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
	 * Returns the value of the '<em><b>Representing Model</b></em>' reference list.
	 * The list contents are of type {@link scrm.knowledge.Model}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Model#getRepresentedProblem <em>Represented Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representing Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representing Model</em>' reference list.
	 * @see scrm.knowledge.KnowledgePackage#getScientificProblem_RepresentingModel()
	 * @see scrm.knowledge.Model#getRepresentedProblem
	 * @model opposite="representedProblem"
	 * @generated
	 */
	EList<Model> getRepresentingModel();

	/**
	 * Returns the value of the '<em><b>Solving Methods</b></em>' reference list.
	 * The list contents are of type {@link scrm.knowledge.Method}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Method#getSolvedProblem <em>Solved Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solving Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solving Methods</em>' reference list.
	 * @see scrm.knowledge.KnowledgePackage#getScientificProblem_SolvingMethods()
	 * @see scrm.knowledge.Method#getSolvedProblem
	 * @model opposite="solvedProblem"
	 * @generated
	 */
	EList<Method> getSolvingMethods();

	/**
	 * Returns the value of the '<em><b>Influenced Feature</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.Feature#getInfluencingProblem <em>Influencing Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Influenced Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Influenced Feature</em>' reference.
	 * @see #setInfluencedFeature(Feature)
	 * @see scrm.knowledge.KnowledgePackage#getScientificProblem_InfluencedFeature()
	 * @see scrm.requirements.Feature#getInfluencingProblem
	 * @model opposite="influencingProblem"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
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
