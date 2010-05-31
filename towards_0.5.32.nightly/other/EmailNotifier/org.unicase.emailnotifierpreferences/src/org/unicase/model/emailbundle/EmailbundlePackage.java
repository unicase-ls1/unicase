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
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__IDENTIFIER = ModelPackage.UNICASE_MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__CREATOR = ModelPackage.UNICASE_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__CREATION_DATE = ModelPackage.UNICASE_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__NAME = ModelPackage.UNICASE_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DESCRIPTION = ModelPackage.UNICASE_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__ANNOTATIONS = ModelPackage.UNICASE_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__ATTACHMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.UNICASE_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__LEAF_SECTION = ModelPackage.UNICASE_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__STATE = ModelPackage.UNICASE_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__APPLIED_STEREOTYPE_INSTANCES = ModelPackage.UNICASE_MODEL_ELEMENT__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__COMMENTS = ModelPackage.UNICASE_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BUNDLE_NAME = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comment Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__COMMENT_PROVIDER = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subscriptions Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__SUBSCRIPTIONS_PROVIDER = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Task Change Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__TASK_CHANGE_PROVIDER = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Task Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__TASK_PROVIDER = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Task Review Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__TASK_REVIEW_PROVIDER = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Task Trace Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__TASK_TRACE_PROVIDER = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Immediately</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__IMMEDIATELY = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Aggregated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__AGGREGATED = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Days</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DAYS = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Days Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DAYS_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Weekday</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__WEEKDAY = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Weekday Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__WEEKDAY_INDEX = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = ModelPackage.UNICASE_MODEL_ELEMENT_FEATURE_COUNT + 13;


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
