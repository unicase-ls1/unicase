/**
 * <copyright> </copyright> $Id$
 */
package urml.usecase;

import org.eclipse.emf.common.util.EList;

import urml.goal.Goal;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Application Domain Use Case</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.usecase.ApplicationDomainUseCase#getDetailedGoal <em>Detailed Goal</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.usecase.UsecasePackage#getApplicationDomainUseCase()
 * @model
 * @generated
 */
public interface ApplicationDomainUseCase extends UseCase {
	/**
	 * Returns the value of the '<em><b>Detailed Goal</b></em>' reference list.
	 * The list contents are of type {@link urml.goal.Goal}.
	 * It is bidirectional and its opposite is '{@link urml.goal.Goal#getDetailingUseCases <em>Detailing Use Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailed Goal</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Detailed Goal</em>' reference list.
	 * @see urml.usecase.UsecasePackage#getApplicationDomainUseCase_DetailedGoal()
	 * @see urml.goal.Goal#getDetailingUseCases
	 * @model opposite="detailingUseCases" keys="identifier"
	 * @generated
	 */
	EList<Goal> getDetailedGoal();

} // ApplicationDomainUseCase
