/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Issue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Issue#getProposals <em>Proposals</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getSolution <em>Solution</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getCriteria <em>Criteria</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getIssue()
 * @model
 * @generated
 */
public interface Issue extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Proposals</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Proposal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proposals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proposals</em>' containment reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Proposals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Proposal> getProposals();

	/**
	 * Returns the value of the '<em><b>Solution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution</em>' containment reference.
	 * @see #setSolution(Solution)
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Solution()
	 * @model containment="true"
	 * @generated
	 */
	Solution getSolution();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Issue#getSolution <em>Solution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solution</em>' containment reference.
	 * @see #getSolution()
	 * @generated
	 */
	void setSolution(Solution value);

	/**
	 * Returns the value of the '<em><b>Criteria</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Criterion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criteria</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criteria</em>' reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Criteria()
	 * @model
	 * @generated
	 */
	EList<Criterion> getCriteria();

} // Issue
