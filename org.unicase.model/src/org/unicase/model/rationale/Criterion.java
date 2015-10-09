/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.rationale;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Criterion</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.rationale.Criterion#getAssessments <em>Assessments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.rationale.RationalePackage#getCriterion()
 * @model
 * @generated
 */
public interface Criterion extends UnicaseModelElement {

	/**
	 * Returns the value of the '<em><b>Assessments</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.rationale.Assessment}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.rationale.Assessment#getCriterion <em>Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assessments</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assessments</em>' reference list.
	 * @see org.unicase.model.rationale.RationalePackage#getCriterion_Assessments()
	 * @see org.unicase.model.rationale.Assessment#getCriterion
	 * @model opposite="criterion"
	 *        annotation="org.eclipse.emf.ecp.editor priority='10.0' position='right'"
	 * @generated
	 */
	EList<Assessment> getAssessments();
} // Criterion
