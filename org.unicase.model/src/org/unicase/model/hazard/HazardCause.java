/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.hazard;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;

/*
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Cause</b></em>'. <!-- end-user-doc --> <p> The
 * following features are supported: <ul> <li>{@link org.unicase.model.hazard.HazardCause#getHazards
 * <em>Hazards</em>}</li> <li>{@link org.unicase.model.hazard.HazardCause#getHazardousModelElements <em>Hazardous Model
 * Elements</em>}</li> <li>{@link org.unicase.model.hazard.HazardCause#getEvaluationStatus <em>Evaluation
 * Status</em>}</li> <li>{@link org.unicase.model.hazard.HazardCause#getLikelihood <em>Likelihood</em>}</li> <li>{@link
 * org.unicase.model.hazard.HazardCause#getMitigations <em>Mitigations</em>}</li> </ul> </p>
 * @see org.unicase.model.hazard.HazardPackage#getHazardCause()
 * @model
 * @generated
 */
public interface HazardCause extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Hazards</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.hazard.Hazard}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.hazard.Hazard#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazards</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hazards</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getHazardCause_Hazards()
	 * @see org.unicase.model.hazard.Hazard#getCauses
	 * @model opposite="causes" keys="identifier"
	 * @generated
	 */
	EList<Hazard> getHazards();

	/**
	 * Returns the value of the '<em><b>Hazardous Model Elements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazardous Model Elements</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hazardous Model Elements</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getHazardCause_HazardousModelElements()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<ModelElement> getHazardousModelElements();

	/**
	 * Returns the value of the '<em><b>Evaluation Status</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.hazard.EvalStatus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evaluation Status</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evaluation Status</em>' attribute.
	 * @see org.unicase.model.hazard.EvalStatus
	 * @see #setEvaluationStatus(EvalStatus)
	 * @see org.unicase.model.hazard.HazardPackage#getHazardCause_EvaluationStatus()
	 * @model
	 * @generated
	 */
	EvalStatus getEvaluationStatus();

	/**
	 * Sets the value of the '{@link org.unicase.model.hazard.HazardCause#getEvaluationStatus <em>Evaluation Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation Status</em>' attribute.
	 * @see org.unicase.model.hazard.EvalStatus
	 * @see #getEvaluationStatus()
	 * @generated
	 */
	void setEvaluationStatus(EvalStatus value);

	/**
	 * Returns the value of the '<em><b>Likelihood</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Likelihood</em>' attribute list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Likelihood</em>' attribute list.
	 * @see org.unicase.model.hazard.HazardPackage#getHazardCause_Likelihood()
	 * @model
	 * @generated
	 */
	EList<Integer> getLikelihood();

	/**
	 * Returns the value of the '<em><b>Mitigations</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.hazard.Mitigation}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.hazard.Mitigation#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mitigations</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mitigations</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getHazardCause_Mitigations()
	 * @see org.unicase.model.hazard.Mitigation#getCauses
	 * @model opposite="causes" keys="identifier"
	 * @generated
	 */
	EList<Mitigation> getMitigations();

} // HazardCause
