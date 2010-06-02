/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.emailbundle;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.emailbundle.EmailbundleFactory
 * @model kind="package"
 * @generated
 */
public interface EmailbundlePackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the\naccompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this\ndistribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\n";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "emailbundle";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/emailbundle";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.emailbundle";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EmailbundlePackage eINSTANCE = org.unicase.model.emailbundle.impl.EmailbundlePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.emailbundle.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.emailbundle.impl.BundleImpl
	 * @see org.unicase.model.emailbundle.impl.EmailbundlePackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 0;

	/**
	 * The feature id for the '<em><b>Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BUNDLE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Comment Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__COMMENT_PROVIDER = 1;

	/**
	 * The feature id for the '<em><b>Subscriptions Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__SUBSCRIPTIONS_PROVIDER = 2;

	/**
	 * The feature id for the '<em><b>Task Change Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__TASK_CHANGE_PROVIDER = 3;

	/**
	 * The feature id for the '<em><b>Task Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__TASK_PROVIDER = 4;

	/**
	 * The feature id for the '<em><b>Task Review Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__TASK_REVIEW_PROVIDER = 5;

	/**
	 * The feature id for the '<em><b>Task Trace Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__TASK_TRACE_PROVIDER = 6;

	/**
	 * The feature id for the '<em><b>Immediately</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__IMMEDIATELY = 7;

	/**
	 * The feature id for the '<em><b>Aggregated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__AGGREGATED = 8;

	/**
	 * The feature id for the '<em><b>Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DAYS = 9;

	/**
	 * The feature id for the '<em><b>Days Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DAYS_COUNT = 10;

	/**
	 * The feature id for the '<em><b>Weekday</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__WEEKDAY = 11;

	/**
	 * The feature id for the '<em><b>Weekday Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__WEEKDAY_INDEX = 12;

	/**
	 * The feature id for the '<em><b>Providers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__PROVIDERS = 13;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = 14;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.emailbundle.Bundle <em>Bundle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see org.unicase.model.emailbundle.Bundle
	 * @generated
	 */
	EClass getBundle();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#getBundleName <em>Bundle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle Name</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getBundleName()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_BundleName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isCommentProvider <em>Comment Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment Provider</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isCommentProvider()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_CommentProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isSubscriptionsProvider <em>Subscriptions Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Subscriptions Provider</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isSubscriptionsProvider()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_SubscriptionsProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isTaskChangeProvider <em>Task Change Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Change Provider</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isTaskChangeProvider()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_TaskChangeProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isTaskProvider <em>Task Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Provider</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isTaskProvider()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_TaskProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isTaskReviewProvider <em>Task Review Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Review Provider</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isTaskReviewProvider()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_TaskReviewProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isTaskTraceProvider <em>Task Trace Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task Trace Provider</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isTaskTraceProvider()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_TaskTraceProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isDays <em>Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Days</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isDays()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Days();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#getDaysCount <em>Days Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Days Count</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getDaysCount()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_DaysCount();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isWeekday <em>Weekday</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weekday</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isWeekday()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Weekday();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#getWeekdayIndex <em>Weekday Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weekday Index</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getWeekdayIndex()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_WeekdayIndex();

	/**
	 * Returns the meta object for the attribute list '{@link org.unicase.model.emailbundle.Bundle#getProviders <em>Providers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Providers</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#getProviders()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Providers();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isImmediately <em>Immediately</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Immediately</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isImmediately()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Immediately();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.emailbundle.Bundle#isAggregated <em>Aggregated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aggregated</em>'.
	 * @see org.unicase.model.emailbundle.Bundle#isAggregated()
	 * @see #getBundle()
	 * @generated
	 */
	EAttribute getBundle_Aggregated();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EmailbundleFactory getEmailbundleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.emailbundle.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.emailbundle.impl.BundleImpl
		 * @see org.unicase.model.emailbundle.impl.EmailbundlePackageImpl#getBundle()
		 * @generated
		 */
		EClass BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '<em><b>Bundle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__BUNDLE_NAME = eINSTANCE.getBundle_BundleName();

		/**
		 * The meta object literal for the '<em><b>Comment Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__COMMENT_PROVIDER = eINSTANCE.getBundle_CommentProvider();

		/**
		 * The meta object literal for the '<em><b>Subscriptions Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__SUBSCRIPTIONS_PROVIDER = eINSTANCE.getBundle_SubscriptionsProvider();

		/**
		 * The meta object literal for the '<em><b>Task Change Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__TASK_CHANGE_PROVIDER = eINSTANCE.getBundle_TaskChangeProvider();

		/**
		 * The meta object literal for the '<em><b>Task Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__TASK_PROVIDER = eINSTANCE.getBundle_TaskProvider();

		/**
		 * The meta object literal for the '<em><b>Task Review Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__TASK_REVIEW_PROVIDER = eINSTANCE.getBundle_TaskReviewProvider();

		/**
		 * The meta object literal for the '<em><b>Task Trace Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__TASK_TRACE_PROVIDER = eINSTANCE.getBundle_TaskTraceProvider();

		/**
		 * The meta object literal for the '<em><b>Days</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__DAYS = eINSTANCE.getBundle_Days();

		/**
		 * The meta object literal for the '<em><b>Days Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__DAYS_COUNT = eINSTANCE.getBundle_DaysCount();

		/**
		 * The meta object literal for the '<em><b>Weekday</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__WEEKDAY = eINSTANCE.getBundle_Weekday();

		/**
		 * The meta object literal for the '<em><b>Weekday Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__WEEKDAY_INDEX = eINSTANCE.getBundle_WeekdayIndex();

		/**
		 * The meta object literal for the '<em><b>Providers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__PROVIDERS = eINSTANCE.getBundle_Providers();

		/**
		 * The meta object literal for the '<em><b>Immediately</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__IMMEDIATELY = eINSTANCE.getBundle_Immediately();

		/**
		 * The meta object literal for the '<em><b>Aggregated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNDLE__AGGREGATED = eINSTANCE.getBundle_Aggregated();

	}

} //EmailbundlePackage
