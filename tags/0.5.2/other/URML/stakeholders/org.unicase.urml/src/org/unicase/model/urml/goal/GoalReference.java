/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.goal;

import org.unicase.metamodel.AssociationClassElement;
import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.goal.GoalReference#getSource <em>Source</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.GoalReference#getTarget <em>Target</em>}</li>
 *   <li>{@link org.unicase.model.urml.goal.GoalReference#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.goal.GoalPackage#getGoalReference()
 * @model
 * @generated
 */
public interface GoalReference extends UrmlModelElement,
		AssociationClassElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.goal.Goal#getInfluencedGoals <em>Influenced Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Goal)
	 * @see org.unicase.model.urml.goal.GoalPackage#getGoalReference_Source()
	 * @see org.unicase.model.urml.goal.Goal#getInfluencedGoals
	 * @model opposite="influencedGoals" transient="false"
	 * @generated
	 */
	Goal getSource();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.goal.GoalReference#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Goal value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.goal.Goal#getInfluencingGoals <em>Influencing Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Goal)
	 * @see org.unicase.model.urml.goal.GoalPackage#getGoalReference_Target()
	 * @see org.unicase.model.urml.goal.Goal#getInfluencingGoals
	 * @model opposite="influencingGoals"
	 * @generated
	 */
	Goal getTarget();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.goal.GoalReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Goal value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.urml.goal.GoalReferenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see org.unicase.model.urml.goal.GoalReferenceType
	 * @see #setWeight(GoalReferenceType)
	 * @see org.unicase.model.urml.goal.GoalPackage#getGoalReference_Weight()
	 * @model
	 * @generated
	 */
	GoalReferenceType getWeight();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.goal.GoalReference#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see org.unicase.model.urml.goal.GoalReferenceType
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(GoalReferenceType value);

} // GoalReference
