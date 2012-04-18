/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.requirement;

import org.unicase.metamodel.NonDomainElement;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Step</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.Step#isUserStep <em>User Step</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Step#getIncludedUseCase <em>Included Use Case</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Step#getIncludedSystemFunction <em>Included System Function</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Step#getUseCase <em>Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getStep()
 * @model
 * @generated
 */
public interface Step extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>User Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Step</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Step</em>' attribute.
	 * @see #setUserStep(boolean)
	 * @see org.unicase.model.requirement.RequirementPackage#getStep_UserStep()
	 * @model
	 * @generated
	 */
	boolean isUserStep();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.Step#isUserStep <em>User Step</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>User Step</em>' attribute.
	 * @see #isUserStep()
	 * @generated
	 */
	void setUserStep(boolean value);

	/**
	 * Returns the value of the '<em><b>Included Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included Use Case</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included Use Case</em>' reference.
	 * @see #setIncludedUseCase(UseCase)
	 * @see org.unicase.model.requirement.RequirementPackage#getStep_IncludedUseCase()
	 * @model
	 * @generated
	 */
	UseCase getIncludedUseCase();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.Step#getIncludedUseCase <em>Included Use Case</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Included Use Case</em>' reference.
	 * @see #getIncludedUseCase()
	 * @generated
	 */
	void setIncludedUseCase(UseCase value);

	/**
	 * Returns the value of the '<em><b>Included System Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Included System Function</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Included System Function</em>' reference.
	 * @see #setIncludedSystemFunction(SystemFunction)
	 * @see org.unicase.model.requirement.RequirementPackage#getStep_IncludedSystemFunction()
	 * @model
	 * @generated
	 */
	SystemFunction getIncludedSystemFunction();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.Step#getIncludedSystemFunction <em>Included System Function</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Included System Function</em>' reference.
	 * @see #getIncludedSystemFunction()
	 * @generated
	 */
	void setIncludedSystemFunction(SystemFunction value);

	/**
	 * Returns the value of the '<em><b>Use Case</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.UseCase#getUseCaseSteps <em>Use Case Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case</em>' container reference.
	 * @see #setUseCase(UseCase)
	 * @see org.unicase.model.requirement.RequirementPackage#getStep_UseCase()
	 * @see org.unicase.model.requirement.UseCase#getUseCaseSteps
	 * @model opposite="useCaseSteps" transient="false"
	 * @generated
	 */
	UseCase getUseCase();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.Step#getUseCase <em>Use Case</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Case</em>' container reference.
	 * @see #getUseCase()
	 * @generated
	 */
	void setUseCase(UseCase value);

} // Step
