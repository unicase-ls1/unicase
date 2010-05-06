/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.testspec;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.UnicaseModelElement;

import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.TestCase#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestCase#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestCase#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestCase#getInfrastructure <em>Infrastructure</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestCase#getNonFunctionalRequirement <em>Non Functional Requirement</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestCase#getFunctionalRequirement <em>Functional Requirement</em>}</li>
 *   <li>{@link org.unicase.model.testspec.TestCase#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.testspec.TestspecPackage#getTestCase()
 * @model
 * @generated
 */
public interface TestCase extends UnicaseModelElement {
	/**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.unicase.model.testspec.EnumType}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see org.unicase.model.testspec.EnumType
     * @see #setType(EnumType)
     * @see org.unicase.model.testspec.TestspecPackage#getTestCase_Type()
     * @model annotation="org.unicase.ui.meeditor priority='10.0' position='left'"
     * @generated
     */
	EnumType getType();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestCase#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see org.unicase.model.testspec.EnumType
     * @see #getType()
     * @generated
     */
	void setType(EnumType value);

	/**
     * Returns the value of the '<em><b>Precondition</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Precondition</em>' attribute.
     * @see #setPrecondition(String)
     * @see org.unicase.model.testspec.TestspecPackage#getTestCase_Precondition()
     * @model annotation="org.unicase.ui.meeditor priority='20.0' position='left'"
     * @generated
     */
	String getPrecondition();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestCase#getPrecondition <em>Precondition</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Precondition</em>' attribute.
     * @see #getPrecondition()
     * @generated
     */
	void setPrecondition(String value);

	/**
     * Returns the value of the '<em><b>Postcondition</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Postcondition</em>' attribute.
     * @see #setPostcondition(String)
     * @see org.unicase.model.testspec.TestspecPackage#getTestCase_Postcondition()
     * @model annotation="org.unicase.ui.meeditor priority='30.0' position='left'"
     * @generated
     */
	String getPostcondition();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestCase#getPostcondition <em>Postcondition</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Postcondition</em>' attribute.
     * @see #getPostcondition()
     * @generated
     */
	void setPostcondition(String value);

	/**
     * Returns the value of the '<em><b>Infrastructure</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infrastructure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Infrastructure</em>' attribute.
     * @see #setInfrastructure(String)
     * @see org.unicase.model.testspec.TestspecPackage#getTestCase_Infrastructure()
     * @model annotation="org.unicase.ui.meeditor priority='40.0' position='left'"
     * @generated
     */
	String getInfrastructure();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestCase#getInfrastructure <em>Infrastructure</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Infrastructure</em>' attribute.
     * @see #getInfrastructure()
     * @generated
     */
	void setInfrastructure(String value);

	/**
     * Returns the value of the '<em><b>Non Functional Requirement</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Functional Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Non Functional Requirement</em>' reference.
     * @see #setNonFunctionalRequirement(NonFunctionalRequirement)
     * @see org.unicase.model.testspec.TestspecPackage#getTestCase_NonFunctionalRequirement()
     * @model annotation="org.unicase.ui.meeditor priority='60.0' position='left'"
     * @generated
     */
	NonFunctionalRequirement getNonFunctionalRequirement();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestCase#getNonFunctionalRequirement <em>Non Functional Requirement</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Non Functional Requirement</em>' reference.
     * @see #getNonFunctionalRequirement()
     * @generated
     */
	void setNonFunctionalRequirement(NonFunctionalRequirement value);

	/**
     * Returns the value of the '<em><b>Functional Requirement</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional Requirement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Functional Requirement</em>' reference.
     * @see #setFunctionalRequirement(FunctionalRequirement)
     * @see org.unicase.model.testspec.TestspecPackage#getTestCase_FunctionalRequirement()
     * @model annotation="org.unicase.ui.meeditor priority='50.0' position='left'"
     * @generated
     */
	FunctionalRequirement getFunctionalRequirement();

	/**
     * Sets the value of the '{@link org.unicase.model.testspec.TestCase#getFunctionalRequirement <em>Functional Requirement</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Functional Requirement</em>' reference.
     * @see #getFunctionalRequirement()
     * @generated
     */
	void setFunctionalRequirement(FunctionalRequirement value);

	/**
     * Returns the value of the '<em><b>Step</b></em>' reference list.
     * The list contents are of type {@link org.unicase.model.testspec.TestStep}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Step</em>' reference list.
     * @see org.unicase.model.testspec.TestspecPackage#getTestCase_Step()
     * @model keys="identifier"
     *        annotation="org.unicase.ui.meeditor priority='70.0' position='left'"
     * @generated
     */
	EList<TestStep> getStep();
	
	/**
	 * Get a test step of a test case with a specific ID.
	 *
	 * @author Sharon Friedrich
	 * @param identifier - ID of the test step
	 * @return test step
	 */
	public TestStep getTestStepByIdentifier(String identifier);

} // TestCase
