/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assumption</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.knowledge.Assumption#getDependingModel <em>Depending Model</em>}</li>
 *   <li>{@link scrm.knowledge.Assumption#getDependingMethod <em>Depending Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.knowledge.KnowledgePackage#getAssumption()
 * @model
 * @generated
 */
public interface Assumption extends ScientificKnowledge {
	/**
	 * Returns the value of the '<em><b>Depending Model</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.MathematicalModel#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depending Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depending Model</em>' reference.
	 * @see #setDependingModel(MathematicalModel)
	 * @see scrm.knowledge.KnowledgePackage#getAssumption_DependingModel()
	 * @see scrm.knowledge.MathematicalModel#getDependencies
	 * @model opposite="dependencies"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='15'"
	 * @generated
	 */
	MathematicalModel getDependingModel();

	/**
	 * Sets the value of the '{@link scrm.knowledge.Assumption#getDependingModel <em>Depending Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depending Model</em>' reference.
	 * @see #getDependingModel()
	 * @generated
	 */
	void setDependingModel(MathematicalModel value);

	/**
	 * Returns the value of the '<em><b>Depending Method</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.NumericalMethod#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depending Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depending Method</em>' reference.
	 * @see #setDependingMethod(NumericalMethod)
	 * @see scrm.knowledge.KnowledgePackage#getAssumption_DependingMethod()
	 * @see scrm.knowledge.NumericalMethod#getDependencies
	 * @model opposite="dependencies"
	 *        annotation="org.unicase.ui.meeditor position='left' priority='20'"
	 * @generated
	 */
	NumericalMethod getDependingMethod();

	/**
	 * Sets the value of the '{@link scrm.knowledge.Assumption#getDependingMethod <em>Depending Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depending Method</em>' reference.
	 * @see #getDependingMethod()
	 * @generated
	 */
	void setDependingMethod(NumericalMethod value);

} // Assumption
