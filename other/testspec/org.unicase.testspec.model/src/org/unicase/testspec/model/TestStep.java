/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.TestStep#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestStep#getInputParameter <em>Input Parameter</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestStep#getOutputParamter <em>Output Paramter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.testspec.model.ModelPackage#getTestStep()
 * @model
 * @generated
 */
public interface TestStep extends ModelElement {
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
	 * @see org.unicase.testspec.model.ModelPackage#getTestStep_Exception()
	 * @model
	 * @generated
	 */
	String getException();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestStep#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(String value);

	/**
	 * Returns the value of the '<em><b>Input Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.testspec.model.InputParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter</em>' reference list.
	 * @see org.unicase.testspec.model.ModelPackage#getTestStep_InputParameter()
	 * @model
	 * @generated
	 */
	EList<InputParameter> getInputParameter();

	/**
	 * Returns the value of the '<em><b>Output Paramter</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.testspec.model.OutputParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Paramter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Paramter</em>' reference list.
	 * @see org.unicase.testspec.model.ModelPackage#getTestStep_OutputParamter()
	 * @model
	 * @generated
	 */
	EList<OutputParameter> getOutputParamter();

} // TestStep
