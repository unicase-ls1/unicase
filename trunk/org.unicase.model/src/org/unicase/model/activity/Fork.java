/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.activity;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Fork</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.activity.Fork#getEntryConditions <em>Entry Conditions</em>}</li>
 * <li>{@link org.unicase.model.activity.Fork#getExitConditions <em>Exit Conditions</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.activity.ActivityPackage#getFork()
 * @model
 * @generated
 */
public interface Fork extends ActivityObject {
	/**
	 * Returns the value of the '<em><b>Entry Conditions</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Conditions</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Entry Conditions</em>' attribute.
	 * @see #setEntryConditions(String)
	 * @see org.unicase.model.activity.ActivityPackage#getFork_EntryConditions()
	 * @model
	 * @generated
	 */
	String getEntryConditions();

	/**
	 * Sets the value of the '{@link org.unicase.model.activity.Fork#getEntryConditions <em>Entry Conditions</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Entry Conditions</em>' attribute.
	 * @see #getEntryConditions()
	 * @generated
	 */
	void setEntryConditions(String value);

	/**
	 * Returns the value of the '<em><b>Exit Conditions</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Conditions</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Exit Conditions</em>' attribute.
	 * @see #setExitConditions(String)
	 * @see org.unicase.model.activity.ActivityPackage#getFork_ExitConditions()
	 * @model
	 * @generated
	 */
	String getExitConditions();

	/**
	 * Sets the value of the '{@link org.unicase.model.activity.Fork#getExitConditions <em>Exit Conditions</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Exit Conditions</em>' attribute.
	 * @see #getExitConditions()
	 * @generated
	 */
	void setExitConditions(String value);

} // Fork
