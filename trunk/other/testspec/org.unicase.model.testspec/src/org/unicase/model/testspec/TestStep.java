/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.TestStep#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestStep#getInputParamter <em>Input Paramter</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestStep#getOutputParameter <em>Output Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.testspec.TestspecPackage#getTestStep()
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
	 * @see org.unicase.model.testspec.TestspecPackage#getTestStep_Exception()
	 * @model
	 * @generated
	 */
	String getException();

	/**
	 * Sets the value of the '{@link org.unicase.model.testspec.TestStep#getException <em>Exception</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception</em>' attribute.
	 * @see #getException()
	 * @generated
	 */
	void setException(String value);

	/**
	 * Returns the value of the '<em><b>Input Paramter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Paramter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Paramter</em>' attribute.
	 * @see #setInputParamter(String)
	 * @see org.unicase.model.testspec.TestspecPackage#getTestStep_InputParamter()
	 * @model
	 * @generated
	 */
	String getInputParamter();

	/**
	 * Sets the value of the '{@link org.unicase.model.testspec.TestStep#getInputParamter <em>Input Paramter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Paramter</em>' attribute.
	 * @see #getInputParamter()
	 * @generated
	 */
	void setInputParamter(String value);

	/**
	 * Returns the value of the '<em><b>Output Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter</em>' attribute.
	 * @see #setOutputParameter(String)
	 * @see org.unicase.model.testspec.TestspecPackage#getTestStep_OutputParameter()
	 * @model
	 * @generated
	 */
	String getOutputParameter();

	/**
	 * Sets the value of the '{@link org.unicase.model.testspec.TestStep#getOutputParameter <em>Output Parameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Parameter</em>' attribute.
	 * @see #getOutputParameter()
	 * @generated
	 */
	void setOutputParameter(String value);

} // TestStep
