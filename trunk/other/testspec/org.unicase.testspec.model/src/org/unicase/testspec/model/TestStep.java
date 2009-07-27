/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link org.unicase.testspec.model.TestStep#getOutputParameter <em>Output Parameter</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestStep#getInputparameter <em>Inputparameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.testspec.model.ModelPackage#getTestStep()
 * @model
 * @generated
 */
public interface TestStep extends EObject {
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
	 * Returns the value of the '<em><b>Output Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.testspec.model.OutputParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter</em>' containment reference list.
	 * @see org.unicase.testspec.model.ModelPackage#getTestStep_OutputParameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputParameter> getOutputParameter();

	/**
	 * Returns the value of the '<em><b>Inputparameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.testspec.model.InputParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputparameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputparameter</em>' containment reference list.
	 * @see org.unicase.testspec.model.ModelPackage#getTestStep_Inputparameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputParameter> getInputparameter();

} // TestStep
