/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.Step#isUserStep <em>User Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getStep()
 * @model
 * @generated
 */
public interface Step extends ModelElement {
	/**
	 * Returns the value of the '<em><b>User Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>User Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Step</em>' attribute.
	 * @see #setUserStep(boolean)
	 * @see org.unicase.model.requirement.RequirementPackage#getStep_UserStep()
	 * @model
	 * @generated
	 */
	boolean isUserStep();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.Step#isUserStep <em>User Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Step</em>' attribute.
	 * @see #isUserStep()
	 * @generated
	 */
	void setUserStep(boolean value);

} // Step
