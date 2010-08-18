/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.usecase;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.requirement.Step;
import org.unicase.model.urml.UrmlModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Use Case</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.usecase.UseCase#getSteps <em>Steps</em>}</li>
 * <li>{@link org.unicase.model.urml.usecase.UseCase#getActors <em>Actors</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.usecase.UsecasePackage#getUseCase()
 * @model abstract="true"
 * @generated
 */
public interface UseCase extends UrmlModelElement {
	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.Step}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see org.unicase.model.urml.usecase.UsecasePackage#getUseCase_Steps()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Step> getSteps();

	/**
	 * Returns the value of the '<em><b>Actors</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.usecase.Actor}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.usecase.Actor#getUseCases <em>Use Cases</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actors</em>' reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Actors</em>' reference list.
	 * @see org.unicase.model.urml.usecase.UsecasePackage#getUseCase_Actors()
	 * @see org.unicase.model.urml.usecase.Actor#getUseCases
	 * @model opposite="useCases" keys="identifier"
	 * @generated
	 */
	EList<Actor> getActors();

} // UseCase
