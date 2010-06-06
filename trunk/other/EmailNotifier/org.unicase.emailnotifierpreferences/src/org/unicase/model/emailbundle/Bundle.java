/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.emailbundle;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#getBundleName <em>Bundle Name</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#getSendOption <em>Send Option</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isDays <em>Days</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#getDaysCount <em>Days Count</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isWeekday <em>Weekday</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#getWeekdayOption <em>Weekday Option</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#getProviders <em>Providers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle()
 * @model
 * @generated
 */
public interface Bundle extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the\naccompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this\ndistribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\n";

	/**
	 * Returns the value of the '<em><b>Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle Name</em>' attribute.
	 * @see #setBundleName(String)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_BundleName()
	 * @model
	 * @generated
	 */
	String getBundleName();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#getBundleName <em>Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle Name</em>' attribute.
	 * @see #getBundleName()
	 * @generated
	 */
	void setBundleName(String value);

	/**
	 * Returns the value of the '<em><b>Send Option</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.emailbundle.SendSettings}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Send Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Send Option</em>' attribute.
	 * @see org.unicase.model.emailbundle.SendSettings
	 * @see #setSendOption(SendSettings)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_SendOption()
	 * @model
	 * @generated
	 */
	SendSettings getSendOption();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#getSendOption <em>Send Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Send Option</em>' attribute.
	 * @see org.unicase.model.emailbundle.SendSettings
	 * @see #getSendOption()
	 * @generated
	 */
	void setSendOption(SendSettings value);

	/**
	 * Returns the value of the '<em><b>Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Days</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Days</em>' attribute.
	 * @see #setDays(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_Days()
	 * @model
	 * @generated
	 */
	boolean isDays();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isDays <em>Days</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Days</em>' attribute.
	 * @see #isDays()
	 * @generated
	 */
	void setDays(boolean value);

	/**
	 * Returns the value of the '<em><b>Days Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Days Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Days Count</em>' attribute.
	 * @see #setDaysCount(int)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_DaysCount()
	 * @model
	 * @generated
	 */
	int getDaysCount();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#getDaysCount <em>Days Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Days Count</em>' attribute.
	 * @see #getDaysCount()
	 * @generated
	 */
	void setDaysCount(int value);

	/**
	 * Returns the value of the '<em><b>Weekday</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weekday</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weekday</em>' attribute.
	 * @see #setWeekday(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_Weekday()
	 * @model
	 * @generated
	 */
	boolean isWeekday();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isWeekday <em>Weekday</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weekday</em>' attribute.
	 * @see #isWeekday()
	 * @generated
	 */
	void setWeekday(boolean value);

	/**
	 * Returns the value of the '<em><b>Weekday Option</b></em>' attribute.
	 * The literals are from the enumeration {@link org.unicase.model.emailbundle.Weekdays}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weekday Option</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weekday Option</em>' attribute.
	 * @see org.unicase.model.emailbundle.Weekdays
	 * @see #setWeekdayOption(Weekdays)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_WeekdayOption()
	 * @model
	 * @generated
	 */
	Weekdays getWeekdayOption();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#getWeekdayOption <em>Weekday Option</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weekday Option</em>' attribute.
	 * @see org.unicase.model.emailbundle.Weekdays
	 * @see #getWeekdayOption()
	 * @generated
	 */
	void setWeekdayOption(Weekdays value);

	/**
	 * Returns the value of the '<em><b>Providers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Providers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Providers</em>' attribute list.
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_Providers()
	 * @model
	 * @generated
	 */
	EList<Object> getProviders();

} // Bundle
