/**
 * <copyright> </copyright> $Id$
 */
package urml.goal;

import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.goal.GoalReference#getSource <em>Source</em>}</li>
 *   <li>{@link urml.goal.GoalReference#getTarget <em>Target</em>}</li>
 *   <li>{@link urml.goal.GoalReference#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.goal.GoalPackage#getGoalReference()
 * @model
 * @generated
 */
public interface GoalReference extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link urml.goal.Goal#getInfluencedGoals <em>Influenced Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Goal)
	 * @see urml.goal.GoalPackage#getGoalReference_Source()
	 * @see urml.goal.Goal#getInfluencedGoals
	 * @model opposite="influencedGoals" keys="identifier"
	 * @generated
	 */
	Goal getSource();

	/**
	 * Sets the value of the '{@link urml.goal.GoalReference#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Goal value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link urml.goal.Goal#getInfluencingGoals <em>Influencing Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Goal)
	 * @see urml.goal.GoalPackage#getGoalReference_Target()
	 * @see urml.goal.Goal#getInfluencingGoals
	 * @model opposite="influencingGoals" keys="identifier"
	 * @generated
	 */
	Goal getTarget();

	/**
	 * Sets the value of the '{@link urml.goal.GoalReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Goal value);

	/**
	 * Returns the value of the '<em><b>Weight</b></em>' attribute.
	 * The literals are from the enumeration {@link urml.goal.GoalReferenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weight</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weight</em>' attribute.
	 * @see urml.goal.GoalReferenceType
	 * @see #setWeight(GoalReferenceType)
	 * @see urml.goal.GoalPackage#getGoalReference_Weight()
	 * @model
	 * @generated
	 */
	GoalReferenceType getWeight();

	/**
	 * Sets the value of the '{@link urml.goal.GoalReference#getWeight <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weight</em>' attribute.
	 * @see urml.goal.GoalReferenceType
	 * @see #getWeight()
	 * @generated
	 */
	void setWeight(GoalReferenceType value);

} // GoalReference
