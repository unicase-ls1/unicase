/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.common.model.NonDomainElement;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Proposal</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.rationale.Proposal#getAssessments <em>Assessments</em>}</li>
 * <li>{@link org.unicase.model.rationale.Proposal#getIssue <em>Issue</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.rationale.RationalePackage#getProposal()
 * @model
 * @generated
 */
public interface Proposal extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Assessments</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.rationale.Assessment}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.rationale.Assessment#getProposal <em>Proposal</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assessments</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Assessments</em>' containment reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getProposal_Assessments()
	 * @see org.unicase.model.rationale.Assessment#getProposal
	 * @model opposite="proposal" containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='10.0' position='right'"
	 * @generated
	 */
	EList<Assessment> getAssessments();

	/**
	 * Returns the value of the '<em><b>Issue</b></em>' container reference. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.rationale.Issue#getProposals <em>Proposals</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Issue</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Issue</em>' container reference.
	 * @see #setIssue(Issue)
	 * @see org.unicase.model.rationale.RationalePackage#getProposal_Issue()
	 * @see org.unicase.model.rationale.Issue#getProposals
	 * @model opposite="proposals" transient="false"
	 *        annotation="org.eclipse.emf.ecp.editor priority='10.0' position='left'"
	 * @generated
	 */
	Issue getIssue();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Proposal#getIssue <em>Issue</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Issue</em>' container reference.
	 * @see #getIssue()
	 * @generated
	 */
	void setIssue(Issue value);

} // Proposal
