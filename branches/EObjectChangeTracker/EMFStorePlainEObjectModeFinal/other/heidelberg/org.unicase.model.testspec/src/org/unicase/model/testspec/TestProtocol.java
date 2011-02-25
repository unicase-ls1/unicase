/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.TestProtocol#getTestReport <em>Test Report</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestProtocol#getTestState <em>Test State</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestProtocol#getTestCase <em>Test Case</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestProtocol#getTestSteps <em>Test Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.testspec.TestspecPackage#getTestProtocol()
 * @model
 * @generated
 */
public interface TestProtocol extends UnicaseModelElement {
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
     * @see org.unicase.model.testspec.TestspecPackage#getTestProtocol_TestReport()
     * @model annotation="org.unicase.ui.meeditor priority='10.0' position='left'"
     * @generated
     */
	String getTestReport();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestProtocol#getTestReport <em>Test Report</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Test Report</em>' attribute.
     * @see #getTestReport()
     * @generated
     */
	void setTestReport(String value);

	/**
     * Returns the value of the '<em><b>Test State</b></em>' attribute.
     * The literals are from the enumeration {@link org.unicase.model.testspec.EnumState}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Test State</em>' attribute.
     * @see org.unicase.model.testspec.EnumState
     * @see #setTestState(EnumState)
     * @see org.unicase.model.testspec.TestspecPackage#getTestProtocol_TestState()
     * @model annotation="org.unicase.ui.meeditor priority='20.0' position='left'"
     * @generated
     */
	EnumState getTestState();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestProtocol#getTestState <em>Test State</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Test State</em>' attribute.
     * @see org.unicase.model.testspec.EnumState
     * @see #getTestState()
     * @generated
     */
	void setTestState(EnumState value);

	/**
     * Returns the value of the '<em><b>Test Case</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Test Case</em>' reference.
     * @see #setTestCase(TestCase)
     * @see org.unicase.model.testspec.TestspecPackage#getTestProtocol_TestCase()
     * @model keys="identifier"
     *        annotation="org.unicase.ui.meeditor priority='30.0' position='left'"
     * @generated
     */
	TestCase getTestCase();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestProtocol#getTestCase <em>Test Case</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Test Case</em>' reference.
     * @see #getTestCase()
     * @generated
     */
	void setTestCase(TestCase value);

	/**
     * Returns the value of the '<em><b>Test Steps</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Steps</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Test Steps</em>' reference.
     * @see #setTestSteps(TestStep)
     * @see org.unicase.model.testspec.TestspecPackage#getTestProtocol_TestSteps()
     * @model keys="identifier"
     *        annotation="org.unicase.ui.meeditor priority='1.0' position='bottom'"
     * @generated
     */
	TestStep getTestSteps();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestProtocol#getTestSteps <em>Test Steps</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Test Steps</em>' reference.
     * @see #getTestSteps()
     * @generated
     */
	void setTestSteps(TestStep value);

} // TestProtocol
