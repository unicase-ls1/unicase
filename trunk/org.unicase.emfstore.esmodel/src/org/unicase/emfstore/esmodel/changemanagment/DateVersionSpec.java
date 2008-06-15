/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment;

import java.util.Date;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Date Version Spec</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec#getDate
 * <em>Date</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getDateVersionSpec()
 * @model
 * @generated
 */
public interface DateVersionSpec extends VersionSpec {
	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getDateVersionSpec_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec#getDate
	 * <em>Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // DateVersionSpec
