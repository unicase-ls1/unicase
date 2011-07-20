/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Day</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.pmdashboard.burndown.BurndownDay#getOpenTaskCount <em>Open Task Count</em>}</li>
 *   <li>{@link org.unicase.pmdashboard.burndown.BurndownDay#getRemainingEstimate <em>Remaining Estimate</em>}</li>
 *   <li>{@link org.unicase.pmdashboard.burndown.BurndownDay#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.pmdashboard.burndown.BurndownPackage#getBurndownDay()
 * @model
 * @generated
 */
public interface BurndownDay extends EObject {
	/**
	 * Returns the value of the '<em><b>Open Task Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Open Task Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Task Count</em>' attribute.
	 * @see #setOpenTaskCount(int)
	 * @see org.unicase.pmdashboard.burndown.BurndownPackage#getBurndownDay_OpenTaskCount()
	 * @model
	 * @generated
	 */
	int getOpenTaskCount();

	/**
	 * Sets the value of the '{@link org.unicase.pmdashboard.burndown.BurndownDay#getOpenTaskCount <em>Open Task Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open Task Count</em>' attribute.
	 * @see #getOpenTaskCount()
	 * @generated
	 */
	void setOpenTaskCount(int value);

	/**
	 * Returns the value of the '<em><b>Remaining Estimate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remaining Estimate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remaining Estimate</em>' attribute.
	 * @see #setRemainingEstimate(int)
	 * @see org.unicase.pmdashboard.burndown.BurndownPackage#getBurndownDay_RemainingEstimate()
	 * @model
	 * @generated
	 */
	int getRemainingEstimate();

	/**
	 * Sets the value of the '{@link org.unicase.pmdashboard.burndown.BurndownDay#getRemainingEstimate <em>Remaining Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Estimate</em>' attribute.
	 * @see #getRemainingEstimate()
	 * @generated
	 */
	void setRemainingEstimate(int value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.unicase.pmdashboard.burndown.BurndownPackage#getBurndownDay_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.unicase.pmdashboard.burndown.BurndownDay#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // BurndownDay
