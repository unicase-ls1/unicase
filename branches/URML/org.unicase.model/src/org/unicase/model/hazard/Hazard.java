/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.hazard;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;
import org.unicase.model.requirement.Actor;

/*
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Hazard</b></em>'. <!-- end-user-doc --> <p> The
 * following features are supported: <ul> <li>{@link org.unicase.model.hazard.Hazard#getSeverity <em>Severity</em>}</li>
 * <li>{@link org.unicase.model.hazard.Hazard#getInvolvedClasses <em>Involved Classes</em>}</li> <li>{@link
 * org.unicase.model.hazard.Hazard#getTargetedActors <em>Targeted Actors</em>}</li> <li>{@link
 * org.unicase.model.hazard.Hazard#getCauses <em>Causes</em>}</li> <li>{@link
 * org.unicase.model.hazard.Hazard#getMitigations <em>Mitigations</em>}</li> </ul> </p>
 * @see org.unicase.model.hazard.HazardPackage#getHazard()
 * @model
 * @generated
 */
public interface Hazard extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see #setSeverity(int)
	 * @see org.unicase.model.hazard.HazardPackage#getHazard_Severity()
	 * @model
	 * @generated
	 */
	int getSeverity();

	/**
	 * Sets the value of the '{@link org.unicase.model.hazard.Hazard#getSeverity <em>Severity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(int value);

	/**
	 * Returns the value of the '<em><b>Involved Classes</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.classes.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Involved Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Involved Classes</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getHazard_InvolvedClasses()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getInvolvedClasses();

	/**
	 * Returns the value of the '<em><b>Targeted Actors</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Actor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targeted Actors</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targeted Actors</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getHazard_TargetedActors()
	 * @model keys="identifier"
	 * @generated
	 */
	EList<Actor> getTargetedActors();

	/**
	 * Returns the value of the '<em><b>Causes</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.hazard.HazardCause}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.hazard.HazardCause#getHazards <em>Hazards</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Causes</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Causes</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getHazard_Causes()
	 * @see org.unicase.model.hazard.HazardCause#getHazards
	 * @model opposite="hazards" keys="identifier"
	 * @generated
	 */
	EList<HazardCause> getCauses();

	/**
	 * Returns the value of the '<em><b>Mitigations</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.hazard.Mitigation}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.hazard.Mitigation#getHazards <em>Hazards</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mitigations</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mitigations</em>' reference list.
	 * @see org.unicase.model.hazard.HazardPackage#getHazard_Mitigations()
	 * @see org.unicase.model.hazard.Mitigation#getHazards
	 * @model opposite="hazards" keys="identifier"
	 * @generated
	 */
	EList<Mitigation> getMitigations();

} // Hazard
