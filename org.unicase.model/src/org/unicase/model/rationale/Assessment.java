/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assessment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Assessment#getProposal <em>Proposal</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Assessment#getCriterion <em>Criterion</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Assessment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getAssessment()
 * @model
 * @generated
 */
public interface Assessment extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Proposal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proposal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proposal</em>' reference.
	 * @see #setProposal(Proposal)
	 * @see org.unicase.model.rationale.RationalePackage#getAssessment_Proposal()
	 * @model required="true"
	 * @generated
	 */
	Proposal getProposal();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Assessment#getProposal <em>Proposal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proposal</em>' reference.
	 * @see #getProposal()
	 * @generated
	 */
	void setProposal(Proposal value);

	/**
	 * Returns the value of the '<em><b>Criterion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criterion</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criterion</em>' reference.
	 * @see #setCriterion(Criterion)
	 * @see org.unicase.model.rationale.RationalePackage#getAssessment_Criterion()
	 * @model required="true"
	 * @generated
	 */
	Criterion getCriterion();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Assessment#getCriterion <em>Criterion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criterion</em>' reference.
	 * @see #getCriterion()
	 * @generated
	 */
	void setCriterion(Criterion value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see org.unicase.model.rationale.RationalePackage#getAssessment_Value()
	 * @model
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Assessment#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

} // Assessment
