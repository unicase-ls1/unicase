/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase;

import org.unicase.metamodel.NonDomainElement;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.usecase.Option#getTargetStep <em>Target Step</em>}</li>
 *   <li>{@link org.unicase.model.usecase.Option#getSourceStep <em>Source Step</em>}</li>
 *   <li>{@link org.unicase.model.usecase.Option#getIncludedUseCase <em>Included Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.usecase.UsecasePackage#getOption()
 * @model
 * @generated
 */
public interface Option extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Target Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Step</em>' reference.
	 * @see #setTargetStep(UnicaseModelElement)
	 * @see org.unicase.model.usecase.UsecasePackage#getOption_TargetStep()
	 * @model
	 * @generated
	 */
	UnicaseModelElement getTargetStep();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.Option#getTargetStep <em>Target Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Step</em>' reference.
	 * @see #getTargetStep()
	 * @generated
	 */
	void setTargetStep(UnicaseModelElement value);

	/**
	 * Returns the value of the '<em><b>Source Step</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.usecase.ActorStep#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Step</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Step</em>' container reference.
	 * @see #setSourceStep(ActorStep)
	 * @see org.unicase.model.usecase.UsecasePackage#getOption_SourceStep()
	 * @see org.unicase.model.usecase.ActorStep#getOptions
	 * @model opposite="options" keys="identifier" transient="false"
	 * @generated
	 */
	ActorStep getSourceStep();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.Option#getSourceStep <em>Source Step</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Step</em>' container reference.
	 * @see #getSourceStep()
	 * @generated
	 */
	void setSourceStep(ActorStep value);

	/**
	 * Returns the value of the '<em><b>Included Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Use Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Use Case</em>' reference.
	 * @see #setIncludedUseCase(UseCase)
	 * @see org.unicase.model.usecase.UsecasePackage#getOption_IncludedUseCase()
	 * @model
	 * @generated
	 */
	UseCase getIncludedUseCase();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.Option#getIncludedUseCase <em>Included Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Included Use Case</em>' reference.
	 * @see #getIncludedUseCase()
	 * @generated
	 */
	void setIncludedUseCase(UseCase value);

} // Option
