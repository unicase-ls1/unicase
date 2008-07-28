/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.rationale;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.Annotation;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.organization.User;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Issue</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Issue#getProposals <em>Proposals</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getSolution <em>Solution</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getCriteria <em>Criteria</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getRefiningIssues <em>Refining Issues</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getRefinedIssue <em>Refined Issue</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getFacilitator <em>Facilitator</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getParticipants <em>Participants</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getIssue()
 * @model
 * @generated
 */
public interface Issue extends Annotation {
	/**
	 * Returns the value of the '<em><b>Proposals</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Proposal}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Proposal#getIssue <em>Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proposals</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proposals</em>' containment reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Proposals()
	 * @see org.unicase.model.rationale.Proposal#getIssue
	 * @model opposite="issue" containment="true" keys="identifier"
	 * @generated
	 */
	EList<Proposal> getProposals();

	/**
	 * Returns the value of the '<em><b>Solution</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Solution#getIssue <em>Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution</em>' containment reference.
	 * @see #setSolution(Solution)
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Solution()
	 * @see org.unicase.model.rationale.Solution#getIssue
	 * @model opposite="issue" containment="true" keys="identifier"
	 * @generated
	 */
	Solution getSolution();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Issue#getSolution <em>Solution</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * @model keys="identifier"
	 * @generated
	 */
	EList<Criterion> getCriteria();

	/**
	 * Returns the value of the '<em><b>Refining Issues</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Issue}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Issue#getRefinedIssue <em>Refined Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refining Issues</em>' containment reference
	 * list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refining Issues</em>' containment reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_RefiningIssues()
	 * @see org.unicase.model.rationale.Issue#getRefinedIssue
	 * @model opposite="refinedIssue" containment="true" keys="identifier"
	 * @generated
	 */
	EList<Issue> getRefiningIssues();

	/**
	 * Returns the value of the '<em><b>Refined Issue</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Issue#getRefiningIssues <em>Refining Issues</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined Issue</em>' container reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refined Issue</em>' container reference.
	 * @see #setRefinedIssue(Issue)
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_RefinedIssue()
	 * @see org.unicase.model.rationale.Issue#getRefiningIssues
	 * @model opposite="refiningIssues" keys="identifier" transient="false"
	 * @generated
	 */
	Issue getRefinedIssue();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Issue#getRefinedIssue <em>Refined Issue</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refined Issue</em>' container reference.
	 * @see #getRefinedIssue()
	 * @generated
	 */
	void setRefinedIssue(Issue value);

	/**
	 * Returns the value of the '<em><b>Facilitator</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facilitator</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Facilitator</em>' reference.
	 * @see #setFacilitator(User)
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Facilitator()
	 * @model
	 * @generated
	 */
	User getFacilitator();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Issue#getFacilitator <em>Facilitator</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Facilitator</em>' reference.
	 * @see #getFacilitator()
	 * @generated
	 */
	void setFacilitator(User value);

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.organization.OrgUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Participants()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<OrgUnit> getParticipants();

} // Issue
