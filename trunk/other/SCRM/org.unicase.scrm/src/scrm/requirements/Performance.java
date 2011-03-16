/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.requirements;

import scrm.knowledge.NumericalMethod;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Performance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scrm.requirements.Performance#getNumericalMethod <em>Numerical Method</em>}</li>
 *   <li>{@link scrm.requirements.Performance#getProblemSize <em>Problem Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getPerformance()
 * @model
 * @generated
 */
public interface Performance extends Requirement {
	/**
	 * Returns the value of the '<em><b>Numerical Method</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.NumericalMethod#getPerformance <em>Performance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numerical Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numerical Method</em>' reference.
	 * @see #setNumericalMethod(NumericalMethod)
	 * @see scrm.requirements.RequirementsPackage#getPerformance_NumericalMethod()
	 * @see scrm.knowledge.NumericalMethod#getPerformance
	 * @model opposite="performance"
	 * @generated
	 */
	NumericalMethod getNumericalMethod();

	/**
	 * Sets the value of the '{@link scrm.requirements.Performance#getNumericalMethod <em>Numerical Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numerical Method</em>' reference.
	 * @see #getNumericalMethod()
	 * @generated
	 */
	void setNumericalMethod(NumericalMethod value);

	/**
	 * Returns the value of the '<em><b>Problem Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Problem Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Problem Size</em>' attribute.
	 * @see #setProblemSize(String)
	 * @see scrm.requirements.RequirementsPackage#getPerformance_ProblemSize()
	 * @model
	 * @generated
	 */
	String getProblemSize();

	/**
	 * Sets the value of the '{@link scrm.requirements.Performance#getProblemSize <em>Problem Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem Size</em>' attribute.
	 * @see #getProblemSize()
	 * @generated
	 */
	void setProblemSize(String value);

} // Performance
