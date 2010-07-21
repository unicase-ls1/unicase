/**
 * <copyright> </copyright> $Id$
 */
package urml.usecase;

import org.eclipse.emf.common.util.EList;

import urml.danger.Asset;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Actor</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.usecase.Actor#getUseCases <em>Use Cases</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.usecase.UsecasePackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends Asset {
	/**
	 * Returns the value of the '<em><b>Use Cases</b></em>' reference list.
	 * The list contents are of type {@link urml.usecase.UseCase}.
	 * It is bidirectional and its opposite is '{@link urml.usecase.UseCase#getActors <em>Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Cases</em>' reference list.
	 * @see urml.usecase.UsecasePackage#getActor_UseCases()
	 * @see urml.usecase.UseCase#getActors
	 * @model opposite="actors" keys="identifier"
	 * @generated
	 */
	EList<UseCase> getUseCases();

} // Actor
