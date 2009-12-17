/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.OrgUnit;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Comment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.rationale.Comment#getSender <em>Sender</em>}</li>
 * <li>{@link org.unicase.model.rationale.Comment#getRecipients <em>Recipients</em>}</li>
 * <li>{@link org.unicase.model.rationale.Comment#getCommentedElement <em>Commented Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.rationale.RationalePackage#getComment()
 * @model
 * @generated
 */
public interface Comment extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Sender</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sender</em>' reference.
	 * @see #setSender(OrgUnit)
	 * @see org.unicase.model.rationale.RationalePackage#getComment_Sender()
	 * @model keys="identifier"
	 * @generated
	 */
	OrgUnit getSender();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Comment#getSender <em>Sender</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Sender</em>' reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(OrgUnit value);

	/**
	 * Returns the value of the '<em><b>Recipients</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.organization.OrgUnit}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipients</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Recipients</em>' reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getComment_Recipients()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<OrgUnit> getRecipients();

	/**
	 * Returns the value of the '<em><b>Commented Element</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.UnicaseModelElement#getComments <em>Comments</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Commented Element</em>' container reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Commented Element</em>' container reference.
	 * @see #setCommentedElement(UnicaseModelElement)
	 * @see org.unicase.model.rationale.RationalePackage#getComment_CommentedElement()
	 * @see org.unicase.model.UnicaseModelElement#getComments
	 * @model opposite="comments" keys="identifier" transient="false"
	 * @generated
	 */
	UnicaseModelElement getCommentedElement();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Comment#getCommentedElement <em>Commented Element</em>}
	 * ' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Commented Element</em>' container reference.
	 * @see #getCommentedElement()
	 * @generated
	 */
	void setCommentedElement(UnicaseModelElement value);

	/**
	 * @return the parents of the comments thread.
	 * @generated NOT
	 */
	List<UnicaseModelElement> getParents();

	/**
	 * @return the top parent of the comments thread.
	 * @generated NOT
	 */
	UnicaseModelElement getFirstParent();

	/**
	 * @return the thread for this comment. Also includes the comment itself.
	 * @generated NOT
	 */
	List<Comment> getThread();

} // Comment
