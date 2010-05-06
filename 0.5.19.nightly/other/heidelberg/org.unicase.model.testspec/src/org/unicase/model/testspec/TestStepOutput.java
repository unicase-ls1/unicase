/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec;

import org.eclipse.emf.common.util.EMap;
import org.unicase.metamodel.NonDomainElement;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Step Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.TestStepOutput#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestStepOutput#getRange <em>Range</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestStepOutput#getTestStep <em>Test Step</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestStepOutput#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.testspec.TestspecPackage#getTestStepOutput()
 * @model
 * @generated
 */
public interface TestStepOutput extends UnicaseModelElement, NonDomainElement {
	/**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see org.unicase.model.testspec.TestspecPackage#getTestStepOutput_Type()
     * @model
     * @generated
     */
	String getType();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestStepOutput#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
	void setType(String value);

	/**
     * Returns the value of the '<em><b>Range</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Range</em>' attribute.
     * @see #setRange(String)
     * @see org.unicase.model.testspec.TestspecPackage#getTestStepOutput_Range()
     * @model
     * @generated
     */
	String getRange();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestStepOutput#getRange <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Range</em>' attribute.
     * @see #getRange()
     * @generated
     */
	void setRange(String value);

	/**
     * Returns the value of the '<em><b>Test Step</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link org.unicase.model.testspec.TestStep#getOutput <em>Output</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Step</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Test Step</em>' container reference.
     * @see #setTestStep(TestStep)
     * @see org.unicase.model.testspec.TestspecPackage#getTestStepOutput_TestStep()
     * @see org.unicase.model.testspec.TestStep#getOutput
     * @model opposite="output" keys="identifier" transient="false"
     * @generated
     */
	TestStep getTestStep();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestStepOutput#getTestStep <em>Test Step</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Test Step</em>' container reference.
     * @see #getTestStep()
     * @generated
     */
	void setTestStep(TestStep value);

    /**
     * Returns the value of the '<em><b>Values</b></em>' map.
     * The key is of type {@link org.unicase.model.testspec.TestProtocol},
     * and the value is of type {@link java.lang.String},
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Values</em>' map isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Values</em>' map.
     * @see org.unicase.model.testspec.TestspecPackage#getTestStepOutput_Values()
     * @model mapType="org.unicase.model.testspec.TestProtocolToStringMap<org.unicase.model.testspec.TestProtocol, org.eclipse.emf.ecore.EString>"
     * @generated
     */
    EMap<TestProtocol, String> getValues();

} // TestStepOutput
