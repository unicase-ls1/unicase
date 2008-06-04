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
 * A representation of the model object '<em><b>Proposal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Proposal#getAssessments <em>Assessments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getProposal()
 * @model
 * @generated
 */
public interface Proposal extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Assessments</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Assessment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assessments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assessments</em>' containment reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getProposal_Assessments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assessment> getAssessments();

} // Proposal
