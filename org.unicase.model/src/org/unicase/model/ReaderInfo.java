/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.unicase.model.organization.OrgUnit;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Reader Info</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.ReaderInfo#getDate <em>Date</em>}</li>
 *   <li>{@link org.unicase.model.ReaderInfo#getReaderId <em>Reader Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getReaderInfo()
 * @model
 * @generated
 */
public interface ReaderInfo extends EObject {
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
	 * @see org.unicase.model.ModelPackage#getReaderInfo_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.unicase.model.ReaderInfo#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Reader Id</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reader Id</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reader Id</em>' reference.
	 * @see #setReaderId(OrgUnit)
	 * @see org.unicase.model.ModelPackage#getReaderInfo_ReaderId()
	 * @model
	 * @generated
	 */
	OrgUnit getReaderId();

	/**
	 * Sets the value of the '{@link org.unicase.model.ReaderInfo#getReaderId
	 * <em>Reader Id</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Reader Id</em>' reference.
	 * @see #getReaderId()
	 * @generated
	 */
	void setReaderId(OrgUnit value);

} // ReaderInfo
