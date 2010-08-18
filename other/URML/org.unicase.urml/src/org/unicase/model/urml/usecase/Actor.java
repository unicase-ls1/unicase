/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.usecase;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.danger.Asset;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Actor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.usecase.Actor#getUseCases <em>Use Cases</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.usecase.UsecasePackage#getActor()
 * @model
 * @generated
 */
public interface Actor extends Asset {
	/**
	 * Returns the value of the '<em><b>Use Cases</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.usecase.UseCase}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.usecase.UseCase#getActors <em>Actors</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Cases</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Use Cases</em>' reference list.
	 * @see org.unicase.model.urml.usecase.UsecasePackage#getActor_UseCases()
	 * @see org.unicase.model.urml.usecase.UseCase#getActors
	 * @model opposite="actors" keys="identifier"
	 * @generated
	 */
	EList<UseCase> getUseCases();

} // Actor
