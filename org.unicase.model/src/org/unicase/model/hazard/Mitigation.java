/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.hazard;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.FunctionalRequirement;

/*
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Mitigation</b></em>'. <!-- end-user-doc --> <p>
 * The following features are supported: <ul> <li>{@link org.unicase.model.hazard.Mitigation#getTechnique
 * <em>Technique</em>}</li> <li>{@link org.unicase.model.hazard.Mitigation#getEvaluationStatus <em>Evaluation
 * Status</em>}</li> <li>{@link org.unicase.model.hazard.Mitigation#getCauses <em>Causes</em>}</li> <li>{@link
 * org.unicase.model.hazard.Mitigation#getHazards <em>Hazards</em>}</li> </ul> </p>
 * @see org.unicase.model.hazard.HazardPackage#getMitigation()
 * @model
 * @generated
 */
public interface Mitigation extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Technique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Technique</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Technique</em>' attribute.
	 * @see #setTechnique(String)
	 * @see org.unicase.model.hazard.HazardPackage#getMitigation_Technique()
	 * @model
	 * @generated
	 */
	String getTechnique();

	/**
	 * Sets the value of the '{@link org.unicase.model.hazard.Mitigation#getTechnique <em>Technique</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technique</em>' attribute.
	 * @see #getTechnique()
	 * @generated
	 */
	void setTechnique(String value);

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
	 * @see org.unicase.model.hazard.HazardPackage#getMitigation_EvaluationStatus()
	 * @model
	 * @generated
	 */
	EvalStatus getEvaluationStatus();

	/**
	 * Sets the value of the '{@link org.unicase.model.hazard.Mitigation#getEvaluationStatus <em>Evaluation Status</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation Status</em>' attribute.
	 * @see org.unicase.model.hazard.EvalStatus
	 * @see #getEvaluationStatus()
	 * @generated
	 */
	void setEvaluationStatus(EvalStatus value);

	/**
	 * Returns the value of the '<em><b>Causes</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.hazard.HazardCause}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.hazard.HazardCause#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Causes</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Causes</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getMitigation_Causes()
	 * @see org.unicase.model.hazard.HazardCause#getMitigations
	 * @model opposite="mitigations" keys="identifier"
	 * @generated
	 */
	EList<HazardCause> getCauses();

	/**
	 * Returns the value of the '<em><b>Hazards</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.hazard.Hazard}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.hazard.Hazard#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hazards</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hazards</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getMitigation_Hazards()
	 * @see org.unicase.model.hazard.Hazard#getMitigations
	 * @model opposite="mitigations" keys="identifier"
	 * @generated
	 */
	EList<Hazard> getHazards();

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.FunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.FunctionalRequirement#getMitigations <em>Mitigations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getMitigation_Requirements()
	 * @see org.unicase.model.requirement.FunctionalRequirement#getMitigations
	 * @model opposite="mitigations" keys="identifier"
	 * @generated
	 */
	EList<FunctionalRequirement> getRequirements();

} // Mitigation
