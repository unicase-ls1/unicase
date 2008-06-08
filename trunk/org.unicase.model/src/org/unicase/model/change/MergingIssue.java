/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.change;

import org.unicase.model.rationale.Issue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Merging Issue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.change.MergingIssue#getResolvingRevision <em>Resolving Revision</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.change.ChangePackage#getMergingIssue()
 * @model
 * @generated
 */
public interface MergingIssue extends Issue {
	/**
	 * Returns the value of the '<em><b>Resolving Revision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolving Revision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolving Revision</em>' attribute.
	 * @see #setResolvingRevision(int)
	 * @see org.unicase.model.change.ChangePackage#getMergingIssue_ResolvingRevision()
	 * @model
	 * @generated
	 */
	int getResolvingRevision();

	/**
	 * Sets the value of the '{@link org.unicase.model.change.MergingIssue#getResolvingRevision <em>Resolving Revision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolving Revision</em>' attribute.
	 * @see #getResolvingRevision()
	 * @generated
	 */
	void setResolvingRevision(int value);

} // MergingIssue
