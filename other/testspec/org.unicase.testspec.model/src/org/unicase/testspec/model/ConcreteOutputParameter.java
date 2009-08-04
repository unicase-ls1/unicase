/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.testspec.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Output Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.testspec.model.ConcreteOutputParameter#getOutputParameter <em>Output Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.testspec.model.ModelPackage#getConcreteOutputParameter()
 * @model
 * @generated
 */
public interface ConcreteOutputParameter extends ConcreteParameter {
	/**
	 * Returns the value of the '<em><b>Output Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter</em>' reference.
	 * @see #setOutputParameter(OutputParameter)
	 * @see org.unicase.testspec.model.ModelPackage#getConcreteOutputParameter_OutputParameter()
	 * @model
	 * @generated
	 */
	OutputParameter getOutputParameter();

	/**
	 * Sets the value of the '{@link org.unicase.testspec.model.ConcreteOutputParameter#getOutputParameter <em>Output Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Parameter</em>' reference.
	 * @see #getOutputParameter()
	 * @generated
	 */
	void setOutputParameter(OutputParameter value);

} // ConcreteOutputParameter
