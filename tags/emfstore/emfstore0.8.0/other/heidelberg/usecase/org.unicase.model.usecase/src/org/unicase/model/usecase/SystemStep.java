/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.usecase;

import org.unicase.metamodel.NonDomainElement;

import org.unicase.model.UnicaseModelElement;

import org.unicase.model.requirement.SystemFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.usecase.SystemStep#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.model.usecase.SystemStep#getIncludedSystemFunction <em>Included System Function</em>}</li>
 *   <li>{@link org.unicase.model.usecase.SystemStep#getLinkedStep <em>Linked Step</em>}</li>
 *   <li>{@link org.unicase.model.usecase.SystemStep#getUseCase <em>Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.usecase.UsecasePackage#getSystemStep()
 * @model
 * @generated
 */
public interface SystemStep extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Exception</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception</em>' attribute.
	 * @see #setException(String)
	 * @see org.unicase.model.usecase.UsecasePackage#getSystemStep_Exception()
	 * @model
	 * @generated
	 */
	String getException();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.SystemStep#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(String value);

	/**
	 * Returns the value of the '<em><b>Included System Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included System Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included System Function</em>' reference.
	 * @see #setIncludedSystemFunction(SystemFunction)
	 * @see org.unicase.model.usecase.UsecasePackage#getSystemStep_IncludedSystemFunction()
	 * @model keys="identifier"
	 * @generated
	 */
	SystemFunction getIncludedSystemFunction();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.SystemStep#getIncludedSystemFunction <em>Included System Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Included System Function</em>' reference.
	 * @see #getIncludedSystemFunction()
	 * @generated
	 */
	void setIncludedSystemFunction(SystemFunction value);

	/**
	 * Returns the value of the '<em><b>Linked Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked Step</em>' reference.
	 * @see #setLinkedStep(UnicaseModelElement)
	 * @see org.unicase.model.usecase.UsecasePackage#getSystemStep_LinkedStep()
	 * @model
	 * @generated
	 */
	UnicaseModelElement getLinkedStep();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.SystemStep#getLinkedStep <em>Linked Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked Step</em>' reference.
	 * @see #getLinkedStep()
	 * @generated
	 */
	void setLinkedStep(UnicaseModelElement value);

	/**
	 * Returns the value of the '<em><b>Use Case</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.usecase.UseCase#getSystemSteps <em>System Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case</em>' container reference.
	 * @see #setUseCase(UseCase)
	 * @see org.unicase.model.usecase.UsecasePackage#getSystemStep_UseCase()
	 * @see org.unicase.model.usecase.UseCase#getSystemSteps
	 * @model opposite="systemSteps" keys="identifier" transient="false"
	 * @generated
	 */
	UseCase getUseCase();

	/**
	 * Sets the value of the '{@link org.unicase.model.usecase.SystemStep#getUseCase <em>Use Case</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Case</em>' container reference.
	 * @see #getUseCase()
	 * @generated
	 */
	void setUseCase(UseCase value);

} // SystemStep
