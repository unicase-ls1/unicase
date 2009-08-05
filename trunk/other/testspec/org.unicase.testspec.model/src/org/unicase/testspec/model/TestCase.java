/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;

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
 *   <li>{@link org.unicase.testspec.model.TestCase#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestCase#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestCase#getPostcondition <em>Postcondition</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestCase#getInfrastructure <em>Infrastructure</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestCase#getNonFunctionalRequirement <em>Non Functional Requirement</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestCase#getFunctionalRequirement <em>Functional Requirement</em>}</li>
 *   <li>{@link org.unicase.testspec.model.TestCase#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.testspec.model.ModelPackage#getTestCase()
 * @model
 * @generated
 */
public interface TestCase extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.testspec.model.EnumType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.unicase.testspec.model.EnumType
	 * @see #setType(EnumType)
	 * @see org.unicase.testspec.model.ModelPackage#getTestCase_Type()
	 * @model
	 * @generated
	 */
	EnumType getType();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestCase#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.unicase.testspec.model.EnumType
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
	 * @see org.unicase.testspec.model.ModelPackage#getTestCase_Precondition()
	 * @model
	 * @generated
	 */
	String getPrecondition();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestCase#getPrecondition <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precondition</em>' attribute.
	 * @see #getPrecondition()
	 * @generated
	 */
	void setPrecondition(String value);

	/**
	 * Returns the value of the '<em><b>Postcondition</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcondition</em>' attribute.
	 * @see #setPostcondition(String)
	 * @see org.unicase.testspec.model.ModelPackage#getTestCase_Postcondition()
	 * @model default=""
	 * @generated
	 */
	String getPostcondition();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestCase#getPostcondition <em>Postcondition</em>}' attribute.
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
	 * @see org.unicase.testspec.model.ModelPackage#getTestCase_Infrastructure()
	 * @model
	 * @generated
	 */
	String getInfrastructure();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestCase#getInfrastructure <em>Infrastructure</em>}' attribute.
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
	 * @see org.unicase.testspec.model.ModelPackage#getTestCase_NonFunctionalRequirement()
	 * @model
	 * @generated
	 */
	NonFunctionalRequirement getNonFunctionalRequirement();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestCase#getNonFunctionalRequirement <em>Non Functional Requirement</em>}' reference.
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
	 * @see org.unicase.testspec.model.ModelPackage#getTestCase_FunctionalRequirement()
	 * @model
	 * @generated
	 */
	FunctionalRequirement getFunctionalRequirement();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.TestCase#getFunctionalRequirement <em>Functional Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functional Requirement</em>' reference.
	 * @see #getFunctionalRequirement()
	 * @generated
	 */
	void setFunctionalRequirement(FunctionalRequirement value);

	/**
	 * Returns the value of the '<em><b>Step</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.testspec.model.TestStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' reference list.
	 * @see org.unicase.testspec.model.ModelPackage#getTestCase_Step()
	 * @model
	 * @generated
	 */
	EList<TestStep> getStep();

} // TestCase
