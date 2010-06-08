/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.urml;

import urml.goal.Goal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.Stakeholder#getGoals <em>Goals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.UrmlPackage#getStakeholder()
 * @model
 * @generated
 */
public interface Stakeholder extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Goals</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link urml.goal.Goal#getStakeholders <em>Stakeholders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals</em>' reference.
	 * @see #setGoals(Goal)
	 * @see org.unicase.model.urml.UrmlPackage#getStakeholder_Goals()
	 * @see urml.goal.Goal#getStakeholders
	 * @model opposite="stakeholders" keys="identifier"
	 * @generated
	 */
	Goal getGoals();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.Stakeholder#getGoals <em>Goals</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goals</em>' reference.
	 * @see #getGoals()
	 * @generated
	 */
	void setGoals(Goal value);

} // Stakeholder