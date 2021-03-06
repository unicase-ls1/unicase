/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mathematical Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.knowledge.MathematicalModel#getRepresentedProblem <em>Represented Problem</em>}</li>
 *   <li>{@link scrm.knowledge.MathematicalModel#getRefinements <em>Refinements</em>}</li>
 *   <li>{@link scrm.knowledge.MathematicalModel#getRefinedModel <em>Refined Model</em>}</li>
 *   <li>{@link scrm.knowledge.MathematicalModel#getNumericalMethods <em>Numerical Methods</em>}</li>
 *   <li>{@link scrm.knowledge.MathematicalModel#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link scrm.knowledge.MathematicalModel#getTheory <em>Theory</em>}</li>
 *   <li>{@link scrm.knowledge.MathematicalModel#getMathematicalExpression <em>Mathematical Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getMathematicalModel()
 * @model
 * @generated
 */
public interface MathematicalModel extends ScientificKnowledge {
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
	 * @see scrm.knowledge.KnowledgePackage#getMathematicalModel_RepresentedProblem()
	 * @see scrm.knowledge.ScientificProblem#getRepresentingModel
	 * @model opposite="representingModel"
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='15'"
	 * @generated
	 */
	ScientificProblem getRepresentedProblem();

	/**
	 * Sets the value of the '{@link scrm.knowledge.MathematicalModel#getRepresentedProblem <em>Represented Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Problem</em>' reference.
	 * @see #getRepresentedProblem()
	 * @generated
	 */
	void setRepresentedProblem(ScientificProblem value);

	/**
	 * Returns the value of the '<em><b>Refinements</b></em>' containment reference list.
	 * The list contents are of type {@link scrm.knowledge.MathematicalModel}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.MathematicalModel#getRefinedModel <em>Refined Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refinements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refinements</em>' containment reference list.
	 * @see scrm.knowledge.KnowledgePackage#getMathematicalModel_Refinements()
	 * @see scrm.knowledge.MathematicalModel#getRefinedModel
	 * @model opposite="refinedModel" containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor position='right' priority='5'"
	 * @generated
	 */
	EList<MathematicalModel> getRefinements();

	/**
	 * Returns the value of the '<em><b>Refined Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.MathematicalModel#getRefinements <em>Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined Model</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined Model</em>' container reference.
	 * @see #setRefinedModel(MathematicalModel)
	 * @see scrm.knowledge.KnowledgePackage#getMathematicalModel_RefinedModel()
	 * @see scrm.knowledge.MathematicalModel#getRefinements
	 * @model opposite="refinements" transient="false"
	 *        annotation="org.eclipse.emf.ecp.editor position='left' priority='12'"
	 * @generated
	 */
	MathematicalModel getRefinedModel();

	/**
	 * Sets the value of the '{@link scrm.knowledge.MathematicalModel#getRefinedModel <em>Refined Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined Model</em>' container reference.
	 * @see #getRefinedModel()
	 * @generated
	 */
	void setRefinedModel(MathematicalModel value);

	/**
	 * Returns the value of the '<em><b>Numerical Methods</b></em>' reference list.
	 * The list contents are of type {@link scrm.knowledge.NumericalMethod}.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.NumericalMethod#getMathematicalModel <em>Mathematical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numerical Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numerical Methods</em>' reference list.
	 * @see scrm.knowledge.KnowledgePackage#getMathematicalModel_NumericalMethods()
	 * @see scrm.knowledge.NumericalMethod#getMathematicalModel
	 * @model opposite="mathematicalModel"
	 *        annotation="org.eclipse.emf.ecp.editor position='right' priority='10'"
	 * @generated
	 */
	EList<NumericalMethod> getNumericalMethods();

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
	 * @see scrm.knowledge.KnowledgePackage#getMathematicalModel_Dependencies()
	 * @see scrm.knowledge.Assumption#getDependingModel
	 * @model opposite="dependingModel"
	 *        annotation="org.eclipse.emf.ecp.editor position='right' priority='15'"
	 * @generated
	 */
	EList<Assumption> getDependencies();

	/**
	 * Returns the value of the '<em><b>Theory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Theory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Theory</em>' attribute.
	 * @see #setTheory(String)
	 * @see scrm.knowledge.KnowledgePackage#getMathematicalModel_Theory()
	 * @model annotation="org.eclipse.emf.ecp.editor position='left' priority='5'"
	 * @generated
	 */
	String getTheory();

	/**
	 * Sets the value of the '{@link scrm.knowledge.MathematicalModel#getTheory <em>Theory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Theory</em>' attribute.
	 * @see #getTheory()
	 * @generated
	 */
	void setTheory(String value);

	/**
	 * Returns the value of the '<em><b>Mathematical Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mathematical Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mathematical Expression</em>' attribute.
	 * @see #setMathematicalExpression(String)
	 * @see scrm.knowledge.KnowledgePackage#getMathematicalModel_MathematicalExpression()
	 * @model annotation="org.eclipse.emf.ecp.editor position='left' priority='7'"
	 * @generated
	 */
	String getMathematicalExpression();

	/**
	 * Sets the value of the '{@link scrm.knowledge.MathematicalModel#getMathematicalExpression <em>Mathematical Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mathematical Expression</em>' attribute.
	 * @see #getMathematicalExpression()
	 * @generated
	 */
	void setMathematicalExpression(String value);

} // MathematicalModel
