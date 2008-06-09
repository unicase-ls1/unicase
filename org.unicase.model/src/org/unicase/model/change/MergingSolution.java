/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.change;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.rationale.Solution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Merging Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.change.MergingSolution#getAppliedChanges <em>Applied Changes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.change.ChangePackage#getMergingSolution()
 * @model
 * @generated
 */
public interface MergingSolution extends Solution {
	/**
	 * Returns the value of the '<em><b>Applied Changes</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.change.ModelChangePackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Changes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Changes</em>' reference list.
	 * @see org.unicase.model.change.ChangePackage#getMergingSolution_AppliedChanges()
	 * @model
	 * @generated
	 */
	EList<ModelChangePackage> getAppliedChanges();

} // MergingSolution
