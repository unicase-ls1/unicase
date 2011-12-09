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
 *   <li>{@link scrm.requirements.Performance#getProblemSize <em>Problem Size</em>}</li>
 *   <li>{@link scrm.requirements.Performance#getDescribedMethod <em>Described Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see scrm.requirements.RequirementsPackage#getPerformance()
 * @model
 * @generated
 */
public interface Performance extends Requirement {
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
	 * @model annotation="org.eclipse.emf.ecp.editor position='left' priority='5'"
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

	/**
	 * Returns the value of the '<em><b>Described Method</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link scrm.knowledge.NumericalMethod#getPerformance <em>Performance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Described Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Described Method</em>' reference.
	 * @see #setDescribedMethod(NumericalMethod)
	 * @see scrm.requirements.RequirementsPackage#getPerformance_DescribedMethod()
	 * @see scrm.knowledge.NumericalMethod#getPerformance
	 * @model opposite="performance"
	 * @generated
	 */
	NumericalMethod getDescribedMethod();

	/**
	 * Sets the value of the '{@link scrm.requirements.Performance#getDescribedMethod <em>Described Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Described Method</em>' reference.
	 * @see #getDescribedMethod()
	 * @generated
	 */
	void setDescribedMethod(NumericalMethod value);

} // Performance
