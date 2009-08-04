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
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getTestState <em>Test State</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getTestCase <em>Test Case</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getConcreteInputParameter <em>Concrete Input Parameter</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestProtocol#getConcreteOutputParameter <em>Concrete Output Parameter</em>}</li>
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
	 * Returns the value of the '<em><b>Test Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Case</em>' containment reference.
	 * @see #setTestCase(LogicalTestCase)
	 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol_TestCase()
	 * @model containment="true"
	 * @generated
	 */
	LogicalTestCase getTestCase();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestProtocol#getTestCase <em>Test Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Case</em>' containment reference.
	 * @see #getTestCase()
	 * @generated
	 */
	void setTestCase(LogicalTestCase value);

	/**
	 * Returns the value of the '<em><b>Concrete Output Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.testspec.model.ConcreteOutputParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Output Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Output Parameter</em>' reference list.
	 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol_ConcreteOutputParameter()
	 * @model
	 * @generated
	 */
	EList<ConcreteOutputParameter> getConcreteOutputParameter();

	/**
	 * Returns the value of the '<em><b>Concrete Input Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.testspec.model.ConcreteInputParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Concrete Input Parameter</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concrete Input Parameter</em>' reference list.
	 * @see org.unicase.testspec.model.ModelPackage#getTestProtocol_ConcreteInputParameter()
	 * @model
	 * @generated
	 */
	EList<ConcreteInputParameter> getConcreteInputParameter();

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
