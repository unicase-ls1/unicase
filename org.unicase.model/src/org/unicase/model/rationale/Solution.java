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
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Solution#getUnderlyingProposals <em>Underlying Proposals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Underlying Proposals</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Proposal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Underlying Proposals</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Underlying Proposals</em>' reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getSolution_UnderlyingProposals()
	 * @model
	 * @generated
	 */
	EList<Proposal> getUnderlyingProposals();

} // Solution
