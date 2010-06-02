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
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isCommentProvider <em>Comment Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isSubscriptionsProvider <em>Subscriptions Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isTaskChangeProvider <em>Task Change Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isTaskProvider <em>Task Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isTaskReviewProvider <em>Task Review Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isTaskTraceProvider <em>Task Trace Provider</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isImmediately <em>Immediately</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isAggregated <em>Aggregated</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isDays <em>Days</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#getDaysCount <em>Days Count</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#isWeekday <em>Weekday</em>}</li>
 *   <li>{@link org.unicase.model.emailbundle.Bundle#getWeekdayIndex <em>Weekday Index</em>}</li>
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
	 * Returns the value of the '<em><b>Comment Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment Provider</em>' attribute.
	 * @see #setCommentProvider(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_CommentProvider()
	 * @model
	 * @generated
	 */
	boolean isCommentProvider();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isCommentProvider <em>Comment Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment Provider</em>' attribute.
	 * @see #isCommentProvider()
	 * @generated
	 */
	void setCommentProvider(boolean value);

	/**
	 * Returns the value of the '<em><b>Subscriptions Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscriptions Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscriptions Provider</em>' attribute.
	 * @see #setSubscriptionsProvider(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_SubscriptionsProvider()
	 * @model
	 * @generated
	 */
	boolean isSubscriptionsProvider();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isSubscriptionsProvider <em>Subscriptions Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscriptions Provider</em>' attribute.
	 * @see #isSubscriptionsProvider()
	 * @generated
	 */
	void setSubscriptionsProvider(boolean value);

	/**
	 * Returns the value of the '<em><b>Task Change Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Change Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Change Provider</em>' attribute.
	 * @see #setTaskChangeProvider(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_TaskChangeProvider()
	 * @model
	 * @generated
	 */
	boolean isTaskChangeProvider();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isTaskChangeProvider <em>Task Change Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Change Provider</em>' attribute.
	 * @see #isTaskChangeProvider()
	 * @generated
	 */
	void setTaskChangeProvider(boolean value);

	/**
	 * Returns the value of the '<em><b>Task Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Provider</em>' attribute.
	 * @see #setTaskProvider(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_TaskProvider()
	 * @model
	 * @generated
	 */
	boolean isTaskProvider();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isTaskProvider <em>Task Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Provider</em>' attribute.
	 * @see #isTaskProvider()
	 * @generated
	 */
	void setTaskProvider(boolean value);

	/**
	 * Returns the value of the '<em><b>Task Review Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Review Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Review Provider</em>' attribute.
	 * @see #setTaskReviewProvider(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_TaskReviewProvider()
	 * @model
	 * @generated
	 */
	boolean isTaskReviewProvider();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isTaskReviewProvider <em>Task Review Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Review Provider</em>' attribute.
	 * @see #isTaskReviewProvider()
	 * @generated
	 */
	void setTaskReviewProvider(boolean value);

	/**
	 * Returns the value of the '<em><b>Task Trace Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Trace Provider</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Trace Provider</em>' attribute.
	 * @see #setTaskTraceProvider(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_TaskTraceProvider()
	 * @model
	 * @generated
	 */
	boolean isTaskTraceProvider();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isTaskTraceProvider <em>Task Trace Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Trace Provider</em>' attribute.
	 * @see #isTaskTraceProvider()
	 * @generated
	 */
	void setTaskTraceProvider(boolean value);

	/**
	 * Returns the value of the '<em><b>Immediately</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immediately</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Immediately</em>' attribute.
	 * @see #setImmediately(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_Immediately()
	 * @model
	 * @generated
	 */
	boolean isImmediately();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isImmediately <em>Immediately</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immediately</em>' attribute.
	 * @see #isImmediately()
	 * @generated
	 */
	void setImmediately(boolean value);

	/**
	 * Returns the value of the '<em><b>Aggregated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated</em>' attribute.
	 * @see #setAggregated(boolean)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_Aggregated()
	 * @model
	 * @generated
	 */
	boolean isAggregated();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#isAggregated <em>Aggregated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregated</em>' attribute.
	 * @see #isAggregated()
	 * @generated
	 */
	void setAggregated(boolean value);

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
	 * Returns the value of the '<em><b>Weekday Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Weekday Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Weekday Index</em>' attribute.
	 * @see #setWeekdayIndex(int)
	 * @see org.unicase.model.emailbundle.EmailbundlePackage#getBundle_WeekdayIndex()
	 * @model
	 * @generated
	 */
	int getWeekdayIndex();

	/**
	 * Sets the value of the '{@link org.unicase.model.emailbundle.Bundle#getWeekdayIndex <em>Weekday Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Weekday Index</em>' attribute.
	 * @see #getWeekdayIndex()
	 * @generated
	 */
	void setWeekdayIndex(int value);

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
