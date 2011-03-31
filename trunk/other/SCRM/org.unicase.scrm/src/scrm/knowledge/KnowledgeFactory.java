/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see scrm.knowledge.KnowledgePackage
 * @generated
 */
public interface KnowledgeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KnowledgeFactory eINSTANCE = scrm.knowledge.impl.KnowledgeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Scientific Problem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scientific Problem</em>'.
	 * @generated
	 */
	ScientificProblem createScientificProblem();

	/**
	 * Returns a new object of class '<em>Mathematical Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mathematical Model</em>'.
	 * @generated
	 */
	MathematicalModel createMathematicalModel();

	/**
	 * Returns a new object of class '<em>Numerical Method</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numerical Method</em>'.
	 * @generated
	 */
	NumericalMethod createNumericalMethod();

	/**
	 * Returns a new object of class '<em>Assumption</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assumption</em>'.
	 * @generated
	 */
	Assumption createAssumption();

	/**
	 * Returns a new object of class '<em>Space</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Space</em>'.
	 * @generated
	 */
	KnowledgeSpace createKnowledgeSpace();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	KnowledgePackage getKnowledgePackage();

} //KnowledgeFactory
