/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase;

import org.eclipse.emf.common.util.EList;

import org.unicase.metamodel.NonDomainElement;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.usecase.ActorStep#getOptions <em>Options</em>}</li>
 *   <li>{@link org.unicase.model.usecase.ActorStep#getUseCase <em>Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.usecase.UsecasePackage#getActorStep()
 * @model
 * @generated
 */
public interface ActorStep extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Options</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.usecase.Option}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.usecase.Option#getSourceStep <em>Source Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Options</em>' containment reference list.
	 * @see org.unicase.model.usecase.UsecasePackage#getActorStep_Options()
	 * @see org.unicase.model.usecase.Option#getSourceStep
	 * @model opposite="sourceStep" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Option> getOptions();

	/**
	 * Returns the value of the '<em><b>Use Case</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.usecase.UseCase#getActorSteps <em>Actor Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case</em>' container reference.
	 * @see #setUseCase(UseCase)
	 * @see org.unicase.model.usecase.UsecasePackage#getActorStep_UseCase()
	 * @see org.unicase.model.usecase.UseCase#getActorSteps
	 * @model opposite="actorSteps" keys="identifier" transient="false"
	 * @generated
	 */
	UseCase getUseCase();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.ActorStep#getUseCase <em>Use Case</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Case</em>' container reference.
	 * @see #getUseCase()
	 * @generated
	 */
	void setUseCase(UseCase value);

} // ActorStep
