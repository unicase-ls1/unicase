/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale;

import org.unicase.metamodel.NonDomainElement;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Assessment</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Assessment#getProposal <em>Proposal</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Assessment#getCriterion <em>Criterion</em>}</li>
 *   <li>{@link org.unicase.model.rationale.Assessment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getAssessment()
 * @model
 * @generated
 */
public interface Assessment extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Proposal</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Proposal#getAssessments <em>Assessments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proposal</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proposal</em>' container reference.
	 * @see #setProposal(Proposal)
	 * @see org.unicase.model.rationale.RationalePackage#getAssessment_Proposal()
	 * @see org.unicase.model.rationale.Proposal#getAssessments
	 * @model opposite="assessments" transient="false"
	 * @generated
	 */
	Proposal getProposal();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Assessment#getProposal <em>Proposal</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proposal</em>' container reference.
	 * @see #getProposal()
	 * @generated
	 */
	void setProposal(Proposal value);

	/**
	 * Returns the value of the '<em><b>Criterion</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Criterion#getAssessments <em>Assessments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Criterion</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Criterion</em>' reference.
	 * @see #setCriterion(Criterion)
	 * @see org.unicase.model.rationale.RationalePackage#getAssessment_Criterion()
	 * @see org.unicase.model.rationale.Criterion#getAssessments
	 * @model opposite="assessments"
	 * @generated
	 */
	Criterion getCriterion();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Assessment#getCriterion <em>Criterion</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Criterion</em>' reference.
	 * @see #getCriterion()
	 * @generated
	 */
	void setCriterion(Criterion value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see org.unicase.model.rationale.RationalePackage#getAssessment_Value()
	 * @model
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link org.unicase.model.rationale.Assessment#getValue <em>Value</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

} // Assessment
