/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec;

import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.TestStep#getException <em>Exception</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestStep#getInput <em>Input</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestStep#getOutput <em>Output</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestStep#getTestCase <em>Test Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.testspec.TestspecPackage#getTestStep()
 * @model
 * @generated
 */
public interface TestStep extends UnicaseModelElement, NonDomainElement {
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
	 * Returns the value of the '<em><b>Input</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.testspec.TestStepInput}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.testspec.TestStepInput#getTestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference list.
	 * @see org.unicase.model.testspec.TestspecPackage#getTestStep_Input()
	 * @see org.unicase.model.testspec.TestStepInput#getTestStep
	 * @model opposite="testStep" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<TestStepInput> getInput();
	
	/**
	 * Get an input parameter of a test step with a specific ID.
	 *
	 * @author Sharon Friedrich
	 * @param identifier - ID of the input parameter
	 * @return test step input
	 */
	public TestStepInput getInputByIdentifier(String identifier);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.testspec.TestStepOutput}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.testspec.TestStepOutput#getTestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference list.
	 * @see org.unicase.model.testspec.TestspecPackage#getTestStep_Output()
	 * @see org.unicase.model.testspec.TestStepOutput#getTestStep
	 * @model opposite="testStep" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<TestStepOutput> getOutput();
	
	/**
	 * Returns the value of the '<em><b>Test Case</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.testspec.TestCase#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Case</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Case</em>' container reference.
	 * @see #setTestCase(TestCase)
	 * @see org.unicase.model.testspec.TestspecPackage#getTestStep_TestCase()
	 * @see org.unicase.model.testspec.TestCase#getStep
	 * @model opposite="step" transient="false"
	 * @generated
	 */
	TestCase getTestCase();

	/**
	 * Sets the value of the '{@link org.unicase.model.testspec.TestStep#getTestCase <em>Test Case</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Case</em>' container reference.
	 * @see #getTestCase()
	 * @generated
	 */
	void setTestCase(TestCase value);

	/**
     * Get an output parameter of a test step with a specific ID.
     *
     * @author Sharon Friedrich
     * @param identifier - ID of the output parameter
     * @return test step output
     */
    public TestStepOutput getOutputByIdentifier(String identifier);

} // TestStep
