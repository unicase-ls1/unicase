/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.goal.Goal;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Stakeholder</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.Stakeholder#getGoals <em>Goals</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.UrmlPackage#getStakeholder()
 * @model
 * @generated
 */
public interface Stakeholder extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Goals</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.goal.Goal}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.goal.Goal#getStakeholders <em>Stakeholders</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Goals</em>' reference list.
	 * @see org.unicase.model.urml.UrmlPackage#getStakeholder_Goals()
	 * @see org.unicase.model.urml.goal.Goal#getStakeholders
	 * @model opposite="stakeholders"
	 * @generated
	 */
	EList<Goal> getGoals();

} // Stakeholder
