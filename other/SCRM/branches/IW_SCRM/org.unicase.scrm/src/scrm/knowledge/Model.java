/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.common.util.EList;

import scrm.requirements.dataObject.Data;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.knowledge.Model#getRepresentedProblem <em>Represented Problem</em>}</li>
 *   <li>{@link scrm.knowledge.Model#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.knowledge.Model#getRefinedModel <em>Refined Model</em>}</li>
 *   <li>{@link scrm.knowledge.Model#getUsedInMethods <em>Used In Methods</em>}</li>
 *   <li>{@link scrm.knowledge.Model#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.Model#getInvolvedData <em>Involved Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getModel()
 * @model
 * @generated
 */
public interface Model extends ScientificKnowledge {
	/**
	 * Returns the value of the '<em><b>Represented Problem</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.ScientificProblem#getRepresentingModel <em>Representing Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Problem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Problem</em>' reference.
	 * @see #setRepresentedProblem(ScientificProblem)
	 * @see scrm.knowledge.KnowledgePackage#getModel_RepresentedProblem()
	 * @see scrm.knowledge.ScientificProblem#getRepresentingModel
	 * @model opposite="representingModel"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	ScientificProblem getRepresentedProblem();

	/**
	 * Sets the value of the '{@link scrm.knowledge.Model#getRepresentedProblem <em>Represented Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Problem</em>' reference.
	 * @see #getRepresentedProblem()
	 * @generated
	 */
	void setRepresentedProblem(ScientificProblem value);

	/**
	 * Returns the value of the '<em><b>Refinements</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.knowledge.Model}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Model#getRefinedModel <em>Refined Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refinements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refinements</em>' containment reference list.
	 * @see scrm.knowledge.KnowledgePackage#getModel_Refinements()
	 * @see scrm.knowledge.Model#getRefinedModel
	 * @model opposite="refinedModel" containment="true" resolveProxies="true"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='5'"
	 * @generated
	 */
	EList<Model> getRefinements();

	/**
	 * Returns the value of the '<em><b>Refined Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Model#getRefinements <em>Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined Model</em>' container reference.
	 * @see #setRefinedModel(Model)
	 * @see scrm.knowledge.KnowledgePackage#getModel_RefinedModel()
	 * @see scrm.knowledge.Model#getRefinements
	 * @model opposite="refinements" transient="false"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='14'"
	 * @generated
	 */
	Model getRefinedModel();

	/**
	 * Sets the value of the '{@link scrm.knowledge.Model#getRefinedModel <em>Refined Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined Model</em>' container reference.
	 * @see #getRefinedModel()
	 * @generated
	 */
	void setRefinedModel(Model value);

	/**
	 * Returns the value of the '<em><b>Used In Methods</b></em>' reference list.
	 * The list contents are of type {@link scrm.knowledge.Method}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Method#getUsingModel <em>Using Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used In Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used In Methods</em>' reference list.
	 * @see scrm.knowledge.KnowledgePackage#getModel_UsedInMethods()
	 * @see scrm.knowledge.Method#getUsingModel
	 * @model opposite="usingModel" derived="true"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	EList<Method> getUsedInMethods();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
	 * The list contents are of type {@link scrm.knowledge.Assumption}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.Assumption#getDependingModel <em>Depending Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependencies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' reference list.
	 * @see scrm.knowledge.KnowledgePackage#getModel_Dependencies()
	 * @see scrm.knowledge.Assumption#getDependingModel
	 * @model opposite="dependingModel"
	 *        annotation="org.unicase.ui.meeditor position='right' priority='15'"
	 * @generated
	 */
	EList<Assumption> getDependencies();

	/**
	 * Returns the value of the '<em><b>Involved Data</b></em>' reference list.
	 * The list contents are of type {@link scrm.requirements.dataObject.Data}.
	 * It is bidirectional and its opposite is '{@link scrm.requirements.dataObject.Data#getDescribedModel <em>Described Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Involved Data</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Involved Data</em>' reference list.
	 * @see scrm.knowledge.KnowledgePackage#getModel_InvolvedData()
	 * @see scrm.requirements.dataObject.Data#getDescribedModel
	 * @model opposite="describedModel"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	EList<Data> getInvolvedData();

} // Model
