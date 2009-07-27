/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getTestReport <em>Test Report</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getTestDescription <em>Test Description</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getLocalTestCases <em>Local Test Cases</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getConcreteParameter <em>Concrete Parameter</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getTestState <em>Test State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol()
 * @model
 * @generated
 */
public interface TestProtocol extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Test Report</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Report</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Report</em>' attribute.
	 * @see #setTestReport(String)
	 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol_TestReport()
	 * @model
	 * @generated
	 */
	String getTestReport();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestProtocol#getTestReport <em>Test Report</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Report</em>' attribute.
	 * @see #getTestReport()
	 * @generated
	 */
	void setTestReport(String value);

	/**
	 * Returns the value of the '<em><b>Test Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Description</em>' attribute.
	 * @see #setTestDescription(String)
	 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol_TestDescription()
	 * @model
	 * @generated
	 */
	String getTestDescription();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestProtocol#getTestDescription <em>Test Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Description</em>' attribute.
	 * @see #getTestDescription()
	 * @generated
	 */
	void setTestDescription(String value);

	/**
	 * Returns the value of the '<em><b>Local Test Cases</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Test Cases</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Test Cases</em>' containment reference.
	 * @see #setLocalTestCases(LogicalTestCase)
	 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol_LocalTestCases()
	 * @model containment="true"
	 * @generated
	 */
	LogicalTestCase getLocalTestCases();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestProtocol#getLocalTestCases <em>Local Test Cases</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Test Cases</em>' containment reference.
	 * @see #getLocalTestCases()
	 * @generated
	 */
	void setLocalTestCases(LogicalTestCase value);

	/**
	 * Returns the value of the '<em><b>Concrete Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.testspec.model.ConcreteParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Parameter</em>' containment reference list.
	 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol_ConcreteParameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConcreteParameter> getConcreteParameter();

	/**
	 * Returns the value of the '<em><b>Test State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.testspec.model.EnumState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test State</em>' attribute.
	 * @see org.unicase.testspec.model.EnumState
	 * @see #setTestState(EnumState)
	 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol_TestState()
	 * @model
	 * @generated
	 */
	EnumState getTestState();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestProtocol#getTestState <em>Test State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test State</em>' attribute.
	 * @see org.unicase.testspec.model.EnumState
	 * @see #getTestState()
	 * @generated
	 */
	void setTestState(EnumState value);

} // TestProtocol
