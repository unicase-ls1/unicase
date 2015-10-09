/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.Annotation;
import org.unicase.model.task.ActivityType;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Issue</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Issue#getProposals <em>Proposals</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getSolution <em>Solution</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getCriteria <em>Criteria</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Issue#getAssessments <em>Assessments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getIssue()
 * @model
 * @generated
 */
public interface Issue extends Annotation, Checkable, WorkItem {
	/**
	 * Returns the value of the '<em><b>Proposals</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Proposal}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Proposal#getIssue <em>Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proposals</em>' containment reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proposals</em>' containment reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Proposals()
	 * @see org.unicase.model.rationale.Proposal#getIssue
	 * @model opposite="issue" containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='21.0' position='left'"
	 * @generated
	 */
	EList<Proposal> getProposals();

	/**
	 * Returns the value of the '<em><b>Solution</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Solution#getIssue <em>Issue</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solution</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solution</em>' containment reference.
	 * @see #setSolution(Solution)
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Solution()
	 * @see org.unicase.model.rationale.Solution#getIssue
	 * @model opposite="issue" containment="true" resolveProxies="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='20.0' position='left'"
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
	 * If the meaning of the '<em>Criteria</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criteria</em>' reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Criteria()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='22.0' position='left'"
	 * @generated
	 */
	EList<Criterion> getCriteria();

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.task.ActivityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' attribute.
	 * @see org.unicase.model.task.ActivityType
	 * @see #setActivity(ActivityType)
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Activity()
	 * @model annotation="org.eclipse.emf.ecp.editor priority='9.5' position='left'"
	 * @generated
	 */
	ActivityType getActivity();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Issue#getActivity <em>Activity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Activity</em>' attribute.
	 * @see org.unicase.model.task.ActivityType
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(ActivityType value);

	/**
	 * Returns the value of the '<em><b>Assessments</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Assessment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assessments</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assessments</em>' reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getIssue_Assessments()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="org.eclipse.emf.ecp.editor priority='30' position='bottom'"
	 * @generated
	 */
	EList<Assessment> getAssessments();

} // Issue
