/**
 * <copyright> </copyright> $Id$
 */
package urml.goal;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.urml.Feature;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.UrmlModelElement;

import urml.usecase.ApplicationDomainUseCase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.goal.Goal#isSoft <em>Soft</em>}</li>
 *   <li>{@link urml.goal.Goal#getType <em>Type</em>}</li>
 *   <li>{@link urml.goal.Goal#getStakeholders <em>Stakeholders</em>}</li>
 *   <li>{@link urml.goal.Goal#getRealizedFeatures <em>Realized Features</em>}</li>
 *   <li>{@link urml.goal.Goal#getDetailingUseCases <em>Detailing Use Cases</em>}</li>
 *   <li>{@link urml.goal.Goal#getSubGoals <em>Sub Goals</em>}</li>
 *   <li>{@link urml.goal.Goal#getParentGoal <em>Parent Goal</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.goal.GoalPackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Soft</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Soft</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Soft</em>' attribute.
	 * @see #setSoft(boolean)
	 * @see urml.goal.GoalPackage#getGoal_Soft()
	 * @model
	 * @generated
	 */
	boolean isSoft();

	/**
	 * Sets the value of the '{@link urml.goal.Goal#isSoft <em>Soft</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Soft</em>' attribute.
	 * @see #isSoft()
	 * @generated
	 */
	void setSoft(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute list.
	 * The list contents are of type {@link urml.goal.GoalType}.
	 * The literals are from the enumeration {@link urml.goal.GoalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute list.
	 * @see urml.goal.GoalType
	 * @see urml.goal.GoalPackage#getGoal_Type()
	 * @model
	 * @generated
	 */
	EList<GoalType> getType();

	/**
	 * Returns the value of the '<em><b>Stakeholders</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.Stakeholder}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.Stakeholder#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholders</em>' reference list.
	 * @see urml.goal.GoalPackage#getGoal_Stakeholders()
	 * @see org.unicase.model.urml.Stakeholder#getGoals
	 * @model opposite="goals" keys="identifier"
	 * @generated
	 */
	EList<Stakeholder> getStakeholders();

	/**
	 * Returns the value of the '<em><b>Realized Features</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.Feature}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.Feature#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realized Features</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized Features</em>' reference list.
	 * @see urml.goal.GoalPackage#getGoal_RealizedFeatures()
	 * @see org.unicase.model.urml.Feature#getGoals
	 * @model opposite="goals" keys="identifier"
	 * @generated
	 */
	EList<Feature> getRealizedFeatures();

	/**
	 * Returns the value of the '<em><b>Detailing Use Cases</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link urml.usecase.ApplicationDomainUseCase#getDetailedGoal <em>Detailed Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailing Use Cases</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailing Use Cases</em>' reference.
	 * @see #setDetailingUseCases(ApplicationDomainUseCase)
	 * @see urml.goal.GoalPackage#getGoal_DetailingUseCases()
	 * @see urml.usecase.ApplicationDomainUseCase#getDetailedGoal
	 * @model opposite="detailedGoal" keys="identifier"
	 * @generated
	 */
	ApplicationDomainUseCase getDetailingUseCases();

	/**
	 * Sets the value of the '{@link urml.goal.Goal#getDetailingUseCases <em>Detailing Use Cases</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Detailing Use Cases</em>' reference.
	 * @see #getDetailingUseCases()
	 * @generated
	 */
	void setDetailingUseCases(ApplicationDomainUseCase value);

	/**
	 * Returns the value of the '<em><b>Sub Goals</b></em>' containment reference list.
	 * The list contents are of type {@link urml.goal.Goal}.
	 * It is bidirectional and its opposite is '{@link urml.goal.Goal#getParentGoal <em>Parent Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Goals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Goals</em>' containment reference list.
	 * @see urml.goal.GoalPackage#getGoal_SubGoals()
	 * @see urml.goal.Goal#getParentGoal
	 * @model opposite="parentGoal" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Goal> getSubGoals();

	/**
	 * Returns the value of the '<em><b>Parent Goal</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link urml.goal.Goal#getSubGoals <em>Sub Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Goal</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Goal</em>' container reference.
	 * @see #setParentGoal(Goal)
	 * @see urml.goal.GoalPackage#getGoal_ParentGoal()
	 * @see urml.goal.Goal#getSubGoals
	 * @model opposite="subGoals" keys="identifier" transient="false"
	 * @generated
	 */
	Goal getParentGoal();

	/**
	 * Sets the value of the '{@link urml.goal.Goal#getParentGoal <em>Parent Goal</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Goal</em>' container reference.
	 * @see #getParentGoal()
	 * @generated
	 */
	void setParentGoal(Goal value);

} // Goal
