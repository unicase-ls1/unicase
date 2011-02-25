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
 * A representation of the model object '<em><b>Concrete Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.ConcreteParameter#getValue <em>Value</em>}</li>
 *   <li>{@link org.unicase.model.testspec.ConcreteParameter#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.testspec.TestspecPackage#getConcreteParameter()
 * @model
 * @generated
 */
public interface ConcreteParameter extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.unicase.model.testspec.TestspecPackage#getConcreteParameter_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.unicase.model.testspec.ConcreteParameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(Parameter)
	 * @see org.unicase.model.testspec.TestspecPackage#getConcreteParameter_Parameter()
	 * @model keys="identifier"
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link org.unicase.model.testspec.ConcreteParameter#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

} // ConcreteParameter
