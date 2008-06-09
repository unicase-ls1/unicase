/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.Annotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Comment#getReplies <em>Replies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getComment()
 * @model
 * @generated
 */
public interface Comment extends Annotation {
	/**
	 * Returns the value of the '<em><b>Replies</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Comment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replies</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replies</em>' reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getComment_Replies()
	 * @model
	 * @generated
	 */
	EList<Comment> getReplies();

} // Comment
