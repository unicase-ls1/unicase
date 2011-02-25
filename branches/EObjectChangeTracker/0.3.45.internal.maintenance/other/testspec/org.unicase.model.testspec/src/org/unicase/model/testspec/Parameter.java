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
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.testspec.Parameter#getType <em>Type</em>}</li>
 *   <li>{@link org.unicase.model.testspec.Parameter#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.testspec.TestspecPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends ModelElement {
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
	 * @see org.unicase.model.testspec.TestspecPackage#getParameter_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.unicase.model.testspec.Parameter#getType <em>Type</em>}' attribute.
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
	 * @see org.unicase.model.testspec.TestspecPackage#getParameter_Range()
	 * @model
	 * @generated
	 */
	String getRange();

	/**
	 * Sets the value of the '{@link org.unicase.model.testspec.Parameter#getRange <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' attribute.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(String value);

} // Parameter
